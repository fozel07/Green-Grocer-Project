import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class admin_panel extends JFrame {

	private JPanel w_Pane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_panel frame = new admin_panel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public admin_panel() {
		setTitle("ADMIN PANEL");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		w_Pane = new JPanel();
		w_Pane.setBackground(Color.WHITE);
		w_Pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_Pane);
		w_Pane.setLayout(null);
		
		JButton btn_logout = new JButton("Log out");
		btn_logout.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			    	LoginGUI frame = new LoginGUI();
					frame.setVisible(true);		
					dispose();
				
							
					
			}
		});
		btn_logout.setBounds(114, 237, 89, 23);
		w_Pane.add(btn_logout);
		
		JButton btnNewButton_1 = new JButton("View Products");
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_view_products frame;
				try {
					frame = new admin_view_products();
					frame.setVisible(true);		
					dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
							
					
			}
		});
		btnNewButton_1.setBounds(24, 52, 263, 68);
		w_Pane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Track Budget");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				admin_track_budget frame;
				try {
					frame = new admin_track_budget();
					frame.setVisible(true);	
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
				
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		btnNewButton_1_1.setBounds(24, 144, 263, 68);
		w_Pane.add(btnNewButton_1_1);
		
		JTextPane txtpnAdminPanel = new JTextPane();
		txtpnAdminPanel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		txtpnAdminPanel.setText("Admin Panel");
		txtpnAdminPanel.setBounds(45, 0, 291, 53);
		w_Pane.add(txtpnAdminPanel);
	}
}

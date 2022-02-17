import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class admin_track_budget extends JFrame {

	private JPanel contentPane;
	private JTextField field_money;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_track_budget frame = new admin_track_budget();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public admin_track_budget() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 51, 464, 349);
		contentPane.add(panel);
		
		
		panel.setLayout(null);
		
		JScrollPane file_pane = new JScrollPane();
		file_pane.setBounds(10, 0, 337, 338);
		
		
		
		File file= new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\track_budget.txt"); 		
		Scanner track_budget_txt= new Scanner(file);
		String str=" ";
		
		double total_money=0;
		
		while(track_budget_txt.hasNextLine()) {		
			 String str1=track_budget_txt.nextLine();
			 str=str + "\n" +str1;
			 String str1_split[]=str1.split(" ");	
			 
			 if(str1_split[0].equals("Total")) {
				total_money=total_money+ Double.parseDouble(str1_split[3]);		
			}	
			 
			 
		}
		track_budget_txt.close();
		
		
		
		
		
		
		
		
		
		panel.add(file_pane);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		file_pane.setViewportView(textPane);
		
		textPane.setText(str);
		
		field_money = new JTextField();
		field_money.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		field_money.setBounds(348, 56, 106, 35);
		field_money.setText(String.valueOf(total_money));
		
		panel.add(field_money);
		field_money.setColumns(10);
		
		JTextPane txtpnTotalMoney = new JTextPane();
		txtpnTotalMoney.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		txtpnTotalMoney.setText("Total Earnings");
		txtpnTotalMoney.setBounds(348, 11, 116, 34);
		panel.add(txtpnTotalMoney);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				admin_panel frame= new admin_panel();
				frame.setVisible(true);
				dispose();
				
				
				
				
			}
		});
		
		
		btnNewButton.setBounds(348, 276, 106, 62);
		panel.add(btnNewButton);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Admin Track Budget Panel");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setBounds(97, 13, 315, 27);
		contentPane.add(lblNewLabel);
	}

	private String valueOf(int total_money) {
		// TODO Auto-generated method stub
		return null;
	}
}

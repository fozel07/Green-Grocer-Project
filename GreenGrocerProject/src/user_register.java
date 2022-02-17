import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.source.tree.WhileLoopTree;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class user_register extends JFrame {

	private JPanel contentPane;
	private JTextField field_register_userID;
	private JPasswordField field_register_user_password;
	private JPasswordField field_re_password;
	private JTextField field_adress;
	private JTextField field_Creditcart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_register frame = new user_register();
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
	public user_register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500,450 );
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		field_register_userID = new JTextField();
		field_register_userID.setBounds(200, 82, 211, 38);
		contentPane.add(field_register_userID);
		field_register_userID.setColumns(10);
		
		JTextPane txtpnUserId = new JTextPane();
		txtpnUserId.setEditable(false);
		txtpnUserId.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		txtpnUserId.setText("User ID     :");
		txtpnUserId.setBounds(10, 82, 177, 38);
		contentPane.add(txtpnUserId);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		txtpnPassword.setText("Password  :");
		txtpnPassword.setBounds(10, 131, 125, 38);
		contentPane.add(txtpnPassword);
		
		JButton btn_user_Register = new JButton("Register");
		btn_user_Register.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btn_user_Register.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
            	 
	
			
				
				if(field_register_userID.getText().length()==0 || field_register_user_password.getText().length()==0 || field_re_password.getText().length()==0  || field_adress.getText().length()==0 || field_Creditcart.getText().length()==0)  {
					
					JOptionPane.showMessageDialog(null,"tüm alanlarý doldurunuz");				
					
				}
				
				else if(!field_register_user_password.getText().equals(field_re_password.getText())) {
					
					JOptionPane.showMessageDialog(null,"two passwords must be the same\r\n"
							+ "");	
				}
				else {
				
				try(FileWriter fw = new FileWriter("C:\\\\Users\\\\fatbj\\\\Downloads\\\\user.txt",true);
					    BufferedWriter bw = new BufferedWriter(fw);
					    PrintWriter out = new PrintWriter(bw))				

					{
					
					File file= new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\user.txt");     
					Scanner user_txt= new Scanner(file);
					String user_username,user_password;
					boolean flag=true;
							
					
					while(user_txt.hasNextLine()) {
						String str=user_txt.nextLine();
						String split_str[]=str.split("\t");
						user_username=split_str[0];
						user_password=split_str[1];						
					    if(user_username.equals(field_register_userID.getText())) {
																
					    	JOptionPane.showMessageDialog(null,"this username is already taken");
					    	flag=false;
					    	break;
																							
					}
					
					}														
					   if(flag==true) {
					    out.println(field_register_userID.getText()+"	"+field_register_user_password.getText()+"	"+field_adress.getText()+"	"+field_Creditcart.getText());
					    out.close();
					    bw.close();
					    
					   }
					    
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				
				
												
				
				
			}}
		});
		
		
		btn_user_Register.setBounds(286, 326, 132, 74);
		contentPane.add(btn_user_Register);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginGUI frame= new LoginGUI();
				frame.setVisible(true);
				dispose();
				
				
				
				
			}
		});
		btnNewButton_1_1.setBounds(29, 326, 132, 74);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("E-VIT User Registration");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		lblNewLabel.setBounds(82, 11, 369, 60);
		contentPane.add(lblNewLabel);
		
		JTextPane txtpnReenterPassword = new JTextPane();
		txtpnReenterPassword.setEditable(false);
		txtpnReenterPassword.setText("Re-enter password:");
		txtpnReenterPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		txtpnReenterPassword.setBounds(10, 180, 183, 38);
		contentPane.add(txtpnReenterPassword);
		
		field_register_user_password = new JPasswordField();
		field_register_user_password.setBounds(200, 131, 208, 38);
		contentPane.add(field_register_user_password);
		
		field_re_password = new JPasswordField();
		field_re_password.setBounds(200, 180, 208, 38);
		contentPane.add(field_re_password);
		
		JTextPane txtpnAdress = new JTextPane();
		txtpnAdress.setText("Adress    :");
		txtpnAdress.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		txtpnAdress.setEditable(false);
		txtpnAdress.setBounds(10, 230, 110, 38);
		contentPane.add(txtpnAdress);
		
		field_adress = new JTextField();
		field_adress.setBounds(126, 229, 314, 38);
		contentPane.add(field_adress);
		field_adress.setColumns(10);
		
		JTextPane txtpnCreditCard = new JTextPane();
		txtpnCreditCard.setText("Credit Card    :");
		txtpnCreditCard.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		txtpnCreditCard.setEditable(false);
		txtpnCreditCard.setBounds(10, 280, 145, 38);
		contentPane.add(txtpnCreditCard);
		
		field_Creditcart = new JTextField();
		field_Creditcart.setColumns(10);
		field_Creditcart.setBounds(165, 279, 275, 38);
		contentPane.add(field_Creditcart);
		
		
		
		
		
		
		
		
	}
}

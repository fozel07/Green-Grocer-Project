import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class LoginGUI extends JFrame {

	private JPanel wrapper_pane;
	private JPasswordField field_password;
	private JPasswordField field_admin_username;
	private JPasswordField field_admin_password;
	private JTextField field_username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setForeground(Color.WHITE);
		setTitle("Green Grocery");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		wrapper_pane = new JPanel();
		wrapper_pane.setBackground(Color.WHITE);
		wrapper_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(wrapper_pane);
		wrapper_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("Strawberry.png")));
		lblNewLabel.setBounds(189, 0, 75, 92);
		wrapper_pane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to E-VIT Online Green Grocery");
		lblNewLabel_1.setBounds(55, 93, 374, 27);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		wrapper_pane.add(lblNewLabel_1);
		
		JTabbedPane wrapped_tabpane = new JTabbedPane(JTabbedPane.TOP);
		wrapped_tabpane.setBounds(10, 131, 474, 229);
		wrapper_pane.add(wrapped_tabpane);
		
		JPanel user_panel =  new JPanel();
		user_panel.setBackground(Color.WHITE);
		wrapped_tabpane.addTab("User Login", null, user_panel, null);
		user_panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username :");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 11, 127, 27);
		user_panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password  :");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(10, 60, 138, 27);
		user_panel.add(lblNewLabel_1_1_1);
		
		JButton btn_user_register = new JButton("Register");
		btn_user_register.setBackground(UIManager.getColor("Button.background"));
		btn_user_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_register frame= new user_register();
				frame.setVisible(true);	
				dispose();
				
				
				
				
				
			}				
		});
		btn_user_register.setBounds(26, 98, 147, 63);
		user_panel.add(btn_user_register);
		
		field_password = new JPasswordField();
		field_password.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		field_password.setBounds(130, 60, 300, 27);
		user_panel.add(field_password);
		
		JButton btn_user_login = new JButton("Login");
		btn_user_login.setBackground(UIManager.getColor("Button.background"));
		btn_user_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(field_username.getText().length()==0 || field_password.getText().length()==0) {		
					JOptionPane.showMessageDialog(null,"tüm alanlarý doldurunuz");			
				}
				else {
					File file= new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\user.txt");     													 								        							        	            	 
			        try {						       	
			        	BufferedWriter		out = new BufferedWriter(new FileWriter("C:\\\\Users\\\\fatbj\\\\Downloads\\\\user_temp.txt"));									        				        			        				        				        				        	
						Scanner user_txt= new Scanner(file);
						String user,password,adress,credit_card;				        
				        Boolean flag=true;
				        user_txt.nextLine();
						while(user_txt.hasNextLine()) {
							ArrayList<User> user_list= new ArrayList<User>();
							String str=user_txt.nextLine();
							String split_str[]=str.split("\t");
							user=split_str[0];
							password=split_str[1];
							adress=split_str[2];
							credit_card=split_str[3];
                            User user_user=new User(user, password,adress,credit_card);
                            user_list.add(user_user);
							if(user.equals(field_username.getText()) && password.equals(field_password.getText())) {							
								out.write(user+"	"+password+"	"+adress+"	"+credit_card);												
								out.close();																
								user_panel frame= new user_panel();
								frame.setVisible(true);	
								dispose();
								flag=false;
								break;
								
							}
																								
						}
						
						if(flag==true) {
							JOptionPane.showMessageDialog(null,"Hatalý þifre girdiniz");	
							
						}																								
					} catch (FileNotFoundException e1) {						
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			        			        			        
			        FileWriter fwOb;
					try {
					fwOb = new FileWriter("C:\\\\Users\\\\fatbj\\\\Downloads\\\\cart.txt", false);
					PrintWriter pwOb = new PrintWriter(fwOb, false);
			        pwOb.flush();
			        pwOb.close();
			        fwOb.close();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			        
					
					
					
					
				}
				
				
			
			}
				
				
				
			
		});
		
		
		btn_user_login.setBounds(264, 98, 147, 63);
		user_panel.add(btn_user_login);
		
		field_username = new JTextField();
		field_username.setBounds(130, 14, 300, 31);
		user_panel.add(field_username);
		field_username.setColumns(10);
		
		JPanel admin_panel = new JPanel();
		admin_panel.setBackground(Color.WHITE);
		wrapped_tabpane.addTab("Admin Login", null, admin_panel, null);
		admin_panel.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Username :");
		lblNewLabel_1_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(10, 11, 127, 27);
		admin_panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password  :");
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(10, 60, 138, 27);
		admin_panel.add(lblNewLabel_1_1_1_1);
		
		
		JButton btn_admin_login = new JButton("Login");
		btn_admin_login.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(field_admin_username.getText().length()==0 || field_admin_password.getText().length()==0) {		
					JOptionPane.showMessageDialog(null,"tüm alanlarý doldurunuz");			
				}
				else {
					File file= new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\admin.txt");         
			        try {
			        	ArrayList<User> admin_list= new ArrayList<User>();
						Scanner admin_txt= new Scanner(file);
						String admin_user;
				        String admin_password;  
				        Boolean flag=true;
						admin_txt.nextLine();
						while(admin_txt.hasNextLine()) {
							String str=admin_txt.nextLine();
							String split_str[]=str.split("\t");
							admin_user=split_str[0];
							admin_password=split_str[1];
						
																	
							if(admin_user.equals(field_admin_username.getText()) && admin_password.equals(field_admin_password.getText())) {
								admin_panel frame= new admin_panel();
								frame.setVisible(true);	
								dispose();
								flag=false;
								break;
								
							}
																								
						}
						if(flag==true) {
							
							JOptionPane.showMessageDialog(null,"Hatalý þifre girdiniz");	
							
						}
						
						
						
						
					} catch (FileNotFoundException e1) {						
						e1.printStackTrace();
					}

					
					
					
					
				}
				
				
			
			}
		});
		btn_admin_login.setBackground(UIManager.getColor("Button.background"));
		btn_admin_login.setBounds(31, 99, 383, 62);
		admin_panel.add(btn_admin_login);
		
		field_admin_username = new JPasswordField();
		field_admin_username.setBounds(133, 11, 300, 27);
		admin_panel.add(field_admin_username);
		
		field_admin_password = new JPasswordField();
		field_admin_password.setBounds(133, 65, 300, 27);
		admin_panel.add(field_admin_password);
	}
}

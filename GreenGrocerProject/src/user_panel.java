import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Spliterator;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTabbedPane;

public class user_panel extends JFrame {

	private JPanel contentPane;
	private JTextField field_amount;
	private JTextField field_productName;
	private JTable table_shopping_list;
	private DefaultTableModel productModel=null;
	private Object[] productData=null;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_panel frame = new user_panel();
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
	public user_panel() throws FileNotFoundException {
		productModel = new DefaultTableModel();
		Object[] colProductName=new Object[4];
		colProductName[0]="Product Name";
		colProductName[1]="Product Fee";
		colProductName[2]="Product_Quantity";
		colProductName[3]="Product ID";
		productModel.setColumnIdentifiers(colProductName);
		productData=new Object[4];
		File file= new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\products.txt");
		Scanner products_txt= new Scanner(file);				
		products_txt.nextLine();
		
		while(products_txt.hasNextLine()) {
			
			String str=products_txt.nextLine();
			String split_str[]=str.split("\t");
			
			productData[0]=split_str[0];
			productData[1]=split_str[1]+" tl";
			productData[2]=split_str[2]+" kg";
			productData[3]=split_str[3];			
		    productModel.addRow(productData);
			
			
		
		}
		products_txt.close();
		
		
		
		
		
		
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-VIT Shopping List");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		lblNewLabel.setBounds(117, 8, 309, 41);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 60, 464, 340);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 329, 318);
		panel.add(scrollPane);
		
		table_shopping_list = new JTable(productModel);
		table_shopping_list.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		scrollPane.setViewportView(table_shopping_list);
table_shopping_list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				field_productName.setText(table_shopping_list.getValueAt(table_shopping_list.getSelectedRow(), 0).toString());
				
				
			}
		});
		
		field_amount = new JTextField();
		field_amount.setBounds(351, 132, 93, 33);
		panel.add(field_amount);
		field_amount.setColumns(10);
		
		
		
		
		JTextPane txtpnAdd = new JTextPane();
		txtpnAdd.setBounds(351, 88, 93, 33);
		txtpnAdd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		txtpnAdd.setText("Amount");
		panel.add(txtpnAdd);
		
		JButton btn_add_basket = new JButton("add cart");
		btn_add_basket.setBounds(349, 170, 109, 57);
		btn_add_basket.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btn_add_basket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                           if(field_productName.getText().length()==0 || field_amount.getText().length()==0 ) {
					
					          JOptionPane.showMessageDialog(null,"tüm alanlarý doldurunuz");	
					
					
			      		
				}
                           
                           else {                               		 
				
				try(FileWriter fw = new FileWriter("C:\\\\Users\\\\fatbj\\\\Downloads\\\\cart.txt",true);
					    BufferedWriter bw = new BufferedWriter(fw);
					    PrintWriter out = new PrintWriter(bw))		
				
					{
					
					try{
						String split_str[]=table_shopping_list.getValueAt(table_shopping_list.getSelectedRow(), 2).toString().split(" ");
						
						int product_value=Integer.parseInt(split_str[0]);											
						if(Integer.parseInt(field_amount.getText())>product_value) {
									
					            JOptionPane.showMessageDialog(null,"please enter a valid number");	
	            
				        }
						
						
						else {
							
							
                           
					    out.println(field_productName.getText()+"	"+table_shopping_list.getValueAt(table_shopping_list.getSelectedRow(), 1).toString().split(" ")[0]+"	"+field_amount.getText()+"	"+table_shopping_list.getValueAt(table_shopping_list.getSelectedRow(), 3).toString().split(" ")[0]);
					    out.close();
					    bw.close();
				          }
						
						
						
					}catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,"please enter a valid number");	
					}
			
				
				
				
				
				
				
					    
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				
				
				
				
				
				
				
				
				
                           }
				
			}			
		});
		panel.add(btn_add_basket);
		
		JTextPane txtpnProductId = new JTextPane();
		txtpnProductId.setEditable(false);
		txtpnProductId.setBounds(338, 0, 120, 33);
		txtpnProductId.setText("Product name");
		txtpnProductId.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		panel.add(txtpnProductId);
		
		field_productName = new JTextField();
		field_productName.setBounds(349, 33, 93, 33);
		field_productName.setBackground(Color.WHITE);
		field_productName.setEditable(false);
		field_productName.setColumns(10);
		panel.add(field_productName);
		
		JButton btn_show_basket = new JButton("show cart");
		btn_show_basket.setBounds(349, 238, 109, 57);
		btn_show_basket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cart frame;
				try {
					frame = new cart();
					frame.setVisible(true);	
					dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btn_show_basket.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		panel.add(btn_show_basket);
		
		JButton btn_back = new JButton("back");
		btn_back.setBounds(355, 306, 89, 23);
		btn_back.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginGUI frame= new LoginGUI();				
				frame.setVisible(true);	
				dispose();
				
									
				
			}
		});
		panel.add(btn_back);
	}
}

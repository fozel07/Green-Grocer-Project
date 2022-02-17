import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Font;
import java.util.Scanner;
import java.io.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JComboBox;

public class admin_view_products extends JFrame {

	private JPanel contentPane;
	private JTextField field_product;
	private JTextField field_product_quantity;
	private JTextField field_product_number;
	private JTable table_products;
	private DefaultTableModel productModel=null;
	private Object[] productData=null;
	private JTextField field_product_ID;
	private JTextField field_product_fee;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_view_products frame = new admin_view_products();
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
	public admin_view_products() throws FileNotFoundException {
		
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
		setBounds(100, 100, 550, 518);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Panel");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setBounds(366, 8, 158, 32);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		tabbedPane.setBounds(10, 11, 525, 457);
		contentPane.add(tabbedPane);
		
		JPanel w_admin = new JPanel();
		w_admin.setBackground(Color.WHITE);
		tabbedPane.addTab("Product Management", null, w_admin, null);
		w_admin.setLayout(null);
		
		JTextPane txtpnProduct = new JTextPane();
		txtpnProduct.setEditable(false);
		txtpnProduct.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		txtpnProduct.setText("Product Name");
		txtpnProduct.setBounds(373, 0, 117, 28);
		w_admin.add(txtpnProduct);
		
		field_product = new JTextField();
		field_product.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		field_product.setBounds(373, 31, 127, 28);
		w_admin.add(field_product);
		field_product.setColumns(10);
		
		JTextPane txtpnProductQuantity = new JTextPane();
		txtpnProductQuantity.setEditable(false);
		txtpnProductQuantity.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		txtpnProductQuantity.setText("Product quantity");
		txtpnProductQuantity.setBounds(373, 125, 134, 28);
		w_admin.add(txtpnProductQuantity);
		
		field_product_quantity = new JTextField();
		field_product_quantity.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		field_product_quantity.setBounds(373, 153, 127, 28);
		w_admin.add(field_product_quantity);
		field_product_quantity.setColumns(10);
		
		JTextPane txtpnProductCode = new JTextPane();
		txtpnProductCode.setEditable(false);
		txtpnProductCode.setText("Product ID");
		txtpnProductCode.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		txtpnProductCode.setBounds(373, 179, 100, 26);
		w_admin.add(txtpnProductCode);
		
		field_product_number = new JTextField();
		field_product_number.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		field_product_number.setColumns(10);
		field_product_number.setBounds(373, 205, 127, 28);
		w_admin.add(field_product_number);
		
		JButton btnNewButton = new JButton("add product");
		btnNewButton.addActionListener(new ActionListener() {
										
			public void actionPerformed(ActionEvent e) {
				
											
				if(field_product.getText().length()==0 || field_product_quantity.getText().length()==0 || field_product_number.getText().length()==0 || field_product_fee.getText().length()==0 ) {
					
					JOptionPane.showMessageDialog(null,"tüm alanlarý doldurunuz");	
										
				}
				
				else {																						
				File inputFile = new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\products.txt");
		        File tempFile = new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\b.txt");

		        BufferedReader reader;
		        BufferedWriter writer ;
				try {
					reader = new BufferedReader(new FileReader(inputFile));
					writer=new BufferedWriter(new FileWriter(tempFile));
					String lineToRemove=field_product_number.getText();
			        String currentLine;

			        while((currentLine = reader.readLine()) != null) {
			        	
			        	String split_str[]=currentLine.split("\t");
			        	
			           
			            if(split_str[3].equals(lineToRemove)) 
			              continue;
			            
			            writer.write(currentLine + System.getProperty("line.separator"));
			        }
			        
			        try {
						
			        	
			        Double myNumber1=Double.parseDouble(field_product_quantity.getText());			        
			        Double myNumber2=Double.parseDouble(field_product_fee.getText());			        
			         
			        writer.write(field_product.getText()+"	"+field_product_fee.getText()+"	"+field_product_quantity.getText()+"	"+field_product_number.getText());
			        
			        
			        } catch (NumberFormatException ex) {
			        	JOptionPane.showMessageDialog(null,"please enter a valid number");	
					}
			        
			        reader.close();
			        writer.close();
			       
			        
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
				
				inputFile.delete();

				boolean successful = tempFile.renameTo(inputFile);
		        System.out.println(successful);
				
				
				
				
				
				
				
				
				
				try {
					
					uptadeProduct();
					
				} catch (FileNotFoundException e1) {
					
					
					e1.printStackTrace();
				}
				
				

				
				
				
				
			}}

			private Double valueOF(String text) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnNewButton.setBounds(373, 231, 127, 34);
		w_admin.add(btnNewButton);
		
		JScrollPane w_scroll_product = new JScrollPane();
		w_scroll_product.setBounds(0, 0, 374, 412);
		w_admin.add(w_scroll_product);
		
		table_products = new JTable(productModel);
		table_products.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		w_scroll_product.setViewportView(table_products);
		
		JTextPane txtpnProductCode_1 = new JTextPane();
		txtpnProductCode_1.setEditable(false);
		txtpnProductCode_1.setText("Product ID");
		txtpnProductCode_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		txtpnProductCode_1.setBounds(373, 276, 100, 26);
		w_admin.add(txtpnProductCode_1);
		
		JButton btnDeleteProduct = new JButton("delete product");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File inputFile = new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\products.txt");
		        File tempFile = new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\b.txt");

		        BufferedReader reader;
		        BufferedWriter writer ;
				try {
					reader = new BufferedReader(new FileReader(inputFile));
					writer=new BufferedWriter(new FileWriter(tempFile));
					String lineToRemove=field_product_ID.getText();
			        String currentLine;

			        while((currentLine = reader.readLine()) != null) {
			        	
			        	String split_str[]=currentLine.split("\t");
			        	
			           
			            if(split_str[3].equals(lineToRemove)) 
			              continue;
			            
			            writer.write(currentLine + System.getProperty("line.separator"));
			        }
			        		        
			        reader.close();
			        writer.close();		
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
				inputFile.delete();

				boolean successful = tempFile.renameTo(inputFile);
		        System.out.println(successful);
		       
		        try {
					uptadeProduct();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		        
				
			
				
				
				
				
			}
		});
		btnDeleteProduct.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnDeleteProduct.setBounds(373, 328, 127, 34);
		w_admin.add(btnDeleteProduct);
		
		field_product_ID = new JTextField();
		field_product_ID.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		field_product_ID.setColumns(10);
		field_product_ID.setBounds(373, 302, 127, 28);
		w_admin.add(field_product_ID);
		
		field_product_fee = new JTextField();
		field_product_fee.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		field_product_fee.setColumns(10);
		field_product_fee.setBounds(373, 85, 127, 28);
		w_admin.add(field_product_fee);
		
		JTextPane txtpnProductFee = new JTextPane();
		txtpnProductFee.setEditable(false);
		txtpnProductFee.setText("Product fee");
		txtpnProductFee.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		txtpnProductFee.setBounds(373, 59, 100, 26);
		w_admin.add(txtpnProductFee);
		
		JButton btn_back = new JButton("Back");
		btn_back.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				admin_panel frame= new admin_panel();
				frame.setVisible(true);
				dispose();
				
				
				
				
			}
		});
		
		
		btn_back.setBounds(384, 373, 100, 39);
		w_admin.add(btn_back);
		
	
	}
	public void uptadeProduct() throws FileNotFoundException {
		DefaultTableModel clearModel=(DefaultTableModel) table_products.getModel();
		clearModel.setRowCount(0);
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
		
		
		
		
	}
	}
	
	
	
	

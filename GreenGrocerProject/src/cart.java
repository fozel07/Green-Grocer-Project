import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class cart extends JFrame {

	private JPanel contentPane;
	private JTextField field_shopingcart_name;
	private JTable shopingcart_table;
	private DefaultTableModel productModel=null;
	private Object[] productData=null;
	private JTextField field_totalprice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cart frame = new cart();
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
	public cart() throws FileNotFoundException {
		
		productModel = new DefaultTableModel();
		Object[] colProductName=new Object[3];
		colProductName[0]="Product Name";
		colProductName[1]="Product Fee";
		colProductName[2]="Product Quantity";	
		double total_price=0;
	
		String money[],weight[];
		productModel.setColumnIdentifiers(colProductName);
		productData=new Object[3];
		File file= new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\cart.txt");
		Scanner products_txt= new Scanner(file);								
		while(products_txt.hasNextLine()) {
			
			String str=products_txt.nextLine();
			String split_str[]=str.split("\t");
			
			productData[0]=split_str[0];
			productData[1]=split_str[1]+" tl";
			productData[2]=split_str[2]+" kg";			
			total_price=total_price+ (Double.parseDouble(split_str[1])*Double.parseDouble(split_str[2]));
		    productModel.addRow(productData);
								
		}
		
		products_txt.close();
		
		
		
		
		
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 52, 464, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 310, 326);
		panel.add(scrollPane);
		
		shopingcart_table = new JTable(productModel);
		scrollPane.setViewportView(shopingcart_table);
		
/*shopingcart_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				field_shopingcart_name.setText(shopingcart_table.getValueAt(shopingcart_table.getSelectedRow(), 0).toString());
				
				
			}
		});*/
		
		field_shopingcart_name = new JTextField();
		field_shopingcart_name.setBackground(Color.WHITE);
		field_shopingcart_name.setBounds(330, 29, 118, 30);
		panel.add(field_shopingcart_name);
		field_shopingcart_name.setColumns(10);
		
		JTextPane txtpnName = new JTextPane();
		txtpnName.setEditable(false);
		txtpnName.setForeground(Color.BLACK);
		txtpnName.setToolTipText("");
		txtpnName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		txtpnName.setText("Name");
		txtpnName.setBounds(330, 0, 86, 30);
		panel.add(txtpnName);
		
		JButton btn_delete_item = new JButton("delete item");
		btn_delete_item.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btn_delete_item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File inputFile = new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\cart.txt");
		        File tempFile = new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\c.txt");

		        BufferedReader reader;
		        BufferedWriter writer ;
				try {
					reader = new BufferedReader(new FileReader(inputFile));
					writer=new BufferedWriter(new FileWriter(tempFile));
					String lineToRemove=field_shopingcart_name.getText();
			        String currentLine;

			        while((currentLine = reader.readLine()) != null) {
			        	
			        	String split_str[]=currentLine.split("\t");
			        	
			           
			            if(split_str[0].equals(lineToRemove)) continue;
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
		        
		        try {
					uptadeProduct();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        		        
		       
	
			}
		});
		
		btn_delete_item.setBounds(330, 70, 127, 54);
		panel.add(btn_delete_item);
		
		JButton btn_proceed = new JButton("proceed");
		btn_proceed.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		
		btn_proceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file= new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\cart.txt");
				File file1= new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\user_temp.txt");
				Scanner cart_txt;
				try {
					cart_txt = new Scanner(file);	
					Scanner user_temp_txt=new Scanner(file1);
					
					
					Queue queue_user = new LinkedList();
					Queue temp_queue = new LinkedList();
					Queue queue = new LinkedList();
					Queue temp = new LinkedList();
					
					while(user_temp_txt.hasNextLine()) {
						
						String str=user_temp_txt.nextLine();
						String split_str[]=str.split("\t");
						
					
						 queue_user.add(split_str[0]);
						 queue_user.add(split_str[1]);
						 queue_user.add(split_str[2]);
						 queue_user.add(split_str[3]);
													
						
						
						
																								
					}
				      if(field_totalprice.getText().equals("0")) {
				    	  
				    	  
				    	  JOptionPane.showMessageDialog(null,"Your cart is empty please add something to cart");
				    	  
				    	  
				      }
					
				      else {
					int input =	JOptionPane.showConfirmDialog(null, "Dear "+queue_user.peek()+"  Are u sure?","Information Message", JOptionPane.YES_NO_OPTION);
					  if(input==1) {
						
						
						
						JOptionPane.showMessageDialog(null,"You can contiue shopping");
						
						
					}
					
					
					
					
					 else if (input==0) {
						
					
						
						String user=(String)queue_user.remove();
						String password=(String)queue_user.remove();
						String adress=(String)queue_user.remove();
						String credit_card=(String)queue_user.remove();
						
						
						
						JOptionPane.showMessageDialog(null,"Your adress is :" +adress+"\n Sent to be shipped to your adress ");
							
						
						
						
							
						
											
					
					
					
					while(cart_txt.hasNextLine()) {
						
						String str=cart_txt.nextLine();
						String split_str[]=str.split("\t");
						
						
						queue.add(split_str[0]);
						queue.add(split_str[1]);
						queue.add(split_str[2]);
						queue.add(split_str[3]);
											
																																																					
				}
					
					
					
					
					
					
					try(FileWriter fw = new FileWriter("C:\\\\Users\\\\fatbj\\\\Downloads\\\\track_budget.txt",true);
						    BufferedWriter bw = new BufferedWriter(fw);
						    PrintWriter out = new PrintWriter(bw))		
					

						{
						
						
							
								 out.println("User : "+user);
								 out.println("Adress : "+adress);
								 
						
						   
								 while(queue.size()!=0) {
	                          						  
						    out.println("Purchased:"+ queue.remove() +"  " +queue.remove()+" tl"+"  "+queue.remove()+" kg"+"  "+queue.remove());
						    
					          																		
							}
								 
						    out.println("Total Price : "+field_totalprice.getText());
							out.close();
						    bw.close();																						
						    
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					
					
					
					
																																			
					
						
			}}
					
					
					
				
					
					
					
					user_temp_txt.close();
					cart_txt.close();
					
					
					
					
					
					
					
					
														
					
					
			
					
				
					
					
					
					
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			
				
				
			}
		});
		
		
		btn_proceed.setBounds(330, 218, 127, 54);
		panel.add(btn_proceed);
		
		JButton btn_back = new JButton("back");
		btn_back.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				user_panel frame;
				try {
					
					frame = new user_panel();
					frame.setVisible(true);
					dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		
		
		
		
		
		
		
		
		btn_back.setBounds(330, 283, 127, 54);
		panel.add(btn_back);
		
		field_totalprice = new JTextField();
		field_totalprice.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		field_totalprice.setBackground(Color.WHITE);
		field_totalprice.setEditable(false);
		field_totalprice.setColumns(10);
		field_totalprice.setBounds(330, 177, 118, 30);
		field_totalprice.setText(String.valueOf(total_price));
		panel.add(field_totalprice);
		
		JTextPane txtpnTotalPrice = new JTextPane();
		txtpnTotalPrice.setEditable(false);
		txtpnTotalPrice.setToolTipText("");
		txtpnTotalPrice.setText("Total Price");
		txtpnTotalPrice.setForeground(Color.BLACK);
		txtpnTotalPrice.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		txtpnTotalPrice.setBounds(330, 136, 100, 30);
		panel.add(txtpnTotalPrice);
		
		JLabel lblNewLabel = new JLabel("My shoping cart");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setBounds(22, 11, 214, 30);
		contentPane.add(lblNewLabel);
	}
	
	
	public void uptadeProduct() throws FileNotFoundException {
		DefaultTableModel clearModel=(DefaultTableModel) shopingcart_table.getModel();
		clearModel.setRowCount(0);
		double total_price=0;	
	     String money[],weight[];
		File file= new File("C:\\\\Users\\\\fatbj\\\\Downloads\\\\cart.txt");
		Scanner products_txt= new Scanner(file);
			
				
		while(products_txt.hasNextLine()) {
			
			String str=products_txt.nextLine();
			String split_str[]=str.split("\t");
			
			productData[0]=split_str[0];
			productData[1]=split_str[1];
			productData[2]=split_str[2];		
			productData[1]=split_str[1]+" tl";
			productData[2]=split_str[2]+" kg";			
			total_price=total_price+ (Double.parseDouble(split_str[1])*Double.parseDouble(split_str[2]));
		    productModel.addRow(productData);
			
			
		
		}
		
		field_totalprice.setText(String.valueOf(total_price));
		products_txt.close();
		
		
		
		
	}
	
	
	
	
	
	

}

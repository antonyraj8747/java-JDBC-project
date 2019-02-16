import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AddCustomerDetails extends JFrame 
{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					AddCustomerDetails frame = new AddCustomerDetails();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCustomerDetails() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddCustomer = new JLabel("ADD CUSTOMER");
		lblAddCustomer.setForeground(Color.WHITE);
		lblAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddCustomer.setBounds(145, 25, 148, 28);
		contentPane.add(lblAddCustomer);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCustomerId.setBounds(73, 91, 104, 25);
		contentPane.add(lblCustomerId);
		
		textField = new JTextField();
		textField.setBounds(210, 94, 150, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setForeground(Color.WHITE);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCustomerName.setBounds(73, 140, 104, 25);
		contentPane.add(lblCustomerName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 143, 150, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setBounds(73, 198, 104, 25);
		contentPane.add(lblAddress);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(210, 194, 150, 60);
		contentPane.add(textArea);
		
		JLabel lblPhoneNo = new JLabel("Phone no");
		lblPhoneNo.setForeground(Color.WHITE);
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhoneNo.setBounds(73, 287, 104, 25);
		contentPane.add(lblPhoneNo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(210, 285, 150, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Class.forName("org.h2.Driver");
					Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					
					String id=textField.getText();
					String name=textField_1.getText();
					String address=textArea.getText();
					String phone=textField_2.getText();
					
					String query="insert into CUSTOMERDETAILS  values('"+id+"','"+name+"','"+address+"','"+phone+"')";
					
					Statement stm=con.createStatement();
					stm.executeUpdate(query);
					
					JOptionPane.showMessageDialog(btnSubmit, "Add Successfull...!");
					
					
				}
				catch (Exception x)
				{
					System.out.println("Invalid" +x);
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(170, 350, 120, 30);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText("");
				textField_1.setText("");
				textArea.setText("");
				textField_2.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(51, 411, 80, 25);
		contentPane.add(btnNewButton);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBackground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHome.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				HomePage home=new HomePage();
				home.setVisible(true);
			}
		});
		btnHome.setBounds(312, 411, 80, 25);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				RegisterPage back=new RegisterPage();
				back.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(185, 411, 80, 25);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\aaa.jpg"));
		label.setBounds(0, 0, 434, 461);
		contentPane.add(label);
		
	}
}

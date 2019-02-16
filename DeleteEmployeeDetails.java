import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class DeleteEmployeeDetails extends JFrame 
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
					DeleteEmployeeDetails frame = new DeleteEmployeeDetails();
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
	public DeleteEmployeeDetails() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateCustomerDetails = new JLabel("DELETE EMPLOYEE DETAILS");
		lblUpdateCustomerDetails.setForeground(Color.WHITE);
		lblUpdateCustomerDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateCustomerDetails.setBounds(99, 25, 256, 28);
		contentPane.add(lblUpdateCustomerDetails);
		
		JLabel lblCustomerId = new JLabel("Employee ID");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCustomerId.setBounds(73, 91, 104, 25);
		contentPane.add(lblCustomerId);
		
		textField = new JTextField();
		textField.setBounds(210, 94, 150, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Employee Name");
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
		textField_2.setBounds(210, 290, 150, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.WHITE);
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String id=textField.getText();

					String qurey="delete from EMPLOYEEDETAILS  where id='"+id+"'";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					stm.executeUpdate(qurey);
					
					JOptionPane.showMessageDialog(btnDelete,"Deleted..");
				}
				catch (Exception d)
				{
					System.out.println(d);
				}

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(163, 377, 120, 30);
		contentPane.add(btnDelete);
		
		JButton btnView = new JButton("View");
		btnView.setBackground(Color.WHITE);
		btnView.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String id=textField.getText();
					
					String str1="select * from EMPLOYEEDETAILS  where id='"+id+"'";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					ResultSet rs=stm.executeQuery(str1);
					rs.next();
					
					String en=rs.getString(2);
					String ea=rs.getString(3);
					String ep=rs.getString(4);
					
					textField_1.setText(en);
					textArea.setText(ea);
					textField_2.setText(ep);
					
					JOptionPane.showMessageDialog(btnView, "Search Completed..");			
					
				}
				catch(Exception t)
				{
					System.out.println(t);
				}
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnView.setBounds(41, 363, 80, 25);
		contentPane.add(btnView);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				textField_1.setText("");
				textArea.setText("");
				textField_2.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReset.setBounds(41, 399, 80, 25);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AdminHomePage home=new AdminHomePage();
				home.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(319, 363, 80, 25);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				HomePage home=new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHome.setBounds(319, 399, 80, 25);
		contentPane.add(btnHome);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\aaa.jpg"));
		label.setBounds(0, 0, 434, 461);
		contentPane.add(label);
	
	}

}

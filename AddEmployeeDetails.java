import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class AddEmployeeDetails extends JFrame 
{

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField;

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
					AddEmployeeDetails frame = new AddEmployeeDetails();
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
	public AddEmployeeDetails() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddCustomer = new JLabel("ADD EMPLOYEE DETAILS");
		lblAddCustomer.setForeground(Color.WHITE);
		lblAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddCustomer.setBounds(110, 25, 232, 28);
		contentPane.add(lblAddCustomer);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setForeground(Color.WHITE);
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeId.setBounds(73, 91, 104, 25);
		contentPane.add(lblEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(210, 94, 150, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setForeground(Color.WHITE);
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeName.setBounds(73, 140, 104, 25);
		contentPane.add(lblEmployeeName);
		
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
					
					String query="insert into EMPLOYEEDETAILS  values('"+id+"','"+name+"','"+address+"','"+phone+"')";
					
					Statement stm=con.createStatement();
					stm.executeUpdate(query);
					
					JOptionPane.showMessageDialog(btnSubmit, "Add Successfull...");
					
				}
				catch (Exception x)
				{
					System.out.println("Invalid" +x);
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(170, 356, 120, 30);
		contentPane.add(btnSubmit);
		
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
		btnReset.setBounds(49, 410, 80, 25);
		contentPane.add(btnReset);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBackground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHome.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				HomePage home=new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(316, 410, 80, 25);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				RegisterPage back=new RegisterPage();
				back.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(186, 410, 80, 25);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\aaa.jpg"));
		label.setBounds(0, 0, 434, 461);
		contentPane.add(label);
				
	}

}

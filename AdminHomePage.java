import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class AdminHomePage extends JFrame 
{
	private JPanel contentPane;

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
					AdminHomePage frame = new AdminHomePage();
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
	public AdminHomePage() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeHomePage = new JLabel("ADMIN HOME PAGE");
		lblEmployeeHomePage.setForeground(Color.WHITE);
		lblEmployeeHomePage.setBounds(135, 40, 185, 28);
		lblEmployeeHomePage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEmployeeHomePage);
		
		JButton btnViewCustomerTable = new JButton("View Employee Table");
		btnViewCustomerTable.setBackground(Color.WHITE);
		btnViewCustomerTable.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				EmployeeDetailsTable table=new EmployeeDetailsTable();
				table.setVisible(true);
				dispose();
			}
		});
		btnViewCustomerTable.setBounds(125, 110, 200, 30);
		btnViewCustomerTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnViewCustomerTable);
		
		JButton btnSearchCustomerDetails = new JButton("Search Employee Details");
		btnSearchCustomerDetails.setBackground(Color.WHITE);
		btnSearchCustomerDetails.setBounds(125, 180, 200, 30);
		btnSearchCustomerDetails.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				SearchEmployeeDetails search=new SearchEmployeeDetails();
				search.setVisible(true);
				dispose();
			}
		});
		btnSearchCustomerDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnSearchCustomerDetails);
		
		JButton btnUpdateCustomerDetails = new JButton("Update Employee Details");
		btnUpdateCustomerDetails.setBackground(Color.WHITE);
		btnUpdateCustomerDetails.setBounds(125, 250, 200, 30);
		btnUpdateCustomerDetails.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				UpdateEmployeeDetails update=new UpdateEmployeeDetails();
				update.setVisible(true);
				dispose();
			}
		});
		btnUpdateCustomerDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnUpdateCustomerDetails);
		
		JButton btnDeleteDetails = new JButton("Delete Employee Details");
		btnDeleteDetails.setBackground(Color.WHITE);
		btnDeleteDetails.setBounds(125, 320, 200, 30);
		btnDeleteDetails.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				DeleteEmployeeDetails delete=new DeleteEmployeeDetails();
				delete.setVisible(true);
				dispose();
			}
		});
		btnDeleteDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnDeleteDetails);
		
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
		btnHome.setBounds(85, 402, 80, 25);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AdminLoginPage login=new AdminLoginPage();
				login.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(275, 402, 80, 25);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\aaa.jpg"));
		label.setBounds(0, 0, 434, 461);
		contentPane.add(label);
	}

}

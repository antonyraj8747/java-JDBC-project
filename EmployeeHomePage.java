import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class EmployeeHomePage extends JFrame
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
					EmployeeHomePage frame = new EmployeeHomePage();
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
	public EmployeeHomePage() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeHomePage = new JLabel("EMPLOYEE HOME PAGE");
		lblEmployeeHomePage.setForeground(Color.WHITE);
		lblEmployeeHomePage.setBounds(120, 40, 215, 28);
		lblEmployeeHomePage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEmployeeHomePage);
		
		JButton btnViewCustomerTable = new JButton("View Customer Table");
		btnViewCustomerTable.setBackground(Color.WHITE);
		btnViewCustomerTable.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				CustomerDetailsTable table=new CustomerDetailsTable();
				table.setVisible(true);
			}
		});
		btnViewCustomerTable.setBounds(125, 110, 200, 30);
		btnViewCustomerTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnViewCustomerTable);
		
		JButton btnSearchCustomerDetails = new JButton("Search Customer Details");
		btnSearchCustomerDetails.setBackground(Color.WHITE);
		btnSearchCustomerDetails.setBounds(125, 180, 200, 30);
		btnSearchCustomerDetails.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				SearchCustomerDetails search=new SearchCustomerDetails();
				search.setVisible(true);
			}
		});
		btnSearchCustomerDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnSearchCustomerDetails);
		
		JButton btnUpdateCustomerDetails = new JButton("Update Customer Details");
		btnUpdateCustomerDetails.setBackground(Color.WHITE);
		btnUpdateCustomerDetails.setBounds(125, 250, 200, 30);
		btnUpdateCustomerDetails.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				UpdateCustomerDetails update=new UpdateCustomerDetails();
				update.setVisible(true);
			}
		});
		btnUpdateCustomerDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnUpdateCustomerDetails);
		
		JButton btnDeleteCustomerDetails = new JButton("Delete Customer Details");
		btnDeleteCustomerDetails.setBackground(Color.WHITE);
		btnDeleteCustomerDetails.setBounds(125, 320, 200, 30);
		btnDeleteCustomerDetails.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				DeleteCustomerDetails delete=new DeleteCustomerDetails();
				delete.setVisible(true);
			}
		});
		btnDeleteCustomerDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnDeleteCustomerDetails);
		
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
		btnHome.setBounds(89, 403, 80, 25);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				EmployeeLoginPage login=new EmployeeLoginPage();
				login.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(276, 403, 80, 25);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\aaa.jpg"));
		label.setBounds(0, 0, 434, 461);
		contentPane.add(label);
		
	}

}

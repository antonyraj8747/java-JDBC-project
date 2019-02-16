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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.ImageIcon;

public class CustomerDetailsTable extends JFrame 
{
	private JPanel contentPane;
	private JTextField textField;
	JPanel panel=new JPanel();
	JTable table=new JTable();

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
					CustomerDetailsTable frame = new CustomerDetailsTable();
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
	public CustomerDetailsTable() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewdata = new JButton("ViewData");
		btnViewdata.setBackground(Color.WHITE);
		btnViewdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
			    String id=textField.getText();		
				String str="select * from CUSTOMERDETAILS  where id='"+id+"'";
				Class.forName("org.h2.Driver");
				Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
				Statement stm=conn.createStatement();
				ResultSet rs=stm.executeQuery(str);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception y)
				{
					
				}
				
			}
		});
		btnViewdata.setBounds(106, 55, 90, 25);
		contentPane.add(btnViewdata);
		//Important code for view tables
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.setBounds(26, 98, 386, 340);
				contentPane.add(panel);
				panel.setLayout(null);
				
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 366, 318);
				panel.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				
				textField = new JTextField();
				textField.setBounds(26, 55, 70, 25);
				contentPane.add(textField);
				textField.setColumns(10);
				
				JButton btnViewall = new JButton("ViewAll");
				btnViewall.setBackground(Color.WHITE);
				btnViewall.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						try
						{
							
							String query="select * from CUSTOMERDETAILS ";
						
							Class.forName("org.h2.Driver");
							Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
							Statement stm=conn.createStatement();
						
							ResultSet rs=stm.executeQuery(query);
							table.setModel(DbUtils.resultSetToTableModel(rs));
						}
						catch(Exception y)
						{
							System.out.println(y);
						}
					}
				});
				btnViewall.setBounds(225, 55, 90, 25);
				contentPane.add(btnViewall);
				
				JLabel lblEmployeeDetailsTable = new JLabel("CUSTOMER DETAILS TABLE");
				lblEmployeeDetailsTable.setBackground(Color.WHITE);
				lblEmployeeDetailsTable.setForeground(Color.WHITE);
				lblEmployeeDetailsTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblEmployeeDetailsTable.setBounds(100, 10, 257, 30);
				contentPane.add(lblEmployeeDetailsTable);
				
				JButton btnReset = new JButton("Reset");
				btnReset.setBackground(Color.WHITE);
				btnReset.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						textField.setText("");
					}
				});
				btnReset.setBounds(342, 41, 70, 20);
				contentPane.add(btnReset);
				
				JButton btnBack = new JButton("Back");
				btnBack.setBackground(Color.WHITE);
				btnBack.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						EmployeeHomePage home=new EmployeeHomePage();
						home.setVisible(true);
						dispose();
					}
				});
				btnBack.setBounds(342, 67, 70, 20);
				contentPane.add(btnBack);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\aaa.jpg"));
				label.setBounds(0, 0, 434, 461);
				contentPane.add(label);
				
	}
}

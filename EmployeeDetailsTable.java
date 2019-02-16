import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class EmployeeDetailsTable extends JFrame
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
					EmployeeDetailsTable frame = new EmployeeDetailsTable();
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
	public EmployeeDetailsTable()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
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
					String str="select * from EMPLOYEEDETAILS  where id='"+id+"'";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					
					Statement stm=conn.createStatement();
					ResultSet rs=stm.executeQuery(str);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception y)
				{
					System.out.println("Invalid Data"+y);
				}
				
			}
		});
		btnViewdata.setBounds(112, 55, 90, 25);
		contentPane.add(btnViewdata);
		//Important code for view tables
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.setBounds(26, 98, 398, 332);
				contentPane.add(panel);
				panel.setLayout(null);
				
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 378, 310);
				panel.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				
				textField = new JTextField();
				textField.setBounds(26, 55, 76, 25);
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
					    String id=textField.getText();		
						String str="select * from EMPLOYEEDETAILS";
						
						Class.forName("org.h2.Driver");
						Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
						Statement stm=conn.createStatement();
						
						ResultSet rs=stm.executeQuery(str);
						table.setModel(DbUtils.resultSetToTableModel(rs));
						}
						catch(Exception y)
						{
							System.out.println(y);
						}
					}
				});
				btnViewall.setBounds(230, 55, 90, 25);
				contentPane.add(btnViewall);
				
				JLabel lblEmployeeDetailsTable = new JLabel("EMPLOYEE DETAILS TABLE");
				lblEmployeeDetailsTable.setForeground(Color.WHITE);
				lblEmployeeDetailsTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblEmployeeDetailsTable.setBounds(110, 11, 248, 30);
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
				btnReset.setBounds(354, 40, 70, 20);
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
				btnBack.setBounds(354, 67, 70, 20);
				contentPane.add(btnBack);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\aaa.jpg"));
				label.setBounds(0, 0, 452, 456);
				contentPane.add(label);
				
				
	}
}

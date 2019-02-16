import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class EmployeeLoginPage extends JFrame
{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
					EmployeeLoginPage frame = new EmployeeLoginPage();
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
	public EmployeeLoginPage() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeLogin = new JLabel("EMPLOYEE LOGIN");
		lblEmployeeLogin.setForeground(Color.WHITE);
		lblEmployeeLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmployeeLogin.setBounds(134, 40, 167, 27);
		contentPane.add(lblEmployeeLogin);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(72, 119, 80, 25);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(212, 120, 153, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(72, 185, 80, 25);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 186, 153, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setForeground(Color.WHITE);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRole.setBounds(72, 252, 80, 25);
		contentPane.add(lblRole);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Employee"}));
		comboBox.setBounds(212, 253, 153, 25);
		contentPane.add(comboBox);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{	
					String name=textField.getText();
					String pass=textField_1.getText();
					
					Class.forName("org.h2.Driver");
					Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					
					String query="select username, password from login WHERE username ='"+name+"' AND password ='"+pass+"'";
					
					Statement stm=con.createStatement();
					
					ResultSet set=stm.executeQuery(query);
					
					set.next();
					
					String y1=set.getString(1);
					String y2=set.getString(2);
					
					if(y1.equals(name)&&y2.equals(pass))
					{
						JOptionPane.showMessageDialog(btnLogin, "Login Successfull..");
						EmployeeHomePage home=new EmployeeHomePage();
						home.setVisible(true);
						dispose();
					}

				}
					
				
				catch(Exception x)
				{
					System.out.println("Invalid username or password"+x);
				}	
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(108, 370, 90, 30);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReset.setBounds(271, 346, 80, 25);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				HomePage home=new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(271, 403, 80, 25);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\aaa.jpg"));
		label.setBounds(0, 0, 434, 461);
		contentPane.add(label);
	}
}

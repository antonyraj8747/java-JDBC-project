import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class AdminLoginPage extends JFrame 
{
	private JPanel contentPane;
	private JTextField password_Field;
	private JTextField username_Field;
	protected Connection connection;

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
					AdminLoginPage frame = new AdminLoginPage();
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
	public AdminLoginPage() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
		lblAdminLogin.setForeground(Color.WHITE);
		lblAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdminLogin.setBounds(150, 38, 136, 28);
		contentPane.add(lblAdminLogin);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(72, 115, 80, 25);
		contentPane.add(lblUsername);
		
		username_Field = new JTextField();
		username_Field.setBounds(201, 116, 150, 25);
		contentPane.add(username_Field);
		username_Field.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(72, 178, 80, 25);
		contentPane.add(lblPassword);

		password_Field = new JTextField();
		password_Field.setBounds(201, 178, 150, 25);
		contentPane.add(password_Field);
		password_Field.setColumns(10);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setForeground(Color.WHITE);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRole.setBounds(72, 246, 80, 25);
		contentPane.add(lblRole);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin"}));
		comboBox.setBounds(201, 247, 150, 25);
		contentPane.add(comboBox);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{	
					String name=username_Field.getText();
					String pass=password_Field.getText();
					
					Class.forName("org.h2.Driver");
					Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					
					String query="select username, password from LOGIN WHERE username ='"+name+"' AND password ='"+pass+"'";
					
					Statement stm=con.createStatement();
					
					ResultSet set=stm.executeQuery(query);
					
					set.next();
					
					String y1=set.getString(1);
					String y2=set.getString(2);
					
					if(y1.equals(name)&&y2.equals(pass))
					{
					
						JOptionPane.showMessageDialog(btnLogin, "Login Successfull..");
						
						AdminHomePage home=new AdminHomePage();
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
		btnLogin.setBounds(107, 361, 90, 30);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				username_Field.setText("");
				password_Field.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReset.setBounds(271, 337, 80, 25);
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
		btnBack.setBounds(271, 393, 80, 25);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\aaa.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 461);
		contentPane.add(lblNewLabel);
		
	}
}

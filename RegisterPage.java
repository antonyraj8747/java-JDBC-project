import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RegisterPage extends JFrame 
{
	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField;
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
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterForm = new JLabel("REGISTER");
		lblRegisterForm.setForeground(Color.WHITE);
		lblRegisterForm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegisterForm.setBounds(172, 40, 89, 30);
		contentPane.add(lblRegisterForm);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(72, 120, 80, 25);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(215, 120, 150, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(72, 190, 80, 25);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(215, 190, 150, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setForeground(Color.WHITE);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRole.setBounds(72, 260, 80, 25);
		contentPane.add(lblRole);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select-your-Role", "Admin", "Employee"}));
		comboBox.setBounds(215, 260, 150, 25);
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
					String role=(String) comboBox.getSelectedItem();
					
					String str=" select username , password, role from LOGIN  where username ='"+name+"' and password ='"+pass+"' and role = '"+role+"' ";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					
					Statement stm =conn.createStatement();
					ResultSet set= stm.executeQuery(str);
					set.next();
					
					String uname=set.getString(1);
					String pa=set.getString(2);
					String ro=set.getString(3);
					
					if(name.equals(uname)&&pass.equals(pa))
					{
							switch(ro)
							{
							case "Admin" :
								JOptionPane.showMessageDialog(btnLogin, "Admin Login Success..!");
								AddEmployeeDetails EoHP = new AddEmployeeDetails();
								EoHP.setVisible(true);
								dispose();
								break;
								
							case "Employee" :
								JOptionPane.showMessageDialog(btnLogin, "Employee Login Success..!");
								AddCustomerDetails EHP = new AddCustomerDetails();
								EHP.setVisible(true);
								dispose();
								break;
							}	
					}
					
				}
				catch(Exception t)
				{
					System.out.println(t);
					JOptionPane.showMessageDialog(btnLogin, "Invalid username or password...!");
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(100, 373, 90, 30);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReset.setBounds(271, 348, 80, 25);
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
		btnBack.setBounds(271, 400, 80, 25);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\aaa.jpg"));
		label.setBounds(0, 0, 434, 461);
		contentPane.add(label);
		
		
		
	}
}

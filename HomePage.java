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
import java.awt.SystemColor;
import javax.swing.UIManager;

public class HomePage extends JFrame 
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
					HomePage frame = new HomePage();
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
	public HomePage() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHomePage = new JLabel("HOME PAGE");
		lblHomePage.setForeground(Color.WHITE);
		lblHomePage.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblHomePage.setBounds(153, 48, 139, 27);
		contentPane.add(lblHomePage);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setForeground(Color.BLACK);
		btnAdminLogin.setBackground(Color.WHITE);
		btnAdminLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				AdminLoginPage login=new AdminLoginPage();
				login.setVisible(true);
				dispose();
			}
		});
		btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdminLogin.setBounds(142, 137, 150, 30);
		contentPane.add(btnAdminLogin);
		
		JButton btnNewButton = new JButton("Employee Login");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				EmployeeLoginPage login=new EmployeeLoginPage();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(142, 206, 150, 30);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.WHITE);
		btnRegister.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				RegisterPage reg=new RegisterPage();
				reg.setVisible(true);
				dispose();
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegister.setBounds(142, 275, 150, 30);
		contentPane.add(btnRegister);
		
		JButton btnMainPage = new JButton("Main Page");
		btnMainPage.setForeground(Color.BLACK);
		btnMainPage.setBackground(Color.WHITE);
		btnMainPage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMainPage.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				MainPage main=new MainPage();
				main.setVisible(true);
				dispose();
			}
		});
		btnMainPage.setBounds(165, 369, 95, 25);
		contentPane.add(btnMainPage);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\aaa.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 461);
		contentPane.add(lblNewLabel);
	}

}

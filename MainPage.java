import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingConstants;

public class MainPage extends JFrame 
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
				MainPage frame = new MainPage();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHotelHifi = new JLabel("Hotel HIFI");
		lblHotelHifi.setForeground(Color.WHITE);
		lblHotelHifi.setFont(new Font("Engravers MT", Font.BOLD | Font.ITALIC, 30));
		lblHotelHifi.setBounds(95, 120, 265, 35);
		contentPane.add(lblHotelHifi);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Engravers MT", Font.BOLD | Font.ITALIC, 20));
		lblWelcome.setBounds(150, 200, 141, 29);
		contentPane.add(lblWelcome);
		
		JButton btnClickToHome = new JButton("Go to HOME page");
		btnClickToHome.setBackground(Color.WHITE);
		btnClickToHome.setToolTipText("Click");
		btnClickToHome.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
					HomePage home=new HomePage();
					home.setVisible(true);
					
					dispose();
			}
		});
		btnClickToHome.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClickToHome.setBounds(150, 352, 141, 29);
		contentPane.add(btnClickToHome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Antony Raj\\Downloads\\small-widescreen-displays-1280x800.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 461);
		contentPane.add(lblNewLabel);

	}
}

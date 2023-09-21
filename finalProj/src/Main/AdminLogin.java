package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Main.Dashboard;

public class AdminLogin implements WindowListener{
	
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private HashMap<String, String> adminLoginInfo = new HashMap<String, String>();
	JFrame frame;
	JFrame frameDb;
	//ulok
	
	public AdminLogin(HashMap<String, String> adminLoginInfo, JFrame jfdb){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Initialization(adminLoginInfo, jfdb);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void Initialization(HashMap<String, String> adminLoginInfo, JFrame jfdb) {
		frame = new JFrame();
		this.adminLoginInfo = adminLoginInfo;
		this.frameDb = jfdb;
		frameDb.setEnabled(false);
		
		frame.addWindowListener(this);
		frame.setBounds(100, 100, 467, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBorder(new EmptyBorder(0, 30, 0, 0));
		header.setBackground(new Color(43, 52, 59));
		header.setBounds(0, 0, 441, 62);
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setBounds(36, 19, 193, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Gilroy ExtraBold", Font.BOLD, 26));
		header.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username: ");
		lblNewLabel_1_1.setFont(new Font("Gilroy Light", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(71, 120, 102, 14);
		contentPane.add(lblNewLabel_1_1);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.setColumns(10);
		usernameField.setBounds(71, 139, 293, 25);
		usernameField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_ENTER) {
					loginAccount();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		contentPane.add(usernameField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password: ");
		lblNewLabel_1_1_1.setFont(new Font("Gilroy Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(71, 184, 102, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(71, 202, 293, 25);
		passwordField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_ENTER) {
					loginAccount();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(201, 242, 168));
		btnLogin.setFont(new Font("Gilroy Light", Font.ITALIC, 13));
		btnLogin.setBounds(71, 264, 293, 35);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginAccount();
			}
			
		});
		
		contentPane.add(btnLogin);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private void loginAccount() {
		String userID = usernameField.getText();
		String password = String.valueOf(passwordField.getPassword());

		if (adminLoginInfo.containsKey(userID)) {
			if (adminLoginInfo.get(userID).equals(password)) {
				frameDb.dispose();
				frame.dispose();
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {

						new Dashboard2().setVisible(true);
					}
				});
			} else {
				JOptionPane.showMessageDialog(null,"Wrong password or username");
			}

		} else {
			JOptionPane.showMessageDialog(null,"Wrong password or username");
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		frameDb.setEnabled(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}

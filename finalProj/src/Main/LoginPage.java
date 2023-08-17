package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Main.RegisterPage;
import utils.WriteReadHandler;

public class LoginPage extends JFrame implements KeyListener{
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel messageLabel = new JLabel();
	private HashMap<String, String> logininfo = new HashMap<String, String>();

	LoginPage(HashMap<String, String> loginInfoOriginal) throws IOException {
		
		logininfo = loginInfoOriginal;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		header.setBorder(new EmptyBorder(0, 30, 0, 0));
		FlowLayout fl_header = (FlowLayout) header.getLayout();
		fl_header.setAlignment(FlowLayout.LEFT);
		fl_header.setVgap(15);
		header.setBackground(new Color(43, 52, 59));
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		header.add(lblNewLabel);
			
		JPanel body = new JPanel();
		contentPane.add(body, BorderLayout.CENTER);
		body.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(73, 50, 128, 25);
		body.add(lblNewLabel_1_1);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.setColumns(10);
		usernameField.setBounds(71, 77, 293, 25);
		usernameField.addKeyListener(this);
		body.add(usernameField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(71, 113, 102, 23);
		body.add(lblNewLabel_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(71, 140, 293, 25);
		passwordField.addKeyListener(this);
		body.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(201, 242, 168));
		btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnLogin.setBounds(71, 202, 142, 35);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginAccount();
			}

		});
		body.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(187, 214, 249));
		btnRegister.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnRegister.setBounds(222, 202, 142, 35);
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						
						RegisterPage frame = new RegisterPage(logininfo);
						dispose();
						
					}
				});
				
			}
			
		});
		body.add(btnRegister);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER) {
			loginAccount();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	private void loginAccount() {
		String userID = usernameField.getText();
		String password = String.valueOf(passwordField.getPassword());

		if (logininfo.containsKey(userID)) {
			if (logininfo.get(userID).equals(password)) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Dashboard window = new Dashboard();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			} else {
				JOptionPane.showMessageDialog(null,"Wrong password or username");
			}

		} else {
			JOptionPane.showMessageDialog(null,"Wrong password or username");
		}
	}
}

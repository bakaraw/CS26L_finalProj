package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Main.RegisterPage;

import utils.WriteReadHandler;

public class LoginPage implements KeyListener{
	private JPanel contentPane;
	private JLabel messageLabel = new JLabel();
	private JFrame frame = new JFrame();
	private IDandPasswords idAndPass = new IDandPasswords();
	private JTextField usernameField;
	private JPasswordField passwordField;

	LoginPage() throws IOException {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 471, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 453, 61);
		header.setBorder(new EmptyBorder(0, 30, 0, 0));
		header.setBackground(new Color(43, 52, 59));
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setBounds(35, 15, 129, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		header.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(74, 102, 128, 25);
		contentPane.add(lblNewLabel_1_1);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.setColumns(10);
		usernameField.setBounds(74, 126, 293, 25);
		contentPane.add(usernameField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(74, 166, 102, 23);
		contentPane.add(lblNewLabel_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(74, 189, 293, 25);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnLogin.setBackground(new Color(201, 242, 168));
		btnLogin.setBounds(74, 251, 142, 35);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnRegister.setBackground(new Color(187, 214, 249));
		btnRegister.setBounds(225, 251, 142, 35);
		contentPane.add(btnRegister);
		
		JButton adminLoginBtn = new JButton("Log-in as Admin");
		adminLoginBtn.setBackground(new Color(226, 252, 252));
		adminLoginBtn.setBounds(158, 298, 128, 25);
		contentPane.add(adminLoginBtn);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER) {
			try {
				loginAccount();
			} catch (HeadlessException | ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	private void loginAccount() throws HeadlessException, FileNotFoundException, ClassNotFoundException, IOException {
		String userID = usernameField.getText();
		String password = String.valueOf(passwordField.getPassword());

		if (idAndPass.getLoginInfo().containsKey(userID)) {
			if (idAndPass.getLoginInfo().get(userID).equals(password)) {
				
				frame.dispose();;
				Dashboard window = new Dashboard();			
				
			} else {
				JOptionPane.showMessageDialog(null,"Wrong password or username");
			}

		} else {
			JOptionPane.showMessageDialog(null,"Wrong password or username");
		}
	}
}

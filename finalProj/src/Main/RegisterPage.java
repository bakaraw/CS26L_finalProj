package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
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

import utils.WriteReadHandler;

public class RegisterPage extends JFrame implements KeyListener {
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField password;
	private JPasswordField confirmPassword;
	// IDandPasswords loginCred = new IDandPasswords();
	private WriteReadHandler userCredSaver = new WriteReadHandler();
	private HashMap<String, String> logininfo = new HashMap<>();

	public RegisterPage(HashMap<String, String> logininfoOriginal) {
		logininfo = logininfoOriginal;

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

		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		header.add(lblNewLabel);

		JPanel body = new JPanel();
		contentPane.add(body, BorderLayout.CENTER);
		body.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Username: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(74, 34, 124, 25);
		body.add(lblNewLabel_1);

		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.setBounds(74, 64, 293, 25);
		body.add(usernameField);
		usernameField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Password: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(74, 100, 142, 23);
		body.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm Password: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(74, 163, 200, 27);
		body.add(lblNewLabel_1_1_1);

		password = new JPasswordField();
		password.setBounds(74, 127, 293, 25);
		body.add(password);

		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(74, 195, 293, 25);
		confirmPassword.addKeyListener(this);
		body.add(confirmPassword);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(201, 242, 168));
		btnRegister.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnRegister.setBounds(74, 244, 142, 35);
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				regAccount();
			}

		});
		body.add(btnRegister);

		JButton btnBack = new JButton("Login Again");
		btnBack.setBackground(new Color(187, 214, 249));
		btnBack.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnBack.setBounds(222, 244, 142, 35);
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					LoginPage loginPg = new LoginPage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}

		});
		body.add(btnBack);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			regAccount();
		}
	}

	public void regAccount() {
		if (!usernameField.getText().isEmpty() && !password.getText().isEmpty()
				&& !confirmPassword.getText().isEmpty()) {
			if (password.getText().contains(confirmPassword.getText())) {

				logininfo.put(usernameField.getText(), password.getText());

				// local username and password saver
				try {
					userCredSaver.writeUsernamPass(logininfo);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Register Successful");

			} else {
				JOptionPane.showMessageDialog(null, "Password does not match");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Input essential infos");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

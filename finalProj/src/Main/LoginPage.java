package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Main.RegisterPage;
import utils.DatabaseHandler;
import utils.WriteReadHandler;

public class LoginPage extends DatabaseHandler implements KeyListener {
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel messageLabel = new JLabel();
	private JFrame frame = new JFrame();
	private IDandPasswords idAndPass = new IDandPasswords();

	LoginPage() throws IOException {
		Connect();
		frame.setTitle("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 962, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel body = new JPanel();
		body.setBackground(new Color(255, 255, 255));
		body.setBounds(477, 0, 469, 509);
		contentPane.add(body);
		body.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Username: ");
		lblNewLabel_1_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_1.setForeground(new Color(43, 52, 59));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(94, 185, 128, 25);
		body.add(lblNewLabel_1_1);

		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.setColumns(10);
		usernameField.setBounds(94, 215, 293, 25);
		usernameField.addKeyListener(this);
		body.add(usernameField);

		JLabel lblNewLabel_1_1_1 = new JLabel("Password: ");
		lblNewLabel_1_1_1.setForeground(new Color(43, 52, 59));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(94, 251, 102, 23);
		body.add(lblNewLabel_1_1_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(94, 278, 293, 25);
		passwordField.addKeyListener(this);
		body.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(201, 242, 168));
		btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnLogin.setBounds(94, 332, 142, 35);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					loginAccount();
				} catch (HeadlessException | ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		body.add(btnLogin);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnRegister.setBounds(245, 332, 142, 35);
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {

						try {
							RegisterPage regPage = new RegisterPage(idAndPass.getLoginInfo());
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						frame.dispose();

					}
				});

			}

		});
		body.add(btnRegister);

		JButton adminLoginBtn = new JButton("Log-in as Admin");
		adminLoginBtn.setFont(new Font("Tahoma", Font.ITALIC, 11));
		adminLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(false);
				AdminLogin adminLogin = new AdminLogin(idAndPass.getAdminLoginInfo(), frame);
			}
		});
		adminLoginBtn.setBackground(new Color(255, 255, 255));
		adminLoginBtn.setBounds(178, 378, 128, 25);
		body.add(adminLoginBtn);

		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setForeground(new Color(43, 52, 59));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(142, 112, 197, 44);
		body.add(lblNewLabel);

		JPanel imgPanel = new JPanel();
		imgPanel.setBounds(0, 0, 477, 509);
		contentPane.add(imgPanel);
		imgPanel.setLayout(null);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("img\\bitmonkelogo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel monkeImg1 = new JLabel("");
		monkeImg1.setBounds(0, 0, 477, 509);
		Image dimg = img.getScaledInstance(monkeImg1.getWidth(), monkeImg1.getHeight(), Image.SCALE_SMOOTH);

		monkeImg1.setIcon(new ImageIcon(dimg));
		imgPanel.add(monkeImg1);

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
		String username = usernameField.getText();
		String userID = usernameField.getText();
		String password = String.valueOf(passwordField.getPassword());

		String passwordFromDatabase = null;

		String name = null;
		String id = null;

		try {

			pst = con.prepareStatement("select ID,Name,Password from employee where Username = ?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();

			if (rs.next() == true) {
				id = Integer.toString(rs.getInt(1));
				name = rs.getString(2);
				passwordFromDatabase = rs.getString(3);

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (!password.isEmpty()) {
			if (password.equals(passwordFromDatabase)) {
				frame.dispose();
				Dashboard window = new Dashboard(username, name, id);
			} else {
				JOptionPane.showMessageDialog(null, "Wrong password or username");
			}
		} else {
			JOptionPane.showMessageDialog(null, "input infos");
		}

	}
}

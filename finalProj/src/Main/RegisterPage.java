package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Calendar;
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

import utils.DatabaseHandler;
import utils.Employee;
import utils.WriteReadHandler;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class RegisterPage extends DatabaseHandler implements KeyListener {
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField password;
	private JPasswordField confirmPassword;
	// IDandPasswords loginCred = new IDandPasswords();
	private WriteReadHandler userCredSaver = new WriteReadHandler();
	private HashMap<String, String> logininfo = new HashMap<>();
	private JTextField firstNameField;
	private JTextField middleNameField;
	private String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
	private JTextField lastNameField;
	private JComboBox monthComboBox;
	private JComboBox dayComboBox;
	private JComboBox yearComboBox;

	private JFrame frame;

	// numbers array maker for the date combobox
	private String[] arrayMaker(int num) {
		int[] numbers = new int[num];
		String[] result = new String[num];
		for (int i = 0; i < num; i++) {
			numbers[i] = i + 1;
		}
		for (int i = 0; i < num; i++) {
			result[i] = Integer.toString(numbers[i]);
		}
		return result;
	}

	private String[] arrayMakerForDate(int startingYear) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int startYear = startingYear;

		// Calculate the size of the array based on the range of years
		int arraySize = currentYear - startYear + 1;

		int[] yearsArray = new int[arraySize];

		// Fill the array with years from 1920 to the current year
		for (int i = 0; i < arraySize; i++) {
			yearsArray[i] = startYear + i;
		}

		// Convert the int array to a string array
		String[] stringYearsArray = new String[arraySize];
		for (int i = 0; i < arraySize; i++) {
			stringYearsArray[i] = Integer.toString(yearsArray[i]);
		}
		return stringYearsArray;
	}

	public RegisterPage(HashMap<String, String> logininfoOriginal) {
		logininfo = logininfoOriginal;
		Connect();

		frame = new JFrame();
    frame.setTitle("Register Account");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 962, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmRegisterAccount.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel body = new JPanel();
		body.setBounds(477, 0, 469, 509);
		body.setBackground(new Color(255, 255, 255));
		contentPane.add(body);
		body.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Username: ");
		lblNewLabel_1.setForeground(new Color(43, 52, 59));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(50, 253, 92, 25);
		body.add(lblNewLabel_1);

		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.setBounds(142, 254, 281, 25);
		body.add(usernameField);
		usernameField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Password: ");
		lblNewLabel_1_1.setForeground(new Color(43, 52, 59));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(50, 289, 142, 23);
		body.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm Password: ");
		lblNewLabel_1_1_1.setForeground(new Color(43, 52, 59));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(50, 325, 172, 27);
		body.add(lblNewLabel_1_1_1);

		password = new JPasswordField();
		password.setBounds(142, 289, 281, 25);
		body.add(password);

		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(199, 329, 224, 25);
		confirmPassword.addKeyListener(this);
		body.add(confirmPassword);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(201, 242, 168));
		btnRegister.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnRegister.setBounds(93, 408, 142, 35);
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				regAccount();
			}

		});
		body.add(btnRegister);

		JButton btnBack = new JButton("Login Again");
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnBack.setBounds(241, 408, 142, 35);
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					LoginPage loginPg = new LoginPage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frmRegisterAccount.dispose();
			}

		});
		body.add(btnBack);

		JLabel lblNewLabel_1_2 = new JLabel("First Name:");
		lblNewLabel_1_2.setForeground(new Color(43, 52, 59));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(50, 119, 194, 25);
		body.add(lblNewLabel_1_2);

		firstNameField = new JTextField();
		firstNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		firstNameField.setColumns(10);
		firstNameField.setBounds(50, 145, 228, 25);
		body.add(firstNameField);

		JLabel lblNewLabel_1_2_1 = new JLabel("Middle Name:");
		lblNewLabel_1_2_1.setForeground(new Color(43, 52, 59));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(288, 119, 136, 25);
		body.add(lblNewLabel_1_2_1);

		middleNameField = new JTextField();
		middleNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		middleNameField.setColumns(10);
		middleNameField.setBounds(288, 145, 136, 25);
		body.add(middleNameField);

		JLabel lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.setBackground(new Color(43, 52, 59));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(new Color(43, 52, 59));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_2.setBounds(50, 46, 231, 50);
		body.add(lblNewLabel_2);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Birthday:");
		lblNewLabel_1_2_1_1.setForeground(new Color(43, 52, 59));
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_1_1.setBounds(50, 217, 93, 25);
		body.add(lblNewLabel_1_2_1_1);

		monthComboBox = new JComboBox(months);
		monthComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		monthComboBox.setBounds(142, 218, 116, 25);
		body.add(monthComboBox);

		dayComboBox = new JComboBox(arrayMaker(31));
		dayComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dayComboBox.setBounds(268, 218, 61, 25);
		body.add(dayComboBox);

		yearComboBox = new JComboBox(arrayMakerForDate(1920));
		yearComboBox.setSelectedItem(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
		yearComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		yearComboBox.setBounds(337, 218, 87, 25);
		body.add(yearComboBox);

		JLabel lblNewLabel_1_2_2 = new JLabel("Last Name:");
		lblNewLabel_1_2_2.setForeground(new Color(43, 52, 59));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_2.setBounds(50, 181, 124, 25);
		body.add(lblNewLabel_1_2_2);

		lastNameField = new JTextField();
		lastNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lastNameField.setColumns(10);
		lastNameField.setBounds(142, 182, 281, 25);
		body.add(lastNameField);

		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 477, 509);
		contentPane.add(imagePanel);
		imagePanel.setLayout(null);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("img\\bitmonke.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 477, 509);
		Image dimg = img.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);

		lblNewLabel_3.setIcon(new ImageIcon(dimg));
		imagePanel.add(lblNewLabel_3);

		frmRegisterAccount.setResizable(false);
		frmRegisterAccount.setLocationRelativeTo(null);
		frmRegisterAccount.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			regAccount();
		}
	}

	public void regAccount() {
		if (!usernameField.getText().isEmpty() && !password.getText().isEmpty() && !firstNameField.getText().isEmpty()
				&& !middleNameField.getText().isEmpty() && !lastNameField.getText().isEmpty()) {

			if (password.getText().equals(confirmPassword.getText())) {

				try {
					Employee employee = new Employee();
					employee.setName(
							firstNameField.getText() + " " + middleNameField.getText() + " " + lastNameField.getText());

					employee.setBirthday(
							monthComboBox.getSelectedItem().toString() + " " + dayComboBox.getSelectedItem().toString()
									+ ", " + yearComboBox.getSelectedItem().toString());

					employee.setUsername(usernameField.getText());
					employee.setPassword(password.getText());
					saveToDatabase(employee);
					firstNameField.setText("");
					middleNameField.setText("");
					lastNameField.setText("");
					usernameField.setText("");
					password.setText("");
					confirmPassword.setText("");
					JOptionPane.showMessageDialog(null, "Register Successful");

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Username already existed");
				}

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

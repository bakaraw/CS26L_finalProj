package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PopUp extends JFrame {

	private JPanel body;
	private JTextField textField_Description;
	private JTextField textField_Price;
	private JTextField textField_SKU;
	private JTextField textField_ChangedBy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUp frame = new PopUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PopUp() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 408, 332);
		body = new JPanel();
		body.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(body);
		body.setLayout(null);
		
		JPanel top = new JPanel();
		top.setLayout(null);
		top.setBorder(new EmptyBorder(0, 5, 0, 83));
		top.setBackground(new Color(48, 62, 71));
		top.setBounds(0, 0, 434, 64);
		body.add(top);
		
		JLabel lblNewLabel_3 = new JLabel("Add/Remove");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Gilroy ExtraBold", Font.BOLD, 26));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(15, 11, 169, 37);
		top.add(lblNewLabel_3);
		
		JLabel label_Description = new JLabel("Description:");
		label_Description.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_Description.setBounds(15, 127, 85, 14);
		body.add(label_Description);
		
		JLabel label_Price = new JLabel("Price:");
		label_Price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_Price.setBounds(60, 177, 40, 14);
		body.add(label_Price);
		
		textField_Description = new JTextField();
		textField_Description.setColumns(10);
		textField_Description.setBounds(110, 126, 259, 20);
		body.add(textField_Description);
		
		textField_Price = new JTextField();
		textField_Price.setColumns(10);
		textField_Price.setBounds(110, 176, 259, 20);
		body.add(textField_Price);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnAdd.setBounds(110, 222, 96, 23);
		body.add(btnAdd);
		
		JButton button_Remove = new JButton("Remove");
		button_Remove.setFont(new Font("Tahoma", Font.ITALIC, 11));
		button_Remove.setBounds(215, 222, 96, 23);
		body.add(button_Remove);
		
		JLabel label_SKU = new JLabel("SKU:");
		label_SKU.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_SKU.setBounds(65, 102, 40, 14);
		body.add(label_SKU);
		
		textField_SKU = new JTextField();
		textField_SKU.setEditable(false);
		textField_SKU.setColumns(10);
		textField_SKU.setBounds(110, 101, 259, 20);
		body.add(textField_SKU);
		
		JLabel label_ChangedBy = new JLabel("Changed By:");
		label_ChangedBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_ChangedBy.setBounds(10, 152, 90, 14);
		body.add(label_ChangedBy);
		
		textField_ChangedBy = new JTextField();
		textField_ChangedBy.setColumns(10);
		textField_ChangedBy.setBounds(110, 151, 259, 20);
		body.add(textField_ChangedBy);
	}
	
	public void setSku(String sku) {
		textField_SKU.setText(sku);
	}

	public void setdesc(String a) {
		textField_Description.setText(a);

	}

	public void setprice(String a) {
		textField_Price.setText(a);
	}
}

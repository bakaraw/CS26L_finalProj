package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import utils.DatabaseHandler;
import utils.Product;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import java.awt.GridLayout;



public class BillWindow extends JFrame{
	
	private JTextArea receipt;
	public BillWindow() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setResizable(false);
		setTitle("Receipt");
		setBounds(100, 100, 448, 547);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel body = new JPanel();
		body.setBackground(new Color(233, 233, 233));
		body.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(body);
		body.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		body.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 422, 498);
		
		
		receipt = new JTextArea();
		receipt.setLineWrap(true);
		receipt.setWrapStyleWord(true);
		receipt.setFont(new Font("Monospaced", Font.PLAIN, 14));
		receipt.setEditable(false);
		receipt.setBounds(63, 271, 402, 498);
		
		scrollPane.setViewportView(receipt);
		panel.add(scrollPane);
		
		
		setVisible(true);	
	}
	
	public JTextArea getRec() {
		return receipt;
	}
}

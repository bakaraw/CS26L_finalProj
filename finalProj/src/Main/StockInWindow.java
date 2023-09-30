package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import utils.ActivityLogs;
import utils.DatabaseHandler;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JTextArea;

public class StockInWindow extends JFrame {

	private JPanel body;
	private static JTextField addstockSkuField;
	private static JTextField adddescField;
	private JTextField stockInbyField;
	private JTextField addqtyField;
	private static JTextField currQtyField;
	private static JTable inventoryTable;
	private static JTable logsTable;
	static DatabaseHandler handler = new DatabaseHandler();
	private static StockInWindow obj = null;
	private static JTextArea addStockTextArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	
	
	public StockInWindow() {
		setTitle("Stock In");
		setResizable(false);
		handler.Connect();
		initComponents();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 476, 567);
		setLocationRelativeTo(null);
		body = new JPanel();
		body.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(body);
		body.setLayout(null);

		JPanel top = new JPanel();
		top.setLayout(null);
		top.setBorder(new EmptyBorder(0, 5, 0, 83));
		top.setBackground(new Color(36, 49, 55));
		top.setBounds(0, 0, 460, 64);
		body.add(top);

		JLabel lblNewLabel_3 = new JLabel("Stock In");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(15, 11, 195, 37);
		top.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("SKU:");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(35, 101, 51, 20);
		body.add(lblNewLabel);

		JLabel lblDescription = new JLabel("DESCRIPTION:");
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescription.setBounds(40, 140, 109, 20);
		body.add(lblDescription);

		JLabel lblStockInBy = new JLabel("STOCK IN BY:");
		lblStockInBy.setVerticalAlignment(SwingConstants.TOP);
		lblStockInBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStockInBy.setBounds(46, 261, 102, 20);
		body.add(lblStockInBy);

		JLabel lblQuantity = new JLabel("QUANTITY:");
		lblQuantity.setVerticalAlignment(SwingConstants.TOP);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(62, 220, 89, 20);
		body.add(lblQuantity);

		addstockSkuField = new JTextField();
		addstockSkuField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					handler.skuSearch(addstockSkuField, adddescField, currQtyField);
				}
			}
		});
		addstockSkuField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addstockSkuField.setColumns(10);
		addstockSkuField.setBounds(85, 98, 242, 30);
		body.add(addstockSkuField);

		adddescField = new JTextField();
		adddescField.setEditable(false);
		adddescField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		adddescField.setColumns(10);
		adddescField.setBounds(159, 138, 267, 30);
		body.add(adddescField);

		stockInbyField = new JTextField();
		stockInbyField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		stockInbyField.setColumns(10);
		stockInbyField.setBounds(159, 258, 267, 30);
		body.add(stockInbyField);

		addqtyField = new JTextField();
		addqtyField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addqtyField.setColumns(10);
		addqtyField.setBounds(159, 217, 267, 30);
		body.add(addqtyField);

		JLabel lblCurrentQty = new JLabel("CURRENT QTY:");
		lblCurrentQty.setVerticalAlignment(SwingConstants.TOP);
		lblCurrentQty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentQty.setBounds(35, 182, 114, 20);
		body.add(lblCurrentQty);

		currQtyField = new JTextField();
		currQtyField.setEditable(false);
		currQtyField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		currQtyField.setColumns(10);
		currQtyField.setBounds(159, 179, 267, 30);
		body.add(currQtyField);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.skuSearch(addstockSkuField, adddescField, currQtyField);
			}
		});
		btnSearch.setBounds(337, 99, 89, 30);
		body.add(btnSearch);

		JButton btnAddStock = new JButton("ADD");
		btnAddStock.setBackground(new Color(201, 242, 168));
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addStock();
				dispose();
			}
		});
		btnAddStock.setBounds(84, 455, 284, 34);
		body.add(btnAddStock);
		addStockTextArea.setLineWrap(true);
		addStockTextArea.setWrapStyleWord(true);
		
		
		addStockTextArea.setBounds(159, 302, 267, 101);
		body.add(addStockTextArea);
		
		JLabel lblRemarks = new JLabel("REMARKS:");
		lblRemarks.setVerticalAlignment(SwingConstants.TOP);
		lblRemarks.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRemarks.setBounds(72, 302, 76, 20);
		body.add(lblRemarks);
	}

	public void addStock() {
		try {
			
			String sku, desc, qty, changeby, remarks;
			sku = addstockSkuField.getText();
			desc = adddescField.getText();
			changeby = stockInbyField.getText();
			remarks = addStockTextArea.getText();
			String addqty = addqtyField.getText();
			System.out.println(addqty);
			System.out.println(changeby);
			
//			if (addqty.isEmpty() || changeby.isEmpty()) {
////				throw new Exception();
//				
//			}

			int addQtyVal = Integer.parseInt(addqty);
			int currQtyVal = Integer.parseInt(currQtyField.getText());
			if (addQtyVal > 0) {

				currQtyVal += addQtyVal;
				handler.updateStockQty(currQtyVal, sku);

				ActivityLogs logs = new ActivityLogs();
				logs.setSku(sku);
				logs.setDescription(desc);
				logs.setActivity("Stock in");
				logs.setQty(addqty);
				logs.setChangeBy(changeby);
				logs.setRemarks(remarks);

				handler.saveToDatabase(logs);
				handler.table_load("product", inventoryTable);
				handler.table_load("activitylogs", logsTable);

				JOptionPane.showMessageDialog(null, "Stock added successfully!");

				currQtyField.setText(currQtyVal + "");
				stockInbyField.setText("");
				addqtyField.setText("");
				addStockTextArea.setText("");
				handler.skuSearched = "";

			} else if (addQtyVal == 0) {
				JOptionPane.showMessageDialog(null, "You add 0 stock");
			} else {
				JOptionPane.showMessageDialog(null, "Input POSITIVE integer in the ADD QTY field");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Please SEARCH first the SKU and\nPlease FILL UP all the necessary information");
		}

	}

	public static StockInWindow getObj() {
		if (obj == null) {
			obj = new StockInWindow();
		}
		return obj;
	}

	public static void setadddescField(String var) {
		adddescField.setText(var);
	}

	public static void setaddstockSkuField(String var) {
		addstockSkuField.setText(var);
	}

	public static void setcurrQtyField(String var) {
		currQtyField.setText(var);
	}
	
	public static void setInventoryTable(JTable table) {
		inventoryTable = table;
	}
	
	public static void setLogsTable(JTable table) {
		logsTable = table;
	}
}

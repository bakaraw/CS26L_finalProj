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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class RemoveWindow extends JFrame {

	private JPanel body;
	private static JTextField inventorySF;
	private static JTextField descremField;
	static JTextField qtyremField;
	private JTextField remQty;
	static JTextField rembyField;
	private static JTable inventoryTable;
	private static JTable logsTable;
	private static JTextArea remarksArea = new JTextArea();
	static DatabaseHandler handler = new DatabaseHandler();
	private static RemoveWindow obj = null;
	private JCheckBox deleteChkbox;

	public RemoveWindow() {
		setTitle("Remove ");
		setResizable(false);
		createGUI();
	}

	public void createGUI() {
		handler.Connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 560);
		setLocationRelativeTo(null);
		body = new JPanel();
		body.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(body);
		body.setLayout(null);

		JPanel top = new JPanel();
		top.setLayout(null);
		top.setBorder(new EmptyBorder(0, 5, 0, 83));
		top.setBackground(new Color(48, 62, 71));
		top.setBounds(0, 0, 447, 64);
		body.add(top);

		JLabel lblNewLabel_3 = new JLabel("Remove");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Gilroy ExtraBold", Font.BOLD, 26));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(15, 11, 103, 37);
		top.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("SKU:");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(35, 84, 35, 20);
		body.add(lblNewLabel);

		inventorySF = new JTextField();
		inventorySF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		inventorySF.setColumns(10);
		inventorySF.setBounds(90, 82, 232, 27);
		body.add(inventorySF);

		JLabel lblDescription = new JLabel("DESCRIPTION:");
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescription.setBounds(37, 121, 109, 20);
		body.add(lblDescription);

		descremField = new JTextField();
		descremField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descremField.setEditable(false);
		descremField.setColumns(10);
		descremField.setBounds(154, 119, 254, 27);
		body.add(descremField);

		JLabel lblCurrentQty = new JLabel("CURRENT QTY:");
		lblCurrentQty.setVerticalAlignment(SwingConstants.TOP);
		lblCurrentQty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentQty.setBounds(32, 158, 114, 20);
		body.add(lblCurrentQty);

		qtyremField = new JTextField();
		qtyremField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		qtyremField.setEditable(false);
		qtyremField.setColumns(10);
		qtyremField.setBounds(154, 157, 254, 27);
		body.add(qtyremField);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.skuSearched = inventorySF.getText();
				handler.skuSearch(inventorySF, descremField, qtyremField);
			}
		});
		btnSearch.setBounds(332, 83, 76, 27);
		body.add(btnSearch);

		remQty = new JTextField();
		remQty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		remQty.setColumns(10);
		remQty.setBounds(154, 195, 254, 27);
		body.add(remQty);

		JLabel lblStockInBy = new JLabel("REMOVED BY:");
		lblStockInBy.setVerticalAlignment(SwingConstants.TOP);
		lblStockInBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStockInBy.setBounds(43, 235, 104, 20);
		body.add(lblStockInBy);

		rembyField = new JTextField();
		rembyField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rembyField.setColumns(10);
		rembyField.setBounds(154, 233, 254, 27);
		body.add(rembyField);

		JLabel lblQuantity = new JLabel("QUANTITY:");
		lblQuantity.setVerticalAlignment(SwingConstants.TOP);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(59, 197, 89, 20);
		body.add(lblQuantity);

		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm Dialog",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				
				if(confirm == JOptionPane.YES_OPTION) {
					if(deleteChkbox.isSelected()) {
						deleteProduct();
					}else {
						removeStock();
					}
				}
				dispose();
			}
		});
		btnRemove.setBackground(new Color(201, 242, 168));
		btnRemove.setBounds(84, 455, 285, 31);
		body.add(btnRemove);

		JLabel lblRemarks = new JLabel("REMARKS:");
		lblRemarks.setVerticalAlignment(SwingConstants.TOP);
		lblRemarks.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRemarks.setBounds(70, 271, 76, 20);
		body.add(lblRemarks);

		JTextArea remarksArea = new JTextArea();
		remarksArea.setLineWrap(true);
		remarksArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		remarksArea.setBounds(154, 271, 254, 120);
		body.add(remarksArea);
		
		deleteChkbox = new JCheckBox("Remove row from the table?");
		deleteChkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(deleteChkbox.isSelected()) {
					remQty.setEditable(false);
					remQty.setText("");
				}else {
					remQty.setEditable(true);
				}
			}
		});
		deleteChkbox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		deleteChkbox.setBounds(154, 398, 212, 23);
		body.add(deleteChkbox);
	}
	
	void deleteProduct() {
		try {
			String sku, desc, changeby, remarks;
			sku = inventorySF.getText();
			desc = descremField.getText();
			changeby = rembyField.getText();
			remarks = remarksArea.getText();

			if (sku.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Search FIRST the product");
			}

			if (changeby.isEmpty()) {
				throw new Exception();
			}

			ActivityLogs logs = new ActivityLogs();
			logs.setSku(sku);
			logs.setDescription(desc);
			logs.setActivity("Deleted product");
			logs.setQty(qtyremField.getText());
			logs.setChangeBy(changeby);
			logs.setRemarks(remarks);
			handler.saveToDatabase(logs);

			handler.deleteRow("product", "SKU", inventorySF.getText());
			inventorySF.setText("");
			descremField.setText("");
			rembyField.setText("");
			remarksArea.setText("");
			qtyremField.setText("");
			handler.table_load("product", inventoryTable);
			handler.table_load("activitylogs", logsTable);
			

		} catch (Exception f) {
			JOptionPane.showMessageDialog(null, "Please input the necessary information");
			System.out.println("try");
		}

	}
	public void removeStock() {
		try {
			String sku, desc, qty, changeby, remarks;

			sku = inventorySF.getText();
			desc = descremField.getText();
			qty = qtyremField.getText();
			changeby = rembyField.getText();
			remarks = remarksArea.getText();

			String remqty = remQty.getText();

//			if (changeby.isEmpty() || remarks.isEmpty()) {
//				throw new Exception();
//			}

			int remQtyVal = Integer.parseInt(remqty);
			int currQtyVal = Integer.parseInt(qty);
			int newQtyVal = currQtyVal - remQtyVal;

			if (remQtyVal > 0 && currQtyVal > 0 && newQtyVal >= 0) {

				handler.updateStockQty(newQtyVal, sku);

				ActivityLogs logs = new ActivityLogs();
				logs.setSku(sku);
				logs.setDescription(desc);
				logs.setActivity("Stock removal");
				logs.setQty(remqty);
				logs.setChangeBy(changeby);
				logs.setRemarks(remarks);

				handler.saveToDatabase(logs);
				handler.table_load("product", inventoryTable);
				handler.table_load("activitylogs", logsTable);

				JOptionPane.showMessageDialog(null, "Stock removed successfully!");

				qtyremField.setText(newQtyVal + "");
				rembyField.setText("");
				remQty.setText("");
				remarksArea.setText("");
				handler.skuSearched = "";

			} else if (currQtyVal == 0) {
				JOptionPane.showMessageDialog(null, "Can't remove stock anymore because current Qty = 0   :(");
			} else if (newQtyVal < 0) {
				JOptionPane.showMessageDialog(null, "**ERROR**\nYou CANNOT remove Qty more than the current Qty");
			} else {
				JOptionPane.showMessageDialog(null, "**ERROR**\n{Input POSITIVE integer in the ADD QTY field}");

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Please SEARCH first the SKU and FILL UP all the necessary information");
			e.printStackTrace();
		}

	}

	public static RemoveWindow getObj() {
		if (obj == null) {
			obj = new RemoveWindow();
		}
		return obj;
	}

	public static void setinventorySF(String var) {
		inventorySF.setText(var);
	}

	public static void setdescremField(String var) {
		descremField.setText(var);
	}

	public static void setcurrQtyField(String var) {
		qtyremField.setText(var);
	}

	public static void setInventoryTable(JTable table) {

		inventoryTable = table;

	}

	public static void setLogsTable(JTable table) {

		logsTable = table;

	}
}

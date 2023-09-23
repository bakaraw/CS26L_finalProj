package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import utils.ActivityLogs;
import utils.DatabaseHandler;
import utils.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import java.awt.Button;
import javax.swing.JTextArea;

import java.sql.*;
import javax.swing.border.EtchedBorder;

import Main.Dashboard;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ListSelectionModel;

public class AdminPage extends DatabaseHandler {

	private JPanel contentPane;
	private JTextField inventorySF;
	private JTable inventoryTable;
	private JTextField skuField;
	private JTextField descField;
	private JTextField stockbyField;
	private JTextField qtyField;
	private JTextField addstockSkuField;
	private JTextField adddescField;
	private JTextField addqtyField;
	private JTextField stockInbyField;
	private JTextField descremField;
	private JTextField rembyField;
	private JTextField qtyremField;
	private JTextField priceField;
	private Product category = new Product();
	private String chosenCat = category.getCategoryByIndex(0);
	private String viewAll = "All";
	private JTextField currQtyField;
	private JComboBox viewCB;
	private JTextField remQty;
	private JTextArea remarksArea;
	private JTextArea addnewprodRemarks;
	private JTable logsTable;
	private JTextArea addStockTextArea;
	private JCheckBox chkRemProd;
	private ActivityLogs actType = new ActivityLogs();
	private JTable clientRecordsTable;

	public AdminPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initialization();
					Connect();
					table_load("product", inventoryTable);
					table_load("activitylogs", logsTable);
					table_load("clientrecords", clientRecordsTable);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void saveToDataBase() {
		String sku, desc, qty, price, stockinby, remarks;

		sku = skuField.getText();
		desc = descField.getText();
		qty = qtyField.getText();
		price = priceField.getText();
		stockinby = stockbyField.getText();
		remarks = addnewprodRemarks.getText();
		try {
			if (!sku.isEmpty() && !desc.isEmpty() && !qty.isEmpty() && !price.isEmpty()) {

				Product prod = new Product();
				prod.setSku(sku);
				prod.setDescription(desc);
				prod.setCategory(chosenCat);
				prod.setQty(qty);
				prod.setPrice(price);

				ActivityLogs logs = new ActivityLogs();
				logs.setSku(sku);
				logs.setDescription(desc);
				logs.setActivity("Stock in");
				logs.setQty(qty);
				logs.setChangeBy(stockinby);
				logs.setRemarks(remarks);

				saveToDatabase(prod);
				saveToDatabase(logs);
				table_load("product", inventoryTable);
				table_load("activitylogs", logsTable);

				skuField.setText("");
				descField.setText("");
				stockbyField.setText("");
				qtyField.setText("");
				priceField.setText("");
				addnewprodRemarks.setText("");

			} else {
				JOptionPane.showMessageDialog(null, "Please input all the necessary information");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addStock() {
		try {

			String sku, desc, qty, changeby, remarks;
			sku = addstockSkuField.getText();
			desc = adddescField.getText();
			changeby = stockInbyField.getText();
			remarks = addStockTextArea.getText();
			String addqty = addqtyField.getText();

			if (addqty.isEmpty() || changeby.isEmpty()) {
				throw new Exception();
			}

			int addQtyVal = Integer.parseInt(addqty);
			int currQtyVal = Integer.parseInt(currQtyField.getText());
			if (addQtyVal > 0) {

				currQtyVal += addQtyVal;
				updateStockQty(currQtyVal, sku);

				ActivityLogs logs = new ActivityLogs();
				logs.setSku(sku);
				logs.setDescription(desc);
				logs.setActivity("Stock in");
				logs.setQty(addqty);
				logs.setChangeBy(changeby);
				logs.setRemarks(remarks);

				saveToDatabase(logs);
				table_load("product", inventoryTable);
				table_load("activitylogs", logsTable);

				JOptionPane.showMessageDialog(null, "Stock added successfully!");

				currQtyField.setText(currQtyVal + "");
				stockInbyField.setText("");
				addqtyField.setText("");
				addStockTextArea.setText("");
				super.skuSearched = "";

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

	public void removeStock() {
		try {
			String sku, desc, qty, changeby, remarks;

			sku = inventorySF.getText();

			desc = descremField.getText();
			qty = qtyremField.getText();
			changeby = rembyField.getText();
			remarks = remarksArea.getText();

			String remqty = remQty.getText();

			if (changeby.isEmpty() || remarks.isEmpty()) {
				throw new Exception();
			}

			int remQtyVal = Integer.parseInt(remqty);
			int currQtyVal = Integer.parseInt(qty);
			int newQtyVal = currQtyVal - remQtyVal;

			if (remQtyVal > 0 && currQtyVal > 0 && newQtyVal >= 0) {

				updateStockQty(newQtyVal, sku);

				ActivityLogs logs = new ActivityLogs();
				logs.setSku(sku);
				logs.setDescription(desc);
				logs.setActivity("Stock removal");
				logs.setQty(remqty);
				logs.setChangeBy(changeby);
				logs.setRemarks(remarks);

				saveToDatabase(logs);
				table_load("product", inventoryTable);
				table_load("activitylogs", logsTable);

				JOptionPane.showMessageDialog(null, "Stock removed successfully!");

				qtyremField.setText(newQtyVal + "");
				rembyField.setText("");
				remQty.setText("");
				remarksArea.setText("");
				super.skuSearched = "";
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

			if (changeby.isEmpty() || remarks.isEmpty()) {
				throw new Exception();
			}

			ActivityLogs logs = new ActivityLogs();
			logs.setSku(sku);
			logs.setDescription(desc);
			logs.setActivity("Deleted product");
			logs.setQty(qtyremField.getText());
			logs.setChangeBy(changeby);
			logs.setRemarks(remarks);
			saveToDatabase(logs);

			deleteRow("product", "SKU", inventorySF.getText());
			table_load("product", inventoryTable);
			table_load("activitylogs", logsTable);

			inventorySF.setText("");
			descremField.setText("");
			rembyField.setText("");
			remarksArea.setText("");
		} catch (Exception f) {
			JOptionPane.showMessageDialog(null, "Please input the necessary information");
		}

	}

	void Initialization(){
		JFrame frame = new JFrame();
		frame.setTitle("Admin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1451, 805);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		header.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(78, 78, 78), new Color(70, 70, 70)));
		header.setBackground(new Color(48, 62, 71));
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Controls");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				IDandPasswords idAndPass = new IDandPasswords();
				try {
					LoginPage loginpage = new LoginPage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(36, 49, 55));
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_header.createSequentialGroup()
					.addGap(62)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 801, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_header.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel_1))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		header.setLayout(gl_header);
		
		JPanel body = new JPanel();
		body.setBackground(new Color(48, 62, 71));
		contentPane.add(body, BorderLayout.CENTER);
		body.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1405, 608);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setBackground(new Color(36, 49, 55));
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel invPn = new JPanel();
		tabbedPane.addTab("Inventory", null, invPn, null);
		
		JLabel lblNewLabel_2 = new JLabel("Inventory");
		lblNewLabel_2.setBounds(10, 11, 123, 31);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		inventorySF = new JTextField();
		inventorySF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inventorySF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_ENTER) {
					
					skuSearch(inventorySF, descremField,  qtyremField);
		
				}
			}
		});
		inventorySF.setBounds(10, 54, 294, 23);
		inventorySF.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skuSearch(inventorySF, descremField, qtyremField);
			}
		});
		btnSearch.setBounds(314, 54, 84, 23);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBackground(new Color(187, 214, 249));
		
		JLabel lblNewLabel_4 = new JLabel("View by category:");
		lblNewLabel_4.setBounds(424, 54, 123, 19);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		viewCB = new JComboBox(category.getCategoryArray());
		viewCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortView("product","Category",viewCB, inventoryTable);
			}
		});
		viewCB.addItem(viewAll);
		
		viewCB.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		viewCB.setBounds(551, 54, 133, 22);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 952, 476);
		
		JPanel removePn = new JPanel();
		removePn.setBounds(987, 88, 403, 476);
		removePn.setBackground(new Color(187, 214, 249));
		
		JLabel lblNewLabel_7 = new JLabel("Remove product");
		lblNewLabel_7.setBounds(10, 11, 115, 17);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_8 = new JLabel("Description:");
		lblNewLabel_8.setBounds(20, 71, 73, 17);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		descremField = new JTextField();
		descremField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		descremField.setBounds(112, 66, 250, 27);
		descremField.setEditable(false);
		descremField.setColumns(10);
		
		rembyField = new JTextField();
		rembyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rembyField.setBounds(112, 104, 250, 27);
		rembyField.setColumns(10);
		
		JLabel lblNewLabel_8_1 = new JLabel("Removed by:");
		lblNewLabel_8_1.setBounds(10, 109, 84, 17);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		qtyremField = new JTextField();
		qtyremField.setEditable(false);
		qtyremField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		qtyremField.setBounds(112, 142, 66, 27);
		qtyremField.setColumns(10);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Crurrent Qty:");
		lblNewLabel_8_1_1.setBounds(10, 147, 85, 17);
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("Remarks:");
		lblNewLabel_8_1_1_1.setBounds(36, 182, 58, 17);
		lblNewLabel_8_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnRemoveProd = new JButton("Remove");
		btnRemoveProd.setBackground(new Color(201, 242, 168));
		btnRemoveProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm Dialog",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				
				if(result == JOptionPane.YES_OPTION) {
					
					if(chkRemProd.isSelected()) {
						deleteProduct();
					}else {
						removeStock();
					}
					
				}
				
			}
		});
		btnRemoveProd.setBounds(115, 386, 247, 33);
		
		JLabel lblNewLabel_9 = new JLabel("Select the product from the table");
		lblNewLabel_9.setBounds(10, 34, 216, 14);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		inventoryTable = new JTable();
		inventoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		inventoryTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = inventoryTable.getSelectedRow();
					String Table_click = (inventoryTable.getModel().getValueAt(row, 0).toString());
					pst = con.prepareStatement("select * from product where SKU ='"+Table_click+"'  ");
					rs = pst.executeQuery();
					
					if(rs.next()) {
						String add1 = rs.getString("SKU");
						inventorySF.setText(add1);
						String add2 = rs.getString("Description");
						descremField.setText(add2);
						String add3 = rs.getString("Qty");
						String add4 = rs.getString("Price");
						String totp = rs.getString("price");
						qtyremField.setText(add3);
						
						addstockSkuField.setText(add1);
						adddescField.setText(add2);
						currQtyField.setText(add3);
						
						PopUp frame = new PopUp();
						frame.setVisible(true);
						
						frame.setSku(Table_click);
						frame.setdesc(add2);
						frame.setprice(add4);
					
						
					}
					
				}catch(Exception f) {
					JOptionPane.showMessageDialog(null, "Click table row");
				}
				
			}
		});
		inventoryTable.setFillsViewportHeight(true);
		inventoryTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inventoryTable.setBackground(new Color(255, 255, 255));
		inventoryTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(inventoryTable);
		invPn.setLayout(null);
		invPn.add(removePn);
		removePn.setLayout(null);
		removePn.add(lblNewLabel_7);
		removePn.add(lblNewLabel_8);
		removePn.add(descremField);
		removePn.add(rembyField);
		removePn.add(lblNewLabel_8_1);
		removePn.add(qtyremField);
		removePn.add(lblNewLabel_8_1_1);
		removePn.add(lblNewLabel_8_1_1_1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(112, 180, 250, 195);
		removePn.add(scrollPane_4);
		
		remarksArea = new JTextArea();
		scrollPane_4.setViewportView(remarksArea);
		removePn.add(btnRemoveProd);
		removePn.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8_1_1_2 = new JLabel("remove Qty:");
		lblNewLabel_8_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_1_1_2.setBounds(204, 147, 84, 17);
		removePn.add(lblNewLabel_8_1_1_2);
		
		remQty = new JTextField();
		remQty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		remQty.setColumns(10);
		remQty.setBounds(289, 142, 73, 27);
		removePn.add(remQty);
		
		chkRemProd = new JCheckBox("Delete product");
		chkRemProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkRemProd.isSelected()) {
					remQty.setEditable(false);
					remQty.setText("");
				}else {
					remQty.setEditable(true);
				}
			}
		});
		chkRemProd.setBounds(239, 30, 123, 23);
		removePn.add(chkRemProd);
		invPn.add(scrollPane);
		invPn.add(lblNewLabel_2);
		invPn.add(inventorySF);
		invPn.add(btnSearch);
		invPn.add(lblNewLabel_4);
		invPn.add(viewCB);
		
		JLabel lblNewLabel_10 = new JLabel("SKU search");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_10.setBounds(10, 39, 64, 14);
		invPn.add(lblNewLabel_10);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(new Color(201, 242, 168));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load("product",inventoryTable);
			}
		});
		btnRefresh.setBounds(694, 54, 89, 23);
		invPn.add(btnRefresh);
		
		JPanel stockinPn = new JPanel();
		tabbedPane.addTab("Stock In", null, stockinPn, null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Stock In");
		lblNewLabel_2_1.setBounds(10, 11, 123, 31);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JPanel newProdPn = new JPanel();
		newProdPn.setBounds(10, 48, 629, 516);
		newProdPn.setBackground(new Color(187, 214, 249));
		
		JPanel addstockPn = new JPanel();
		addstockPn.setBounds(649, 48, 741, 516);
		addstockPn.setBackground(new Color(187, 214, 249));
		
		JLabel lblNewLabel_3_1 = new JLabel("ADD STOCK");
		lblNewLabel_3_1.setBounds(10, 11, 99, 19);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		addstockSkuField = new JTextField();
		addstockSkuField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_ENTER) {
					
					skuSearch(addstockSkuField, adddescField, currQtyField);
					
				}
			}
		});
		addstockSkuField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addstockSkuField.setBounds(10, 65, 346, 28);
		addstockSkuField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				skuSearch(addstockSkuField, adddescField, currQtyField);
				
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(221, 221, 221));
		btnNewButton_2.setBounds(374, 66, 88, 26);
		
		JLabel lblNewLabel_6 = new JLabel("Enter SKU:");
		lblNewLabel_6.setBounds(10, 35, 71, 19);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_5_1_2 = new JLabel("Description:");
		lblNewLabel_5_1_2.setBounds(76, 107, 107, 25);
		lblNewLabel_5_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		adddescField = new JTextField();
		adddescField.setEditable(false);
		adddescField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adddescField.setBounds(193, 104, 346, 28);
		adddescField.setColumns(10);
		
		addqtyField = new JTextField();
		addqtyField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_ENTER) {
					addStock();
				}
			}
		});
		addqtyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addqtyField.setBounds(193, 224, 160, 28);
		addqtyField.setColumns(10);
		
		JLabel lblNewLabel_5_1_2_1 = new JLabel("Add Qty:");
		lblNewLabel_5_1_2_1.setBounds(101, 223, 82, 25);
		lblNewLabel_5_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		stockInbyField = new JTextField();
		stockInbyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stockInbyField.setBounds(193, 183, 346, 28);
		stockInbyField.setColumns(10);
		
		JLabel lblNewLabel_5_1_2_2 = new JLabel("Stock in by:");
		lblNewLabel_5_1_2_2.setBounds(76, 183, 107, 25);
		lblNewLabel_5_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		stockinPn.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("ADD NEW PRODUCT");
		lblNewLabel_3.setBounds(10, 11, 150, 19);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_5 = new JLabel("SKU:");
		lblNewLabel_5.setBounds(118, 44, 43, 25);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		skuField = new JTextField();
		skuField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		skuField.setBounds(171, 41, 421, 28);
		skuField.setColumns(10);
		
		descField = new JTextField();
		descField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		descField.setBounds(171, 88, 421, 28);
		descField.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Description:");
		lblNewLabel_5_1.setBounds(54, 87, 107, 25);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		stockbyField = new JTextField();
		stockbyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stockbyField.setBounds(171, 135, 421, 28);
		stockbyField.setColumns(10);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Stock in by:");
		lblNewLabel_5_1_1.setBounds(54, 135, 107, 25);
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Qty:");
		lblNewLabel_5_1_1_1.setBounds(121, 252, 38, 25);
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		priceField = new JTextField();
		priceField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		priceField.setColumns(10);
		priceField.setBounds(170, 213, 170, 28);
		newProdPn.add(priceField);
		
		qtyField = new JTextField();
		qtyField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_ENTER) {
					saveToDataBase();
				}
			}
		});
		qtyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		qtyField.setBounds(170, 253, 170, 28);
		qtyField.setColumns(10);
		
		JButton btnAddProd = new JButton("Add product");
		btnAddProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveToDataBase();
			}
		});
		btnAddProd.setBounds(170, 442, 170, 37);
		btnAddProd.setBackground(new Color(201, 242, 168));
		btnAddProd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		stockinPn.add(newProdPn);
		newProdPn.setLayout(null);
		newProdPn.add(lblNewLabel_3);
		newProdPn.add(btnAddProd);
		newProdPn.add(lblNewLabel_5_1_1_1);
		newProdPn.add(lblNewLabel_5);
		newProdPn.add(lblNewLabel_5_1);
		newProdPn.add(lblNewLabel_5_1_1);
		newProdPn.add(stockbyField);
		newProdPn.add(descField);
		newProdPn.add(skuField);
		newProdPn.add(qtyField);
		
		
		
		JLabel lblNewLabel_5_1_1_2 = new JLabel("Price:");
		lblNewLabel_5_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_2.setBounds(109, 209, 50, 25);
		newProdPn.add(lblNewLabel_5_1_1_2);
		
		JComboBox catCb = new JComboBox(category.getCategoryArray());
		catCb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		catCb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String chosen = (String) catCb.getSelectedItem();
				if(chosen.contains(category.getCategoryByIndex(0))) {
					chosenCat = category.getCategoryByIndex(0);
				}
				else if(chosen.contains(category.getCategoryByIndex(1))) {
					chosenCat = category.getCategoryByIndex(1);
				}
				else if(chosen.contains(category.getCategoryByIndex(2))) {
					chosenCat = category.getCategoryByIndex(2);
				}
				else if(chosen.contains(category.getCategoryByIndex(3))) {
					chosenCat = category.getCategoryByIndex(3);
				}
				else if(chosen.contains(category.getCategoryByIndex(4))) {
					chosenCat = category.getCategoryByIndex(4);
				}
				else if(chosen.contains(category.getCategoryByIndex(5))) {
					chosenCat = category.getCategoryByIndex(5);
				}
				
			}
			
		});
		catCb.setBounds(170, 174, 170, 28);
		newProdPn.add(catCb);
		
		JLabel lblNewLabel_5_1_1_2_1 = new JLabel("Category:");
		lblNewLabel_5_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_2_1.setBounds(73, 173, 87, 25);
		newProdPn.add(lblNewLabel_5_1_1_2_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(170, 292, 422, 139);
		newProdPn.add(scrollPane_3);
		
		addnewprodRemarks = new JTextArea();
		scrollPane_3.setViewportView(addnewprodRemarks);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Remarks:");
		lblNewLabel_5_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_1_1.setBounds(73, 292, 87, 25);
		newProdPn.add(lblNewLabel_5_1_1_1_1);
		stockinPn.add(addstockPn);
		addstockPn.setLayout(null);
		addstockPn.add(lblNewLabel_3_1);
		addstockPn.add(addstockSkuField);
		addstockPn.add(btnNewButton_2);
		addstockPn.add(lblNewLabel_6);
		
		addstockPn.add(lblNewLabel_5_1_2);
		addstockPn.add(lblNewLabel_5_1_2_2);
		addstockPn.add(stockInbyField);
		addstockPn.add(adddescField);
		addstockPn.add(lblNewLabel_5_1_2_1);
		addstockPn.add(addqtyField);
		
		currQtyField = new JTextField();
		currQtyField.setEditable(false);
		currQtyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		currQtyField.setColumns(10);
		currQtyField.setBounds(193, 144, 160, 28);
		addstockPn.add(currQtyField);
		
		JButton btnAddStock = new JButton("Add stock\r\n");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStock();
			}
		});

		btnAddStock.setBounds(193, 442, 170, 37);
		btnAddStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddStock.setBackground(new Color(201, 242, 168));
		addstockPn.add(btnAddStock);
		JLabel lblNewLabel_5_1_2_3 = new JLabel("Current Qty:");
		lblNewLabel_5_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_2_3.setBounds(73, 147, 110, 25);
		addstockPn.add(lblNewLabel_5_1_2_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(193, 263, 346, 168);
		addstockPn.add(scrollPane_2);
		
		addStockTextArea = new JTextArea();
		scrollPane_2.setViewportView(addStockTextArea);
		
		JLabel lblNewLabel_5_1_2_1_1 = new JLabel("Remarks:");
		lblNewLabel_5_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_2_1_1.setBounds(95, 259, 88, 25);
		addstockPn.add(lblNewLabel_5_1_2_1_1);
		stockinPn.add(lblNewLabel_2_1);
		
		JPanel activityHistoPn = new JPanel();
		tabbedPane.addTab("Activity Logs", null, activityHistoPn, null);
		activityHistoPn.setLayout(null);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Admin Activity Logs");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1_1.setBounds(10, 11, 280, 31);
		activityHistoPn.add(lblNewLabel_2_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 87, 1183, 383);
		activityHistoPn.add(scrollPane_1);
		
		logsTable = new JTable();
		scrollPane_1.setViewportView(logsTable);
		
		JButton btnRefreshLogs = new JButton("Refresh");
		btnRefreshLogs.setBackground(new Color(201, 242, 168));
		btnRefreshLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load("activitylogs", logsTable);
			}
		});
		btnRefreshLogs.setBounds(303, 53, 89, 23);
		activityHistoPn.add(btnRefreshLogs);
		
		JComboBox viewByAct = new JComboBox(actType.getActArray());	
		viewByAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortView("activitylogs","Activity",viewByAct, logsTable);
			}
		});
		viewByAct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewByAct.setBounds(137, 53, 133, 22);
		activityHistoPn.add(viewByAct);
		
		JLabel lblNewLabel_4_1 = new JLabel("View by activity:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(10, 53, 123, 19);
		activityHistoPn.add(lblNewLabel_4_1);
		
		JButton btnDeleteLogs = new JButton("Delete all");
		btnDeleteLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all data in this table?", "Confirm Dialog",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				
				if(result == JOptionPane.YES_OPTION) {
					deleteAllData("activitylogs");
					table_load("activitylogs", logsTable);
				}
				
			}
		});
		btnDeleteLogs.setBounds(1104, 53, 89, 23);
		activityHistoPn.add(btnDeleteLogs);
		
		JPanel clientRecPn = new JPanel();
		tabbedPane.addTab("Client Records", null, clientRecPn, null);
		clientRecPn.setLayout(null);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Client Records");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1_1_1.setBounds(10, 11, 280, 31);
		clientRecPn.add(lblNewLabel_2_1_1_1);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 88, 1183, 382);
		clientRecPn.add(scrollPane_5);
		
		clientRecordsTable = new JTable();
		scrollPane_5.setViewportView(clientRecordsTable);
		
		JButton btnDeleteClientRecords = new JButton("Delete all");
		btnDeleteClientRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all data in this table?", "Confirm Dialog",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				
				if(result == JOptionPane.YES_OPTION) {
					deleteAllData("clientrecords");
					table_load("clientrecords", clientRecordsTable);
				}
			}
		});
		btnDeleteClientRecords.setBounds(10, 54, 89, 23);
		clientRecPn.add(btnDeleteClientRecords);
		body.add(tabbedPane);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

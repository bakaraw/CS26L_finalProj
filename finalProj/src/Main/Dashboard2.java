/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import utils.ActivityLogs;
import utils.DatabaseHandler;
import utils.Product;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Dashboard2 extends javax.swing.JFrame {

	public Dashboard2() {
		windowStart();
		initComponents();
		setLocationRelativeTo(null);
	}

	
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		databaseHandler = new DatabaseHandler();
		DashboardPanel = new JPanel();
		SlidingMenu = new javax.swing.JPanel();
		HideMenu = new javax.swing.JLabel();
		HideMenu.setForeground(new Color(255, 255, 255));
		StockSales = new javax.swing.JLabel();
		Inventory = new javax.swing.JLabel();
		StockIn = new javax.swing.JLabel();
		ActivityLogs = new javax.swing.JLabel();
		ClientRecords = new javax.swing.JLabel();
		LogOut = new javax.swing.JLabel();
		BitMonke = new javax.swing.JLabel();
		OpenMenu = new javax.swing.JLabel();
		OpenMenu.setForeground(new Color(43, 52, 59));
		Bar = new javax.swing.JLabel();
		layeredPane = new javax.swing.JLayeredPane();
		InventoryPanel = new javax.swing.JPanel();
		ActivityLogsPanel = new javax.swing.JPanel();
		ClientRecordsPanel = new javax.swing.JPanel();
		StockInPanel = new javax.swing.JPanel();
		SalesReportPanel = new javax.swing.JPanel();
		
		databaseHandler.Connect();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		DashboardPanel.setBackground(new java.awt.Color(204, 204, 204));

		SlidingMenu.setBackground(new Color(43, 52, 59));
		SlidingMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(51, 51, 51)));

		HideMenu.setBackground(new Color(43, 52, 59));
		HideMenu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		HideMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/hide_1.png"))); // NOI18N
		HideMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		HideMenu.setOpaque(true);
		HideMenu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				HideMenuMouseReleased(evt);
			}
		});

		StockSales.setBackground(new Color(43, 52, 59));
		StockSales.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
		StockSales.setForeground(new Color(255, 255, 255));
		StockSales.setText("     Sales Report");
		StockSales.setOpaque(true);
		StockSales.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				StockSalesMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				StockSalesMouseExited(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				StockSalesMouseReleased(evt);
			}
		});

		Inventory.setBackground(new Color(43, 52, 59));
		Inventory.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
		Inventory.setForeground(new Color(255, 255, 255));
		Inventory.setText("     Inventory");
		Inventory.setOpaque(true);
		Inventory.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				InventoryMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				InventoryMouseExited(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				InventoryMouseReleased(evt);
			}
		});

		StockIn.setBackground(new Color(43, 52, 59));
		StockIn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
		StockIn.setForeground(new Color(255, 255, 255));
		StockIn.setText("     Stock In");
		StockIn.setOpaque(true);
		StockIn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				StockInMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				StockInMouseExited(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				StockInMouseReleased(evt);
			}
		});

		ActivityLogs.setBackground(new Color(43, 52, 59));
		ActivityLogs.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
		ActivityLogs.setForeground(new Color(255, 255, 255));
		ActivityLogs.setText("     Activity Logs");
		ActivityLogs.setOpaque(true);
		ActivityLogs.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				ActivityLogsMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				ActivityLogsMouseExited(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				ActivityLogsMouseReleased(evt);
			}
		});

		ClientRecords.setBackground(new Color(43, 52, 59));
		ClientRecords.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
		ClientRecords.setForeground(new Color(255, 255, 255));
		ClientRecords.setText("     Client Records");
		ClientRecords.setOpaque(true);
		ClientRecords.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				ClientRecordsMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				ClientRecordsMouseExited(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				ClientRecordsMouseReleased(evt);
			}
		});

		LogOut.setBackground(new Color(43, 52, 59));
		LogOut.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
		LogOut.setForeground(new Color(255, 255, 255));
		LogOut.setText("     Log out");
		LogOut.setOpaque(true);
		LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				LogOutMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				LogOutMouseExited(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				LogOutMouseReleased(evt);
			}
		});

		BitMonke.setBackground(new Color(43, 52, 59));
		BitMonke.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
		BitMonke.setForeground(new Color(255, 255, 255));
		BitMonke.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		BitMonke.setText("BitMonke");
		BitMonke.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 102, 102)));

		javax.swing.GroupLayout SlidingMenuLayout = new javax.swing.GroupLayout(SlidingMenu);
		SlidingMenu.setLayout(SlidingMenuLayout);
		SlidingMenuLayout.setHorizontalGroup(SlidingMenuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(HideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 258,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGroup(SlidingMenuLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(BitMonke,
						javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(StockSales, javax.swing.GroupLayout.PREFERRED_SIZE, 258,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(Inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 258,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(StockIn, javax.swing.GroupLayout.PREFERRED_SIZE, 258,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(ActivityLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 258,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(ClientRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 258,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 258,
						javax.swing.GroupLayout.PREFERRED_SIZE));
		SlidingMenuLayout
				.setVerticalGroup(
						SlidingMenuLayout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(SlidingMenuLayout.createSequentialGroup()
										.addComponent(HideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(6, 6, 6)
										.addComponent(BitMonke, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(StockSales, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(6, 6, 6)
										.addComponent(Inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(6, 6, 6)
										.addComponent(StockIn, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(6, 6, 6)
										.addComponent(ActivityLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(6, 6, 6)
										.addComponent(ClientRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(6, 6, 6)
										.addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		OpenMenu.setBackground(new Color(43, 52, 59));
		OpenMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		OpenMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/menu (1).png"))); // NOI18N
		OpenMenu.setOpaque(true);
		OpenMenu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				OpenMenuMouseReleased(evt);
			}
		});

		Bar.setBackground(new Color(43, 52, 59));
		Bar.setOpaque(true);

		layeredPane.setLayout(new java.awt.CardLayout());

		InventoryPanel.setBackground(new Color(255, 255, 255));
		
		removePn = new JPanel();
		removePn.setLayout(null);
		removePn.setBackground(new Color(187, 214, 249));
		
		lblNewLabel = new JLabel("Remove product");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 115, 17);
		removePn.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Description:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 71, 73, 17);
		removePn.add(lblNewLabel_1);
		
		descremField = new JTextField();
		descremField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		descremField.setEditable(false);
		descremField.setColumns(10);
		descremField.setBounds(112, 66, 250, 27);
		removePn.add(descremField);
		
		rembyField = new JTextField();
		rembyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rembyField.setColumns(10);
		rembyField.setBounds(112, 104, 250, 27);
		removePn.add(rembyField);
		
		lblNewLabel_8 = new JLabel("Removed by:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 109, 84, 17);
		removePn.add(lblNewLabel_8);
		
		qtyremField = new JTextField();
		qtyremField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		qtyremField.setEditable(false);
		qtyremField.setColumns(10);
		qtyremField.setBounds(112, 142, 66, 27);
		removePn.add(qtyremField);
		
		lblNewLabel_8_1 = new JLabel("Crurrent Qty:");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_1.setBounds(10, 147, 85, 17);
		removePn.add(lblNewLabel_8_1);
		
		lblNewLabel_8_1_1 = new JLabel("Remarks:");
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_1_1.setBounds(36, 182, 58, 17);
		removePn.add(lblNewLabel_8_1_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 180, 250, 195);
		removePn.add(scrollPane);
		
		remarksArea = new JTextArea();
		scrollPane.setViewportView(remarksArea);
		
		btnRemoveProd = new JButton("Remove");
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
		btnRemoveProd.setBackground(new Color(201, 242, 168));
		btnRemoveProd.setBounds(115, 386, 247, 33);
		removePn.add(btnRemoveProd);
		
		lblNewLabel_2 = new JLabel("Select the product from the table");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setBounds(10, 34, 216, 14);
		removePn.add(lblNewLabel_2);
		
		lblNewLabel_8_1_1_1 = new JLabel("remove Qty:");
		lblNewLabel_8_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_1_1_1.setBounds(204, 147, 84, 17);
		removePn.add(lblNewLabel_8_1_1_1);
		
		remQty = new JTextField();
		remQty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		remQty.setColumns(10);
		remQty.setBounds(289, 142, 73, 27);
		removePn.add(remQty);
		
		chkRemProd = new JCheckBox("Delete product");
		chkRemProd.setBounds(239, 30, 123, 23);
		removePn.add(chkRemProd);
		
		lblNewLabel_3 = new JLabel("Inventory");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		inventorySF = new JTextField();
		inventorySF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inventorySF.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databaseHandler.skuSearch(inventorySF, descremField, qtyremField);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBackground(new Color(187, 214, 249));
		
		lblNewLabel_4 = new JLabel("View by category:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		viewCB = new JComboBox(category.getCategoryArray());
		viewCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databaseHandler.sortView("product","Category",viewCB, inventoryTable);
			}
		});
		viewCB.addItem("All");
		viewCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNewLabel_5 = new JLabel("SKU search");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databaseHandler.table_load("product",inventoryTable);
			}
		});
		btnRefresh.setBackground(new Color(201, 242, 168));
		
		scrollPane_1 = new JScrollPane();
		
		btnNewButton = new JButton("Add Product");
		
		btnNewButton_1 = new JButton("Stock in");
		
		btnNewButton_3 = new JButton("Remove");

		javax.swing.GroupLayout InventoryPanelLayout = new javax.swing.GroupLayout(InventoryPanel);
		InventoryPanelLayout.setHorizontalGroup(
			InventoryPanelLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(InventoryPanelLayout.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
						.addGroup(InventoryPanelLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 938, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(removePn, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE))
						.addGroup(InventoryPanelLayout.createSequentialGroup()
							.addComponent(inventorySF, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(viewCB, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnRefresh)
							.addGap(66)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_3)))
					.addGap(21))
		);
		InventoryPanelLayout.setVerticalGroup(
			InventoryPanelLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(InventoryPanelLayout.createSequentialGroup()
					.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(InventoryPanelLayout.createSequentialGroup()
							.addContainerGap(57, Short.MAX_VALUE)
							.addComponent(lblNewLabel_5)
							.addGap(1)
							.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSearch)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(viewCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnRefresh)
									.addComponent(btnNewButton)
									.addComponent(btnNewButton_1)
									.addComponent(btnNewButton_3))
								.addComponent(inventorySF, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
						.addGroup(InventoryPanelLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(50)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(removePn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
					.addGap(20))
		);
		
		inventoryTable = new JTable();
		inventoryTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = inventoryTable.getSelectedRow();
					String Table_click = (inventoryTable.getModel().getValueAt(row, 0).toString());
					databaseHandler.pst = databaseHandler.con.prepareStatement("select * from product where SKU ='"+Table_click+"'  ");
					databaseHandler.rs = databaseHandler.pst.executeQuery();
					
					if(databaseHandler.rs.next()) {
						String add1 = databaseHandler.rs.getString("SKU");
						inventorySF.setText(add1);
						String add2 = databaseHandler.rs.getString("Description");
						descremField.setText(add2);
						String add3 = databaseHandler.rs.getString("Qty");
						qtyremField.setText(add3);
//						
//						addstockSkuField.setText(add1);
//						adddescField.setText(add2);
//						currQtyField.setText(add3);
						
					}
					
				}catch(Exception f) {
					JOptionPane.showMessageDialog(null, "Click table row");
				}
			}
		});
		scrollPane_1.setViewportView(inventoryTable);
		databaseHandler.table_load("product", inventoryTable);
		InventoryPanel.setLayout(InventoryPanelLayout);

		layeredPane.add(InventoryPanel, "card3");

		ActivityLogsPanel.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Admin Activity Logs");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_4_1 = new JLabel("View by activity:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox viewByAct = new JComboBox(new ActivityLogs().getActArray());
		viewByAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databaseHandler.sortView("activitylogs","Activity",viewByAct, logsTable);
			}
		});
		viewByAct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnRefreshLogs = new JButton("Refresh");
		btnRefreshLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databaseHandler.table_load("activitylogs", logsTable);
			}
		});
		btnRefreshLogs.setBackground(new Color(201, 242, 168));
		
		JButton btnDeleteLogs = new JButton("Delete all");
		
		JScrollPane scrollPane_actLogs = new JScrollPane();

		javax.swing.GroupLayout ActivityLogsPanelLayout = new javax.swing.GroupLayout(ActivityLogsPanel);
		ActivityLogsPanelLayout.setHorizontalGroup(
			ActivityLogsPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(ActivityLogsPanelLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(ActivityLogsPanelLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_actLogs, GroupLayout.PREFERRED_SIZE, 1343, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
						.addGroup(ActivityLogsPanelLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(viewByAct, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnRefreshLogs)
							.addGap(70)
							.addComponent(btnDeleteLogs)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		ActivityLogsPanelLayout.setVerticalGroup(
			ActivityLogsPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(ActivityLogsPanelLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(ActivityLogsPanelLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(ActivityLogsPanelLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(viewByAct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(ActivityLogsPanelLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRefreshLogs)
							.addComponent(btnDeleteLogs)))
					.addGap(15)
					.addComponent(scrollPane_actLogs, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		logsTable = new JTable();
		scrollPane_actLogs.setViewportView(logsTable);
		databaseHandler.table_load("activitylogs", logsTable);
		ActivityLogsPanel.setLayout(ActivityLogsPanelLayout);

		layeredPane.add(ActivityLogsPanel, "card4");

		ClientRecordsPanel.setBackground(new Color(255, 255, 255));
		
		scrollPane_4 = new JScrollPane();
		
		btnDeleteClientRecords = new JButton("Delete all");
		
		lblNewLabel_2_1_1_1 = new JLabel("Client Records");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));

		javax.swing.GroupLayout ClientRecordsPanelLayout = new javax.swing.GroupLayout(ClientRecordsPanel);
		ClientRecordsPanelLayout.setHorizontalGroup(
			ClientRecordsPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(ClientRecordsPanelLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(ClientRecordsPanelLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteClientRecords)
						.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 1346, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		ClientRecordsPanelLayout.setVerticalGroup(
			ClientRecordsPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(ClientRecordsPanelLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnDeleteClientRecords)
					.addGap(11)
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		clientRecordsTable = new JTable();
		scrollPane_4.setViewportView(clientRecordsTable);
		databaseHandler.table_load("clientrecords", clientRecordsTable);
		ClientRecordsPanel.setLayout(ClientRecordsPanelLayout);

		layeredPane.add(ClientRecordsPanel, "card5");

		StockInPanel.setBackground(new Color(255, 255, 255));
		
		JPanel newProdPn = new JPanel();
		newProdPn.setLayout(null);
		newProdPn.setBackground(new Color(187, 214, 249));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(170, 213, 170, 28);
		newProdPn.add(textField);
		
		JLabel lblNewLabel_3_1 = new JLabel("ADD NEW PRODUCT");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(10, 11, 150, 19);
		newProdPn.add(lblNewLabel_3_1);
		
		JButton btnAddProd = new JButton("Add product");
		btnAddProd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddProd.setBackground(new Color(201, 242, 168));
		btnAddProd.setBounds(170, 442, 170, 37);
		newProdPn.add(btnAddProd);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Qty:");
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_1.setBounds(121, 252, 38, 25);
		newProdPn.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("SKU:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1.setBounds(118, 44, 43, 25);
		newProdPn.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Description:");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1.setBounds(54, 87, 107, 25);
		newProdPn.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_1_2 = new JLabel("Stock in by:");
		lblNewLabel_5_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_2.setBounds(54, 135, 107, 25);
		newProdPn.add(lblNewLabel_5_1_1_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(171, 135, 421, 28);
		newProdPn.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(171, 88, 421, 28);
		newProdPn.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(171, 41, 421, 28);
		newProdPn.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(170, 253, 170, 28);
		newProdPn.add(textField_4);
		
		JLabel lblNewLabel_5_1_1_2_1 = new JLabel("Price:");
		lblNewLabel_5_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_2_1.setBounds(109, 209, 50, 25);
		newProdPn.add(lblNewLabel_5_1_1_2_1);
		
		JComboBox catCb = new JComboBox(new Object[]{});
		catCb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		catCb.setBounds(170, 174, 170, 28);
		newProdPn.add(catCb);
		
		JLabel lblNewLabel_5_1_1_2_1_1 = new JLabel("Category:");
		lblNewLabel_5_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_2_1_1.setBounds(73, 173, 87, 25);
		newProdPn.add(lblNewLabel_5_1_1_2_1_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(170, 292, 422, 139);
		newProdPn.add(scrollPane_3);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Remarks:");
		lblNewLabel_5_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_1_1.setBounds(73, 292, 87, 25);
		newProdPn.add(lblNewLabel_5_1_1_1_1);
		
		JPanel addstockPn = new JPanel();
		addstockPn.setLayout(null);
		addstockPn.setBackground(new Color(187, 214, 249));
		
		JLabel lblNewLabel_3_1_1 = new JLabel("ADD STOCK");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(10, 11, 99, 19);
		addstockPn.add(lblNewLabel_3_1_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(10, 65, 346, 28);
		addstockPn.add(textField_5);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(new Color(221, 221, 221));
		btnNewButton_2.setBounds(374, 66, 88, 26);
		addstockPn.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Enter SKU:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 35, 71, 19);
		addstockPn.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("Description:");
		lblNewLabel_5_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_2.setBounds(76, 107, 107, 25);
		addstockPn.add(lblNewLabel_5_1_2);
		
		JLabel lblNewLabel_5_1_2_2 = new JLabel("Stock in by:");
		lblNewLabel_5_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_2_2.setBounds(76, 183, 107, 25);
		addstockPn.add(lblNewLabel_5_1_2_2);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(193, 183, 346, 28);
		addstockPn.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(193, 104, 346, 28);
		addstockPn.add(textField_7);
		
		JLabel lblNewLabel_5_1_2_1 = new JLabel("Add Qty:");
		lblNewLabel_5_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_2_1.setBounds(101, 223, 82, 25);
		addstockPn.add(lblNewLabel_5_1_2_1);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(193, 224, 160, 28);
		addstockPn.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(193, 144, 160, 28);
		addstockPn.add(textField_9);
		
		JButton btnAddStock = new JButton("Add stock\r\n");
		btnAddStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddStock.setBackground(new Color(201, 242, 168));
		btnAddStock.setBounds(193, 442, 170, 37);
		addstockPn.add(btnAddStock);
		
		JLabel lblNewLabel_5_1_2_3 = new JLabel("Current Qty:");
		lblNewLabel_5_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_2_3.setBounds(73, 147, 110, 25);
		addstockPn.add(lblNewLabel_5_1_2_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(193, 263, 346, 168);
		addstockPn.add(scrollPane_2);
		
		JLabel lblNewLabel_5_1_2_1_1 = new JLabel("Remarks:");
		lblNewLabel_5_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_2_1_1.setBounds(95, 259, 88, 25);
		addstockPn.add(lblNewLabel_5_1_2_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Stock In");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 28));

		javax.swing.GroupLayout StockInPanelLayout = new javax.swing.GroupLayout(StockInPanel);
		StockInPanelLayout.setHorizontalGroup(
			StockInPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(StockInPanelLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(StockInPanelLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(StockInPanelLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(StockInPanelLayout.createSequentialGroup()
							.addComponent(newProdPn, GroupLayout.PREFERRED_SIZE, 647, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(addstockPn, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
							.addGap(37))))
		);
		StockInPanelLayout.setVerticalGroup(
			StockInPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(StockInPanelLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(StockInPanelLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(addstockPn, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
						.addComponent(newProdPn, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		StockInPanel.setLayout(StockInPanelLayout);

		layeredPane.add(StockInPanel, "card6");

		SalesReportPanel.setBackground(new Color(255, 255, 255));
		
		JPanel salesReportContentPanel = new JPanel();

		javax.swing.GroupLayout SalesReportPanelLayout = new javax.swing.GroupLayout(SalesReportPanel);
		SalesReportPanelLayout.setHorizontalGroup(
			SalesReportPanelLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, SalesReportPanelLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(salesReportContentPanel, GroupLayout.PREFERRED_SIZE, 1352, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		SalesReportPanelLayout.setVerticalGroup(
			SalesReportPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(SalesReportPanelLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(salesReportContentPanel, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		salesReportContentPanel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Sales Report");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_7.setBounds(34, 11, 302, 34);
		salesReportContentPanel.add(lblNewLabel_7);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(34, 67, 488, 233);
		salesReportContentPanel.add(panel_1);
		
		JLabel lblNewLabel_9 = new JLabel("sales line graph");
		panel_1.add(lblNewLabel_9);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 128));
		panel_2.setBounds(34, 312, 488, 233);
		salesReportContentPanel.add(panel_2);
		
		JLabel lblNewLabel_10 = new JLabel("pie chart");
		panel_2.add(lblNewLabel_10);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 255, 128));
		panel_3.setBounds(532, 63, 810, 482);
		salesReportContentPanel.add(panel_3);
		
		JLabel lblNewLabel_11 = new JLabel("table");
		panel_3.add(lblNewLabel_11);
		SalesReportPanel.setLayout(SalesReportPanelLayout);

		layeredPane.add(SalesReportPanel, "card2");

		javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
		DashboardPanelLayout.setHorizontalGroup(
			DashboardPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(DashboardPanelLayout.createSequentialGroup()
					.addComponent(SlidingMenu, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addGap(0)
					.addGroup(DashboardPanelLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(DashboardPanelLayout.createSequentialGroup()
							.addGap(64)
							.addComponent(Bar, GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE))
						.addGroup(DashboardPanelLayout.createSequentialGroup()
							.addComponent(OpenMenu, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		DashboardPanelLayout.setVerticalGroup(
			DashboardPanelLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(SlidingMenu, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
				.addGroup(DashboardPanelLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(DashboardPanelLayout.createSequentialGroup()
					.addComponent(Bar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(DashboardPanelLayout.createSequentialGroup()
					.addComponent(OpenMenu, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(579, Short.MAX_VALUE))
		);
		DashboardPanel.setLayout(DashboardPanelLayout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(DashboardPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(DashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		switchPanels(SalesReportPanel); // TODO add your handling code here:
	}

	private void OpenMenuMouseReleased(java.awt.event.MouseEvent evt) {

		Thread th = new Thread() {
			public void run() {
				try {
					int width = 26;
					for (int a = 0; a < 10; a++) {
						Thread.sleep(10);
						SlidingMenu.setSize(width, getHeight());
						HideMenu.setSize(width, HideMenu.getHeight());
						width = width + 26;
					}
				} catch (Exception e) {
					String message = "An error has ocurred.";
					JOptionPane.showMessageDialog(rootPane, message);
				}
			}
		};
		th.start();

		// TODO add your handling code here:
	}

	private void HideMenuMouseReleased(java.awt.event.MouseEvent evt) {
		Thread th = new Thread() {
			public void run() {
				try {
					int width = SlidingMenu.getWidth();
					for (int a = 0; a <= 10; a++) {
						Thread.sleep(10);
						SlidingMenu.setSize(width, getHeight());
						width = width - 26;
					}
				} catch (Exception e) {
					String message = "An error has ocurred.";
					JOptionPane.showMessageDialog(rootPane, message);
				}
			}
		};
		th.start(); // TODO add your handling code here:
	}

	private void StockSalesMouseEntered(java.awt.event.MouseEvent evt) {
		StockSales.setBackground(new Color(102, 102, 102)); // TODO add your handling code here:
	}

	private void StockSalesMouseExited(java.awt.event.MouseEvent evt) {
		StockSales.setBackground(new Color(43, 52, 59));
	}

	private void InventoryMouseEntered(java.awt.event.MouseEvent evt) {
		Inventory.setBackground(new Color(102, 102, 102)); // TODO add your handling code here:
	}

	private void InventoryMouseReleased(java.awt.event.MouseEvent evt) {
		switchPanels(InventoryPanel); // TODO add your handling code here:
	}

	private void InventoryMouseExited(java.awt.event.MouseEvent evt) {
		Inventory.setBackground(new Color(43, 52, 59));
	}

	private void StockInMouseEntered(java.awt.event.MouseEvent evt) {
		StockIn.setBackground(new Color(102, 102, 102)); // TODO add your handling code here:
	}

	private void StockInMouseExited(java.awt.event.MouseEvent evt) {
		StockIn.setBackground(new Color(43, 52, 59));
	}

	private void ActivityLogsMouseEntered(java.awt.event.MouseEvent evt) {
		ActivityLogs.setBackground(new Color(102, 102, 102));
	}

	private void ActivityLogsMouseExited(java.awt.event.MouseEvent evt) {
		ActivityLogs.setBackground(new Color(43, 52, 59));
	}

	private void ClientRecordsMouseEntered(java.awt.event.MouseEvent evt) {
		ClientRecords.setBackground(new Color(102, 102, 102));
	}

	private void ClientRecordsMouseExited(java.awt.event.MouseEvent evt) {
		ClientRecords.setBackground(new Color(43, 52, 59));
	}

	private void LogOutMouseEntered(java.awt.event.MouseEvent evt) {
		LogOut.setBackground(new Color(102, 102, 102));
	}

	private void LogOutMouseExited(java.awt.event.MouseEvent evt) {
		LogOut.setBackground(new Color(43, 52, 59));
	}

	private void StockSalesMouseReleased(java.awt.event.MouseEvent evt) {
		switchPanels(SalesReportPanel); // TODO add your handling code here:
	}

	private void StockInMouseReleased(java.awt.event.MouseEvent evt) {
		switchPanels(StockInPanel); // TODO add your handling code here:
	}

	private void ActivityLogsMouseReleased(java.awt.event.MouseEvent evt) {
		switchPanels(ActivityLogsPanel); // TODO add your handling code here:
	}

	private void ClientRecordsMouseReleased(java.awt.event.MouseEvent evt) {
		switchPanels(ClientRecordsPanel); // TODO add your handling code here:
	}

	private void LogOutMouseReleased(java.awt.event.MouseEvent evt) {
		dispose();
		// pantawag sa login page:
		/*
		 * try { LoginPage loginpage = new LoginPage(); } catch ( IOException e1) { //
		 * TODO Auto-generated catch block e1.printStackTrace(); }
		 */
	}

	/**
	 * @param args the command line arguments
	 */
	public static void start() {
		
	}
	
	public void windowStart() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Dashboard2.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Dashboard2.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Dashboard2.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Dashboard2.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
	}
	
	void deleteProduct() {
		try {
			String sku, desc, changeby, remarks;
			sku = inventorySF.getText();
			desc = descremField.getText();
			changeby = rembyField.getText();
			remarks = remarksArea.getText();
			
			
			if(sku.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Search FIRST the product");
			}
			
			if(changeby.isEmpty() || remarks.isEmpty()) {
				throw new Exception();
			}
			
			ActivityLogs logs = new ActivityLogs();
			logs.setSku(sku);
	        logs.setDescription(desc);
	        logs.setActivity("Deleted product");
	        logs.setQty(qtyremField.getText());
	        logs.setChangeBy(changeby);
	        logs.setRemarks(remarks);
	        databaseHandler.saveToDatabase(logs);
	        
			databaseHandler.deleteRow("product", "SKU", inventorySF.getText());
			databaseHandler.table_load("product", inventoryTable);
//			table_load("activitylogs", logsTable);
			
			inventorySF.setText("");
			descremField.setText("");
			rembyField.setText("");
			remarksArea.setText("");
		}catch(Exception f) {
			JOptionPane.showMessageDialog(null, "Please input the necessary information");
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
			
			if(changeby.isEmpty() || remarks.isEmpty()) {
				throw new Exception();
			}
			
			int remQtyVal = Integer.parseInt(remqty);
			int currQtyVal = Integer.parseInt(qty);
			int newQtyVal = currQtyVal - remQtyVal;
			
			if(remQtyVal > 0 && currQtyVal > 0 && newQtyVal >= 0) {
				
				
		        databaseHandler.updateStockQty(newQtyVal, sku);
		        
		        ActivityLogs logs = new ActivityLogs();
		        logs.setSku(sku);
		        logs.setDescription(desc);
		        logs.setActivity("Stock removal");
		        logs.setQty(remqty);
		        logs.setChangeBy(changeby);
		        logs.setRemarks(remarks);
		        
		        
		        databaseHandler.saveToDatabase(logs);
		        databaseHandler.table_load("product",inventoryTable);
//		        databaseHandler.table_load("activitylogs", logsTable);
		        
		        JOptionPane.showMessageDialog(null, "Stock removed successfully!");
		        
		        qtyremField.setText(newQtyVal+"");
		        rembyField.setText("");
		        remQty.setText("");
		        remarksArea.setText("");
		        databaseHandler.skuSearched = "";
			}
			else if(currQtyVal == 0) {
				JOptionPane.showMessageDialog(null, "Can't remove stock anymore because current Qty = 0   :(");
			}
			else if(newQtyVal < 0) {
				JOptionPane.showMessageDialog(null, "**ERROR**\nYou CANNOT remove Qty more than the current Qty");
			}
			else {
				JOptionPane.showMessageDialog(null, "**ERROR**\n{Input POSITIVE integer in the ADD QTY field}");
				
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Please SEARCH first the SKU and FILL UP all the necessary information");
			e.printStackTrace();
		}
		
	}
	// Variables declaration - do not modify
	private javax.swing.JLabel ActivityLogs;
	private javax.swing.JPanel ActivityLogsPanel;
	private javax.swing.JLabel Bar;
	private javax.swing.JLabel BitMonke;
	private javax.swing.JLabel ClientRecords;
	private javax.swing.JPanel ClientRecordsPanel;
	private javax.swing.JPanel DashboardPanel;
	private javax.swing.JLabel HideMenu;
	private javax.swing.JLabel Inventory;
	private javax.swing.JPanel InventoryPanel;
	private javax.swing.JLabel LogOut;
	private javax.swing.JLabel OpenMenu;
	private javax.swing.JPanel SalesReportPanel;
	private javax.swing.JPanel SlidingMenu;
	private javax.swing.JLabel StockIn;
	private javax.swing.JPanel StockInPanel;
	private javax.swing.JLabel StockSales;
	private javax.swing.JLayeredPane layeredPane;
	private JPanel removePn;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField descremField;
	private JTextField rembyField;
	private JLabel lblNewLabel_8;
	private JTextField qtyremField;
	private JLabel lblNewLabel_8_1;
	private JLabel lblNewLabel_8_1_1;
	private JScrollPane scrollPane;
	private JButton btnRemoveProd;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_8_1_1_1;
	private JTextField remQty;
	private JCheckBox chkRemProd;
	private JLabel lblNewLabel_3;
	private JTextField inventorySF;
	private JButton btnSearch;
	private JLabel lblNewLabel_4;
	private JComboBox viewCB;
	private JLabel lblNewLabel_5;
	private JButton btnRefresh;
	private DatabaseHandler databaseHandler;
	private JScrollPane scrollPane_1;
	private JTable inventoryTable;
	private JTextArea remarksArea;
	private Product category = new Product();
	private String chosenCat = category.getCategoryByIndex(0);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable logsTable;
	private JScrollPane scrollPane_4;
	private JButton btnDeleteClientRecords;
	private JLabel lblNewLabel_2_1_1_1;
	private JTable clientRecordsTable;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
}

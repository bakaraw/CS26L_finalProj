/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import utils.ActivityLogs;
import utils.DatabaseHandler;
import utils.Product;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.RingPlot; // If you're creating a ring chart
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PiePlot3D; // For 3D pie charts
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import org.jfree.ui.RefineryUtilities;

import org.jfree.util.Rotation;



import javax.swing.JFrame;
import javax.swing.JPanel;



public class Dashboard2 extends javax.swing.JFrame {

	public Dashboard2() {
		setTitle("Admin");
		windowStart();
		initComponents();
		setLocationRelativeTo(null);
	}
	@SuppressWarnings("unchecked")
	private void initComponents() {
		
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
		EmployeePanel = new javax.swing.JPanel();
		SalesReportPanel = new javax.swing.JPanel();



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
		StockIn.setText("     Employee");
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

		lblNewLabel_3 = new JLabel(" Inventory");
		lblNewLabel_3.setIcon(new ImageIcon("img\\icons8-open-box-32.png"));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 28));

		inventorySF = new JTextField();
		inventorySF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = inventorySF.getText();
				search(searchString);
			}
		});
		inventorySF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inventorySF.setColumns(10);

		lblNewLabel_4 = new JLabel("View by category:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		viewCB = new JComboBox(category.getCategoryArray());
		viewCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databaseHandler.sortView("product", "Category", viewCB, inventoryTable);
			}
		});
		viewCB.addItem("All");
		viewCB.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnRefresh = new JButton("");
		btnRefresh.setIcon(new ImageIcon("img//icons8-refresh-16 (1).png"));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databaseHandler.table_load("product", inventoryTable);
			}
		});
		btnRefresh.setBackground(new Color(201, 242, 168));

		scrollPane_1 = new JScrollPane();

		btn_AddProduct = new JButton(" Add Product");
		btn_AddProduct.setIcon(new ImageIcon("img//icons8-add-new-16.png"));
		btn_AddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWindow addwindow = new AddWindow();
				addwindow.setInventoryTable(inventoryTable);
				addwindow.setLogsTable(clientRecordsTable);
				addwindow.getObj().setVisible(true);
			}
		});
		
		btn_StockIn = new JButton("Stock in");
		btn_StockIn.setIcon(new ImageIcon("img\\icons8-add-to-cart-16.png"));
		btn_StockIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockinwindow.getObj().setVisible(true);
			}
		});

		btn_Remove = new JButton("Remove");
		btn_Remove.setIcon(new ImageIcon("img//icons8-remove-16.png"));
		btn_Remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removewindow.getObj().setVisible(true);
			}
		});
		
		searchIcon = new JLabel("");
		searchIcon.setIcon(new ImageIcon("img//icons8-search-16 (1).png"));

		javax.swing.GroupLayout InventoryPanelLayout = new javax.swing.GroupLayout(InventoryPanel);
		InventoryPanelLayout.setHorizontalGroup(
			InventoryPanelLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(InventoryPanelLayout.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 1362, GroupLayout.PREFERRED_SIZE)
						.addGroup(InventoryPanelLayout.createSequentialGroup()
							.addComponent(searchIcon, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(inventorySF, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(viewCB, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(btn_AddProduct)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_StockIn, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_Remove, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
					.addGap(18))
		);
		InventoryPanelLayout.setVerticalGroup(
			InventoryPanelLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(InventoryPanelLayout.createSequentialGroup()
					.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(InventoryPanelLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_AddProduct, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_StockIn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Remove, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
						.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(InventoryPanelLayout.createSequentialGroup()
								.addContainerGap(28, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGap(23)
								.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(inventorySF, Alignment.TRAILING)
									.addComponent(searchIcon, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
							.addGroup(InventoryPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnRefresh, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
									.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(viewCB, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);

		inventoryTable = new JTable();
		inventoryTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = inventoryTable.getSelectedRow();
					String Table_click = (inventoryTable.getModel().getValueAt(row, 0).toString());
					databaseHandler.pst = databaseHandler.con
							.prepareStatement("select * from product where SKU ='" + Table_click + "'  ");
					databaseHandler.rs = databaseHandler.pst.executeQuery();

					if (databaseHandler.rs.next()) {
						String sku = databaseHandler.rs.getString("SKU");
						
//						inventorySF.setText(sku);
						String desc = databaseHandler.rs.getString("Description");
//						descremField.setText(desc);
						String qty = databaseHandler.rs.getString("Qty");
//						qtyremField.setText(qty);
						
						StockInWindow.setaddstockSkuField(sku);
						StockInWindow.setadddescField(desc);
						StockInWindow.setcurrQtyField(qty);
						StockInWindow.setInventoryTable(inventoryTable);
						StockInWindow.setLogsTable(logsTable);
						
//						removewindow = new RemoveWindow();
						RemoveWindow.setInventoryTable(inventoryTable);
						RemoveWindow.setLogsTable(logsTable);
						RemoveWindow.setinventorySF(sku);
						RemoveWindow.setdescremField(desc);
						RemoveWindow.setcurrQtyField(qty);
						
						databaseHandler.skuSearched = Table_click;
					}

				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, "Click table row");
					f.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(inventoryTable);
		databaseHandler.table_load("product", inventoryTable);
		InventoryPanel.setLayout(InventoryPanelLayout);

		layeredPane.add(InventoryPanel, "card3");

		ActivityLogsPanel.setBackground(new Color(255, 255, 255));

		JLabel lblNewLabel_2_1_1 = new JLabel("  Admin Activity Logs");
		lblNewLabel_2_1_1.setIcon(new ImageIcon("img\\icons8-activity-feed-32.png"));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));

		JLabel lblNewLabel_4_1 = new JLabel("View by activity:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JComboBox viewByAct = new JComboBox(new ActivityLogs().getActArray());
		viewByAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databaseHandler.sortView("activitylogs", "Activity", viewByAct, logsTable);
			}
		});
		viewByAct.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnRefreshLogs = new JButton("Refresh");
		btnRefreshLogs.setIcon(new ImageIcon("img\\icons8-refresh-16 (1).png"));
		btnRefreshLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databaseHandler.table_load("activitylogs", logsTable);
			}
		});
		btnRefreshLogs.setBackground(new Color(201, 242, 168));

		JButton btnDeleteLogs = new JButton("Delete all");
		btnDeleteLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all data in the table?", "Confirm Dialog",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				if(confirm == JOptionPane.YES_OPTION) {
					databaseHandler.deleteAllData("activitylogs");
					databaseHandler.table_load("activitylogs", logsTable);
				}
			}
		});
		btnDeleteLogs.setIcon(new ImageIcon("img\\icons8-remove-16 (1).png"));

		JScrollPane scrollPane_actLogs = new JScrollPane();

		javax.swing.GroupLayout ActivityLogsPanelLayout = new javax.swing.GroupLayout(ActivityLogsPanel);
		ActivityLogsPanelLayout.setHorizontalGroup(
			ActivityLogsPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(ActivityLogsPanelLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(ActivityLogsPanelLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_actLogs, GroupLayout.PREFERRED_SIZE, 1343, GroupLayout.PREFERRED_SIZE)
						.addGroup(ActivityLogsPanelLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(viewByAct, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnRefreshLogs)
							.addGap(70)
							.addComponent(btnDeleteLogs))
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
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
					.addContainerGap(23, Short.MAX_VALUE))
		);

		logsTable = new JTable();
		scrollPane_actLogs.setViewportView(logsTable);
		databaseHandler.table_load("activitylogs", logsTable);
		ActivityLogsPanel.setLayout(ActivityLogsPanelLayout);

		layeredPane.add(ActivityLogsPanel, "card4");

		ClientRecordsPanel.setBackground(new Color(255, 255, 255));

		scrollPane_4 = new JScrollPane();

		btnDeleteClientRecords = new JButton("Delete all");
		btnDeleteClientRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all the data in this table?", "Confirm Dialog",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				
				if(confirm == JOptionPane.YES_OPTION) {
					databaseHandler.deleteAllData("clientrecords");
					databaseHandler.table_load("clientrecords", clientRecordsTable);
				}
				
			}
		});
		btnDeleteClientRecords.setIcon(new ImageIcon("img\\icons8-remove-16 (1).png"));

		lblNewLabel_2_1_1_1 = new JLabel("  Client Records");
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon("img\\icons8-database-view-32.png"));
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));

		javax.swing.GroupLayout ClientRecordsPanelLayout = new javax.swing.GroupLayout(ClientRecordsPanel);
		ClientRecordsPanelLayout.setHorizontalGroup(ClientRecordsPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(ClientRecordsPanelLayout.createSequentialGroup().addGap(30)
						.addGroup(ClientRecordsPanelLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 280,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDeleteClientRecords).addComponent(scrollPane_4,
										GroupLayout.PREFERRED_SIZE, 1346, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(24, Short.MAX_VALUE)));
		ClientRecordsPanelLayout.setVerticalGroup(ClientRecordsPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(ClientRecordsPanelLayout.createSequentialGroup().addGap(36)
						.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(12).addComponent(btnDeleteClientRecords).addGap(11)
						.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(20, Short.MAX_VALUE)));

		clientRecordsTable = new JTable();
		scrollPane_4.setViewportView(clientRecordsTable);
		databaseHandler.table_load("clientrecords", clientRecordsTable);
		ClientRecordsPanel.setLayout(ClientRecordsPanelLayout);

		layeredPane.add(ClientRecordsPanel, "card5");

		EmployeePanel.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Employee");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JScrollPane employeeTbScrollPane = new JScrollPane();

		javax.swing.GroupLayout gl_EmployeePanel = new javax.swing.GroupLayout(EmployeePanel);
		gl_EmployeePanel.setHorizontalGroup(
			gl_EmployeePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EmployeePanel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_EmployeePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
						.addComponent(employeeTbScrollPane, GroupLayout.PREFERRED_SIZE, 1353, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_EmployeePanel.setVerticalGroup(
			gl_EmployeePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EmployeePanel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(employeeTbScrollPane, GroupLayout.PREFERRED_SIZE, 507, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		employeeTable = new JTable();
		employeeTbScrollPane.setViewportView(employeeTable);
		databaseHandler.table_load(employeeTable);
		EmployeePanel.setLayout(gl_EmployeePanel);

		layeredPane.add(EmployeePanel, "card6");

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
		
		lineGraphPn = new JPanel();
		lineGraphPn.setBackground(new Color(255, 255, 255));
		lineGraphPn.setBounds(34, 67, 709, 430);
		try {
			lineGraphPn.add(createLineGraph());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		salesReportContentPanel.add(lineGraphPn);
		
		PieChartPanel = new JPanel();
		PieChartPanel.setBackground(new Color(255, 255, 128));
		PieChartPanel.setBounds(753, 67, 560, 341);
		try {
			PieChartPanel.add( new CreatePieChart("Pie Chart Test","Stocks Comparison"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		salesReportContentPanel.add(PieChartPanel);
		SalesReportPanel.setLayout(SalesReportPanelLayout);

		layeredPane.add(SalesReportPanel, "card2");

		javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
		DashboardPanelLayout
				.setHorizontalGroup(DashboardPanelLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(DashboardPanelLayout.createSequentialGroup()
								.addComponent(SlidingMenu, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
								.addGap(0)
								.addGroup(DashboardPanelLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(DashboardPanelLayout.createSequentialGroup().addGap(64)
												.addComponent(Bar, GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE))
										.addGroup(DashboardPanelLayout
												.createSequentialGroup().addComponent(OpenMenu,
														GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
												.addContainerGap()))));
		DashboardPanelLayout.setVerticalGroup(DashboardPanelLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(SlidingMenu, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
				.addGroup(DashboardPanelLayout.createSequentialGroup().addGap(49)
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(DashboardPanelLayout.createSequentialGroup()
						.addComponent(Bar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(DashboardPanelLayout.createSequentialGroup()
						.addComponent(OpenMenu, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(579, Short.MAX_VALUE)));
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
		switchPanels(EmployeePanel); // TODO add your handling code here:
	}

	private void ActivityLogsMouseReleased(java.awt.event.MouseEvent evt) {
		switchPanels(ActivityLogsPanel); // TODO add your handling code here:
	}

	private void ClientRecordsMouseReleased(java.awt.event.MouseEvent evt) {
		switchPanels(ClientRecordsPanel); // TODO add your handling code here:
	}

	private void LogOutMouseReleased(java.awt.event.MouseEvent evt) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			LoginPage loginPage = new LoginPage();
			
		} catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		dispose();
	}

	public static void start() {

	}
	
	public void search (String str) {
		model = (DefaultTableModel) inventoryTable.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter(model);	
		inventoryTable.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	
	
	
	public void windowStart() {

		databaseHandler = new DatabaseHandler();
		databaseHandler.Connect();
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
  }
  
	public ChartPanel createLineGraph() throws Exception {
			String query ="select Date,TotalSales from clientrecords";
			JDBCCategoryDataset dataset = new JDBCCategoryDataset(databaseHandler.con,query);
			JFreeChart chart = ChartFactory.createLineChart("Sales Chart", "Date", "Sales (Php)", dataset, PlotOrientation.VERTICAL, false, true, true);
			BarRenderer renderer = null;
			CategoryPlot plot = null;
			renderer = new BarRenderer();
			ChartPanel chartpn = new ChartPanel(chart, true);
			return chartpn;
	}
	
	public class CreatePieChart extends JPanel {
		public CreatePieChart (String apptitle, String chartTitle) {
			PieDataset dataset = createDataset();
			JFreeChart chart = createChart(dataset, chartTitle);
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new java.awt.Dimension(500,300));
			add(chartPanel);
			
		}
		
		private PieDataset createDataset() {
			DefaultPieDataset result = new DefaultPieDataset();
			result.setValue("Peripherals", 65);
			result.setValue("CPU", 24);
			result.setValue("GPU", 40);
			result.setValue("Motherboard", 21);
			result.setValue("RAM", 34);
			result.setValue("Storage Device", 21);
			return result;
		}

		private JFreeChart createChart(PieDataset dataset, String title) {
			JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, true);
			PiePlot3D plot = (PiePlot3D)chart.getPlot();
			plot.setStartAngle(90);
			plot.setDirection(Rotation.CLOCKWISE);
			plot.setForegroundAlpha(0.5f);
			return chart;
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
	private javax.swing.JPanel EmployeePanel;
	private javax.swing.JLabel StockSales;
	private javax.swing.JLayeredPane layeredPane;
	private JLabel lblNewLabel_3;
	private JTextField inventorySF;
	private JLabel lblNewLabel_4;
	private JComboBox viewCB;
	private JButton btnRefresh;
	private DatabaseHandler databaseHandler;
	private JScrollPane scrollPane_1;
	public JTable inventoryTable;
	private Product category = new Product();
	private String chosenCat = category.getCategoryByIndex(0);
	private JTable logsTable;
	private JScrollPane scrollPane_4;
	private JButton btnDeleteClientRecords;
	private JLabel lblNewLabel_2_1_1_1;
	private JTable clientRecordsTable;
	private JPanel lineGraphPn;
	private JPanel PieChartPanel;
	private JButton btn_AddProduct;
	private JButton btn_StockIn;
	private JButton btn_Remove;
	public static String test1;
	public static String test2;
	public static String test3;
	static StockInWindow stockinwindow = new StockInWindow();
	static RemoveWindow removewindow = new RemoveWindow();
	static DefaultTableModel model = null;
	private JTable employeeTable;
	private JLabel searchIcon;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D; // For 3D pie charts
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.util.Rotation;

import utils.ActivityLogs;
import utils.DatabaseHandler;
import utils.Product;

import javax.swing.DefaultComboBoxModel;
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
		BitMonke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
				frame = new JFrame();
				frame.setTitle("Oliver");
				frame.setBounds(100, 100, 453, 384);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JLabel monkeGif = new JLabel("                  ");
				monkeGif.setIcon(new ImageIcon("img\\monkey-monke.gif"));
				frame.getContentPane().add(monkeGif, BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		OpenMenu = new javax.swing.JLabel();
		OpenMenu.setForeground(new Color(43, 52, 59));
		Bar = new javax.swing.JLabel();
		layeredPane = new javax.swing.JLayeredPane();
		InventoryPanel = new javax.swing.JPanel();
		InventoryPanel.isOptimizedDrawingEnabled();
		ActivityLogsPanel = new javax.swing.JPanel();
		ClientRecordsPanel = new javax.swing.JPanel();
		EmployeePanel = new javax.swing.JPanel();
		SalesReportPanel = new javax.swing.JPanel() {
			@Override
			public boolean isOptimizedDrawingEnabled() {
				return false;
			}
		};

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		DashboardPanel.setBackground(new java.awt.Color(204, 204, 204));

		SlidingMenu.setBackground(new Color(36, 49, 55));
		SlidingMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(51, 51, 51)));

		HideMenu.setBackground(new Color(36, 49, 55));
		HideMenu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		HideMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/hide_1.png"))); // NOI18N
		HideMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		HideMenu.setOpaque(true);
		HideMenu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				HideMenuMouseReleased(evt);
			}
		});

		StockSales.setBackground(new Color(36, 49, 55));
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

		Inventory.setBackground(new Color(36, 49, 55));
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

		StockIn.setBackground(new Color(36, 49, 55));
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

		ActivityLogs.setBackground(new Color(36, 49, 55));
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

		ClientRecords.setBackground(new Color(36, 49, 55));
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

		LogOut.setBackground(new Color(36, 49, 55));
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

		BitMonke.setBackground(new Color(36, 49, 55));
		BitMonke.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
		BitMonke.setForeground(new Color(255, 255, 255));
		BitMonke.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		BitMonke.setIcon(new ImageIcon("img\\bitmonkeadmin.png"));
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

		OpenMenu.setBackground(new Color(36, 49, 55));
		OpenMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		OpenMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/menu (1).png"))); // NOI18N
		OpenMenu.setOpaque(true);
		OpenMenu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				OpenMenuMouseReleased(evt);
			}
		});

		Bar.setBackground(new Color(36, 49, 55));
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

		JLabel searchLogo = new JLabel("");
		searchLogo.setIcon(new ImageIcon("img//icons8-search-16 (1).png"));

		javax.swing.GroupLayout InventoryPanelLayout = new javax.swing.GroupLayout(InventoryPanel);
		InventoryPanelLayout.setHorizontalGroup(InventoryPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(InventoryPanelLayout.createSequentialGroup().addGap(20).addGroup(InventoryPanelLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(InventoryPanelLayout.createSequentialGroup()
								.addComponent(searchLogo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(inventorySF, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
								.addGap(55)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 123,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(viewCB, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addGap(58).addComponent(btn_AddProduct).addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btn_StockIn, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btn_Remove, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 1417, Short.MAX_VALUE))
						.addContainerGap()));
		InventoryPanelLayout.setVerticalGroup(InventoryPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(InventoryPanelLayout.createSequentialGroup().addGap(21)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(searchLogo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(inventorySF, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnRefresh, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
												.addComponent(btn_AddProduct, GroupLayout.DEFAULT_SIZE, 32,
														Short.MAX_VALUE)
												.addComponent(btn_StockIn, GroupLayout.PREFERRED_SIZE, 31,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btn_Remove, GroupLayout.DEFAULT_SIZE, 32,
														Short.MAX_VALUE))
										.addGroup(InventoryPanelLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(viewCB, GroupLayout.PREFERRED_SIZE, 32,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 19,
														GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE)));

		inventoryTable = new JTable();
		inventoryTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = inventoryTable.convertRowIndexToModel(inventoryTable.getSelectedRow());
					DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();
					String Table_click = (inventoryTable.getModel().getValueAt(row, 0).toString());
					databaseHandler.pst = databaseHandler.con
							.prepareStatement("select * from product where SKU ='" + Table_click + "'  ");
					databaseHandler.rs = databaseHandler.pst.executeQuery();

					if (databaseHandler.rs.next()) {

						StockInWindow.getObj().setVisible(false);
						RemoveWindow.getObj().setVisible(false);

						String sku = databaseHandler.rs.getString("SKU");
						String desc = databaseHandler.rs.getString("Description");
						String qty = databaseHandler.rs.getString("Qty");

						StockInWindow.setaddstockSkuField(sku);
						StockInWindow.setadddescField(desc);
						StockInWindow.setcurrQtyField(qty);
						StockInWindow.setInventoryTable(inventoryTable);
						StockInWindow.setLogsTable(logsTable);

						RemoveWindow.setInventoryTable(inventoryTable);
						RemoveWindow.setLogsTable(logsTable);
						RemoveWindow.setinventorySF(sku);
						RemoveWindow.setdescremField(desc);
						RemoveWindow.setcurrQtyField(qty);

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
				int confirm = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to delete all data in the table?", "Confirm Dialog",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (confirm == JOptionPane.YES_OPTION) {
					databaseHandler.deleteAllData("activitylogs");
					databaseHandler.table_load("activitylogs", logsTable);
				}
			}
		});
		btnDeleteLogs.setIcon(new ImageIcon("img\\icons8-remove-16 (1).png"));

		JScrollPane scrollPane_actLogs = new JScrollPane();

		javax.swing.GroupLayout ActivityLogsPanelLayout = new javax.swing.GroupLayout(ActivityLogsPanel);
		ActivityLogsPanelLayout.setHorizontalGroup(ActivityLogsPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(ActivityLogsPanelLayout.createSequentialGroup().addGap(32).addGroup(ActivityLogsPanelLayout
						.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_actLogs, GroupLayout.PREFERRED_SIZE, 1343, GroupLayout.PREFERRED_SIZE)
						.addGroup(ActivityLogsPanelLayout.createSequentialGroup()
								.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 123,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(viewByAct, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addGap(33).addComponent(btnRefreshLogs).addGap(70).addComponent(btnDeleteLogs))
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(25, Short.MAX_VALUE)));
		ActivityLogsPanelLayout.setVerticalGroup(ActivityLogsPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(ActivityLogsPanelLayout.createSequentialGroup().addGap(26)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addGroup(ActivityLogsPanelLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(ActivityLogsPanelLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 19,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(viewByAct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(ActivityLogsPanelLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnRefreshLogs).addComponent(btnDeleteLogs)))
						.addGap(15)
						.addComponent(scrollPane_actLogs, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE)));

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

				int confirm = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to delete all the data in this table?", "Confirm Dialog",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (confirm == JOptionPane.YES_OPTION) {
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
		gl_EmployeePanel.setHorizontalGroup(gl_EmployeePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EmployeePanel.createSequentialGroup().addGap(26)
						.addGroup(gl_EmployeePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 349,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(employeeTbScrollPane, GroupLayout.PREFERRED_SIZE, 1353,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(21, Short.MAX_VALUE)));
		gl_EmployeePanel.setVerticalGroup(gl_EmployeePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EmployeePanel.createSequentialGroup().addGap(21)
						.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(employeeTbScrollPane, GroupLayout.PREFERRED_SIZE, 507, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(20, Short.MAX_VALUE)));

		employeeTable = new JTable();
		employeeTbScrollPane.setViewportView(employeeTable);
		databaseHandler.table_load(employeeTable);
		EmployeePanel.setLayout(gl_EmployeePanel);

		layeredPane.add(EmployeePanel, "card6");

		SalesReportPanel.setBackground(new Color(255, 255, 255));

		salesReportContentPanel = new JPanel();
		salesReportContentPanel.setBackground(new Color(255, 255, 255));

		javax.swing.GroupLayout SalesReportPanelLayout = new javax.swing.GroupLayout(SalesReportPanel);
		SalesReportPanelLayout.setHorizontalGroup(SalesReportPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(SalesReportPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(salesReportContentPanel, GroupLayout.DEFAULT_SIZE, 1427, Short.MAX_VALUE)
						.addContainerGap()));
		SalesReportPanelLayout.setVerticalGroup(SalesReportPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(SalesReportPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(salesReportContentPanel, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
						.addContainerGap()));

		salesReportContentPanel.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel(" Sales Report");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_7.setBounds(23, 11, 318, 34);
		lblNewLabel_7.setIcon(new ImageIcon("img\\graph.png"));
		salesReportContentPanel.add(lblNewLabel_7);

		lineGraphPn = new JPanel();
		lineGraphPn.setBackground(new Color(255, 255, 255));
		lineGraphPn.setBounds(23, 56, 709, 474);
		try {

			cbDMY = new JComboBox();
			lineGraphPn.add(cbDMY);
			cbDMY.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (cbDMY.getSelectedItem().toString().equals("Daily")) {
						try {
							Component[] components = lineGraphPn.getComponents();
							if (components.length > 0) {
								Component lastComponent = components[components.length - 1];
								lineGraphPn.remove(lastComponent);
								lineGraphPn.revalidate();
								lineGraphPn.repaint();
							}
							lineGraphPn.add(createDailyLineGraph());
							System.out.println("daily");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (cbDMY.getSelectedItem().toString().equals("Monthly")) {
						try {
							Component[] components = lineGraphPn.getComponents();
							if (components.length > 0) {
								Component lastComponent = components[components.length - 1];
								lineGraphPn.remove(lastComponent);
								lineGraphPn.revalidate();
								lineGraphPn.repaint();
							}
							lineGraphPn.add(createMonthlyLineGraph());
							System.out.println("Monthly");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (cbDMY.getSelectedItem().toString().equals("Yearly")) {
						try {
							Component[] components = lineGraphPn.getComponents();
							if (components.length > 0) {
								Component lastComponent = components[components.length - 1];
								lineGraphPn.remove(lastComponent);
								lineGraphPn.revalidate();
								lineGraphPn.repaint();
							}
							lineGraphPn.add(createYearlyLineGraph());
							System.out.println("yearly");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}
			});
			cbDMY.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cbDMY.setModel(new DefaultComboBoxModel(new String[] { "Daily", "Monthly", "Yearly" }));
			lineGraphPn.add(createDailyLineGraph());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		salesReportContentPanel.add(lineGraphPn);

		PieChartPanel = new JPanel();
		PieChartPanel.setBackground(new Color(255, 255, 255));
		PieChartPanel.setBounds(772, 79, 613, 442);
		try {

			PieChartPanel.add(new CreatePieChart("Pie Chart Test", "Stocks Comparison"));

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		salesReportContentPanel.add(PieChartPanel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(1017, 56, 122, 23);
		salesReportContentPanel.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Total Sales")) {
					switchToAllSales();
				} else if (comboBox.getSelectedItem().equals("This Year")) {
					switchToThisYear();
				} else if (comboBox.getSelectedItem().equals("This Month")) {
					switchToThisMonth();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Total Sales", "This Year", "This Month" }));

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

	public void switchToThisMonth() {
		PieChartPanel.removeAll();
		InviFrame = new InvisibleFrame();
		databaseHandler.table_load("catcomparison", InviFrame.table);
		InviFrame.setVisible(false);
		setPeripherals((int) calculateSalesThisMonth(InviFrame.table, 1));
		setcpu((int) calculateSalesThisMonth(InviFrame.table, 2));
		setgpu((int) calculateSalesThisMonth(InviFrame.table, 3));
		setmotherboard((int) calculateSalesThisMonth(InviFrame.table, 4));
		setram((int) calculateSalesThisMonth(InviFrame.table, 5));
		setstoragedevice((int) calculateSalesThisMonth(InviFrame.table, 6));

		PieChartPanel.add(new CreatePieChart("Pie Chart Test", "This Month Comparison"));
		repaint();
		revalidate();
	}

	public void switchToThisYear() {
		PieChartPanel.removeAll();
		InviFrame = new InvisibleFrame();
		databaseHandler.table_load("catcomparison", InviFrame.table);
		InviFrame.setVisible(false);
		setPeripherals((int) calculateSalesThisYear(InviFrame.table, 1));
		setcpu((int) calculateSalesThisYear(InviFrame.table, 2));
		setgpu((int) calculateSalesThisYear(InviFrame.table, 3));
		setmotherboard((int) calculateSalesThisYear(InviFrame.table, 4));
		setram((int) calculateSalesThisYear(InviFrame.table, 5));
		setstoragedevice((int) calculateSalesThisYear(InviFrame.table, 6));

		PieChartPanel.add(new CreatePieChart("Pie Chart Test", "This Year Comparison"));
		repaint();
		revalidate();
	}

	public void switchToAllSales() {
		PieChartPanel.removeAll();
		InviFrame = new InvisibleFrame();
		databaseHandler.table_load("catcomparison", InviFrame.table);
		InviFrame.setVisible(false);
		setPeripherals((int) calculateTotalSales(InviFrame.table, 1));
		setcpu((int) calculateTotalSales(InviFrame.table, 2));
		setgpu((int) calculateTotalSales(InviFrame.table, 3));
		setmotherboard((int) calculateTotalSales(InviFrame.table, 4));
		setram((int) calculateTotalSales(InviFrame.table, 5));
		setstoragedevice((int) calculateTotalSales(InviFrame.table, 6));

		PieChartPanel.add(new CreatePieChart("Pie Chart Test", "Total Sales Comparison"));
		repaint();
		revalidate();
	}

	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		switchPanels(SalesReportPanel);
		switchToAllSales();

	}

	private void OpenMenuMouseReleased(java.awt.event.MouseEvent evt) {
		Component[] components = layeredPane.getComponents();
		for (Component component : components) {
			if (component instanceof JComponent) {
				((JComponent) component).setEnabled(false);
			}
		}
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
		StockSales.setBackground(new Color(48, 62, 71)); // TODO add your handling code here:
	}

	private void StockSalesMouseExited(java.awt.event.MouseEvent evt) {
		StockSales.setBackground(new Color(36, 49, 55));
	}

	private void InventoryMouseEntered(java.awt.event.MouseEvent evt) {
		Inventory.setBackground(new Color(48, 62, 71)); // TODO add your handling code here:
	}

	private void InventoryMouseReleased(java.awt.event.MouseEvent evt) {
		switchPanels(InventoryPanel); // TODO add your handling code here:
	}

	private void InventoryMouseExited(java.awt.event.MouseEvent evt) {
		Inventory.setBackground(new Color(36, 49, 55));
	}

	private void StockInMouseEntered(java.awt.event.MouseEvent evt) {
		StockIn.setBackground(new Color(48, 62, 71)); // TODO add your handling code here:
	}

	private void StockInMouseExited(java.awt.event.MouseEvent evt) {
		StockIn.setBackground(new Color(36, 49, 55));
	}

	private void ActivityLogsMouseEntered(java.awt.event.MouseEvent evt) {
		ActivityLogs.setBackground(new Color(48, 62, 71));
	}

	private void ActivityLogsMouseExited(java.awt.event.MouseEvent evt) {
		ActivityLogs.setBackground(new Color(36, 49, 55));
	}

	private void ClientRecordsMouseEntered(java.awt.event.MouseEvent evt) {
		ClientRecords.setBackground(new Color(48, 62, 71));
	}

	private void ClientRecordsMouseExited(java.awt.event.MouseEvent evt) {
		ClientRecords.setBackground(new Color(36, 49, 55));
	}

	private void LogOutMouseEntered(java.awt.event.MouseEvent evt) {
		LogOut.setBackground(new Color(48, 62, 71));
	}

	private void LogOutMouseExited(java.awt.event.MouseEvent evt) {
		LogOut.setBackground(new Color(36, 49, 55));
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
			LoginPage loginPage = new LoginPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispose();
	}

	public static void start() {

	}

	public void search(String str) {
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

	public ChartPanel createDailyLineGraph() throws Exception {
		String query = "SELECT DATE_FORMAT(Date, '%b %e %Y') AS FormattedDate, Sales FROM salesdata";
		JDBCCategoryDataset dataset = new JDBCCategoryDataset(databaseHandler.con, query);
		JFreeChart chart = ChartFactory.createLineChart("Daily Sales Chart", "Date", "Sales (Php)", dataset,
				PlotOrientation.VERTICAL, false, true, true);
		BarRenderer renderer = null;
		CategoryPlot plot = null;
		renderer = new BarRenderer();
		ChartPanel chartpn = new ChartPanel(chart, true);
		return chartpn;
	}

	public ChartPanel createMonthlyLineGraph() throws Exception {
		databaseHandler.pst = databaseHandler.con.prepareStatement(
				"SELECT DATE_FORMAT(Date, '%b %Y') AS month, SUM(Sales) AS total_monthly_sales FROM salesdata GROUP BY DATE_FORMAT(Date, '%b %Y')");
		ResultSet monthlyResult = databaseHandler.pst.executeQuery();
		DefaultCategoryDataset monthlyDataset = new DefaultCategoryDataset();
		while (monthlyResult.next()) {
			String month = monthlyResult.getString("month");
			double totalMonthlySales = monthlyResult.getDouble("total_monthly_sales");
			monthlyDataset.addValue(totalMonthlySales, "Monthly Sales", month);
		}
		JFreeChart chart = ChartFactory.createLineChart("Monthly Sales Chart", "Date", "Sales (Php)", monthlyDataset,
				PlotOrientation.VERTICAL, false, true, true);
		BarRenderer renderer = null;
		CategoryPlot plot = null;
		renderer = new BarRenderer();
		ChartPanel chartpn = new ChartPanel(chart, true);
		return chartpn;
	}

	public ChartPanel createYearlyLineGraph() throws Exception {
		databaseHandler.pst = databaseHandler.con.prepareStatement(
				"SELECT YEAR(Date) AS year, SUM(Sales) AS total_yearly_sales FROM salesdata GROUP BY YEAR(Date)");
		ResultSet yearlyResult = databaseHandler.pst.executeQuery();
		DefaultCategoryDataset yearlyDataset = new DefaultCategoryDataset();
		while (yearlyResult.next()) {
			int year = yearlyResult.getInt("year");
			double totalYearlySales = yearlyResult.getDouble("total_yearly_sales");
			yearlyDataset.addValue(totalYearlySales, "Yearly Sales", Integer.toString(year));
		}
		JFreeChart chart = ChartFactory.createLineChart("Yearly Sales Chart", "Date", "Sales (Php)", yearlyDataset,
				PlotOrientation.VERTICAL, false, true, true);
		BarRenderer renderer = null;
		CategoryPlot plot = null;
		renderer = new BarRenderer();
		ChartPanel chartpn = new ChartPanel(chart, true);
		return chartpn;
	}

	public class CreatePieChart extends JPanel {
		public CreatePieChart(String apptitle, String chartTitle) {
			PieDataset dataset = createDataset();
			JFreeChart chart = createChart(dataset, chartTitle);
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new java.awt.Dimension(600, 385));
			add(chartPanel);

		}

		private PieDataset createDataset() {
			DefaultPieDataset result = new DefaultPieDataset();
			result.setValue("Peripherals", getPeripherals());
			result.setValue("CPU", getcpu());
			result.setValue("GPU", getgpu());
			result.setValue("Motherboard", getmotherboard());
			result.setValue("RAM", getram());
			result.setValue("Storage Device", getstoragedevice());
			return result;
		}

		private JFreeChart createChart(PieDataset dataset, String title) {
			JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, true);
			PiePlot3D plot = (PiePlot3D) chart.getPlot();
			plot.setStartAngle(90);
			plot.setDirection(Rotation.CLOCKWISE);
			plot.setForegroundAlpha(0.5f);
			return chart;
		}

	}

	public int calculateSalesThisYear(JTable table, int index) {
		int total = 0;

		// Column indices for the date column (first column) and the value column
		// (second column)
		int dateColumnIndex = 0; // First column
		int valueColumnIndex = index; // Second column

		// Get the current year
		Calendar currentYear = Calendar.getInstance();

		// Iterate through the rows of the table
		for (int row = 0; row < table.getRowCount(); row++) {
			// Parse the date from the first column as java.sql.Date
			java.sql.Date sqlDate = (java.sql.Date) table.getValueAt(row, dateColumnIndex); // Fully qualify
																							// java.sql.Date

			// Convert the java.sql.Date to java.util.Date
			Date utilDate = new Date(sqlDate.getTime());

			// Format the date as a string in "yyyy-MM-dd" format
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(utilDate);

			// Check if the date belongs to the current year
			if (isDateInCurrentYear(utilDate, currentYear)) {
				Object value = table.getValueAt(row, valueColumnIndex);
				if (value instanceof Number) {
					total += ((Number) value).intValue();
				}
			}
		}

		return total;
	}

	private boolean isDateInCurrentYear(Date date, Calendar currentYear) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR) == currentYear.get(Calendar.YEAR);
	}

	public int calculateSalesThisMonth(JTable table, int index) {
		int total = 0;

		// Column indices for the date column (first column) and the value column
		// (second column)
		int dateColumnIndex = 0; // First column
		int valueColumnIndex = index; // Second column

		// Get the current date and set it to the first day of the current month
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(Calendar.DAY_OF_MONTH, 1);

		// Iterate through the rows of the table
		for (int row = 0; row < table.getRowCount(); row++) {
			// Parse the date from the first column as java.sql.Date
			java.sql.Date sqlDate = (java.sql.Date) table.getValueAt(row, dateColumnIndex); // Fully qualify
																							// java.sql.Date

			// Convert the java.sql.Date to java.util.Date
			Date utilDate = new Date(sqlDate.getTime());

			// Format the date as a string in "yyyy-MM-dd" format
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(utilDate);

			// Check if the date belongs to the current month
			if (isDateInCurrentMonth(utilDate, currentDate)) {
				Object value = table.getValueAt(row, valueColumnIndex);
				if (value instanceof Number) {
					total += ((Number) value).intValue();
				}
			}
		}

		return total;
	}

	private boolean isDateInCurrentMonth(Date date, Calendar currentMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) == currentMonth.get(Calendar.MONTH)
				&& calendar.get(Calendar.YEAR) == currentMonth.get(Calendar.YEAR);
	}

	public int calculateTotalSales(JTable table, int index) {
		int total = 0;

		// Get the number of rows in the table
		int rowCount = table.getRowCount();

		// Column index for the second column (assuming a zero-based index)
		int columnIndex = index; // 1 represents the second column

		// Iterate through the rows and sum the values in the second column
		for (int row = 0; row < rowCount; row++) {
			Object value = table.getValueAt(row, columnIndex);

			if (value instanceof Number) {
				total += ((Number) value).intValue();
			}
			// If your cells contain non-numeric data, you might need additional validation.
			// For example, you can check the type of the cell value before adding it to the
			// total.
		}

		return total;
	}

	public void setPeripherals(int num) {
		peripherals = num;
	}

	public int getPeripherals() {
		return peripherals;
	}

	public void setcpu(int num) {
		cpu = num;
	}

	public int getcpu() {
		return cpu;
	}

	public void setgpu(int num) {
		gpu = num;
	}

	public int getgpu() {
		return gpu;
	}

	public void setmotherboard(int num) {
		motherboard = num;
	}

	public int getmotherboard() {
		return motherboard;
	}

	public void setram(int num) {
		ram = num;
	}

	public int getram() {
		return ram;
	}

	public void setstoragedevice(int num) {
		storagedevice = num;
	}

	public int getstoragedevice() {
		return storagedevice;
	}

	private int peripherals = 0;
	private int cpu = 0;
	private int gpu = 0;
	private int motherboard = 0;
	private int ram = 0;
	private int storagedevice = 0;

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

	private JLabel jLabel1;
	private InvisibleFrame InviFrame;

	static DefaultTableModel model = null;
	private JTable employeeTable;
	private JLabel searchIcon;
	private JComboBox cbDMY;
	private JPanel salesReportContentPanel;
}

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

import utils.ClientRecords;
import utils.DatabaseHandler;
import utils.Product;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dashboard extends DatabaseHandler {

	static JTextField totalAmount;
	private JTextField amountPay;
	private JTextField searchField;
	private static JTable prodTable;
	private IDandPasswords idAndPass = new IDandPasswords();
	private Product category = new Product();
	private JComboBox viewCB;
	private static String dataqty;
	private static JTable cartble;
	private JTextField changeField;
	private BillWindow billwin;
	private JFrame frame;
	private String prod1;
	private String qty1;
	private String price1;
	private Cart cart;
	private ClientRecords clientRec;

	public Dashboard() {
		initialize();
		Connect();
		table_load("product", prodTable);
	}

	public void stockReturn() {
		try {
			for (int row = 0; row < cartble.getRowCount(); row++) {

				String desc = cartble.getValueAt(row, 0).toString();
				String qty = cartble.getValueAt(row, 1).toString();
				int cartQty = Integer.parseInt(qty);
				int newCartQtyVal = cart.getQtyValue();

				pst = con.prepareStatement("SELECT `Qty` FROM `product` WHERE `Description` = '" + desc + "'");
				int currQty = rs.getInt("Qty") - newCartQtyVal;
				int newQty = currQty + cartQty;
				System.out.println(currQty);
				System.out.println(cartQty);
				System.out.println(newQty);

				pst = con.prepareStatement(
						"UPDATE `product` SET `Qty`='" + newQty + "' WHERE Description=" + "'" + desc + "'");
				pst.execute();
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}

	public void checkOut() {
		try {
			double amtpy = Double.parseDouble(amountPay.getText());
			double totaly = Double.parseDouble(totalAmount.getText());

			if (amtpy >= totaly && !amountPay.getText().isEmpty()) {

				getbal();
				makerec();

				for (int row = 0; row < cartble.getRowCount(); row++) {
					String desc = cartble.getValueAt(row, 0).toString();
					String qty = cartble.getValueAt(row, 1).toString();
					int remQty = Integer.parseInt(qty);

					pst = con.prepareStatement("SELECT `Qty` FROM `product` WHERE `Description` = '" + desc + "'");
					ResultSet rs = pst.executeQuery();
					if (rs.next() == true) {
						int currQty = rs.getInt("Qty");
						int newQty = currQty - remQty;

						pst = con.prepareStatement(
								"UPDATE `product` SET `Qty`='" + newQty + "' WHERE Description=" + "'" + desc + "'");
						pst.execute();
						table_load("product", prodTable);
					}

				}

			} else {
				JOptionPane.showMessageDialog(null, "Insufficient Payment");
				table_load("product", prodTable);
			}

		} catch (NumberFormatException t) {
			JOptionPane.showMessageDialog(null, "Insufficient Payment");
			table_load("product", prodTable);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassCastException f) {
			System.out.println("mali");
			JOptionPane.showMessageDialog(null, "Stock not enough");
		}

		DefaultTableModel prodTableModel = (DefaultTableModel) cartble.getModel();
		prodTableModel.setRowCount(0);

		totalAmount.setText("");
		changeField.setText("");
		amountPay.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Dashboard");
		frame.setBounds(100, 100, 1446, 798);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel top = new JPanel();
		top.setBorder(new EmptyBorder(0, 5, 0, 83));
		top.setBackground(new Color(48, 62, 71));
		frame.getContentPane().add(top, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Moon", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));

		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					LoginPage loginpage = new LoginPage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoutBtn.setForeground(new Color(255, 255, 255));
		logoutBtn.setBackground(new Color(48, 62, 71));
		GroupLayout gl_top = new GroupLayout(top);
		gl_top.setHorizontalGroup(gl_top.createParallelGroup(Alignment.LEADING).addGroup(gl_top.createSequentialGroup()
				.addGap(1002).addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
				.addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE).addGap(77)));
		gl_top.setVerticalGroup(gl_top.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_top.createSequentialGroup().addGap(12)
						.addGroup(gl_top.createParallelGroup(Alignment.LEADING).addComponent(logoutBtn)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
						.addContainerGap()));
		top.setLayout(gl_top);

		JPanel left = new JPanel();
		left.setBorder(new EmptyBorder(25, 15, 15, 15));
		left.setBackground(new Color(48, 62, 71));
		frame.getContentPane().add(left, BorderLayout.WEST);
		GridBagLayout gbl_left = new GridBagLayout();
		gbl_left.columnWidths = new int[] { 408 };
		gbl_left.rowHeights = new int[] { 0, 232, 232, 0 };
		gbl_left.columnWeights = new double[] { 1.0 };
		gbl_left.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		left.setLayout(gbl_left);

		JLabel lblNewLabel_2 = new JLabel("Cart");
		lblNewLabel_2.setFont(new Font("Gilroy ExtraBold", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		left.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		left.add(scrollPane_1, gbc_scrollPane_1);

		cartble = new JTable();
		cartble.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Description", "Qty", "Price", "Total Amount" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		scrollPane_1.setViewportView(cartble);

		JPanel buttonPn = new JPanel();
		buttonPn.setBackground(new Color(36, 49, 55));
		GridBagConstraints gbc_buttonPn = new GridBagConstraints();
		gbc_buttonPn.fill = GridBagConstraints.BOTH;
		gbc_buttonPn.gridx = 0;
		gbc_buttonPn.gridy = 2;
		left.add(buttonPn, gbc_buttonPn);
		buttonPn.setLayout(null);

		JButton cleaarBtn = new JButton("Clear");
		cleaarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tbl = (DefaultTableModel) cartble.getModel();
				System.out.println("test");

				tbl.setRowCount(0);
				table_load("product", prodTable);

				totalAmount.setText("");
				changeField.setText("");
				amountPay.setText("");
			}
		});
		cleaarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				amountPay.setText("");
			}
		});

		cleaarBtn.setFont(new Font("Tahoma", Font.ITALIC, 11));
		cleaarBtn.setBackground(new Color(187, 214, 249));
		cleaarBtn.setBounds(69, 113, 143, 37);
		buttonPn.add(cleaarBtn);

		JButton removeBtn = new JButton("Remove");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		removeBtn.setFont(new Font("Tahoma", Font.ITALIC, 11));
		removeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					DefaultTableModel tbl = (DefaultTableModel) cartble.getModel();
					int i = cartble.getSelectedRow();

					String desc = cartble.getValueAt(i, 0).toString();
					String qty = cartble.getValueAt(i, 1).toString();
					int cartQty = Integer.parseInt(qty);

					pst = con.prepareStatement("SELECT `Qty` FROM `product` WHERE `Description` = '" + desc + "'");
					int currQty = rs.getInt("Qty") - cartQty;
					int newQty = currQty + cartQty;

					pst = con.prepareStatement(
							"UPDATE `product` SET `Qty`='" + newQty + "' WHERE Description=" + "'" + desc + "'");
					pst.execute();
					table_load("product", prodTable);
					tbl.removeRow(i);

				} catch (ArrayIndexOutOfBoundsException o) {
					JOptionPane.showMessageDialog(null, "No Item Selected");
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		removeBtn.setBackground(new Color(255, 255, 255));
		removeBtn.setBounds(222, 113, 151, 37);
		buttonPn.add(removeBtn);

		JButton btnNewButton_2 = new JButton("Check out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkOut();
			}
		});

		btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton_2.setBackground(new Color(201, 242, 168));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(69, 161, 304, 37);
		buttonPn.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("Total Sales:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(238, 168, 82));
		lblNewLabel.setBounds(106, 18, 106, 14);
		buttonPn.add(lblNewLabel);

		totalAmount = new JTextField();
		totalAmount.setEditable(false);
		totalAmount.setHorizontalAlignment(SwingConstants.CENTER);
		totalAmount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		totalAmount.setForeground(new Color(238, 168, 82));
		totalAmount.setBackground(Color.BLACK);
		totalAmount.setBounds(222, 7, 151, 25);
		buttonPn.add(totalAmount);
		totalAmount.setColumns(10);

		JLabel lblAmountPayed = new JLabel("Amount Payed: ");
		lblAmountPayed.setForeground(Color.WHITE);
		lblAmountPayed.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAmountPayed.setBounds(69, 82, 143, 20);
		buttonPn.add(lblAmountPayed);

		amountPay = new JTextField();
		amountPay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					checkOut();
				}
			}
		});
		amountPay.setFont(new Font("Arial Black", Font.PLAIN, 15));
		amountPay.setHorizontalAlignment(SwingConstants.CENTER);
		amountPay.setBounds(222, 77, 151, 25);
		buttonPn.add(amountPay);
		amountPay.setColumns(10);

		JLabel lblChange = new JLabel("Change:");
		lblChange.setForeground(Color.WHITE);
		lblChange.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChange.setBounds(136, 49, 76, 22);
		buttonPn.add(lblChange);

		changeField = new JTextField();
		changeField.setBackground(new Color(160, 238, 82));
		changeField.setEditable(false);
		changeField.setHorizontalAlignment(SwingConstants.CENTER);
		changeField.setFont(new Font("Arial Black", Font.PLAIN, 15));
		changeField.setColumns(10);
		changeField.setBounds(222, 41, 151, 25);
		buttonPn.add(changeField);

		JPanel body = new JPanel();
		body.setBackground(new Color(233, 233, 233));
		body.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(body, BorderLayout.CENTER);

		JLabel lblNewLabel_3 = new JLabel("Available Products");
		lblNewLabel_3.setBounds(15, 0, 239, 37);
		lblNewLabel_3.setFont(new Font("Gilroy ExtraBold", Font.BOLD, 25));

		searchField = new JTextField();
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					skuSearch(searchField);
				}
			}
		});
		searchField.setBounds(15, 44, 313, 23);
		searchField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skuSearch(searchField);
			}
		});
		btnSearch.setBounds(338, 43, 84, 23);
		btnSearch.setBackground(new Color(187, 214, 249));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 78, 923, 604);

		prodTable = new JTable();
		prodTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column" }) {
			boolean[] columnEditables = new boolean[] { false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		prodTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		prodTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					int row = prodTable.getSelectedRow();
					String Table_click = (prodTable.getModel().getValueAt(row, 0).toString());
					pst = con.prepareStatement("select * from product where sku ='" + Table_click + "'  ");
					rs = pst.executeQuery();

					if (rs.next()) {
						String pDesc = rs.getString("description");
						String pPrice = rs.getString("price");
						String totp = rs.getString("price");
						dataqty = rs.getString("qty");
						cart = new Cart();
						cart.setSku(Table_click);
						cart.setdesc(pDesc);
						cart.setprice(pPrice);
						cart.setTot(totp);

						skuSearched = Table_click;
					}

				} catch (Exception f) {
					f.printStackTrace();

				}
			}
		});

		prodTable.setFont(new Font("Tahoma", Font.PLAIN, 13));

		scrollPane.setViewportView(prodTable);

		JLabel lblNewLabel_4 = new JLabel("View by category:");
		lblNewLabel_4.setBounds(440, 44, 117, 19);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		viewCB = new JComboBox(category.getCategoryArray());
		viewCB.setBounds(575, 42, 139, 23);
		viewCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		viewCB.addItem("All");
		viewCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sortView("product", "Category", viewCB, prodTable);
			}

		});

		JLabel lblNewLabel_5 = new JLabel("SKU search");
		lblNewLabel_5.setBounds(15, 29, 54, 14);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 11));
		body.setLayout(null);
		body.add(searchField);
		body.add(btnSearch);
		body.add(lblNewLabel_4);
		body.add(viewCB);
		body.add(scrollPane);
		body.add(lblNewLabel_5);
		body.add(lblNewLabel_3);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static JTable bringTable() {
		return cartble;
	}

	public static String getdataqty() {
		return dataqty;
	}

	public static void setdataqty(String qty) {
		dataqty = qty;
	}

	public void getbal() {
		double tot = Double.parseDouble(totalAmount.getText());
		double pay = Double.parseDouble(amountPay.getText());

		float bal = (float) (pay - tot);
		changeField.setText(String.valueOf(bal));

	}

	public void makerec() {
		String total = totalAmount.getText();
		String pay = amountPay.getText();
		String change = changeField.getText();

		DefaultTableModel model = new DefaultTableModel();
		model = (DefaultTableModel) cartble.getModel();
		clientRec = new ClientRecords();
		clientRec.setTotalSales(totalAmount.getText());
		clientRec.setAmountPayed(amountPay.getText());
		clientRec.setChange(changeField.getText());
		if (model.getRowCount() > 0) {
			billwin = new BillWindow();

			billwin.getRec()
					.setText("=========================================\n" + "	        **POSBILL**				  \n"
							+ "=========================================\n" + "\n" + "\n" + "Qty" + "\t" + "Price"
							+ "\t" + "Product\n");
			String finalClientRec = "";
			for (int i = 0; i < model.getRowCount(); i++) {

				prod1 = (String) model.getValueAt(i, 0);
				qty1 = (String) model.getValueAt(i, 1);
				price1 = (String) model.getValueAt(i, 2);

				String clientRecordsItems = (prod1 + " (price: " + price1 + ") (qty: " + qty1 + ") ||");
				finalClientRec = (finalClientRec + clientRecordsItems);
				clientRec.setItems(finalClientRec);
				billwin.getRec().setText(billwin.getRec().getText() + qty1 + "\t" + price1 + "\t" + prod1 + "\n");
			}

			billwin.getRec().setText(billwin.getRec().getText() + "\n");
			billwin.getRec().setText(billwin.getRec().getText() + "\n");
			billwin.getRec().setText(billwin.getRec().getText() + "\t\tTotal amount: " + total + "\n");
			billwin.getRec().setText(billwin.getRec().getText() + "\t\tCash Received: " + pay + "\n");
			billwin.getRec().setText(billwin.getRec().getText() + "\t\tChange: " + change + "\n");
			billwin.getRec().setText(billwin.getRec().getText() + "\n");
			billwin.getRec().setText(billwin.getRec().getText() + "\n");
			billwin.getRec().setText(billwin.getRec().getText() + "=========================================\n");
			billwin.getRec().setText(billwin.getRec().getText() + "THIS IS YOUR OFFICIAL RECEIPT, THANK YOU!\n");
			billwin.getRec().setText(billwin.getRec().getText() + "=========================================\n");

			saveToDatabase(clientRec);
		}

	}

	public static JTable getProductTable() {
		return prodTable;
	}
}

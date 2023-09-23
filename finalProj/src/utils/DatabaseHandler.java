package utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Main.Cart;
import Main.Dashboard;
import net.proteanit.sql.DbUtils;

public class DatabaseHandler {

	public Connection con;
	public PreparedStatement pst;
	public ResultSet rs;

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/posproject", "root", "");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// for the product table
	public void saveToDatabase(Product prod) throws Exception {
		String sku, desc, cat, qty, price;
		sku = prod.getSku();
		desc = prod.getDescription();
		cat = prod.getCategory();
		qty = prod.getQty();
		price = prod.getPrice();

		try {
			pst = con.prepareStatement("insert into product(SKU,Description,Category,Qty,Price)values(?,?,?,?,?)");
			pst.setString(1, sku);
			pst.setString(2, desc);
			pst.setString(3, cat);
			pst.setString(4, qty);
			pst.setString(5, price);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Product added successfully");
		}

		catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,
					"Error:\n[INVALID INPUT] must put numerical value in price and qty field\nor\n[EXISTING SKU FOUND] there is existing product with that SKU");
			throw new Exception();
		}
	}

	public void saveToDatabase(ClientRecords cr) {
		String items, totalSales, amountPayed, change;
		items = cr.getReceipt();
		totalSales = cr.getTotalSales();
		amountPayed = cr.getAmountPayed();
		change = cr.getChange();
		try {
			pst = con.prepareStatement(
					"insert into `clientrecords`(`Date`, `Items`, `TotalSales`, `Amount Payed`, `Change_`)values(?,?,?,?,?)");
			pst.setDate(1, cr.getDate());
			pst.setString(2, items);
			pst.setString(3, totalSales);
			pst.setString(4, amountPayed);
			pst.setString(5, change);
			pst.executeUpdate();
		}

		catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Unexpected Error Occurred");
		}
	}

	// for the activity logs table
	public void saveToDatabase(ActivityLogs logs) {
		Date date;
		String sku, desc, act, qty, changeby, remarks;
		date = logs.getDate();
		sku = logs.getSku();
		desc = logs.getDescription();
		act = logs.getActivity();
		qty = logs.getQty();
		changeby = logs.getChangeBy();
		remarks = logs.getRemarks();

		try {
			pst = con.prepareStatement(
					"insert into activitylogs(`Date`, `SKU`, `Description`, `Activity`, `Qty`, `Changed by`, `Remarks`)values(?,?,?,?,?,?,?)");
			pst.setDate(1, date);
			pst.setString(2, sku);
			pst.setString(3, desc);
			pst.setString(4, act);
			pst.setString(5, qty);
			pst.setString(6, changeby);
			pst.setString(7, remarks);
			pst.executeUpdate();
		}

		catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Unexpected Error Occurred");
		}
	}

	public void saveToDatabase(Employee employee) {
		String id, name, birthday, username, password;

		id = employee.getID();
		name = employee.getName();
		birthday = employee.getBirthday();
		username = employee.getUsername();
		password = employee.getPassword();

		try {
			pst = con.prepareStatement(
					"insert into employee(`Name`, `Birthday`, `Username`, `Password`)values(?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, birthday);
			pst.setString(3, username);
			pst.setString(4, password);
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Unexpected Error Occurred");
		}

	}

	public void sortView(String dbTableName, String colName, JComboBox viewCB, JTable table) {
		try {
			String chosen = (String) viewCB.getSelectedItem();

			pst = con.prepareStatement("select * from " + dbTableName + " where " + colName + " = ?");
			pst.setString(1, chosen);
			ResultSet rs = pst.executeQuery();

			if (rs.next() == true) {

				rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));

			} else if (chosen.contains("All")) {
				table_load(dbTableName, table);
			} else {
				JOptionPane.showMessageDialog(null, "No existing " + dbTableName + " in this type of " + colName);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}

	public void updateStockQty(int changedQty, String sku) {
		try {
			pst = con.prepareStatement("UPDATE `product` SET `Qty`='" + changedQty + "' WHERE SKU=" + "'" + sku + "'");
			pst.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Please search first the sku");
			e1.printStackTrace();
		}
	}

	// loads the table from the database
	public void table_load(String dbTablename, JTable table) {
		try {
			pst = con.prepareStatement("select * from " + dbTablename);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String skuSearched;
	protected String qtyResult;

	// search query for the database
	public void skuSearch(JTextField skuField, JTextField descField, JTextField qtyField) {
		try {

			skuSearched = skuField.getText();

			pst = con.prepareStatement("select Description,Qty from product where SKU = ?");
			pst.setString(1, skuSearched);
			ResultSet rs = pst.executeQuery();

			if (rs.next() == true) {

				String desc = rs.getString(1);
				qtyResult = rs.getString(2);
				JOptionPane.showMessageDialog(null, "Product Found");
				descField.setText(desc);
				qtyField.setText(qtyResult);

			} else {
				JOptionPane.showMessageDialog(null, "Product NOT Found");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}

	}

	public void skuSearch(JTextField skuField) {
		try {

			skuSearched = skuField.getText();

			pst = con.prepareStatement("select SKU,Description,Qty,Price from product where SKU = ?");
			pst.setString(1, skuSearched);
			ResultSet rs = pst.executeQuery();

			if (rs.next() == true) {
				Cart cart = new Cart();
				String sku = rs.getString(1);
				String desc = rs.getString(2);
				String qty = rs.getString(3);
				String price = rs.getString(4);
				Dashboard.setdataqty(qty);
				cart.setSku(sku);
				cart.setdesc(desc);
				cart.setprice(price);
				cart.setTot(price);

			} else {
				JOptionPane.showMessageDialog(null, "Product NOT Found");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}

	public void credentialsSearch(String username) {
		
	}

	public void deleteRow(String dbTablename, String columnReference, String columnVal) {
		try {
			pst = con.prepareStatement("DELETE FROM " + dbTablename + " WHERE " + columnReference + "=?");
			pst.setString(1, columnVal);
			pst.execute();

			JOptionPane.showMessageDialog(null, "Successfully deleted a product completely");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Unexpected Error in deleting a row");
		}
	}

	public void setSkuSelected(String sku) {
		skuSearched = sku;
	}

	public void deleteAllData(String tableName) {
		try {
			pst = con.prepareStatement("DELETE FROM " + tableName);
			pst.execute();
			JOptionPane.showMessageDialog(null, "You successfully deleted all data and the table");
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
}

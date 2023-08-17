package utils;

import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ClientRecords {
	private Date date;
	private String items;
	private String totalSales;
	private String amountPayed;
	private String change;
	
	
	
	public Date getDate() {
		date = new Date(System.currentTimeMillis());
		return date;
	}
	
	public void setItems(String items) {
		this.items = items; 
	}
	
	public void setTotalSales(String totalSales) {
		this.totalSales = totalSales;
	}
	
	public void setAmountPayed(String amountPayed) {
		this.amountPayed = amountPayed;
	}
	
	public void setChange(String change) {
		this.change = change;
	}
	
	
	public String getReceipt() {
		return items;
	}
	public String getTotalSales() {
		return totalSales;
	}
	public String getAmountPayed() {
		return amountPayed;
	}
	public String getChange() {
		return change;
	}
}

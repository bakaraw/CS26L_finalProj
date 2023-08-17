package utils;

import java.sql.Date;


public class ActivityLogs {
	private Date date;
	private String sku;
	private String desc;
	private String activity;
	private String[] activityType = {"All", "Stock in", "Stock removal", "Deleted product"};
	private String qty;
	private String changedby;
	private String remarks; 
	
	public Date getDate() {
		date = new Date(System.currentTimeMillis());
		return date;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	public void setDescription(String desc) {
		this.desc = desc;
	}
	public void setActivity(String act) {
		this.activity = act;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public void setChangeBy(String changeby) {
		this.changedby = changeby;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	public String getSku() {
		return sku;
	}
	public String getDescription() {
		return desc;
	}
	public String getActivity() {
		return activity;
	}
	public String getQty() {
		return qty;
	}
	public String getChangeBy() {
		return changedby;
	}
	public String getRemarks() {
		return remarks;
	}
	public String[] getActArray() {
		return activityType;
	}

}

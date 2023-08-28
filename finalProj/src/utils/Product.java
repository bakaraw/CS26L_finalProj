package utils;

public class Product {
	private String sku;
	private String desc;
	private String[] categoryArr = { "Peripherals", "CPU", "GPU", "Motherboard", "RAM", "Storage device" };
	private String category;
	private String qty;
	private String price;

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setDescription(String desc) {
		this.desc = desc;
	}

	public void setCategory(String cat) {
		this.category = cat;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public String getDescription() {
		return desc;
	}

	public String getCategory() {
		return category;
	}

	public String getQty() {
		return qty;
	}

	public String getPrice() {
		return price;
	}

	public String[] getCategoryArray() {
		return categoryArr;
	}

	public String getCategoryByIndex(int index) {
		return categoryArr[index];
	}
}

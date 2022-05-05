package productManage;

public abstract class Product {
	private String productID;
	private String productName;
	private int number;
	private double price;
	abstract float computeMoney();
	public Product(String productID, String productName, int number, double price) {
		super();
		setProductID(productID);
		setProductName(productName);
		setNumber(number);
		setPrice(price);
	}
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}

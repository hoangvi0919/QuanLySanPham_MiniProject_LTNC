package productManage;

public class Phone extends Product{

	public Phone(String productID, String productName, int number, double price) {
		super(productID, productName, number, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	float computeMoney() {
		float result= (float) (getPrice()*getNumber()* (1-0.2));
		return result;
	}

}

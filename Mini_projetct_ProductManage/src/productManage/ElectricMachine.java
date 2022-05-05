package productManage;

public class ElectricMachine extends Product{

	public ElectricMachine(String productID, String productName, int number, double price) {
		super(productID, productName, number, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	float computeMoney() {
		float result = (float) (getPrice()*getNumber()*(1-0.1));
		return result;
	}
	
}

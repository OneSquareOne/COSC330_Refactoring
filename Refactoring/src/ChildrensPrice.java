
public class ChildrensPrice extends Price {

	public ChildrensPrice() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPriceCode() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public double getCharge(int daysRented) {
		double rentalPrice = 1.5;
		if (daysRented > 3)
			rentalPrice += (daysRented - 3) * 1.5;
		return rentalPrice;
	}

}

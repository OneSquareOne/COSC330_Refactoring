
public class RegularPrice extends Price{

	public RegularPrice() {
	}

	@Override
	public int getPriceCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCharge(int daysRented) {
		// TODO Auto-generated method stub
		double rentalPrice = 2;
		if (daysRented > 2)
			rentalPrice += (daysRented - 2) * 1.5;
		return rentalPrice;
	}
}

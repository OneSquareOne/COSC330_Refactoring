
public class NewReleasePrice extends Price {

	public NewReleasePrice() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPriceCode() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double getCharge(int daysRented) {
		
		return daysRented * 3;
	}
}

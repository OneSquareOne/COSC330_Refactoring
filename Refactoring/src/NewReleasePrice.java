
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
	
	@Override
	public int getFrequentRenterPoints(int daysRented) {
		int frequentRenterPoints = 1;
		if (daysRented > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
}

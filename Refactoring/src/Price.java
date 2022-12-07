
public abstract class Price {
	abstract public int getPriceCode();
	abstract public double getCharge(int daysRented);
	public int getFrequentRenterPoints(int daysRented) {
		int frequentRenterPoints = 1;
		return frequentRenterPoints;
	}
}

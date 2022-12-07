
public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
    
    public double getCharge(int daysRented) {
    	double rentalPrice = 0;
    	switch (this.getPriceCode()) {
		case Movie.REGULAR:
			rentalPrice += 2;
			if (daysRented > 2)
				rentalPrice += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			rentalPrice += daysRented * 3;
			break;
		case Movie.CHILDREN:
			rentalPrice += 1.5;
			if (daysRented > 3)
				rentalPrice += (daysRented - 3) * 1.5;
			break;
		}
    	return rentalPrice;
    }
    
    public int getFreqeuntRenterPoints(int daysRented) {
		int frequentRenterPoints = 1;
		// add bonus for a two day new release rental
		if (this.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
    }

}


public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price moviePrice;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return moviePrice.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
    	if(priceCode == CHILDREN) {
    		moviePrice = new ChildrensPrice();
    	}else if(priceCode == REGULAR) {
    		moviePrice = new RegularPrice();
    	}else if(priceCode == NEW_RELEASE) {
    		moviePrice = new NewReleasePrice();
    	}
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

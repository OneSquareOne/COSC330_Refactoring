
public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price moviePrice;

    public Movie(String title, Price priceCode) {
        this.title = title;
        this.setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return moviePrice.getPriceCode();
    }

    public void setPriceCode(Price priceCode) {
    		moviePrice = priceCode;
    }
    
    public double getCharge(int daysRented) {
    
    	return moviePrice.getCharge(daysRented);
    }
    
    public int getFreqeuntRenterPoints(int daysRented) {
		return moviePrice.getFrequentRenterPoints(daysRented);
    }

}

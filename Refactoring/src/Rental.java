import java.util.ArrayList;
import java.util.List;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
    
    public double getCharge() {
    	double rentalPrice = 0;
		switch (this.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			rentalPrice += 2;
			if (this.getDaysRented() > 2)
				rentalPrice += (this.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			rentalPrice += this.getDaysRented() * 3;
			break;
		case Movie.CHILDREN:
			rentalPrice += 1.5;
			if (this.getDaysRented() > 3)
				rentalPrice += (this.getDaysRented() - 3) * 1.5;
			break;
		}
		return rentalPrice;
    }

}
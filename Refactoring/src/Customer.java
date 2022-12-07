import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    @Test
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double amount = 0;
           
            amount = amountFor(rental);

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amount) + "\n";

            totalAmount += amount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }
    
    public double amountFor(Rental rental) {
    	double rentalPrice = 0;
    	switch (rental.getMovie().getPriceCode()) {
        case Movie.REGULAR:
        	rentalPrice += 2;
            if (rental.getDaysRented() > 2)
            	rentalPrice += (rental.getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
        	rentalPrice += rental.getDaysRented() * 3;
            break;
        case Movie.CHILDREN:
        	rentalPrice += 1.5;
            if (rental.getDaysRented() > 3)
            	rentalPrice += (rental.getDaysRented() - 3) * 1.5;
            break;
    }
    	return rentalPrice;
    }
}
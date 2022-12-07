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

	//fixed in 2-2
	public double amountFor(Rental rental)  {
	
		return rental.getCharge();
	}
}
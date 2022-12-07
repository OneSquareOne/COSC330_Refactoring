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

	public String statement() {
		int frequentRenterPoints = 0;

		String result = "Rental record for " + getName() + "\n";
		for (Rental rental : rentals) {
			frequentRenterPoints += rental.getFrequentRenterPoints();

			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amountFor(rental)) + "\n";
		}

		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

		return result;
	}

	//fixed in 2-2
	public double amountFor(Rental rental)  {
	
		return rental.getCharge();
	}
	
	public double getTotalCharge() {
		double totalAmount = 0;
		for (Rental rental : rentals) {
		totalAmount += amountFor(rental);
		}
		return totalAmount;
	}
}
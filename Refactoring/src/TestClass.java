import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TestClass {

	private Price newReleasePrice = new NewReleasePrice();
	private Price childrensPrice = new ChildrensPrice();
	private Price regularPrice = new RegularPrice();
	private Movie THE_HULK=new Movie("The Hulk", childrensPrice);
	private Movie IRON_MAN = new Movie("Iron Man 4", newReleasePrice);
	private Movie SPIDER_MAN = new Movie("Spiderman", regularPrice);

	private final Customer customer = new Customer("fred");

	@Test
	public void basicChildrenRental() {
		customer.addRental(new Rental(THE_HULK, 2));
		assertEquals(customer.statement(),
				"Rental record for fred\n\tThe Hulk\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points");
	}

	@Test
	public void shouldDiscountChildrensRentals() {
		customer.addRental(new Rental(THE_HULK, 4));
		assertEquals(customer.statement(),
				"Rental record for fred\n\tThe Hulk\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points");
	}

	@Test
	public void basicNewReleaseRental() {
		customer.addRental(new Rental(IRON_MAN, 1));
		assertEquals(customer.statement(),
				"Rental record for fred\n\tIron Man 4\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points");
	}

	@Test
	public void shouldNotDiscountNewReleaseRentalsButBonusFrequentRenterPoints() {
		customer.addRental(new Rental(IRON_MAN, 4));
		assertEquals(customer.statement(),
				"Rental record for fred\n\tIron Man 4\t12.0\nAmount owed is 12.0\nYou earned 2 frequent renter points");
	}

	@Test
	public void basicRegularRental() {
		customer.addRental(new Rental(SPIDER_MAN, 2));
		assertEquals(customer.statement(),
				"Rental record for fred\n\tSpiderman\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points");
	}

	@Test
	public void shouldDiscountRegularRental() {
		customer.addRental(new Rental(SPIDER_MAN, 4));
		assertEquals(customer.statement(),
				"Rental record for fred\n\tSpiderman\t5.0\nAmount owed is 5.0\nYou earned 1 frequent renter points");
	}

	@Test
	public void shouldSumVariousRentals() {
		customer.addRental(new Rental(THE_HULK, 2));
		customer.addRental(new Rental(SPIDER_MAN, 1));
		customer.addRental(new Rental(IRON_MAN, 3));
		assertEquals(customer.statement(),
				"Rental record for fred\n\tThe Hulk\t1.5\n\tSpiderman\t2.0\n\tIron Man 4\t9.0\nAmount owed is 12.5\nYou earned 4 frequent renter points");

	}

}

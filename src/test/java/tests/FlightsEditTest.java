package tests;

import org.testng.annotations.Test;

public class FlightsEditTest extends BaseTest {

	@Test(description = "chooseTabinMainpage and type of flght")
	public void tc01_choosetab() {
		mainPage.flightsTab();
	}

	@Test(description = "chooseDepartureCountry")
	public void tc02_chooseDeparture() {
		mainPage.departureCountry("Israel", "Tel Aviv");
	}

	@Test(description = "chooseDestinationCountry")
	public void tc03_chooseDestinationCountry() {
		mainPage.destinationCountry("Hungary", "Budapest");
	}

	@Test(description = "chooseDepartureDate")
	public void tc04_chooseDepartureDate() {
		mainPage.departureDate("Apr", "23");
	}

	@Test(description = "chooseReturnDate")
	public void tc05_chooseReturnDate() {
		mainPage.returnDate("Apr", "30");
	}

	@Test(description = "choosePassengersAmount")
	public void tc06_choosePassengersAmount() {
		mainPage.passengersAmount();
	}

	@Test(description = "searchFlights")
	public void tc07_searchFlights() {
		mainPage.searchFlights();
	}

	@Test(description = "edit new search by changing depart and return dates and amount of passengers ")
	public void tc08_editNewSearch() {
		flightsPage.editNewSearch("25", "28");
	}

	@Test(description = "select new dpt date")
	public void tc09_newDptDate() {
		flightsPage.newDptDate("Thursday");
	}

	@Test(description = "select new rtn date")
	public void tc10_newRtnDate() {
		flightsPage.newRtnDate("Sunday");
	}

	@Test(description = "choose your fare")
	public void tc11_fareOption() {
		flightsPage.fareOptin();
	}

	@Test(description = "fill one passengers details")
	public void tc12_fillOnePassenfersDetails() {
		flightsPage.onePassengerGender("Mrs");
		flightsPage.passengerDetails("Yuval", "Haddy");
	}

	@Test(description = "fill second passengers details")
	public void tc13_fillsecondpassengersDetails() {
		flightsPage.secondPassengerGender("Mr");
		flightsPage.secondPassengersDetails("Eli", "Haddy");
		flightsPage.continueNextPage();
	}

}

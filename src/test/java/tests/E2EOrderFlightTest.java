package tests;

import org.testng.annotations.Test;

import pageobjects.ExtrasPage;

public class E2EOrderFlightTest extends BaseTest {

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

	@Test(description = "choose the cheapest departure flight")
	public void tc08_minDeparturePrice() {
		flightsPage.cheapestDepartureFlight();
	}

	@Test(description = "choose the cheapest return flight")
	public void tc09_minReturnPrice() {
		flightsPage.cheapestReturnFlight();
	}

	@Test(description = "choose your fare")
	public void tc10_fareOption() {
		flightsPage.fareOptin();
	}

	@Test(description = "fill passengers details")
	public void tc11_fillDetails() {
		flightsPage.onePassengerGender("Mrs");
		flightsPage.passengerDetails("Yuval", "Haddy");
		flightsPage.continueNextPage();
	}

	@Test(description = "chooseDptSeats")
	public void tc12_chooseDptSeats() {
		seatsPage.chooseDptSeats("5");
	}

	@Test(description = "chooseRtnSeats")
	public void tc13_chooseRtnSeats() {
		seatsPage.chooseDptSeats("5");
	}

	@Test(description = "fastTrack")
	public void tc14_choosefastTrack() {
		seatsPage.fastTrack();
	}

	@Test(description = " addSmallbegs")
	public void tc15_addSmallBags() {
		bagsPage.addSmallBags();
	}

	@Test(description = " addLargeBegs")
	public void tc16_addLargeBegs() {
		bagsPage.addLargeBegs();
	}

	@Test(description = "removeLargeBegs")
	public void tc17_removeLargeBegs() {
		bagsPage.removeLargeBegs();
	}

	@Test(description = " add begs")
	public void tc18_continueBagsPage() {
		bagsPage.continueNextPage();
	}

	@Test(description = "addAmountCreditExtrasPage")
	public void tc19_addAmountCredit() {
		extrasPage.addAmountCredit();
	}

	@Test(description = "extrasPage")
	public void tc20_continueToTheNextPage() {
		extrasPage.continueToNextPage();
	}

	@Test(description = "continueToTheLastPage")
	public void tc21_continueToTheLastPage() {
		extrasPage.continueToLastPage();
	}

}

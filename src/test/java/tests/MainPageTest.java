package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

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
		mainPage.destinationCountry("Malta", "Malta");
	}

	@Test(description = "chooseAnotherDestination")
	public void tc04_chooseDestination() {
		mainPage.chooseAnotherDestination();
	}

	@Test(description = "chooseDestinationCountry")
	public void tc05_chooseDestinationCountry() {
		mainPage.destinationCountry("Italy", "Milan Bergamo");
	}

	@Test(description = "chooseDate")
	public void tc06_choosedate() {
		mainPage.chooseMandatoryDate();
	}

	@Test(description = "add and remove All Kind Of Passengers Amount")
	public void tc07_addAllKindOfPassengersAmount() {
		mainPage.addAllKindOfPassengersAmount();
		String actual = mainPage.passengersMsg();
		String expected = "3 Adults, 1 Other";
		Assert.assertEquals(actual, expected);
	}

}

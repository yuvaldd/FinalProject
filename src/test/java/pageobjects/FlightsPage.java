package pageobjects;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightsPage extends MenuPage {

	@FindBy(css = ".flight-card-summary__select-btn.ng-tns-c2051464752-18")
	private WebElement selectDPTBtn;
	@FindBy(css = ".flight-card-summary__select-btn.ng-tns-c2051464752-20")
	private WebElement selectRTNnBtn;
	@FindBy(css = ".fare-table__fare-column-border--regu")
	private WebElement fareBtn;

	@FindBy(css = ".dropdown__toggle.body-l-lg")
	private WebElement genderBtn;
	@FindBy(css = "[data-ref='pax-details__ADT-1'] .dropdown__toggle.body-l-lg")
	private WebElement secondGenderBtn;
	@FindBy(css = "#form\\.passengers\\.ADT-0\\.name ")
	private WebElement firstNameFiledPsngr;
	@FindBy(css = "#form\\.passengers\\.ADT-0\\.surname ")
	private WebElement lastNameFiledPsngr;
	@FindBy(css = "#form\\.passengers\\.ADT-1\\.name")
	private WebElement firstNameFiledScndPsngr;
	@FindBy(css = "#form\\.passengers\\.ADT-1\\.surname")
	private WebElement lastNameFiledScndPsngr;
	@FindBy(css = ".continue-flow__button.ry-button--gradient-yellow")
	private WebElement continueBtn;

	@FindBy(css = ".details__edit-search.ry-button--small")
	private WebElement editSearchBtn;
	@FindBy(css = "fsw-input-button.ng-trigger-datesFromTripTypeChange")
	private WebElement departBtn;
	@FindBy(css = "ry-counter:nth-child(3) > div.counter > div:nth-child(3)")
	private WebElement passengersAddAdultsBtn;
	@FindBy(css = ".passengers__confirm-button.ry-button--anchor-blue")
	private WebElement passengersOkBtn;
	@FindBy(css = "div>button>.ng-tns-c983940023-18.ng-star-inserted")
	private WebElement searchAgainBtn;
	@FindBy(css = ".flight-card-summary__select-btn.ng-tns-c2051464752-16")
	private WebElement newDptSelectBtn;
	@FindBy(css = ".flight-card-summary__select-btn.ng-tns-c2051464752-14")
	private WebElement newRtnSelectBtn;

	@FindBy(css = ".calendar-body__cell-wrap.ng-star-inserted")
	private List<WebElement> dayDepartList;
	@FindBy(css = ".item.ng-tns-c556924221-10.ng-star-inserted")
	private List<WebElement> selectDayDepartList;
	@FindBy(css = ".item.ng-tns-c556924221-9.ng-star-inserted")
	private List<WebElement> selectDayRtnList;
	//

	@FindBy(css = ".item.ng-tns-c556924221-10.ng-star-inserted")
	private List<WebElement> priceDPTList;
	@FindBy(css = ".item.ng-tns-c556924221-9.ng-star-inserted")
	private List<WebElement> priceRTNList;
	@FindBy(css = ".fare-table__fare-column.ng-star-inserted")
	private List<WebElement> fareList;
	@FindBy(css = ".dropdown__menu-items ry-dropdown-item")
	private List<WebElement> genderList;

	public FlightsPage(WebDriver driver) {
		super(driver);
	}

	// choose the cheapest departure flight
	public void cheapestDepartureFlight() {
		waiting(2000);
		int minDPTPrice = Integer.MAX_VALUE;
		WebElement minDPTWeb = null;
		waiting(2000);
		for (WebElement el : priceDPTList) {
			waiting(2000);
			WebElement PriceDPTFlight = el
					.findElement(By.cssSelector("[class^='price__integers carousel-date-price']"));
			String priceDPTStr = getText(PriceDPTFlight);
			int priceDPTNum = Integer.parseInt(priceDPTStr);
			if (priceDPTNum < minDPTPrice) {
				minDPTPrice = priceDPTNum;
				minDPTWeb = PriceDPTFlight;
				waiting(1000);
			}
		}
		waiting(1000);
		click(minDPTWeb);
		waiting(2000);
		click(selectDPTBtn);
	}

	// choose the cheapest return flight
	public void cheapestReturnFlight() {
		waiting(2000);
		scrollDown();
		int minRTNPrice = Integer.MAX_VALUE;
		WebElement minRTNWeb = null;
		waiting(2000);
		for (WebElement el : priceRTNList) {
			waiting(2000);
			WebElement PriceRTNFlight = el
					.findElement(By.cssSelector("[class^='price__integers carousel-date-price']"));
			String priceRTNStr = getText(PriceRTNFlight);
			int priceRTNNum = Integer.parseInt(priceRTNStr);
			if (priceRTNNum < minRTNPrice) {
				minRTNPrice = priceRTNNum;
				minRTNWeb = PriceRTNFlight;
				waiting(1000);
			}
		}
		waiting(1000);
		click(minRTNWeb);
		waiting(2000);
		click(selectRTNnBtn);
	}

	public void fareOptin() {
		waiting(2000);
		scrollDown();
		waiting(2000);
		scrollDown();
		click(fareBtn);
	}

	// choose  one passenger gender
	public void onePassengerGender(String gender) {
		waiting(2000);
		scrollDown();
		waiting(2000);
		scrollDown();
		click(genderBtn);
		waiting(2000);
		for (WebElement el : genderList) {
			waiting(2000);
			WebElement genderTtl = el.findElement(By.cssSelector(".dropdown-item__label.body-l-lg.body-l-sm"));
			if (getText(genderTtl).contains(gender)) {
				click(genderTtl);
				break;
			}
		}
	}
	
	//choose second passenger gender
	
	public void secondPassengerGender(String gender) {
		waiting(2000);
		scrollDown();
		waiting(2000);
		scrollDown();
		click(secondGenderBtn);
		waiting(2000);
		for (WebElement el : genderList) {
			waiting(2000);
			WebElement genderTtl = el.findElement(By.cssSelector(".dropdown-item__label.body-l-lg.body-l-sm"));
			if (getText(genderTtl).contains(gender)) {
				click(genderTtl);
				break;
			}
		}
	}

	// fill one passenger details
	public void passengerDetails(String firstName, String LastName) {
		waiting(1000);
		scrollDown();
		fillText(firstNameFiledPsngr, firstName);
		waiting(1000);
		fillText(lastNameFiledPsngr, LastName);
		waiting(1000);
	}
	
	// fill second passenger details
	public void secondPassengersDetails(String firstName, String LastName) {
		waiting(1000);
		scrollDown();
		fillText(firstNameFiledScndPsngr, firstName);
		waiting(1000);
		fillText(lastNameFiledScndPsngr, LastName);
		waiting(1000);
	}

	// continue
	public void continueNextPage() {
		click(continueBtn);
	}

	// edit new search by changing depart and return dates and amount of passengers
	public void editNewSearch(String dayDpt, String dayRtn) {
		waiting(1000);
		click(editSearchBtn);
		waiting(1000);
		click(departBtn);
		waiting(1000);
		for (WebElement el : dayDepartList) {
			WebElement dayName = el.findElement(By.cssSelector(".calendar-body__cell"));
			if (getText(dayName).contains(dayDpt)) {
				click(dayName);
				break;
			}
		}
		waiting(1000);
		for (WebElement el : dayDepartList) {
			WebElement dayName = el.findElement(By.cssSelector(".calendar-body__cell"));
			if (getText(dayName).contains(dayRtn)) {
				click(dayName);
				break;
			}
		}
		waiting(2000);
		click(passengersAddAdultsBtn);
		waiting(2000);
		click(passengersOkBtn);
		waiting(2000);
		click(searchAgainBtn);
	}

	// select new dpt date
	public void newDptDate(String dptDate) {
		waiting(2000);
		for (WebElement el : selectDayDepartList) {
			waiting(2000);
			WebElement newDate = el.findElement(By.cssSelector(".date-item__day-of-week.body-m-lg.body-m-sm"));
			if (getText(newDate).contains(dptDate)) {
				click(newDate);
				break;
			}
		}
		waiting(3000);
		click(newDptSelectBtn);
	}

	// select new rtn date
	public void newRtnDate(String rtnDate) {
		waiting(2000);
		for (WebElement el : selectDayRtnList) {
			waiting(2000);
			WebElement newDate = el.findElement(By.cssSelector(".date-item__day-of-week.body-m-lg.body-m-sm"));
			if (getText(newDate).contains(rtnDate)) {
				click(newDate);
				break;
			}
		}
		waiting(3000);
		click(newRtnSelectBtn);
	}

}

package pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends MenuPage {

	@FindBy(css = "[aria-label='flights'] div.tab-text.ng-star-inserted")
	private WebElement flightsBtn;
	@FindBy(css = ".ry-radio-circle-button__checked.ng-star-inserted")
	private WebElement retrnFlghtBtn;
	@FindBy(css = "fsw-trip-type > ry-radio-button:nth-child(2) > label")
	private WebElement oneWayBtn;
	@FindBy(css = ".promo-code__icon")
	private WebElement promoCodeBtn;
	@FindBy(css = ".promo-code__input.ng-pristine.ng-valid.ng-star-inserted.ng-touched")
	private WebElement promoCodeTxt;
	@FindBy(css = "#input-button__departure")
	private WebElement departureBtn;
	@FindBy(css = "#input-button__destination")
	private WebElement destinationBtn;
	@FindBy(css = "[data-ref=\"datepicker-tabs__exact-dates\"] .tab-text")
	private WebElement exactDateBtn;
	@FindBy(css = "[data-ref='datepicker-tabs__flexible-dates'] .tab-text")
	private WebElement flexibleDatesBtn;
	@FindBy(css = ".span-cols-2.ng-star-inserted")
	private WebElement monthMandatoryDateBtn;
	@FindBy(css = ".day-item.ng-star-inserted")
	private WebElement dayMandatoryDateBtn;
	@FindBy(css = ".flexible-dates__cta-apply.ry-button--outline-light-blue")
	private WebElement applyBtn;
	@FindBy(css = "ry-counter:nth-child(3) > div.counter > div:nth-child(3)")
	private WebElement passengersAddAdultsBtn;
	@FindBy(css = "ry-counter:nth-child(4) > div.counter > div.counter__button-wrapper--enabled")
	private WebElement passengersAddTeensBtn;
	@FindBy(css = "ry-counter:nth-child(5) > div.counter > div.counter__button-wrapper--enabled")
	private WebElement passengersAddChildrenBtn;
	@FindBy(css = "ry-counter:nth-child(6) > div.counter > div.counter__button-wrapper--enabled")
	private WebElement passengersAddInfantBtn;
	@FindBy(css = "div .ry-button--gradient-blue")
	private WebElement okInfantBtn;
	@FindBy(css = "ry-counter:nth-child(6) > div.counter > div.counter__button-wrapper--enabled")
	private WebElement passengersRemoveInfantBtn;
	@FindBy(css = ".passengers__confirm-button.ry-button--anchor-blue")
	private WebElement passengersOkBtn;
	@FindBy(css = ".flight-search-widget__start-search-cta.ng-tns-c983940023-3")
	private WebElement searchBtn;
	@FindBy(css = ".input-button__input.input-button__display-value--truncate-text ")
	private WebElement passMsgTxt;

	@FindBy(css = ".countries__country.body-l-lg.body-l-sm")
	private List<WebElement> countryList;
	@FindBy(css = ".list__airports-scrollable-container.small-height .ng-star-inserted")
	private List<WebElement> cityList;
	@FindBy(css = ".list__airports-scrollable-container.large-height>.ng-star-inserted")
	private List<WebElement> cityDesList;
	@FindBy(css = ".m-toggle__scrollable-item.ng-star-inserted")
	private List<WebElement> monDepartList;
	@FindBy(css = ".calendar-body__cell-wrap.ng-star-inserted")
	private List<WebElement> dayDepartList;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	// choose tab in mainPage
	public void flightsTab() {
		click(flightsBtn);
	}

	// if you want return flight
	public void rtrnFlght() {
		click(retrnFlghtBtn);
	}

	// if you want one way ticket
	public void oneWayFlght() {
		waitForElementToBeClickable(oneWayBtn);
		click(oneWayBtn);
	}

	// if you have promo code
	public void promoCode(String code) {
		click(promoCodeBtn);
		fillText(promoCodeTxt, code);
	}

	// choose your departure
	public void departureCountry(String country, String city) {
		click(departureBtn);
		waiting(1000);
		for (WebElement el : countryList) {
			WebElement countryTtl = el.findElement(By.cssSelector(".countries__country-inner.ng-star-inserted"));
			if (getText(countryTtl).contains(country)) {
				waiting(1000);
				click(countryTtl);
				break;
			}
		}
		waiting(1000);
		for (WebElement el : cityList) {
			WebElement cityTtl = el.findElement(By.cssSelector("[data-ref='airport-item__name']"));
			if (getText(cityTtl).contains(city)) {
				click(cityTtl);
				break;
			}
		}
	}

	// return to departureDate to choose another destination
	public void chooseAnotherDestination() {
		click(destinationBtn);
	}

	// choose your destination
	public void destinationCountry(String country, String city) {
		waiting(1000);
		for (WebElement el : countryList) {
			WebElement countryTtl = el.findElement(By.cssSelector(".countries__country-inner.ng-star-inserted"));
			if (getText(countryTtl).contains(country)) {
				waiting(1000);
				click(countryTtl);
				break;
			}
		}

		waiting(1000);
		for (WebElement el : cityDesList) {
			WebElement cityTtl = el.findElement(By.cssSelector("[data-ref='airport-item__name']"));
			if (getText(cityTtl).contains(city)) {
				click(cityTtl);
				break;
			}
		}
	}

	// choose your departureDate
	public void departureDate(String month, String day) {
		waiting(1000);
		click(exactDateBtn);
		waiting(1000);
		for (WebElement el : monDepartList) {
			WebElement monName = el.findElement(By.cssSelector(".m-toggle__month"));
			if (getText(monName).contains(month)) {
				click(monName);
				break;
			}
		}
		waiting(1000);
		for (WebElement el : dayDepartList) {
			WebElement dayName = el.findElement(By.cssSelector(".calendar-body__cell"));
			if (getText(dayName).contains(day)) {
				click(dayName);
				break;
			}
		}
	}

	// choose your returnDate
	public void returnDate(String month, String day) {
		waiting(1000);
		for (WebElement el : monDepartList) {
			WebElement monName = el.findElement(By.cssSelector(".m-toggle__month"));
			if (getText(monName).contains(month)) {
				click(monName);
				break;
			}
		}
		waiting(1000);
		for (WebElement el : dayDepartList) {
			WebElement dayName = el.findElement(By.cssSelector(".calendar-body__cell"));
			if (getText(dayName).contains(day)) {
				click(dayName);
				break;
			}
		}
	}

	// choose flexible dates of month and day
	public void chooseMandatoryDate() {
		waiting(1000);
		click(flexibleDatesBtn);
		waiting(1000);
		click(monthMandatoryDateBtn);
		waiting(1000);
		click(dayMandatoryDateBtn);
		waiting(1000);
		click(applyBtn);
	}

	// choose onePassengersAmount
	public void passengersAmount() {
		click(passengersOkBtn);
	}

	// choose all Kind Of Passengers Amount
	public void addAllKindOfPassengersAmount() {
		click(passengersAddAdultsBtn);
		waiting(1000);
		click(passengersAddAdultsBtn);
		waiting(1000);
		click(passengersAddTeensBtn);
		waiting(1000);
		click(passengersAddChildrenBtn);
		waiting(1000);
		click(passengersAddChildrenBtn);
		waiting(1000);
		click(passengersAddInfantBtn);
		waiting(1000);
		click(okInfantBtn);
		waiting(1000);
		click(passengersRemoveInfantBtn);
		waiting(1000);
		click(passengersOkBtn);
	}

	// search flightsBtn
	public void searchFlights() {
		click(searchBtn);
	}

	// validation
	public String passengersMsg() {
		return getText(passMsgTxt);
	}
}

package pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeatsPage extends MenuPage {

	@FindBy(css = ".seatmap__extraleg.seatmap__extraleg--aisle.ng-star-inserted")
	private List<WebElement> rowDptList;
	@FindBy(css = ".seatmap__extraleg.seatmap__extraleg--aisle.ng-star-inserted")
	private List<WebElement> rowRtnList;
	@FindBy(css = "#seat-05A")
	private WebElement seatDepBtn;
	@FindBy(css = "#seat-05A")
	private WebElement seatRtnBtn;
	@FindBy(css = ".passenger-carousel__cta")
	private WebElement nextFlightBtn;
	@FindBy(css = ".enhanced-takeover-beta__product-actions .enhanced-takeover-beta__product-dismiss-cta.ry-button--anchor-blue.ry-button--anchor")
	private WebElement fastTrackBtn;

	public SeatsPage(WebDriver driver) {
		super(driver);
	}

	// choose row to seat in the depart flight.
	public void chooseDptSeats(String row) {
		waiting(5000);
		scrollUp();
		waiting(1000);
		scrollUp();
		for (WebElement el : rowDptList) {
			waiting(1000);
			WebElement rowNum = el
					.findElement(By.cssSelector(".seatmap__seat.seatmap__seat--aisle.b2.ng-star-inserted"));
			if (getText(rowNum).contains(row)) {
				click(rowNum);
				break;
			}
		}
		waiting(3000);
		click(seatDepBtn);
		waiting(1000);
		click(nextFlightBtn);

	}

	// choose row to seat in the return flight.
	public void chooseRtnSeats(String row) {
		waiting(5000);
		for (WebElement el : rowDptList) {
			waiting(1000);
			WebElement rowNum = el
					.findElement(By.cssSelector(".seatmap__seat.seatmap__seat--aisle.b2.ng-star-inserted"));
			if (getText(rowNum).contains(row)) {
				click(rowNum);
				break;
			}
		}
		waiting(3000);
		click(seatRtnBtn);
		click(nextFlightBtn);
	}

	// remove fast track
	public void fastTrack() {
		waiting(5000);
		click(fastTrackBtn);
	}

}

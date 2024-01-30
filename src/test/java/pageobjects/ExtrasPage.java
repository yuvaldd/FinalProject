package pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtrasPage extends MenuPage {

	@FindBy(css = ".airport-and-flight__cta.ry-button--gradient-yellow")
	private WebElement continueBtn;
	@FindBy(css = ".ng-star-inserted.ry-button--gradient-light-blue")
	private WebElement addFastTrackBtn;
	@FindBy(css = ".big-card-fast-track__card.ng-star-inserted .ng-star-inserted.ry-button--anchor-blue.ry-button--anchor")
	private WebElement removeFastTrackBtn;
	@FindBy(css = ".prepaid-card__add-cta.ry-button--gradient-blue")
	private WebElement addPrePaidCardBtn;
	@FindBy(css = ".ry-button--full.inflight-select-content__button")
	private WebElement confirmBtn;
	@FindBy(css = ".transport__cta.ry-button--gradient-yellow")
	private WebElement continueToLastPageBtn;

	public ExtrasPage(WebDriver driver) {
		super(driver);
	}

	// continue to the next page.
	public void continueToNextPage() {
		waiting(2000);
		scrollDown();
		waiting(1000);
		scrollDown();
		waiting(1000);
		click(continueBtn);
	}

	// add fast track
	public void addFastTrack() {
		click(addFastTrackBtn);
	}

	// remove fast track
	public void removeFastTrack() {
		click(removeFastTrackBtn);
	}

	// add pre-paid credit and amount
	public void addAmountCredit() {
		waiting(2000);
		scrollDown();
		waiting(1000);
		scrollDown();
		waiting(1000);
		click(addPrePaidCardBtn);
		waiting(1000);
		click(confirmBtn);
	}

	// continue to the last page.
	public void continueToLastPage() {
		waiting(2000);
		scrollDown();
		waiting(1000);
		scrollDown();
		waiting(1000);
		click(continueToLastPageBtn);
	}

}

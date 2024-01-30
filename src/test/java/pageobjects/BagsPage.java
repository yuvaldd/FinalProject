package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagsPage extends MenuPage {

	@FindBy(css = ".content-plus-tag__button-text")
	private WebElement addSmallBabBtn;
	@FindBy(css = ".content-plus-tag__button-text")
	private WebElement removeSmallBabBtn;
	@FindBy(css = ".product-selector__control div>div:nth-child(3).counter__button-wrapper--enabled")
	private WebElement addLargeBabBtn;
	@FindBy(css = ".product-selector__control div.counter>div:nth-child(1).counter__button-wrapper--enabled")
	private WebElement removeLargeBabBtn;
	@FindBy(css = ".booking-content__section.booking-content__section--continue-flow .ry-button--gradient-yellow")
	private WebElement continueNextPage;

	public BagsPage(WebDriver driver) {
		super(driver);
	}

	// continue to the next page.
	public void continueNextPage() {
		waiting(5000);
		scrollDown();
		waiting(5000);
		scrollDown();
		waiting(1000);
		click(continueNextPage);
	}

	// if you want add one more 10k begs.
	public void addSmallBags() {
		waiting(4000);
		click(addSmallBabBtn);
	}

	// if you want remove one more 10k begs.
	public void removeSmallBags() {
		waiting(2000);
		click(removeSmallBabBtn);
	}

	// if you want add one more 20k begs.
	public void addLargeBegs() {
		waiting(2000);
		click(addLargeBabBtn);
		waiting(1000);
		click(addLargeBabBtn);
	}

	// if you want remove one more 20k begs.
	public void removeLargeBegs() {
		waiting(2000);
		click(removeLargeBabBtn);
	}

}

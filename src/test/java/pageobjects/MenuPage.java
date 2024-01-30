package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

	@FindBy(css = "div button:nth-child(3).cookie-popup-with-overlay__button-settings")
	private WebElement cookiesBtn;
	@FindBy(css = "hp-header-sections-group.hp-header-content__menu-right.ng-star-inserted > hp-header-menu-item:nth-child(4) > button > span")
	private WebElement loginBtn;
	@FindBy(css = ".form__input div>[type=\"email\"]")
	private WebElement emailField;
	@FindBy(css = "[type=\"password\"]")
	private WebElement passwordField;
	@FindBy(css = ".auth-submit__button.ry-button--gradient-yellow")
	private WebElement okBtn;
	@FindBy(css = ".tooltip-button")
	private WebElement tooltipBtn;// for logout
	@FindBy(css = ".log-out.ry-button--anchor-blue")
	private WebElement logOutBtn;
	@FindBy(css = "hp-header-sections-group.hp-header-content__menu-right.ng-star-inserted>hp-header-menu-item:nth-child(3)>button .header-menu-item__title.ng-star-inserted")
	private WebElement signUpBtn;
	@FindBy(css = ".auth-submit__button.ry-button--gradient-yellow")
	private WebElement createAccountBtn;
	@FindBy(css = " div.basket-total-icon__state.ng-tns-c356685602-11.ng-trigger.ng-trigger-tickAnimation > icon > span > svg > path")
	private WebElement cartBtn;

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	// cookie window
	public void closeCookieWindow() {
		waiting(1000);
		click(cookiesBtn);
	}

	// log in
	public void login(String email, String password) {
		waiting(2000);
		click(loginBtn);
		waitForVisibilityOf(emailField);
		fillText(emailField, email);
		fillText(passwordField, password);
		waitForElementToBeClickable(okBtn);
		click(okBtn);
		waiting(2000);

	}

	// logout
	public void logout() {
		click(tooltipBtn);
		click(logOutBtn);
	}

	// sign up
	public void signup(String email, String password) {
		waiting(2000);
		click(signUpBtn);
		waitForVisibilityOf(emailField);
		fillText(emailField, email);
		fillText(passwordField, password);
		waitForElementToBeClickable(createAccountBtn);
		click(createAccountBtn);
		waiting(2000);

	}

	// go to cart page
	public void goToCart() {
		click(cartBtn);
	}

}

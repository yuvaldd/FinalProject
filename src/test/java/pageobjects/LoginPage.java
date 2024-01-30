package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(css = "div button:nth-child(3).cookie-popup-with-overlay__button-settings")
	private WebElement cookiesBtn;
	@FindBy(css = "hp-header-sections-group.hp-header-content__menu-right.ng-star-inserted > hp-header-menu-item:nth-child(5) > button > span")
	private WebElement loginBtn;
	@FindBy(css = ".form__input div>[type=\"email\"]")
	private WebElement emailField;
	@FindBy(css = "[type=\"password\"]")
	private WebElement passwordField;
	@FindBy(css = ".auth-submit__button.ry-button--gradient-yellow")
	private WebElement okBtn;
	@FindBy(css = "span._error")
	private WebElement ErrMsgTxt;

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	// close cookie window
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

	// validation
	public String errMsg() {
		waiting(2000);
		return getText(ErrMsgTxt);
	}

}

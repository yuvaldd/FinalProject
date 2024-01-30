package pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void fillText(WebElement el, String text) {
		// highlight
		highlightElement(el, "green");
		el.clear();
		waiting(200);
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		// highlight
		highlightElement(el, "green");
		waiting(300);
		el.click();
	}

	public String getText(WebElement el) {
		highlightElement(el, "orange");
		return el.getText();
	}
	
	
	public void waitForElementToBeClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	public void waitForVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	public void waitForInVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void back() {
		driver.navigate().back();
	}
	
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");

	}

	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-300)", "");
	}

	public void waiting(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void alertOK(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	/*
	 * Call this method with your element and a color like (red,green,orange, yellow
	 * etc...)
	 */
	private void highlightElement(WebElement element, String color) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color: yellow;border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}
}

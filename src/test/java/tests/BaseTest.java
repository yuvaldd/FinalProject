package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import pageobjects.BagsPage;
import pageobjects.ExtrasPage;
import pageobjects.FlightsPage;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.SeatsPage;

public class BaseTest {

	WebDriver driver;
	LoginPage loginPage;
	MainPage mainPage;
	FlightsPage flightsPage;
	SeatsPage seatsPage;
	BagsPage bagsPage;
	ExtrasPage extrasPage;

	@BeforeClass(description = "open web")
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ryanair.com/gb/en");
		loginPage = new LoginPage(driver);
		loginPage.closeCookieWindow();
	}

	@BeforeClass
	public void setupForPages() {
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		flightsPage = new FlightsPage(driver);
		seatsPage = new SeatsPage(driver);
		bagsPage = new BagsPage(driver);
		extrasPage = new ExtrasPage(driver);
	}

	@BeforeClass
	public void setupLogin() {
		loginPage.login("yuvalhadi@gmail.com", "0123456Yh");

	}

	@AfterClass(description = "close web")
	public void tearDown() {
		// driver.quit();
	}

	/*
	 * This method will run after wach test, it will take screen shot only for tests
	 * that failed
	 */
	@AfterMethod
	public void failedTest(ITestResult result) {
		// check if the test failed
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// result.getname() method will give you current test case name.
			// ./ScreenShots/ tell you that, in your current directory, create folder
			// ScreenShots. dot represents current directory
		}
	}

}

package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class LoginFailedTest extends BaseTest {

	@Override
	public void setupLogin() {
	}

	@Test(dataProvider = "getData", description = "use incorect login infornation")
	public void tc01_loginFailed(String email, String password, String expected) {
		loginPage.login(email, password);
		String actual = loginPage.errMsg();
		loginPage.refreshPage();
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "ya@gmail.com", "0123456Yh", "Incorrect email address or password, 4 attempts left" },
				{ "yuvalhadi@gmail.com", "012345", "Incorrect email address or password" },
				{ "ya@gmail.com", "012345", "Incorrect email address or password, 4 attempts left" }, };
		return myData;
	}
}

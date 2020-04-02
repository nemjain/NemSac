package com.practice.nemsac;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClass.MyAccountPage;
import pageClass.homePage;
import pageClass.loginPage;
import utility.TestDataFileReader;

public class LoginTestSuite {

	WebDriver driver;
	homePage objhomePage;
	loginPage objloginPage;
	MyAccountPage objMyAccountPage;
	TestDataFileReader objTestDataFilereader = new TestDataFileReader();
	/*String DashBoardTitle = "Welcome To the Dashboard | 4wheelparts.com";
	
	 * String userName = "nem.jain@taistech.com"; String passWordValid =
	 * "Password12"; String passWordInvalid = "XYZ123";
	 
	
	String expectedErrorMessage = "The entered username or password is invalid";
	*/

	@BeforeTest
	public void beforeTest() throws IOException {
		// All Variable declaration
		String driverPath = System.getProperty("user.home") + "\\git\\NemSac\\nemsac\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void verifyValidUserLogin() {
		String URL = "https://uat:uattap123@wwwuat.4wheelparts.com";
		driver.get(URL);

		objhomePage = new homePage(driver);
		objhomePage.click_on_myAccount();
		objhomePage.click_on_LogIn();

		objloginPage = new loginPage(driver);
		objloginPage.enterUserName(objTestDataFilereader.getValue("userName"));
		objloginPage.enterPassword(objTestDataFilereader.getValue("passWordValid"));
		objloginPage.submitSignIn();
		// objMyAccountPage = new MyAccountPage(driver);
		// objMyAccountPage.getPageTitle();

		Assert.assertEquals(objTestDataFilereader.getValue("DashBoardTitle"), driver.getTitle());
		System.out.println("Welcome To Dashboard");
	}

	@Test
	public void verifyInvalidUserLogin() throws InterruptedException {
		String URL = "https://uat:uattap123@wwwuat.4wheelparts.com";
		driver.get(URL);
		String actualLoginError;

		objhomePage = new homePage(driver);
		objhomePage.click_on_myAccount();
		objhomePage.click_on_LogIn();

		objloginPage = new loginPage(driver);
		objloginPage.enterUserName(objTestDataFilereader.getValue("userName"));
		objloginPage.enterPassword(objTestDataFilereader.getValue("passWordInvalid"));
		objloginPage.submitSignIn();
		actualLoginError = objloginPage.getLoginErrorMessage();
		// objMyAccountPage = new MyAccountPage(driver);
		// objMyAccountPage.getPageTitle();
		
		Assert.assertEquals(actualLoginError, objTestDataFilereader.getValue("expectedErrorMessage"));
		System.out.println(actualLoginError);
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
	}

}

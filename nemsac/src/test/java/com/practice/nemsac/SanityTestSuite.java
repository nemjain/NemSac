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

public class SanityTestSuite {

	WebDriver driver;
	homePage objhomePage;
	loginPage objloginPage;
	MyAccountPage objMyAccountPage;
	String DashBoardTitle = "Welcome To the Dashboard | 4wheelparts.com";

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
	public void verifyValidUserLogin() throws InterruptedException {
		String URL = "https://uat:uattap123@wwwuat.4wheelparts.com";
		driver.get(URL);

		objhomePage = new homePage(driver);
		objhomePage.click_on_myAccount();
		objhomePage.click_on_LogIn();

		objloginPage = new loginPage(driver);
		objloginPage.enterUserName();
		objloginPage.enterPassword();
		objloginPage.submitSignIn();
		// objMyAccountPage = new MyAccountPage(driver);
		// objMyAccountPage.getPageTitle();

		Assert.assertEquals(DashBoardTitle, driver.getTitle());
		System.out.println("Welcome To Dashboard");
	}

	@Test
	public void validateOrderTheProducts() throws InterruptedException {
		String URL = "https://uat:uattap123@wwwuat.4wheelparts.com";
		driver.get(URL);

		objhomePage = new homePage(driver);
		objhomePage.click_on_myAccount();
		objhomePage.click_on_LogIn();

		objloginPage = new loginPage(driver);
		objloginPage.enterUserName();
		objloginPage.enterPassword();
		objloginPage.submitSignIn();
		// objMyAccountPage = new MyAccountPage(driver);
		// objMyAccountPage.getPageTitle();

		Assert.assertEquals(DashBoardTitle, driver.getTitle());
		System.out.println("Welcome To Dashboard");
	}

	@Test
	public void validateAddToKart() throws InterruptedException {
		String URL = "https://uat:uattap123@wwwuat.4wheelparts.com";
		driver.get(URL);

		objhomePage = new homePage(driver);
		objhomePage.click_on_myAccount();
		objhomePage.click_on_LogIn();

		objloginPage = new loginPage(driver);
		objloginPage.enterUserName();
		objloginPage.enterPassword();
		objloginPage.submitSignIn();
		// objMyAccountPage = new MyAccountPage(driver);
		// objMyAccountPage.getPageTitle();

		Assert.assertEquals(DashBoardTitle, driver.getTitle());
		System.out.println("Welcome To Dashboard");
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
	}

}

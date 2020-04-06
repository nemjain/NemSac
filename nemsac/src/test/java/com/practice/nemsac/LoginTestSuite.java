package com.practice.nemsac;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.MyAccountPage;
import pageClass.homePage;
import pageClass.loginPage;
import utility.ExtentReports.ExtentTestManager;

public class LoginTestSuite extends BaseTest {

	loginPage objloginPage;
	WebDriver driver;

	@Test(priority = 0, description = "Valid Login Scenario with corret username and password.")
	public void verifyValidUserLogin(Method method) {
		this.driver = getDriver();

		// ExtentReports Description
		ExtentTestManager.startTest(method.getName(), "Valid Login Scenario with valid username and password.");
		String URL = "https://uat:uattap123@wwwuat.4wheelparts.com";
		driver.get(URL);

		objhomePage = new homePage(driver);
		objhomePage.click_on_myAccount();
		objhomePage.click_on_LogIn();

		objloginPage = new loginPage(driver);
		objloginPage.enterUserName(objTestDataFilereader.getValue("userName"));
		objloginPage.enterPassword(objTestDataFilereader.getValue("passWordValid"));
		objloginPage.submitSignIn();
		objMyAccountPage = new MyAccountPage(driver);
		objMyAccountPage.getPageTitle();

		Assert.assertEquals(objTestDataFilereader.getValue("DashBoardTitle"), driver.getTitle());
		System.out.println("Welcome To Dashboard");

	}

	@Test(priority = 1, description = "Invalid Login Scenario with username and wrong password.")
	public void verifyInvalidUserLogin(Method method) throws InterruptedException {
		this.driver = getDriver();
		// ExtentReports Description
		ExtentTestManager.startTest(method.getName(), "Invalid Login Scenario with empty username and password.");
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
		objMyAccountPage = new MyAccountPage(driver);
		objMyAccountPage.getPageTitle();

		Assert.assertEquals(actualLoginError, objTestDataFilereader.getValue("expectedErrorMessage"));
		System.out.println(actualLoginError);
	}

}

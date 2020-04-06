package com.practice.nemsac;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utility.ExtentReports.ExtentTestManager;

public class SanityClass extends BaseTest {

	@Test
	public void verifyWebSiteLogin(Method method) throws InterruptedException {

		WebDriver driver = getDriver();
		System.out.println(driver);
		// ExtentReports Description
		ExtentTestManager.startTest(method.getName(),
				"Valid Login Scenario with valid username and password for Wheelparts.com.");
		String URL = "https://uat:uattap123@wwwuat.4wheelparts.com";
		driver.get(URL);
	}

}

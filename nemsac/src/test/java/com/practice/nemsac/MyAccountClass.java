package com.practice.nemsac;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utility.ExtentReports.ExtentTestManager;

public class MyAccountClass extends BaseTest {

	@Test
	public void verifyMyAccountClassTest(Method method) throws InterruptedException {
		// WebDriver driver = getDriver();
		// ExtentReports Description
		ExtentTestManager.startTest(method.getName(), "In MyAccount class call.");
		System.out.println("In MyAccount");
	}

}

package com.practice.nemsac;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageClass.MyAccountPage;
import pageClass.homePage;
import utility.TestDataFileReader;

public class BaseTest {

	WebDriver driver;

	homePage objhomePage;

	MyAccountPage objMyAccountPage;
	TestDataFileReader objTestDataFilereader = new TestDataFileReader();

	@BeforeMethod
	public void beforeMethod() throws IOException {
		// All Variable declaration
		String driverPath = System.getProperty("user.home") + "\\git\\NemSac\\nemsac\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	public WebDriver getDriver() {
		return driver;

	}

}

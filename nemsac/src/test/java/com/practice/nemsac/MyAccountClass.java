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

public class MyAccountClass {

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
		System.out.println("In MyAccount");
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
	}

}

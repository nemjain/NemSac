package com.practice.nemsac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClass.homePage;
import pageClass.loginPage;

public class BaseClass {

	WebDriver driver;
	homePage objhomePage;
	loginPage objloginPage;

	@BeforeTest
	public void beforeTest() {
		// All Variable declaration
		String driverPath = "C:\\Users\\jindals\\git\\NemSac\\nemsac\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void f() throws InterruptedException {
		String URL = "https://uat:uattap123@wwwuat.4wheelparts.com";
		driver.get(URL);
	
		objhomePage = new homePage(driver);
		objhomePage.click_on_myAccount();
		objhomePage.click_on_LogIn();
				
		objloginPage = new loginPage(driver);
		objloginPage.enterUserName();
		objloginPage.enterPassword();
		objloginPage.submitSignIn();

	}

	@AfterTest
	public void afterTest() {
	//	driver.quit();
	}

}

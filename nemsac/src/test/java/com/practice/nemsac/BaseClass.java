package com.practice.nemsac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {

	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		// All Variable declaration
		String driverPath = "C:\\Users\\jindals\\git\\NemSac\\nemsac\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();

	}

	@Test
	public void f() {
		String URL = "https://uat:uattap123@wwwuat.4wheelparts.com";
		driver.get(URL);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}

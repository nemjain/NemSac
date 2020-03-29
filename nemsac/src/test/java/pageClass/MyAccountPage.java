package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonFunctions.commonFunctionsForAll;

public class MyAccountPage {

	WebDriver driver;
	commonFunctionsForAll objCommonFunction2 = new commonFunctionsForAll();

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * @FindBy(how = How.XPATH, using = "") private WebElement pageTitle;
	 */
	
	
	public String getPageTitle() {
		//objCommonFunction2.waitExplicit(driver, pageTitle);
		String varTitle = driver.getTitle();
		System.out.println(varTitle);
		return varTitle;
		
	}

}

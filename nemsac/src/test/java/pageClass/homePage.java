package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.commonFunctionsForAll;


public class homePage{

	WebDriver driver;
	commonFunctionsForAll objCommonFunction = new commonFunctionsForAll();
	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@id='myAccount']")
	private WebElement linkMyAccount;

	@FindBy(how = How.XPATH, using = "//span[@class='myaccount']//a[contains(text(), 'Log in')]")
	private WebElement linkLogIn;

	public void click_on_myAccount() {
		objCommonFunction.waitExplicit(driver, linkMyAccount);
		linkMyAccount.click();
	}

	public void click_on_LogIn() {
		objCommonFunction.waitExplicit(driver, linkLogIn);
		linkLogIn.click();
	}
	
}

package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class homePage{

	WebDriver driver;

	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@id='myAccount']")
	private WebElement linkMyAccount;

	@FindBy(how = How.XPATH, using = "//span[@class='myaccount']//a[contains(text(), 'Log in')]")
	private WebElement linkLogIn;

	public void click_on_myAccount() {
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(linkMyAccount));
		//waitExplicit(linkMyAccount);
		linkMyAccount.click();
	}

	public void click_on_LogIn() {
	//	WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(linkLogIn));
		//waitExplicit(linkLogIn);
		linkLogIn.click();
	}
	
	public void waitExplicit(WebElement locator) {
	//	WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

}

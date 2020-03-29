package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

	WebDriver driver;
	String userName = "nem.jain@taistech.com";
	String passWord = "Password12";

	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	private WebElement txtEmail;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	private WebElement txtPassword;

	@FindBy(how = How.XPATH, using = "//input[@value='Sign In']")
	private WebElement btnSignIn;

	public void enterUserName() {
	//	waitExplicit( txtEmail);
		txtEmail.sendKeys(userName);
	}

	public void enterPassword() {
	//	waitExplicit( txtPassword);
		txtPassword.sendKeys(passWord);
	}

	public void submitSignIn() {
		//waitExplicit(btnSignIn);
		btnSignIn.submit();
	}

	/*
	 * public void waitExplicit(WebElement locator) { WebDriverWait wait = new
	 * WebDriverWait(driver, 30);
	 * wait.until(ExpectedConditions.elementToBeClickable(locator));
	 * 
	 * }
	 */
}

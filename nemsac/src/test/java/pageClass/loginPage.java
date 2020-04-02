package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commonFunctions.commonFunctionsForAll;

public class loginPage {

	WebDriver driver;
	
	commonFunctionsForAll objCommonFunction = new commonFunctionsForAll(driver);

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	private WebElement txtEmail;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	private WebElement txtPassword;

	@FindBy(how = How.XPATH, using = "//input[@value='Sign In']")
	private WebElement btnSignIn;

	@FindBy(how = How.XPATH, using = "//div/p[@class='custom-error-style']")
	private WebElement loginErrorMessage;
	
	
	public void enterUserName(String userName) {
		objCommonFunction.waitExplicit(driver, txtEmail);
		txtEmail.sendKeys(userName);
	}

	public void enterPassword(String passWord) {
		objCommonFunction.waitExplicit(driver, txtPassword);
		txtPassword.sendKeys(passWord);
	}

	public void submitSignIn() {
		objCommonFunction.waitExplicit(driver, btnSignIn);
		btnSignIn.submit();
	}
	
	public String getLoginErrorMessage() {
		objCommonFunction.waitExplicit(driver, loginErrorMessage);
		return loginErrorMessage.getText();
		
	}
}

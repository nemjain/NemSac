package commonFunctions;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonFunctionsForAll {

	WebDriverWait wait;
	WebDriver driver;

	public void waitExplicit(WebDriver driver, WebElement locator) {
		this.driver = driver;
		wait = (WebDriverWait) new WebDriverWait(driver, 50).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
		wait.until(ExpectedConditions.visibilityOf(locator));

	}

}

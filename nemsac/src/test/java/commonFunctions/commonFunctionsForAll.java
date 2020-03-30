package commonFunctions;

import java.time.Duration;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonFunctionsForAll {

	WebDriverWait wait;
	FluentWait<WebDriver> onjFluentWait;
	WebDriver driver;

	public commonFunctionsForAll() {
		this.driver = driver;
	}

	public void waitExplicit(WebDriver driver, WebElement locator) {

		wait = (WebDriverWait) new WebDriverWait(driver, 50).ignoring(StaleElementReferenceException.class,
				ElementNotVisibleException.class);
		wait.until(ExpectedConditions.visibilityOf(locator));

	}

	public void waitFluent(WebDriver driver) {
		
		onjFluentWait = new FluentWait<WebDriver>(driver);
		onjFluentWait
		.withTimeout(Duration.ofMillis(3000))
		.pollingEvery(Duration.ofMillis(300))
		.ignoring(NoSuchElementException.class);

	}

	public void waitExplicit(WebDriver driver, WebElement locator) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
}

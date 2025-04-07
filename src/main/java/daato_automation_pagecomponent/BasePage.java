/* Hello, Welcome to Divya Coding */
package daato_automation_pagecomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 47Billion
 *
 */
public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void threadSleep(long second) throws InterruptedException {

		Thread.sleep(second);
	}
	
	public void printMessage(String message) {

		System.out.println(message);
	}

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", element);
	}

	public void waitElementToBeClick(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();
	}

}
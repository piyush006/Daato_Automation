/* Hello, Welcome to Divya Coding */
package daato_automation_page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;

/**
 * @author 47Billion
 *
 */
public class SendCOCPage extends BasePage {

	WebDriver driver;

	public SendCOCPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@title='Search']//*[name()='svg']")
	WebElement searchIcon;

	@FindBy(xpath = "//input[@placeholder='Search…']")
	WebElement searchButton;

	@FindBy(xpath = "//button[normalize-space(text())='Actions']")
	WebElement actionButton;

	@FindBy(xpath = "//li[normalize-space()='Request Code of Conduct acceptance']")
	WebElement sendCocButton;

	@FindBy(xpath = "//button[normalize-space()='Send']")
	WebElement sendButton;
	
	@FindBy(xpath = "//p[contains(text(),'Rows per page:')]")
	WebElement rowsPerPageLabel;

	public void sendCodeOfConduct(String company) throws InterruptedException {
		searchIcon.click();
		searchButton.sendKeys(company);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", rowsPerPageLabel);
		threadSleep(PageConstants.WAIT_TWO);
		driver.findElement(By.xpath("//p[contains(text(),'" + company + "')]")).click();
		//driver.findElement(By.xpath("//div[contains(text(),'" + company + "')]")).click();
		threadSleep(PageConstants.WAIT_TWO);
		actionButton.click();
		threadSleep(PageConstants.WAIT_TWO);
		sendCocButton.click();
		threadSleep(PageConstants.WAIT_TWO);
		sendButton.click();
		threadSleep(PageConstants.WAIT_THREE);

	}

}

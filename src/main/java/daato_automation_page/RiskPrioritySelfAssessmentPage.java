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
public class RiskPrioritySelfAssessmentPage extends BasePage {

	WebDriver driver;
	public RiskPrioritySelfAssessmentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@title='Search']//*[name()='svg']")
	WebElement searchIcon;
	
	@FindBy(xpath="//input[@placeholder='Search…']")
	WebElement searchButton;
	
	@FindBy(xpath="(//p[contains(text(),'Self-assessment')])[1]")
	WebElement selfAssesButton;
	
	@FindBy(xpath = "//button[text()='Close']")
	WebElement popupCloseButton;
	
	@FindBy(xpath = "//p[contains(text(),'Rows per page:')]")
	WebElement rowsPerPageLabel;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement closeButton;
	
	public void selfAssessment(String company) throws InterruptedException
	{
		//threadSleep(PageConstants.WAIT_ONE);
		//popupCloseButton.click();
		threadSleep(PageConstants.WAIT_TWO);
		searchIcon.click();
		searchButton.sendKeys(company);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", rowsPerPageLabel);
		threadSleep(PageConstants.WAIT_TWO);
		driver.findElement(By.xpath("//p[contains(text(),'" + company + "')]")).click();
		//driver.findElement(By.xpath("//div[contains(text(),'" + company + "')]")).click();
		threadSleep(PageConstants.WAIT_TWO);
		//closeButton.click();
		selfAssesButton.click();
	}
}

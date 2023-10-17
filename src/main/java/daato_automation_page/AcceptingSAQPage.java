/* Hello, Welcome to Divya Coding */
package daato_automation_page;

import org.openqa.selenium.By;
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
public class AcceptingSAQPage extends BasePage{

	WebDriver driver;	
	public AcceptingSAQPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@title='Search']//*[name()='svg']")
	WebElement searchIcon;
	
	@FindBy(xpath="//input[@placeholder='Search…']")
	WebElement searchButton;
	
	@FindBy(xpath="//button[normalize-space()='Data requests']")
	WebElement dataRequest;
	
	@FindBy(xpath="//button[normalize-space()='Accept the answer']")
	WebElement acceptTheAns;

	public void acceptingSAQ(String company) throws InterruptedException
	{
		searchIcon.click();
		searchButton.sendKeys(company);
		driver.findElement(By.xpath("//div[contains(text(),'" + company + "')]")).click();
		threadSleep(PageConstants.WAIT_TWO);
		dataRequest.click();
		driver.findElement(By.xpath("//div[contains(text(),'" + company + "')]")).click();
		threadSleep(PageConstants.WAIT_TEN);
		acceptTheAns.click();
		threadSleep(PageConstants.WAIT_TEN);
		
	}
}

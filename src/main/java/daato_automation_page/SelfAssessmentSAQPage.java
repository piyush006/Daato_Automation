/* Hello, Welcome to Divya Coding */
package daato_automation_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;

/**
 * @author 47Billion
 *
 */
public class SelfAssessmentSAQPage extends BasePage {

	WebDriver driver;

	public SelfAssessmentSAQPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@title='Search']//*[name()='svg']")
	WebElement searchIcon;

	@FindBy(xpath = "//input[@placeholder='Search…']")
	WebElement searchButton;

	@FindBy(xpath = "(//p[contains(text(),'Self-assessment')])[1]")
	WebElement selfAssessment;

	@FindBy(xpath = "//button[normalize-space()='Actions']")
	WebElement action;

	@FindBy(xpath = "//li[normalize-space()='Request Self-assessment']")
	WebElement requestSelfAssessment;

	@FindBy(xpath = "//button[normalize-space()='Send']")
	WebElement send;

	public void openNewTabAndNavigate(String url) throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_FOUR);
	}

	public void selfAssessment(String company) throws InterruptedException {
		searchIcon.click();
		searchButton.sendKeys(company);
		threadSleep(PageConstants.WAIT_TWO);
		selectCompany(company);
		threadSleep(PageConstants.WAIT_TWO);
		selfAssessment.click();

	}

	public void selectCompany(String company) {
		driver.findElement(By.xpath("//div[contains(text(),'" + company + "')]")).click();
	}

	public void sendSAQ(String company) throws InterruptedException {
		searchIcon.click();
		searchButton.sendKeys(company);
		threadSleep(PageConstants.WAIT_TWO);
		selectCompany(company);
		threadSleep(PageConstants.WAIT_TWO);
		action.click();
		threadSleep(PageConstants.WAIT_TWO);
		requestSelfAssessment.click();
		threadSleep(PageConstants.WAIT_TWO);
		send.click();
		threadSleep(PageConstants.WAIT_THREE);

	}

}
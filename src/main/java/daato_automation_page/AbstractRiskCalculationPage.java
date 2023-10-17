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
public class AbstractRiskCalculationPage extends BasePage {

	WebDriver driver;

	public AbstractRiskCalculationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[normalize-space()='Edit']")
	WebElement edit;

	@FindBy(xpath = "//span[normalize-space()='Country risk level']")
	WebElement countryRiskLevel;

	@FindBy(xpath = "//button[normalize-space()='Reset to default']")
	WebElement resetToDefault;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement submit;

	@FindBy(xpath = "//button[@title='Search']//*[name()='svg']")
	WebElement searchIcon;

	@FindBy(xpath = "//input[@placeholder='Search…']")
	WebElement searchButton;

	@FindBy(xpath = "//p[contains(text(),'Risk level')]")
	WebElement riskLevel;

	public void riskSettings() throws InterruptedException {
		openNewTabAndNavigate(PageConstants.PAGE_RISK_SETTING_URL);
		edit.click();
		countryRiskLevel.click();
		resetToDefault.click();
		submit.click();
		threadSleep(PageConstants.WAIT_THREE);
	}

	public void searchCompany() throws InterruptedException {
		openNewTabAndNavigate(PageConstants.PAGE_SUPPLIER_REPO_URL);
		searchIcon.click();
		threadSleep(PageConstants.WAIT_TWO);
	}

	public void riskLevel(String company) throws InterruptedException {
		searchButton.sendKeys(company);
		threadSleep(PageConstants.WAIT_TWO);
		selectCompany(company);
		threadSleep(PageConstants.WAIT_THREE);
		riskLevel.click();
	}
	
	 private void openNewTabAndNavigate(String url) throws InterruptedException {
	        driver.switchTo().newWindow(WindowType.TAB);
	        driver.get(url);
	        threadSleep(PageConstants.WAIT_FOUR);
	    }
	 
	 private void selectCompany(String company) {
	        driver.findElement(By.xpath("//div[contains(text(),'" + company + "')]")).click();
	    }

}

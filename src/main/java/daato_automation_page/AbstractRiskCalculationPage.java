/* Hello, Welcome to Divya Coding */
package daato_automation_page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath = "//p[normalize-space()='Influence']")
	WebElement influence;
	
	
	
	//p[normalize-space()='Influence']

	@FindBy(xpath = "//p[text()='Risk assessment']")
	WebElement riskAssessment;

	@FindBy(xpath = "//input[@value='default']")
	WebElement defaultRadioButton;

	@FindBy(xpath = "//input[@value='custom']")
	WebElement customRadioButton;

	@FindBy(xpath = "//button[text()='Close']")
	WebElement popupCloseButton;

	@FindBy(xpath = "//p[contains(text(),'Rows per page:')]")
	WebElement rowsPerPageLabel;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement closeButton;

	/*
	 * public void riskSettings() throws InterruptedException {
	 * openNewTabAndNavigate(PageConstants.PAGE_RISK_SETTING_URL); edit.click();
	 * countryRiskLevel.click(); resetToDefault.click(); submit.click();
	 * threadSleep(PageConstants.WAIT_THREE); }
	 */

	public void riskSettings() throws InterruptedException {
		openNewTabAndNavigate(PageConstants.PAGE_RISK_SETTING_URL);
		riskAssessment.click();
		if (defaultRadioButton.isSelected()) {
			// If default is selected, select the custom radio button
			customRadioButton.click();
			System.out.println("Custom radio button selected.");
		} else if (customRadioButton.isSelected()) {
			// If custom is already selected, redirect to another page
			threadSleep(PageConstants.WAIT_ONE);
			openNewTabAndNavigate(PageConstants.PAGE_SUPPLIER_REPO_URL);
		}
		threadSleep(PageConstants.WAIT_THREE);
	}

	public void searchCompany() throws InterruptedException {
		threadSleep(PageConstants.WAIT_ONE);
		//popupCloseButton.click();
		searchIcon.click();
		threadSleep(PageConstants.WAIT_TWO);
	}

	public void riskLevel(String company) throws InterruptedException {
		searchButton.sendKeys(company);
		threadSleep(PageConstants.WAIT_TWO);
		selectCompany(company);
		threadSleep(PageConstants.WAIT_TWO);
		
		System.out.println("I am here");
		//closeButton.click();
		influence.click();
	}

	private void openNewTabAndNavigate(String url) throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_FOUR);
	}

	private void selectCompany(String company) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", rowsPerPageLabel);
		threadSleep(PageConstants.WAIT_TWO);
		driver.findElement(By.xpath("//p[contains(text(),'" + company + "')]")).click();

	}

}

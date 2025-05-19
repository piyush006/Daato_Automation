package Doublemateriality;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;

public class checkmanualiroscore extends BasePage{
	
	
	String reporid;
	
	WebDriver driver;

	public checkmanualiroscore(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath = "(//div[contains(@class,'MuiStep-root')])[3]//span[contains(@class,'MuiStepLabel-iconContainer')]")
	WebElement thirdstep;
	
	@FindBy(xpath = "(//div[contains(@class,'MuiStep-root')])[2]//span[contains(@class,'MuiStepLabel-iconContainer')]")
	WebElement seconstep;
	
	@FindBy(xpath = "//button[normalize-space()='Assess Social IROs']")
	WebElement AssessSociaIROs;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/button[1]/span[1]")
	WebElement Workingcondition;
	
	@FindBy(xpath = "//tr[td//text()[contains(., 'Automatedimpact01')]]//p[contains(text(), 'Assess')]")
	WebElement clickonassess;
	
	@FindBy(xpath = "//button[normalize-space()='Close']")
	WebElement close;
	
	@FindBy(xpath = "//div[contains(text(),'Timeframe')]")
	WebElement timeframe;
	
	
	@FindBy(xpath = "//div[@role='button']//span[contains(@class, 'MuiChip-label')]")
	WebElement valueofimeframe;
	
	@FindBy(xpath = "//div[contains(text(), 'Is this a human-rights related impact or not?')]/following::input[@role='combobox'][1]")
	WebElement humanimpactvalue;
	
	@FindBy(xpath = "//div[contains(text(), 'Is it an actual or potential impact?')]/following::input[@role='combobox'][1]")
	WebElement Potentialvalue;
	
	
	
	@FindBy(xpath = "//div[contains(text(),'Is the impact negative or positive?')]")
	WebElement typeofimpact;
	
	
	
	@FindBy(xpath = "//div[contains(text(), 'Is the impact negative or positive?')]/following::input[@role='combobox'][1]")
	WebElement valueofimpact;
	
	@FindBy(xpath = "//p[@class='sc-jlZhew jCmBDe MuiTypography-root MuiTypography-body1']")
	WebElement completestep1;
	
	@FindBy(xpath = "//button[normalize-space()='Complete step']")
	WebElement submit;
	
	
	
	
	public void checkmanualscore() throws InterruptedException {
		
		
		
		reporid=ProperyUtilReader2.getReportId();
		
		String fullUrl = PageConstants.surverypage + reporid;
		openNewTabAndNavigate(fullUrl);
		threadSleep(PageConstants.WAIT_THREE);	
		
	    thirdstep.click();
	    threadSleep(PageConstants.WAIT_ONE);
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AssessSociaIROs);
		Thread.sleep(500); // Small wait to ensure scroll completed
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", AssessSociaIROs);
		threadSleep(PageConstants.WAIT_TWO);
		
		
		WebDriverWait waitUntilClickable = new WebDriverWait(driver, Duration.ofSeconds(15));
		waitUntilClickable.until(driver -> {
		    try {
		        return Workingcondition.isEnabled() && Workingcondition.isDisplayed() && Workingcondition.isDisplayed();
		    } catch (Exception e) {
		        return false;
		    }
		});
		
		// Finally click
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", Workingcondition);
				threadSleep(PageConstants.WAIT_TWO);
		
	}
	
	
	
	private void openNewTabAndNavigate(String url) throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_FOUR);
		
	}		
		
		
	
		
		
		
	}
	
	
	
	
	
	
	


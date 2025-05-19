package Doublemateriality;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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

public class Checkirosocore extends BasePage{
	
	String reporid;
	
	WebDriver driver;

	public Checkirosocore(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}		
	
	
	
	@FindBy(xpath = "(//div[contains(@class,'MuiStep-root')])[3]//span[contains(@class,'MuiStepLabel-iconContainer')]")
	WebElement thirdstep;
	
	@FindBy(xpath = "(//div[contains(@class,'MuiStep-root')])[2]//span[contains(@class,'MuiStepLabel-iconContainer')]")
	WebElement seconstep;
	
	@FindBy(xpath = "//button[normalize-space()='Assess Environmental IROs']")
	WebElement AssessEnvironmentalIROs;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/button[1]/span[1]")
	WebElement openclimate;
	
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
	
	
	
	
	
	
	public void checkiroscore() throws InterruptedException {
		
		
		
		reporid=ProperyUtilReader2.getReportId();
		
		String fullUrl = PageConstants.surverypage + reporid;
		openNewTabAndNavigate(fullUrl);
		threadSleep(PageConstants.WAIT_THREE);	
		
	    thirdstep.click();
	    threadSleep(PageConstants.WAIT_ONE);
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AssessEnvironmentalIROs);
		Thread.sleep(500); // Small wait to ensure scroll completed
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", AssessEnvironmentalIROs);
		threadSleep(PageConstants.WAIT_TWO);
		
		
		WebDriverWait waitUntilClickable = new WebDriverWait(driver, Duration.ofSeconds(15));
		waitUntilClickable.until(driver -> {
		    try {
		        return openclimate.isEnabled() && openclimate.isDisplayed() && openclimate.isDisplayed();
		    } catch (Exception e) {
		        return false;
		    }
		});
		
		// Finally click
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", openclimate);
				threadSleep(PageConstants.WAIT_TWO);
		
	}
	
	
	
	private void openNewTabAndNavigate(String url) throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_FOUR);
		
	}	
	
	
	public Map<String, String> checkassessment() throws InterruptedException {
	    Map<String, String> values = new HashMap<>();
		
		
		
reporid=ProperyUtilReader2.getReportId();
		
		String fullUrl = PageConstants.surverypage + reporid;
		openNewTabAndNavigate(fullUrl);
		threadSleep(PageConstants.WAIT_THREE);	
		
		threadSleep(PageConstants.WAIT_THREE);		
		 thirdstep.click();
		    threadSleep(PageConstants.WAIT_ONE);
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AssessEnvironmentalIROs);
			Thread.sleep(500); // Small wait to ensure scroll completed
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", AssessEnvironmentalIROs);
			threadSleep(PageConstants.WAIT_TWO);
			
			
			WebDriverWait waitUntilClickable = new WebDriverWait(driver, Duration.ofSeconds(15));
			waitUntilClickable.until(driver -> {
			    try {
			        return openclimate.isEnabled() && openclimate.isDisplayed() && openclimate.isDisplayed();
			    } catch (Exception e) {
			        return false;
			    }
			});
			
			// Finally click
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", openclimate);
					threadSleep(PageConstants.WAIT_TWO);
		              clickonassess.click();
		
		              threadSleep(PageConstants.WAIT_FIVE);
		              
		              
		              WebDriverWait waitUntilClickable1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		  			waitUntilClickable1.until(driver -> {
		  			    try {
		  			        return close.isEnabled() && close.isDisplayed() && close.isDisplayed();
		  			    } catch (Exception e) {
		  			        return false;
		  			    }
		  			}); 
		  			
		  			
		  			close.click();
		              
		  			 threadSleep(PageConstants.WAIT_ONE);
		  			try {
		  		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", timeframe);
		  		        threadSleep(PageConstants.WAIT_ONE);

		  		        values.put("actualTimeFrame", valueofimeframe.getText());
		  		        values.put("actualHumanImpact", humanimpactvalue.getAttribute("value"));
		  		        values.put("potential", Potentialvalue.getAttribute("value"));

		  		        threadSleep(PageConstants.WAIT_ONE);
		  		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", typeofimpact);
		  		        threadSleep(PageConstants.WAIT_ONE);

		  		        values.put("typeOfImpact", valueofimpact.getAttribute("value"));

		  		        return values;

		  		    } catch (Exception e) {
		  		        System.out.println("One or more required values not found. Skipping assessment check.");
		  		        return null; // Or return empty map if you prefer
		  		    }
}
	
	public void completestepfirst3() throws InterruptedException {
		
		reporid=ProperyUtilReader2.getReportId();
			
			String fullUrl = PageConstants.surverypage + reporid;
			openNewTabAndNavigate(fullUrl);
			threadSleep(PageConstants.WAIT_FOUR);
			thirdstep.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='sc-jlZhew jCmBDe MuiTypography-root MuiTypography-body1']")));
			completestep1.click();
			threadSleep(PageConstants.WAIT_ONE);
			submit.click();
			threadSleep(PageConstants.WAIT_ONE);
		}

	public void completestepfirst2() throws InterruptedException {
		
		reporid=ProperyUtilReader2.getReportId();
			
			String fullUrl = PageConstants.surverypage + reporid;
			openNewTabAndNavigate(fullUrl);
			threadSleep(PageConstants.WAIT_FOUR);
			seconstep.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='sc-jlZhew jCmBDe MuiTypography-root MuiTypography-body1']")));
			completestep1.click();
			threadSleep(PageConstants.WAIT_ONE);
			submit.click();
			threadSleep(PageConstants.WAIT_ONE);
		}
	
	
}

package Doublemateriality;

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

public class Finalreportpage extends BasePage{
	
	String reporid;
	WebDriver driver;

	public Finalreportpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath = "//p[@class='sc-jlZhew jCmBDe MuiTypography-root MuiTypography-body1']")
	WebElement completestep1;
	
	@FindBy(xpath = "//button[normalize-space()='Complete step']")
	WebElement submit;
	
	@FindBy(xpath = "(//div[contains(@class,'MuiStep-root')])[4]//span[contains(@class,'MuiStepLabel-iconContainer')]")
	WebElement fourthstep;
	
	@FindBy(xpath = "(//button[@aria-label='expand row'])[1]")
	WebElement viewenvironment;
	
	

	@FindBy(xpath = "(//span[@class='sc-fqkvVR csQlyy MuiTouchRipple-root'])[15]")
	WebElement Climate;
	
	@FindBy(xpath = "//button[@id='button-selectionResultsView']")
	WebElement clickontableview;
	
	@FindBy(xpath = "//li[normalize-space()='IRO table']")
	WebElement Selectirotable;
	
	@FindBy(xpath = "//div[@id=':r1ho:']")
	WebElement Selectpage;
	
	@FindBy(xpath = "//button[@aria-label='last page']//*[name()='svg']")
	WebElement Lastpage;
	
	
	
	
	
	public void checkfinalscorepage() throws InterruptedException {
		
		
reporid=ProperyUtilReader2.getReportId();
		
		String fullUrl = PageConstants.surverypage + reporid;
		openNewTabAndNavigate(fullUrl);
		threadSleep(PageConstants.WAIT_FIVE);
		
		 WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait13.until(ExpectedConditions.visibilityOf(fourthstep));
			wait13.until(ExpectedConditions.elementToBeClickable(fourthstep));
		
	    fourthstep.click();
	    threadSleep(PageConstants.WAIT_THREE);
	    fourthstep.click();
	    threadSleep(PageConstants.WAIT_ONE);
	    
	    WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11.until(ExpectedConditions.visibilityOf(viewenvironment));
		wait11.until(ExpectedConditions.elementToBeClickable(viewenvironment));

		// Try normal click, fallback to JS click in headless mode
		try {
			viewenvironment.click();
		} catch (Exception e) {
		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView({block: 'center'}); arguments[0].click();", viewenvironment);
		}
	    
		threadSleep(PageConstants.WAIT_TWO);	
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Climate);
		Thread.sleep(500); // Small wait to ensure scroll completed
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Climate);
		threadSleep(PageConstants.WAIT_TWO);
		
	
		
		
		
	}
	
	
	
	public void checkirotable() throws InterruptedException {
		
		
reporid=ProperyUtilReader2.getReportId();
		
		String fullUrl = PageConstants.surverypage + reporid;
		openNewTabAndNavigate(fullUrl);
		threadSleep(PageConstants.WAIT_THREE);	
		
		WebDriverWait wait14 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait14.until(ExpectedConditions.visibilityOf(fourthstep));
		wait14.until(ExpectedConditions.elementToBeClickable(fourthstep));
		
		fourthstep.click();
	    threadSleep(PageConstants.WAIT_FIVE);
	    fourthstep.click();
	    threadSleep(PageConstants.WAIT_THREE);
	    
	    WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait12.until(ExpectedConditions.visibilityOf(clickontableview));
		wait12.until(ExpectedConditions.elementToBeClickable(clickontableview));

		// Try normal click, fallback to JS click in headless mode
		try {
			clickontableview.click();
		} catch (Exception e) {
		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView({block: 'center'}); arguments[0].click();", clickontableview);
		}
	    
		threadSleep(PageConstants.WAIT_TWO);
	    
	    
	    
		
	//    clickontableview.click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[normalize-space()='IRO table']")));
	    
		Selectirotable.click();
		
		 threadSleep(PageConstants.WAIT_ONE);
		 
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Lastpage);
			Thread.sleep(500); // Small wait to ensure scroll completed
			
		
		 
	}
	
	
	
	
	
	
	
	private void openNewTabAndNavigate(String url) throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_FOUR);
		
	}	
	
	
	
	
	
	
	
	
public void completestepfirst4() throws InterruptedException {
		
		reporid=ProperyUtilReader2.getReportId();
			
			String fullUrl = PageConstants.surverypage + reporid;
			openNewTabAndNavigate(fullUrl);
			threadSleep(PageConstants.WAIT_FOUR);
			fourthstep.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='sc-jlZhew jCmBDe MuiTypography-root MuiTypography-body1']")));
			completestep1.click();
			threadSleep(PageConstants.WAIT_ONE);
			submit.click();
			threadSleep(PageConstants.WAIT_ONE);
		}
		
	
}

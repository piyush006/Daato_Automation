package Doublemateriality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;

public class Answercollaborationrequest extends BasePage{
	
	
	WebDriver driver;

	public Answercollaborationrequest(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	@FindBy(xpath = "(//p[@class='sc-jlZhew jjhSap MuiTypography-root MuiTypography-body1'][contains(text(),'Is this a direct impact of the entire company or o')])")
	WebElement selectrequest;
	
	@FindBy(xpath = "//div[contains(text(),'Is this a direct impact of the entire company or o')]")
	WebElement scrolltoseedatapoint;
	
	@FindBy(xpath = "(//input[@id='searchSelectID-impact'])[1]")
	WebElement clickdatapoint;
	
	
	@FindBy(xpath = "//li[@id='searchSelectID-impact-option-0']")
	WebElement Selectdatapoint;
	
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement clicksubmitbuton;
	
	@FindBy(xpath = "//button[@class='sc-iGgWBj cuoIjU MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth sc-gsFSXq cOyzay MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth']")
	WebElement confirmandsubmit;
	
	
	
	
	
	
	
	
	
	
	//li[@id='searchSelectID-impact-option-2']
	
	
	public void selectandanswerrequest() throws InterruptedException {
		
		
		threadSleep(PageConstants.WAIT_FOUR);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
	
			WebElement remindButton = (WebElement) js.executeScript(
				    "return document.querySelector('.productfruits--container').shadowRoot.querySelector('button.productfruits--card-footer-skip-button');");

				if (remindButton != null) {
					
					
					WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait10.until(ExpectedConditions.visibilityOf(remindButton));
					wait10.until(ExpectedConditions.elementToBeClickable(remindButton));
					
					threadSleep(PageConstants.WAIT_TWO);
					
					
					
				    remindButton.click();
				    
				} else {
					
					
				    System.out.println("'Remind me later' button not found.");
				}
			
			

		WebDriverWait waitUntilClickable = new WebDriverWait(driver, Duration.ofSeconds(15));
		// Custom wait: check that button is both enabled and clickable
		waitUntilClickable.until(driver -> {
		    try {
		        return selectrequest.isEnabled() && selectrequest.isDisplayed() && selectrequest.isDisplayed();
		    } catch (Exception e) {
		        return false;
		    }
		});		
		
		
		threadSleep(PageConstants.WAIT_ONE);
		
		
		selectrequest.click();
		
		
		threadSleep(PageConstants.WAIT_THREE);
			
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrolltoseedatapoint);
	//	Thread.sleep(500); // Small wait to ensure scroll completed
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickdatapoint);
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='searchSelectID-impact'])[1]")));
		
		clickdatapoint.click();
		System.out.println("datapointclicked");
		threadSleep(PageConstants.WAIT_ONE);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='searchSelectID-impact-option-0']")));
		Selectdatapoint.click();
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		Thread.sleep(500); 
		
		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clicksubmitbuton);
		Thread.sleep(500);
		
		System.out.println("Displayed: " + clicksubmitbuton.isDisplayed());
		System.out.println("Enabled: " + clicksubmitbuton.isEnabled());
		System.out.println("Text: " + clicksubmitbuton.getText());

		// Wait for clickability
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(clicksubmitbuton));
		wait.until(ExpectedConditions.elementToBeClickable(clicksubmitbuton));

		// Try normal click, fallback to JS click in headless mode
		try {
		    clicksubmitbuton.click();
		} catch (Exception e) {
		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView({block: 'center'}); arguments[0].click();", clicksubmitbuton);
		}
		
		
		
		threadSleep(PageConstants.WAIT_ONE);
		
		confirmandsubmit.click();
		
		threadSleep(PageConstants.WAIT_THREE);
}
	

}

package DoubleMateriality;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.Fillsurveryrequest;
import DMUTILS.PropertyUtilReader;
import DMUTILS.PropertyUtilWriter;
import daato_automation_page.Fillsurvey;
import daato_automation_page.SelfAssessmentPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;
import utils.AuthTokenadminUtil;
import utils.AuthTokenstakeholder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Registerstakeholder extends BaseTest{
	
	
	String Email;
	String extractedId;
	String stakeholdertoken;
	
	
	



	
@Test
public void loginasstakeholder() throws InterruptedException {
	
	
	
	
	Email=PropertyUtilReader.stakeholdermail();
	
	
	
	
	Fillsurvey fillsurvery = new Fillsurvey(driver);
	fillsurvery.yopmailLogin(Email);
	ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

	System.out.println(wid.size());
	driver.switchTo().window(wid.get(2));
	WebElement button1 = driver.findElement(By.cssSelector("button p.MuiTypography-body1"));
	button1.click();
//	PropertyFileUtils prop = new PropertyFileUtils();
//	LoginPage login = new LoginPage(driver);
	
	threadSleep(PageConstants.WAIT_TWO);
	
	WebElement inputField = driver.findElement(By.id("username"));
	inputField.sendKeys(Email);
	threadSleep(TestConstants.WAIT_TWO);
	WebElement button = driver.findElement(By.id("kc-login"));
	button.click();	
	threadSleep(TestConstants.WAIT_TWO); 
	fillsurvery.yopmailLoginforOTP(Email);
	

	WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-new']"));
	passwordField.sendKeys("12");
	
	threadSleep(TestConstants.WAIT_ONE);

	WebElement passwordConfirmField = driver.findElement(By.xpath("//input[@id='password-confirm']"));
	passwordConfirmField.sendKeys("12");
	
	threadSleep(TestConstants.WAIT_ONE);
	
	System.out.println("I am here before submit");
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Wait for the button to be visible and clickable
    

	WebElement submitNewPassButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit']")));

	// Scroll into view using JavaScript
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", submitNewPassButton);

	// Optional small wait to let rendering catch up
	Thread.sleep(500);

	// Click via JavaScript if still not interactable
	
	
	
	try {
	    wait.until(ExpectedConditions.elementToBeClickable(submitNewPassButton)).click();
	} catch (ElementNotInteractableException e) {
	    System.out.println("Fallback to JS click due to headless issues");
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitNewPassButton);
	}
	
	
	
	threadSleep(TestConstants.WAIT_ONE);
	
	WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
	lastNameField.sendKeys("Test");
	
	threadSleep(TestConstants.WAIT_ONE);
	
	

	// Wait for the button to be visible and clickable


	

	WebElement submitNewPassButton2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit']")));

	// Scroll into view using JavaScript
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", submitNewPassButton2);

	// Optional small wait to let rendering catch up
	Thread.sleep(500);

	// Click via JavaScript if still not interactable
	
	
	try {
	    wait.until(ExpectedConditions.elementToBeClickable(submitNewPassButton2)).click();
	} catch (ElementNotInteractableException e) {
	    System.out.println("Fallback to JS click due to headless issues");
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitNewPassButton2);
	}
	
	
	
	
	threadSleep(TestConstants.WAIT_THREE);
	
	String currentUrl = driver.getCurrentUrl();
    System.out.println("Current URL: " + currentUrl);

    // Extract the ID from the URL
    String[] parts = currentUrl.split("/");  // split by "/"
     extractedId = null;
    for (int i = 0; i < parts.length; i++) {
        if (parts[i].equals("requests") && i + 1 < parts.length) {
            extractedId = parts[i + 1];
            break;
        }
    }

    System.out.println("Extracted ID: " + extractedId);
    
    
    PropertyUtilWriter.writeProperty("extractedId", extractedId);
    
    
    
    System.out.println("TEST PASSED: Stakeholder Registered Successfully");
	
}





}

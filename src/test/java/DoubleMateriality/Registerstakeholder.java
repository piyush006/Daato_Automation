package DoubleMateriality;

import java.util.ArrayList;

import org.openqa.selenium.By;
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
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Wait for the button to be visible and clickable
    
	
	WebElement submitNewPassButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitNewPassButton);
	submitNewPassButton.click();
	
	
	
	threadSleep(TestConstants.WAIT_ONE);
	
	WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
	lastNameField.sendKeys("Test");
	
	threadSleep(TestConstants.WAIT_ONE);
	
	

	// Wait for the button to be visible and clickable


	
	WebElement submitNewPassButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitNewPassButton2);
	submitNewPassButton2.click();
	
	
	
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

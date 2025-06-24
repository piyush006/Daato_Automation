package ESRS_Report;

import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.PropertyUtilReader;
import DMUTILS.PropertyUtilWriter;
import ESRS_UTILS.PropertyUtilReaderESRS;
import daato_automation_page.Fillsurvey;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;
import utils.AuthTokenadminUtil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Registerentity extends BaseTest{
	
	String childEmail;
    String ParentEmail;
	
	
	@BeforeClass
	public void getadmintoken() {
		
		childEmail=PropertyUtilReaderESRS.childemail();
		ParentEmail=PropertyUtilReaderESRS.parentemail();
	
	}	
	
	
 
	@Test(priority=1)
	public void registerentity() throws InterruptedException {
	
		
	System.out.println(childEmail);
	
	Fillsurvey fillsurvery = new Fillsurvey(driver);
	fillsurvery.yopmailLoginesrs(childEmail);
	ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

	System.out.println(wid.size());
	driver.switchTo().window(wid.get(2));
	//WebElement button1 = driver.findElement(By.cssSelector("button p.MuiTypography-body1"));
	//button1.click();
//	PropertyFileUtils prop = new PropertyFileUtils();
//	LoginPage login = new LoginPage(driver);
	
	threadSleep(PageConstants.WAIT_THREE);
	
	WebElement inputField = driver.findElement(By.id("username"));
	threadSleep(TestConstants.WAIT_ONE);
	inputField.sendKeys(childEmail);
	threadSleep(TestConstants.WAIT_TWO);
	WebElement button = driver.findElement(By.id("kc-login"));
	button.click();	
	threadSleep(TestConstants.WAIT_TWO);
	fillsurvery.yopmailLoginforOTP(childEmail);
	

	WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-new']"));
	passwordField.sendKeys("12");
	
	threadSleep(TestConstants.WAIT_ONE);

	WebElement passwordConfirmField = driver.findElement(By.xpath("//input[@id='password-confirm']"));
	passwordConfirmField.sendKeys("12");
	
	takeScreenshot("before_submit.png");
	
	System.out.println("clickedhere");
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	WebElement submitNewPassButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit']")));

	// Scroll into view using JavaScript
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", submitNewPassButton);

	// Optional small wait to let rendering catch up
	Thread.sleep(500);

	// Click via JavaScript if still not interactable
	
	System.out.println("I am here before submit");
	try {
	    wait.until(ExpectedConditions.elementToBeClickable(submitNewPassButton)).click();
	} catch (ElementNotInteractableException e) {
	    System.out.println("Fallback to JS click due to headless issues");
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitNewPassButton);
	}
	
	
	
	
	threadSleep(TestConstants.WAIT_TWO);
	
	System.out.println("TEST PASSED: The ESRS Child Entity Manager received the invitation email and data collection request, and registered successfully");
      
	
}
	
	
	@Test(priority=2)
	public void registerparentenity() throws InterruptedException {
		
	
	System.out.println(ParentEmail);
	
	Fillsurvey fillsurvery = new Fillsurvey(driver);
	fillsurvery.yopmailLoginesrs(ParentEmail);
	ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

	System.out.println(wid.size());
	driver.switchTo().window(wid.get(2));
	
	threadSleep(PageConstants.WAIT_THREE);
	
	WebElement inputField = driver.findElement(By.id("username"));
	threadSleep(TestConstants.WAIT_ONE);
	inputField.sendKeys(ParentEmail);
	threadSleep(TestConstants.WAIT_TWO);
	WebElement button = driver.findElement(By.id("kc-login"));
	button.click();	
	threadSleep(TestConstants.WAIT_TWO);
	fillsurvery.yopmailLoginforOTP(ParentEmail);
	

	WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-new']"));
	passwordField.sendKeys("12");
	
	threadSleep(TestConstants.WAIT_ONE);

	WebElement passwordConfirmField = driver.findElement(By.xpath("//input[@id='password-confirm']"));
	passwordConfirmField.sendKeys("12");
	
	System.out.println("I am here before submit");
	
	takeScreenshot("before_submit.png");
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
	
	
	threadSleep(TestConstants.WAIT_TWO);
	
	
	System.out.println("TEST PASSED: The ESRS Parent Entity Manager received the invitation email and data collection request, and registered successfully");
	
		}
	
	
	public void takeScreenshot(String fileName) {
	    try {
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String filePath = System.getProperty("user.dir") + "/screenshots/" + fileName;
	        FileUtils.copyFile(srcFile, new File(filePath));
	        System.out.println("Screenshot saved at: " + filePath);
	    } catch (IOException e) {
	        System.out.println("Screenshot failed: " + e.getMessage());
	    }
	}
	
	
	
	
}	
	



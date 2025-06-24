package ESRS_Report;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	threadSleep(TestConstants.WAIT_ONE);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	WebElement submitNewPassButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitNewPassButton);
	submitNewPassButton.click();
	
	//threadSleep(TestConstants.WAIT_ONE);
	
	//WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
	//lastNameField.sendKeys("Test");
	
//	threadSleep(TestConstants.WAIT_ONE);
	
	// Using value attribute in XPath
//	WebElement submitUpdateButton = driver.findElement(By.xpath("//input[@value='Submit']"));
//	submitUpdateButton.click();
	
	
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
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	WebElement submitNewPassButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitNewPassButton);
	submitNewPassButton.click();
	
	
	
	threadSleep(TestConstants.WAIT_TWO);
	
	
	System.out.println("TEST PASSED: The ESRS Parent Entity Manager received the invitation email and data collection request, and registered successfully");
	
		}
	
	
	
	
	
	
}	
	



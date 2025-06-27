package EUTaxonomy;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import daato_automation_page.Fillsurvey;
import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;


public class EURegisterdataprovider extends BasePage{
	
	
	WebDriver driver;

	public EURegisterdataprovider(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement clicksubmitbuton;
	
	@FindBy(xpath = "//button[@class='sc-iGgWBj cuoIjU MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth sc-gsFSXq cOyzay MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth']")
	WebElement confirmandsubmit;
	
	@FindBy(xpath = "(//p[@class='sc-jlZhew jjhSap MuiTypography-root MuiTypography-body1'][contains(text(),'Have you adopted and embedded a commitment to incorporate a human rights')])")
	WebElement selectrequest;
	
	
	@FindBy(xpath = "//input[@value='yes']")
	WebElement clickdatapoint;
	
	
	
	
	
	
	
	
	
	
	public String registerdataprovider(String Email) throws InterruptedException {
	
	

	Fillsurvey fillsurvery = new Fillsurvey(driver);
	fillsurvery.yopmailLogin(Email);
	ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

	System.out.println(wid.size());
	driver.switchTo().window(wid.get(2));
	
	
	WebElement button1 = driver.findElement(By.cssSelector("button p.MuiTypography-body1"));
	button1.click();
	
	
	threadSleep(PageConstants.WAIT_TWO);
	
	WebElement inputField = driver.findElement(By.id("username"));
	inputField.sendKeys(Email);
	threadSleep(PageConstants.WAIT_TWO);
	WebElement button = driver.findElement(By.id("kc-login"));
	button.click();	
	threadSleep(PageConstants.WAIT_TWO);
	fillsurvery.yopmailLoginforOTP(Email);
	

	WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-new']"));
	passwordField.sendKeys("12");
	
	threadSleep(PageConstants.WAIT_ONE);

	WebElement passwordConfirmField = driver.findElement(By.xpath("//input[@id='password-confirm']"));
	passwordConfirmField.sendKeys("12");
	
	threadSleep(PageConstants.WAIT_ONE);
	WebElement submitNewPassButton = driver.findElement(By.xpath("//input[@type='submit']"));
	submitNewPassButton.click();
	
	
	
	
	threadSleep(PageConstants.WAIT_TWO);
	
	String currentUrl = driver.getCurrentUrl();
    System.out.println("Current URL: " + currentUrl);
    
    String[] parts = currentUrl.split("/");
    String Extractedid = parts[4];  // Index 4 contains the ID (0-based indexing)

    // Print or use the ID
    System.out.println("Extracted ID: " + Extractedid);
    
    

    
    
    
    
 
	
	
threadSleep(PageConstants.WAIT_FOUR);
	
	
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    JavascriptExecutor js = (JavascriptExecutor) driver;
	
    WebElement yesLabel = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//label[contains(., 'Yes')]")));

        // Scroll into view
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", yesLabel);
        Thread.sleep(1000); // short delay for animation

        try {
            // Try WebElement click first
            yesLabel.click();
            System.out.println("Clicked 'Yes' label with WebElement click.");
        } catch (Exception e) {
            // Fallback to JavaScript click
            System.out.println("WebElement click failed, using JS click.");
            js.executeScript("arguments[0].click();", yesLabel);
        }

      
  
    
	

    System.out.println("✅ Clicked on 'Yes' successfully!");
    
    

	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	Thread.sleep(500); 
	
    
 // Scroll into view
 		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clicksubmitbuton);
 		Thread.sleep(500);
 		
 		System.out.println("Displayed: " + clicksubmitbuton.isDisplayed());
 		System.out.println("Enabled: " + clicksubmitbuton.isEnabled());
 		System.out.println("Text: " + clicksubmitbuton.getText());

 		// Wait for clickability
 		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
 		wait2.until(ExpectedConditions.visibilityOf(clicksubmitbuton));
 		wait2.until(ExpectedConditions.elementToBeClickable(clicksubmitbuton));

 		// Try normal click, fallback to JS click in headless mode
 		try {
 		    clicksubmitbuton.click();
 		} catch (Exception e) {
 		    ((JavascriptExecutor) driver).executeScript(
 		        "arguments[0].scrollIntoView({block: 'center'}); arguments[0].click();", clicksubmitbuton);
 		}
 		
 		
 		
 		threadSleep(PageConstants.WAIT_TWO);
 		
 		confirmandsubmit.click();
 		
 		threadSleep(PageConstants.WAIT_FOUR);
 		
 		
 		return Extractedid;
 }
 	
    
	
	
	
}	
	
	
	
	

	



package daato_automation_page;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import java.time.Duration;

public class Fillsurvey extends BasePage{

	
	
	WebDriver driver;

	public Fillsurvey(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	@FindBy(xpath = "//input[@id='login']")
	WebElement loginButton;

	@FindBy(xpath = "//i[@class='material-icons-outlined f36']")
	WebElement arrowButton;

	@FindBy(id = "ifmail")
	WebElement mailFrame;

	@FindBy(id = "ifinbox")
	WebElement mailInboxFrame;
	
	@FindBy(xpath = "//p/b[contains(text(),'Code:')]")
	WebElement otpElement;
	
	@FindBy(xpath = "//input[@name='submit']")
	WebElement submitOTPButton;
	
	@FindBy(xpath = "//a[contains(text(),'View the request')]")
	WebElement viewToRequestButton;
	
	@FindBy(xpath = "//a[contains(text(),'View the workflow')]")
	WebElement ViewtheworkflowButton;
	
	
	
	
	public void yopmailLogin(String email) throws InterruptedException {
		openNewTabAndNavigate(PageConstants.PAGE_YOPMAIL_URL);
		loginButton.sendKeys(email);
		arrowButton.click();
		threadSleep(PageConstants.WAIT_TWO);
		driver.switchTo().frame(mailFrame);
		threadSleep(PageConstants.WAIT_TWO);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until button is clickable
		WebElement viewToRequestButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'View the request')]")));

		// Scroll into view if necessary
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewToRequestButton);

		// Extra: wait for visibility
		wait.until(ExpectedConditions.visibilityOf(viewToRequestButton));

		// Now click using JavaScript (bypasses overlay or hidden DOM issues)
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewToRequestButton);
		//viewToRequestButton.click();

	}
	
	public void yopmailLoginesrs(String email) throws InterruptedException {
		openNewTabAndNavigate(PageConstants.PAGE_YOPMAIL_URL);
		loginButton.sendKeys(email);
		arrowButton.click();
		threadSleep(PageConstants.WAIT_TWO);
		driver.switchTo().frame(mailFrame);
		threadSleep(PageConstants.WAIT_TWO);
		ViewtheworkflowButton.click();

	}
	
	
	
	
	public void openNewTabAndNavigate(String url) throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_FOUR);

	}
	
	public void SwitchToURL(String url) throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_ONE);
	}
	public void yopmailLoginforOTP(String email) throws InterruptedException {
		String otp = getOtpFromEmail(email);
		System.out.println(otp);
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Window handle size: " + windowHandles.size());
        driver.switchTo().window(windowHandles.get(2));
        WebElement otpInput = driver.findElement(By.id("otp"));
        otpInput.sendKeys(otp);
        submitOTPButton.click();        
    }
	public String getOtpFromEmail(String email) throws InterruptedException {
		String emailBody = getEmailBodyFromInbox(email);
		System.out.println(emailBody);

		// Regular expression to extract the OTP (numeric string of 6 digits)
		Pattern otpPattern = Pattern.compile("\\b\\d{6}\\b");
		Matcher matcher = otpPattern.matcher(emailBody);

		if (matcher.find()) {
			return matcher.group(); // Return OTP if found
		}

		return null; // Return null if no OTP found
		
	
	}
	public String getEmailBodyFromInbox(String email) throws InterruptedException {
		openNewTabAndNavigate(PageConstants.PAGE_YOPMAIL_URL);
		System.out.println(email);
		arrowButton.click();
		threadSleep(PageConstants.WAIT_TWO);
		driver.switchTo().frame(mailFrame);
		String emailBody = otpElement.getText(); // Get the email body text
		System.out.println(emailBody);
		return emailBody; // Return the email body content as a string
	}
	
	
	
}

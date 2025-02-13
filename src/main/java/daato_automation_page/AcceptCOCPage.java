
package daato_automation_page;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Excel.utility.Xls_Reader;
import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;

/**
 * @author 47Billion
 *
 */
public class AcceptCOCPage extends BasePage {

	WebDriver driver;

	public AcceptCOCPage(WebDriver driver) {
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

	@FindBy(xpath = "//a[contains(text(),'Go to the request')]")
	WebElement goToRequestButton;

	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement passWord;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement continueButton;

	@FindBy(xpath = "//input[@value='proposedCoc']")
	WebElement proposedCoc;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement submit;

	@FindBy(id = "multilineTextID-Comment")
	WebElement comment;

	@FindBy(xpath = "(//button[normalize-space()='Submit'])[2]")
	WebElement submit1;

	@FindBy(xpath = "//button[.//p[text()='View request']]")
	WebElement viewToRequestButton;
	
	@FindBy(xpath = "//div[text()='Please choose your preferred method of agreeing to the human rights-related and environment-related expectations*']")
	WebElement pleaseChoose;
	
	@FindBy(xpath = "//span[text()='I accept and sign the Code of Conduct proposed by the customer']")
	WebElement acceptCOC;
	
	@FindBy(xpath = "//div[text()='Drag & drop click to upload']")
	WebElement uploadButton;
	
	@FindBy(xpath = "//input[@type='file']")
	WebElement fileInput;

	public void yopmailLogin(String email) throws InterruptedException {
		openNewTabAndNavigate(PageConstants.PAGE_YOPMAIL_URL);
		loginButton.sendKeys(email);
		arrowButton.click();
		threadSleep(PageConstants.WAIT_FOUR);
		driver.switchTo().frame(mailFrame);
		goToRequestButton.click();
		threadSleep(PageConstants.WAIT_TWO);

		ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		printMessage("Window handle size: " + windowHandles.size());
		driver.switchTo().window(windowHandles.get(2));
		printMessage("btn");
		viewToRequestButton.click();
	}

	public void openNewTabAndNavigate(String url) throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_FOUR);

	}

	public void yopmailCustomerLogin(String email, String pass) throws InterruptedException {

		userName.sendKeys(email);
		continueButton.click();
		threadSleep(PageConstants.WAIT_TWO);
		passWord.sendKeys(pass);
		continueButton.click();
		threadSleep(PageConstants.WAIT_TWO);
	}

	public void acceptCocRequest() throws InterruptedException {
		System.out.println(driver.getCurrentUrl());
		// proposedCoc.click();
		threadSleep(PageConstants.WAIT_TWO);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", pleaseChoose);
		threadSleep(PageConstants.WAIT_TWO);
		acceptCOC.click();	
		threadSleep(PageConstants.WAIT_TWO);
		if (uploadButton.isDisplayed() && uploadButton.isEnabled()) {	   
		    fileInput.sendKeys("D:\\SeleniumDemo\\Daato.jpg");
		    printMessage("File uploaded successfully.");
		} else {
			printMessage("Element is not interactable.");

		}
		threadSleep(PageConstants.WAIT_ONE);
		Xls_Reader reader = new Xls_Reader(PageConstants.PAGE_DATA_FILE_PATH);
		String url = driver.getCurrentUrl();
		printMessage(url);
		reader.setCellData("Recent_Added", "CocCurrentUrl", 2, url);
		String URL1 = reader.getCellData("Recent_Added", "CocCurrentUrl", 2);
		printMessage(URL1);
		submit.click();
		threadSleep(PageConstants.WAIT_FIVE);
		comment.sendKeys(PageConstants.PAGE_COMMENT_NAME);
		threadSleep(PageConstants.WAIT_ONE);
		submit1.click();
		threadSleep(PageConstants.WAIT_EIGHT);

	}

}

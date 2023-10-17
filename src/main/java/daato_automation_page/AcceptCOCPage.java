/* Hello, Welcome to Divya Coding */
package daato_automation_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

	@FindBy(xpath = "(//button[@name='action'][normalize-space()='Continue'])[2]")
	WebElement continueButton;

	@FindBy(xpath = "//input[@value='proposedCoc']")
	WebElement proposedCoc;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement submit;

	@FindBy(id = "multilineTextID-Comment")
	WebElement comment;

	@FindBy(xpath = "(//button[normalize-space()='Submit'])[2]")
	WebElement submit1;

	public void yopmailLogin(String email) throws InterruptedException {
		openNewTabAndNavigate(PageConstants.PAGE_YOPMAIL_URL);
		loginButton.sendKeys(email);
		arrowButton.click();
		threadSleep(PageConstants.WAIT_FOUR);
		driver.switchTo().frame(mailFrame);
		goToRequestButton.click();
	}

	public void openNewTabAndNavigate(String url) throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_FOUR);

	}

	public void yopmailCustomerLogin(String email, String pass) throws InterruptedException {
		userName.sendKeys(email);
		passWord.sendKeys(pass);
		continueButton.click();
		threadSleep(PageConstants.WAIT_TWO);
	}

	public void acceptCocRequest() throws InterruptedException {
		proposedCoc.click();
		threadSleep(PageConstants.WAIT_ONE);
		submit.click();
		threadSleep(PageConstants.WAIT_FIVE);
		comment.sendKeys(PageConstants.PAGE_COMMENT_NAME);
		threadSleep(PageConstants.WAIT_ONE);
		submit1.click();
		threadSleep(PageConstants.WAIT_EIGHT);
	}

}

/* Hello, Welcome to Divya Coding */
package daato_automation_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;

public class LoginPage extends BasePage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement emailId;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//input[@id='kc-login']")
	WebElement login;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement customerLogin;

	public void LoginApplication(String email, String pass) throws InterruptedException {
		emailId.sendKeys(email);
		login.click();
		password.sendKeys(pass);
		threadSleep(PageConstants.WAIT_TWO);
		login.click();
		threadSleep(PageConstants.WAIT_TWO);
	}

	public void CustomerLoginApplication(String email, String pass) throws InterruptedException {
		emailId.sendKeys(email);
		password.sendKeys(pass);
		threadSleep(PageConstants.WAIT_TWO);
		customerLogin.click();
		threadSleep(PageConstants.WAIT_THREE);
	}

	public void YopmailLoginApplication(String pass) throws InterruptedException {
		
		password.sendKeys(pass);
		customerLogin.click();
		threadSleep(PageConstants.WAIT_THREE);
	}
}

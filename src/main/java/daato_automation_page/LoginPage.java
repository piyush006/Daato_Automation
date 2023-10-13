/* Hello, Welcome to Divya Coding */
package daato_automation_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import daato_automation_pagecomponent.BasePage;


public class LoginPage extends BasePage{

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement emailId;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="(//button[@name='action'][normalize-space()='Continue'])[2]")
	WebElement login;

	public void LoginApplication(String email, String pass) throws InterruptedException {
		emailId.sendKeys(email);
		password.sendKeys(pass);
		threadSleep(2000);
		login.click();
		threadSleep(2000);
	}
}

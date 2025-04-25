package daato_automation_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;

public class Downloadrepository extends BasePage{
	
	WebDriver driver;

	public Downloadrepository(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	@FindBy(xpath = "//button[@id='button-exportReport']")
	WebElement export;

	@FindBy(xpath = "//li[@aria-label='Export all the company profiles information regarding your suppliers and business entities.']")
	WebElement clickexport;
	
	
	



public void clickanddownrepository() throws InterruptedException {
	
	
	export.click();
	
	Thread.sleep(PageConstants.WAIT_THREE);
	//closeButton.click();
	clickexport.click();

	
	

}












}
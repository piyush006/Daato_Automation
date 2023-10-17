/* Hello, Welcome to Divya Coding */
package daato_automation_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;

/**
 * @author 47Billion
 *
 */
public class AddSupplierPage extends BasePage{

	WebDriver driver;	
	public AddSupplierPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		 
	@FindBy(xpath="//header/div[1]/div[2]/div[1]/button[1]")
	WebElement module;
	
	@FindBy(xpath="//p[contains(text(),'Supply Chain Sustainability')]")
	WebElement supplyChainSust;
	
	@FindBy(xpath="//span[contains(text(),'Repository')]")
	WebElement repository;
	
	@FindBy(xpath="//button[normalize-space()='Add Supplier']")
	WebElement addSupplier;
	
	@FindBy(xpath="//li[normalize-space()='Add']")
	WebElement add;
	
	@FindBy(xpath="//input[@id='singleLineTextID-Company name (required)']")
	WebElement companyName;
	
	@FindBy(xpath="//input[@id='singleLineTextID-Contact email']")
	WebElement contactEmail;
	
	@FindBy(xpath="//input[@id='singleLineTextID-Contact name']")
	WebElement contactName;
	
	@FindBy(xpath="//input[@id='searchSelectID-Countries of Operation']")
	WebElement countriesOfOperation;
	
	@FindBy(xpath="//input[@id='searchSelectID-Products or services']")
	WebElement productsOrServices;
	
	@FindBy(xpath="//input[@id='numberInputID-Spend volume']")
	WebElement spendVolume;
	
	@FindBy(xpath="//button[normalize-space()='Create']")
	WebElement createButton;
	
	public void navigateToSupplier() {
		module.click();
		supplyChainSust.click();
		repository.click();
		addSupplier.click();
		add.click();
	}	
	
	public void addSupplierForm(String companyN, String contactE, String contactN, int company1, int product1, String spendV) throws InterruptedException {
		companyName.sendKeys(companyN);
		contactEmail.sendKeys(contactE);
		contactName.sendKeys(contactN);
		countriesOfOperation.click();
		driver.findElement(By.xpath("//li[@id='searchSelectID-Countries of Operation-option-"+0+"']")).click();
		driver.findElement(By.xpath("//li[@id='searchSelectID-Countries of Operation-option-"+company1+"']")).click();
		productsOrServices.click();
		driver.findElement(By.xpath("//li[@id='searchSelectID-Products or services-option-"+product1+"']")).click();
		spendVolume.sendKeys(spendV);
		threadSleep(PageConstants.WAIT_THREE);
		createButton.click();
		threadSleep(PageConstants.WAIT_TWENTY);
	}	
}

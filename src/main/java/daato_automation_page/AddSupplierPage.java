/* Hello, Welcome to Divya Coding */
package daato_automation_page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;
import java.time.Duration;
/**
 * @author 47Billion
 *
 */
public class AddSupplierPage extends BasePage {

	WebDriver driver;

	public AddSupplierPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//header/div[1]/div[2]/div[1]/button[1]")
	WebElement module;

	@FindBy(xpath = "//p[contains(text(),'Supply Chain Sustainability')]")
	WebElement supplyChainSust;

	@FindBy(xpath = "//span[contains(text(),'Repository')]")
	WebElement repository;

	@FindBy(xpath = "//button[normalize-space()='Add Supplier']")
	WebElement addSupplier;

	@FindBy(xpath = "//li[normalize-space()='Add']")
	WebElement add;

	@FindBy(xpath = "//input[@id='singleLineTextID-Company name (required)']")
	WebElement companyName;

	@FindBy(xpath = "//input[@id='singleLineTextID-Contact email']")
	WebElement contactEmail;

	@FindBy(xpath = "//input[@id='singleLineTextID-Contact name']")
	WebElement contactName;

	@FindBy(xpath = "//input[@id='searchSelectID-Countries of Operation']")
	WebElement countriesOfOperation;

	@FindBy(xpath = "//input[@id='searchSelectID-Products or services']")
	WebElement productsOrServices;
	
	@FindBy(xpath = "//input[@id='numberInputID-Spend volume']")
	WebElement spendVolume;

	@FindBy(xpath = "//button[normalize-space()='Create']")
	WebElement createButton;

	@FindBy(xpath = "//button[text()='Close']")
	WebElement popupCloseButton;

	public void navigateToSupplier() throws InterruptedException {
		module.click();
		supplyChainSust.click();
		repository.click();
		threadSleep(PageConstants.WAIT_EIGHT);
		//popupCloseButton.click();
		addSupplier.click();
		add.click();
	}

	public void addSupplierForm(String companyN, String contactE, String contactN, int company1, int product1,
			String spendV) throws InterruptedException {
		System.out.println(companyN);
		companyName.sendKeys(companyN);
		contactEmail.sendKeys(contactE);
		contactName.sendKeys(contactN);
		countriesOfOperation.click();
		driver.findElement(By.xpath("//li[@id='searchSelectID-Countries of Operation-option-" + 0 + "']")).click();
		driver.findElement(By.xpath("//li[@id='searchSelectID-Countries of Operation-option-" + company1 + "']")).click();
		System.out.println("piyush");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productsOrServices);
		Thread.sleep(500); // Small wait to ensure scroll completed
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", productsOrServices);
		System.out.println("piyush");
		productsOrServices.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='searchSelectID-Products or services-option-0']")));

		driver.findElement(By.xpath("//li[@id='searchSelectID-Products or services-option-" + 0 + "']")).click();
		System.out.println("piyush");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='searchSelectID-Products or services-option-" + product1 + "']")));
		
		driver.findElement(By.xpath("//li[@id='searchSelectID-Products or services-option-" + product1 + "']")).click();	
		System.out.println("piyush");
		System.out.println("I am new code");
		
		spendVolume.sendKeys(spendV);
		System.out.println(spendV);
		threadSleep(PageConstants.WAIT_THREE);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createButton);
		Thread.sleep(500); // Tiny wait

		WebDriverWait waitUntilEnabled = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitUntilEnabled.until(ExpectedConditions.elementToBeClickable(createButton));
		System.out.println("added bby me");

		createButton.click();
		System.out.println("addedsupplier");
		threadSleep(PageConstants.WAIT_FIVE);
	}
}

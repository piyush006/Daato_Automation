package daato_automation_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;

public class UploadRepository extends BasePage{
	
	
	WebDriver driver;

	public UploadRepository(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	@FindBy(xpath = "//button[normalize-space()='Add Supplier']")
	WebElement Addsupplier;

	@FindBy(xpath = "//li[normalize-space()='Import from file']")
	WebElement Importfromfile;
	
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement Add;
	
	
	@FindBy(xpath = "//p[@class='sc-jlZhew iXrjka MuiTypography-root MuiTypography-body1']")
	WebElement uploadButton;
	
	@FindBy(xpath = "//input[@type='file']")
	WebElement fileInput;
	
	@FindBy(xpath = "//span[normalize-space()='Company profile']")
	WebElement companyprofile;
	
	@FindBy(xpath = "//input[@placeholder='Example: Jane Smith']")
	WebElement getname;
	
	//input[@placeholder='Example: Jane Smith']
	
	
	public void uploadrepositoryfile(String excelpath) throws InterruptedException {
		
		Addsupplier.click();
		Importfromfile.click();
		threadSleep(PageConstants.WAIT_THREE);
		if (uploadButton.isDisplayed() && uploadButton.isEnabled()) {	   
		    fileInput.sendKeys(excelpath);
		    printMessage("File uploaded successfully.");
		} else {
			printMessage("Element is not interactable.");

		}
		threadSleep(PageConstants.WAIT_FOUR);
        Add.click();
        threadSleep(PageConstants.WAIT_FOUR);
	
	
	}
	
	
	public void checkcontactnamaftereditrepo(String companyname) throws InterruptedException {
		
    threadSleep(PageConstants.WAIT_TWO);
	driver.findElement(By.xpath("//p[normalize-space()='" + companyname + "']")).click();
	threadSleep(PageConstants.WAIT_TWO);
	companyprofile.click();
	threadSleep(PageConstants.WAIT_TEN);
	String ExpectedGetcontactname =getname.getText();
	Assert.assertEquals(ExpectedGetcontactname, companyname);
	
	}
	
	

}

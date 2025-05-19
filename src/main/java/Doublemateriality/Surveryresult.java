package Doublemateriality;

import java.time.Duration;

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

public class Surveryresult extends BasePage{
	
	

	WebDriver driver;

	public Surveryresult(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	@FindBy(xpath = "//button[normalize-space()='View Results']")
	WebElement viewresult;
	
	@FindBy(xpath = "//p[@class='sc-jlZhew jCmBDe MuiTypography-root MuiTypography-body1']")
	WebElement completestep1;
	
	@FindBy(xpath = "//button[normalize-space()='Complete step']")
	WebElement submit;
	
	String reporid;
	
public void checkresult() throws InterruptedException {
	
	reporid=ProperyUtilReader2.getReportId();
	
	String fullUrl = PageConstants.surverypage + reporid;
	
	openNewTabAndNavigate(fullUrl);
	threadSleep(PageConstants.WAIT_FOUR);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewresult);
	Thread.sleep(500); // Small wait to ensure scroll completed
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewresult);
	threadSleep(PageConstants.WAIT_TWO);
	
	
	
}

public void completestepfirst() throws InterruptedException {
	
reporid=ProperyUtilReader2.getReportId();
	
	String fullUrl = PageConstants.surverypage + reporid;
	openNewTabAndNavigate(fullUrl);
	threadSleep(PageConstants.WAIT_FOUR);

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='sc-jlZhew jCmBDe MuiTypography-root MuiTypography-body1']")));
	completestep1.click();
	threadSleep(PageConstants.WAIT_ONE);
	submit.click();
	threadSleep(PageConstants.WAIT_ONE);
}




private void openNewTabAndNavigate(String url) throws InterruptedException {
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get(url);
	threadSleep(PageConstants.WAIT_FOUR);
	
}	

}

package Daato_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class openfund {
	
	
	
	WebDriver driver;
	
	
	@Test
	
	public void testcy() throws InterruptedException{
	
	
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\47Billion\\Desktop\\chromedriver_win32\\chromedriver.exe");
    
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
  // options.addArguments("--headless");
    driver = new ChromeDriver(options);
    driver.get("https://app-staging.openfund.ca/login");

	
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("investorauto@yopmail.com");
	driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@123");
	driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
	Thread.sleep(3000);
	
	
	 WebElement dropdown = driver.findElement(By.xpath("//select[@aria-label='Phone number country']"));

     // Find all options within the dropdown
     List<WebElement> options1 = dropdown.findElements(By.tagName("option"));

     // Get the total number of options
     int totalOptions = options1.size();
	
	

	
	for(int i=1;i<=totalOptions;i++) {
	
	
	String piyush =driver.findElement(By.xpath("//select[@aria-label='Phone number country']/option["+i+"]")).getText();
	
	System.out.println(piyush);
	}
	
	
	}
}
	
	
	
	
	
	
	



package Daato_Automation;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Submitting_RAR extends Base_Class{
	
	
String Email;	
	
	@Test(enabled=false)
	
	public void submit_RAR() throws InterruptedException {
	

	
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
	 
	
	 
	
Email=reader.getCellData("Recent_Added", "Email",2); 
	 
	
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://yopmail.com/en/");
	driver.findElement(By.xpath("//input[@id='login']")).sendKeys(Email);
	driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
	Thread.sleep(4000);
	driver.switchTo().frame(driver.findElement(By.id("ifmail")));
	driver.findElement(By.xpath("//a[contains(text(),'Go to the request')]")).click();
	
	
	ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

	System.out.println(wid.size());
	//switch to active tab
	driver.switchTo().window(wid.get(2));
	
	
	
  driver.findElement(By.id("username")).sendKeys(Email);
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	//driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	Thread.sleep(2000);	
	 WebElement element1 = driver.findElement(By.xpath("(//p[contains(text(),'Child labour')])[1]"));
		scrollIntoView(element1);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//textarea[@id='multilineTextID-main'])[1]")).sendKeys("Automation test");
		Thread.sleep(1000);
		 WebElement element2 = driver.findElement(By.xpath("(//p[contains(text(),'Child labour')])[2]"));
			scrollIntoView(element2);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//textarea[@id='multilineTextID-main'])[2]")).sendKeys("Automation test");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[normalize-space()='Plan']")).click();
			Thread.sleep(5000);
	
			driver.findElement(By.xpath("//button[normalize-space()='Submit plan']")).click();
			Thread.sleep(3000);
			
  
	
	
	
	
	}
	
	@Test(priority=2)
	
	
	public void submit_rar() throws InterruptedException {
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
	 
	
	 
	
	Email=reader.getCellData("Recent_Added", "Email",2); 
		 
		
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://yopmail.com/en/");
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys(Email);
		driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
		Thread.sleep(4000);
		driver.switchTo().frame(driver.findElement(By.id("ifmail")));
		driver.findElement(By.xpath("//a[contains(text(),'Go to the request')]")).click();
		
		
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(wid.size());
		//switch to active tab
		driver.switchTo().window(wid.get(2));
		
		
		
	  driver.findElement(By.id("username")).sendKeys(Email);
		driver.findElement(By.id("password")).sendKeys("681993@Virat");
		//driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
		Thread.sleep(2000);		
		
		
		  driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("multilineTextID-Comment")).sendKeys("piyush");
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[2]")).click();
			Thread.sleep(5000);
	
		
		
		
	
	
	}
		
	public static void scrollIntoView(WebElement element) {
	    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	    jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", element);
	    System.out.println("Scroll into view with smooth behavior");
	}
	
	
	
	
	
	
	

}

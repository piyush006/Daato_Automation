package Daato_Automation;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Accept_CoC extends Base_Class{
	
	String Email;	
	
	@Test
	
	public void accept_CoC() throws InterruptedException {
	

	
	
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
	
	
	driver.findElement(By.xpath("//input[@value='proposedCoc']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("multilineTextID-Comment")).sendKeys("piyush");
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[2]")).click();
	Thread.sleep(8000);
	
	
	}
	
	
	

}

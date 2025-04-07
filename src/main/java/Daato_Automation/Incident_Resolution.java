package Daato_Automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Incident_Resolution extends Base_Class{
	
	
String Incident_title;

String Email;		
	
	@Test
	public void send_to_resolve() throws InterruptedException, IOException {
		
		Propertiesefile get = new Propertiesefile();
		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
		 
		Incident_title=reader.getCellData("Recent_Added", "Incident_title",2);
	  Email=reader.getCellData("Recent_Added", "Email",2);
		
	driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	Thread.sleep(2000);	
		
		driver.switchTo().newWindow(WindowType.TAB);
	//driver.get("https://demo.daato.io/modules/supplyChain/incidents");
		driver.get(get.getURLIncident());
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
		
		Thread.sleep(2000);

	driver.findElement(By.xpath("//button[normalize-space()='Open']")).click();

	Thread.sleep(6000);	
	
	driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys(Incident_title);

	Thread.sleep(8000);
	driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M12 8c1.1 ')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[normalize-space()='Resolve']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//textarea[@id='multilineTextID-Comment']")).sendKeys("Resolved");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='attachFileInputID-Attach files']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
	
	Thread.sleep(4000);

		
		
	}	
	
	
	
	}

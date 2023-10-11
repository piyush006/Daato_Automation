package Daato_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Accepting_SAQ extends Base_Class{
	
	String Company_Name;

	String Email;
	
@Test(priority=1)

public void accepting_SAQ() throws InterruptedException {
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
	 
	 Company_Name=reader.getCellData("Recent_Added", "Company_Name",2);
     Email=reader.getCellData("Recent_Added", "Email",2);
			 
			
     Thread.sleep(2000);
	
     driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
 	driver.findElement(By.id("password")).sendKeys("681993@Virat");
 	Thread.sleep(2000);
 	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
 	Thread.sleep(2000);	

	driver.switchTo().newWindow(WindowType.TAB);
	Thread.sleep(2000);
	
	//driver.get("https://daato.daato.dev/modules/supplyChain/suppliersRepository");
	driver.get("https://demo.daato.io/modules/supplyChain/suppliersRepository?");
	
	
	
	driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys(Company_Name);
	
	
	driver.findElement(By.xpath("//div[contains(text(),'"+Company_Name+"')]")).click();
	
	Thread.sleep(2000);
	
	
	driver.findElement(By.xpath("//button[normalize-space()='Data requests']")).click();
	
	driver.findElement(By.xpath("//div[contains(text(),'"+Company_Name+"')]")).click();
	
	Thread.sleep(10000);
	driver.findElement(By.xpath("//button[normalize-space()='Accept the answer']")).click();
	Thread.sleep(10000);
	
}
	
}


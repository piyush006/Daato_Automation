package Daato_Automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Accepting_RAR extends Base_Class{
	
	
String Company_Name;
String Email;
	

@Test
	
public void accept_RAR() throws InterruptedException, IOException {
	Propertiesefile get = new Propertiesefile();
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
	//driver.get("https://demo.daato.io/modules/supplyChain/suppliersRepository?");
	
	driver.get(get.getURLSupplierrepo());
Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys(Company_Name);
	
	
	driver.findElement(By.xpath("//div[contains(text(),'"+Company_Name+"')]")).click();
	
Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
	
	Thread.sleep(2000);
	
	
	driver.findElement(By.xpath("//button[normalize-space()='Data requests']")).click();
	
	driver.findElement(By.xpath("//div[@title='Request for Planning Remedial Actions']")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[normalize-space()='Accept the answer']")).click();
	Thread.sleep(5000);	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
	
	
	
	
	
	
	
	
	
	
	

}

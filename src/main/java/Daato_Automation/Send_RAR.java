package Daato_Automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Send_RAR extends Base_Class{
	
String Company;	


@Test

public void send_RAR() throws InterruptedException, IOException {
	
	Propertiesefile get = new Propertiesefile();
	driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	Thread.sleep(2000);		
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
	
	driver.switchTo().newWindow(WindowType.TAB);
	//driver.get("https://daato.daato.dev/modules/supplyChain/suppliersRepository");
	//driver.get("https://demo.daato.io/modules/supplyChain/suppliersRepository?");
	driver.get(get.getURLSupplierrepo());
	
Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
	
	Thread.sleep(2000);
	Company = reader.getCellData("Recent_Added","Company_Name",2);
	
	driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys(Company);
	
	
	driver.findElement(By.xpath("//div[contains(text(),'"+Company+"')]")).click();
	
Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
	
	Thread.sleep(2000);
	
    driver.findElement(By.xpath("//button[normalize-space()='Actions']")).click();
	
	driver.findElement(By.xpath("//li[normalize-space()='Request Remedial Actions']")).click();
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='searchSelectID-Risk category']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-Risk category-option-0']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='searchSelectID-Risk category']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	
	
	Thread.sleep(5000);
			
		
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	

}

package Daato_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Send_CoC extends Base_Class{

String Company;	

@Test

public void send_coc() throws InterruptedException {
	
	
	
	driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	Thread.sleep(2000);		
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
	
	driver.switchTo().newWindow(WindowType.TAB);
	//driver.get("https://daato.daato.dev/modules/supplyChain/suppliersRepository");
	driver.get("https://demo.daato.io/modules/supplyChain/suppliersRepository?");
	
	Company = reader.getCellData("Recent_Added","Company_Name",2);
	
	driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys(Company);
	
	
	driver.findElement(By.xpath("//div[contains(text(),'"+Company+"')]")).click();
	
	Thread.sleep(2000);
	
  driver.findElement(By.xpath("//button[normalize-space()='Actions']")).click();
	
	driver.findElement(By.xpath("//li[normalize-space()='Send Code of Conduct']")).click();
	
	driver.findElement(By.xpath("//button[normalize-space()='Send']")).click();
	
	
	Thread.sleep(3000);
		
	
	
	
	
	
	
	
	
}
	
	
	
	
}

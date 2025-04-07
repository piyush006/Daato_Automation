package Daato_Automation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;


public class Check_link_bw_Incident_Supplier extends Base_Class {
	
	
	String Company_Name;
	boolean flag;
	
	
	@Test

public void check_link_bw_Incident_Supplier() throws InterruptedException, IOException {
	
	
	
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
	
	Company_Name = reader.getCellData("Recent_Added","Company_Name",2);
	
	driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys(Company_Name);
	
	
	driver.findElement(By.xpath("//div[contains(text(),'"+Company_Name+"')]")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
	
	Thread.sleep(2000);
	
	
	driver.findElement(By.xpath("//button[normalize-space()='Incidents']")).click();
	
	Thread.sleep(2000);
	
	
	
	
	try {
		flag = flag=driver.findElement(By.xpath("(//div/p[normalize-space()='"+Company_Name+"'])[2]")).isDisplayed();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
    Assert.assertEquals(flag, true);
	
	
	
	
	
	
	
	
	
}	
	
	
	
	
	
	

}

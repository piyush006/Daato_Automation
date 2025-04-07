package Daato_Automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Request_Remedial_Action_Incident extends Base_Class{
	
	
 String Company_Name;

	String Email;		
	
	@Test
public void request_remedial_Acion() throws InterruptedException, IOException {
	
		Propertiesefile get = new Propertiesefile();
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
	 
	 Company_Name=reader.getCellData("Recent_Added", "Company_Name",2);
   Email=reader.getCellData("Recent_Added", "Email",2);
	
driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
driver.findElement(By.id("password")).sendKeys("681993@Virat");
Thread.sleep(2000);
driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
Thread.sleep(2000);	
	
	driver.switchTo().newWindow(WindowType.TAB);
//driver.get("https://demo.daato.io/modules/supplyChain/incidents");
Thread.sleep(1000);		

driver.get(get.getURLIncident());

Thread.sleep(2000);

driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();

Thread.sleep(2000);

driver.findElement(By.xpath("//button[normalize-space()='Open']")).click();

Thread.sleep(1000);
driver.findElement(By.xpath("//p[normalize-space()='"+Company_Name+"']")).click();
	
Thread.sleep(1000);

driver.findElement(By.xpath("//button[normalize-space()='Request action']")).click();
	
Thread.sleep(1000);	

driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	

Thread.sleep(2000);		
	
	
	
	
	
}
	
	
}	
	
	
	
	
	
	
	
	
	
	


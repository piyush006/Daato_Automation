package Daato_Automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Add_Incident extends Base_Class {
	
	String Company_Name;

	String Email;	
	
	
	
	
@Test	
	
	
	
public void add_incident() throws InterruptedException, IOException {
	
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
driver.findElement(By.xpath("//button[normalize-space()='Add Incident']")).click();

driver.findElement(By.xpath("(//input[@id='singleLineTextID-undefined'])[1]")).sendKeys(Company_Name);
Thread.sleep(1000);	
driver.findElement(By.xpath("(//input[@id='searchSelectID-undefined'])[7]")).click();
Thread.sleep(1000);	
driver.findElement(By.xpath("//li[@id='searchSelectID-undefined-option-0']")).click();
Thread.sleep(1000);		
	
driver.findElement(By.xpath("(//input[@id='searchSelectID-undefined'])[8]")).sendKeys(Company_Name);
driver.findElement(By.xpath("//li[@id='searchSelectID-undefined-option-0']")).click();
Thread.sleep(1000);	
driver.findElement(By.xpath("(//input[@id='searchSelectID-undefined'])[9]")).sendKeys("piyush.soni@47billion.com");	
driver.findElement(By.xpath("//li[@id='searchSelectID-undefined-option-0']")).click();
Thread.sleep(1000);	
driver.findElement(By.xpath("(//input[@id='searchSelectID-undefined'])[10]")).click();
driver.findElement(By.xpath("//li[@id='searchSelectID-undefined-option-0']")).click();
Thread.sleep(1000);	
driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
Thread.sleep(1000);	
driver.findElement(By.xpath("//textarea[@id='multilineTextID-undefined']")).sendKeys("Automationtest");
Thread.sleep(1000);	
driver.findElement(By.xpath("//div[@class='sc-gEvEer YFevl MuiStack-root']")).click();
Thread.sleep(1000);	
driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
Thread.sleep(1000);	
driver.findElement(By.xpath("//input[@name='childLabor-include']")).click();

driver.findElement(By.xpath("//input[@name='forcedLabour-include']")).click();

driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();

Thread.sleep(3000);

}	
	
	
}

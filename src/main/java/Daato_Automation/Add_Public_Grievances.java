package Daato_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Add_Public_Grievances extends Base_Class{
	

@Test
	
public void add_public_grievances() throws InterruptedException {
	
Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
	
	driver.switchTo().newWindow(WindowType.TAB);
	//driver.get("https://daato.daato.dev/modules/supplyChain/suppliersRepository");
	driver.get("https://demo.daato.io/grievances/demo");	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[normalize-space()='Report']")).click();
	
	
	
	
	
	
	driver.findElement(By.xpath("//input[@id='singleLineTextID-Who do you represent?']")).sendKeys("Daato");
	driver.findElement(By.xpath("//input[@id='singleLineTextID-Name']")).sendKeys("Autocomment");
	driver.findElement(By.xpath("//input[@id='singleLineTextID-Email']")).sendKeys("piyush.soni@47billion.com");
	driver.findElement(By.xpath("//input[@id='singleLineTextID-Phone number']")).sendKeys("91-7999934710");
	driver.findElement(By.xpath("//input[@id='singleLineTextID-Company in question (Required)']")).sendKeys("Daato");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@value='imminent']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='searchSelectID-What is the category of the human rights complaint?']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-What is the category of the human rights complaint?-option-0']")).click();
	Thread.sleep(2000);
	
driver.findElement(By.xpath("//li[@id='searchSelectID-What is the category of the human rights complaint?-option-1']")).click();
Thread.sleep(2000);
    driver.findElement(By.xpath("(//input[@value='true'])[1]")).click();
	Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	Thread.sleep(2000);
    driver.findElement(By.xpath("//p[contains(text(),'Submit')]")).click();
	Thread.sleep(15000);
}
	
	
	
}

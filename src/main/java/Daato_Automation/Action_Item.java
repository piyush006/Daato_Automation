package Daato_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Action_Item extends Base_Class{
	
	String Company_Name;
	String SAQ_Accepted;
	String Email;
	
	
@Test

public void check_action_item_list() throws InterruptedException {
	
	
	
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier.xlsx");
		 
		 int count = reader.getRowCount("data");
		 
		 for(int i=0;i<count-1;i++) {
			
			 SAQ_Accepted=reader.getCellData("data", "SAQ_Accepted", i+2);
			 
			 if(SAQ_Accepted.equals("No")) {
				 
				 Company_Name=reader.getCellData("data", "Company_Name", i+2);
				 Email=reader.getCellData("data", "Email", i+2);
				 
				 break; 
				 
			 }
			 
			
		 }

		
		driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
		driver.findElement(By.id("password")).sendKeys("681993@Virat");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//p[@class='sc-breuTD dAOWMV MuiTypography-root MuiTypography-body1 MuiTypography-alignCenter']")).click();
		driver.findElement(By.id("menuItemId-profile")).click();
		driver.findElement(By.id("inputId-languages")).click();
		driver.findElement(By.xpath("//li[normalize-space()='English']")).click();
		driver.findElement(By.xpath("//button[@id='buttonID-applySettings']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(240));
		String Success =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='sc-breuTD liTfKa MuiTypography-root MuiTypography-body1']"))).getText();
		
		System.out.println(Success);
		driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M12 4.7L11')]")).click();

		Thread.sleep(2000);	
		
		driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'Supply Chain Risk')]")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='Suppliers repository']")).click();	
	
		driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys(Company_Name);
		Thread.sleep(2000);	
		
		driver.findElement(By.xpath("//div[contains(text(),'"+Company_Name+"')]")).click();
		
		Thread.sleep(2000);
	
	  driver.findElement(By.xpath("//button[normalize-space()='Actions']")).click();
	  
WebElement list =		(WebElement) driver.findElements(By.xpath("//ul[@role='menu']"));

System.out.println(list);
	
	
	
	
}


}

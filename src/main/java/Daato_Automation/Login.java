package Daato_Automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Base_Class{
	
	
	@Test   
    
	public void daato_login() throws InterruptedException {	
		
		driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
		driver.findElement(By.id("password")).sendKeys("681993@Virat");
		driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
		
	boolean flag =	driver.findElement(By.xpath("//header/div[1]/div[3]/div[4]/button[1]/span[1]/*[1]")).isDisplayed();
	Assert.assertTrue(flag);

		
		
		
	
		
	                                          
}
}

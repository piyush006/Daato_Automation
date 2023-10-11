package Daato_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Add_User_Module_Specific extends Base_Class{
	
String User_Invited;
String Name;
String Email;
	
	
	
	
@Test

public void supply_chain_managment_scs_module_manager() throws InterruptedException {
	
	
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
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M12 4.7L11')]")).click();

	Thread.sleep(2000);
	driver.findElement(By.xpath("//header/div[1]/div[3]/div[4]/button[1]/span[1]/*[1]")).click();
	
	driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
	
	 Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\add_user_module_specific.xlsx");
	 
	 int count = reader.getRowCount("SCS_Module_Manager");
	 
	 for(int i=0;i<count-1;i++) {
		
		 User_Invited=reader.getCellData("SCS_Module_Manager", "User_Invited", i+2);
		 
		 if(User_Invited.equals("No")) {
		 Name=reader.getCellData("SCS_Module_Manager","Name", i+2);	 
		 Email=reader.getCellData("SCS_Module_Manager", "Email", i+2); 
		
		System.out.println(Email);
	
	driver.findElement(By.id("singleLineTextID-Name")).sendKeys(Name);
	driver.findElement(By.id("emailInputID-Email")).sendKeys(Email);
	
	JavascriptExecutor j = (JavascriptExecutor)driver;
	j.executeScript("window.scrollBy(0,10000)");
	
	driver.findElement(By.xpath("//input[@value='module-specific']")).click();
	
	
	JavascriptExecutor t = (JavascriptExecutor)driver;
	t.executeScript("window.scrollBy(0,10000)");
	
	
	Thread.sleep(10000);
   /* driver.findElement(By.xpath("(//input[@placeholder='Select from the list'])[4]")).click();
    driver.findElement(By.xpath("(//input[@placeholder='Select from the list'])[4]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//li[@id='searchSelectID-undefined-option-0']")).click();
	
    driver.findElement(By.xpath("//input[@value='admin']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='Invite']")).click();
	
	
	
	Thread.sleep(3000);
	reader.setCellData("SCS_Module_Manager","User_Invited",i+2,"Yes");
     

	break;
	*/
}
		 
		 
}	
	
	
}
}

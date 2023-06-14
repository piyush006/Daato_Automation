package Daato_Automation;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Submitting_SAQ extends Base_Class{

	String Email;
	String User_Registered;
	
@Test


public void submitting_SAQ() throws InterruptedException {
	
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier.xlsx");
	 
	 int count = reader.getRowCount("data");
	 
	 for(int i=0;i<count-1;i++) {
		
		 User_Registered=reader.getCellData("data", "User_Registered", i+2);
		 
		 if(User_Registered.equals("No")) {
			 
		 Email=reader.getCellData("data", "Email", i+2); 
	 
	
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://yopmail.com/en/");
	driver.findElement(By.xpath("//input[@id='login']")).sendKeys(Email);
	driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
	driver.switchTo().frame(driver.findElement(By.id("ifmail")));
	driver.findElement(By.xpath("//a[contains(text(),'View the request')]")).click();
	
	
	ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

	System.out.println(wid.size());
	//switch to active tab
	driver.switchTo().window(wid.get(2));
	
	
	
   // driver.findElement(By.id("username")).sendKeys(Email);
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
	//driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	Thread.sleep(3000);
	reader.setCellData("data","User_Registered",i+2,"Yes");
	

	break;
	
		 }
	 }
	
	 driver.findElement(By.xpath("//p[contains(text(),'q')]")).click();
	driver.findElement(By.id("menuItemId-profile")).click();
	driver.findElement(By.id("inputId-languages")).click();
	driver.findElement(By.xpath("//li[normalize-space()='English']")).click();
	driver.findElement(By.xpath("//button[@id='buttonID-applySettings']")).click();
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(240));
	String Success =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='sc-breuTD liTfKa MuiTypography-root MuiTypography-body1']"))).getText();
	
	System.out.println(Success);
	
	driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M12 4.7L11')]")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[contains(text(),'Requests')]")).click();
	driver.findElement(By.xpath("//div[contains(text(),'piyush.soni@47billion.com')]")).click();
	driver.findElement(By.xpath("//button[normalize-space()='Submit the answer']")).click();
	
	
	driver.findElement(By.id("multilineTextID-Comment")).sendKeys("piyush");
	driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	Thread.sleep(8000);
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
}

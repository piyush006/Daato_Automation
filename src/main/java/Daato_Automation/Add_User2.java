package Daato_Automation;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Add_User2 extends Base_Class{
	
	
String User_Invited;
String Email;
String Name;


	
@Test


public void add_user_admin() throws InterruptedException {
	
	
	
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
	
	 Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\add_user.xlsx");
	 
	 int count = reader.getRowCount("data");
	 
	 for(int i=0;i<count-1;i++) {
		
		 User_Invited=reader.getCellData("data", "User_Invited", i+2);
		 
		 if(User_Invited.equals("No")) {
		 Name=reader.getCellData("data","Name", i+2);	 
		 Email=reader.getCellData("data", "Email", i+2); 
		
		System.out.println(Email);
	
	driver.findElement(By.id("singleLineTextID-Name")).sendKeys(Name);
	driver.findElement(By.id("emailInputID-Email")).sendKeys(Email);
	
    driver.findElement(By.xpath("//input[@value='admin']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='Invite']")).click();
	
	
	
	Thread.sleep(3000);
	reader.setCellData("data","User_Invited",i+2,"Yes");
     

	break;
	
}
		 
		 
}
driver.switchTo().newWindow(WindowType.TAB);
driver.get("https://yopmail.com/en/");
driver.findElement(By.xpath("//input[@id='login']")).sendKeys(Email);
driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
Thread.sleep(3000);
driver.switchTo().frame(driver.findElement(By.id("ifmail")));
Thread.sleep(3000);
driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]/a")).click();
System.out.println("piyush");


ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

System.out.println(wid.size());
//switch to active tab
driver.switchTo().window(wid.get(2));
driver.findElement(By.id("password")).sendKeys("681993@Virat");
Thread.sleep(3000);
driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
Thread.sleep(4000);

}


@Test



public void add_user_data_provider() throws InterruptedException {
	
	
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
	driver.findElement(By.xpath("//header/div[1]/div[3]/div[4]/button[1]/span[1]/*[1]")).click();
	
	driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
	
	 Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\add_data_provider.xlsx");
	 
	 int count = reader.getRowCount("data");
	 
	 for(int i=0;i<count-1;i++) {
		
		 User_Invited=reader.getCellData("data", "User_Invited", i+2);
		 
		 if(User_Invited.equals("No")) {
			 
			 Name=reader.getCellData("data","Name", i+2);	 
		 Email=reader.getCellData("data", "Email", i+2); 
		
		System.out.println(Email);
	
		driver.findElement(By.id("singleLineTextID-Name")).sendKeys(Name);
	driver.findElement(By.id("emailInputID-Email")).sendKeys(Email);
	 driver.findElement(By.xpath("//input[@value='contributor']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='Invite']")).click();
	
	Thread.sleep(3000);
	reader.setCellData("data","User_Invited",i+2,"Yes");
     

	break;
	
}
	 
}
}

@Test


public void add_isolated_data_provider() throws InterruptedException {
	
	
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
	driver.findElement(By.xpath("//header/div[1]/div[3]/div[4]/button[1]/span[1]/*[1]")).click();
	
	driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
	
	 Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\add_isolated_data_provider.xlsx");
	 
	 int count = reader.getRowCount("data");
	 
	 for(int i=0;i<count-1;i++) {
		
		 User_Invited=reader.getCellData("data", "User_Invited", i+2);
		 
		 if(User_Invited.equals("No")) {
			 Name=reader.getCellData("data","Name", i+2);	 
		 Email=reader.getCellData("data", "Email", i+2); 
		
		System.out.println(Email);
	
		driver.findElement(By.id("singleLineTextID-Name")).sendKeys(Name);
	driver.findElement(By.id("emailInputID-Email")).sendKeys(Email);
    driver.findElement(By.xpath("//input[@value='isolated-contributor']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='Invite']")).click();
	
	Thread.sleep(3000);
	reader.setCellData("data","User_Invited",i+2,"Yes");
     

	break;
	
	
	
}
	 
}	
	
	
}

	

}



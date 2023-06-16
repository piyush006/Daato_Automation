package Daato_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Add_Supplier extends Base_Class{
	
	
	String User_Invited;
	String Email;	
	String Company_Name;
	String Identifier;
	String Order_volume_in_EUR;
	
	
	
	

	
@Test

public void add_supplier() throws InterruptedException {
	
	
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
	
	driver.findElement(By.xpath("//button[normalize-space()='Add supplier']")).click();
	
	driver.findElement(By.xpath("//li[normalize-space()='Add']")).click();
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier.xlsx");
	 
	 int count = reader.getRowCount("data");
	 
	 for(int i=0;i<count-1;i++) {
		
		 User_Invited=reader.getCellData("data", "User_Invited", i+2);
		 
		 if(User_Invited.equals("No")) {
			 
		 Email=reader.getCellData("data", "Email", i+2); 
		 Company_Name = reader.getCellData("data", "Company_Name", i+2);
		 Identifier =  reader.getCellData("data", "Identifier", i+2);
		 Order_volume_in_EUR = reader.getCellData("data", "Order_volume_in_EUR", i+2);

		
		
	

	
	driver.findElement(By.xpath("//input[@placeholder='Legal company name']")).sendKeys(Company_Name);
	driver.findElement(By.id("searchSelectID-undefined")).click();
	driver.findElement(By.xpath("//li[@id='searchSelectID-undefined-option-1']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Type in the number']")).sendKeys(Identifier);
	driver.findElement(By.xpath("//input[@placeholder='Select from the list']")).click();
	driver.findElement(By.xpath("//li[@id='searchSelectID-undefined-option-0']")).click();
	driver.findElement(By.xpath("//input[@placeholder='name@domain.com']")).sendKeys(Email);
	driver.findElement(By.xpath("//input[@placeholder='Example: 100000']")).sendKeys(Order_volume_in_EUR);
	Thread.sleep(3000);	
	driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
	Thread.sleep(10000);	
	reader.setCellData("data","User_Invited",i+2,"Yes");
	driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//input[@class='sc-cOFTSb sc-eKszNL GCAvE ghywui MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd']")).sendKeys(Company_Name);
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//tbody/tr[1]/td[9]/button[1]/*[1]")).click();
	driver.findElement(By.xpath("//li[normalize-space()='Send SAQ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[normalize-space()='Send']")).click();
	Thread.sleep(2000);
	
	break;
	
	
}
		 
		 
}

}


}

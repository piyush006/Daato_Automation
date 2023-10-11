package Daato_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Add_Supplier extends Base_Class{
	
	String Company_Name;
	String Contact_Email;
	String Contact_name;
	String Countries_of_operation;
	String Product_or_services;
	String Spend_volume;
	String User_Invited;
		
	
	
	
@Test

public void add_supplier() throws InterruptedException {
	
	
	driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	Thread.sleep(2000);
	
	/*driver.findElement(By.xpath("//p[@class='sc-breuTD dAOWMV MuiTypography-root MuiTypography-body1 MuiTypography-alignCenter']")).click();
	driver.findElement(By.id("menuItemId-profile")).click();
	driver.findElement(By.id("inputId-languages")).click();
	driver.findElement(By.xpath("//li[normalize-space()='English']")).click();
	driver.findElement(By.xpath("//button[@id='buttonID-applySettings']")).click();
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(240));
	String Success =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='sc-breuTD liTfKa MuiTypography-root MuiTypography-body1']"))).getText();
	
	System.out.println(Success);
	driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M12 4.7L11')]")).click();

	Thread.sleep(2000);*/
	
	driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/button[1]")).click();
	
	driver.findElement(By.xpath("//p[contains(text(),'Supply Chain Sustainability')]")).click();
	
	driver.findElement(By.xpath("//span[contains(text(),'Repository')]")).click();
	
	driver.findElement(By.xpath("//button[normalize-space()='Add Supplier']")).click();
	
	driver.findElement(By.xpath("//li[normalize-space()='Add']")).click();
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
	 
	 int count = reader.getRowCount("Add_Supplier");
	 
	 for(int i=0;i<count-1;i++) {
		
		 User_Invited=reader.getCellData("Add_Supplier", "User_Invited", i+2);
		 
		 if(User_Invited.equals("No")) {
			 
		 Company_Name = reader.getCellData("Add_Supplier", "Company_Name", i+2);	 
		 Contact_Email=reader.getCellData("Add_Supplier", "Contact_Email", i+2); 
		 Contact_name =reader.getCellData("Add_Supplier", "Contact_name", i+2);
		 Countries_of_operation  =  reader.getCellData("Add_Supplier", "Countries_of_operation", i+2);
		 Product_or_services = reader.getCellData("Add_Supplier","Product_or_services", i+2);
         Spend_volume= reader.getCellData("Add_Supplier", "Spend_volume", i+2);

         System.out.println(Countries_of_operation);
		 System.out.println(Product_or_services);
		 double C = Double.parseDouble(Countries_of_operation);
		 double P =Double.parseDouble(Product_or_services);
		 int Company1 = (int) C;
		 int Product1 = (int) P;
		
	
	
	
	driver.findElement(By.xpath("//input[@id='singleLineTextID-Company name (required)']")).sendKeys(Company_Name);
	driver.findElement(By.xpath("//input[@id='singleLineTextID-Contact email']")).sendKeys(Contact_Email);
	driver.findElement(By.xpath("//input[@id='singleLineTextID-Contact name']")).sendKeys(Contact_name);
	driver.findElement(By.xpath("//input[@id='searchSelectID-Countries of operation']")).click();
	
	driver.findElement(By.xpath("//li[@id='searchSelectID-Countries of operation-option-"+0+"']")).click();
	
	driver.findElement(By.xpath("//li[@id='searchSelectID-Countries of operation-option-"+Company1+"']")).click();
	
	driver.findElement(By.xpath("//input[@id='searchSelectID-Products or services']")).click();
	
	driver.findElement(By.xpath("//li[@id='searchSelectID-Products or services-option-"+Product1+"']")).click();
	
	driver.findElement(By.xpath("//input[@id='numberInputID-Spend volume']")).sendKeys(Spend_volume);
	Thread.sleep(3000);	
	driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
	
	Thread.sleep(20000);	
	
	
	reader.setCellData("Add_Supplier","User_Invited",i+2,"Yes");
	
	
	break;
	
	
}
		 
		 
}
	 reader.setCellData("Recent_Added","Company_Name",2,Company_Name);
	 reader.setCellData("Recent_Added","Email",2,Contact_Email);

}


}

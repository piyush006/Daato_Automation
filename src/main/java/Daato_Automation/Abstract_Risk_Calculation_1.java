package Daato_Automation;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.LoginPage;

public class Abstract_Risk_Calculation_1 extends Base_Class{
	
	String Company;
	
@Test

public void abstract_risk_changes_to_default_settings() throws InterruptedException{
	
	

	ArrayList<String> Expected_Result = new ArrayList<String>();
	ArrayList<String> Actual_Result = new ArrayList<String>();
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
	 
	 int count = reader.getRowCount("abstract_logic_1");

	 for (int i=0;i<count-1;i++) {
		 
		 String Expected =reader.getCellData("abstract_logic_1","Expected_Abstract_Risk_Assement_Category_Wise",i+2);

		 Expected_Result.add(Expected);	 
	 }

	LoginPage login = new LoginPage(driver);
	login.LoginApplication("piyush.soni@47billion.com", "681993@Virat");
	
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
	
	//driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/button[1]")).click();	
	
	//driver.findElement(By.xpath("//p[contains(text(),'Supply Chain Risk')]")).click();
	//driver.findElement(By.xpath("//span[normalize-space()='Module settings']")).click();
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://daato.daato.dev/modules/supplyChain/riskSettings");
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//p[normalize-space()='Edit']")).click();
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//span[normalize-space()='Country risk level']")).click();
	driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();
	Thread.sleep(2000);	
	
	driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys("Afghanistan");
	
	driver.findElement(By.id("searchSelectID-undefined")).click();
	
	driver.findElement(By.xpath("//li[@id='searchSelectID-undefined-option-0']")).click();
	
	
	
	driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	
	Thread.sleep(000);
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://daato.daato.dev/modules/supplyChain/suppliersRepository");
	
	
	Thread.sleep(5000);	
	
	
	Company = reader.getCellData("Recent_Added","Company_Name",2);
	driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//input[@class='sc-cOFTSb sc-eKszNL GCAvE ghywui MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd']")).sendKeys(Company);
	Thread.sleep(2000);	
	
	
	driver.findElement(By.xpath("//div[contains(text(),'"+Company+"')]")).click();
	Thread.sleep(3000);	
	driver.findElement(By.xpath("(//p[contains(text(),'Abstract risk assessment')])[2]")).click();
	
	
	int Total_Risk = driver.findElements(By.xpath("//table/tbody/tr/td[4]")).size();

	System.out.println(Total_Risk);
	
	java.util.List<WebElement> Actual_Risk1 = driver.findElements(By.xpath("//table/tbody/tr/td[4]"));
	
	

	 for(WebElement Actual_Risk: Actual_Risk1)
	 { 
		 Actual_Result.add(Actual_Risk.getText());
	  
	  }
	
		
	
	 for (int I=0;I<count-1;I++) {
			
			reader.setCellData("abstract_logic_1","Actual_Abstract_Risk_Assement_Category_Wise",I+2,Actual_Result.get(I));
			
		}
	 
	 
	 
	 String Final_Abstract_score = driver.findElement(By.xpath("//div[@class='sc-kLLXSd leKTMB MuiStack-root']//div[2]//p[2]")).getText();
	 
	System.out.println(Final_Abstract_score); 
	 
	 String Expected_Abstract_score =reader.getCellData("abstract_logic_1","Final_Abstract_Risk_Assesment_After_Changes_in_Default_Settings",2);
	 
	 
	 System.out.println(Expected_Abstract_score);
	 
	
	Assert.assertEquals(Actual_Result, Expected_Result);
	
	Assert.assertEquals(Final_Abstract_score,Expected_Abstract_score);
	
	
	
}
}
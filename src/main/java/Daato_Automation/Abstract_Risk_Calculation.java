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

public class Abstract_Risk_Calculation extends Base_Class{
	
	
String Company;
	
@Test

public void to_verify_abstrac_risk() throws InterruptedException {
	
	
	ArrayList<String> Expected_Result = new ArrayList<String>();
	ArrayList<String> Expected_Product_Score = new ArrayList<String>();
	ArrayList<String> Expected_Country_Score = new ArrayList<String>();
    ArrayList<String> Actual_Result = new ArrayList<String>();
	ArrayList<String> Actual_Result1 = new ArrayList<String>();
    ArrayList<String> categories_wise_product_score = new ArrayList<String>();
	ArrayList<String> categories_wise_country_score = new ArrayList<String>();
	
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
	
	
	
	 
	 int count = reader.getRowCount("abstract_logic");
	

	 for (int i=0;i<count-1;i++) {
		 
		 String Expected =reader.getCellData("abstract_logic","Expected_Abstract_Risk_Assement_Category_Wise",i+2);

		 Expected_Result.add(Expected);	 
		 
		 
	 }
	
	 
	 
	
	
	
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

	Thread.sleep(2000);	*/
	
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://demo.daato.io/modules/supplyChain/riskSettings");
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//p[normalize-space()='Edit']")).click();
	driver.findElement(By.xpath("//span[normalize-space()='Country risk level']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='Reset to default']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	
	Thread.sleep(3000);
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://demo.daato.io/modules/supplyChain/suppliersRepository?");
	
	Thread.sleep(4000);	
	//driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/button[1]")).click();
	//driver.findElement(By.xpath("//p[contains(text(),'Supply Chain Risk')]")).click();
	
	//driver.findElement(By.xpath("//span[normalize-space()='Suppliers repository']")).click();
	
	driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();
	Thread.sleep(2000);	
	
	
	Company = reader.getCellData("Recent_Added","Company_Name",2);
	driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys(Company);
	//driver.findElement(By.xpath("//input[@class='sc-jsJBEP sc-cWSHoV ZRXBW cxNqZI MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd']")).sendKeys("Autosupplier");
	Thread.sleep(2000);	
	
	
	driver.findElement(By.xpath("//div[contains(text(),'"+Company+"')]")).click();
	//driver.findElement(By.xpath("//div[contains(text(),'Autosupplier')]")).click();
	Thread.sleep(3000);	
	driver.findElement(By.xpath("//p[contains(text(),'Risk level')]")).click();
	
	
	

	
	
	java.util.List<WebElement> Actual_Risk1 = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
	
	

	 for(WebElement Actual_Risk: Actual_Risk1)
		  {
		// if (Actual_Risk1 != null && !((CharSequence) Actual_Risk1).isEmpty()) {
			 
			 Actual_Result.add(Actual_Risk.getText());
			 
		 }
		 
		 
	 for(String Actual_Risk2: Actual_Result) 
	 {
		 if (Actual_Risk2 != null && !((CharSequence) Actual_Risk2).isEmpty()) {
			 
			 Actual_Result1.add(Actual_Risk2);
		 }
	 }
            
	  
	  
	
		
	
	 for (int I=0;I<count-1;I++) {
			
			reader.setCellData("abstract_logic","Actual_Abstract_Risk_Assement_Category_Wise",I+2,Actual_Result1.get(I));
			
		}
	 
	 Thread.sleep(2000);
	 
	 driver.findElement(By.xpath("//p[contains(text(),'Abstract assessment')]")).click();
	 
	
	 
	 
	 String Final_Abstract_score = driver.findElement(By.xpath("//div[@class='sc-ezreuY fFryNQ MuiStack-root']//div[1]//p[2]")).getText();
	 
	System.out.println(Final_Abstract_score); 
	 
	 String Expected_Abstract_score =reader.getCellData("abstract_logic","Final_Abstract_Risk_Assesment",2);
	 
	 
	 java.util.List<WebElement> product_risk = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
	 java.util.List<WebElement> country_risk = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
	 

	 for(WebElement product_risk1: product_risk)
		 
		  {
		
		 categories_wise_product_score.add(product_risk1.getText());
			 
		 }
	 
	 for (int I=0;I<count-1;I++) {
			
			reader.setCellData("abstract_logic","Actual_Product_Score_Category_wise",I+2,categories_wise_product_score.get(I));
			
		}
	 
	 
	 for(WebElement country_risk1: country_risk)
		 
	  {
	
		categories_wise_country_score.add(country_risk1.getText());
		 
	 }
	 
	 for (int I=0;I<count-1;I++) {
			
			reader.setCellData("abstract_logic","Actual_Country_Score_Category_wise",I+2,categories_wise_country_score.get(I));
			
		}
	 
	 
	 
	 
	 
	Assert.assertEquals(Actual_Result1, Expected_Result);
	Assert.assertEquals(Final_Abstract_score,Expected_Abstract_score);
	
	
	
}
	
}

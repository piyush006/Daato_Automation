package Daato_Automation;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Risk_Priority_Self_Assessment extends Base_Class{
	
	
String Company;
	
	
@Test

public void check_risk_priority_Self_assessment() throws InterruptedException {
	
ArrayList<String> Expected_Result = new ArrayList<String>();
ArrayList<String> Actual_Result = new ArrayList<String>();

Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");



 
 int count = reader.getRowCount("self_assessment_saq");
 
for (int i=0;i<count-1;i++) {
	 
	 String Expected =reader.getCellData("self_assessment_saq","Expected_Status_After_SAQ",i+2);

	 Expected_Result.add(Expected);	 
	 
	 
 }

driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
driver.findElement(By.id("password")).sendKeys("681993@Virat");
Thread.sleep(2000);
driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
Thread.sleep(2000);	
	
	
//driver.switchTo().newWindow(WindowType.TAB);
//driver.get("https://daato.daato.dev/profile");

//driver.findElement(By.id("inputId-languages")).click();
//driver.findElement(By.xpath("//li[normalize-space()='English']")).click();
//driver.findElement(By.xpath("//button[@id='buttonID-applySettings']")).click();

//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(240));
//String Success =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='sc-breuTD liTfKa MuiTypography-root MuiTypography-body1']"))).getText();

//System.out.println(Success);

//driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M12 4.7L11')]")).click();

Thread.sleep(2000);	

driver.switchTo().newWindow(WindowType.TAB);
//driver.get("https://daato.daato.dev/modules/supplyChain/suppliersRepository");
driver.get("https://demo.daato.io/modules/supplyChain/suppliersRepository?");


Company = reader.getCellData("Recent_Added","Company_Name",2);

driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();

driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys(Company);


driver.findElement(By.xpath("//div[contains(text(),'"+Company+"')]")).click();

Thread.sleep(2000);

driver.findElement(By.xpath("(//p[contains(text(),'Self-assessment')])[1]")).click();




	
java.util.List<WebElement> status = driver.findElements(By.xpath("//div[@class='sc-jlZhew hmANKZ MuiBox-root']/p[2]"));

for(WebElement status1: status)
	 
{

	Actual_Result.add(status1.getText());
	 
}
	
	
	
	
for (int j=0;j<13;j++) {
	
	
	reader.setCellData("self_assessment_saq","Actual_Status_After_SAQ",j+2,Actual_Result.get(j));	
	
	
}



//(//p[@class='sc-breuTD kQmjQe MuiTypography-root MuiTypography-body1'])[13]

}	
	
	
}
	
	
	
	
	
	
	

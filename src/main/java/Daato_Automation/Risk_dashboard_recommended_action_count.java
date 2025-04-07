package Daato_Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import Excel.utility.Xls_Reader;

public class Risk_dashboard_recommended_action_count extends Base_Class{
	
	
	
	
@Test
public void risk_dashboard_recommended_action_count() throws InterruptedException, IOException {
	
	String value2;
	
	
	
	
	driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	Thread.sleep(2000);
	
	
	
driver.get("https://daato.daato.dev/modules/supplyChain");	


Thread.sleep(3000);

	
	
Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");

for(int i=0;i<30;i++)
{
reader.removeColumn("Recommended_actions", i);
}

ArrayList<String> Actual_Result = new ArrayList<String>();
ArrayList<String> Actual_Result1 = new ArrayList<String>();


List<WebElement> value = driver.findElements(By.xpath("//div[@class='sc-jlZhew MuiDataGrid-cellContent MuiBox-root']"));





for(WebElement Actual_value: value)
{
// if (Actual_Risk1 != null && !((CharSequence) Actual_Risk1).isEmpty()) {
	 
	 Actual_Result.add(Actual_value.getText());
	 
}




for (int i = 1; i < Actual_Result.size(); i += 2) {
  
	reader.addColumn("Recommended_actions",Actual_Result.get(i));
	
}

int count1 = reader.getColumnCount("Recommended_actions");

System.out.println(count1);



for (int i=0; i<=count1; i++) {
	
	
	value2 = reader.getCellData("Recommended_actions", i, 1);
	
	
	Actual_Result1.add(value2);
	
	
	

}

int j=0;

for (int i = 0; i < Actual_Result.size(); i += 2) {
	
	
	
	  
reader.setCellData("Recommended_actions",Actual_Result1.get(j),2,Actual_Result.get(i));	

j++;

System.out.println(j);
	
}	
	

}
}




	
	
	
	
	
	
	
	
	
	
	
	
	



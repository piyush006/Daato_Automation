package Daato_Automation;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Self_Assessement_VH extends Base_Class {

	String Email;
	String User_Registered;

	String URL;
	String URL1;

	@Test

	public void Submit_empty_saq() throws InterruptedException {

		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");

		int count = reader.getRowCount("Add_Supplier");

		for (int i = 0; i < count - 1; i++) {

			User_Registered = reader.getCellData("Add_Supplier", "User_Registered", i + 2);

			if (User_Registered.equals("No")) {

				Email = reader.getCellData("Add_Supplier", "Contact_Email", i + 2);

				driver.switchTo().newWindow(WindowType.TAB);
				driver.get("https://yopmail.com/en/");
				driver.findElement(By.xpath("//input[@id='login']")).sendKeys(Email);
				driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
				Thread.sleep(4000);
				driver.switchTo().frame(driver.findElement(By.id("ifmail")));
				driver.findElement(By.xpath("//a[contains(text(),'View the request')]")).click();

				ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

				System.out.println(wid.size());
				// switch to active tab
				driver.switchTo().window(wid.get(2));

				// driver.findElement(By.id("username")).sendKeys(Email);
				driver.findElement(By.id("password")).sendKeys("681993@Virat");
				driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
				// driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
				Thread.sleep(3000);
				reader.setCellData("Add_Supplier", "User_Registered", i + 2, "Yes");
				Thread.sleep(2000);

				break;

			}

		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
		
		Thread.sleep(2000);	

		driver.findElement(By.xpath("//button[contains(text(),'Requests')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'piyush.soni@47billion.com')]")).click();
		Thread.sleep(2000);

		URL = driver.getCurrentUrl();
		reader.setCellData("Recent_Added", "Currenturl", 2, URL);
		URL1 = reader.getCellData("Recent_Added", "Currenturl", 2);
		Thread.sleep(2000);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("multilineTextID-Comment")).sendKeys("piyush");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[2]")).click();
		Thread.sleep(8000);
		
		
		

	}
}

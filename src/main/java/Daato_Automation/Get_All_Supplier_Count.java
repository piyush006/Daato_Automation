package Daato_Automation;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Get_All_Supplier_Count extends Base_Class {

	int totalRowCount = 0;

	int rows_Per_page = 0;

	int page_count = 0;

	@Test(priority=1)

	public void get_supplier_count_risk_dashboard() throws IOException, InterruptedException {

		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");

		login();

		driver.get("https://daato.daato.dev/modules/supplyChain");
		
		
		

		Thread.sleep(6000);
		String get_supplier_Count = driver.findElement(By.xpath("//p[@class='sc-fqkvVR hbOdCl MuiTypography-root MuiTypography-body1']")).getText();
   
		String[] get_supplier_Count1=get_supplier_Count.split(" ");
		
		String get_supplier_Coun2=get_supplier_Count1[0];
		
		System.out.println(get_supplier_Coun2);
		reader.setCellData("filter_result", "Supplier_Count_Dashboard", 2, get_supplier_Coun2);
		
	

	}

	@Test(priority=2)
	public void get_all_supplier_count() throws InterruptedException, IOException {

		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");


		login();
		
		
		

		click_on_next_page();

		String Supplier_count = Integer.toString(totalRowCount / 2);

		reader.setCellData("filter_result", "Supplier_Count_Repo", 2, Supplier_count);
		
		totalRowCount = 0;

		rows_Per_page = 0;

		page_count = 0;
		
		

	}

	@Test(priority=3)
	public void get_required_count() throws IOException, InterruptedException {

		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");

		login();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='sc-jlZhew jAwoKi MuiBox-root']//button[2]//*[name()='svg']"))
				.click();

		driver.findElement(By.xpath("//input[@id='searchSelectID-Self-assessment']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@id='searchSelectID-Self-assessment-option-0']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();

		Thread.sleep(2000);

		click_on_next_page();

		String SAQ_Required_Count = Integer.toString(totalRowCount / 2);

		reader.setCellData("filter_result", "SAQ_Required_Count", 2, SAQ_Required_Count);

		Thread.sleep(2000);
		
		totalRowCount = 0;

		rows_Per_page = 0;

		page_count = 0;
	}

	@Test(priority=4)

	public void get_saq_requested_count() throws InterruptedException, IOException {

		// Requested........................

		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");

		login();

		driver.findElement(By.xpath("//div[@class='sc-jlZhew jAwoKi MuiBox-root']//button[2]//*[name()='svg']"))
				.click();

		driver.findElement(By.xpath("//input[@id='searchSelectID-Self-assessment']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[@id='searchSelectID-Self-assessment-option-1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
		Thread.sleep(2000);

		click_on_next_page();

		String SAQ_Requested_Count = Integer.toString(totalRowCount / 2);

		reader.setCellData("filter_result", "SAQ_Requested_Count", 2, SAQ_Requested_Count);

		totalRowCount = 0;

		rows_Per_page = 0;

		page_count = 0;

	}

	@Test(priority=5)
	public void get_review_count() throws InterruptedException, IOException {

		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");

		login();

		driver.findElement(By.xpath("//div[@class='sc-jlZhew jAwoKi MuiBox-root']//button[2]//*[name()='svg']"))
				.click();

		driver.findElement(By.xpath("//input[@id='searchSelectID-Self-assessment']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[@id='searchSelectID-Self-assessment-option-2']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();

		Thread.sleep(2000);

		click_on_next_page();

		String SAQ_Review_Count = Integer.toString(totalRowCount / 2);

		reader.setCellData("filter_result", "SAQ_Review_Count", 2, SAQ_Review_Count);

		totalRowCount = 0;

		rows_Per_page = 0;

		page_count = 0;

	}

	@Test(priority=6)
	public void get_complete_count() throws IOException, InterruptedException {

		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");

		login();

		driver.findElement(By.xpath("//div[@class='sc-jlZhew jAwoKi MuiBox-root']//button[2]//*[name()='svg']"))
				.click();

		driver.findElement(By.xpath("//input[@id='searchSelectID-Self-assessment']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[@id='searchSelectID-Self-assessment-option-3']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();

		Thread.sleep(2000);

		click_on_next_page();

		String SAQ_Completed_Count = Integer.toString(totalRowCount / 2);

		reader.setCellData("filter_result", "SAQ_Completed_Count", 2, SAQ_Completed_Count);

		totalRowCount = 0;

		rows_Per_page = 0;

		page_count = 0;

	}

	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", element);
		System.out.println("Scroll into view with smooth behavior");

	}

	public void click_on_next_page() throws InterruptedException, IOException {

		boolean nextPageExists = true;

		WebElement element1 = driver.findElement(By.xpath("//button[@title='Go to next page']"));
		scrollIntoView(element1);
		Thread.sleep(2000);

		while (nextPageExists) {

			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			rows_Per_page = rows.size();

			page_count++;

			System.out.println("Page =:" + page_count + "rows count:=" + rows_Per_page);
			totalRowCount += rows.size();

			WebElement nextPageButton = driver.findElement(By.xpath("//button[@title='Go to next page']"));

			if (nextPageButton.getAttribute("disabled") != null) {
				System.out.println("The button is disabled.");
				nextPageExists = false;

			} else {
				nextPageExists = true;

				nextPageButton.click();
				Thread.sleep(3000);
			}

		}

		WebElement element2 = driver
				.findElement(By.xpath("//div[@class='sc-jlZhew jAwoKi MuiBox-root']//button[2]//*[name()='svg']"));
		scrollIntoView(element2);
		Thread.sleep(1000);

	}

	public void login() throws IOException, InterruptedException {

		Propertiesefile get = new Propertiesefile();
		driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
		driver.findElement(By.id("password")).sendKeys("681993@Virat");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
		Thread.sleep(2000);

		driver.get(get.getURLSupplierrepo());

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
		
		Thread.sleep(2000);

	}

}

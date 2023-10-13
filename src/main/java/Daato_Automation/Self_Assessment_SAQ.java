package Daato_Automation;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Self_Assessment_SAQ extends Base_Class {

	String Company;

	@Test(priority = 1)
	public void self_assessment_before_saq() throws InterruptedException {

		ArrayList<String> Expected_Result = new ArrayList<String>();
		ArrayList<String> Actual_Result = new ArrayList<String>();

		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");

		int count = reader.getRowCount("self_assessment_saq");

		for (int i = 0; i < count - 1; i++) {

			String Expected = reader.getCellData("self_assessment_saq", "Expected_Status", i + 2);

			Expected_Result.add(Expected);

		}

		driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
		driver.findElement(By.id("password")).sendKeys("681993@Virat");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
		Thread.sleep(2000);

		// driver.switchTo().newWindow(WindowType.TAB);
		// driver.get("https://daato.daato.dev/profile");

		// driver.findElement(By.id("inputId-languages")).click();
		// driver.findElement(By.xpath("//li[normalize-space()='English']")).click();
		// driver.findElement(By.xpath("//button[@id='buttonID-applySettings']")).click();

		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(240));
		// String Success =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='sc-breuTD
		// liTfKa MuiTypography-root MuiTypography-body1']"))).getText();

		// System.out.println(Success);

		// driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M12
		// 4.7L11')]")).click();

		Thread.sleep(2000);

		driver.switchTo().newWindow(WindowType.TAB);
		// driver.get("https://daato.daato.dev/modules/supplyChain/suppliersRepository");
		driver.get("https://demo.daato.io/modules/supplyChain/suppliersRepository?");

		Company = reader.getCellData("Recent_Added", "Company_Name", 2);

		driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys(Company);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'" + Company + "')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//p[contains(text(),'Self-assessment')])[1]")).click();

		for (int i = 0; i < 14; i++) {

			String status = driver
					.findElement(By.xpath(
							"(//p[@class='sc-fqkvVR cTnBHY MuiTypography-root MuiTypography-body1'])['" + i + "']"))
					.getText();

			Actual_Result.add(status);

		}

		for (int j = 0; j < count - 1; j++) {

			reader.setCellData("self_assessment_saq", "Actual_Status", j + 2, Actual_Result.get(j));

		}

		// (//p[@class='sc-breuTD kQmjQe MuiTypography-root MuiTypography-body1'])[13]

	}

	@Test(priority = 2)

	public void sendSAQ() throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys("piyush.soni@47billion.com");
		driver.findElement(By.id("password")).sendKeys("681993@Virat");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
		Thread.sleep(2000);

		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");

		driver.switchTo().newWindow(WindowType.TAB);
		// driver.get("https://daato.daato.dev/modules/supplyChain/suppliersRepository");
		driver.get("https://demo.daato.io/modules/supplyChain/suppliersRepository?");

		Company = reader.getCellData("Recent_Added", "Company_Name", 2);

		driver.findElement(By.xpath("//button[@title='Search']//*[name()='svg']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Search…']")).sendKeys(Company);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'" + Company + "')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[normalize-space()='Actions']")).click();

		driver.findElement(By.xpath("//li[normalize-space()='Request Self-assessment']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Send']")).click();

		Thread.sleep(3000);

	}

}

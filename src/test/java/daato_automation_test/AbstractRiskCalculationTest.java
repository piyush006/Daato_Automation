/* Hello, Welcome to Divya Coding */
package daato_automation_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.AbstractRiskCalculationPage;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;

/**
 * @author 47Billion
 *
 */
public class AbstractRiskCalculationTest extends BaseTest{
	String Company;

	@Test(priority=2)

	public void to_verify_abstrac_risk() throws InterruptedException, IOException {
		/*
		 * PropertyFileUtils prop = new PropertyFileUtils(); LoginPage login = new
		 * LoginPage(driver); login.LoginApplication(prop.getuser(),
		 * prop.getpassword());
		 */
		ArrayList<String> Expected_Result = new ArrayList<String>();
		ArrayList<String> Actual_Result = new ArrayList<String>();
		ArrayList<String> Actual_Result1 = new ArrayList<String>();
		ArrayList<String> categories_wise_product_score = new ArrayList<String>();
		ArrayList<String> categories_wise_country_score = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
	    Workbook workbook = new XSSFWorkbook(fis);

	    // Step 2: Pass both path and workbook to Xls_Reader
	    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);

		int count = reader.getRowCount("abstract_logic");

		for (int i = 0; i < count - 1; i++) {

			String Expected = reader.getCellData("abstract_logic", "Expected_Abstract_Risk_Assement_Category_Wise",
					i + 2);

			Expected_Result.add(Expected);

		}

		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());

		AbstractRiskCalculationPage abstractRiskCalculation = new AbstractRiskCalculationPage(driver);
		abstractRiskCalculation.riskSettings();

		abstractRiskCalculation.searchCompany();
		Company = reader.getCellData("Recent_Added", "Company_Name", 2);
		System.out.println("piyush"+Company);

		abstractRiskCalculation.riskLevel(Company);
		
		System.out.println("I am out to check readings");

		java.util.List<WebElement> Actual_Risk1 = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));

		for (WebElement Actual_Risk : Actual_Risk1) {

			Actual_Result.add(Actual_Risk.getText());

		}

		for (String Actual_Risk2 : Actual_Result) {
			if (Actual_Risk2 != null && !((CharSequence) Actual_Risk2).isEmpty()) {

				Actual_Result1.add(Actual_Risk2);
			}
		}

		for (int I = 0; I < count - 1; I++) {

			reader.setCellData("abstract_logic", "Actual_Abstract_Risk_Assement_Category_Wise", I + 2,
					Actual_Result1.get(I));

		}

		Thread.sleep(2000);

		driver.findElement(By.xpath("//p[contains(text(),'Abstract assessment')]")).click();

		String Final_Abstract_score = driver
				.findElement(By.xpath("//div[@class='sc-izQBue bPAzNg MuiStack-root']//div[1]//p[2]")).getText();

		System.out.println(Final_Abstract_score);

		String Expected_Abstract_score = reader.getCellData("abstract_logic", "Final_Abstract_Risk_Assesment", 2);

		java.util.List<WebElement> product_risk = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
		java.util.List<WebElement> country_risk = driver.findElements(By.xpath("//table/tbody/tr/td[4]"));

		for (WebElement product_risk1 : product_risk)

		{

			categories_wise_product_score.add(product_risk1.getText());

		}

		for (int I = 0; I < count - 1; I++) {

			reader.setCellData("abstract_logic", "Actual_Product_Score_Category_wise", I + 2,
					categories_wise_product_score.get(I));

		}

		for (WebElement country_risk1 : country_risk)

		{

			categories_wise_country_score.add(country_risk1.getText());

		}

		for (int I = 0; I < count - 1; I++) {

			reader.setCellData("abstract_logic", "Actual_Country_Score_Category_wise", I + 2,
					categories_wise_country_score.get(I));

		}

		Assert.assertEquals(Actual_Result1, Expected_Result);
		Assert.assertEquals(Final_Abstract_score, Expected_Abstract_score);

	}

}

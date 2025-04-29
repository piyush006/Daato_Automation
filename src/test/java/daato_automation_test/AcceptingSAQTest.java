/* Hello, Welcome to Divya Coding */
package daato_automation_test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.AcceptingSAQPage;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;

/**
 * @author 47Billion
 *
 */
public class AcceptingSAQTest extends BaseTest {

	String Company_Name;

	String Email;

	@Test(priority = 1)

	public void accepting_SAQ() throws InterruptedException, IOException {

		FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
	    Workbook workbook = new XSSFWorkbook(fis);

	    // Step 2: Pass both path and workbook to Xls_Reader
	    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);

		Company_Name = reader.getCellData("Recent_Added", "Company_Name", 2);
		Email = reader.getCellData("Recent_Added", "Email", 2);

		threadSleep(TestConstants.WAIT_TWO);

		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());

		openNewTabAndNavigate(TestConstants.TEST_SUPPLIER_REPO_URL);

		AcceptingSAQPage acceptingSAQPage = new AcceptingSAQPage(driver);
		acceptingSAQPage.acceptingSAQ(Company_Name);
		
	}
	
	@Test(priority = 2)
	public void accept_Btn() throws InterruptedException, IOException
	{
		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
		
		FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
	    Workbook workbook = new XSSFWorkbook(fis);

	    // Step 2: Pass both path and workbook to Xls_Reader
	    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);
		String URL1 = reader.getCellData("Recent_Added", "Currenturl", 2);
		String Company_Name = reader.getCellData("Recent_Added", "Company_Name", 2);
		System.out.println(Company_Name);
		System.out.println(URL1);
		driver.get(URL1);
		threadSleep(PageConstants.WAIT_TEN);
		WebElement acceptbtn = driver.findElement(By.xpath("//button[contains(text(),'Accept the answer')]"));
		acceptbtn.click();
		
	}

}

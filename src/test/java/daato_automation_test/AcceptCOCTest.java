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
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.AcceptCOCPage;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;

/**
 * @author 47Billion
 *
 */
public class AcceptCOCTest extends BaseTest {

	String Email;

	@Test(priority = 1)

	public void accept_CoC() throws InterruptedException, IOException {

		FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
	    Workbook workbook = new XSSFWorkbook(fis);

	    // Step 2: Pass both path and workbook to Xls_Reader
	    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);
		
		Email = reader.getCellData("Recent_Added", "Email", 2);
		System.out.println(Email);
		AcceptCOCPage acceptCOCPage = new AcceptCOCPage(driver);
		acceptCOCPage.yopmailLogin(Email);

		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(wid.size());
		driver.switchTo().window(wid.get(2));

		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
		acceptCOCPage.acceptCocRequest();
		
		

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
		String URL1 = reader.getCellData("Recent_Added", "CocCurrentUrl", 2);
		String Company_Name = reader.getCellData("Recent_Added", "Company_Name", 2);
		System.out.println(Company_Name);
		System.out.println(URL1);
		driver.get(URL1);
		threadSleep(PageConstants.WAIT_TEN);
		// Using XPath to locate by button text
		WebElement acceptbtn = driver.findElement(By.xpath("//button[text()='Accept the answer']"));
		acceptbtn.click();
		printMessage("Accept btn clicked");
	}
	

}

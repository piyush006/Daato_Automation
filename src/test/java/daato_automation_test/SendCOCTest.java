package daato_automation_test;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.LoginPage;
import daato_automation_page.SendCOCPage;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;

/* Hello, Welcome to Divya Coding */

/**
 * @author 47Billion
 *
 */
public class SendCOCTest extends BaseTest {

	String Company;

	@Test

	public void send_coc() throws InterruptedException, IOException {

		FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
	    Workbook workbook = new XSSFWorkbook(fis);

	    // Step 2: Pass both path and workbook to Xls_Reader
	    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);

		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());

		openNewTabAndNavigate(TestConstants.TEST_SUPPLIER_REPO_URL);

		Company = reader.getCellData("Recent_Added", "Company_Name", 2);

		SendCOCPage sendCOCPage = new SendCOCPage(driver);
		sendCOCPage.sendCodeOfConduct(Company);

	}

}

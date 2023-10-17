/* Hello, Welcome to Divya Coding */
package daato_automation_test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.AcceptingSAQPage;
import daato_automation_page.LoginPage;
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

		Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH);

		Company_Name = reader.getCellData("Recent_Added", "Company_Name", 2);
		Email = reader.getCellData("Recent_Added", "Email", 2);

		threadSleep(TestConstants.WAIT_TWO);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(prop.getuser(), prop.getpassword());

		openNewTabAndNavigate(TestConstants.TEST_SUPPLIER_REPO_URL);

		AcceptingSAQPage acceptingSAQPage = new AcceptingSAQPage(driver);
		acceptingSAQPage.acceptingSAQ(Company_Name);

	}

}

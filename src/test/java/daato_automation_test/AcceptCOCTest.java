/* Hello, Welcome to Divya Coding */
package daato_automation_test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.AcceptCOCPage;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;

/**
 * @author 47Billion
 *
 */
public class AcceptCOCTest extends BaseTest {

	String Email;

	@Test

	public void accept_CoC() throws InterruptedException, IOException {

		Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH);
		
		Email = reader.getCellData("Recent_Added", "Email", 2);

		AcceptCOCPage acceptCOCPage = new AcceptCOCPage(driver);
		acceptCOCPage.yopmailLogin(Email);

		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(wid.size());
		driver.switchTo().window(wid.get(2));

		PropertyFileUtils prop = new PropertyFileUtils();
		acceptCOCPage.yopmailCustomerLogin(Email, prop.getpassword());

		acceptCOCPage.acceptCocRequest();

	}

}

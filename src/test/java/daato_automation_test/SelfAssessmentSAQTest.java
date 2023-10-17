/* Hello, Welcome to Divya Coding */
package daato_automation_test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.LoginPage;
import daato_automation_page.SelfAssessmentSAQPage;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;

/**
 * @author 47Billion
 *
 */
public class SelfAssessmentSAQTest extends BaseTest {

	String Company;

	@Test(priority = 1)
	public void self_assessment_before_saq() throws InterruptedException, IOException {

		ArrayList<String> Expected_Result = new ArrayList<String>();
		ArrayList<String> Actual_Result = new ArrayList<String>();

		Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH);

		int count = reader.getRowCount("self_assessment_saq");

		for (int i = 0; i < count - 1; i++) {

			String Expected = reader.getCellData("self_assessment_saq", "Expected_Status", i + 2);

			Expected_Result.add(Expected);

		}

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(prop.getuser(), prop.getpassword());

		SelfAssessmentSAQPage selfAssessmentSAQPage = new SelfAssessmentSAQPage(driver);
		selfAssessmentSAQPage.openNewTabAndNavigate(TestConstants.TEST_SUPPLIER_REPO_URL);

		Company = reader.getCellData("Recent_Added", "Company_Name", 2);

		selfAssessmentSAQPage.selfAssessment(Company);

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

	}

	@Test(priority = 2)

	public void sendSAQ() throws InterruptedException, IOException {

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(prop.getuser(), prop.getpassword());

		Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH);

		SelfAssessmentSAQPage selfAssessmentSAQPage = new SelfAssessmentSAQPage(driver);
		selfAssessmentSAQPage.openNewTabAndNavigate(TestConstants.TEST_SUPPLIER_REPO_URL);

		Company = reader.getCellData("Recent_Added", "Company_Name", 2);

		selfAssessmentSAQPage.sendSAQ(Company);

	}

}

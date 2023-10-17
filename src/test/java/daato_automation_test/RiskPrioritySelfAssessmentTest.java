/* Hello, Welcome to Divya Coding */
package daato_automation_test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.LoginPage;
import daato_automation_page.RiskPrioritySelfAssessmentPage;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;

/**
 * @author 47Billion
 *
 */
public class RiskPrioritySelfAssessmentTest extends BaseTest {

	String Company;

	@Test

	public void check_risk_priority_Self_assessment() throws InterruptedException, IOException {

		ArrayList<String> Expected_Result = new ArrayList<String>();
		ArrayList<String> Actual_Result = new ArrayList<String>();

		Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH);

		int count = reader.getRowCount("self_assessment_saq");

		for (int i = 0; i < count - 1; i++) {

			String Expected = reader.getCellData("self_assessment_saq", "Expected_Status_After_SAQ", i + 2);

			Expected_Result.add(Expected);

		}

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(prop.getuser(), prop.getpassword());

		openNewTabAndNavigate(TestConstants.TEST_SUPPLIER_REPO_URL);

		Company = reader.getCellData("Recent_Added", "Company_Name", 2);

		RiskPrioritySelfAssessmentPage riskPrioritySelfAssessmentPage = new RiskPrioritySelfAssessmentPage(driver);
		riskPrioritySelfAssessmentPage.selfAssessment(Company);

		java.util.List<WebElement> status = driver
				.findElements(By.xpath("//div[@class='sc-jlZhew hmANKZ MuiBox-root']/p[2]"));

		for (WebElement status1 : status)

		{

			Actual_Result.add(status1.getText());

		}

		for (int j = 0; j < 13; j++) {

			reader.setCellData("self_assessment_saq", "Actual_Status_After_SAQ", j + 2, Actual_Result.get(j));

		}

	}

}

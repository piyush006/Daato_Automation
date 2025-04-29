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

		FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
	    Workbook workbook = new XSSFWorkbook(fis);

	    // Step 2: Pass both path and workbook to Xls_Reader
	    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);

		int count = reader.getRowCount("self_assessment_saq");
		for (int i = 0; i < count - 1; i++) {

			String Expected = reader.getCellData("self_assessment_saq", "Expected_Status_After_SAQ", i + 2);

			Expected_Result.add(Expected);

		}

		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());

		openNewTabAndNavigate(TestConstants.TEST_SUPPLIER_REPO_URL);

		Company = reader.getCellData("Recent_Added", "Company_Name", 2);

		RiskPrioritySelfAssessmentPage riskPrioritySelfAssessmentPage = new RiskPrioritySelfAssessmentPage(driver);
		riskPrioritySelfAssessmentPage.selfAssessment(Company);

		//java.util.List<WebElement> status = driver
				//.findElements(By.xpath("//div[@class='sc-jlZhew hmANKZ MuiBox-root']/p[2]"));
				
				java.util.List<WebElement> status = driver
						.findElements(By.xpath("//div[@class='sc-dAlyuH dnwsPK MuiBox-root']/p[2]"));
			

		/*for (WebElement status1 : status)

		{
			Actual_Result.add(status1.getText());

		}

		for (int j = 0; j < 12; j++) {

			reader.setCellData("self_assessment_saq", "Actual_Status_After_SAQ", j + 2, Actual_Result.get(j));

		}

	}

}
*/
		
		  // Debugging: Check the number of elements in 'status'
        System.out.println("Number of status elements: " + status.size());

        // Iterate over the status elements and add their text to the Actual_Result list
        for (WebElement status1 : status) {
        	
            Actual_Result.add(status1.getText());
        }

        // Debugging: Check the size of Actual_Result after population
        System.out.println("Actual_Result Size: " + Actual_Result.size());

        // Use Actual_Result.size() instead of hardcoding 12
        for (int j = 0; j <Actual_Result.size(); j++) {
            System.out.println("Setting cell data for index: " + j);
            reader.setCellData("self_assessment_saq", "Actual_Status_After_SAQ", j + 2, Actual_Result.get(j));
        }
        
        Assert.assertEquals(Actual_Result, Expected_Result);
    }
}
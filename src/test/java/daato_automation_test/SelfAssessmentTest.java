/* Hello, Welcome to Divya Coding */
package daato_automation_test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.LoginPage;
import daato_automation_page.SelfAssessmentPage;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;

/**
 * @author 47Billion
 *
 */
public class SelfAssessmentTest extends BaseTest {

	String Email;
	String User_Registered;

	String revenue = "100";
	String location = "Indore";

	String URL;
	String URL1;

	@Test(priority = 1)

	public void General_information() throws InterruptedException, IOException {

		Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH);

		int count = reader.getRowCount("Add_Supplier");

		for (int i = 0; i < count - 1; i++) {

			User_Registered = reader.getCellData("Add_Supplier", "User_Registered", i + 2);

			if (User_Registered.equals("No")) {

				Email = reader.getCellData("Add_Supplier", "Contact_Email", i + 2);

				SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
				selfAssessmentPage.yopmailLogin(Email);

				ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

				System.out.println(wid.size());
				driver.switchTo().window(wid.get(2));

				PropertyFileUtils prop = new PropertyFileUtils();
				LoginPage login = new LoginPage(driver);
				login.YopmailLoginApplication(prop.getpassword());
				reader.setCellData("Add_Supplier", "User_Registered", i + 2, "Yes");
				threadSleep(TestConstants.WAIT_THREE);
				break;

			}

		}

		driver.findElement(By.xpath("//button[contains(text(),'Requests')]")).click();
		threadSleep(TestConstants.WAIT_FOUR);
		driver.findElement(By.xpath("//div[contains(text(),'piyush.soni@47billion.com')]")).click();
		threadSleep(TestConstants.WAIT_TWO);

		URL = driver.getCurrentUrl();
		reader.setCellData("Recent_Added", "Currenturl", 2, URL);
		URL1 = reader.getCellData("Recent_Added", "Currenturl", 2);

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.generalInformation(revenue, location);

	}

	@Test(priority = 2)

	public void add_governance_and() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addGovernance();

	}

	@Test(priority = 3)
	public void Add_Buisness_Ethics() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addBuisnessEthics();
	}

	@Test(priority = 4)
	public void Add_responsible_supply_chain_management() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addResponsibleSupplyChainManagement();

	}

	@Test(priority = 5)

	public void add_policies_and_certifications() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addPoliciesAndCertifications();
	}

	@Test(priority = 6)

	public void add_policy_part_second() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addPoliciesPartSecond();
	}

	@Test(priority = 7)
	public void add_chld_frc_hs_fa_ee_fw_lr() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addChldFrcHsFaEeFwLr();

	}

	@Test(priority = 8)
	public void add_cs_sw() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addCsSw();

	}

	@Test(priority = 9)
	public void add_environmental_performance() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addEnvironmentalPerformance();

	}

	@Test(priority = 10)

	public void submit_SAQ() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.submitSAQ();

	}
}

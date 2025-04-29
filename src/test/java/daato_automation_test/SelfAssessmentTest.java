/* Hello, Welcome to Divya Coding */
package daato_automation_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import daato_automation_pagecomponent.PageConstants;
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
	String Customer_Email;
	String NewPassword;
	
	String revenue = "100";
	String location = "Indore";

	String URL;
	String URL1;

	@Test(priority = 4)

	public void General_information() throws InterruptedException, IOException {

		FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
	    Workbook workbook = new XSSFWorkbook(fis);

	    // Step 2: Pass both path and workbook to Xls_Reader
	    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);

		int count = reader.getRowCount("Add_Supplier");

		for (int i = 0; i < count - 1; i++) {

			User_Registered = reader.getCellData("Add_Supplier", "User_Registered", i + 2);
			
			
			if (User_Registered.equals("No")) {

				Email = reader.getCellData("Add_Supplier", "Contact_Email", i + 2);
				Customer_Email = reader.getCellData("Add_Supplier", "Contact_Email", i + 2);
			
				System.out.println("Piyush" + Customer_Email);

				SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
				selfAssessmentPage.yopmailLogin(Email);
				ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

				System.out.println(wid.size());
				driver.switchTo().window(wid.get(2));
				WebElement button1 = driver.findElement(By.cssSelector("button p.MuiTypography-body1"));
				button1.click();
			//	PropertyFileUtils prop = new PropertyFileUtils();
			//	LoginPage login = new LoginPage(driver);
				
				threadSleep(PageConstants.WAIT_TWO);
				threadSleep(PageConstants.WAIT_TWO);
				
				WebElement inputField = driver.findElement(By.id("username"));
				inputField.sendKeys(Customer_Email);
				WebElement button = driver.findElement(By.id("kc-login"));
				button.click();
				
				
				selfAssessmentPage.yopmailLoginforOTP(Customer_Email);
				
				NewPassword = reader.getCellData("Add_Supplier", "Password", 2).toString();
				System.out.println(NewPassword);
				if (NewPassword.endsWith(".0")) {
				    NewPassword = NewPassword.substring(0, NewPassword.length() - 2);
				}

				System.out.println("after format)" +NewPassword);
			
				WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-new']"));
				passwordField.sendKeys(NewPassword);

				WebElement passwordConfirmField = driver.findElement(By.xpath("//input[@id='password-confirm']"));
				passwordConfirmField.sendKeys(NewPassword);

				WebElement submitNewPassButton = driver.findElement(By.xpath("//input[@type='submit']"));
				submitNewPassButton.click();
				
				WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
				lastNameField.sendKeys("Test");
				
				// Using value attribute in XPath
				WebElement submitUpdateButton = driver.findElement(By.xpath("//input[@value='Submit']"));
				submitUpdateButton.click();
				
				//login.YopmailLoginApplication(prop.getpassword());
				reader.setCellData("Add_Supplier", "User_Registered", i + 2, "Yes");
				threadSleep(TestConstants.WAIT_THREE);
				System.out.println("break");
				break;

			}

		}

		/*
		 * driver.findElement(By.xpath("//button[contains(text(),'Requests')]")).click()
		 * ; threadSleep(TestConstants.WAIT_FOUR); driver.findElement(By.xpath(
		 * "//div[contains(text(),'piyush.soni@47billion.com')]")).click();
		 * threadSleep(TestConstants.WAIT_TWO);
		 */

		URL = driver.getCurrentUrl();
		reader.setCellData("Recent_Added", "Currenturl", 2, URL);
		URL1 = reader.getCellData("Recent_Added", "Currenturl", 2);
		System.out.println("url");
		System.out.println(URL);
		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.generalInformation(revenue, location);
		System.out.println("general1");

	}

	//@Test(priority = 2)
	@Test(enabled=false)
	public void add_governance_and() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());

		selfAssessmentPage.addGovernance();
		System.out.println("addGovernance2");
	}

	//@Test(priority = 3)
/*	@Test(enabled=false)
	public void Add_Buisness_Ethics() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addBuisnessEthics();
		System.out.println("addBuisnessEthics3");
	}

	//@Test(priority = 4)
	@Test(enabled=false)
	public void Add_responsible_supply_chain_management() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addResponsibleSupplyChainManagement();
		System.out.println("addResponsibleSupplyChainManagement4");

	}

//	@Test(priority = 5)
	
	@Test(enabled=false)
	public void add_policies_and_certifications() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addPoliciesAndCertifications();
		System.out.println("addPoliciesAndCertifications5");
	}

	// @Test(priority = 6)
	@Test(enabled=false)

	public void add_policy_part_second() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addPoliciesPartSecond();
		System.out.println("addPoliciesPartSecond6");
	}
	
	//@Test(priority = 7)
	@Test(enabled=false)
	public void add_chld_frc_hs_fa_ee_fw_lr() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addChldFrcHsFaEeFwLr();
		System.out.println("addChldFrcHsFaEeFwLr7");
	}

	//@Test(priority = 8)
	@Test(enabled=false)
	public void add_cs_sw() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addCsSw();
		System.out.println("addCsSw8");
	}

	//@Test(priority = 9)
	@Test(enabled=false)
	public void add_environmental_performance() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.addEnvironmentalPerformance();
		System.out.println("addEnvironmentalPerformance9");
	}

	//@Test(priority = 10)
	@Test(enabled=false)

	public void submit_SAQ() throws InterruptedException, IOException {

		SelfAssessmentPage selfAssessmentPage = new SelfAssessmentPage(driver);
		selfAssessmentPage.SwitchToURL(URL1);

		PropertyFileUtils prop = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, prop.getpassword());

		selfAssessmentPage.submitSAQ();
		System.out.println("submitSAQ10");
	}*/
	
	

}

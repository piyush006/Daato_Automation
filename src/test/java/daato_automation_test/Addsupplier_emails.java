package daato_automation_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.AddSupplierPage;
import daato_automation_page.LoginPage;
import daato_automation_page.SelfAssessmentPage;
import daato_automation_page.SelfAssessmentSAQPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;

public class Addsupplier_emails extends BaseTest {
	


	
		String Company_Name;
		String Contact_Email;
		String Contact_name;
		String Countries_of_operation="99";
		String Product_or_services="100";
		String Spend_volume;
		String User_Invited;
		String Company;
		String Email;
		String User_Registered;
		String Customer_Email;
		String NewPassword;
		
		String revenue = "100";
		String location = "Indore";

		String URL;
		String URL1;

		@Test(priority=1)
		public void add_supplier() throws InterruptedException, IOException {
			
			
			Random random = new Random();

	        // Generate company name: regressXXX (3-digit suffix)
	        int suffix = random.nextInt(900) + 100; // ensures 100-999
	        Company_Name = "regress" + suffix;

	        // Generate contact email
	        Contact_Email = Company_Name + "@yopmail.com";

	        // Generate contact name: 8-letter random string
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	        StringBuilder nameBuilder = new StringBuilder();
	        for (int i = 0; i < 8; i++) {
	            nameBuilder.append(characters.charAt(random.nextInt(characters.length())));
	        }
	        Contact_name = nameBuilder.toString();	
			
			
	        Spend_volume = String.valueOf(10000 + random.nextInt(90000));
			
			
			
			

			
			PropertyFileUtils p = new PropertyFileUtils();
			LoginPage login = new LoginPage(driver);
			login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
			//PropertyFileUtils prop = new PropertyFileUtils();
			

			AddSupplierPage addSupplierpage = new AddSupplierPage(driver);
			addSupplierpage.navigateToSupplier();

			 FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
			    Workbook workbook = new XSSFWorkbook(fis);

			    // Step 2: Pass both path and workbook to Xls_Reader
			    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);
		/*	int count = reader.getRowCount("Add_Supplier");

			for (int i = 0; i < count - 1; i++) {
		        String User_Invited = reader.getCellData("Add_Supplier", "User_Invited", i + 2);

		        if (User_Invited.equals("No")) {
		            String Company_Name = reader.getCellData("Add_Supplier", "Company_Name", i + 2);
		            String Contact_Email = reader.getCellData("Add_Supplier", "Contact_Email", i + 2);
		            String Contact_name = reader.getCellData("Add_Supplier", "Contact_name", i + 2);
		            String Countries_of_operation = reader.getCellData("Add_Supplier", "Countries_of_operation", i + 2);
		            String Product_or_services = reader.getCellData("Add_Supplier", "Product_or_services", i + 2);
		            String Spend_volume = reader.getCellData("Add_Supplier", "Spend_volume", i + 2);

		            System.out.println(Countries_of_operation);
		            System.out.println(Product_or_services);

		            double C = Double.parseDouble(Countries_of_operation);
		            double P = Double.parseDouble(Product_or_services);
		            int Company1 = (int) C;
		            int Product1 = (int) P;

		            addSupplierpage.addSupplierForm(Company_Name, Contact_Email, Contact_name, Company1, Product1, Spend_volume);
		            reader.setCellData("Add_Supplier", "User_Invited", i + 2, "Yes");

		            // ✅ Save Recent Added Supplier
		            reader.setCellData("Recent_Added", "Company_Name", 2, Company_Name);
		            reader.setCellData("Recent_Added", "Email", 2, Contact_Email);
		            reader.setCellData("Customer_Login", "Company_Name", 2, Company_Name);
		            reader.setCellData("Customer_Login", "Email", 2, Contact_Email);

		            break;
		        }
		    }

			 reader.closeWorkbook();
			    fis.close();
			*/
			    double C = Double.parseDouble(Countries_of_operation);
	            double P = Double.parseDouble(Product_or_services);
	            int Company1 = (int) C;
	            int Product1 = (int) P;
			    
			    
			    addSupplierpage.addSupplierForm(Company_Name, Contact_Email, Contact_name, Company1, Product1, Spend_volume);
	          //  reader.setCellData("Add_Supplier", "User_Invited", i + 2, "Yes");

	            // ✅ Save Recent Added Supplier
	            reader.setCellData("Recent_Added", "Company_Name", 2, Company_Name);
	            reader.setCellData("Recent_Added", "Email", 2, Contact_Email);
	            reader.setCellData("Customer_Login", "Company_Name", 2, Company_Name);
	            reader.setCellData("Customer_Login", "Email", 2, Contact_Email);	    
	            reader.closeWorkbook();
			    fis.close();
			    
			    
			    
			    System.out.println("TEST PASSED: Supplier Added Successfully");
			     
			    
			    
			    
		}	
	
	@Test(priority=2)

	public void sendSAQ() throws InterruptedException, IOException {

		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());

		FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
	    Workbook workbook = new XSSFWorkbook(fis);

	    // Step 2: Pass both path and workbook to Xls_Reader
	    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);

		SelfAssessmentSAQPage selfAssessmentSAQPage = new SelfAssessmentSAQPage(driver);
		selfAssessmentSAQPage.openNewTabAndNavigate(TestConstants.TEST_SUPPLIER_REPO_URL);

		Company = reader.getCellData("Recent_Added", "Company_Name", 2);
        System.out.println(Company);
		selfAssessmentSAQPage.sendSAQ(Company);
		
		System.out.println("TEST PASSED: SAQ Request Sent to Supplier Successfully");

	}
	
	
	@Test(priority = 3)

	public void General_information() throws InterruptedException, IOException {

		FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
	    Workbook workbook = new XSSFWorkbook(fis);

	    // Step 2: Pass both path and workbook to Xls_Reader
	    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);

	
	  
				Email = reader.getCellData("Recent_Added", "Email", 2);
				
			
				System.out.println(Email);

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
				inputField.sendKeys(Email);
				WebElement button = driver.findElement(By.id("kc-login"));
				button.click();
				
				
				selfAssessmentPage.yopmailLoginforOTP(Email);
				
				NewPassword = reader.getCellData("Add_Supplier", "Password", 2).toString();
				System.out.println(NewPassword);
				if (NewPassword.endsWith(".0")) {
				    NewPassword = NewPassword.substring(0, NewPassword.length() - 2);
				}

				System.out.println("after format)" +NewPassword);
				threadSleep(PageConstants.WAIT_THREE);
				
			
				WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-new']"));
				passwordField.sendKeys("12");
				
				threadSleep(PageConstants.WAIT_ONE);

				WebElement passwordConfirmField = driver.findElement(By.xpath("//input[@id='password-confirm']"));
				passwordConfirmField.sendKeys("12");
				
				threadSleep(PageConstants.WAIT_ONE);

				WebElement submitNewPassButton = driver.findElement(By.xpath("//input[@type='submit']"));
				submitNewPassButton.click();
				
				threadSleep(PageConstants.WAIT_ONE);
				
				WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
				lastNameField.sendKeys("Test");
				
				threadSleep(PageConstants.WAIT_ONE);
				
				// Using value attribute in XPath
				WebElement submitUpdateButton = driver.findElement(By.xpath("//input[@value='Submit']"));
				submitUpdateButton.click();
				
				//login.YopmailLoginApplication(prop.getpassword());
				
				threadSleep(TestConstants.WAIT_THREE);
				
				

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
		
		Thread.sleep(4000);
		SelfAssessmentPage selfAssessmentPage2 = new SelfAssessmentPage(driver);
		selfAssessmentPage2.generalInformation(revenue, location);
		System.out.println("general1");
		
		System.out.println("TEST PASSED: Supplier Received SAQ and Registered Successfully");

	}

	
	
	

	}

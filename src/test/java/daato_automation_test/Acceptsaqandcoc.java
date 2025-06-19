package daato_automation_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.ApiHelper;
import utils.Requestids;

public class Acceptsaqandcoc extends BaseTest{
	
	
	String Email;
	String title;
	
	public String adminToken;
		
	@Test(priority=7)
	public void getadmintoken() throws InterruptedException, IOException {
		
		
		 
		 
	
		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
		threadSleep(PageConstants.WAIT_FIVE);
		adminToken = getTokenFromBrowser();
        System.out.println("Admin Token:" + adminToken);
		
		
	}
	
	
	@Test(priority=8)
		
		public void acceptsaqandcoc() throws InterruptedException, IOException {
		
		FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
	    Workbook workbook = new XSSFWorkbook(fis);

	    // Step 2: Pass both path and workbook to Xls_Reader
	    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);
	    Email =reader.getCellData("Customer_Login", "Email",2);
		System.out.println(Email);
		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(Email, PropertyFileUtils.getPassword());
		threadSleep(PageConstants.WAIT_FOUR);
		String token = getTokenFromBrowser();
		System.out.println("Token:" + token);
	   
		
		
		Requestids requestInfo = ApiHelper.getRequestIdsWithReports(token);

	    if (requestInfo.selfRequestId != null) {
	        ApiHelper.acceptSAQandcoc(adminToken, requestInfo.selfRequestId);
	    }

	    if (requestInfo.cocRequestId != null) {
	        ApiHelper.acceptSAQandcoc(adminToken, requestInfo.cocRequestId);
	    }
	    
	    System.out.println("TEST PASSED: SAQ and COC Request Approved Successfully");
    
	}	
	
	
}


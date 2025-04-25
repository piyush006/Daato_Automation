package daato_automation_test;

import java.io.IOException;

import org.testng.annotations.Test;

import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import utils.SCSbulkactions;

public class BulksupplierImport extends BaseTest{
	
	String Email;
	String title;
	
	public String adminToken;
	
	
	@Test
	
	
	public void uploadbulksuppliers() throws InterruptedException, IOException {
		

		
			
			PropertyFileUtils prop1 = new PropertyFileUtils();
			LoginPage login1 = new LoginPage(driver);
			login1.LoginApplication(prop1.getuser(), prop1.getpassword());
			threadSleep(PageConstants.WAIT_FOUR);
			adminToken = getTokenFromBrowser();
	        System.out.println("Admin Token:" + adminToken);	
	        
	     SCSbulkactions.uploadbulksupplier(adminToken);   
		
		
		
	}
	
	
	}


package daato_automation_test;

import java.io.IOException;

import org.testng.annotations.Test;

import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import utils.SCSbulkactions;

public class Bulkassignentity extends BaseTest{
	String Email;
	String title;
	
	public String adminToken;
	
	
	@Test(priority=10)
	
	
		public void bulkassignentity() throws InterruptedException, IOException {
			
		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
			threadSleep(PageConstants.WAIT_FOUR);
			adminToken = getTokenFromBrowser();
	        System.out.println("Admin Token:" + adminToken);
	        
	        String payload = SCSbulkactions.bulkactions(adminToken);
	        if (payload != null) {
	            // Step 2: Call mark-as-safe method
	            SCSbulkactions.bulkassignentity(adminToken, payload);
	        
	            System.out.println("TEST PASSED: Entity manager assigned successfully to First 10 Suppliers");
	            
	           

}
	}
	
	
	@Test(priority=11)
	
	public void bulkassignrelationshipmanager() throws InterruptedException, IOException {
		
		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
		threadSleep(PageConstants.WAIT_FOUR);
		adminToken = getTokenFromBrowser();
        System.out.println("Admin Token:" + adminToken);
        
        String payload = SCSbulkactions.bulkactions(adminToken);
        if (payload != null) {
            // Step 2: Call mark-as-safe method
            SCSbulkactions.bulkassignrelationshipmanager(adminToken, payload);
        }
	
        System.out.println("TEST PASSED: Relationship manager assigned successfully to First 10 Suppliers");
	
	
}
}

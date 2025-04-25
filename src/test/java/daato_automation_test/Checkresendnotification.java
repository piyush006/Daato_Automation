package daato_automation_test;

import java.io.IOException;

import org.testng.annotations.Test;

import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.Addsinglesupplier;
import utils.SCSbulkactions;
import utils.Addsinglesupplier;

public class Checkresendnotification extends BaseTest{
	
		String adminToken;
		String supplierId;
        String COCId;
	
	@Test
	public void checkresendnotification() throws InterruptedException, IOException {
	

	PropertyFileUtils prop1 = new PropertyFileUtils();
	LoginPage login1 = new LoginPage(driver);
	login1.LoginApplication(prop1.getuser(), prop1.getpassword());
	threadSleep(PageConstants.WAIT_FOUR);
	
	adminToken = getTokenFromBrowser();
	System.out.println("Admin Token:" + adminToken);
	
	
	
	Response riskResponse = Addsinglesupplier.addsinglesupplier(adminToken);
	JsonPath json = riskResponse.jsonPath();
	
	supplierId = json.getString("_id");
	System.out.println(supplierId);
	
	threadSleep(PageConstants.WAIT_TWO);
	 Addsinglesupplier.sendcoc(supplierId, adminToken);
	 
	 System.out.println("Request send");
		
		

	 Response riskResponse1 = Addsinglesupplier.getcocid(supplierId, adminToken);
	 
	 JsonPath json1 = riskResponse1.jsonPath();
	 
	 String requestId = json1.getString("codeOfConductRequest.requestId");
	 System.out.println(requestId);
	 
	 Addsinglesupplier.resendcocnotification(requestId, adminToken);
	
	}
	
	

	
	
	

}

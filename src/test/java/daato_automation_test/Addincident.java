package daato_automation_test;

import java.io.IOException;

import org.testng.Assert;
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
import utils.Incidenthelper;
import utils.SCSbulkactions;

public class Addincident extends BaseTest{
	
	
String adminToken;
	
	String Email;
	
	String supplierid;
	
	String ExpectedriskPriorityLevel ="3";
	
	String ActualriskPriorityLevel;
	
	@Test(priority=1)
	
	public void Getsupplierid() throws IOException, InterruptedException {
		
		
		Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH);
	    Email =reader.getCellData("Customer_Login", "Email",2);
		System.out.println(Email);
		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
		threadSleep(PageConstants.WAIT_FOUR);
		String token = getTokenFromBrowser();
		System.out.println("Token:" + token);
	    String endpoint = "https://qa.daato.app/api/request?type=incoming&page=0&limit=10";
	    
	    Response response = ApiHelper.getWithToken(endpoint, token);
	    JsonPath json = response.jsonPath();	
		
	    supplierid = json.getString("data[0].supplierID");
		System.out.println(supplierid);
		
		}
	
	
	@Test(priority=2)
  public void addincident() throws IOException, InterruptedException {
	
	
	
		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
	threadSleep(PageConstants.WAIT_FOUR);
	
	adminToken = getTokenFromBrowser();
	System.out.println("Admin Token:" + adminToken);
	
	
	Incidenthelper.incidentdetials(supplierid, adminToken);
	
	

}
	
	
	@Test(priority=3)
	
	
	  public void checkriskafteraddingincident() throws IOException, InterruptedException {
	
		Response riskResponse = SCSbulkactions.getRiskForSupplier(supplierid, adminToken);
	    JsonPath json = riskResponse.jsonPath();
	    
	    ActualriskPriorityLevel = json.getString("riskPriorityLevel");
	    System.out.println("Risk Priority Level: " + ExpectedriskPriorityLevel);
	    
	    Assert.assertEquals(ActualriskPriorityLevel, ExpectedriskPriorityLevel);
	 
	
	
	
}
}
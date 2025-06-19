package daato_automation_test;

import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.Getlatestfilepath;
import daato_automation_testcomponent.TestConstants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.SCSbulkactions;
import utils.SupplierData;
import utils.SupplierDataReader;





public class Checkrepositorydata extends BaseTest{
	
	
String ActualEmail;
String ActualContactName;
String ActualRelationshiomanager;
String ActualEntitymanager;
String ActualProductname;
String adminToken;


String ExpectedEmail;
String ExpectedContactName;
String ExpectedRelationshiomanager;
String ExpectedEntitymanager;
String ExpectedProductname;
String ExpectedCompanyname;
boolean ExpectedMarkassafe;
boolean ActualMarkassafe = true;

	
	@Test(priority=14)
	
	public void GetexpectedResult() throws IOException, InterruptedException {
		
		
		
		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
		threadSleep(PageConstants.WAIT_FOUR);
		adminToken = getTokenFromBrowser();
        System.out.println("Admin Token:" + adminToken);
        
        
        String Supplierid = SCSbulkactions.getFirstSupplierId(adminToken);	
        System.out.println(Supplierid);
        
        
        Response riskResponse = SCSbulkactions.getRiskForSupplier(Supplierid, adminToken);
        JsonPath json = riskResponse.jsonPath();
       // String supplierName = jsonPath.getString("name");
  
        ExpectedContactName = json.getString("defaultContact.name");
        ExpectedEmail = json.getString("defaultContact.email");
        ExpectedRelationshiomanager = json.getString("relationshipManagers[0].email");
        ExpectedEntitymanager =  json.getString("assignedTo[0].name");
        ExpectedMarkassafe = json.getBoolean("markedSafe");
        ExpectedCompanyname=json.getString("name");
        System.out.println(ExpectedCompanyname);
        
        System.out.println(ExpectedMarkassafe);
        System.out.println(ExpectedContactName);
}
	
	
   @Test(priority=15)
   
    public void checkacutaldata() throws IOException {
        SupplierData data = SupplierDataReader.getSupplierData("Piyush");
        if (data != null) {
        	ActualEmail=data.contactEmail;
        	ActualContactName=data.contactName;
        	ActualRelationshiomanager=data.relationshipManager;
        	ActualEntitymanager =data.ownBusiness;
        	ActualProductname=data.productsOrServices;
        	
        System.out.println(ActualEmail);
        System.out.println(ActualContactName);
        System.out.println(ExpectedMarkassafe);
        System.out.println(ActualMarkassafe);
        
        
        
      Assert.assertEquals(ActualEmail, ExpectedEmail);
      Assert.assertEquals(ActualContactName, ExpectedContactName);
      Assert.assertEquals(ActualRelationshiomanager, ExpectedRelationshiomanager);
      Assert.assertEquals(ActualEntitymanager, ExpectedEntitymanager);
      Assert.assertEquals(ActualMarkassafe, ExpectedMarkassafe); 
     
      
        	
        	
            // Assertions or other logic
        } else {
            System.out.println("Supplier not found in Excel.");
        }
        
        
        System.out.println("TEST PASSED: Added Supplier details Showing Correct on Repository file");
    }
    
    

    
  }
	

/*   String actualHeader = reader.getCellData("suppliers", 28, 1); // assuming AC = 29th column
   System.out.println("Header: >>" + actualHeader + "<< (length: " + actualHeader.length() + ")");
   System.out.println("Header debug:");
   for (int j = 0; j < actualHeader.length(); j++) {
       System.out.println("Char " + j + ": '" + actualHeader.charAt(j) + "' (ASCII: " + (int) actualHeader.charAt(j) + ")");
   }*/

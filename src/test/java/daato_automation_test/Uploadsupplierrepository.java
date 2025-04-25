package daato_automation_test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import daato_automation_page.Downloadrepository;
import daato_automation_page.LoginPage;
import daato_automation_page.UploadRepository;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.SCSbulkactions;
import utils.SupplierDataReader;

public class Uploadsupplierrepository extends BaseTest{
	
	
	String excelpath;
	String contactname;
	String companyname;
	String adminToken;
	String ExpectedContactName;
	boolean ExpectedMarkassafe =false;
	boolean ActualMarkassafe;
	
	
	
@Test(priority=1)	
	
public  void editanduploadrepo() throws IOException, InterruptedException {
	
	
 SupplierDataReader updater = new SupplierDataReader();
 updater.editexcel();
excelpath =SupplierDataReader.latestExcelPath;

System.out.println(excelpath);
contactname =SupplierDataReader.randomContactName;
companyname =SupplierDataReader.Companyname;
PropertyFileUtils p = new PropertyFileUtils();
LoginPage login = new LoginPage(driver);
login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());

openNewTabAndNavigate(TestConstants.TEST_SUPPLIER_REPO_URL);


UploadRepository downloadfile =  new UploadRepository(driver);

downloadfile.uploadrepositoryfile(excelpath);

}

@Test(priority=2)

public  void checkcontactnameaftereditrepo() throws IOException, InterruptedException{
	
	PropertyFileUtils p = new PropertyFileUtils();
	LoginPage login = new LoginPage(driver);
	login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
	threadSleep(PageConstants.WAIT_FOUR);
	adminToken = getTokenFromBrowser();
	
    System.out.println("Admin Token:" + adminToken);
    
    
    String Supplierid = SCSbulkactions.getFirstSupplierId(adminToken);	
    System.out.println(Supplierid);
    
    SCSbulkactions.unmarkassafe(Supplierid,adminToken);
    
    
    Response riskResponse = SCSbulkactions.getRiskForSupplier(Supplierid, adminToken);
    JsonPath json = riskResponse.jsonPath();
   // String supplierName = jsonPath.getString("name");

    ExpectedContactName = json.getString("defaultContact.name");
    ActualMarkassafe = json.getBoolean("markedSafe");
    System.out.println(ExpectedMarkassafe);
    Assert.assertEquals(ActualMarkassafe, ExpectedMarkassafe);
    
		
	
	
	
}



}

package daato_automation_test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import daato_automation_page.Downloadrepository;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.FileDownloader;
import utils.SCSbulkactions;
import utils.SupplierDataReader;

public class Downloadrepositoryfile extends BaseTest{
	
	
	String adminToken;
	String url;
	
	@Test(priority=13)
	
	public void downloadrepository() throws IOException, InterruptedException, URISyntaxException {
	
	
		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
		threadSleep(PageConstants.WAIT_FOUR);
		adminToken = getTokenFromBrowser();
		
	    System.out.println("Admin Token:" + adminToken);
		
	    Response riskResponse = SupplierDataReader.downloadfile(adminToken);
	    JsonPath json = riskResponse.jsonPath();
	    
	    url = json.getString("url");
	    System.out.println(url);
	    
	    
	    Path downloadPath = Paths.get(System.getProperty("user.dir"), "downloads");
	    Files.createDirectories(downloadPath); // Creates folder if not exists
	    FileDownloader.downloadFileFromUrl(url, downloadPath.toString());
	    
	    System.out.println("TEST PASSED: Supplier Repository File Downloaded Successfully");
	    
	 // Step 3: Download file to custom download folder
	   /* String downloadPath = System.getProperty("user.dir") + "/downloads";
	    new File(downloadPath).mkdirs(); // Ensure directory exists

	   FileDownloader.downloadFileFromUrl(url, downloadPath);*/
	
	/*PropertyFileUtils prop = new PropertyFileUtils();
	LoginPage login = new LoginPage(driver);
	login.LoginApplication(prop.getuser(), prop.getpassword());

	openNewTabAndNavigate(TestConstants.TEST_SUPPLIER_REPO_URL);
	
	
	
	Downloadrepository downloadfile =  new Downloadrepository(driver);
	
	downloadfile.clickanddownrepository();
	
	threadSleep(PageConstants.WAIT_TWENTY);*/
	
}
	
	
	
}
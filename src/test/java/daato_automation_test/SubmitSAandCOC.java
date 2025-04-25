package daato_automation_test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseBodyExtractionOptions;
import utils.ApiHelper;

public class SubmitSAandCOC extends BaseTest{
	
String Email;
String title;
	
@Test
public void fillsaq() throws IOException, InterruptedException {
	
	Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH);
    Email =reader.getCellData("Customer_Login", "Email",2);
	System.out.println(Email);
	PropertyFileUtils prop = new PropertyFileUtils();
	LoginPage login = new LoginPage(driver);
	login.LoginApplication(Email, prop.getpassword());
	threadSleep(PageConstants.WAIT_FOUR);
	String token = getTokenFromBrowser();
	System.out.println("Token:" + token);
    String endpoint = "https://qa.daato.app/api/request?type=incoming&page=0&limit=10";
    
    Response response = ApiHelper.getWithToken(endpoint, token);
    JsonPath json = response.jsonPath();
    
    List<String> requestTypes = json.getList("data.requestType");

    String cocReportId = null;
    String cocRequestId = null;
    String selfReportId = null;
    String selfRequestId = null;

    for (int i = 0; i < requestTypes.size(); i++) {
        String type = requestTypes.get(i);

        if ("code-of-conduct".equalsIgnoreCase(type)) {
            cocReportId = json.getString("data[" + i + "].reportID");
            cocRequestId = json.getString("data[" + i + "]._id");
        } else if ("self-assessment".equalsIgnoreCase(type)) {
            selfReportId = json.getString("data[" + i + "].reportID");
            selfRequestId = json.getString("data[" + i + "]._id");
        }
    }

    if (cocReportId != null) {
        System.out.println("Code of Conduct - Report ID: " + cocReportId + ", Request ID: " + cocRequestId);
    } else {
        System.out.println("Code of Conduct request not found.");
    }

    if (selfReportId != null) {
        System.out.println("Self-assessment - Report ID: " + selfReportId + ", Request ID: " + selfRequestId);
    } else {
        System.out.println("Self-assessment request not found.");
    }
   /* Response response = ApiHelper.getWithToken(endpoint, token);
    JsonPath json = response.jsonPath();
    String reportID = json.getString("data[0].reportID");
    String requestId = json.getString("data[0]._id");*/
   
    
    System.out.println("Extracted reportID: " + selfReportId);
    System.out.println("ID: " + selfRequestId);
    
    ApiHelper.executeAllPutCalls(token, selfReportId);
    
    ApiHelper.postsaqRequestState(token, selfRequestId);
    
    ApiHelper.executeAllPutCallscoc(token, cocReportId);
    
    ApiHelper.postcocRequestState(token, cocRequestId);

    // Step 3: Make the GET call with Authorization header
   /* Response response = RestAssured
        .given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
        .when()
            .get(endpoint)
        .then()
            .statusCode(200) // will throw error if not 200
            .extract()
            .response();

    // Step 4: Print response
    System.out.println("Response Body:");
    System.out.println(response.asString());
    
    
	JsonPath jsonPath = response.jsonPath();
    String reportID = jsonPath.getString("data[0].reportID");
    String ID = jsonPath.getString("data[0]._id");
    

    // Adjust the path below as per actual structure
    // or update path if different
    System.out.println("Extracted reportID: " + reportID);
    System.out.println("ID" + ID);
    
    String putUrl = "https://qa.daato.app/api/reports/" + reportID + "/dataPoint/scSize?pagesPath=main";

    // 4. Create JSON payload
    String payload = "{\"value\":[\"11 to 50\"]}";

    // 5. Make PUT call
    Response putResponse = RestAssured
        .given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .body(payload)
        .when()
            .put(putUrl)
        .then()
            .statusCode(200)
            .extract()
            .response();
    
    String putUrl1 = "https://qa.daato.app/api/reports/" + reportID + "/dataPoint/scInfluence1?pagesPath=main";

    // 4. Create JSON payload
    String payload1 = "{\"value\":[20000]}";

    // 5. Make PUT call
    Response putResponse1 = RestAssured
        .given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .body(payload1)
        .when()
            .put(putUrl1)
        .then()
            .statusCode(200)
            .extract()
            .response();

    
    
    driver.quit();*/
	
    
	
	}	
}

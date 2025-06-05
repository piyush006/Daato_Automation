package ESRS_Report;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.PropertyUtilReader;
import DMUTILS.PropertyUtilWriter;
import ESRS_UTILS.CreateESRSreport;

import ESRS_UTILS.ProperyUtilWriterESRS;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.AuthTokenadminUtil;
import static io.restassured.RestAssured.given;

public class CreateReport {

	
	

	String admintoken;
	String reportid;
	
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
   
	
		
		}
	
	 @Test(priority = 1)
	    public void createsrsreport() {
	        reportid = CreateESRSreport.createReportAndExtractId(admintoken);
	        ProperyUtilWriterESRS.writeProperty("reportid", reportid);
	       
	    }
	

	    @Test(priority = 2)
	    public void waitForReportReady() {
	        RestAssured.baseURI = "https://qa.daato.app";
	        int attempts = 100;
	        int delay = 15000; // 15 seconds

	        for (int i = 0; i < attempts; i++) {
	            Response response = given()
	                    .header("Authorization", "Bearer " + admintoken)
	                    .header("Content-Type", "application/json")
	                    .get("/api/esrs/disclosure-reporting/" + reportid);

	            int statusCode = response.statusCode();
	            String responseBody = response.getBody().asString();

	            System.out.println("Attempt " + (i + 1) + ": Status Code = " + statusCode);
	          //  System.out.println("Response Body: " + responseBody);

	            // Continue checking until config sync completes
	            if (!responseBody.contains("config is syncing") && statusCode == 200) {
	                System.out.println("✅ Report is ready.");
	                return;
	            }

	            try {
	                Thread.sleep(delay);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	                throw new RuntimeException("Thread was interrupted while waiting for report to be ready.");
	            }
	        }

	        throw new RuntimeException("❌ Report not ready after maximum retries.");
	    }
}


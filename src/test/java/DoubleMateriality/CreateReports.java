package DoubleMateriality;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.Createdmreport;
import DMUTILS.PropertyUtilWriter;
import ESRS_UTILS.CreateESRSreport;
import ESRS_UTILS.ProperyUtilWriterESRS;
import EU_Utils.Createreport;
import EU_Utils.PropertyutilwriterEU;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.AuthTokenadminUtil;

public class CreateReports {
	
	
	
	String admintoken;
	String reportid;
	boolean ExpectedisDefaultMaterial =false;
	
	String datacollectionid;
	
@BeforeClass()
public void getadmintoken() {
			
admintoken= AuthTokenadminUtil.getAdminToken();
			
}	



		
@Test(priority=1)	
public void createreport() {
	
	
	
	
	
	reportid =Createdmreport.createDoubleMaterialityReport(admintoken);	
	
	
	System.out.println(reportid);
	
	PropertyUtilWriter.writeProperty("reportid", reportid);
	
	
	 System.out.println("TEST PASSED: Double Materiality Reported Created Successfully");
}


@Test(priority = 2)
public void createsrsreport() {
    reportid = CreateESRSreport.createReportAndExtractId(admintoken);
    ProperyUtilWriterESRS.writeProperty("reportid", reportid);
   
}


@Test(priority = 3)
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
            System.out.println("TEST PASSED: ESRS Report Created Successfully");
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
	
	
@Test(priority=4)

public void createEUreport() {
	
	
	
	String[] ids = Createreport.createTaxonomy(admintoken);

    if (ids != null) {
    	reportid = ids[0];
    	datacollectionid = ids[1];

        System.out.println("Taxonomy ID: " + reportid);
        System.out.println("Data Collection ID: " + datacollectionid);
    } else {
        System.out.println("Failed to create taxonomy.");
    }
    
    
    
    PropertyutilwriterEU.writeProperty("reportid", reportid);
    PropertyutilwriterEU.writeProperty("datacollectionid", datacollectionid);
    
    
    System.out.println("TEST PASSED: Report created successfully");
    
    
    
}
	
	
	
	
	
	
	

}

package ESRS_UTILS;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ESRSApiHelper {
	
	
	
	public static void fillAndCompleteDataPoints(List<String> dataPointIds, String token, String reportId, String pagePath, String module, String value) throws InterruptedException {

        RestAssured.baseURI = "https://qa.daato.app/api/reports/" + reportId;

        for (String dataPointId : dataPointIds) {
            // JSON body with escaped value
            String payload = "{\"value\":[\"" + value + "\"]}";

            // URL for filling value
            String fillUrl = "/dataPoint/" + dataPointId + "?pagesPath=" + pagePath + "&module=" + module;

            // URL for completing data point
            String completeUrl = "/collaborationDataPoint/" + dataPointId + "/finalDataPointId/" + dataPointId + "/completed?pagesPath=" + pagePath + "&module=" + module;

            // Send PUT request to fill value
            Response fillResponse = given()
            		.header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json")
                    .body(payload)
                    .when()
                    .put(fillUrl);

            System.out.println("PUT " + RestAssured.baseURI + fillUrl + " => Status: " + fillResponse.statusCode());

            // Only try to complete if fill was successful
            if (fillResponse.statusCode() == 200) {
            	Thread.sleep(4000);
                Response completeResponse = given()
                		
                		.header("Authorization", "Bearer " + token)
                        .header("Content-Type", "application/json")
                        .body("{\"completed\":true}")
                        .when()
                        .put(completeUrl);

                System.out.println("PUT " + RestAssured.baseURI + completeUrl + " => Status: " + completeResponse.statusCode());

                if (completeResponse.statusCode() != 200) {
                    System.out.println("❌ Failed to complete dataPoint: " + dataPointId);
                }
            } else {
                System.out.println("❌ Failed to fill dataPoint: " + dataPointId);
            }
        }
        
        
        
       
        
        
    }
	
	
	
	
	
	
	public static void fillAndCompleteDataPoints1(List<String> dataPointIds, String token, String reportId, String pagePath, String module) {

        Map<String, String> payloadMap = PayloadHelper.getPayloadMap();

        for (String dpId : dataPointIds) {
            String payload = payloadMap.get(dpId);
            if (payload == null) {
                System.out.println("⚠️ No payload found for: " + dpId);
                continue;
            }

            String dataPointUrl = String.format("https://qa.daato.app/api/reports/%s/dataPoint/%s?pagesPath=%s&module=%s",
                    reportId, dpId, pagePath, module);

            String completionUrl = String.format("https://qa.daato.app/api/reports/%s/collaborationDataPoint/%s/finalDataPointId/%s/completed?pagesPath=%s&module=%s",
                    reportId, dpId, dpId, pagePath, module);

            Response response = given()
                    .header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json")
                    .body(payload)
                    .put(dataPointUrl);

            System.out.println("📤 Sent to: " + dpId + " | URL: " + dataPointUrl + " | Status: " + response.statusCode());

            Response completeResp = given()
                    .header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json")
                    .body("{\"completed\":true}")
                    .put(completionUrl);

            System.out.println("Completed: " + dpId + " | URL: " + dataPointUrl + " | Status: " + completeResp.statusCode());
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



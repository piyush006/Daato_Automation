package ESRS_UTILS;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Completefinal {
	
	
	
	
	

	  public static void updateMultipleDisclosures(String token, String reportId) {
	        String baseUrl = "https://qa.daato.app/api/esrs/disclosure-reporting/status/";
	        String endpoint = baseUrl + reportId;
	        
	        System.out.println(reportId);

	        // List of entityIds to loop through
	        String[] entityIds = {
	            "ESRS-E1-Climate-Change-Disclosure-GOV-3",
	            "ESRS-E1-Climate-Change-Disclosure-E1-1",
	            "ESRS-E1-Climate-Change-Disclosure-ESRS-2-SBM-3",
	            "ESRS-E1-Climate-Change-Disclosure-ESRS-2-IRO-1",
	            "ESRS-E1-Climate-Change-Disclosure-E1-2",
	            "ESRS-E1-Climate-Change-Disclosure-E1-3",
	            "ESRS-E1-Climate-Change-Disclosure-E1-4",
	            "ESRS-E1-Climate-Change-Disclosure-E1-6",
	            "ESRS-E1-Climate-Change-Disclosure-E1-8",
	            "ESRS-E1-Climate-Change-Disclosure-E1-9",
	        };

	        for (String entityId : entityIds) {
	            String payload = "{\n" +
	                    "  \"entityId\": \"" + entityId + "\",\n" +
	                    "  \"status\": \"completed\",\n" +
	                    "  \"isDisclosure\": true\n" +
	                    "}";

	            Response response = given()
	                    .header("Authorization", "Bearer " + token)
	                    .header("Content-Type", "application/json")
	                    .body(payload)
	                    .when()
	                    .put(endpoint)
	                    .then()
	                    .statusCode(200) // validate HTTP 200
	                    .extract().response();

	            // Optional: print response or log entityId
	            System.out.println("Updated: " + entityId + " | Response: " + response.asString());
	        }
	    }
}



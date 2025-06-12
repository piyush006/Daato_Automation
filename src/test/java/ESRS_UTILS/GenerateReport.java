package ESRS_UTILS;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class GenerateReport {
	
	
	
	public static void update(String token, String reportId) {
        // Set base URI
        RestAssured.baseURI = "https://qa.daato.app";

        // Construct URL with reportId
        String endpoint = "/api/reports/" + reportId + "/dataPoint/esrsE15?pagesPath=main";

        // JSON payload
        String payload = "{ \"value\": [\"Automatedpiyush\"] }";

        // Send PUT request
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(payload)
            .when()
                .put(endpoint)
            .then()
                .extract().response();

        // Output response
        System.out.println("Status Code: " + response.getStatusCode());
    //    System.out.println("Response Body: " + response.asString());

        if (response.getStatusCode() == 200) {
            System.out.println("✅ Data point updated successfully.");
        } else {
            System.err.println("❌ Update failed.");
        }
    }
	
	
	
	
	public static void updateStatus(String token, String reportId) {
        // Base URI
        RestAssured.baseURI = "https://qa.daato.app";

        // Full URL with reportId
        String endpoint = "/api/esrs/disclosure-reporting/status/" + reportId;

        // JSON Payload
        String payload = "{\n" +
                "  \"entityId\": \"ESRS-E1-Climate-Change-Disclosure-E1-5\",\n" +
                "  \"status\": \"completed\",\n" +
                "  \"isDisclosure\": true\n" +
                "}";

        // Send PUT request
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(payload)
            .when()
                .put(endpoint)
            .then()
                .extract().response();

        // Print results
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.asString());

        if (response.getStatusCode() == 200) {
            System.out.println("✅ Disclosure status updated successfully.");
        } else {
            System.err.println("❌ Failed to update disclosure status.");
        }
    }
	
	
	public static String getStatus(String token, String reportid) {
		String disclosureId = "ESRS-E1-Climate-Change-Disclosure-E1-5";

        // Construct full URL with dynamic reportId
        String url = "https://qa.daato.app/api/esrs/disclosure-reporting/" 
                     + reportid + "/disclosures/" + disclosureId;
        // Call API and extract response
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Extract "status" from top level of response
        String status = response.jsonPath().getString("status");

        // Print or return the status
        System.out.println("Disclosure Status: " + status);
        return status;
    }

   
       
    
}

	
	
	
	
	
	
	
	
	



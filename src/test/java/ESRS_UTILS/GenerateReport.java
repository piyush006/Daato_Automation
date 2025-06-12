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
	
	
	
	
/*	public static void updateStatus(String token, String reportId) {
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
    }*/
	public static void updateStatusWithTwoRounds(String token, String reportId) {
	    final String disclosureId = "ESRS-E1-Climate-Change-Disclosure-E1-5";
	    final int totalAttemptsPerRound = 5;
	    final int delayBetweenChecksMillis = 4000;

	    boolean isCompleted = false;
	    int round = 1;

	    while (round <= 2 && !isCompleted) {
	        System.out.println("🚀 Starting Round #" + round + " of Status Updates");

	        String finalStatus = "";

	        for (int attempt = 1; attempt <= totalAttemptsPerRound; attempt++) {
	            System.out.println("🔁 Round " + round + " - Update Attempt #" + attempt);

	            // Step 1: Update the status
	            updateStatus(token, reportId);

	            // Step 2: Wait before checking status
	            try {
	                Thread.sleep(delayBetweenChecksMillis);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	                System.err.println("Thread sleep interrupted!");
	            }

	            // Step 3: Check the status
	            finalStatus = getStatus(token, reportId, disclosureId);
	            System.out.println("📊 Round " + round + " - Attempt #" + attempt + " - Status = " + finalStatus);
	        }

	        // Step 4: After 5th attempt, evaluate the final status
	        if ("completed".equalsIgnoreCase(finalStatus)) {
	            System.out.println("✅ Disclosure status is 'completed' after Round #" + round);
	            isCompleted = true;
	            break;
	        } else {
	            System.out.println("⚠️ Final status after Round #" + round + " is not 'completed'. Retrying...");
	        }

	        round++;
	    }

	    // Final outcome
	    if (!isCompleted) {
	        System.err.println("❌ Disclosure status failed to become 'completed' after 2 full rounds.");
	    }
	}
	
	
	public static void updateStatus(String token, String reportId) {
	    RestAssured.baseURI = "https://qa.daato.app";
	    String endpoint = "/api/esrs/disclosure-reporting/status/" + reportId;

	    String payload = "{\n" +
	            "  \"entityId\": \"ESRS-E1-Climate-Change-Disclosure-E1-5\",\n" +
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
	            .extract().response();

	    System.out.println("🔧 PUT Status Update -> Code: " + response.getStatusCode());
	    System.out.println("PUT Response: " + response.prettyPrint());

	    if (response.getStatusCode() == 200) {
	        System.out.println("✅ Status update API responded with 200 OK.");
	    } else {
	        System.err.println("❌ Status update failed.");
	    }
	}

	public static String getStatus(String token, String reportId, String disclosureId) {
	    String url = "https://qa.daato.app/api/esrs/disclosure-reporting/" 
	                 + reportId + "/disclosures/" + disclosureId;

	    Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .when()
	            .get(url)
	            .then()
	            .extract()
	            .response();

	    String status = response.jsonPath().getString("status");
	    System.out.println("🔍 Current Disclosure Status: " + status);
	    return status;
	}
       
    
}

	
	
	
	
	
	
	
	
	



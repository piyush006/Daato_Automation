package ESRS_UTILS;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Submitrequest {
	
	
	
	
	public static void updateEntityStatusToCompleted(String token, String workflowId, String entityId) {
	    // Build the full URL
	    String url = "https://qa.daato.app/api/data-collection-workflows/" + workflowId + "/entities/" + entityId;

	    // Build the payload
	    String payload = "{\"status\":\"completed\"}";

	    // Send PUT request
	    Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .body(payload)
	            .put(url)
	            .then()
	            .statusCode(200)
	            .extract()
	            .response();

	    
	    String responseBody = response.getBody().asString();
	    System.out.println("Status Code: " + response.getStatusCode());
	    
	    System.out.println("Response Body: " + response.getBody().asString());
	    
	    if (!"data-collection-workflows-updated".equals(responseBody)) {
	    	
	        throw new RuntimeException("Expected response 'data-collection-workflows-updated' but got '" + responseBody + "'");
	    }

	    System.out.println("✅ Status update successful.");
	    
	    
	    
	    
	}
	
	
	public static void updateWorkflowStatus(String token, String workflowId) {
	    // Build the URL
	    String url = "https://qa.daato.app/api/data-collection-workflows/" + workflowId;

	    // Define the payload
	    String payload = "{\"status\":\"completed\"}";

	    // Send PUT request
	    Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .body(payload)
	            .when()
	            .put(url)
	            .then()
	            .statusCode(200) // ✅ Validate expected status code
	            .extract()
	            .response();

	    // Print the response body
	    String responseBody = response.getBody().asString();
	    System.out.println("Response Body: " + responseBody);
	
	
	
	}
	
	

}

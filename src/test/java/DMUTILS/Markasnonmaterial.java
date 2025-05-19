package DMUTILS;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;



public class Markasnonmaterial {
	
	
	
	 public static void markasnonmaterial(String token, String doubleMaterialityId) {
	        String[] assessments = {
	            "esrs-e1-energy",
	            "esrs-e2-pollution-of-air",
	            "esrs-e2-pollution-of-water",
	            "esrs-e2-pollution-of-soil",
	            "esrs-s1-working-conditions-of-own-workforce-secure-employment",
	            "esrs-g1-governance-corporate-culture"
	        };

	        String payload = "{"
	                + "\"explanationMessage\":\"Automation comment\","
	                + "\"mark\":true"
	                + "}";

	        RestAssured.baseURI = "https://qa.daato.app";

	        for (String assessment : assessments) {
	            String endpoint = "/api/esrs/double-materiality/" + doubleMaterialityId +
	                              "/assessments/" + assessment + "/non-material";

	            Response response = given()
	                    .header("Authorization", "Bearer " + token)
	                    .header("Content-Type", "application/json")
	                    .body(payload)
	                .when()
	                    .put(endpoint)
	                .then()
	                    .statusCode(200)
	                    .extract().response();

	            System.out.println("Posted to: " + endpoint);
	            System.out.println("Status Code: " + response.getStatusCode());
	        }
	    }

	    // Example usage
	 
	
	
}

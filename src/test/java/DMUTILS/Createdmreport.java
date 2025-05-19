package DMUTILS;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


import java.util.UUID;
public class Createdmreport {
	
	
	
public static String createDoubleMaterialityReport(String token) {
	 
	        String uniqueName = "Automated Report " + UUID.randomUUID().toString().substring(0, 8);
	        String payload = "{"
	                + "\"startDate\":\"2025-04-28T18:30:00.000Z\","
	                + "\"endDate\":\"2025-12-02T18:30:00.000Z\","
	                + "\"name\":\"" + uniqueName + "\""
	                + "}";

	        RestAssured.baseURI = "https://qa.daato.app";

	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	            .when()
	                .post("/api/esrs/double-materiality")
	            .then()
	                .statusCode(201)
	                .extract().response();

	        String id = response.jsonPath().getString("_id");

	        System.out.println("Created Report ID: " + id);
	        return id;
	    }	
	
	
}
	
package DMUTILS;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class XLSXdatareader {
	
	
	
	
	
	public static String downloadFile(String token, String reportId) {
	    String endpoint = "https://qa.daato.app/api/esrs/double-materiality/" + reportId + "/export/data";

	    Response response = RestAssured
	        .given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	        .when()
	            .get(endpoint)
	        .then()
	            .statusCode(200)  // Change if the API uses a different status
	            .extract().response();
	    
	    String fileUrl = response.asString(); // assuming the URL is returned as plain text
	    return fileUrl;

	  
	}
	
	
}

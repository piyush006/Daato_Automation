package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Incidenthelper {
	
	
		
	
	
	
	
	public static void incidentdetials(String supplierId, String token) {
		
		
		
		 String endpoint = "https://qa.daato.app/api/incidents";
		    String payload = String.format(
		        "{\"title\":\"Test Automation\",\"incidentsType\":\"grievance\",\"supplier\":{\"supplierId\":\"%s\",\"realm\":\"qa\"},\"ownSupplier\":false,\"incidentManager\":{\"managerId\":\"e1721788-31cf-4228-954f-30493eb7081f\",\"managerEmail\":\"piyush.soni@47billion.com\"},\"risks\":[\"childLabor\",\"forcedLabour\"],\"riskNature\":\"imminent\",\"description\":\"Test piyush\",\"attachments\":[]}",
		        supplierId
		    );

		    Response response = RestAssured
		        .given()
		            .header("Authorization", "Bearer " + token)
		            .header("Content-Type", "application/json")
		            .body(payload)
		        .when()
		            .post(endpoint)
		        .then()
		            .statusCode(201)
		            .extract()
		            .response();

		    System.out.println("Response: " + response.asString());
		
		
		
		
		
}
}
	
	
	
	
	
	
	
	
	



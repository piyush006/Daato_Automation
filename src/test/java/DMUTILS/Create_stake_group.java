package DMUTILS;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Create_stake_group {
	
	  static String uniqueName = "AutomatedGroup_" + System.currentTimeMillis();

	    public static String  createStakeholderGroup(String token) {
	        String baseUrl = "https://qa.daato.app";
	        String endpoint = "/api/esrs/stakeholder/groups";
	        String payload = "{"
	        		+ "\"name\":\"" + uniqueName + "\","
	        	    + "\"relevantESRSGroups\":["
	        	        + "{"
	        	            + "\"mainGroup\":\"environmental\","
	        	            + "\"group\":\"Climate\","
	        	            + "\"issues\":["
	        	                + "{\"esrsTopicId\":\"esrs-e1-climate-change-adaptation\",\"weight\":2},"
	        	                + "{\"esrsTopicId\":\"esrs-e1-climate-change-mitigation\",\"weight\":2},"
	        	                + "{\"esrsTopicId\":\"esrs-e1-energy\",\"weight\":2}"
	        	            + "]"
	        	        + "},"
	        	        + "{"
	        	            + "\"mainGroup\":\"environmental\","
	        	            + "\"group\":\"Pollution\","
	        	            + "\"issues\":["
	        	                + "{\"esrsTopicId\":\"esrs-e2-pollution-of-air\",\"weight\":2},"
	        	                + "{\"esrsTopicId\":\"esrs-e2-pollution-of-water\",\"weight\":2},"
	        	                + "{\"esrsTopicId\":\"esrs-e2-pollution-of-soil\",\"weight\":2},"
	        	                + "{\"esrsTopicId\":\"esrs-e2-pollution-of-living-organisms-food-resources\",\"weight\":2},"
	        	                + "{\"esrsTopicId\":\"esrs-e2-substances-of-concern\",\"weight\":2},"
	        	                + "{\"esrsTopicId\":\"esrs-e2-substances-of-very-high-concern\",\"weight\":2},"
	        	                + "{\"esrsTopicId\":\"esrs-e2-microplastics\",\"weight\":2}"
	        	            + "]"
	        	        + "}"
	        	    + "],"
	        	    + "\"type\":\"internal\","
	        	    + "\"financialAssessmentRelevant\":true,"
	        	    + "\"impactAssessmentRelevant\":true"
	        	+ "}";
	        
	 

	        RestAssured.baseURI = baseUrl;

	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	            .when()
	                .post(endpoint)
	            .then()
	                .statusCode(201) // adjust if API returns 200 or something else
	                .extract()
	                .response();

	            return response.jsonPath().getString("_id");

	       
	    
	    }
	
	
	
	

}


package ESRS_UTILS;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateESRSreport {
	
	
	
	
	
	public static String createReportAndExtractId(String token) { 
	    // Token provided from another class
	    RestAssured.baseURI = "https://qa.daato.app";

	    String uniqueName = "Automated" + UUID.randomUUID().toString().substring(0, 4);

	    String payload = "{\n" +
	            "  \"name\": \"" + uniqueName + "\",\n" +
	            "  \"reportingStartPeriod\": \"2025-05-06T18:30:00.000Z\",\n" +
	            "  \"reportingEndPeriod\": \"2025-05-23T18:30:00.000Z\",\n" +
	            "  \"entityIds\": []\n" +
	            "}";

	    Response response = given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .body(payload)
	            .when()
	            .post("/api/esrs/disclosure-reporting")
	            .then()
	            .statusCode(201)
	            .extract().response();

	    String createdReportId = response.jsonPath().getString("_id");
	    System.out.println("Created Report _id: " + createdReportId);
	    
	    // Return the created report ID
	    return createdReportId;
	}
	
	
	
	
	public static void createEntityCustomDisclosure(String token, String reportId) {
	    RestAssured.baseURI = "https://qa.daato.app";

	    String uniqueName = "Automated" + UUID.randomUUID().toString().substring(0, 4);
	    
	    String payload = "{\n" +
	            "  \"disclosureName\": \"" + uniqueName +"\",\n" +
	            "  \"section\": \"crossCutting\"\n" +
	            "}";

	    Response response = given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .body(payload)
	            .when()
	            .post("/api/esrs/disclosure-reporting/entity-custom-disclosure/" + reportId)
	            .then()
	            .statusCode(201)
	            .extract().response();
	    System.out.println("Response Body: " + response.getBody().asString());
	    String disclosureId = response.jsonPath().getString("_id");
	   
	}
	
	public static String getDisclosureIdForMdr1(String token, String reportId) {
		 RestAssured.baseURI = "https://qa.daato.app";

		    Response response = given()
		            .header("Authorization", "Bearer " + token)
		            .header("Content-Type", "application/json")
		            .queryParam("esrsLite", "standards")
		            .when()
		            .get("/api/esrs/disclosure-reporting/" + reportId)
		            .then()
		            .statusCode(200)
		            .extract()
		            .response();

		    String responseBody = response.getBody().asString();
		    JsonPath jsonPath = JsonPath.from(responseBody);

		    List<Map<String, Object>> requirementArray = jsonPath.getList("disclosureRequirementArray");

		    if (requirementArray == null) {
		        throw new RuntimeException("disclosureRequirementArray is null");
		    }

		    for (Map<String, Object> item : requirementArray) {
		        String name = (String) item.get("disclosureName");
		        if ("MDR - Description of the sustainability matter for entity-specific disclosures".equals(name)) {
		            return (String) item.get("disclosureId");
		        }
		    }

		    throw new RuntimeException("Disclosure with name 'MDR - Description of the sustainability matter for entity-specific disclosures' not found");
	    }
	
	
	
	
	public static void updateEsrsEntity(String token, String reportId, String entityId) {
	    RestAssured.baseURI = "https://qa.daato.app";

	    // Payload with Java-escaped string
	    String payload = String.format(
	        "{\n" +
	        "    \"entityId\": \"%s\",\n" +
	        "    \"includedIn\": false,\n" +
	        "    \"message\": \"TestAutomated\",\n" +
	        "    \"isDisclosure\": true,\n" +
	        "    \"noInfoToDisclose\": false,\n" +
	        "    \"markAsNonMaterial\": true,\n" +
	        "    \"excludeReason\": \"nonMaterial\",\n" +
	        "    \"reportingType\": null,\n" +
	        "    \"isCustom\": true\n" +
	        "}",
	        entityId);

	    // Send PUT request (no return)
	    given()
	        .header("Authorization", "Bearer " + token)
	        .header("Content-Type", "application/json")
	        .body(payload)
	        .when()
	        .put("/api/esrs/disclosure-reporting/" + reportId + "/update-esrs-entity")
	        .then()
	        .statusCode(200);

	    System.out.println("Update successful for entityId: " + entityId);
	
	
	
	
	}	
	


}
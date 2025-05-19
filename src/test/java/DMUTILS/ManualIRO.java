package DMUTILS;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;
public class ManualIRO {
	
	
	
	
	
	public static String createCustomIRO(String token, String urlId) {
        RestAssured.baseURI = "https://qa.daato.app";

        String endpoint = "/api/esrs/double-materiality/" + urlId + "/iro/custom";

        String payload = "{\n" +
                "  \"title\": \"Automatedmanual\",\n" +
                "  \"description\": \"Test\",\n" +
                "  \"source\": \"Test\",\n" +
                "  \"natureOfImpact\": \"Potential\",\n" +
                "  \"typeOfImpact\": \"Negative\",\n" +
                "  \"timeframe\": \"Short-Term\",\n" +
                "  \"impactHumanRights\": \"Human-rights related impact\",\n" +
                "  \"iroType\": \"impact\",\n" +
                "  \"issueId\": \"esrs-s1-working-conditions-of-own-workforce-working-time\",\n" +
                "  \"esgType\": \"social\"\n" +
                "}";

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(payload)
            .when()
                .post(endpoint)
            .then()
                .statusCode(201)
                .body("message", equalTo("custom-iro-added-successfully"))
                .extract().response();

        String iroId = response.jsonPath().getString("iroId");
        System.out.println("Created IRO ID: " + iroId);
        return iroId;
    }
	
	
	
    public static String getAssessmentReportId(String token, String urlId, String iroId) {
        RestAssured.baseURI = "https://qa.daato.app";

        String endpoint = "/api/esrs/double-materiality/" + urlId + "/iro/" + iroId + "/assessment-report";

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
            .when()
                .post(endpoint)
            .then()
                .statusCode(201)
                .extract().response();

        String assessmentReportId = response.jsonPath().getString("assessmentReportId");

        System.out.println("Assessment Report ID: " + assessmentReportId);
        return assessmentReportId;
    }
    
    
    public static void performAllPutCalls(String token, String assessmentReportId, String reportId, String iroId) {
        RestAssured.baseURI = "https://qa.daato.app";

        // List of endpoint suffixes for each data point
        List<String> endpoints = Arrays.asList(
            "impactPotentialNegativeScale",
            "impactPotentialNegativeScope",
            "impactPotentialNegativeIrremediability",
            "impactPotentialNegativeLikelihood"
        );

        // Common payload
        String payload = "{\"value\":[\"5\"]}";

        for (String endpointName : endpoints) {
            String endpoint = "/api/reports/" + assessmentReportId + "/dataPoint/" + endpointName +
                "?pagesPath=doubleMateriality/" + reportId + "/assessIROs/social/" + assessmentReportId + "/" + iroId +
                "&module=iro";

            Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(payload)
            .when()
                .put(endpoint)
            .then()
                .statusCode(200)
                .extract().response();

            System.out.println("PUT to " + endpointName + " successful. Status: " + response.statusCode());
        }
    }
    public static void sendcollaborationrequest(
            String token,
            String reportedId,
            String assessmentReportId,
            String iroId,
            String contributorId
        ) {
            RestAssured.baseURI = "https://qa.daato.app";

            String endpoint = "/api/request?pagesPath=doubleMateriality/" + reportedId +
                              "/assessIROs/social/" + assessmentReportId + "/" + iroId + "&module=";

            String payload = "{\n" +
            	    "  \"title\": \"Is this a direct impact of the entire company or only some of its subsidiaries or levels of the value chain?\",\n" +
            	    "  \"reportID\": \"" + assessmentReportId + "\",\n" +
            	    "  \"pageID\": \"impact\",\n" +
            	    "  \"contributors\": [\"" + contributorId + "\"],\n" +
            	    "  \"dueDate\": \"2025-12-12T07:49:33.265Z\",\n" +
            	    "  \"message\": \"Test Piyush\",\n" +
            	    "  \"forCollaborator\": true,\n" +
            	    "  \"dataPointIDs\": [\"impactCompany\"]\n" +
            	    "}";

            Response response = given()
                    .header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json")
                    .body(payload)
                .when()
                    .post(endpoint)
                .then()
                    .statusCode(201)
                    .extract().response();
            String responseBody = response.getBody().asString();
            System.out.println("Response Body: " + responseBody);

            System.out.println("Request created successfully. Status Code: " + response.statusCode());
        }	

}

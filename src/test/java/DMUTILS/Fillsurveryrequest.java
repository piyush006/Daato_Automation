package DMUTILS;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Fillsurveryrequest {
	
	
	
	public static void submitScoring(String token, String requestId) {
        String baseUrl = "https://qa.daato.app/api/esrs/double-materiality/survey/request/" + requestId;

        // Array of scoring payloads
        String[] payloads = {
            "{\"scoring\":{\"scoring\":0,\"issueId\":\"esrs-e1-climate-change-adaptation\"}}",
            "{\"scoring\":{\"scoring\":4,\"issueId\":\"esrs-e1-climate-change-mitigation\"}}",
            "{\"scoring\":{\"scoring\":2,\"issueId\":\"esrs-e2-pollution-of-living-organisms-food-resources\"}}",
            "{\"scoring\":{\"scoring\":1,\"issueId\":\"esrs-e2-substances-of-concern\"}}",
            "{\"scoring\":{\"scoring\":2,\"issueId\":\"esrs-e2-substances-of-very-high-concern\"}}",
            "{\"scoring\":{\"scoring\":1,\"issueId\":\"esrs-e2-microplastics\"}}"
        };

        for (String payload : payloads) {
            Response response = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .body(payload)
                .when()
                    .put(baseUrl)
                .then()
                .statusCode(200)
                    .extract().response();
               
            // Assert status code is 200
            int statusCode = response.getStatusCode();
            System.out.println("Payload: " + payload);
            System.out.println("Status Code: " + statusCode);

        }
    }
	
	
	
	public static void submitCustomMatter(String token, String requestId) {
        String url = "https://qa.daato.app/api/esrs/double-materiality/survey/request/" + requestId;

        String payload = "{\n" +
                "  \"customSustainabilitymatter\": {\n" +
                "    \"issue\": \"Automatedentityspecific\",\n" +
                "    \"esg\": \"environmental\",\n" +
                "    \"description\": \"Test\",\n" +
                "    \"esrsStandard\": \"Entity Specific Disclosures\",\n" +
                "    \"source\": \"Test\",\n" +
                "    \"attachment\": {}\n" +
                "  }\n" +
                "}";

        Response response = RestAssured
            .given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(payload)
            .when()
                .put(url)
            .then()
            .statusCode(200)
                .extract().response();

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);
        System.out.println("Response Body: " + response.getBody().asString());

	
	
	}
	
	
	public static void updateRequestStatus(String token, String requestId) {
        String url = "https://qa.daato.app/api/request/state";

        String payload = String.format(
                "{\n" +
                "  \"requestID\": \"%s\",\n" +
                "  \"status\": \"review\",\n" +
                "  \"message\": \"Test piyush\"\n" +
                "}", requestId
        );

        Response response = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .body(payload)
                .when()
                    .patch(url)
                .then()
                    .extract().response();

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);
        System.out.println("Response Body: " + response.getBody().asString());

        // Assert status is 200
       
    }	
	
	
	
	public static void acceptRequest(String token, String reportId) {
        String url = "https://qa.daato.app/api/request/" + reportId + "/accept";

        Response response = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                .when()
                    .post(url)
                .then()
                    .statusCode(201) // Check HTTP status
                    .extract().response();

        // Log full response
        System.out.println("Response Body: " + response.getBody().asString());

        // Extract and assert the "status" field from the response
        String actualStatus = response.jsonPath().getString("status");
        System.out.println("Survey status: " + actualStatus);
      String expectedStatus ="completed";
      assertEquals(actualStatus, expectedStatus);
      
    }
	
	public static void deleteSurveyScope(String token, String reportId) {
        String url = "https://qa.daato.app/api/esrs/double-materiality/" + reportId + "/survey/scope";

        Response response = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                .when()
                    .delete(url)
                .then()
                   .statusCode(200) // Expected DELETE success status
                    .extract().response();

        // Log full response
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        if (!responseBody.isEmpty() && response.getContentType().contains("application/json")) {
            String actualStatus = response.jsonPath().getString("status");
            System.out.println("Survey deletion status (if returned): " + actualStatus);
            String expectedStatus = "survey-closed-success";
            assertEquals(actualStatus, expectedStatus);
        } else {
            System.out.println("No JSON body returned or content type is not JSON.");
        }
    }
	
	
	
	public static String getContributorId(String token) {
        RestAssured.baseURI = "https://qa.daato.app";

        String endpoint = "/api/request?type=incoming&page=0&limit=10";

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
            .when()
                .get(endpoint)
            .then()
                .statusCode(200)
                .extract().response();

        String contributorId = response.jsonPath().getString("data[0].contributor.id");
        System.out.println("Contributor ID: " + contributorId);
        return contributorId;
    }


}

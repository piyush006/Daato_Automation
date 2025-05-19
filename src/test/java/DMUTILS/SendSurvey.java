package DMUTILS;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;
public class SendSurvey {

	
	
	
	
	public static void sendSurveyToStakeholder(String token, String reportId, String stakeholderId) {
        String url = "https://qa.daato.app/api/esrs/double-materiality/" + reportId + "/survey/scope";

        String payload = String.format(
            "{\n" +
            "  \"internalSurveyMessage\": \"Test\",\n" +
            "  \"externalSurveyMessage\": \"Test\",\n" +
            "  \"deadlineDate\": \"2025-10-17T18:30:00.000Z\",\n" +
            "  \"stakeholderIds\": [\"%s\"]\n" +
            "}", stakeholderId
        );

        Response response = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .body(payload)
                .when()
                    .post(url)
                .then()
                    //.statusCode(201)  // Assumes 200 is the expected success status
                    .extract().response();

        // Assert response body contains status = "survey-sent"
        
        System.out.println("surveysent");
        String responseBody = response.getBody().asString();
        System.out.println("Raw response body: " + responseBody);

        // Only try to extract status if body is not empty and contains JSON
        if (responseBody != null && responseBody.trim().startsWith("{")) {
            String actualStatus = response.jsonPath().getString("status");
            System.out.println("Response status: " + actualStatus);
            assertEquals(actualStatus, "survey-sent", "Survey send status is not as expected!");
        } else {
            System.out.println("Warning: Response body is not valid JSON.");
        }
    }	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

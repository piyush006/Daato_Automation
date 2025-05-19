package DMUTILS;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class UploadIRO {
	
	
	
	public static void postIROBulk(String token, String reportId) {
        String baseUrl = "https://qa.daato.app";
        String endpoint = String.format("%s/api/esrs/double-materiality/%s/iro/custom/bulk", baseUrl, reportId);
        String payload = "[{\"description\":\"Testauto01\",\"title\":\"Automatedimpact01\",\"iroType\":\"impact\",\"issueId\":\"esrs-e1-climate-change-adaptation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryLow\",\"typeOfImpact\":\"Negative\",\"timeframe\":\"Short-Term\",\"natureOfImpact\":\"Potential\",\"impactHumanRights\":\"Human-rights related impact\"}," +
        		"{\"description\":\"Testauto02\",\"title\":\"Automatedimpact02\",\"iroType\":\"impact\",\"issueId\":\"esrs-e1-climate-change-adaptation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryHigh\",\"typeOfImpact\":\"Positive\",\"timeframe\":\"Mid-Term\",\"natureOfImpact\":\"Actual\"}," +
        		"{\"description\":\"Testauto03\",\"title\":\"Automatedimpact03\",\"iroType\":\"impact\",\"issueId\":\"esrs-e1-climate-change-mitigation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryLow\",\"typeOfImpact\":\"Negative\",\"timeframe\":\"Short-Term\",\"natureOfImpact\":\"Potential\",\"impactHumanRights\":\"Human-rights related impact\"}," +
        		"{\"description\":\"Testauto04\",\"title\":\"Automatedimpact04\",\"iroType\":\"impact\",\"issueId\":\"esrs-e1-climate-change-mitigation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryHigh\",\"typeOfImpact\":\"Positive\",\"timeframe\":\"Mid-Term\",\"natureOfImpact\":\"Actual\"}," +
        		"{\"description\":\"Testauto05\",\"title\":\"Automatedimpact05\",\"iroType\":\"impact\",\"issueId\":\"esrs-e1-energy\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"medium\",\"typeOfImpact\":\"Negative\",\"timeframe\":\"Short-Term\",\"natureOfImpact\":\"Potential\",\"impactHumanRights\":\"Human-rights related impact\"}," +
        		"{\"description\":\"Testauto06\",\"title\":\"Automatedimpact06\",\"iroType\":\"impact\",\"issueId\":\"esrs-e1-energy\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"low\",\"typeOfImpact\":\"Positive\",\"timeframe\":\"Mid-Term\",\"natureOfImpact\":\"Actual\"}," +
        		"{\"description\":\"Test opportunities\",\"title\":\"Automatedoppo01\",\"iroType\":\"opportunity\",\"issueId\":\"esrs-e1-climate-change-adaptation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryLow\",\"typeOfImpact\":\"\",\"timeframe\":\"Short-Term\",\"natureOfImpact\":\"\"}," +
        		"{\"description\":\"Test opportunities\",\"title\":\"Automatedoppo02\",\"iroType\":\"opportunity\",\"issueId\":\"esrs-e1-climate-change-adaptation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryHigh\",\"typeOfImpact\":\"\",\"timeframe\":\"Mid-Term\",\"natureOfImpact\":\"\"}," +
        		"{\"description\":\"Test opportunities\",\"title\":\"Automatedoppo03\",\"iroType\":\"opportunity\",\"issueId\":\"esrs-e1-climate-change-mitigation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryLow\",\"typeOfImpact\":\"\",\"timeframe\":\"Short-Term\",\"natureOfImpact\":\"\"}," +
        		"{\"description\":\"Test opportunities\",\"title\":\"Automatedoppo04\",\"iroType\":\"opportunity\",\"issueId\":\"esrs-e1-climate-change-mitigation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryHigh\",\"typeOfImpact\":\"\",\"timeframe\":\"Mid-Term\",\"natureOfImpact\":\"\"}," +
        		"{\"description\":\"Test opportunities\",\"title\":\"Automatedoppo05\",\"iroType\":\"opportunity\",\"issueId\":\"esrs-e1-energy\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"medium\",\"typeOfImpact\":\"\",\"timeframe\":\"Short-Term\",\"natureOfImpact\":\"\"}," +
        		"{\"description\":\"Test opportunities\",\"title\":\"Automatedoppo06\",\"iroType\":\"opportunity\",\"issueId\":\"esrs-e1-energy\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"low\",\"typeOfImpact\":\"\",\"timeframe\":\"Mid-Term\",\"natureOfImpact\":\"\"}," +
        		"{\"description\":\"Test risk\",\"title\":\"Automatedrisk01\",\"iroType\":\"risk\",\"issueId\":\"esrs-e1-climate-change-adaptation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryLow\",\"typeOfImpact\":\"\",\"timeframe\":\"Short-Term\",\"natureOfImpact\":\"\"}," +
        		"{\"description\":\"Test risk\",\"title\":\"Automatedrisk02\",\"iroType\":\"risk\",\"issueId\":\"esrs-e1-climate-change-adaptation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryHigh\",\"typeOfImpact\":\"\",\"timeframe\":\"Mid-Term\",\"natureOfImpact\":\"\"}," +
        		"{\"description\":\"Test risk\",\"title\":\"Automatedrisk03\",\"iroType\":\"risk\",\"issueId\":\"esrs-e1-climate-change-mitigation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryLow\",\"typeOfImpact\":\"\",\"timeframe\":\"Short-Term\",\"natureOfImpact\":\"\"}," +
        		"{\"description\":\"Test risk\",\"title\":\"Automatedrisk04\",\"iroType\":\"risk\",\"issueId\":\"esrs-e1-climate-change-mitigation\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"veryHigh\",\"typeOfImpact\":\"\",\"timeframe\":\"Mid-Term\",\"natureOfImpact\":\"\"}," +
        		"{\"description\":\"Test risk\",\"title\":\"Automatedrisk05\",\"iroType\":\"risk\",\"issueId\":\"esrs-e1-energy\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"medium\",\"typeOfImpact\":\"\",\"timeframe\":\"Short-Term\",\"natureOfImpact\":\"\"}," +
        		"{\"description\":\"Test risk\",\"title\":\"Automatedrisk06\",\"iroType\":\"risk\",\"issueId\":\"esrs-e1-energy\",\"source\":\"Test\",\"esgType\":\"environmental\",\"manualAssessment\":\"low\",\"typeOfImpact\":\"\",\"timeframe\":\"Mid-Term\",\"natureOfImpact\":\"\"}]";

              String responseBody = RestAssured
            .given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(payload)
            .when()
                .post(endpoint)
            .then()
            .statusCode(201)
                .log().ifValidationFails()
                .extract().asString();

        // Parse and print only the message
        JsonPath jsonPath = new JsonPath(responseBody);
        String message = jsonPath.getString("message");
        System.out.println("API Message: " + message);
    }
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



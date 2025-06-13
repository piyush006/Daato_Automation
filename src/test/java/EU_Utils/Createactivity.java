package EU_Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Createactivity {
	
	
	
	
	
	public static void createMyTaxonomy(String token, String projectGroupId, String dataCollectionId) {
        RestAssured.baseURI = "https://qa.daato.app";

        String endpoint = "/api/project-group/taxonomy/" + projectGroupId +
                          "/dataCollection/" + dataCollectionId + "/entity/my_taxonomy";

        String payload = "{\n" +
                "  \"name\": \"Test\",\n" +
                "  \"economicActivity\": \"9.1_3.2\",\n" +
                "  \"availableEnvironmentalCriteria\": [\"Climate mitigation\"],\n" +
                "  \"environmentalCriteria\": \"Climate mitigation\",\n" +
                "  \"relatedActivities\": [\n" +
                "    {\n" +
                "      \"activityId\": \"3.2\",\n" +
                "      \"activityName\": \"Close to market research, development and innovation - CCM 9.1 / Manufacture of equipment for the production and use of hydrogen - CCM 3.2\",\n" +
                "      \"environmentalCriteria\": \"Climate mitigation\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Response response =   given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .body(payload)
            .post(endpoint)
            .then()
        .statusCode(201) // Validate status code
        .extract()
        .response();

System.out.println("Response Body:\n" + response.getBody().asString());
    }
	
	
	
	
	
	

}

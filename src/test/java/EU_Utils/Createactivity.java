package EU_Utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class Createactivity {
	
	
	public static String safeguardFor_9_1_3_2;
    public static String safeguardFor_3_2;
    public static String idFor_9_1_3_2;
    public static String idFor_3_2;
    public static String reportIdFor9_1;
    public static String reportIdFor3_2;
    
    
	 public static void createTaxonomy(String token, String reportId, String dataCollectionId) {
	        RestAssured.baseURI = "https://qa.daato.app";

	        String endpoint = "/api/project-group/taxonomy/" + reportId + "/dataCollection/" + dataCollectionId + "/entity/my_taxonomy";
	        
	        
	        System.out.println("Calling URL: " + RestAssured.baseURI + endpoint);

	        String payload = "{\n" +
	                "  \"name\": \"Automated9.1\",\n" +
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

	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .when()
	                .post(endpoint);

	        // Print response and status
	        System.out.println("Status Code: " + response.getStatusCode());
	        System.out.println("Response Body: " + response.getBody().asString());

	        // Assert 201 status
	        if (response.getStatusCode() == 201) {
	            System.out.println("✅ Entity created successfully.");
	        } else {
	            System.out.println("❌ Failed to create entity.");
	        }
	    }
	
	
	 public static void createSecondTaxonomy(String token, String reportId, String dataCollectionId) {
	        RestAssured.baseURI = "https://qa.daato.app";

	        String endpoint = "/api/project-group/taxonomy/" + reportId +
	                          "/dataCollection/" + dataCollectionId +
	                          "/entity/my_taxonomy";

	        // 🔍 Print full request URL
	        System.out.println("Calling URL: " + RestAssured.baseURI + endpoint);

	        String payload = "{\n" +
	                "  \"name\": \"Automated3.2\",\n" +
	                "  \"economicActivity\": \"3.2\",\n" +
	                "  \"availableEnvironmentalCriteria\": [\"Climate mitigation\"],\n" +
	                "  \"environmentalCriteria\": \"Climate mitigation\",\n" +
	                "  \"relatedActivities\": [\n" +
	                "    {\n" +
	                "      \"activityId\": \"9.1_3.2\",\n" +
	                "      \"activityName\": \"Manufacture of equipment for the production and use of hydrogen\",\n" +
	                "      \"environmentalCriteria\": \"Climate mitigation\"\n" +
	                "    }\n" +
	                "  ]\n" +
	                "}";

	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .log().all() // Logs request
	                .when()
	                .post(endpoint)
	                .then()
	                .log().all() // Logs response
	                .extract()
	                .response();

	        System.out.println("Status Code: " + response.getStatusCode());
	        System.out.println("Response Body: " + response.getBody().asString());

	        if (response.getStatusCode() == 201) {
	            System.out.println("✅ Taxonomy created successfully.");
	        } else {
	            System.out.println("❌ Failed to create taxonomy.");
	        }
	    }
	 
	 
	 public static void fetchSafeguardIds(String token, String reportId, String dataCollectionId) {
		    String url = "https://qa.daato.app/api/project-group/taxonomy/" + reportId +
		                 "/dataCollection/" + dataCollectionId + "/entity/my_taxonomy";

		    System.out.println("Calling URL: " + url);

		    Response response = RestAssured.given()
		            .header("Authorization", "Bearer " + token)
		            .when()
		            .get(url)
		            .then()
		            .statusCode(200)
		            .extract()
		            .response();

		    String jsonString = response.getBody().asString();
		    JsonPath jsonPath = new JsonPath(jsonString);

		    int size = jsonPath.getList("").size();
		    for (int i = 0; i < size; i++) {
		        String economicActivity = jsonPath.getString("[" + i + "].economicActivity");

		        if ("9.1_3.2".equals(economicActivity)) {
		            safeguardFor_9_1_3_2 = jsonPath.getString("[" + i + "].minimumSocialSafeguards");
		            idFor_9_1_3_2 = jsonPath.getString("[" + i + "]._id");
		        } else if ("3.2".equals(economicActivity)) {
		            safeguardFor_3_2 = jsonPath.getString("[" + i + "].minimumSocialSafeguards");
		            idFor_3_2 = jsonPath.getString("[" + i + "]._id");
		        }
		    }

		    System.out.println("✅ Extracted Values:");
		    System.out.println("Minimum Safeguard for 9.1_3.2: " + safeguardFor_9_1_3_2);
		    System.out.println("_id for 9.1_3.2: " + idFor_9_1_3_2);
		    System.out.println("Minimum Safeguard for 3.2: " + safeguardFor_3_2);
		    System.out.println("_id for 3.2: " + idFor_3_2);
		}
	 
	 
	 
	 
	 public static void fetchReportIds(String token, String taxonomyId, String dataCollectionId) {
	        String url = "https://qa.daato.app/api/project-group/taxonomy/" + taxonomyId +
	                     "/dataCollection/" + dataCollectionId + "/entity/my_taxonomy";

	        Response response = RestAssured.given()
	                .header("Authorization", "Bearer " + token)
	                .get(url);

	        if (response.getStatusCode() != 200) {
	            System.err.println("❌ Failed. Status code: " + response.getStatusCode());
	            return;
	        }

	        String json = response.getBody().asString();
	        JsonPath jp = new JsonPath(json);

	        // Use filters to extract values based on economicActivity
	        reportIdFor9_1 = jp.getString("find { it.economicActivity == '9.1_3.2' }.environmentalCriteriaReportId");
	        reportIdFor3_2 = jp.getString("find { it.economicActivity == '3.2' }.environmentalCriteriaReportId");

	        System.out.println("✅ environmentalCriteriaReportId for 9.1_3.2: " + reportIdFor9_1);
	        System.out.println("✅ environmentalCriteriaReportId for 3.2: " + reportIdFor3_2);

	        // Now you can return or use these as needed
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

	    
}

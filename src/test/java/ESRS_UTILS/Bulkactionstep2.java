package ESRS_UTILS;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;



public class Bulkactionstep2 {
	
	
	public static boolean updateDataPointDefinitions(String token, String reportId) {
	    System.out.println("Token: " + token);
	    System.out.println("Report ID: " + reportId);

	    RestAssured.baseURI = "https://qa.daato.app";

	    String payload = "{\n" +
	            "  \"dataPointDefinitions\": [\n" +
	            "    {\n" +
	            "      \"id\": \"v5E169\",\n" +
	            "      \"category\": \"voluntary\",\n" +
	            "      \"included\": false,\n" +
	            "      \"aggregated\": false,\n" +
	            "      \"justification\": \"Test\",\n" +
	            "      \"isSubDataPoint\": false\n" +
	            "    },\n" +
	            "    {\n" +
	            "      \"id\": \"v5E1630\",\n" +
	            "      \"category\": \"voluntary,phase-in\",\n" +
	            "      \"included\": false,\n" +
	            "      \"aggregated\": false,\n" +
	            "      \"justification\": \"Test\",\n" +
	            "      \"isSubDataPoint\": false\n" +
	            "    }\n" +
	            "  ]\n" +
	            "}";

	    int maxAttempts = 6;
	    int delayMs = 5000; // 5 seconds

	    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
	        System.out.println("🔁 Attempt " + attempt + " to update data point definitions...");

	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .when()
	                .put("/api/esrs/disclosure-reporting/" + reportId + "/datapoint-definitions");

	        System.out.println("Response Status Code: " + response.getStatusCode());
	        System.out.println("Response Body: " + response.getBody().asString());

	        if (response.getStatusCode() == 200) {
	            List<Map<String, Object>> dataPoints = response.jsonPath().getList("$");

	            for (Map<String, Object> dataPoint : dataPoints) {
	                if ("v5E169".equals(dataPoint.get("id"))) {
	                    Boolean included = (Boolean) dataPoint.get("included");
	                    System.out.println("✅ Included value for v5E169: " + included);
	                    return included;
	                }
	            }

	            throw new RuntimeException("❌ Datapoint with id 'v5E169' not found in response.");
	        } else {
	            System.out.println("❌ Failed attempt " + attempt + ". Waiting before retry...");
	            try {
	                Thread.sleep(delayMs);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    }

	    throw new RuntimeException("❌ All retry attempts failed to update datapoint definitions for report ID: " + reportId);
	}
	 
	 
	 
	 
	 public static void markE17nonmateridal(String token, String reportId) {
	        RestAssured.baseURI = "https://qa.daato.app";

	        String payload = "[\n" +
	                "  {\n" +
	                "    \"entityId\": \"ESRS-E1-Climate-Change-Disclosure-E1-7\",\n" +
	                "    \"includedIn\": false,\n" +
	                "    \"message\": \"Automatedmarkassafe\",\n" +
	                "    \"isDisclosure\": true,\n" +
	                "    \"markAsNonMaterial\": true,\n" +
	                "    \"noInfoToDisclose\": false,\n" +
	                "    \"excludeReason\": \"nonMaterial\",\n" +
	                "    \"reportingType\": \"\",\n" +
	                "    \"isCustom\": false\n" +
	                "  }\n" +
	                "]";

	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .when()
	                .put("/api/esrs/disclosure-reporting/" + reportId + "/bulk-update-disclosures")
	                .then()
	                .statusCode(200)
	                .extract()
	                .response();

	        // Parse response
	        boolean ok = response.jsonPath().getBoolean("ok");
	        String value = response.jsonPath().getString("value");

	        System.out.println("Response: ok=" + ok + ", value=" + value);

	        // Assert response values
	        assertEquals(true, ok, "❌ Expected 'ok' to be true");
	        assertEquals("updated-success", value, "❌ Expected 'value' to be 'updated-success'");
	    } 
	 
	 
	 
	 
	 public static void completestep1(String token, String urlId) {
	        RestAssured.baseURI = "https://qa.daato.app";

	        // Construct the endpoint URL
	        String endpoint = "/api/esrs/disclosure-reporting/" + urlId + "/step";

	        // Define the payload
	        String payload = "{\n" +
	                "  \"stepOne\": \"completed\",\n" +
	                "  \"stepTwo\": \"inProgress\",\n" +
	                "  \"stepThree\": \"locked\",\n" +
	                "  \"stepFour\": \"locked\"\n" +
	                "}";

	        // Send the PATCH request
	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .when()
	                .put(endpoint)
	                .then()
	                .statusCode(200)
	                .extract()
	                .response();

	        // Assert response message
	        String actualMessage = response.asString();
	        System.out.println("Response: " + actualMessage);

	        assertEquals("updated-success", actualMessage, "The response message is not as expected.");
	    }
	 
	    public static void aggregatedatapoints(String token, String urlId, String parentEntityId, String childEntityId) throws InterruptedException {
	    	
	    	 Thread.sleep(1000);
	        RestAssured.baseURI = "https://qa.daato.app";

	        String endpoint = "/api/esrs/disclosure-reporting/" + urlId + "/datapoint-definitions";

	        String includedEntities = "[\"" + parentEntityId + "\",\"" + childEntityId + "\"]";

	        // List of all datapoint IDs
	        String[] dataPointIds = {
	            "v5E1530", "v5E152", "v5E153", "v5E154Calculated", "v5E155", "v5E156", "v5E157", "v5E158", "v5E159Calculated",
	            "v5E1510", "v5E1511", "v5E1512", "v5E1513", "v5E1514", "v5E1515", "v5E1516Calculated", "v5E1517",
	            "v5E1521", "v5E1522", "v5E1523", "v5E1524", "v5E1525", "v5E1526", "v5E1527", "v5E1528", "v5E1529"
	        };

	        // Some IDs have "category": "voluntary"
	        String[] voluntaryIds = {"v5E1523", "v5E1524"};

	        StringBuilder payloadBuilder = new StringBuilder("{ \"dataPointDefinitions\": [");

	        for (int i = 0; i < dataPointIds.length; i++) {
	            String id = dataPointIds[i];
	            payloadBuilder.append("{");
	            payloadBuilder.append("\"id\":\"").append(id).append("\",");
	            if (isVoluntary(id, voluntaryIds)) {
	                payloadBuilder.append("\"category\":\"voluntary\",");
	            }
	            payloadBuilder.append("\"included\":true,");
	            payloadBuilder.append("\"aggregated\":true,");
	            payloadBuilder.append("\"aggregationScope\":{\"scope\":\"entities\",\"included\":").append(includedEntities).append("},");
	            payloadBuilder.append("\"isSubDataPoint\":false");
	            payloadBuilder.append("}");
	            if (i < dataPointIds.length - 1) {
	                payloadBuilder.append(",");
	            }
	        }

	        payloadBuilder.append("]}");

	        String payload = payloadBuilder.toString();

	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .when()
	                .put(endpoint)
	                .then()
	                .extract()
	                .response();

	        assertEquals(200, response.statusCode(), "Expected status code 200 for datapoint definitions update");
	        System.out.println("Datapoint definitions updated successfully.");
	    }

	    private static boolean isVoluntary(String id, String[] voluntaryIds) {
	        for (String voluntaryId : voluntaryIds) {
	            if (voluntaryId.equals(id)) return true;
	        }
	        return false;
	    }
	 
	    public static void completestep2(String token, String reportId) {
	        String url = "https://qa.daato.app/api/esrs/disclosure-reporting/" + reportId + "/step";

	        String payload = "{"
	            + "\"stepOne\":\"completed\","
	            + "\"stepTwo\":\"completed\","
	            + "\"stepThree\":\"notStarted\","
	            + "\"stepFour\":\"locked\""
	            + "}";

	        Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .body(payload)
	            .when()
	            .put(url)
	            .then()
	            .statusCode(200)
	            .extract()
	            .response();

	        // Assert the response message
	        String actualMessage = response.asString();
	        System.out.println("Response: " + actualMessage);

	        assertEquals("updated-success", actualMessage, "The response message is not as expected.");
	    }

	    
	    
	    
	    public static void startReport(String token, String reportId) {
	        String url = "https://qa.daato.app/api/esrs/disclosure-reporting/" + reportId + "/start";

	        String payload = "{"
	            + "\"dueDate\":\"2025-12-12T11:40:24.843Z\","
	            + "\"message\":\"\""
	            + "}";

	        Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .body(payload)
	            .when()
	            .post(url)
	            .then()
	            .statusCode(201)
	            .extract()
	            .response();

	        // Optional: Validate message or success flag if present
	        boolean ok = response.jsonPath().getBoolean("ok");
	        String value = response.jsonPath().getString("value");

	        System.out.println("Response: ok=" + ok + ", value=" + value);

	        // Assert response values
	        assertEquals(true, ok, "❌ Expected 'ok' to be true");
	        assertEquals("report-started", value, "❌ Expected 'value' to be 'report-started'");
	    }    
	    
	    
	    
	    public static String getDataCollectionId(String token, String reportId) {
	        String url = "https://qa.daato.app/api/esrs/disclosure-reporting/" + reportId + "?esrsLite=standards";

	        Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .when()
	            .get(url)
	            .then()
	            .statusCode(200)
	            .extract()
	            .response();

	        return response.jsonPath().getString("dataCollectionId");
	    }    
	    
	    
	    
	    public static String getEntityDataCollectionId(String token, String id) {
	        // Build the full URL
	        String url = "https://qa.daato.app/api/esrs/disclosure-reporting/data-collection-workflows/" + id;
	        
	        // Make the GET request
	        Response response = RestAssured
	                .given()
	                .header("Authorization", "Bearer " + token)
	                .get(url)
	                .then()
	                .extract()
	                .response();
	        System.out.println("Response Body: " + response.getBody().asString());
	        JsonPath jsonPath = response.jsonPath();

	        // Get list of entities
	        List<Map<String, Object>> entities = jsonPath.getList("entities");

	        for (Map<String, Object> entity : entities) {
	            Object reports = entity.get("entityReports");

	            if (reports instanceof Map) {
	                Map<?, ?> entityReports = (Map<?, ?>) reports;
	                Object dataCollectionId = entityReports.get("esrs-entity-data-collection");

	                if (dataCollectionId != null) {
	                    return dataCollectionId.toString(); // ✅ Clean, safe
	                }
	            }
	        }

	        return null;
	    }
	    public static String getEntityDataCollectionIdparent(String token, String id) {
	        // Build the full URL
	        String url = "https://qa.daato.app/api/esrs/disclosure-reporting/data-collection-workflows/" + id;

	        // Make the GET request
	        Response response = RestAssured
	                .given()
	                .header("Authorization", "Bearer " + token)
	                .get(url)
	                .then()
	                .extract()
	                .response();

	        System.out.println("Response Body: " + response.getBody().asString());

	        JsonPath jsonPath = response.jsonPath();

	        // Get list of entities
	        List<Map<String, Object>> entities = jsonPath.getList("entities");

	        for (Map<String, Object> entity : entities) {
	            Object reportsObj = entity.get("entityReports");

	            if (reportsObj instanceof Map<?, ?>) {
	                Map<?, ?> entityReports = (Map<?, ?>) reportsObj;
	                Object summaryIdObj = entityReports.get("esrs-entity-summary");

	                if (summaryIdObj != null) {
	                    return summaryIdObj.toString(); // Return as string
	                }
	            }
	        }

	        return null; 
	    
	    }
}

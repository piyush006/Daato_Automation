package DMUTILS;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Checkresponsenonmaterial {
	
	
	
	
	public static Boolean getDefaultMaterialForEnergy(String token, String reportId) {
		RestAssured.baseURI = "https://qa.daato.app";

	    Response response = given()
	        .header("Authorization", "Bearer " + token)
	        .header("Content-Type", "application/json")
	        .when()
	        .get("/api/esrs/double-materiality/" + reportId + "/step/scope/esg-type/environmental")
	        .then()
	        .statusCode(200)
	        .extract().response();

	    JsonArray rootArray = JsonParser.parseString(response.asString()).getAsJsonArray();

	    for (JsonElement groupElement : rootArray) {
	        JsonObject groupObj = groupElement.getAsJsonObject();
	        JsonArray issuesArray = groupObj.getAsJsonArray("issues");

	        for (JsonElement issueElement : issuesArray) {
	            JsonObject issue = issueElement.getAsJsonObject();
	            String issueId = issue.get("issueId").getAsString();
	            System.out.println("Found issueId: " + issueId);  // For debugging

	            if ("esrs-e1-energy".equals(issueId)) {
	                return issue.get("defaultMaterial").getAsBoolean();
	            }
	        }
	    }

	    // Not found
	    return null;
	
	
	
	}
}

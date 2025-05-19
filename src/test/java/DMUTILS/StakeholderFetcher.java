package DMUTILS;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;




public class StakeholderFetcher {
	
	
	
	public static class Stakeholder {
        public String id;
        public String name;

        public Stakeholder(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static List<Stakeholder> getStakeholdersByGroupId(String token, String groupId) {
        RestAssured.baseURI = "https://qa.daato.app";

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .get("/api/esrs/stakeholder/groups?type=internal")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonArray rootArray = JsonParser.parseString(response.asString()).getAsJsonArray();
        List<Stakeholder> result = new ArrayList<>();

        for (JsonElement groupElement : rootArray) {
            JsonObject groupObj = groupElement.getAsJsonObject();
            if (groupObj.get("_id").getAsString().equals(groupId)) {
                JsonArray stakeholdersArray = groupObj.getAsJsonArray("stakeholders");
                for (JsonElement stakeholderElement : stakeholdersArray) {
                    JsonObject stakeholder = stakeholderElement.getAsJsonObject();
                    String id = stakeholder.get("_id").getAsString();
                    String name = stakeholder.get("name").getAsString();
                    result.add(new Stakeholder(id, name));
                }
                break; // no need to check other groups
            }
        }

        return result;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package DMUTILS;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Createstack {
	
	static String stakeholderemail;
	
    public static void createStakeholder(String token, String stakeHolderGroupId) {
        String baseUrl = "https://qa.daato.app";
        String endpoint = "/api/esrs/stakeholder";

        // Generate a timestamp-based unique suffix
        String uniqueSuffix = String.valueOf(System.currentTimeMillis());

        // Generate unique name and email
        String uniqueName = "StakeholderAuto_" + uniqueSuffix;
        String uniqueEmail = "piyush" + uniqueSuffix + "@yopmail.com";

        // Build JSON payload with dynamic values
        String payload = "{"
                + "\"name\":\"" + uniqueName + "\","
                + "\"type\":\"internal\","
                + "\"userEmail\":\"" + uniqueEmail + "\","
                + "\"organization\":\"\","
                + "\"stakeHolderGroupId\":\"" + stakeHolderGroupId + "\""
                + "}";

        RestAssured.baseURI = baseUrl;

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(payload)
            .when()
                .post(endpoint)
            .then()
                .statusCode(201)
                .extract()
                .response();
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Stakeholder created:");
        System.out.println("Name: " + uniqueName);
        System.out.println("Email: " + uniqueEmail);
        
        stakeholderemail =uniqueEmail;
        
        PropertyUtilWriter.writeProperty("stakeholdermail", stakeholderemail);
    }
}




package ESRS_UTILS;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Creatuser {

	
	
	 public static Map<String, String> createparentuser(String token) {
	        RestAssured.baseURI = "https://qa.daato.app";

	        // Generate a random 4-digit number
	        Random random = new Random();
	        int randomNumber = random.nextInt(10000);  // Generates a number between 0 and 9999

	        // Ensure the number is always 4 digits (padded with leading zeros if needed)
	        String randomDigits = String.format("%04d", randomNumber);

	        // Create the email and firstName using the random number
	        String email = "Automatedesrsparent" + randomDigits + "@yopmail.com";
	        String firstName = "Automatedparent" + randomDigits;

	        // Create the payload with the generated email and first name
	        String payload = "{\n" +
	                "  \"email\": \"" + email + "\",\n" +
	                "  \"roleNames\": [\"esrs_entity_manager\"],\n" +
	                "  \"firstName\": \"" + firstName + "\",\n" +
	                "  \"lastName\": \"parent\"\n" +
	                "}";

	        // Send the request and get the response
	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .when()
	                .post("/api/users")
	                .then()
	                .statusCode(201)
	                .extract()
	                .response();

	        String userId = response.jsonPath().getString("user_id");

	        System.out.println("User created -> user_id: " + userId + ", email: " + email + ", firstName: " + firstName);

	        // Return both values in a map
	        Map<String, String> result = new HashMap<>();
	        result.put("user_id", userId);
	        result.put("email", email);

	        return result;
	    }	
	
	 
	    public static String createparentEntity(String token, String userId) {
	    	
	    	     RestAssured.baseURI = "https://qa.daato.app";
	    	     
	    	     Random random = new Random();
	 	        int randomNumber = random.nextInt(10000);  // Generates a number between 0 and 9999

	 	        // Ensure the number is always 4 digits (padded with leading zeros if needed)
	 	        String randomDigits = String.format("%04d", randomNumber);

	 	        String Name = "Automatedesrsparent" + randomDigits;

	        // Construct the payload dynamically
	        String payload = "{\n" +
	                "  \"name\": \"" + Name + "\",\n" +
	                "  \"labels\": [],\n" +
	                "  \"assignments\": [\n" +
	                "    {\n" +
	                "      \"userID\": \"" + userId + "\",\n" +
	                "      \"module\": \"esrs\",\n" +
	                "      \"position\": \"manager\"\n" +
	                "    }\n" +
	                "  ],\n" +
	                "  \"parentID\": \"\",\n" +
	                "  \"internalID\": \"\",\n" +
	                "  \"dataProvidersIds\": [],\n" +
	                "  \"logoUrl\": \"\",\n" +
	                "  \"logoFileName\": \"\"\n" +
	                "}";

	        // Make the POST request
	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .when()
	                .post("/api/reporting-structure/entities")
	                .then()
	                .statusCode(201)
	                .extract()
	                .response();

	        // Extract the _id from the response
	        String entityId = response.jsonPath().getString("_id");

	        System.out.println("Entity created -> _id: " + entityId);

	        return entityId;
	    }
	
	    
	    
	    public static Map<String, String> createchilduser(String token) {
	        RestAssured.baseURI = "https://qa.daato.app";

	        // Generate a random 4-digit number
	        Random random = new Random();
	        int randomNumber = random.nextInt(10000);  // Generates a number between 0 and 9999

	        // Ensure the number is always 4 digits (padded with leading zeros if needed)
	        String randomDigits = String.format("%04d", randomNumber);

	        // Create the email and firstName using the random number
	        String email = "Automatedesrschild" + randomDigits + "@yopmail.com";
	        String firstName = "Automatedchild" + randomDigits;

	        // Create the payload with the generated email and first name
	        String payload = "{\n" +
	                "  \"email\": \"" + email + "\",\n" +
	                "  \"roleNames\": [\"esrs_entity_manager\"],\n" +
	                "  \"firstName\": \"" + firstName + "\",\n" +
	                "  \"lastName\": \"parent\"\n" +
	                "}";

	        // Send the request and get the response
	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .when()
	                .post("/api/users")
	                .then()
	                .statusCode(201)
	                .extract()
	                .response();

	        String userId = response.jsonPath().getString("user_id");

	        System.out.println("User created -> user_id: " + userId + ", email: " + email + ", firstName: " + firstName);

	        // Return both values in a map
	        Map<String, String> result = new HashMap<>();
	        result.put("user_id", userId);
	        result.put("email", email);

	        return result;
	    }	
	    
	    
	    
	    public static String createChildEntity(String token, String userId, String parentId) {
	        RestAssured.baseURI = "https://qa.daato.app";

	        // Generate a random 4-digit number for uniqueness
	        Random random = new Random();
	        int randomNumber = random.nextInt(10000);
	        String randomDigits = String.format("%04d", randomNumber);

	        // Create a unique name for the child entity
	        String name = "Automatedesrschild" + randomDigits;

	        // Construct the payload dynamically
	        String payload = "{\n" +
	                "  \"name\": \"" + name + "\",\n" +
	                "  \"labels\": [],\n" +
	                "  \"assignments\": [\n" +
	                "    {\n" +
	                "      \"userID\": \"" + userId + "\",\n" +
	                "      \"module\": \"esrs\",\n" +
	                "      \"position\": \"manager\"\n" +
	                "    }\n" +
	                "  ],\n" +
	                "  \"parentID\": \"" + parentId + "\",\n" +
	                "  \"internalID\": \"\",\n" +
	                "  \"dataProvidersIds\": [],\n" +
	                "  \"logoUrl\": \"\",\n" +
	                "  \"logoFileName\": \"\"\n" +
	                "}";

	        // Send the POST request
	        Response response = given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .when()
	                .post("/api/reporting-structure/entities")
	                .then()
	                .statusCode(201)
	                .extract()
	                .response();

	        // Extract and return the _id from the response
	        String entityId = response.jsonPath().getString("_id");

	        System.out.println("Child entity created -> _id: " + entityId);

	        return entityId;
	    }	    
	    
	   
	    
	    
	    
	
}

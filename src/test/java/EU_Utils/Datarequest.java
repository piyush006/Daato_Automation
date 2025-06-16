package EU_Utils;


import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import static io.restassured.RestAssured.given;
public class Datarequest {
	
	
	
	public static String createUser(String token) {
        // Generate random 3-digit number
        int randomDigits = new Random().nextInt(900) + 100;
        String firstName = "EUDataprovider" + randomDigits;
        String email = firstName + "@yopmail.com";
        
        
        PropertyutilwriterEU.writeProperty("dataprovideremail", email);

        // Set base URI
        RestAssured.baseURI = "https://qa.daato.app/api";

        // Create payload
        String payload = String.format(
            "{\"email\":\"%s\",\"roleNames\":[\"contributor\"],\"firstName\":\"%s\",\"lastName\":\"provider\"}",
            email, firstName
        );

        // Send POST request
        Response response = given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .body(payload)
            .when()
            .post("/users")
            .then()
            .statusCode(201)
            .extract()
            .response();

        // Extract user_id from response
        String userId = response.jsonPath().getString("user_id");

        System.out.println("User created:");
        System.out.println("Email: " + email);
        System.out.println("User ID: " + userId);

        return userId;
    }	
	
	
	
	public static void sendRequest(String token, String reportIdInUrl, String moduleIdInUrl, String reportIdInPayload, String contributorId) {
        RestAssured.baseURI = "https://qa.daato.app";

        String url = String.format("/api/request?pagesPath=reports/%s/my_taxonomy/mss/%s&module=eu-taxonomy", reportIdInUrl, moduleIdInUrl);

        // Generate future due date in ISO format
        String dueDate = ZonedDateTime.now().plusDays(7).format(DateTimeFormatter.ISO_INSTANT);

        String payload = "{"
                + "\"title\": \"Have you adopted and embedded a commitment to incorporate a human rights due diligence process into your policies and procedures?\","
                + "\"reportID\": \"" + reportIdInPayload + "\","
                + "\"pageID\": \"main\","
                + "\"contributors\": [\"" + contributorId + "\"],"
                + "\"dueDate\": \"" + dueDate + "\","
                + "\"message\": \"AutomatedRequest\","
                + "\"dataPointIDs\": [\"mss1\"]"
                + "}";

        Response response = given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .body(payload)
            .when()
            .post(url)
            .then()
            .statusCode(201)
            .extract()
            .response();

        System.out.println("✅ Request created successfully");
        System.out.println("📦 Response: " + response.asPrettyString());
    }
	
	public static void acceptRequest(String token, String requestId) {
        String url = "https://qa.daato.app/api/request/" + requestId + "/accept";

        Response response = given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
        .when()
            .post(url)
        .then()
           // .statusCode(201)
            .extract()
            .response();

        System.out.println("Response status: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
    }
	
	
	
	

}

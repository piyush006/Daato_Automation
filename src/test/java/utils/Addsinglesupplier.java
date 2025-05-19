package utils;

import java.util.Random;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Addsinglesupplier {

    static String name;
    static String defaultContactEmail;
    static String defaultContactName;

    public static Response addsinglesupplier(String Token) {

        name = "Test_" + generateRandomString(4);
        defaultContactName = "User_" + generateRandomString(4);
        defaultContactEmail = "piyush.soni+" + generateRandomString(4) + "@47billion.com";

        String endpoint = "https://qa.daato.app/api/supplier";

        String payload = String.format(
            "{\"name\":\"%s\",\"defaultContactEmail\":\"%s\",\"defaultContactName\":\"%s\",\"internalID\":\"random\",\"countryCodes\":[\"AF\"],\"productCodes\":[\"00\"],\"cocAgreement\":\"missing\"}",
            name, defaultContactEmail, defaultContactName
        );

        Response response = RestAssured
            .given()
                .header("Authorization", "Bearer " + Token)
                .header("Content-Type", "application/json")
                .body(payload)
            .when()
                .post(endpoint)
            .then()
                .statusCode(201)  // Adjust if a different code is expected
                .extract()
                .response();

        
        System.out.println("Response: " + response.asPrettyString());

        return response;
    }

    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(rand.nextInt(characters.length())));
        }
        return result.toString();
    }
    
    public static void sendcoc(String supplierid,String Token) {
    	
    	
    	String endpoint = "https://qa.daato.app/api/supplier/coc";

        // Inject supplierid dynamically into the JSON payload
        String payload = "{"
            + "\"suppliers\":[\"" + supplierid + "\"],"
            + "\"title\":\"Please accept the Code of Conduct\","
            + "\"message\":\"Internal QA is asking you to agree to the Code of Conduct. This is to provide contractual assurances aligned with the requirements of the German Supply Chain Due Diligence Act. For more information, you can refer to the guidance.\","
            + "\"dueDate\":\"2025-12-30T10:22:03.768Z\""
            + "}";

        Response response = RestAssured
            .given()
                .header("Authorization", "Bearer " + Token)
                .header("Content-Type", "application/json")
                .body(payload)
            .when()
                .post(endpoint)
            .then()
                .statusCode(201)  // Adjust if needed
                .extract()
                .response();

        System.out.println("Response: " + response.asPrettyString());
    	
    	
    	
    }
    
    public static Response getcocid(String supplierid, String Token) {

        // Use supplierid in the endpoint
        String endpoint = "https://qa.daato.app/api/risk/suppliers/" + supplierid;

        Response response = RestAssured
            .given()
                .header("Authorization", "Bearer " + Token)
                .header("Content-Type", "application/json")
            .when()
                .get(endpoint)
            .then()
                .statusCode(200)  // Use 200 for GET success unless 201 is expected
                .extract()
                .response();

     //   System.out.println("Response: " + response.asPrettyString());

        return response;
    }
    
    
public static void resendcocnotification(String requestId,String Token) {
    	
    	
	String endpoint = "https://qa.daato.app/api/request/" + requestId + "/resend";

        // Inject supplierid dynamically into the JSON payload
       

        Response response = RestAssured
            .given()
                .header("Authorization", "Bearer " + Token)
                .header("Content-Type", "application/json")
            .when()
                .post(endpoint)
            .then()
                .statusCode(201)  // Adjust if needed
                .extract()
                .response();

        System.out.println("Response: " + response.asPrettyString());
    	
    	
    	
    }
     
    
    
    
    	
    	
}
    

    
    
    
    
    
    

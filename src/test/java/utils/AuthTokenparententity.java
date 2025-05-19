package utils;

import static io.restassured.RestAssured.given;

import ESRS_UTILS.PropertyUtilReaderESRS;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthTokenparententity {
	
	
static String Email;
	
	private static String cachedToken;
    private static long expiryTimeEpochMillis = 0;  // epoch time in ms

    public static String getparenttoken() {
    	
    	Email=PropertyUtilReaderESRS.parentemail();
        long now = System.currentTimeMillis();
        
        if (cachedToken == null || now >= expiryTimeEpochMillis) {
            RestAssured.baseURI = "https://auth.daato.app";

            Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("username", Email)
                .formParam("password", "12")
                .formParam("grant_type", "password")
                .formParam("client_id", "daato-api")
                .formParam("client_secret", "CLz0Px7KhWNs5nfCeQ5LgTGLJexGz3lD")
            .when()
                .post("/realms/qa/protocol/openid-connect/token")
            .then()
                .statusCode(200)
                .extract().response();

            cachedToken = response.jsonPath().getString("access_token");
            int expiresIn = response.jsonPath().getInt("expires_in"); // in seconds

            // Set expiry time to now + expiresIn (converted to milliseconds)
            expiryTimeEpochMillis = now + (expiresIn * 1000L);

            System.out.println("Fetched new token. Valid for " + (expiresIn / 60) + " minutes.");
        }

        return cachedToken;
    }	
	
	
	
	
	
	
	
	

}

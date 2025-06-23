package EU_Utils;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Completestep {
	
	
	
	
	
	public static void updateSteps(String token, String id) {
        String url = "https://qa.daato.app/api/eu-taxonomy/" + id;

        String[] payloads = {
            "{\"step\":{\"eligibility\":\"complete\"}}",
            "{\"step\":{\"mss\":\"complete\"}}",
            "{\"step\":{\"alignment\":\"complete\"}}", 
            "{\"step\":{\"financialInformation\":\"complete\"}}",
            "{\"step\":{\"analytics\":\"complete\"}}"
        };

        for (String payload : payloads) {
            System.out.println("PUT -> " + url);
            System.out.println("Payload -> " + payload);

            Response response = RestAssured
                    .given()
                    .header("Authorization", "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .put(url)
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();

            System.out.println("Status Code: " + response.getStatusCode());
        }
    }

}

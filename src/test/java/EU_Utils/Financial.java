package EU_Utils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Financial {
	
	
	
	
	
	
	public static void updateStatus(String token, String id) {
        String url = "https://qa.daato.app/api/eu-financial-information/update-status/" + id;
        String payload = "{\"entityId\":\"my_taxonomy\",\"mode\":\"simple\"}";

        System.out.println("PUT -> " + url);

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
	
	
	public static void sendFinancialInformation(String token, String id) {
        String url = "https://qa.daato.app/api/eu-financial-information/update-financial-information/" + id;

        String[] payloads = {
            "{\"financialInformation\":{\"transactionType\":\"CAPEX\",\"amountEur\":1000},\"entityId\":\"my_taxonomy\"}",
            "{\"financialInformation\":{\"transactionType\":\"OPEX\",\"amountEur\":2000},\"entityId\":\"my_taxonomy\"}",
            "{\"financialInformation\":{\"transactionType\":\"Turnover\",\"amountEur\":3000},\"entityId\":\"my_taxonomy\"}"
        };

        for (String payload : payloads) {
            System.out.println("POST -> " + url);
            System.out.println("Payload -> " + payload);

            Response response = RestAssured
                    .given()
                    .header("Authorization", "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post(url)
                    .then()
                    .statusCode(201)
                    .extract()
                    .response();

            System.out.println("Status Code: " + response.getStatusCode());
        }
    }
	
	
	
	
	public static void sendFinancialInformation92(String token, String id, String projectId) {
        String url = "https://qa.daato.app/api/eu-financial-information/update-financial-information/" + id;

        String[] payloads = {
            String.format("{\"financialInformation\":{\"transactionType\":\"CAPEX\",\"amountEur\":400},\"entityId\":\"my_taxonomy\",\"projectId\":\"%s\"}", projectId),
            String.format("{\"financialInformation\":{\"transactionType\":\"OPEX\",\"amountEur\":500},\"entityId\":\"my_taxonomy\",\"projectId\":\"%s\"}", projectId),
            String.format("{\"financialInformation\":{\"transactionType\":\"Turnover\",\"amountEur\":600},\"entityId\":\"my_taxonomy\",\"projectId\":\"%s\"}", projectId)
        };

        for (String payload : payloads) {
            System.out.println("POST -> " + url);
            System.out.println("Payload -> " + payload);

            Response response = RestAssured
                    .given()
                    .header("Authorization", "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post(url)
                    .then()
                    .statusCode(201)
                    .extract()
                    .response();

            System.out.println("Status Code: " + response.getStatusCode());
        }
    }
	
	
	
	
	

}

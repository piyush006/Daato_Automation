package EU_Utils;

import java.util.Random;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Createreport {
	
	
	
	public static String[] createTaxonomy(String token) {
        RestAssured.baseURI = "https://qa.daato.app";

        // Generate unique name like "Automatedparent1234"
        String randomSuffix = String.format("%04d", new Random().nextInt(10000));
        String uniqueName = "Autop" + randomSuffix;

        String payload = "{\n" +
                "  \"name\": \"" + uniqueName + "\",\n" +
                "  \"year\": \"2025\",\n" +
                "  \"collectData\": \"no\"\n" +
                "}";

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/api/eu-taxonomy")
                .then()
                .extract()
                .response();

        int statusCode = response.getStatusCode();
      //  System.out.println("Status Code: " + statusCode);

        if (statusCode == 200 || statusCode == 201) {
            String taxonomyId = response.jsonPath().getString("_id");
            String dataCollectionId = response.jsonPath().getString("dataCollectionId");

            System.out.println("✅ Created taxonomy: " + uniqueName);
        //    System.out.println("taxonomyId: " + taxonomyId);
        //    System.out.println("dataCollectionId: " + dataCollectionId);

            return new String[]{taxonomyId, dataCollectionId};
        } else {
            System.err.println("❌ Failed to create taxonomy. Response: " + response.asString());
            return null;
        }
    }
	
	
	
	
	
	
	
	

}

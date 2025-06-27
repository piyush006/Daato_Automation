package EU_Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class Fillmsafguard {
	
	
	
	
	
	public static void submitAll(String token, String minimumSafeguardId, String reportId, String dataCollectionId) {

	    // List of all data points
	    String[] dataPoints = {
	        "mss1", "mss2", "mss3", "mss4", "mss5", "mss6",
	        "mss7-1", "mss8-1", "mss8-2", "mss9-1", "mss10-1", "mss10-2"
	    };

	    for (String dataPoint : dataPoints) {
	        // Determine the value: "no" for specific data points, otherwise "yes"
	        String value = (dataPoint.equals("mss9-1") || dataPoint.equals("mss7-1") || dataPoint.equals("mss8-2")) ? "no" : "yes";

	        // Build the endpoint URL
	        String url = "https://qa.daato.app/api/reports/" + minimumSafeguardId +
	                     "/dataPoint/" + dataPoint +
	                     "?pagesPath=" + reportId + "/my_taxonomy/mss/" + dataCollectionId;

	        // Build payload
	        String payload = "{\"value\":[\"" + value + "\"]}";

	        // Log request
	        System.out.println("\nPosting to: " + url);
	        System.out.println("Payload: " + payload);

	        // Make the request
	        Response response = RestAssured.given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .put(url);

	        // Handle response
	        int statusCode = response.getStatusCode();
	        System.out.println("Status Code: " + statusCode);
	        System.out.println("Response: " + response.getBody().asString());

	        // Validate status
	        if (statusCode != 200) {
	            System.err.println("❌ Failed for " + dataPoint + " — expected 200, got " + statusCode);
	        } else {
	            System.out.println("Success for " + dataPoint);
	        }
	    }
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



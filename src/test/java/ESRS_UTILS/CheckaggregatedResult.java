package ESRS_UTILS;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CheckaggregatedResult {
	
	
	static int expectedparentreportingvalue=50;
	static int expectedparentcomparativevalue=50;
	static int expectedchildreportingvalue=50;
	static int expectedchildcomparativevalue=50;
	static int expectedparentreportingvalue1=20;
	static int expectedparentcomparativevalue1=20;
	static int expectedchildreportingvalue1=20;
	static int expectedchildcomparativevalue1=20;
	
	
	
	
	public static void getAggregatedDataStatus(String token, String disclosureId) {
	    // Hardcoded Data Point ID
	    String dataPointId = "v5E152";

	    // Build the full URL
	    String url = "https://qa.daato.app/api/esrs/disclosure-reporting/" + disclosureId + "/aggregated-data-point/" + dataPointId;

	    // Send GET request
	    Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .get(url)
	            .then()
	            .statusCode(200)
	            .extract()
	            .response();

	    // Log full response
	 //   System.out.println("Response Body: " + response.getBody().asPrettyString());

	    // Parse JSON
	    JsonPath jsonPath = response.jsonPath();

	    // Extract required fields
	    String overallStatus = jsonPath.getString("status");
	    String Parententityname = jsonPath.getString("aggregatedData[0].entityName");
	    String aggregatedStatusparent = jsonPath.getString("aggregatedData[0].status");
	    Integer reportingValueparent = jsonPath.getInt("aggregatedData[0].dataPoint.value[0].reporting[0]");
	    Integer comparativeValueparent = jsonPath.getInt("aggregatedData[0].dataPoint.value[0].comparative[0]");
	    
	    
	    String childentityname = jsonPath.getString("aggregatedData[1].entityName");
	    String aggregatedStatuschild = jsonPath.getString("aggregatedData[1].status");
	    Integer reportingValuechild = jsonPath.getInt("aggregatedData[1].dataPoint.value[0].reporting[0]");
	    Integer comparativeValuechild = jsonPath.getInt("aggregatedData[1].dataPoint.value[0].comparative[0]");
	    

	    // Log extracted values
	    System.out.println("Overall Status: " + overallStatus);
	    
	    System.out.println("parententityname " + Parententityname);
	    System.out.println("Aggregated Status: " + aggregatedStatusparent);
	    System.out.println("Reporting Value: " + reportingValueparent);
	    System.out.println("Comparative Value: " + comparativeValueparent);
	    System.out.println("childentityname " + childentityname);
	    System.out.println("Aggregated Status child: " + aggregatedStatuschild);
	    System.out.println("Aggregated Status child: " + reportingValuechild);
	    System.out.println("Aggregated Status child: " + comparativeValuechild);
	    
	    
	  
	  
	    Assert.assertEquals(reportingValueparent, expectedparentreportingvalue);
	    Assert.assertEquals(reportingValuechild, expectedchildreportingvalue);
	    Assert.assertEquals(comparativeValueparent, expectedparentcomparativevalue);
	    Assert.assertEquals(comparativeValuechild, expectedchildcomparativevalue);
	    
	    
	    
	}	
	
	public static void getAggregatedDataStatuspercentage(String token, String disclosureId) {
	    // Hardcoded Data Point ID
	    String dataPointId = "v5E154Calculated";

	    // Build the full URL
	    String url = "https://qa.daato.app/api/esrs/disclosure-reporting/" + disclosureId + "/aggregated-data-point/" + dataPointId;

	    // Send GET request
	    Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .get(url)
	            .then()
	            .statusCode(200)
	            .extract()
	            .response();

	    // Log full response
	 //   System.out.println("Response Body: " + response.getBody().asPrettyString());

	    // Parse JSON
	    JsonPath jsonPath = response.jsonPath();

	    // Extract required fields
	    String overallStatus = jsonPath.getString("status");
	    String Parententityname = jsonPath.getString("aggregatedData[0].entityName");
	    String aggregatedStatusparent = jsonPath.getString("aggregatedData[0].status");
	    Integer reportingValueparent = jsonPath.getInt("aggregatedData[0].dataPoint.value[0].reporting[0]");
	    Integer comparativeValueparent = jsonPath.getInt("aggregatedData[0].dataPoint.value[0].comparative[0]");
	    
	    
	    String childentityname = jsonPath.getString("aggregatedData[1].entityName");
	    String aggregatedStatuschild = jsonPath.getString("aggregatedData[1].status");
	    Integer reportingValuechild = jsonPath.getInt("aggregatedData[1].dataPoint.value[0].reporting[0]");
	    Integer comparativeValuechild = jsonPath.getInt("aggregatedData[1].dataPoint.value[0].comparative[0]");
	    

	    // Log extracted values
	    System.out.println("Overall Status: " + overallStatus);
	    
	    System.out.println("parententityname " + Parententityname);
	    System.out.println("Aggregated Status: " + aggregatedStatusparent);
	    System.out.println("Reporting Value: " + reportingValueparent);
	    System.out.println("Comparative Value: " + comparativeValueparent);
	    System.out.println("childentityname " + childentityname);
	    System.out.println("Aggregated Status child: " + aggregatedStatuschild);
	    System.out.println("Aggregated Status child: " + reportingValuechild);
	    System.out.println("Aggregated Status child: " + comparativeValuechild);
	    
	    
	  
	  
	    Assert.assertEquals(reportingValueparent, expectedparentreportingvalue1);
	    Assert.assertEquals(reportingValuechild, expectedchildreportingvalue1);
	    Assert.assertEquals(comparativeValueparent, expectedparentcomparativevalue1);
	    Assert.assertEquals(comparativeValuechild, expectedchildcomparativevalue1);
	    
	    
	    
	}
	
	public static void updateDisclosureSteps(String token, String disclosureId) {
    // Build the URL
    String url = "https://qa.daato.app/api/esrs/disclosure-reporting/" + disclosureId + "/step";

    // Java-escaped JSON payload
    String payload = "{"
            + "\"stepOne\":\"completed\","
            + "\"stepTwo\":\"completed\","
            + "\"stepThree\":\"completed\","
            + "\"stepFour\":\"inProgress\""
            + "}";

    // Send PUT request
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

    // Extract and assert response body
    String responseBody = response.getBody().asString();
    System.out.println("Response: " + responseBody);
    Assert.assertEquals(responseBody, "updated-success", "Unexpected response from step update API");
	
	}
	
	
	public static String getDisclosureRequirementReportId(String token, String disclosureId) {
	    // Build the URL with query param
	    String url = "https://qa.daato.app/api/esrs/disclosure-reporting/" + disclosureId + "?esrsLite=standards";

	    // Send GET request and extract response
	    Response response = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .when()
	            .get(url)
	            .then()
	            .statusCode(200)
	            .extract()
	            .response();

	    // Extract disclosureRequirementReportId
	    String disclosureRequirementReportId = response.jsonPath().getString("disclosureRequirementReportId");

	    // Log and return
	    System.out.println("Disclosure Requirement Report ID: " + disclosureRequirementReportId);
	    return disclosureRequirementReportId;
	}
	
	
	
	
	
	

	
}
	

	
	



package utils;

import java.io.File;
import java.util.Collections;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.File;

public class SCSbulkactions {
	
	
	
	 public static final String BASE_URL = "https://qa.daato.app/api/supplier";
	
	    
	 private static final String GET_SUPPLIER_IDS_URL = "https://qa.daato.app/api/risk/suppliers?supplierType=external&skip=0&limit=0&search=&sort=&filters=%7B%7D&supplierIdsOnly=yes";

	    // ✅ 1. This method returns the payload (does NOT make the API call)
	    public static String bulkactions(String token) {
	        Response response = RestAssured
	            .given()
	                .header("Authorization", "Bearer " + token)
	            .get(GET_SUPPLIER_IDS_URL);

	        if (response.getStatusCode() != 200) {
	            System.out.println("❌ Failed to fetch supplier IDs: " + response.getStatusCode());
	            return null;
	        }

	        List<String> allIds = response.jsonPath().getList("supplierIds");

	        if (allIds == null || allIds.size() < 10) {
	            System.out.println("❌ Not enough supplier IDs found.");
	            return null;
	        }

	        List<String> firstTen = allIds.subList(0, 10);

	        // Build JSON payload
	        StringBuilder jsonBuilder = new StringBuilder();
	        jsonBuilder.append("{\"suppliersIds\":[");
	        for (int i = 0; i < firstTen.size(); i++) {
	            jsonBuilder.append("\"").append(firstTen.get(i)).append("\"");
	            if (i < firstTen.size() - 1) {
	                jsonBuilder.append(",");
	            }
	        }
	        jsonBuilder.append("],\"message\":\"Automation Marked as Safe\"");

	        // Don't add markedSafe here — different methods will add it based on need
	        jsonBuilder.append("}");

	        return jsonBuilder.toString();
	    }

	    // ✅ 2. This is your reusable method
	    public static void bulkmarkassafe(String token, String jsonPayload) {
	        // Add markedSafe = true to the payload
	        JsonPath parsedJson = new JsonPath(jsonPayload);
	        List<String> ids = parsedJson.getList("suppliersIds");
	        String message = parsedJson.getString("message");

	        StringBuilder updatedPayload = new StringBuilder();
	        updatedPayload.append("{\"suppliersIds\":[");
	        for (int i = 0; i < ids.size(); i++) {
	            updatedPayload.append("\"").append(ids.get(i)).append("\"");
	            if (i < ids.size() - 1) updatedPayload.append(",");
	        }
	        updatedPayload.append("],\"message\":\"").append(message).append("\",\"markedSafe\":true}");

	        // Send PUT request
	        try {
	            Response response = RestAssured
	                .given()
	                    .header("Authorization", "Bearer " + token)
	                    .header("Content-Type", "application/json")
	                    .body(updatedPayload.toString())
	                .when()
	                    .put(BASE_URL)
	                .then()
	                    .extract()
	                    .response();

	            System.out.println("✅ Called URL: " + BASE_URL);
	            System.out.println("Status Code: " + response.getStatusCode());
	            System.out.println("Response Body: " + response.getBody().asString());

	        } catch (Exception e) {
	            System.err.println("❌ PUT request failed.");
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    
	    
	    public static void uploadbulksupplier(String token) {
	    	
	    	String payload ="{"
	    		    + "\"data\":["
	    		    + "{\"name\":\"Automationbulksupplier01\",\"countryCodes\":[\"AF\"],\"productCodes\":[\"00\"],\"spendVolume\":500,\"spendVolumeCurrency\":\"eur\",\"defaultContactEmail\":\"Automationregression01@yopmail.com\",\"internalID\":\"Automation01\",\"excelUpload\":true},"
	    		    + "{\"name\":\"Automationbulksupplier02\",\"countryCodes\":[\"AF\"],\"productCodes\":[\"00\"],\"spendVolume\":500,\"spendVolumeCurrency\":\"eur\",\"defaultContactEmail\":\"Automationregression02@yopmail.com\",\"internalID\":\"Automation02\",\"excelUpload\":true},"
	    		    + "{\"name\":\"Automationbulksupplier03\",\"countryCodes\":[\"AF\"],\"productCodes\":[\"00\"],\"spendVolume\":500,\"spendVolumeCurrency\":\"eur\",\"defaultContactEmail\":\"Automationregression03@yopmail.com\",\"internalID\":\"Automation03\",\"excelUpload\":true},"
	    		    + "{\"name\":\"Automationbulksupplier04\",\"countryCodes\":[\"AF\"],\"productCodes\":[\"00\"],\"spendVolume\":500,\"spendVolumeCurrency\":\"eur\",\"defaultContactEmail\":\"Automationregression04@yopmail.com\",\"internalID\":\"Automation04\",\"excelUpload\":true},"
	    		    + "{\"name\":\"Automationbulksupplier05\",\"countryCodes\":[\"AF\"],\"productCodes\":[\"00\"],\"spendVolume\":500,\"spendVolumeCurrency\":\"eur\",\"defaultContactEmail\":\"Automationregression05@yopmail.com\",\"internalID\":\"Automation05\",\"excelUpload\":true},"
	    		    + "{\"name\":\"Automationbulksupplier06\",\"countryCodes\":[\"AF\"],\"productCodes\":[\"00\"],\"spendVolume\":500,\"spendVolumeCurrency\":\"eur\",\"defaultContactEmail\":\"Automationregression06@yopmail.com\",\"internalID\":\"Automation06\",\"excelUpload\":true},"
	    		    + "{\"name\":\"Automationbulksupplier07\",\"countryCodes\":[\"AF\"],\"productCodes\":[\"00\"],\"spendVolume\":500,\"spendVolumeCurrency\":\"eur\",\"defaultContactEmail\":\"Automationregression07@yopmail.com\",\"internalID\":\"Automation07\",\"excelUpload\":true},"
	    		    + "{\"name\":\"Automationbulksupplier08\",\"countryCodes\":[\"AF\"],\"productCodes\":[\"00\"],\"spendVolume\":500,\"spendVolumeCurrency\":\"eur\",\"defaultContactEmail\":\"Automationregression08@yopmail.com\",\"internalID\":\"Automation08\",\"excelUpload\":true},"
	    		    + "{\"name\":\"Automationbulksupplier09\",\"countryCodes\":[\"AF\"],\"productCodes\":[\"00\"],\"spendVolume\":500,\"spendVolumeCurrency\":\"eur\",\"defaultContactEmail\":\"Automationregression09@yopmail.com\",\"internalID\":\"Automation09\",\"excelUpload\":true},"
	    		    + "{\"name\":\"Automationbulksupplier10\",\"countryCodes\":[\"AF\"],\"productCodes\":[\"00\"],\"spendVolume\":500,\"spendVolumeCurrency\":\"eur\",\"defaultContactEmail\":\"Automationregression10@yopmail.com\",\"internalID\":\"Automation10\",\"excelUpload\":true}"
	    		    + "]"
	    		    + "}";
	     
	    	Response response = given()
	                .baseUri("https://qa.daato.app")
	                .basePath("/api/supplier/import")
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	                .body(payload)
	                .post();

	            System.out.println("Status Code: " + response.getStatusCode());
	            System.out.println("Response Body: " + response.getBody().asString());

	            response.then().statusCode(201);
	       

	      
	   }
	    
	    
	    public static void bulkassignentity(String token, String jsonPayload) {
	    	
	    	JsonPath parsedJson = new JsonPath(jsonPayload);
	        List<String> ids = parsedJson.getList("suppliersIds");

	        // Build updated payload string
	        StringBuilder updatedPayload = new StringBuilder();
	        updatedPayload.append("{\"suppliersIds\":[");
	        for (int i = 0; i < ids.size(); i++) {
	            updatedPayload.append("\"").append(ids.get(i)).append("\"");
	            if (i < ids.size() - 1) updatedPayload.append(",");
	        }
	        updatedPayload.append("],");

	        // Now add the assignedTo block
	        updatedPayload.append("\"assignedTo\":[{");
	        updatedPayload.append("\"entityType\":\"entity\",");
	        updatedPayload.append("\"entityID\":\"67a1f9398fa0c9ec63dde6c5\",");
	        updatedPayload.append("\"name\":\"SAQ Entity\"");
	        updatedPayload.append("}]}");

	        // Send PUT request
	        try {
	            Response response = RestAssured
	                .given()
	                    .header("Authorization", "Bearer " + token)
	                    .header("Content-Type", "application/json")
	                    .body(updatedPayload.toString())
	                .when()
	                    .put(BASE_URL)
	                .then()
	                    .extract()
	                    .response();

	            System.out.println("✅ Called URL: " + BASE_URL);
	            System.out.println("Status Code: " + response.getStatusCode());
	            System.out.println("Response Body: " + response.getBody().asString());

	        } catch (Exception e) {
	            System.err.println("❌ PUT request failed.");
	            e.printStackTrace();
	        }
	    
	 
	 
	}

 public static void bulkassignrelationshipmanager(String token, String jsonPayload) {
	    	
	    	JsonPath parsedJson = new JsonPath(jsonPayload);
	        List<String> ids = parsedJson.getList("suppliersIds");

	        // Build updated payload string
	        StringBuilder updatedPayload = new StringBuilder();
	        updatedPayload.append("{\"suppliersIds\":[");
	        for (int i = 0; i < ids.size(); i++) {
	            updatedPayload.append("\"").append(ids.get(i)).append("\"");
	            if (i < ids.size() - 1) updatedPayload.append(",");
	        }
	        updatedPayload.append("],");

	        // Now add the relationshipManagers block
	        updatedPayload.append("\"relationshipManagers\":{");
	        updatedPayload.append("\"user_id\":\"60b664f0-6e02-4a29-bd25-227f04efdc79\",");
	        updatedPayload.append("\"name\":\"piyush.soni+334343433115@47billion.com\",");
	        updatedPayload.append("\"email\":\"piyush.soni+334343433115@47billion.com\"");
	        updatedPayload.append("}}");
	        // Send PUT request
	        try {
	            Response response = RestAssured
	                .given()
	                    .header("Authorization", "Bearer " + token)
	                    .header("Content-Type", "application/json")
	                    .body(updatedPayload.toString())
	                .when()
	                    .put(BASE_URL)
	                .then()
	                    .extract()
	                    .response();

	            System.out.println("✅ Called URL: " + BASE_URL);
	            System.out.println("Status Code: " + response.getStatusCode());
	            System.out.println("Response Body: " + response.getBody().asString());

	        } catch (Exception e) {
	            System.err.println("❌ PUT request failed.");
	            e.printStackTrace();
	        }
	    
	 
	 
	}
 
 
 
 
 public static String getFirstSupplierId(String token) {
	    Response response = RestAssured
	        .given()
	            .header("Authorization", "Bearer " + token)
	        .get(GET_SUPPLIER_IDS_URL);

	    if (response.getStatusCode() != 200) {
	        System.out.println("❌ Failed to fetch supplier IDs: " + response.getStatusCode());
	        return null;
	    }

	    List<String> allIds = response.jsonPath().getList("supplierIds");

	    if (allIds == null || allIds.isEmpty()) {
	        System.out.println("❌ No supplier IDs found.");
	        return null;
	    }

	    return allIds.get(0); // Return only the first supplier ID
	}
 
 public static Response getRiskForSupplier(String supplierId, String token) {
	    String endpoint = "https://qa.daato.app/api/risk/suppliers/" + supplierId;

	    Response response = RestAssured
	        .given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	        .when()
	            .get(endpoint)
	        .then()
	            .statusCode(200)  // Adjust if a different code is expected
	            .extract().response();

	    // Print the response for visibility
	 //   System.out.println("Risk API Response: " + response.asPrettyString());

	    return response;
	}
 
 
 
 public static void unmarkassafe(String supplierId, String token) {
	 

	    String endpoint = "https://qa.daato.app/api/supplier";
	    String payload = String.format(
	        "{\"suppliersIds\":[\"%s\"],\"modifiedRiskLevel\":\"NA\",\"message\":\"Test\",\"markedSafe\":false}",
	        supplierId
	    );

	    Response response = RestAssured
	        .given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .body(payload)
	        .when()
	            .put(endpoint)
	        .then()
	            .statusCode(200)
	            .extract()
	            .response();

	    System.out.println("Response: " + response.asString());
	}
	 
	 
 }


	
		
	    
	        
	        
	        
	        
	
	
	
	
	
	
	
	
	



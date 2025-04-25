package utils;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiHelper {
	
	
	
	
	private static final String[] ENDPOINTS = {
	        "dataPoint/scSize",
	        "dataPoint/scInfluence1",
	        "dataPoint/scFactoryName",
	        "dataPoint/scInfluence2",
	        "dataPoint/scInfluence3",
	        "dataPoint/scCausation",
	        "dataPoint/scGovernanceSocial",
	        "dataPoint/scGovernanceEnvironment",
	        "dataPoint/scGovernanceHro",
	        "dataPoint/scGovernanceCoc",
	        "dataPoint/scGovernanceGrievance",
	        "dataPoint/scGrievanceType",
	        "dataPoint/scEthicsPolicy",
	        "dataPoint/scEthicsCoverage",
	        "dataPoint/scCsrSuppliers",
	        "dataPoint/scCsrAreas",
	        "dataPoint/scCsrDocument",
	        "dataPoint/SAICMS",
	        "dataPoint/ISO45001CMS",
	        "dataPoint/scEnvEms",
	        "dataPoint/scHrPolicy",
	        "dataPoint/scHrPolicyCoverage",
	        "dataPoint/scHsPolicy",
	        "dataPoint/scHsPolicyCoverage",
	        "dataPoint/scEnvPolicy",
	        "dataPoint/scEnvPolicyCoverage",
	        "dataPoint/scClPolicyTraining",
	        "dataPoint/scFlTraining",
	        "dataPoint/scHsTrainings",
	        "dataPoint/scFaTraining",
	        "dataPoint/scDivTraining",
	        "dataPoint/scFwTraining",
	        "dataPoint/scLrTenure",
	        "dataPoint/scLrTraining",
	        "dataPoint/scCsConfirmation",
	        "dataPoint/scCsConfirmation",
	        "dataPoint/scCsTraining",
	        "dataPoint/scSwhraTraining",
	        "dataPoint/scSwhraLegal",
	        "dataPoint/scEmsRohs",
	        "dataPoint/scEmsHazardouswaste",
	        "dataPoint/scEmsMercury",
	        "dataPoint/scEmsPops",
	        "dataPoint/scEmsProcedure",
	        
	        
	    };

	   
	    private static final String[] PAYLOADS = {
	        "{\"value\":[\"11 to 50\"]}",
	        "{\"value\":[4000]}",
	        "{\"value\":[{\"placeID\":\"Eh5CZXJsaW5lciBUb3IsIEhhbWJ1cmcsIEdlcm1hbnkiLiosChQKEgnh53rn6Y6xRxFNkqdgxI9_fhIUChIJuRMYfoNhsUcRoDrWe_I9JgQ\",\"address\":\"Berliner Tor, Hamburg, Germany\",\"countryCode\":\"DE\",\"coordinates\":{\"lat\":53.5553326,\"lng\":10.0228897}}]}",
	        "{\"value\":[\"long-term\"]}",
	        "{\"value\":[\"strong\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Human rights complaints\",\"Environmental complaints\",\"Unethical business practices\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Anti-Corruption and Anti-Money Laundering\",\"Data Protection and Data Security\",\"Financial responsibility (Accurate Records)\",\"Disclosure of Information\",\"Fair competition and anti-trust\",\"Conflicts of interest\",\"Counterfeit parts\",\"Intellectual property\",\"Export controls and economic sanctions\",\"Whistleblowing and protection against retaliation\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Prohibition of child labour\",\"Prohibition of forced labour and all forms of slavery\",\"Occupational safety and health hazards\",\"Freedom of association and the right to collective bargaining\",\"All form of non-discrimination in employment\",\"Prohibition of withholding of an adequate living wage\",\"Prohibition of destruction of the natural basis of life through environmental pollution\",\"Prohibition of unlawful violation of land rights\",\"Prohibition of commissioning or using private/public security forces that may cause impairment due to lack of training or control\",\"Specific action or failure to act, which is directly capable of significantly impairing a protected legal position and whose illegality is obvious upon reasonable consideration of all circumstances involved.\",\"Prohibition of production and/or use of substances covered by the Stockholm Convention (POPs) and non-environmentally sound handling of POP-containing wastes\",\"Prohibition of import/export of hazardous waste under the Basel Convention\",\"Prohibition of production, use, and/or disposal of mercury (Minamata Convention)\"]}",
	        "{\"value\":[\"Included in terms and condition\"]}",
	        "{\"value\":[\"Yes, SA8000 (SAI)\"]}",
	        "{\"value\":[\"Yes, ISO45001\"]}",
	        "{\"value\":[\"Yes, we have a internationally recognised certified management system\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Prohibition of child labour\",\"Prohibition of forced labour and all forms of slavery\",\"Freedom of association and the right to collective bargaining\",\"All form of non-discrimination in employment\",\"Anti-harassment and anti-bullying practices\",\"Prohibition of withholding of an adequate living wage\",\"Prohibition of unlawful violation of land rights\",\"Prohibition of commissioning or using private/public security forces that may cause impairment due to lack of training or control\",\"Specific action or failure to act, which is directly capable of significantly impairing a protected legal position and whose illegality is obvious upon reasonable consideration of all circumstances involved.\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Personal protective equipment\",\"Machine safety\",\"Emergency preparedness\",\"Incident and accident management\",\"Workplace ergonomics\",\"Handling of chemical and/or biological substances\",\"Fire protection\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"GHG emissions reporting\",\"Energy efficiency\",\"Renewable energy\",\"Decarbonisation\",\"Water quality, consumption & management\",\"Air quality\",\"Responsible chemical management\",\"Sustainable resources management\",\"Waste reduction\",\"Reuse and recycling\",\"Biodiversity, land use and deforestation\",\"Soil quality\",\"Noise emissions\",\"Prohibition of production, use, and/or disposal of mercury (Minamata Convention)\",\"Prohibition of production and/or use of substances covered by the Stockholm Convention (POPs) and non-environmentally sound handling of POP-containing wastes\",\"Prohibition of import/export of hazardous waste under the Basel Convention\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        "{\"value\":[\"Yes\"]}",
	        
	       
	    };
	    
	    
	 
	    
	    
	 
	    
	    
	    public static final String BASE_URL = "https://qa.daato.app/api/reports/%s/%s?pagesPath=main";
	    
	    public static void executeAllPutCalls(String token, String reportId) {
	        for (int i = 0; i < ENDPOINTS.length; i++) {
	            String fullUrl = String.format(BASE_URL, reportId, ENDPOINTS[i]);
	            String body = PAYLOADS[i];

	            // Debug info
	            System.out.println("\n--- PUT CALL ---");
	            System.out.println("Endpoint: " + ENDPOINTS[i]);
	            System.out.println("Full URL: " + fullUrl);
	            System.out.println("Payload: " + body);

	            try {
	                Response response = RestAssured
	                    .given()
	                        .header("Authorization", "Bearer " + token)
	                        .header("Content-Type", "application/json")
	                        .body(body)
	                    .when()
	                        .put(fullUrl)
	                    .then()
	                        .extract()
	                        .response();

	                int statusCode = response.getStatusCode();
	                System.out.println("Status Code: " + statusCode);

	                if (statusCode != 200) {
	                    System.out.println("Response Body: " + response.getBody().asString());
	                }

	            } catch (Exception e) {
	                System.err.println("Exception occurred on endpoint: " + ENDPOINTS[i]);
	                e.printStackTrace();
	            }
	        }
	    }
	 
	    
	    public static Response getWithToken(String url, String token) {
	        return RestAssured
	            .given()
	                .header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json")
	            .when()
	                .get(url)
	            .then()
	            .statusCode(200)
	                .extract().response();
	    }
	    
	
	
	    public static void postsaqRequestState(String token, String requestId) {
	        String url = "https://qa.daato.app/api/request/state";

	       
	        String payload = String.format(
	                "{\"requestID\":\"%s\",\"status\":\"review\",\"message\":\"Submitted by automation Piyush\"}", requestId
	                );
	        
	        System.out.println("Payload: " + payload);

	        try {
	            Response response = RestAssured
	                .given()
	                    .header("Authorization", "Bearer " + token)
	                    .header("Content-Type", "application/json")
	                    .body(payload)
	                .when()
	                    .patch(url)
	                .then()
	                    .extract()
	                    .response();
	            
	            System.out.println("Calling URL: " + url);
	            System.out.println("\n--- Post CALL ---");
	            int statusCode = response.getStatusCode();
	            System.out.println("Status Code: " + statusCode);
	           
	            String responseBody = response.getBody().asString();
	            System.out.println("Response Body: " + responseBody);

	            // Extract 'message' if it exists
	            if (responseBody != null && !responseBody.trim().isEmpty()) {
	                JsonPath json = new JsonPath(responseBody);
	                String message = json.getString("message");
	                if (message != null) {
	                    System.out.println("Response Message: " + message);
	                } else {
	                    System.out.println("No 'message' field found in the response.");
	                }
	            } else {
	                System.out.println("Empty response body. No JSON to parse.");
	            }
	            
	        } catch (Exception e) {
	            System.err.println("POST request failed.");
	            e.printStackTrace();
	        }
	        }
	    
	    
	    
	    private static final String[] ENDPOINTS1 = {
	    		"dataPoint/cocAgreement",
	    		"dataPoint/uploadSigned",
	    };
	    
	    private static final String[] PAYLOADS1 = {
	    		
	    		"{\"value\":[\"proposedCoc\"]}",
	    		null
	    
	    };    
	    
	    public static void executeAllPutCallscoc(String token, String reportId) {
	        for (int i = 0; i < ENDPOINTS1.length; i++) {
	            String fullUrl = String.format(BASE_URL, reportId, ENDPOINTS1[i]);
	            System.out.println("\n--- PUT CALL ---");
	            System.out.println("Endpoint: " + ENDPOINTS1[i]);
	            System.out.println("Full URL: " + fullUrl);

	            try {
	                Response response;

	                if (PAYLOADS1[i] != null) {
	                    // Normal JSON PUT call
	                    System.out.println("Payload: " + PAYLOADS1[i]);
	                    response = RestAssured
	                        .given()
	                            .header("Authorization", "Bearer " + token)
	                            .header("Content-Type", "application/json")
	                            .body(PAYLOADS1[i])
	                        .when()
	                            .put(fullUrl)
	                        .then()
	                            .extract()
	                            .response();
	                } else {
	                    // File upload for uploadSigned
	                    File file = new File("C:\\Users\\47Billion\\Desktop\\Daato_Automation\\Add_Supplier_Afghanistan.xlsx"); // replace with actual path
	                    System.out.println("Uploading file: " + file.getAbsolutePath());

	                    response = RestAssured
	                        .given()
	                            .header("Authorization", "Bearer " + token)
	                            .multiPart("file", file)
	                        .when()
	                            .put(fullUrl)
	                        .then()
	                            .extract()
	                            .response();
	                }

	                int statusCode = response.getStatusCode();
	                System.out.println("Status Code: " + statusCode);

	                if (statusCode != 200) {
	                    System.out.println("Response Body: " + response.getBody().asString());
	                }

	            } catch (Exception e) {
	                System.err.println("Exception occurred on endpoint: " + ENDPOINTS1[i]);
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    
	    
	   public static void postcocRequestState(String token, String requestId) {
	        String url = "https://qa.daato.app/api/request/state";

	       
	        String payload = String.format(
	                "{\"requestID\":\"%s\",\"status\":\"review\",\"message\":\"Submitted by automation Piyush\"}", requestId
	                );
	        
	        System.out.println("Payload: " + payload);

	        try {
	            Response response = RestAssured
	                .given()
	                    .header("Authorization", "Bearer " + token)
	                    .header("Content-Type", "application/json")
	                    .body(payload)
	                .when()
	                    .patch(url)
	                .then()
	                    .extract()
	                    .response();
	            
	            System.out.println("Calling URL: " + url);
	            System.out.println("\n--- Post CALL ---");
	            int statusCode = response.getStatusCode();
	            System.out.println("Status Code: " + statusCode);
	           
	            String responseBody = response.getBody().asString();
	            System.out.println("Response Body: " + responseBody);

	            // Extract 'message' if it exists
	            if (responseBody != null && !responseBody.trim().isEmpty()) {
	                JsonPath json = new JsonPath(responseBody);
	                String message = json.getString("message");
	                if (message != null) {
	                    System.out.println("Response Message: " + message);
	                } else {
	                    System.out.println("No 'message' field found in the response.");
	                }
	            } else {
	                System.out.println("Empty response body. No JSON to parse.");
	            }
	            
	        } catch (Exception e) {
	            System.err.println("POST request failed.");
	            e.printStackTrace();
	        }
	        }   
	   
	   
	   
	   public static void acceptSAQandcoc(String token, String requestId)   {
		   
		   final String BASE_URL ="https://qa.daato.app/api/request/%s/accept";
		
		 String url = String.format(BASE_URL, requestId);
		
		 try {
	            Response response = RestAssured
	                .given()
	                    .header("Authorization", "Bearer " + token)
	                    .header("Content-Type", "application/json")
	                .when()
	                    .post(url)
	                .then()
	                    .extract()
	                    .response();
	            
	            System.out.println("Calling URL: " + url);
	            System.out.println("\n--- Post CALL ---");
	            int statusCode = response.getStatusCode();
	            System.out.println("Status Code: " + statusCode);
	           
	            String responseBody = response.getBody().asString();
	            System.out.println("Response Body: " + responseBody);

	            // Extract 'message' if it exists
	            if (responseBody != null && !responseBody.trim().isEmpty()) {
	                JsonPath json = new JsonPath(responseBody);
	                String message = json.getString("message");
	                if (message != null) {
	                    System.out.println("Response Message: " + message);
	                } else {
	                    System.out.println("No 'message' field found in the response.");
	                }
	            } else {
	                System.out.println("Empty response body. No JSON to parse.");
	            }
	            
	        } catch (Exception e) {
	            System.err.println("POST request failed.");
	            e.printStackTrace();
	        }
		 
		 
	        }   
	     
		   
		   
	   public static Requestids getRequestIdsWithReports(String token) {
		    String endpoint = "https://qa.daato.app/api/request?type=incoming&page=0&limit=10";
		    Response response = getWithToken(endpoint, token);
		    JsonPath json = response.jsonPath();

		    List<String> requestTypes = json.getList("data.requestType");

		    String selfReportId = null;
		    String selfRequestId = null;
		    String cocReportId = null;
		    String cocRequestId = null;

		    for (int i = 0; i < requestTypes.size(); i++) {
		        String type = requestTypes.get(i);

		        if ("code-of-conduct".equalsIgnoreCase(type) && cocRequestId == null) {
		            cocReportId = json.getString("data[" + i + "].reportID");
		            cocRequestId = json.getString("data[" + i + "]._id");
		        } else if ("self-assessment".equalsIgnoreCase(type) && selfRequestId == null) {
		            selfReportId = json.getString("data[" + i + "].reportID");
		            selfRequestId = json.getString("data[" + i + "]._id");
		        }
		    }

		    if (cocReportId != null) {
		        System.out.println("Code of Conduct - Report ID: " + cocReportId + ", Request ID: " + cocRequestId);
		    } else {
		        System.out.println("Code of Conduct request not found.");
		    }

		    if (selfReportId != null) {
		        System.out.println("Self-assessment - Report ID: " + selfReportId + ", Request ID: " + selfRequestId);
		    } else {
		        System.out.println("Self-assessment request not found.");
		    }

		    return new Requestids(selfReportId, selfRequestId, cocReportId, cocRequestId);
		}	   
		   
		   
		   
		   
		   
		   
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	

	
	
	
	/*public static Response getWithToken(String url, String token) {
        return RestAssured
            .given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
            .when()
                .get(url)
            .then()
                .extract().response();
    }

    public static Response putWithToken(String url, String token, String jsonBody) {
        return RestAssured
            .given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(jsonBody)
            .when()
                .put(url)
            .then()
                .extract().response();
    }*/
	
	


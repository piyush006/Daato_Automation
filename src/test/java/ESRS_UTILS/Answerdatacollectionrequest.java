package ESRS_UTILS;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Answerdatacollectionrequest {
	
	
    // URLs and payloads
    private static final String[][] URL_PAYLOADC = {
        { "v5E1530", "{\"value\":[{\"id\":0,\"reporting\":[12],\"comparative\":[12],\"_id\":[\"piyush\"]}]}" },
        { "v5E152", "{\"value\":[{\"id\":0,\"reporting\":[50],\"comparative\":[50],\"_id\":[\"c3c94d6a-d98e-4be8-9497-b03070020284\"]}]}" },
        { "v5E153", "{\"value\":[{\"id\":0,\"reporting\":[60],\"comparative\":[60],\"_id\":[\"b0fe2425-7b6e-49aa-bb72-90be4a812de9\"]}]}" },
        { "v5E155", "{\"value\":[{\"id\":0,\"reporting\":[70],\"comparative\":[70],\"_id\":[\"de4b08a5-dba3-4c5e-b111-bd95eee267ce\"]}]}" },
        { "v5E156", "{\"value\":[{\"id\":0,\"reporting\":[80],\"comparative\":[80],\"_id\":[\"bb4e45a7-8cfa-428c-9178-d87b04235861\"]}]}" },
        { "v5E157", "{\"value\":[{\"id\":0,\"reporting\":[90],\"comparative\":[90],\"_id\":[\"a73cc306-5dad-4b55-8b5d-e11d76c1fe88\"]}]}" },
        { "v5E158", "{\"value\":[{\"id\":0,\"reporting\":[100],\"comparative\":[100],\"_id\":[\"7fc9c153-784d-4cbc-8177-6ef0c924496c\"]}]}" },
        { "v5E1510", "{\"value\":[\"yes\"]}" },
        { "v5E1511", "{\"value\":[{\"id\":0,\"reporting\":[30],\"comparative\":[30],\"_id\":[\"9d888f15-1fac-43bb-be2b-8c7fd89bbd2e\"]}]}" },
        { "v5E1512", "{\"value\":[{\"id\":0,\"reporting\":[130],\"comparative\":[130],\"_id\":[\"cf386bd7-b529-48c4-a212-985141e17e3e\"]}]}" },
        { "v5E1513", "{\"value\":[{\"id\":0,\"reporting\":[98],\"comparative\":[100],\"_id\":[\"748ba846-34c2-4902-8fbb-b847222cbe2a\"]}]}" },
        { "v5E1514", "{\"value\":[{\"id\":0,\"reporting\":[125],\"comparative\":[130],\"_id\":[\"f0430a8a-0537-4dec-9274-f78b1ee4aed9\"]}]}" },
        { "v5E1515", "{\"value\":[{\"id\":0,\"reporting\":[130],\"comparative\":[135],\"_id\":[\"59490aed-69be-4c16-9adf-f08189277f7c\"]}]}" },
        { "v5E1517", "{\"value\":[{\"id\":0,\"reporting\":[60],\"comparative\":[80],\"_id\":[\"79ca8f0c-1fe6-421b-adf8-36225fd5849c\"]}]}" },
        { "v5E1521", "{\"value\":[\"Automated comment\"]}" },
        { "v5E1522", "{\"value\":[\"Automated comment\"]}" },
        { "v5E1523", "{\"value\":[50]}" },
        { "v5E1524", "{\"value\":[70]}" },
        { "v5E1525", "{\"value\":[\"yes\"]}" },
        { "v5E1526", "{\"value\":[90]}" },
        { "v5E1527", "{\"value\":[490]}" },
        { "v5E1528", "{\"value\":[\"Automated Test Result\"]}" },
        { "v5E1529", "{\"value\":[\"Automated comment\"]}" },
        { "v5E159Calculated", "{\"value\":[{\"id\":0,\"reporting\":[50],\"comparative\":[60],\"_id\":[\"e9aa9a71-00bd-4ea6-a58c-ac279e68f9bb\"]}]}" }
    };

    public static void sendAllRequestschild(String token, String reportId) {
        for (String[] pair : URL_PAYLOADC) {
            String endpoint = pair[0];
            String payload = pair[1];

            String fullUrl = "https://qa.daato.app/api/reports/" + reportId + "/dataPoint/" + endpoint + "?pagesPath=main";

            Response response = RestAssured
                    .given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("application/json")
                    .body(payload)
                    .put(fullUrl)
                    .then()
                    .extract()
                    .response();

            System.out.println("Sent PUT to: " + fullUrl);
          //  System.out.println("Payload: " + payload);
            System.out.println("Status: " + response.getStatusCode());
           System.out.println("Response: " + response.getBody().asString());
        //    System.out.println("--------------------------------------------------");
        }
    }	
    
    
    // URLs and payloads
    private static final String[][] URL_PAYLOADSP = {
        { "v5E1530", "{\"value\":[{\"id\":0,\"reporting\":[12],\"comparative\":[12],\"_id\":[\"piyush\"]}]}" },
        { "v5E152", "{\"value\":[{\"id\":0,\"reporting\":[50],\"comparative\":[50],\"_id\":[\"c3c94d6a-d98e-4be8-9497-b03070020284\"]}]}" },
        { "v5E153", "{\"value\":[{\"id\":0,\"reporting\":[60],\"comparative\":[60],\"_id\":[\"b0fe2425-7b6e-49aa-bb72-90be4a812de9\"]}]}" },
        { "v5E155", "{\"value\":[{\"id\":0,\"reporting\":[70],\"comparative\":[70],\"_id\":[\"de4b08a5-dba3-4c5e-b111-bd95eee267ce\"]}]}" },
        { "v5E156", "{\"value\":[{\"id\":0,\"reporting\":[80],\"comparative\":[80],\"_id\":[\"bb4e45a7-8cfa-428c-9178-d87b04235861\"]}]}" },
        { "v5E157", "{\"value\":[{\"id\":0,\"reporting\":[90],\"comparative\":[90],\"_id\":[\"a73cc306-5dad-4b55-8b5d-e11d76c1fe88\"]}]}" },
        { "v5E158", "{\"value\":[{\"id\":0,\"reporting\":[100],\"comparative\":[100],\"_id\":[\"7fc9c153-784d-4cbc-8177-6ef0c924496c\"]}]}" },
        { "v5E1510", "{\"value\":[\"yes\"]}" },
        { "v5E1511", "{\"value\":[{\"id\":0,\"reporting\":[30],\"comparative\":[30],\"_id\":[\"9d888f15-1fac-43bb-be2b-8c7fd89bbd2e\"]}]}" },
        { "v5E1512", "{\"value\":[{\"id\":0,\"reporting\":[130],\"comparative\":[130],\"_id\":[\"cf386bd7-b529-48c4-a212-985141e17e3e\"]}]}" },
        { "v5E1513", "{\"value\":[{\"id\":0,\"reporting\":[98],\"comparative\":[100],\"_id\":[\"748ba846-34c2-4902-8fbb-b847222cbe2a\"]}]}" },
        { "v5E1514", "{\"value\":[{\"id\":0,\"reporting\":[125],\"comparative\":[130],\"_id\":[\"f0430a8a-0537-4dec-9274-f78b1ee4aed9\"]}]}" },
        { "v5E1515", "{\"value\":[{\"id\":0,\"reporting\":[130],\"comparative\":[135],\"_id\":[\"59490aed-69be-4c16-9adf-f08189277f7c\"]}]}" },
        { "v5E1517", "{\"value\":[{\"id\":0,\"reporting\":[60],\"comparative\":[80],\"_id\":[\"79ca8f0c-1fe6-421b-adf8-36225fd5849c\"]}]}" },
        { "v5E1521", "{\"value\":[\"Automated comment\"]}" },
        { "v5E1522", "{\"value\":[\"Automated comment\"]}" },
        { "v5E1523", "{\"value\":[50]}" },
        { "v5E1524", "{\"value\":[70]}" },
        { "v5E1525", "{\"value\":[\"yes\"]}" },
        { "v5E1526", "{\"value\":[90]}" },
        { "v5E1527", "{\"value\":[490]}" },
        { "v5E1528", "{\"value\":[\"Automated Test Result\"]}" },
        { "v5E1529", "{\"value\":[\"Automated comment\"]}" },
        { "v5E159Calculated", "{\"value\":[{\"id\":0,\"reporting\":[50],\"comparative\":[60],\"_id\":[\"e9aa9a71-00bd-4ea6-a58c-ac279e68f9bb\"]}]}" }
    };
	
    public static void sendAllRequestsparent(String token, String reportId) {
        for (String[] pair : URL_PAYLOADSP) {
            String endpoint = pair[0];
            String payload = pair[1];

            String fullUrl = "https://qa.daato.app/api/reports/" + reportId + "/dataPoint/" + endpoint + "?pagesPath=own-ESRS-E1-Climate-Change-Disclosure-E1-5";

            Response response = RestAssured
                    .given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("application/json")
                    .body(payload)
                    .put(fullUrl)
                    .then()
                    .extract()
                    .response();

            System.out.println("Sent PUT to: " + fullUrl);
          //  System.out.println("Payload: " + payload);
            System.out.println("Status: " + response.getStatusCode());
           System.out.println("Response: " + response.getBody().asString());
        //    System.out.println("--------------------------------------------------");
        }
    }
    
    public static void updateStatuschild(String token, String workflowId, String entityId) {
        String url = "https://qa.daato.app/api/data-collection-workflows/"
                   + workflowId + "/entities/" + entityId;

        Response response = RestAssured
            .given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .body("{\"status\":\"completed\"}")
            .when()
            .put(url)
            .then()
            .statusCode(200)
            .extract()
            .response();

        // Print the response body
        System.out.println("Response Body: " + response.asString());
    }
    
    public static void updateStatusparent(String token, String workflowId, String entityId) {
        String url = "https://qa.daato.app/api/data-collection-workflows/"
                   + workflowId + "/entities/" + entityId;

        RestAssured
            .given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .body("{\"status\":\"completed\"}")
            .when()
            .put(url)
            .then()
            .statusCode(200); // silently assert success
    }
    
    public static void completeDataCollection(String token, String workflowId) {
        String url = "https://qa.daato.app/api/data-collection-workflows/" + workflowId;

        Response response = RestAssured
            .given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .body("{\"status\":\"completed\"}")
            .when()
            .put(url)
            .then()
            .statusCode(200)
            .extract()
            .response();

        // Print the response body
        System.out.println("Response Body: " + response.asString());
    }
    
    
    
    public static void markDataPointCompleted(String token, String fullUrl) {
        Response response = RestAssured
            .given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .body("{\"completed\": true}")
            .when()
            .put(fullUrl)
            .then()
            .statusCode(200)
            .extract()
            .response();

        // Print the response
        System.out.println("URL: " + fullUrl);
        System.out.println("Response Body: " + response.asString());
    }
    
    
    
    

    }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


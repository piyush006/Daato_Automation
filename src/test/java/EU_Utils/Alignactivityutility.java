package EU_Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import java.util.LinkedHashMap;
import java.util.Map;

public class Alignactivityutility {
	
	
	
	private final String token;
    private final String alignmentReportId;
    private final String reportId;
    private final String activityId;

    public Alignactivityutility(String token, String alignmentReportId, String reportId, String activityId) {
        this.token = token;
        this.alignmentReportId = alignmentReportId;
        this.reportId = reportId;
        this.activityId = activityId;
    }

    public void sendAllRequests() {
        // Use LinkedHashMap to maintain order
        Map<String, String> apiPayloadMap = new LinkedHashMap<>();

        apiPayloadMap.put("eu32MithydrScr1", "{\"value\":[\"a. For hydrogen fuels\"]}");
        apiPayloadMap.put("eu32MithydrScr2", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu32MithydrScr4", "{\"value\":[\"a. Article 28(5) of Directive (EU) 2018/2001\"]}");
        apiPayloadMap.put("eu32MithydrScr5", "{\"value\":[\"a. In line with Article 30 of Directive (EU) 2018/2001 where applicable\"]}");
        apiPayloadMap.put("eu32MithydrScr6", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu32MithydrScr7", "{\"value\":[\"a. Technical screening criteria specified in Section 5.11 or 5.12 of Delegated Regulation (EU) 2021/2139\"]}");
        apiPayloadMap.put("eu32Enabling1", "{\"value\":[\"no\"]}");
        apiPayloadMap.put("eu32Enabling2", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu321DNSHadapt", "{\"value\":[\"Less than ten years\"]}");
        apiPayloadMap.put("eu3211DNSHadapt", "{\"value\":[\"Test\"]}");
        apiPayloadMap.put("eu322DNSHadapt", "{\"value\":[\"a. They are produced, developed or otherwise taking place in your own sites\"]}");
        apiPayloadMap.put("eu3221DNSHadapt", "{\"value\":[{\"_id\":[\"405c5709-6a0c-4f09-b3ea-73e3374946c9\"],\"id\":-1,\"sites\":[\"Test\"]}]}");
        apiPayloadMap.put("eu323DNSHadapt", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu3231DNSHadapt", "{\"value\":[\"1. Temperature related- Changing temperature (air, freshwater, marine water)\"]}");
        apiPayloadMap.put("eu3232DNSHadapt", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu3233DNSHadapt", "{\"value\":[{\"_id\":[\"fe2f450e-b134-4e8d-aee4-98fa5dbbb4e9\"],\"id\":-1,\"risks\":[\"Test\"]}]}");
        apiPayloadMap.put("eu3234DNSHadapt", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu3235DNSHadapt", "{\"value\":[{\"_id\":[\"43714ec7-a746-4424-96b9-6e299250492e\"],\"id\":-1,\"solutions\":[\"Test\"]}]}");
        apiPayloadMap.put("eu327DNSHadapt", "{\"value\":[\"a. No adaptation efforts in another area are negatively affected\",\"b. Consistency with local, sectoral, regional or national adaptation plans and strategies\",\"c. Blue/green infrastructure are considered to the extent possible\",\"d. Consideration of nature-based solutions to the extent possible\"]}");
        apiPayloadMap.put("eu32MithydrWater0", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu32MithydrWater01", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu32MithydrWater02", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu32MithydrWater11", "{\"value\":[\"Test\"]}");
        apiPayloadMap.put("eu32MithydrWater5", "{\"value\":[\"no\"]}");
        apiPayloadMap.put("eu32MithydrWater51", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu32MitcircuralReuse", "{\"value\":[\"a\"]}");
        apiPayloadMap.put("eu32MitcircuralDesign", "{\"value\":[\"a\"]}");
        apiPayloadMap.put("eu32MitcircuralPriority", "{\"value\":[\"a\"]}");
        apiPayloadMap.put("eu32MitcircuralSoc", "{\"value\":[\"a\"]}");
        apiPayloadMap.put("eu32MitpollutionManufacture", "{\"value\":[\"no\"]}");
        apiPayloadMap.put("eu32MitpollutionMercury", "{\"value\":[\"no\"]}");
        apiPayloadMap.put("eu32MitpollutionInvolvemnet", "{\"value\":[\"no\"]}");
        apiPayloadMap.put("eu32MitpollutionCompliance", "{\"value\":[\"no\"]}");
        apiPayloadMap.put("eu32MitpollutionAnnex17", "{\"value\":[\"b. Yes, but in full compliance with the Annex’ specified conditions\"]}");
        apiPayloadMap.put("eu32MitpollutionArt57", "{\"value\":[\"b. Yes, but the substances’ use has been proven essential for society.\"]}");
        apiPayloadMap.put("eu32MitpollutionArt59", "{\"value\":[\"a. Yes\"]}");
        apiPayloadMap.put("eu32BiodiversityThirdCountries", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu32BiodiversityAssessThird", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu32BiodiversityMit", "{\"value\":[\"yes\"]}");
        apiPayloadMap.put("eu32BiodiversitySensitive", "{\"value\":[\"a. Yes\"]}");
        apiPayloadMap.put("eu32BiodiversityMit2", "{\"value\":[\"yes\"]}");

        for (Map.Entry<String, String> entry : apiPayloadMap.entrySet()) {
            String dataPointId = entry.getKey();
            String payload = entry.getValue();
            String url = String.format(
                "https://qa.daato.app/api/reports/%s/dataPoint/%s?pagesPath=reports/%s/my_taxonomy/alignment/%s",
                alignmentReportId, dataPointId, reportId, activityId
            );

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
            
            

            int statusCode = response.getStatusCode();
            System.out.println("Status Code: " + statusCode);
        }
    }	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

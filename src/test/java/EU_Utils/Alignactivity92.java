package EU_Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import java.util.LinkedHashMap;
import java.util.Map;
public class Alignactivity92 {
	
	
	
	 private final String token;
	    private final String alignmentReportId;
	    private final String reportId;
	    private final String activityId;

	    public Alignactivity92(String token, String alignmentReportId, String reportId, String activityId) {
	        this.token = token;
	        this.alignmentReportId = alignmentReportId;
	        this.reportId = reportId;
	        this.activityId = activityId; 
	    }

	    public void sendAllRequests() {
	        Map<String, String> apiPayloadMap = new LinkedHashMap<>();

	        apiPayloadMap.put("eu91SubsBeige", "{\"value\":[\"Yes, corresponding to TRL 6 or 7\"]}");
	        apiPayloadMap.put("eu91SubsQuali", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91SubsMarket", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91SubsEnabling", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu9.11DNSHadapt", "{\"value\":[\"Less than ten years\"]}");
	        apiPayloadMap.put("eu9.111DNSHadapt", "{\"value\":[\"Test\"]}");
	        apiPayloadMap.put("eu9.12DNSHadapt", "{\"value\":[\"a. They are produced, developed or otherwise taking place in your own sites\"]}");
	        apiPayloadMap.put("eu9.121DNSHadapt", "{\"value\":[{\"_id\":[\"729545cc-666c-4960-8fa9-7fb318b3d183\"],\"id\":-1,\"sites\":[\"Test\"]}]}");
	        apiPayloadMap.put("eu9.13DNSHadapt", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu9.131DNSHadapt", "{\"value\":[\"1. Temperature related- Changing temperature (air, freshwater, marine water)\"]}");
	        apiPayloadMap.put("eu9.132DNSHadapt", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu9.133DNSHadapt", "{\"value\":[{\"_id\":[\"820db43e-f030-401a-8c54-1102accbfa53\"],\"id\":-1,\"risks\":[\"Test\"]}]}");
	        apiPayloadMap.put("eu9.134DNSHadapt", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu9.135DNSHadapt", "{\"value\":[{\"_id\":[\"83e3eaaa-b69c-4f0e-b627-6d78b3546d9b\"],\"id\":-1,\"solutions\":[\"Test piyush\"]}]}");
	        apiPayloadMap.put("eu9.17DNSHadapt", "{\"value\":[\"a. No adaptation efforts in another area are negatively affected\",\"b. Consistency with local, sectoral, regional or national adaptation plans and strategies\",\"c. Blue/green infrastructure are considered to the extent possible\"]}");
	        apiPayloadMap.put("eu91DnshWater1", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshWater11", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshWater2", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshWater21", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshCircecon1", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshCircecon11", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshCircecon2", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshPoll1", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshPoll11", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshBiodiv1", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshBiodiv11", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshBiodiv2", "{\"value\":[\"yes\"]}");
	        apiPayloadMap.put("eu91DnshBiodiv21", "{\"value\":[\"yes\"]}");

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

	            System.out.println("Status Code: " + response.getStatusCode());
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
	

}

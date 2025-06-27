package ESRSfulldatapointshelper;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

public class Generaldisclosureshelper {
	
	
	
	
	
	public static void fillAndCompleteDataPoints1(List<String> dataPointIds, String token, String reportId, String pagePath, String module) {

        Map<String, String> payloadMap = PayloadHelpergeneraldr.getPayloadMap();

        for (String dpId : dataPointIds) {
            String payload = payloadMap.get(dpId);
            if (payload == null) {
                System.out.println("⚠️ No payload found for: " + dpId);
                continue;
            }

            String dataPointUrl = String.format("https://qa.daato.app/api/reports/%s/dataPoint/%s?pagesPath=%s&module=%s",
                    reportId, dpId, pagePath, module);

            String completionUrl = String.format("https://qa.daato.app/api/reports/%s/collaborationDataPoint/%s/finalDataPointId/%s/completed?pagesPath=%s&module=%s",
                    reportId, dpId, dpId, pagePath, module);

            Response response = given()
                    .header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json")
                    .body(payload)
                    .put(dataPointUrl);

            System.out.println("📤 Sent to: " + dpId + " | URL: " + dataPointUrl + " | Status: " + response.statusCode());

            Response completeResp = given()
                    .header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json")
                    .body("{\"completed\":true}")
                    .put(completionUrl);

            System.out.println("Completed: " + dpId + " | URL: " + dataPointUrl + " | Status: " + completeResp.statusCode());
        }
    }
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

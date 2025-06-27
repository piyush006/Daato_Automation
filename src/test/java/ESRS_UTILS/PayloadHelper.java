package ESRS_UTILS;

import java.util.HashMap;
import java.util.Map;

public class PayloadHelper {
	
	
	public static Map<String, String> getPayloadMap() {
        Map<String, String> map = new HashMap<>();

        map.put("v5G139", "{ \"value\": [ { \"total\": [100], \"part\": [95] } ] }");

        map.put("v5G1312", "{\n" +
                "  \"value\": [\n" +
                "    {\n" +
                "      \"mainQuestion\": \"Piyush soni\",\n" +
                "      \"questions\": {\n" +
                "        \"training\": {\n" +
                "          \"value\": [\n" +
                "            { \"rowId\": 0, \"indexesColumn\": [\"At-risk functions\"] },\n" +
                "            { \"rowId\": 1, \"indexesColumn\": [\"Managers\"] },\n" +
                "            { \"rowId\": 2, \"indexesColumn\": [\"Administrative, management and supervisory bodies\"] },\n" +
                "            { \"rowId\": 3, \"indexesColumn\": [\"Other own workers\"] }\n" +
                "          ], \"calculatedValues\": []\n" +
                "        },\n" +
                "        \"delivery\": { \"value\": [\n" +
                "            { \"rowId\": 0, \"indexesColumn\": [\"At-risk functions\"] },\n" +
                "            { \"rowId\": 1, \"indexesColumn\": [\"Managers\"] },\n" +
                "            { \"rowId\": 2, \"indexesColumn\": [\"Administrative, management and supervisory bodies\"] },\n" +
                "            { \"rowId\": 3, \"indexesColumn\": [\"Other own workers\"] }\n" +
                "          ], \"calculatedValues\": [] },\n" +
                "        \"frequency\": { \"value\": [\n" +
                "            { \"rowId\": 0, \"indexesColumn\": [\"At-risk functions\"] },\n" +
                "            { \"rowId\": 1, \"indexesColumn\": [\"Managers\"] },\n" +
                "            { \"rowId\": 2, \"indexesColumn\": [\"Administrative, management and supervisory bodies\"] },\n" +
                "            { \"rowId\": 3, \"indexesColumn\": [\"Other own workers\"] }\n" +
                "          ], \"calculatedValues\": [] },\n" +
                "        \"topics\": { \"value\": [\n" +
                "            { \"rowId\": 0, \"indexesColumn\": [\"At-risk functions\"] },\n" +
                "            { \"rowId\": 1, \"indexesColumn\": [\"Managers\"] },\n" +
                "            { \"rowId\": 2, \"indexesColumn\": [\"Administrative, management and supervisory bodies\"] },\n" +
                "            { \"rowId\": 3, \"indexesColumn\": [\"Other own workers\"] }\n" +
                "          ], \"calculatedValues\": [] }\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}");

        for (String id : new String[]{"v5G1410", "v5G166", "v5G1411", "v5G168", "v5G1512", "v5G1511"}) {
            map.put(id, "{ \"value\": [ { \"reporting\": [100], \"comparative\": [50] } ] }");
        }

        for (String id : new String[]{"v5G143", "v5G146", "v5G147", "v5G1514"}) {
            map.put(id, "{\"value\":[4]}");
        }

        map.put("v5G167", "{ \"value\": [ { \"total\": [1000], \"part\": [500], \"comparative\": [700] } ] }");

        map.put("v5G151", "{ \"value\": [ { \"id\": -1, \"comparative\": [700], \"amount\": [1000], \"countryText\": [\"Germany\"], \"reason\": [\"Test\"] } ] }");
        map.put("v5G153", "{ \"value\": [ { \"id\": -1, \"comparative\": [700], \"amount\": [1000], \"countryText\": [\"Germany\"], \"reason\": [\"Test\"] } ] }");
        

        return map;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

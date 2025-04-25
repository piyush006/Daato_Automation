package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

import com.google.common.io.Files;

import Excel.utility.Xls_Reader;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_testcomponent.Getlatestfilepath;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SupplierDataReader {
	
	public static String latestExcelPath;
    public static String randomContactName;
    public static String Companyname;
    

    public static SupplierData getSupplierData(String supplierNameToFind) throws IOException {
    	
    	String downloadPath = System.getProperty("user.dir") + "/downloads";
    	//String downloadPath = System.getProperty("download.dir", System.getProperty("user.dir") + "/downloads");
        File latestFile = Getlatestfilepath.getLatestFileFromDir(downloadPath, ".xlsx");

        Xls_Reader reader = new Xls_Reader(latestFile.getAbsolutePath());
        int count = reader.getRowCount("suppliers");

        for (int i = 0; i < count - 1; i++) {
            String supplierName = reader.getCellData("suppliers", "Supplier Name (mandatory)", i + 2);
            if (supplierName.equals(supplierNameToFind)) {
                SupplierData data = new SupplierData();
                data.supplierName = supplierName;
                data.contactEmail = reader.getCellData("suppliers", "Contact Email (recommended)", i + 2);
                System.out.println(data.contactEmail);
                data.productsOrServices = reader.getCellData("suppliers", "Products Or Services (recommended)\ni.e. PS_0013", i + 2);
                data.contactName = reader.getCellData("suppliers", "Contact Name (optional)", i + 2);
                data.isActive = reader.getCellData("suppliers", 28, i + 2);
                data.ownBusiness = reader.getCellData("suppliers", "Own Business Entity (optional)\nplease type the exact entity name used in the organizational structure in Daato. You can refer to masterentity sheet", i + 2);
                data.relationshipManager = reader.getCellData("suppliers", "Relationship manager’s email (optional)\ni.e. 123@gmail.com", i + 2);
                data.markedAsSafe = reader.getCellData("suppliers", "Marked as Safe (optional)\ni.e. FALSE", i + 2);
                return data;
            }
        }

        return null; // Supplier not found
    }
    
    
    public void editexcel() {
    	
    	//String downloadPath = System.getProperty("download.dir", System.getProperty("user.dir") + "/downloads");
    	String downloadPath = System.getProperty("user.dir") + "/downloads";
        File latestFile = Getlatestfilepath.getLatestFileFromDir(downloadPath, ".xlsx");

        latestExcelPath = latestFile.getAbsolutePath();

        Xls_Reader reader = new Xls_Reader(latestExcelPath);

        // Generate random 5-character string
        randomContactName = generateRandomString(5);

        // Update Excel cell with the generated name
        Companyname   = reader.getCellData("suppliers", "Supplier Name (mandatory)",2);
        reader.setCellData("suppliers", "Contact Name (optional)", 2, randomContactName);
        
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(rand.nextInt(characters.length())));
        }
        return result.toString();
    }
    
    
   
    
    public static Response downloadfile(String token) {
    	String endpoint = "https://qa.daato.app/api/risk/export/all/repoInformation";

	    Response response = RestAssured
	        .given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	        .when()
	            .post(endpoint)
	        .then()
	            .statusCode(201)  // Adjust if a different code is expected
	            .extract().response();

	    // Print the response for visibility
	 //   System.out.println("Risk API Response: " + response.asPrettyString());

	    return response;
    }
    

    
}

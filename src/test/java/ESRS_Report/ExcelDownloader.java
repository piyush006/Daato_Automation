package ESRS_Report;

import static org.testng.Assert.assertEquals;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.PropertyUtilReaderESRS;
import Excel.utility.Xls_Reader;
import daato_automation_testcomponent.Getlatestfilepath;
import utils.AuthTokenadminUtil;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDownloader {
	
	
	
	
	String Parentenityname;
	String childentityname;
	String value1 ="12.0";
	String value2 ="12.0";
	String value3 ="12.0";
	String value4 ="12.0";
	String admintoken;
	String reportid;
	
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
	reportid=PropertyUtilReaderESRS.reportid();
	
}
	
	@Test(priority=1)

	public void downloadesrsexcel() {
		
		
		
		try {
            // API URL
           String urlStr = "https://qa.daato.app/api/esrs/disclosure-reporting/"+reportid+"/export-datapoint?dataPointIds=v5E1530,v5E152,v5E153,v5E154Calculated,v5E155,v5E156,v5E157,v5E158,v5E159Calculated,v5E1510,v5E1511,v5E1512,v5E1513,v5E1514,v5E1515,v5E1516Calculated,v5E1517,v5E1520,v5E1521,v5E1522,v5E1523,v5E1524,v5E1525,v5E1526,v5E1527,v5E1528,v5E1529";
         
			//String urlStr =	"https://qa.daato.app/api/esrs/disclosure-reporting/"+reportid+"/export-datapoint?dataPointIds=v5E1530";
			URL url = new URL(urlStr);
			
			System.out.println(url);

            // Open HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Set headers
            connection.setRequestProperty("Authorization", "Bearer " + admintoken);
            connection.setRequestProperty("Accept", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

            // Check response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Define folder path (relative to project root)
                File folder = new File("downloadedrsrlitefile");
                if (!folder.exists()) {
                    folder.mkdirs();  // create folder if not exists
                }

                // Define file path
                String filePath = "downloadedrsrlitefile/exported_data.xlsx";
                FileOutputStream outputStream = new FileOutputStream(filePath);

                // Download and save file
                InputStream inputStream = connection.getInputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();

                System.out.println("✅ Excel file downloaded to: " + filePath);
            } else {
                System.out.println("❌ Failed with HTTP code: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
}
	
	
	@Test(priority=2)
	
	public void Verifyexceldata() throws IOException {
		
		
		
		String downloadPath = System.getProperty("user.dir") + "/downloadedrsrlitefile";
		//String downloadPath = System.getProperty("download.dir", System.getProperty("user.dir") + "/downloads");
	    File latestFile = Getlatestfilepath.getLatestFileFromDir(downloadPath, ".xlsx");
	 
	    System.out.println(latestFile);
	    FileInputStream fis = new FileInputStream(latestFile);
	    Workbook workbook = new XSSFWorkbook(fis);
	    Xls_Reader reader = new Xls_Reader(latestFile.getAbsolutePath(), workbook);
	   // int count = reader.getRowCount("Impacts");
	String Parententityname = reader.getCellData("E1-5 37(v5E1530)", "Entity Name", 2);
	String Childentityname =reader.getCellData("E1-5 37(v5E1530)", "Entity Name", 3);
	String Reportingyearvalueparent = reader.getCellData("E1-5 37(v5E1530)", "Reporting year value", 2);
	String Reportingyearvaluechild = reader.getCellData("E1-5 37(v5E1530)", "Reporting year value", 3);
	String Comparativeyearvalueparent = reader.getCellData("E1-5 37(v5E1530)", "Comparative year value", 2);
	String Comparativeyearvaluechild = reader.getCellData("E1-5 37(v5E1530)", "Comparative year value", 3);
	
	System.out.println(Parententityname);
	System.out.println(Childentityname);
	System.out.println(Reportingyearvalueparent);
	System.out.println(Reportingyearvaluechild);
	System.out.println(Comparativeyearvalueparent);
	System.out.println(Comparativeyearvaluechild);
	
	

	    assertEquals(Reportingyearvalueparent, value1);
	    assertEquals(Reportingyearvaluechild, value1);
	    assertEquals(Comparativeyearvalueparent, value1);
	    assertEquals(Comparativeyearvaluechild, value1);
	    
		
		
		
			
		
	}	
	
	
	

}

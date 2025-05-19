package ESRS_Report;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.PropertyUtilReader;
import DMUTILS.PropertyUtilWriter;
import ESRS_UTILS.CreateESRSreport;
import ESRS_UTILS.ProperyUtilWriterESRS;
import io.restassured.RestAssured;
import utils.AuthTokenadminUtil;

public class CreateReport {

	
	

	String admintoken;
	String reportid;
	
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
   
   
		
		}
	
	
	@Test
	public void createsrsreport() {
		
		
		
		reportid = CreateESRSreport.createReportAndExtractId(admintoken);
		ProperyUtilWriterESRS.writeProperty("reportid", reportid);
		
}
	
	
	
	
}

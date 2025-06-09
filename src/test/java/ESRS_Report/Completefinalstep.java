package ESRS_Report;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.Completefinal;
import ESRS_UTILS.PropertyUtilReaderESRS;
import utils.AuthTokenadminUtil;

public class Completefinalstep {
	
	
	
	String reportid;
	String admintoken;
	
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
   
reportid=PropertyUtilReaderESRS.reportid();

	

}
	
	
	@Test
	public void completefinalstep() throws InterruptedException {
		
		Thread.sleep(3000);
		
		System.out.println(reportid);
		
		
		Completefinal.updateMultipleDisclosures(admintoken, reportid);	
		
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

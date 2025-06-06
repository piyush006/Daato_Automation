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
   
//reportid=PropertyUtilReaderESRS.reportid();
reportid="6842542585b3bba05cf448b8";
	

}
	
	
	@Test
	public void completefinalstep() {
		
		
		Completefinal.updateMultipleDisclosures(admintoken, reportid);	
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

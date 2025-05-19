package ESRS_Report;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.CheckaggregatedResult;
import ESRS_UTILS.PropertyUtilReaderESRS;
import ESRS_UTILS.ProperyUtilWriterESRS;
import utils.AuthTokenadminUtil;
import utils.AuthTokenchildentity;
import utils.AuthTokenparententity;

public class Checkaggregateresult {
	
String parententityid;
	
	
	String admintoken;
	String reportid;
	
	
	@BeforeClass
	public void getadmintoken() {
		
  
	
	
	
	
	admintoken= AuthTokenadminUtil.getAdminToken();
	reportid=PropertyUtilReaderESRS.reportid();
	}
	
	
	
	@Test(priority=1)
	public void checkaggregatedresultv5E152() {
		
		
		
		CheckaggregatedResult.getAggregatedDataStatus(admintoken, reportid);	
	
		
		
		
		
	}
	
	
	
	@Test(priority=2)
	public void checkaggregatedv5E154() {
		
		
		
		CheckaggregatedResult.getAggregatedDataStatuspercentage(admintoken, reportid);	
	
		
		
		
		
	}
	
	
	@Test(priority=3)

	public void getdisclousurerequirementid() {
		
		
		
		String disclosureRequirementReportId = CheckaggregatedResult.getDisclosureRequirementReportId(admintoken, reportid);
		
		
		System.out.println(disclosureRequirementReportId);
		
		
		ProperyUtilWriterESRS.writeProperty("disclosureRequirementReportId", disclosureRequirementReportId);
		
		
		
	}
	
	
	
	
	
@Test(priority=4)

public void completestep3() {
	
	
	
	CheckaggregatedResult.updateDisclosureSteps(admintoken, reportid);
	
	
	
	
	
	
}


	
	
	
	

}

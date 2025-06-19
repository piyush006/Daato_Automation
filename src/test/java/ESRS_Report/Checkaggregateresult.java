package ESRS_Report;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.Answerdatacollectionrequest;
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
	String disclosureRequirementReportId;
	
	
	@BeforeClass
	public void getadmintoken() {
		
   
	
	
	
	
	admintoken= AuthTokenadminUtil.getAdminToken();
	reportid=PropertyUtilReaderESRS.reportid();
	//disclosureRequirementReportId=PropertyUtilReaderESRS.disclosureRequirementReportId();
	}
	
	
	
	@Test(priority=1)
	public void checkaggregatedresultv5E152() {
		
		
		
		CheckaggregatedResult.getAggregatedDataStatus(admintoken, reportid);	
	
		
		System.out.println("TEST PASSED: Aggregated Data on third step for E15 data points showing correctly");
		
		
	}
	
	
	
	@Test(priority=2)
	public void checkaggregatedv5E154() {
		
		
		
		CheckaggregatedResult.getAggregatedDataStatuspercentage(admintoken, reportid);	
	
		System.out.println("TEST PASSED: % Aggregated Data on third step for E15 data points showing correctly");
		
		
		
	}
	
	
	@Test(priority=3)

	public void getdisclousurerequirementid() {
		
		
		
		 disclosureRequirementReportId = CheckaggregatedResult.getDisclosureRequirementReportId(admintoken, reportid);
		
		
		System.out.println(disclosureRequirementReportId);
		
		
		ProperyUtilWriterESRS.writeProperty("disclosureRequirementReportId", disclosureRequirementReportId);
		
		
		
	}
	
	
	
	
	




@Test(priority=4)


public void completeindividualdatapoints() {
	
	
	
	 // passed from another class or method

	String[] urls = {
	    "/collaborationDataPoint/v5E1530/finalDataPointId/v5E1530/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E152/finalDataPointId/v5E152/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E153/finalDataPointId/v5E153/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E154Calculated/finalDataPointId/v5E154Calculated/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E155/finalDataPointId/v5E155/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E156/finalDataPointId/v5E156/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E157/finalDataPointId/v5E157/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E158/finalDataPointId/v5E158/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E159Calculated/finalDataPointId/v5E159Calculated/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E1510/finalDataPointId/v5E1510/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E1511/finalDataPointId/v5E1511/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E1512/finalDataPointId/v5E1512/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E1513/finalDataPointId/v5E1513/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E1514/finalDataPointId/v5E1514/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure",
	    "/collaborationDataPoint/v5E1517/finalDataPointId/v5E1517/completed?pagesPath=ESRS-E1-Climate-Change-Disclosure-E1-5&module=esrs-disclosure"
	};

	for (String path : urls) {
	    String fullUrl = "https://qa.daato.app/api/reports/" + disclosureRequirementReportId + path;
	    System.out.println(fullUrl);
	    Answerdatacollectionrequest.markDataPointCompleted(admintoken, fullUrl);
	}
}
	
	
@Test(priority=5)

	public void completestep3() {
		
		
		
		CheckaggregatedResult.updateDisclosureSteps(admintoken, reportid);
		
		
		
		
		
		
	}


	
	
}


	
	
	
	



package ESRS_Report;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.GenerateReport;
import ESRS_UTILS.PropertyUtilReaderESRS;
import utils.AuthTokenadminUtil;

public class Generatereport {
	
	
	
	
	String reportid;
	String admintoken;
	
	String disclosureRequirementReportId;
	
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
	
	disclosureRequirementReportId = PropertyUtilReaderESRS.disclosureRequirementReportId();
   
	reportid =PropertyUtilReaderESRS.reportid();

	

}
	
	
	
@Test(priority=1)
	
	
	public void updatefinaldr() {
	
	System.out.println(disclosureRequirementReportId);
	
		GenerateReport.update(admintoken, disclosureRequirementReportId);
		
		
}
	
	
	
/*	@Test(priority=2)
	
	public void updateandcheckstatus() {
		
		
		GenerateReport.updateStatusWithTwoRounds(admintoken, reportid);	
		
		
		
	}*/
	
	
	
	
	
	
	
	
	
/*@Test(priority=2)

public void completeE15() throws InterruptedException {
	

	
	
	
	GenerateReport.updateStatus(admintoken, reportid);
	
	
}
	


@Test(priority=3)

public void getstatus() {
	
	
	
	
	String status =GenerateReport.getStatus(admintoken, reportid);
	System.out.println(status);
	
	
	
	
}*/	


	
	

}

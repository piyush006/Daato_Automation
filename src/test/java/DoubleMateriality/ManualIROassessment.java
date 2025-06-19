package DoubleMateriality;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.ManualIRO;
import DMUTILS.PropertyUtilReader;
import DMUTILS.PropertyUtilWriter;
import daato_automation_testcomponent.BaseTest;
import utils.AuthTokenadminUtil;

public class ManualIROassessment extends BaseTest{
	
	
	
	String admintoken;
	String extractedId;
	String reportId;
	String iroId;
	String Assessmentreportid;
	String contributorId;
	
	@BeforeClass()
	public void getadmintoken() {
				
	admintoken= AuthTokenadminUtil.getAdminToken();
	extractedId=PropertyUtilReader.extractedId();
	reportId=PropertyUtilReader.getReportId();
	Assessmentreportid=PropertyUtilReader.Assessmentreportid();
	iroId=PropertyUtilReader.iroId();
	contributorId=PropertyUtilReader.contributorId();
	}	
		
	
@Test(priority=1)
public void createmanualassessment() {
	
	
	
	
iroId = ManualIRO.createCustomIRO(admintoken, reportId);

System.out.println(iroId);

PropertyUtilWriter.writeProperty("iroId", iroId);


Assessmentreportid = ManualIRO.getAssessmentReportId(admintoken, reportId, iroId);

PropertyUtilWriter.writeProperty("Assessmentreportid", Assessmentreportid);

System.out.println(Assessmentreportid);

System.out.println("TEST PASSED: Manaul IRO Created Successfully");

}


@Test(priority=2)
public void assessmanualassessment() {
	
	
	
	
	
ManualIRO.performAllPutCalls(admintoken, Assessmentreportid, reportId, iroId);

System.out.println("TEST PASSED: Manaul IRO assessed successfully");

	
	
	
}

@Test(priority=3)

public void sendcollaborationrequest() {
	
	
	
	ManualIRO.sendcollaborationrequest(admintoken, reportId, Assessmentreportid, iroId, contributorId);
	
	
	System.out.println("TEST PASSED: Collaboration request sent Successfully");
	
	
	
	
}

	
	
}

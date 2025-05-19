package DoubleMateriality;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.Fillsurveryrequest;
import DMUTILS.PropertyUtilReader;
import utils.AuthTokenadminUtil;

public class Acceptandfinshsurveryrequest {
	
	
	
String admintoken;
String extractedId;
String reportId;


	@BeforeClass()
	public void getadmintoken() {
				
	admintoken= AuthTokenadminUtil.getAdminToken();
	extractedId=PropertyUtilReader.extractedId();
	reportId=PropertyUtilReader.getReportId();
	}	
	
	
@Test(priority=1)
public void acceptsurveyrequest() {
	
	
	
	

Fillsurveryrequest.acceptRequest(admintoken, extractedId);		
	
	
}	
	

@Test(priority=2)

	
public void fishsurvert()
{
	
	
	Fillsurveryrequest.deleteSurveyScope(admintoken, reportId);
	
	
	
}
	
	
	
	
	
	
}



package DoubleMateriality;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.Fillsurveryrequest;
import DMUTILS.PropertyUtilReader;
import DMUTILS.PropertyUtilWriter;
import utils.AuthTokenstakeholder;

public class Fillandsubmitsurveryrequest {
	
	
	String stakeholdertoken;
	String extractedId2;
	String contributorId;

	@BeforeClass()
	public void getadmintoken() {
				
		stakeholdertoken= AuthTokenstakeholder.getstaketoken();
		extractedId2=PropertyUtilReader.extractedId();
	}		
	
	
	
	
	@Test(priority=1)

	public void filldatarequest() {
		
		
		
		
	
		
	Fillsurveryrequest.submitScoring(stakeholdertoken, extractedId2);
		
	System.out.println("TEST PASSED: Survery Request Filled Sucessfully by Stakeholder");
		
		
	}	
	
	
	//@Test(enabled=false)	
@Test(priority=2)
	
	
public void addentityspecificdisclousre() {
	
	
	Fillsurveryrequest.submitCustomMatter(stakeholdertoken, extractedId2);
	
	System.out.println("TEST PASSED: Entity Specific Disclousure added Successfully by Stakeholder");
	
}	
	//@Test(enabled=false)
@Test(priority=3)
	
public void submitrequest() {
	
	
	
	
	Fillsurveryrequest.updateRequestStatus(stakeholdertoken, extractedId2);
	
	System.out.println("TEST PASSED: Stakeholder submitted the request Successfully");
	
}


@Test(priority=4)

public void getcontributorid() {
	
	
	
contributorId =	Fillsurveryrequest.getContributorId(stakeholdertoken);
	
PropertyUtilWriter.writeProperty("contributorId", contributorId);
	
	
	
	
}


	
	
	
}

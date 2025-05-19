package ESRS_Report;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.PropertyUtilReaderESRS;
import ESRS_UTILS.Submitrequest;
import utils.AuthTokenadminUtil;
import utils.AuthTokenchildentity;
import utils.AuthTokenparententity;

public class Submitdatacollectioknrequest {
	
	String parententityid;
	
	String childentityid;

	String dataCollectionId;
	String esrsentitydatacollectionid;
	String esrsentitydatacollectionidparent;
	String childentitytoken;
	String parententitytoken;
	String admintoken;
	
	@BeforeClass
	public void getadmintoken() {
		
  
	
	parententityid =PropertyUtilReaderESRS.parententityid();
	childentityid =PropertyUtilReaderESRS.childentityid();
	dataCollectionId=PropertyUtilReaderESRS.dataCollectionId();
	childentitytoken =AuthTokenchildentity.getchildtoken();
	parententitytoken=AuthTokenparententity.getparenttoken();
	admintoken= AuthTokenadminUtil.getAdminToken();
	}
	
	
	
@Test(priority=1)
public void submitchildcollectionrequest() {
	
	
	
	
	
	Submitrequest.updateEntityStatusToCompleted(childentitytoken, dataCollectionId, childentityid);
	
	
	
	
	
	
	
}	
	
@Test(priority=2)	
	
	
public void submitparentcollectionrequest() {
	
	
	
	
	
	Submitrequest.updateEntityStatusToCompleted(parententitytoken, dataCollectionId, parententityid);
	
	
	
	
	
	
	
}




@Test(priority=3)

public void completedatacollection() {
	
	
	
	Submitrequest.updateWorkflowStatus(admintoken, dataCollectionId);
	
	
	
	
}
	
	
	
	

}

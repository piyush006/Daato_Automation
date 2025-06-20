package ESRS_Report;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.Answerdatacollectionrequest;
import ESRS_UTILS.PropertyUtilReaderESRS;
import utils.AuthTokenadminUtil;
import utils.AuthTokenchildentity;
import utils.AuthTokenparententity;

public class Answerdatarequest {
	
    String parententityid;
	
	String childentityid;
	
	
	String admintoken;
	String reportid;
	String entityspecificdisclousureid;
	String dataCollectionId;
	String esrsentitydatacollectionid;	
	String getEntityDataCollectionIdparent;
	
	String parentid;
	String parentemail;
	
	String childid;
	String childemail;
	String childentitytoken;
	String parententitytoken;

	
	
	@BeforeClass
	public void getadmintoken() {
		
	//admintoken= AuthTokenadminUtil.getAdminToken();
	childentitytoken =AuthTokenchildentity.getchildtoken();
	parententitytoken=AuthTokenparententity.getparenttoken();
	admintoken=AuthTokenadminUtil.getAdminToken();
   
	reportid=PropertyUtilReaderESRS.reportid();
	
	parententityid =PropertyUtilReaderESRS.parententityid();
	childentityid =PropertyUtilReaderESRS.childentityid();
	dataCollectionId=PropertyUtilReaderESRS.dataCollectionId();
	esrsentitydatacollectionid=PropertyUtilReaderESRS.esrsentitydatacollectionid();
	getEntityDataCollectionIdparent=PropertyUtilReaderESRS.esrsentitydatacollectionidparent();
	
	
	}	 
	
	
	
	@Test(priority=1)
	public void startchilddatacollection() {
		
		

	        Answerdatacollectionrequest.sendAllRequestschild(childentitytoken, esrsentitydatacollectionid);
		
	        System.out.println("TEST PASSED: Child Entity filled E15 Data points successfully");
		
	}
	
	
	@Test(priority=2)
	
	public void completedatacollectionchild() {
		
		
		System.out.println(childentitytoken);
		System.out.println(dataCollectionId);
		System.out.println(childentityid);
		
		
		Answerdatacollectionrequest.updateStatuschild(childentitytoken, dataCollectionId, childentityid);
		
		
		System.out.println("TEST PASSED: Child Entity Data collection Request completed successfully");
		
		
	}
	
	
	
@Test(priority=3)
	
	
	public void startparentdatacollection() {
		
		

	        Answerdatacollectionrequest.sendAllRequestsparent(parententitytoken, getEntityDataCollectionIdparent);
		
				
	        System.out.println("TEST PASSED: Parent Entity filled E15 Data points under own data collection tab successfully ");
		
	}
	
	
	
	
	@Test(priority=4)
	
	
	public void completedatacollectionparent() {
		
		
		
		 Answerdatacollectionrequest.updateStatusparent(parententitytoken, dataCollectionId,parententityid);
		
		 System.out.println("TEST PASSED: Parent Entity Data Collection completed successfully");
		
		
		
	}
	
	
	
	@Test(priority=5)
	
	
	public void Completedatacollection() {
		
		
		
		Answerdatacollectionrequest.completeDataCollection(admintoken, dataCollectionId);	
		
		
		
		
		
		
	}	
	
	
	
	
	

}

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
		
		
		
	}
	
	
	@Test(priority=2)
	
	public void completedatacollectionchild() {
		
		
		System.out.println(childentitytoken);
		System.out.println(dataCollectionId);
		System.out.println(childentityid);
		
		
		Answerdatacollectionrequest.updateStatuschild(childentitytoken, dataCollectionId, childentityid);
		
		
		
		
		
	}
	
	
	
@Test(priority=3)
	
	
	public void startparentdatacollection() {
		
		

	        Answerdatacollectionrequest.sendAllRequestsparent(parententitytoken, getEntityDataCollectionIdparent);
		
				
		
	}
	
	
	
	
	@Test(priority=4)
	
	
	public void completedatacollectionparent() {
		
		
		
		 Answerdatacollectionrequest.updateStatusparent(parententitytoken, dataCollectionId,parententityid);
		
		
		
		
		
	}
	
	
	
	@Test(priority=5)
	
	
	public void Completedatacollection() {
		
		
		
		Answerdatacollectionrequest.completeDataCollection(admintoken, dataCollectionId);	
		
		
		
		
		
	}	
	
	
	
	
	

}

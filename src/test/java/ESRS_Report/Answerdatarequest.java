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
	
   
	reportid=PropertyUtilReaderESRS.reportid();
	
	parententityid =PropertyUtilReaderESRS.parententityid();
	childentityid =PropertyUtilReaderESRS.childentityid();
	dataCollectionId=PropertyUtilReaderESRS.childentityid();
	esrsentitydatacollectionid=PropertyUtilReaderESRS.esrsentitydatacollectionid();
	getEntityDataCollectionIdparent=PropertyUtilReaderESRS.esrsentitydatacollectionidparent();
	}	
	
	
	
	@Test(priority=1)
	public void startchilddatacollection() {
		
		

	        Answerdatacollectionrequest.sendAllRequestschild(childentitytoken, esrsentitydatacollectionid);
		
		
		
	}
	
	@Test(priority=2)
	
	
	public void startparentdatacollection() {
		
		

	        Answerdatacollectionrequest.sendAllRequestsparent(parententitytoken, getEntityDataCollectionIdparent);
		
				
		
	}

}

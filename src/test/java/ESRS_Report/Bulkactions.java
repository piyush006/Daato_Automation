package ESRS_Report;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.Bulkactionstep2;
import ESRS_UTILS.PropertyUtilReaderESRS;
import ESRS_UTILS.ProperyUtilWriterESRS;
import utils.AuthTokenadminUtil;
import static org.testng.Assert.assertFalse;

public class Bulkactions {
	
String parententityid;
	
	String childentityid;
	
	
	String admintoken;
	String reportid;
	String entityspecificdisclousureid;
	String dataCollectionId;
	String esrsentitydatacollectionid;
	String esrsentitydatacollectionidparent;
	
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
   
	reportid=PropertyUtilReaderESRS.reportid();
	
	parententityid =PropertyUtilReaderESRS.parententityid();
	childentityid =PropertyUtilReaderESRS.childentityid();
	dataCollectionId=PropertyUtilReaderESRS.dataCollectionId();
	esrsentitydatacollectionid=PropertyUtilReaderESRS.esrsentitydatacollectionid();
	
}
		
@Test(priority = 1)
	
	
	public void markE16voluntaryoff() throws InterruptedException {
		
		
		
		 
		
		
		System.out.println(admintoken);
		System.out.println(reportid);
		
		boolean included = Bulkactionstep2.updateDataPointDefinitions(admintoken, reportid);
        System.out.println("Returned included value: " + included);
		
		
        assertFalse(included, "❌ Test failed: 'included' is not false for ID v5E169");
		
        System.out.println("TEST PASSED: Some data points of Disclosure E16 marked as voluntary Successfully");
		
	}
	
	
	
	

	
	

 @Test(priority=2)
	
	public void markE17nonmaterial() {
		
		
		Bulkactionstep2.markE17nonmateridal(admintoken, reportid);	
		
		
		 System.out.println("TEST PASSED: Disclosure E17 marked as Non material Successfully");
		
		
		
	
	}
	
	
	
	@Test(priority=3)
		
public void completestep1() {
		
		
		
		Bulkactionstep2.completestep1(admintoken, reportid);
		
		
		 System.out.println("TEST PASSED: Step 1 Completed Successfully");
		
		
	}


	@Test(priority = 4)
	
public void assigndatapointtoentity() throws InterruptedException {
	
	
	
	
Bulkactionstep2.aggregatedatapoints(admintoken, reportid, parententityid, childentityid);

	
System.out.println("TEST PASSED: Assigned E15 data points to Parent and Child Entity Successfully");
	
}
	
	
	@Test(priority=5)
public void completestep2() {
	
	
	
	Bulkactionstep2.completestep2(admintoken, reportid);
	
	System.out.println("TEST PASSED: Step 2 Completed Successfully");
	
}
	
	
	




	@Test(priority=6)

public void startdatacollection() {
	
	

	Bulkactionstep2.startReport(admintoken, reportid);
	
	System.out.println("TEST PASSED: Data collection started Successfully");

	
}


	@Test(priority=7)

public void getdatacollectionid() {
	
	
	
	dataCollectionId = Bulkactionstep2.getDataCollectionId(admintoken, reportid);
	
	System.out.println(dataCollectionId);
	
	ProperyUtilWriterESRS.writeProperty("dataCollectionId", dataCollectionId);
	
	
}


	@Test(priority=8)

public void getesrsentitydatacollectionid() {
	
    

	esrsentitydatacollectionid = Bulkactionstep2.getEntityDataCollectionId(admintoken, dataCollectionId);
    System.out.println("Extracted ID: " + esrsentitydatacollectionid);	
    
    ProperyUtilWriterESRS.writeProperty("esrsentitydatacollectionid", esrsentitydatacollectionid);
	
	
	
	
	
	
	
}


	@Test(priority=9)
public void getesrsentitydatacollectionidparent() {
	
    

	esrsentitydatacollectionidparent = Bulkactionstep2.getEntityDataCollectionIdparent(admintoken, dataCollectionId);
    System.out.println("Extracted ID: " + esrsentitydatacollectionidparent);	
    
    ProperyUtilWriterESRS.writeProperty("esrsentitydatacollectionidparent", esrsentitydatacollectionidparent);


}
	

	

}

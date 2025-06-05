package ESRS_Report;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.PropertyUtilReader;
import ESRS_UTILS.CreateESRSreport;
import ESRS_UTILS.PropertyUtilReaderESRS;
import ESRS_UTILS.ProperyUtilWriterESRS;
import utils.AuthTokenadminUtil;

public class Createentityspecificdis {
	
	
	
	String admintoken;
	String reportid;
	String entityspecificdisclousureid;
	
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
   
	reportid=PropertyUtilReaderESRS.reportid();
		
		}
	
	
	
	
	@Test (priority=1)
	public void createentityspecificdis() {
		
		
		
		CreateESRSreport.createEntityCustomDisclosure(admintoken, reportid);	
		
		
			}
	
	
	
	@Test(priority=2)
	public void getid() {
		
		
		
	//	CreateESRSreport.getDisclosureIdForMdr1(admintoken, reportid);
		
	 entityspecificdisclousureid = CreateESRSreport.getDisclosureIdForMdr1(admintoken, reportid);
		System.out.println("MDR1 Disclosure ID: " + entityspecificdisclousureid);
		
		ProperyUtilWriterESRS.writeProperty("entityspecificdisclousureid", entityspecificdisclousureid);
	
	}
	
	
	
	@Test(priority=3)
	public void markasnonmaterialentityspecifc() throws InterruptedException {
		
		
		CreateESRSreport.updateEsrsEntity(admintoken, reportid, entityspecificdisclousureid);
		
		 Thread.sleep(5000);
		
		
	}
	
	
	

}

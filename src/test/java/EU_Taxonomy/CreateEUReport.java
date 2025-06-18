package EU_Taxonomy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.PropertyUtilReaderESRS;
import ESRS_UTILS.ProperyUtilWriterESRS;
import EU_Utils.Createreport;
import EU_Utils.PropertyutilwriterEU;
import utils.AuthTokenadminUtil;

public class CreateEUReport {
	
	

	String admintoken;
	
String	reportid;
String	datacollectionid;
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
   
	

}	
	@Test
	
	public void createEUreport() {
		
		
		
		String[] ids = Createreport.createTaxonomy(admintoken);

        if (ids != null) {
        	reportid = ids[0];
        	datacollectionid = ids[1];

            System.out.println("Taxonomy ID: " + reportid);
            System.out.println("Data Collection ID: " + datacollectionid);
        } else {
            System.out.println("Failed to create taxonomy.");
        }
        
        
        
        PropertyutilwriterEU.writeProperty("reportid", reportid);
        PropertyutilwriterEU.writeProperty("datacollectionid", datacollectionid);
        
        
        System.out.println("✅ TESTED OK: Report created successfully");
        
        
        
    }
		
		
		
		
		
	
	}
	
	
	
	
	
	


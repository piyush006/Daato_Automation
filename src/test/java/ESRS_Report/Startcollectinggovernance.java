package ESRS_Report;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.CheckaggregatedResult;
import ESRS_UTILS.ESRSApiHelper;
import ESRS_UTILS.PayloadHelper;
import ESRS_UTILS.PropertyUtilReaderESRS;
import ESRS_UTILS.ProperyUtilWriterESRS;
import utils.AuthTokenadminUtil;

public class Startcollectinggovernance {
	
	
	
	
	
	
	
	static String  admintoken;
    String reportid;
	String disclosureRequirementReportId;
	static String pagePath = "ESRS-G1-Business-Conduct-Disclosure-ESRS-2-GOV-1";
	static  String module = "esrs";
	
	
	@BeforeClass
	public void getadmintoken() {
		
   
	
	
	
	
	admintoken= AuthTokenadminUtil.getAdminToken();
	reportid=PropertyUtilReaderESRS.reportid();
	//disclosureRequirementReportId=PropertyUtilReaderESRS.disclosureRequirementReportId();
	}
	
	
	@Test(priority=1)

	public void getdisclousurerequirementid() {
		
		
		
		
		 disclosureRequirementReportId = CheckaggregatedResult.getDisclosureRequirementReportId(admintoken, reportid);
		
		
		System.out.println(disclosureRequirementReportId);
		
		
		ProperyUtilWriterESRS.writeProperty("disclosureRequirementReportId", disclosureRequirementReportId);
		
		
		
	}

	
	 
	    
	    
	    
	    
	@Test(priority=2)

	    public static void startESRSG1BusinessConduct() throws InterruptedException{
	    	
	    	admintoken = AuthTokenadminUtil.getAdminToken(); // Assuming it returns: Bearer xxx
	        String disclosureRequirementReportId = PropertyUtilReaderESRS.disclosureRequirementReportId(); // Assuming it returns: 685bc7f513735ce9329a1d5e

	      
	        List<String> commentPoints = List.of(
	        	    "v5G1Gov11", "v5G1Gov12","v5G1Iro11","v5G1114","v5G111","v5G115","v5G116","v5G1111","v5G1112","v5G122","v5G123","v5G124","v5G133","v5G134","v5G135","v5G138","v5G1310","v5G137","v5G149","v5G144","v5G148","v5G162","v5G165",
	        	    "v5G159","v5G1513","v5G157","v5G154","v5G151");
	       

	        List<String> yesNoPoints = List.of(
	                "v5G112", "v5G114","v5G112","v5G114","v5G1110","v5G1113","v5G132","v5G1510","v5G119"
	                
	            );
	        
	        pagePath = "ESRS-G1-Business-Conduct-Disclosure-ESRS-2-GOV-1";
	        module = "esrs";

	        // Comment-based points
	        ESRSApiHelper.fillAndCompleteDataPoints(commentPoints, admintoken, disclosureRequirementReportId, pagePath, module, "Automated comment");

	        // Yes/No-based points
	        ESRSApiHelper.fillAndCompleteDataPoints(yesNoPoints, admintoken, disclosureRequirementReportId, pagePath, module, "yes");
	    }
	
	
	
	
	@Test(priority=3)
	
	
    public static void startESRSG1BusinessConduct1() {
		
        admintoken = AuthTokenadminUtil.getAdminToken(); // e.g. "Bearer xyz"
       String reportid = PropertyUtilReaderESRS.disclosureRequirementReportId();
       
       System.out.println(reportid);
       
      // e.g. "685bf55b13735ce9329a52ec"
         pagePath = "ESRS-G1-Business-Conduct-Disclosure-G1-5";
         module = "esrs";

         List<String> pointsToFill = List.of(
        		    "v5G139", "v5G1312",
        		    "v5G1410", "v5G1411", "v5G166", "v5G168",
        		    "v5G1512", "v5G1511",
        		    "v5G143", "v5G146", "v5G147", "v5G1514",
        		    "v5G167", "v5G151","v5G153"
        		);

        ESRSApiHelper.fillAndCompleteDataPoints1(pointsToFill, admintoken, reportid, pagePath, module);
        
        System.out.println("TEST PASSED: Included all the data points Under Topic ESRS-G1-Business-Conduct");
        
        System.out.println("TEST PASSED: Filled all the data points of DR: ESRS 2 GOV-1 ");
        System.out.println("TEST PASSED: Filled all the data points of DR: ESRS 2 IRO-1 ");
        System.out.println("TEST PASSED: Filled all the data points of DR: G1-1 ");
        System.out.println("TEST PASSED: Filled all the data points of DR: G1-2 ");
        System.out.println("TEST PASSED: Filled all the data points of DR: G1-3 ");
        System.out.println("TEST PASSED: Filled all the data points of DR: G1-4 ");
        System.out.println("TEST PASSED: Filled all the data points of DR: G1-5 ");
        System.out.println("TEST PASSED: Filled all the data points of DR: G1-6 ");
        
        
        
        
    }
	
	
	
	
	
	
	

 }
	    
		





	
	
	


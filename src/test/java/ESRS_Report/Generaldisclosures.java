package ESRS_Report;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.CheckaggregatedResult;
import ESRS_UTILS.PropertyUtilReaderESRS;
import ESRS_UTILS.ProperyUtilWriterESRS;
import ESRSfulldatapointshelper.Generaldisclosureshelper;
import utils.AuthTokenadminUtil;

public class Generaldisclosures {
	
	
	

	
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
	
	
    public static void startESRSG1BusinessConduct1() {
		
        admintoken = AuthTokenadminUtil.getAdminToken(); // e.g. "Bearer xyz"
       String reportid = PropertyUtilReaderESRS.disclosureRequirementReportId();
       
       System.out.println(reportid);
       
      // e.g. "685bf55b13735ce9329a52ec"
         pagePath = "ESRS-2-General-Disclosures-Disclosure-BP-1";
         module = "esrs";

         List<String> pointsToFill = List.of(
        		    "v5Esrs2Bp11", "v5Esrs2Bp12", "v5Esrs2Bp16", "v5Esrs2Bp18", "v5Esrs2Bp22",
        		    "v5Esrs2Bp26", "v5Esrs2Bp216", "v5Esrs2Bp221", "v5Esrs2Bp228", "v5Esrs2Bp232",
        		    "v5Esrs2Bp235", "v5Esrs2Gov31", "v5Esrs2Sbm16", "v5Esrs2Sbm111", "v5Esrs2Sbm117",
        		    "v5Esrs2Sbm119", "v5Esrs2Sbm121", "v5Esrs2Iro22", "v5Esrs2Iro24", "v5Esrs2Iro26",
        		    "v5Esrs2Iro28", "v5Esrs2Iro210", "v5Esrs2Iro212", "v5Esrs2Iro214", "v5Esrs2Iro216",
        		    "v5Esrs2Iro218", "v5Esrs2Iro220", "v5Esrs2Bp14", "v5Esrs2Bp15", "v5Esrs2Bp23",
        		    "v5Esrs2Bp24", "v5Esrs2Bp27", "v5Esrs2Bp28", "v5Esrs2Bp29", "v5Esrs2Bp210",
        		    "v5Esrs2Bp217", "v5Esrs2Bp218", "v5Esrs2Bp219", "v5Esrs2Bp222", "v5Esrs2Bp223",
        		    "v5Esrs2Bp224", "v5Esrs2Bp226", "v5Esrs2Bp227", "v5Esrs2Bp229", "v5Esrs2Bp230",
        		    "v5Esrs2Bp233", "v5Esrs2Gov17", "v5Esrs2Gov18", "v5Esrs2Gov110", "v5Esrs2Gov113",
        		    "v5Esrs2Gov114", "v5Esrs2Gov115", "v5Esrs2Gov116", "v5Esrs2Gov117", "v5Esrs2Gov118",
        		    "v5Esrs2Gov119", "v5Esrs2Gov120", "v5Esrs2Gov121", "v5Esrs2Gov122", "v5Esrs2Gov21",
        		    "v5Esrs2Gov22", "v5Esrs2Gov23", "v5Esrs2Gov24", "v5Esrs2Gov32", "v5Esrs2Gov33",
        		    "v5Esrs2Gov34", "v5Esrs2Gov36", "v5Esrs2Gov51", "v5Esrs2Gov52", "v5Esrs2Gov53",
        		    "v5Esrs2Gov54", "v5Esrs2Gov55", "v5Esrs2Sbm12", "v5Esrs2Sbm13", "v5Esrs2Sbm17",
        		    "v5Esrs2Sbm110", "v5Esrs2Sbm123", "v5Esrs2Sbm124", "v5Esrs2Sbm125", "v5Esrs2Sbm126",
        		    "v5Esrs2Sbm127", "v5Esrs2Sbm128", "v5Esrs2Sbm129", "v5Esrs2Sbm130", "v5Esrs2Sbm212",
        		    "v5Esrs2Sbm21", "v5Esrs2Sbm22", "v5Esrs2Sbm23", "v5Esrs2Sbm24", "v5Esrs2Sbm25",
        		    "v5Esrs2Sbm26", "v5Esrs2Sbm28", "v5Esrs2Sbm29", "v5Esrs2Sbm210", "v5Esrs2Sbm211",
        		    "v5Esrs2Sbm32", "v5Esrs2Sbm33", "v5Esrs2Sbm34", "v5Esrs2Iro10", "v5Esrs2Iro11",
        		    "v5Esrs2Iro12", "v5Esrs2Iro13", "v5Esrs2Iro14", "v5Esrs2Iro15", "v5Esrs2Iro16",
        		    "v5Esrs2Iro17", "v5Esrs2Iro18", "v5Esrs2Iro19", "v5Esrs2Iro110", "v5Esrs2Iro111",
        		    "v5Esrs2Iro112", "v5Esrs2Iro113", "v5Esrs2Iro114", "v5Esrs2Iro222", "v5Esrs2Gov15",
        		    "v5Esrs2Gov16", "v5Esrs2Sbm14", "v5Esrs2Sbm18", "v5Esrs2Sbm112", "v5Esrs2Sbm113",
        		    "v5Esrs2Sbm114", "v5Esrs2Sbm115", "v5Esrs2Sbm116", "v5Esrs2Sbm118", "v5Esrs2Sbm120",
        		    "v5Esrs2Sbm122", "v5Esrs2Bp247", "v5Esrs2Gov19", "v5Esrs2Gov111", "v5Esrs2Gov35",
        		    "v5Esrs2Gov42", "v5Esrs2Sbm15", "v5Esrs2Sbm19", "v5Esrs2Sbm31Impact", "v5Esrs2Sbm31Risk",
        		    "v5Esrs2Iro223", "v5Esrs2Iro224"
        		);

         Generaldisclosureshelper.fillAndCompleteDataPoints1(pointsToFill, admintoken, reportid, pagePath, module);
         
         
         
         System.out.println("TEST PASSED: Included all the data points Under Topic ESRS-2-General-Disclosures");
         
         System.out.println("TEST PASSED: Filled all the data points of DR: ESRS 2 GOV-1 ");
         System.out.println("TEST PASSED: Filled all the data points of DR: BP-1 ");
         System.out.println("TEST PASSED: Filled all the data points of DR: BP-2  ");
         System.out.println("TEST PASSED: Filled all the data points of DR: GOV-1 ");
         System.out.println("TEST PASSED: Filled all the data points of DR: GOV-2 ");
         System.out.println("TEST PASSED: Filled all the data points of DR: GOV-3 ");
         System.out.println("TEST PASSED: Filled all the data points of DR: GOV-4 ");
         System.out.println("TEST PASSED: Filled all the data points of DR: GOV-5 ");
         System.out.println("TEST PASSED: Filled all the data points of DR: SBM-1 ");
         System.out.println("TEST PASSED: Filled all the data points of DR: SBM-2 ");
         System.out.println("TEST PASSED: Filled all the data points of DR: SBM-3 ");
         
         
         
         
         
         
         
    }	
	
	
	
	
	
	
	
	
	
	
	
	

}

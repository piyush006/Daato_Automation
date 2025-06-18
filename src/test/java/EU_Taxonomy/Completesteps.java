package EU_Taxonomy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EU_Utils.Completestep;
import EU_Utils.PropertyUtilsreadereu;
import utils.AuthTokenadminUtil;

public class Completesteps {
	
	
	
	String admintoken;
	
	String	reportid;
	String	datacollectionid;

	String Min91;
	String Min32;
	String Activityid92;
	String Activityid32;
	String	Alingmentid92;
	String Alingmentid32;


		
		@BeforeClass
		public void getadmintoken() {
			
		admintoken= AuthTokenadminUtil.getAdminToken();
		reportid =PropertyUtilsreadereu.reportid();
		datacollectionid=PropertyUtilsreadereu.datacollectionid();
		Min91=PropertyUtilsreadereu.Mins91();
		Min32=PropertyUtilsreadereu.Mins32();
		Activityid92=PropertyUtilsreadereu.Activityid92();
	    Activityid32=PropertyUtilsreadereu.Activityid32();
	    Alingmentid92=PropertyUtilsreadereu.Alingmentid92();
	    Alingmentid32=PropertyUtilsreadereu.Alingmentid32();
         
	}		
		
	
	
	@Test
	public void completestep() {
		
		
		
		Completestep.updateSteps(admintoken, reportid);	
		
		
		System.out.println("✅ TESTED OK: All the steps completed Successfully");
		
		
	}
	
	
	
	
	
	

}

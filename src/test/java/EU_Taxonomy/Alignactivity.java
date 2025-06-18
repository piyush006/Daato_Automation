package EU_Taxonomy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EU_Utils.Alignactivity92;
import EU_Utils.Alignactivityutility;
import EU_Utils.Createactivity;
import EU_Utils.PropertyUtilsreadereu;
import utils.AuthTokenadminUtil;

public class Alignactivity {
	
	
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
	
	
	
	
	
	@Test(priority=1)
	
	
	public void alignactivity32() {
		
		
		
	System.out.println(Alingmentid32);	
		
		
	Alignactivityutility client = new Alignactivityutility(admintoken, Alingmentid32, reportid, Activityid32);
      client.sendAllRequests();
		
      System.out.println("✅ TESTED OK: Activity 3.2 Aligned successfully");
		
		
	}
	
	@Test(priority=2)
	
	
	public void alignactivity92() {
		
		
		
		System.out.println(Alingmentid92);	
		
		
		Alignactivity92 client = new Alignactivity92(admintoken, Alingmentid92, reportid, Activityid32);
	      client.sendAllRequests();
				
		
		
	      System.out.println("✅ TESTED OK: Activity 9.1 Aligned successfully");
		
		
	}
	
	
	
	
	
	
	

}

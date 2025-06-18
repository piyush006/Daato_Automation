package EU_Taxonomy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EU_Utils.Fillmsafguard;
import EU_Utils.PropertyUtilsreadereu;
import utils.AuthTokenadminUtil;

public class Fillminimumsafeguard {
	
	
String admintoken;
	
String	reportid;
String	datacollectionid;

String Min91;
String Min32;
String Activityid92;
String Activityid32;


	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
	reportid =PropertyUtilsreadereu.reportid();
	datacollectionid=PropertyUtilsreadereu.datacollectionid();
	Min91=PropertyUtilsreadereu.Mins91();
	Min32=PropertyUtilsreadereu.Mins32();
	Activityid92=PropertyUtilsreadereu.Activityid92();
    Activityid32=PropertyUtilsreadereu.Activityid32();

}
	
	
	
	@Test(priority=1)
	public void fillMS92() {
		
		Fillmsafguard.submitAll(admintoken, Min91, reportid, Activityid92);
		
		
		System.out.println("✅ TESTED OK: Minimum Safeguard for 9.1 Activity satisfied");
		
		
	}
	
	
	@Test(priority=2)
	
	public void fillms32() {
		
		
		Fillmsafguard.submitAll(admintoken, Min32, reportid, Activityid32);	
		
		
		System.out.println("✅ TESTED OK: Minimum Safeguard for 3.2 Activity satisfied");
	}
	
	
	
	
	
	

}

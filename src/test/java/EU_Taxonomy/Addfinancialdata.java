package EU_Taxonomy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EU_Utils.Financial;
import EU_Utils.PropertyUtilsreadereu;
import utils.AuthTokenadminUtil;

public class Addfinancialdata {
	
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
	public void Updatestatus() {
		
		
		
		
		Financial.updateStatus(admintoken, reportid);	
		
	
		
		
	}
	
	
@Test(priority=2)	
	
	public void addfinancialdata() {
	
	
	Financial.sendFinancialInformation(admintoken, reportid);
	
	
	 System.out.println("✅ Organization financial data updated successfully");
	
}
	
	
@Test(priority=3)
	
public void addfinancialdata92() {
	
	
	Financial.sendFinancialInformation92(admintoken, reportid, Activityid92);
	
	System.out.println("✅ Activity 9.2 financial data updated successfully");
	
}



@Test(priority=4)

public void addfinancialdata32() {


Financial.sendFinancialInformation92(admintoken, reportid, Activityid32);


System.out.println("✅ Activity 3.2 financial data updated successfully");

}
	
	
	
	
	
	
	
	

}

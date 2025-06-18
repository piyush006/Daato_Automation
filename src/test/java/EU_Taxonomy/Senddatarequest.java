package EU_Taxonomy;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.PropertyUtilReader;
import EU_Utils.Datarequest;
import EU_Utils.PropertyUtilsreadereu;
import EU_Utils.PropertyutilwriterEU;
import daato_automation_page.Fillsurvey;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_testcomponent.TestConstants;
import utils.AuthTokenadminUtil;

public class Senddatarequest {
	
	String admintoken;
		
	String	reportid;
	String	datacollectionid;
	String Activityid32;
	
	String dataproviderid;
	
	String Mins32;
	
	String Email;
		
		@BeforeClass
		public void getadmintoken() {
			
		admintoken= AuthTokenadminUtil.getAdminToken();
		reportid =PropertyUtilsreadereu.reportid();
		datacollectionid=PropertyUtilsreadereu.datacollectionid();
		Activityid32= PropertyUtilsreadereu.Activityid32();
		Mins32=PropertyUtilsreadereu.Mins32();
	}
		
	

	
@Test(priority=1)

public void createuser() {
	
	
		
 dataproviderid = Datarequest.createUser(admintoken);
 
 
 PropertyutilwriterEU.writeProperty("dataproviderid", dataproviderid);
	
}
	
	
@Test(priority=2)	


public void senddatarequest() {
	
	
	String dataproviderid = PropertyUtilsreadereu.dataproviderid();
	
	
	Datarequest.sendRequest(admintoken, reportid, Activityid32, Mins32, dataproviderid);
	
	
	System.out.println("🧪 TEST PASSED: Data request sent successfully");

	
	
}
	
	





	

}

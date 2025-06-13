package EU_Taxonomy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.PropertyUtilReaderESRS;
import EU_Utils.Createactivity;
import EU_Utils.PropertyUtilsreadereu;
import utils.AuthTokenadminUtil;

public class Addactivity {
	
	
	String admintoken;
	
String	reportid;
String	datacollectionid;
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
	reportid =PropertyUtilsreadereu.reportid();
	datacollectionid=PropertyUtilsreadereu.datacollectionid();

}
	
	
	
	
	
@Test(priority=1)	
public void addactivity() {
	
	
	
	
	Createactivity.createMyTaxonomy(admintoken, reportid, datacollectionid);
	
	
	
	
	
	
	
	
	
	
}	
	

	
	
	
	

}

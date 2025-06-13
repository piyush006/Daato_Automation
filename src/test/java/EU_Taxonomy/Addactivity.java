package EU_Taxonomy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.PropertyUtilReaderESRS;
import ESRS_UTILS.ProperyUtilWriterESRS;
import EU_Utils.Createactivity;
import EU_Utils.PropertyUtilsreadereu;
import EU_Utils.PropertyutilwriterEU;
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
public void addactivityfirst() {
	
	
	System.out.println(datacollectionid);
	
	Createactivity.createTaxonomy(admintoken, reportid, datacollectionid);
	
	
	
	
	
	}	
	

@Test(priority=2)
	
	
	public void addactivitsecond(){
		
		
		
		Createactivity.createSecondTaxonomy(admintoken, reportid, datacollectionid);	
		
		
		
		}
	
	
@Test(priority=3)
	public void fetchidsofminsafguard() {
		
		
		Createactivity.fetchSafeguardIds(admintoken, reportid, datacollectionid);

        // You can now use:
        String idFor_9_1_3_2 = Createactivity.safeguardFor_9_1_3_2;
        String idFor_3_2 = Createactivity.safeguardFor_3_2;
        
        String Activityidfor92=Createactivity.idFor_9_1_3_2;
        String Activityidfor32=Createactivity.idFor_3_2;

        System.out.println("Safeguard ID for 9.1_3.2 (from main): " + idFor_9_1_3_2);
        System.out.println("Safeguard ID for 3.2 (from main): " + idFor_3_2);
        System.out.println("_id for 9.1_3.2: " + Activityidfor92);
        System.out.println("_id for 3.2: " + Activityidfor32);
		
        PropertyutilwriterEU.writeProperty("Mins91", idFor_9_1_3_2);
        PropertyutilwriterEU.writeProperty("Mins32", idFor_3_2);
        PropertyutilwriterEU.writeProperty("Activityid32", Activityidfor32);
        PropertyutilwriterEU.writeProperty("Activityid92", Activityidfor92);
        
        		
		
    }
	
	
	
	@Test(priority=4)
	
	
	public void fetchenvironmentreportcriteriid() {
	
		Createactivity.fetchReportIds(admintoken, reportid, datacollectionid);
		
	String	Alingmentid92 = Createactivity.reportIdFor9_1;
	String Alingmentid32 =Createactivity.reportIdFor3_2;
	
	System.out.println(Alingmentid92);
	System.out.println(Alingmentid32);
	
	PropertyutilwriterEU.writeProperty("Alingmentid92", Alingmentid92);
	PropertyutilwriterEU.writeProperty("Alingmentid32", Alingmentid32);
	
	
	
	
		
}
}

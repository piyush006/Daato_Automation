package EU_Taxonomy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EU_Utils.Datarequest;
import EU_Utils.PropertyUtilsreadereu;
import utils.AuthTokenadminUtil;

public class Acceptdatarequest {
	
	
	String Email;

	
	String admintoken;
	String Extractdid;


		
		@BeforeClass
		public void getadmintoken() {
			
		admintoken= AuthTokenadminUtil.getAdminToken();
	
	}
	
	
	
	
	
	
	@Test
	
	
	
	public void approvedatarequest() {
		
		
		
	
		Extractdid = PropertyUtilsreadereu.Extractdid();
		System.out.println(Extractdid);
		
		Datarequest.acceptRequest(admintoken, Extractdid);
		
		System.out.println("🧪 TEST PASSED: Data request Accepted successfully");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}

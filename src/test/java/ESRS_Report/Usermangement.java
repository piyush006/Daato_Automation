package ESRS_Report;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ESRS_UTILS.Creatuser;
import ESRS_UTILS.ProperyUtilWriterESRS;
import utils.AuthTokenadminUtil;

public class Usermangement {
	
	
	
	
	String parentid;
	String parentemail;
	String parententityid;
	String childid;
	String childemail;
	String childentityid;

		
		
	String admintoken;


	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();


		
		}
		



	@Test(priority=1)
	public void createparent() {
		
		
		
		
		Map<String, String> userDetails = Creatuser.createparentuser(admintoken);
	    parentid = userDetails.get("user_id");
	    parentemail = userDetails.get("email");

	    System.out.println("Saved parentid: " + parentid);
	    System.out.println("Saved email: " + parentemail);
		
	    ProperyUtilWriterESRS.writeProperty("parentid", parentid);
	    ProperyUtilWriterESRS.writeProperty("parentemail", parentemail);
	    
	    System.out.println("TEST PASSED: ESRS Parent Entity manager created Successfully");
	    
	    
	    
		}	


	@Test(priority=3)


	public void createchild() throws InterruptedException {
		
		System.out.println("child");
		
		Thread.sleep(1000);
		Map<String, String> userDetails = Creatuser.createchilduser(admintoken);
		childid = userDetails.get("user_id");
		childemail = userDetails.get("email");

	    System.out.println("Saved childid: " + childid);
	    System.out.println("Saved childemail: " + childemail);
		
	    ProperyUtilWriterESRS.writeProperty("childid", childid);
	    ProperyUtilWriterESRS.writeProperty("childemail", childemail);	
	    
	    System.out.println("TEST PASSED: ESRS Child Entity manager created Successfully");
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	

}

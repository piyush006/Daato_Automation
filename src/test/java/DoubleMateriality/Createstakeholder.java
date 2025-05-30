package DoubleMateriality;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.Create_stake_group;
import DMUTILS.Createstack;
import DMUTILS.PropertyUtilWriter;
import DMUTILS.StakeholderFetcher;
import utils.AuthTokenadminUtil;

public class Createstakeholder {
	
	String admintoken;
	String groupid;
	String stakeid;
	String stakeholderName;
	
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
		
		}

   

	@Test(priority=1)
	public  void createstakeholdergroup() {
		
		System.out.println(admintoken);
		
		
	groupid=Create_stake_group.createStakeholderGroup(admintoken);
		
		System.out.println(groupid);
		
		
 
		
		
	}
	

   
	@Test(priority=2)
	
	public void createstake() throws InterruptedException {
		
	
	
	Createstack.createStakeholder(admintoken, groupid);
		
		
		
	}
	
	
	
	@Test(priority=3)
	
	
	public void getstakeid() {
		
		
		
		
		 List<StakeholderFetcher.Stakeholder> stakeholders = StakeholderFetcher.getStakeholdersByGroupId(admintoken, groupid);

	        if (!stakeholders.isEmpty()) {
	             stakeid = stakeholders.get(0).id;
	            stakeholderName = stakeholders.get(0).name;

	            System.out.println("Stakeholder ID: " + stakeid);
	            System.out.println("Stakeholder Name: " + stakeholderName);
	        } else {
	            System.out.println("No stakeholders found for group ID: " + groupid);
	        }
		
		
		
	        PropertyUtilWriter.writeProperty("stakeid", stakeid);
	        PropertyUtilWriter.writeProperty("stakeholderName", stakeholderName);
		
		
	}
	
	
	

}

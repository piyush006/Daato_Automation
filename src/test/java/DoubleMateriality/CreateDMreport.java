package DoubleMateriality;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.Checkresponsenonmaterial;
import DMUTILS.Createdmreport;
import DMUTILS.Markasnonmaterial;
import DMUTILS.PropertyUtilWriter;
import utils.AuthTokenadminUtil;


public class CreateDMreport {
	
	
	String admintoken;
	String reportid;
	boolean ExpectedisDefaultMaterial =false;
	
@BeforeClass()
public void getadmintoken() {
			
admintoken= AuthTokenadminUtil.getAdminToken();
			
}	



		
@Test(priority=1)	
public void createreport() {
	
	
	
	
	
	reportid =Createdmreport.createDoubleMaterialityReport(admintoken);	
	
	
	System.out.println(reportid);
	
	PropertyUtilWriter.writeProperty("reportid", reportid);
	
	
	 System.out.println("TEST PASSED: Double Materiality Reported Created Successfully");
}



@Test(priority=2)

public void markTopicNonmaterial() {
	
	
	
	Markasnonmaterial.markasnonmaterial(admintoken, reportid);
	
	System.out.println("TEST PASSED: Following topics marked as non material: Energy,pollution of air,Pollution of water,Pollution of soil and many more..");
}



@Test(priority=3)


public void checkresponseaftermarkingasnonmaterial() {
	
	
Boolean ActualisDefaultMaterial = Checkresponsenonmaterial.getDefaultMaterialForEnergy(admintoken, reportid);


System.out.println("Default Material Value: " + ActualisDefaultMaterial);

// Assertion: Test will pass only if value is false

	Assert.assertEquals(ActualisDefaultMaterial, ExpectedisDefaultMaterial);
	
	

}





		
		

}



	
	
	

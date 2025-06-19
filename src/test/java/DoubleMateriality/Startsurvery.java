package DoubleMateriality;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.PropertyUtilReader;
import DMUTILS.SendSurvey;
import daato_automation_page.SelfAssessmentPage;
import daato_automation_pagecomponent.PageConstants;
import utils.AuthTokenadminUtil;

public class Startsurvery {
	
	String stakeid;
	String stakeholderName;
	String reportId;
	String admintoken;
	
	@BeforeClass()
	public void getadmintoken() {
				
	admintoken= AuthTokenadminUtil.getAdminToken();
				
	}	

	
	
	
@Test	
public void startsurvey() {
	

	stakeid = PropertyUtilReader.getStakeId();
	stakeholderName = PropertyUtilReader.getStakeholderName();
	reportId = PropertyUtilReader.getReportId();
	
	System.out.println(stakeid);
	System.out.println(stakeholderName);
	System.out.println(reportId);
	
	SendSurvey.sendSurveyToStakeholder(admintoken, reportId, stakeid);
	
	System.out.println("TEST PASSED: Survery Started Successfully and Included Newly Created stakeholder");
	
	
}	



	
	
}

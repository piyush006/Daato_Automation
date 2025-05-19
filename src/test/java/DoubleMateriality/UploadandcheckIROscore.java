package DoubleMateriality;

import static org.testng.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.PropertyUtilReader;
import DMUTILS.UploadIRO;
import Doublemateriality.Checkirosocore;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;
import utils.AuthTokenadminUtil;

public class UploadandcheckIROscore extends BaseTest{
	
	
	
	
	String admintoken;
	String extractedId;
	String reportId;
	String Expectedtimframe="Short-Term";
	String Expectedimpact="Potential";
	String Expectedpotential="Negative";
	String ExpectedtypeOfImpact="Human-rights related impact";


	@BeforeClass()
	public void getadmintoken() {
				
	admintoken= AuthTokenadminUtil.getAdminToken();
	extractedId=PropertyUtilReader.extractedId();
	reportId=PropertyUtilReader.getReportId();
	}

	
	
	//@Test(enabled=false)
@Test(priority=1)
	
public void uploadiro() throws InterruptedException {
		
		
UploadIRO.postIROBulk(admintoken, reportId);
Checkirosocore complete = new Checkirosocore(driver);
LoginPage login = new LoginPage(driver);
login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());	

complete.completestepfirst2();

				
}
	
	
	
//@Test(enabled=false)
@Test(priority=2)
public void checkiroscore() throws InterruptedException {
	
	LoginPage login = new LoginPage(driver);
	login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());	
	
	threadSleep(TestConstants.WAIT_TWO);
	
	Checkirosocore score = new Checkirosocore(driver);
	
	score.checkiroscore();
	
	Map<String, String> titleAssessmentMap = new LinkedHashMap<>();
	
	
	List<WebElement> rows = driver.findElements(By.xpath(

		    "//tbody/tr[preceding-sibling::tr[.//text()[normalize-space()='Climate change adaptation']] " +

		    "and not(preceding-sibling::tr[.//text()[normalize-space()='Climate change mitigation']])]"

		));
		 
	for (WebElement row : rows) {
	    List<WebElement> tds = row.findElements(By.tagName("td"));

	    if (tds.size() >= 4) {
	        // TD[2] has both icon and title — we only want the title line
	        String fullText = tds.get(2).getText().trim();
	        String[] lines = fullText.split("\\r?\\n");

	        // Get the second line as the actual title
	        String title = (lines.length > 1) ? lines[1].trim() : ""; 

	        String assessment = tds.get(3).getText().trim();

	        System.out.println("Title: " + title + " | Assessment: " + assessment);
	        titleAssessmentMap.put(title, assessment);
	    }
	}
	assertEquals(titleAssessmentMap.get("Automatedimpact01"), "Very low");
	assertEquals(titleAssessmentMap.get("Automatedimpact02"), "Very high");
	assertEquals(titleAssessmentMap.get("Automatedoppo01"), "Very low");
	assertEquals(titleAssessmentMap.get("Automatedoppo02"), "Very high");
	assertEquals(titleAssessmentMap.get("Automatedrisk01"), "Very low");
	assertEquals(titleAssessmentMap.get("Automatedrisk02"), "Very high");
	
	
}


@Test(priority=3)

public void checkassedetails() throws InterruptedException {
	
	
	LoginPage login = new LoginPage(driver);
	login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
	
	Checkirosocore score = new Checkirosocore(driver);	
	Map<String, String> values = score.checkassessment();

	if (values == null || values.isEmpty()) {
	    System.out.println("Assessment values not found. Skipping logic.");
	    return;
	}

	// Use values
	String ActualtimeFrame = values.get("actualTimeFrame");
	String Actualimpact = values.get("actualHumanImpact");
	String Actualpotential = values.get("potential");
	String ActualtypeOfImpact = values.get("typeOfImpact");
	
	Assert.assertEquals(ActualtimeFrame, Expectedtimframe);
	Assert.assertEquals(Actualimpact, ExpectedtypeOfImpact);
	Assert.assertEquals(Actualpotential, Expectedimpact);
	Assert.assertEquals(ActualtypeOfImpact, Expectedpotential);
	
	
	
}



	
}

package DoubleMateriality;

import static org.testng.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Doublemateriality.Checkirosocore;
import Doublemateriality.checkmanualiroscore;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;

public class Checkmanualscore extends BaseTest{
	
	
	
	
@Test
	
public void checkmaualscore() throws InterruptedException {
	
	
	LoginPage login = new LoginPage(driver);
	login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());	
	
	checkmanualiroscore check = new checkmanualiroscore(driver);
	
	check.checkmanualscore();
	threadSleep(PageConstants.WAIT_ONE);
	
Map<String, String> titleAssessmentMap = new LinkedHashMap<>();
	
	
List<WebElement> rows = driver.findElements(By.xpath(

	    "//tbody/tr[preceding-sibling::tr[.//text()[normalize-space()='Working conditions - Working time']] " +

	    "and not(preceding-sibling::tr[.//text()[normalize-space()='Working conditions - Adequate wages']])]"

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
	        
	        break;
	    }
	}
	assertEquals(titleAssessmentMap.get("Automatedmanual"), "Very high");
	
	
	Checkirosocore complete = new Checkirosocore(driver);
	complete.completestepfirst3();
	
	System.out.println("TEST PASSED: Manaul IRO Score Showing Correct");
	
	
	
	
}	
	
	
	
	
	
	

}

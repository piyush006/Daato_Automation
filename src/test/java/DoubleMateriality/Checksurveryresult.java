package DoubleMateriality;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import DMUTILS.PropertyUtilReader;
import Doublemateriality.Surveryresult;
import daato_automation_page.AbstractRiskCalculationPage;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;
import static org.testng.Assert.assertEquals;

public class Checksurveryresult extends BaseTest{
	
	
	
@Test
public void checksureryresult() throws InterruptedException {
	
	
	
	
	LoginPage login = new LoginPage(driver);
	login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());	
	
	threadSleep(TestConstants.WAIT_TWO);
	
	
	
	
	Surveryresult check = new Surveryresult(driver);
	
	
	check.checkresult();
	
	threadSleep(TestConstants.WAIT_TWO);
	
	List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
	Map<String, String> matterScoreMap = new LinkedHashMap<>();

	for (WebElement row : rows) {
	    String matter = row.findElement(By.xpath("./td[2]")).getText().trim();
	    String score = row.findElement(By.xpath("./td[3]")).getText().trim();
	    matterScoreMap.put(matter, score);
	}

	// Print and verify all values
	for (Map.Entry<String, String> entry : matterScoreMap.entrySet()) {
	    System.out.println("Matter: " + entry.getKey() + " | Score: " + entry.getValue());
	}
	
	
	assertEquals(matterScoreMap.get("Climate change adaptation"), "Very low");
	assertEquals(matterScoreMap.get("Climate change mitigation"), "Very high");
	assertEquals(matterScoreMap.get("Energy"), "N/A");
	assertEquals(matterScoreMap.get("Pollution of living organisms and food resources"), "Medium");
	assertEquals(matterScoreMap.get("Substances of concern (in relation to pollution)"), "Low");
	assertEquals(matterScoreMap.get("Substances of very high concern (in relation to pollution)"), "Medium");
	assertEquals(matterScoreMap.get("Microplastics"), "Low");
	
  check.completestepfirst();


}
}

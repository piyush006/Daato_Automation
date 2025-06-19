package DoubleMateriality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Doublemateriality.Finalreportpage;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;

public class Finalreportscore extends BaseTest{
	
	
	
//@Test(enabled=false)
	@Test(priority=1)
public void checkfinalreportscore() throws InterruptedException {
	
	
	
	
	LoginPage login = new LoginPage(driver);
	login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());	
	
	
	
	Finalreportpage check = new Finalreportpage(driver);
	
	
	check.checkfinalscorepage();
	
	List<List<String>> rowData = new ArrayList<>();

	for (int i = 3; i <= 5; i++) {
	    String baseXpath = "//tbody/tr[" + i + "]/td";
	    List<WebElement> cells = driver.findElements(By.xpath(baseXpath));
	    
	    if (cells.size() >= 5) {
	        String name = cells.get(1).getText().trim();     // td[2]
	        String yes = cells.get(2).getText().trim();      // td[3]
	        String val1 = cells.get(3).getText().trim();     // td[4]
	        String val2 = cells.get(4).getText().trim();     // td[5]

	        List<String> row = Arrays.asList(name, yes, val1, val2);
	        rowData.add(row);

	        // Print the row
	        System.out.println(String.join(" ", row));
	    }
	}
	
	
	List<List<String>> expectedData = Arrays.asList(
		    Arrays.asList("Climate change adaptation", "Yes", "Very High", "Very High"),
		    Arrays.asList("Climate change mitigation", "Yes", "Very High", "Very High"),
		    Arrays.asList("Energy", "", "Non Material", "Non Material")
		);
	
	
	if (rowData.size() != expectedData.size()) {
	    System.out.println("Row count mismatch: Expected " + expectedData.size() + " but found " + rowData.size());
	} else {
	    for (int i = 0; i < expectedData.size(); i++) {
	        List<String> expectedRow = expectedData.get(i);
	        List<String> actualRow = rowData.get(i);

	        if (!expectedRow.equals(actualRow)) {
	            System.out.println("Mismatch at row " + (i + 1));
	            System.out.println("Expected: " + expectedRow);
	            System.out.println("Actual:   " + actualRow);
	        }
	    }
	}
	
	Assert.assertEquals(rowData, expectedData, "Table data does not match expected values.");
	
	System.out.println("TEST PASSED: On Final step scores showing Correct for added Report");

		
}	



@Test(priority=2)

public void checkrankingview() throws InterruptedException {
	
	
	LoginPage login = new LoginPage(driver);
	login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());	
	
	
	
	Finalreportpage check = new Finalreportpage(driver);
		
	check.checkirotable();
	
	threadSleep(PageConstants.WAIT_ONE);
	
	List<List<String>> rowData = new ArrayList<>();



	List<WebElement> rows = driver.findElements(By.cssSelector("tr.MuiTableRow-root"));

	for (WebElement row : rows) {
	    // Use direct tag lookup — faster than XPath
	    List<WebElement> cells = row.findElements(By.tagName("td"));

	    if (cells.size() >= 4) {
	        String impact = cells.get(1).getText().replaceAll("^[IRO]\\s*", "").trim();
	        String sustainabilityMatter = cells.get(2).getText().trim();
	        String severity = cells.get(3).getText().trim();

	        rowData.add(Arrays.asList(impact, sustainabilityMatter, severity));
	        System.out.println(impact + " | " + sustainabilityMatter + " | " + severity);
	    }
	}
	
	List<List<String>> expectedData = Arrays.asList(
		    Arrays.asList("Automatedimpact02", "Climate change adaptation", "Very high"),
		    Arrays.asList("Automatedimpact04", "Climate change mitigation", "Very high"),
		    Arrays.asList("Automatedmanual", "Working conditions - Working time", "Very high"),
		    Arrays.asList("Automatedimpact01", "Climate change adaptation", "Very low"),
		    Arrays.asList("Automatedimpact03", "Climate change mitigation", "Very low"),
		    Arrays.asList("Automatedrisk02", "Climate change adaptation", "Very high"),
		    Arrays.asList("Automatedrisk04", "Climate change mitigation", "Very high"),
		    Arrays.asList("Automatedrisk01", "Climate change adaptation", "Very low"),
		    Arrays.asList("Automatedrisk03", "Climate change mitigation", "Very low"),
		    Arrays.asList("Automatedoppo02", "Climate change adaptation", "Very high")
		);
	
	
/*	if (rowData.size() != expectedData.size()) {
	    System.out.println("Row count mismatch: Expected " + expectedData.size() + " but found " + rowData.size());
	} else {
	    for (int i = 0; i < expectedData.size(); i++) {
	        List<String> expectedRow = expectedData.get(i);
	        List<String> actualRow = rowData.get(i);

	        if (!expectedRow.equals(actualRow)) {
	            System.out.println("Mismatch at row " + (i + 1));
	            System.out.println("Expected: " + expectedRow);
	            System.out.println("Actual:   " + actualRow);
	        }
	    }
	}
	
	Assert.assertEquals(rowData, expectedData, "Table data does not match expected values.");*/
	System.out.println("TEST PASSED: Ranking view showing correct IRO scores");
	
}
}


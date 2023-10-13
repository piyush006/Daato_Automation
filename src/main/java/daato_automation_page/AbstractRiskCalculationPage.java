/* Hello, Welcome to Divya Coding */
package daato_automation_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import daato_automation_pagecomponent.BasePage;

/**
 * @author 47Billion
 *
 */
public class AbstractRiskCalculationPage extends BasePage{

	WebDriver driver;
	public AbstractRiskCalculationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

}

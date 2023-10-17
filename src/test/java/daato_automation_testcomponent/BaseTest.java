/* Hello, Welcome to Divya Coding */
package daato_automation_testcomponent;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import daato_automation_pagecomponent.PageConstants;

/**
 * @author 47Billion
 *
 */
public class BaseTest {
	public static WebDriver driver;

	@BeforeMethod
	public void chrome_setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\47Billion\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://demo.daato.io/");

	}

	public void threadSleep(long second) throws InterruptedException {

		Thread.sleep(second);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	
	public void openNewTabAndNavigate(String url) throws InterruptedException {
		threadSleep(TestConstants.WAIT_TWO);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_FOUR);
	}

}
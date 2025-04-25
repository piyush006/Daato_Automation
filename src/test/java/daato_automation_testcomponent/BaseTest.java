/* Hello, Welcome to Divya Coding */
package daato_automation_testcomponent;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import daato_automation_pagecomponent.PageConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author 47Billion
 *
 */
public class BaseTest {
	public static WebDriver driver;

	@BeforeMethod
	public void chrome_setup() throws InterruptedException {
		
		 
		
		 // Define custom download path
	    String downloadFilepath = System.getProperty("user.dir") + "/downloads";
	    File downloadDir = new File(downloadFilepath);
	    downloadDir.mkdirs(); // Ensure the folder exists

	    
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("download.default_directory", downloadFilepath);
	    prefs.put("profile.default_content_settings.popups", 0);
	    prefs.put("download.prompt_for_download", false);
	  
	    ChromeOptions ops = new ChromeOptions();
	    ops.setExperimentalOption("prefs", prefs);
	    if (System.getenv("CI") != null) {
	        System.out.println("CI environment detected: Running Chrome in headless mode");
	        ops.addArguments("--headless=new"); // modern headless mode
	    }
	    ops.addArguments("--remote-allow-origins=*");
	    ops.addArguments("--disable-gpu");
	    ops.addArguments("--disable-dev-shm-usage");
	    ops.addArguments("--no-sandbox");
	    ops.addArguments("--headless=new");

	    // Setup WebDriver
	   WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(ops);
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    driver.manage().window().maximize();

	    // Navigate to your test URL
	    driver.get(TestConstants.TEST_DAATO_URL);
	    
	    
		
		/*WebDriverManager.chromedriver().setup();
		//System.setProperty(TestConstants.TEST_CHROME_DRIVER, TestConstants.TEST_CHROME_DRIVER_PATH);
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get(TestConstants.TEST_DAATO_URL);*/

	}

	public void threadSleep(long second) throws InterruptedException {

		Thread.sleep(second);
	}
	
	public void printMessage(String message) {

		System.out.println(message);
	}
	
	public String getTokenFromBrowser() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return window.localStorage.getItem('kc_token');");
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
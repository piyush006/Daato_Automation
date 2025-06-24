/* Hello, Welcome to Divya Coding */
package daato_automation_testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

import daato_automation_pagecomponent.PageConstants;
/**
 * @author 47Billion
 *
 */
public class BaseTest {
	public static WebDriver driver;
	
	@BeforeMethod
	public void chrome_setup() throws InterruptedException, IOException {
		
		 
		
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
	        ops.addArguments("--no-sandbox"); // Required for GitHub Actions
	        ops.addArguments("--disable-dev-shm-usage"); // Solve limited memory problems
	        ops.addArguments("--disable-gpu"); // Disable GPU, important for headless
	        ops.addArguments("--window-size=1920,1080"); // Set a proper screen size
	        ops.addArguments("--remote-allow-origins=*"); // Fix CORS issues if any
	    }
	    
	 //  ops.addArguments("--headless=new");
	    ops.addArguments("--remote-allow-origins=*");
	    ops.addArguments("--window-size=1920,1080");
	    ops.addArguments("--disable-gpu");
	    ops.addArguments("--disable-dev-shm-usage");
	    ops.addArguments("--no-sandbox");
	  

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
	@BeforeClass
    public void setupRuntimeFile() throws IOException {
        String projectDir = System.getProperty("user.dir");

        Path sourcePath = Paths.get(projectDir, "test-data", "Add_Supplier_Afghanistan.xlsx");
        Path targetDir = Paths.get(projectDir, "target", "runtime");
        Path targetPath = targetDir.resolve("Add_Supplier_Afghanistan.xlsx");

        // Step 1: Make sure target directory exists
        if (Files.notExists(targetDir)) {
            Files.createDirectories(targetDir);
        }

        // Step 2: If target file doesn't exist, copy fresh
        if (Files.notExists(targetPath)) {
            System.out.println("Target file not found. Copying fresh...");
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } else {
            System.out.println("Target file already exists. Proceeding to use existing file for read/write.");
        }

        System.out.println("Target file ready at: " + targetPath.toAbsolutePath());
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
	public void tearDown() throws IOException {

		
		driver.quit();
	}

	public void openNewTabAndNavigate(String url) throws InterruptedException {
		threadSleep(TestConstants.WAIT_TWO);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_FOUR);
	}
	
	
	
	
	
	

}
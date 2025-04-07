package Daato_Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class headless {
	
	 private WebDriver driver;

	
	
	
	@BeforeClass
    public void setUp() {
        // Set up ChromeDriver with headless mode
        System.setProperty("webdriver.chrome.driver","C:\\Users\\47Billion\\Desktop\\chromedriver_win32\\chromedriver.exe");
       
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
       options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void headlessTest() {
        // Your test logic here
        driver.get("https://google.com");
        System.out.println("Page title: " + driver.getTitle());
        // Add test assertions and interactions as needed
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver after the test
        driver.quit();
    }
}


	
	
	
	
	



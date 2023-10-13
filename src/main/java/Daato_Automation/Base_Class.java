package Daato_Automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Class {
	
static WebDriver driver;

@BeforeMethod
public void chrome_setup() {
		
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\47Billion\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	 ChromeOptions ops = new ChromeOptions();	
	 ops.addArguments("--remote-allow-origins=*");
	 driver = new ChromeDriver(ops);

	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	 driver.manage().window().maximize();
     driver.get("https://demo.daato.io/");
		
}

@AfterMethod
public void tearDown() {
	
driver.quit();
}	
	
}

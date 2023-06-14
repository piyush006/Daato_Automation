package Daato_Automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Class {
	
	

	
WebDriver driver;


	
@BeforeMethod


public void chrome_setup() {
	
	
	
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\47Billion\\Desktop\\Driver\\chromedriver_win32\\chromedriver.exe");
	 ChromeOptions ops = new ChromeOptions();	
	 ops.addArguments("--remote-allow-origins=*");
	 driver = new ChromeDriver(ops);

	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 driver.manage().window().maximize();
	 driver.get("https://daato.daato.dev/");
	
	
}

@AfterMethod
public void tearDown() {
	
driver.quit();
}	
		
}

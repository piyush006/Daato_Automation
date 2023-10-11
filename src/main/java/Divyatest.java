import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Divyatest {

	
	static WebDriver driver;

@Test

public void login() {
	
	
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\47Billion\\Desktop\\chromedriver_win32\\chromedriver.exe");
	 ChromeOptions ops = new ChromeOptions();	
	 ops.addArguments("--remote-allow-origins=*");
	 driver = new ChromeDriver(ops);

	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	 driver.manage().window().maximize();

	driver.get("http://erpstage.spineit.net/GmLogin.jsp");
	
	
	driver.findElement(By.xpath("//*[@id='okta-signin-username']")).sendKeys("APINVAUTO");
	driver.findElement(By.xpath("//*[@id='okta-signin-password']")).sendKeys("b2xudbUv");
	driver.findElement(By.xpath("//*[@id='okta-signin-submit']")).click();
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package Daato_Automation;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;

public class Self_Assessment extends Base_Class{
	
	String Email;
	String User_Registered;	
	
	
	String URL;
	String URL1;
	
	

	
	
	@Test(priority=1)
	
	public void General_information() throws InterruptedException {
		
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
		 
		 int count = reader.getRowCount("Add_Supplier");
		 
		 for(int i=0;i<count-1;i++) {
			
			 User_Registered=reader.getCellData("Add_Supplier", "User_Registered", i+2);
			 
			 if(User_Registered.equals("No")) {
				 
			 Email=reader.getCellData("Add_Supplier", "Contact_Email", i+2); 
		 
		
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://yopmail.com/en/");
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys(Email);
		driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
		Thread.sleep(4000);
		driver.switchTo().frame(driver.findElement(By.id("ifmail")));
		driver.findElement(By.xpath("//a[contains(text(),'View the request')]")).click();
		
		
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(wid.size());
		//switch to active tab
		driver.switchTo().window(wid.get(2));
		
		
		
	  //  driver.findElement(By.id("username")).sendKeys(Email);
		driver.findElement(By.id("password")).sendKeys("681993@Virat");
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
	//	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
		Thread.sleep(3000);
		reader.setCellData("Add_Supplier","User_Registered",i+2,"Yes");
        Thread.sleep(2000);
		
		

		break;
		
		
			 }
			 
		 }
		 
		 driver.findElement(By.xpath("//button[contains(text(),'Requests')]")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[contains(text(),'piyush.soni@47billion.com')]")).click();	
			Thread.sleep(2000);
			
			 URL = driver.getCurrentUrl();
			 reader.setCellData("Recent_Added","Currenturl",2,URL);
			 URL1=reader.getCellData("Recent_Added", "Currenturl",2);
		
		// driver.findElement(By.xpath("//p[contains(text(),'q')]")).click();
		//driver.findElement(By.id("menuItemId-profile")).click();
//		driver.findElement(By.id("inputId-languages")).click();
//		driver.findElement(By.xpath("//li[normalize-space()='English']")).click();
		//driver.findElement(By.xpath("//button[@id='buttonID-applySettings']")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(240));
//		String Success =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='sc-breuTD liTfKa MuiTypography-root MuiTypography-body1']"))).getText();
		
		//System.out.println(Success);
		
	//	driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M12 4.7L11')]")).click();
		
		
		
	driver.findElement(By.xpath("//input[@id='searchSelectID-main']")).click();
	
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-1']")).click();
	
	driver.findElement(By.xpath("//input[@id='numberInputID-main']")).sendKeys("100");
	driver.findElement(By.xpath("//input[@id='autocompleteAddressID-main']")).sendKeys("Indore");
	driver.findElement(By.xpath("//li[@id='autocompleteAddressID-main-option-3']")).click();
	
	
	Thread.sleep(2000);
	
	   driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[2]")).click();
		
		driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-2']")).click();
		
		Thread.sleep(2000);
		 driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[3]")).click();
		 driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-1']")).click();
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[4]")).click();
		 driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
		 
		 Thread.sleep(2000);
	
		
		
}


@Test(priority=2)
	

public void add_governance_and() throws InterruptedException {
	
	
	//driver.findElement(By.xpath("//input[@id='username']")).sendKeys("piyushjnm@yopmail.com");
//	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("681993@Virat");
	//driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	
	
		driver.switchTo().newWindow(WindowType.TAB);
		
		
		
		
		driver.get(URL1);
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys(Email);
		driver.findElement(By.id("password")).sendKeys("681993@Virat");
		driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
		
	
	Thread.sleep(2000);
	
	WebElement element2 = driver.findElement(By.xpath("//span[contains(text(),'Governance')]"));
	scrollIntoView(element2);
	
	Thread.sleep(1000);
	
	
	 driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[5]")).click();
	 driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	 Thread.sleep(4000);
	 
	 WebElement element25 = driver.findElement(By.xpath("//p[contains(text(),'Can you confirm that your company has a management person responsible for environment sustainability?')]"));
		scrollIntoView(element25); 
		Thread.sleep(1000);
	 driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[6]")).click();
	 driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	 
	 Thread.sleep(4000);
	 
	 WebElement element26 = driver.findElement(By.xpath("//p[contains(text(),'Can you confirm that your company has a management person responsible for monitoring sustainability risks (e.g. a Human Rights Officer)?')]"));
		scrollIntoView(element26);
	 
		 Thread.sleep(1000);
	 
	 driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[7]")).click();
	 driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	 Thread.sleep(4000);
	 
	 
	 WebElement element27 = driver.findElement(By.xpath("//p[contains(text(),'Can you confirm that your company has a Code of Co')]"));
		scrollIntoView(element27);
		
		Thread.sleep(1000);
		
	 
	 driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[8]")).click();
	 driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	 
	 Thread.sleep(4000);
	 
	 WebElement element28 = driver.findElement(By.xpath("//p[contains(text(),'Can you confirm that your company has a Code of Co')]"));
		scrollIntoView(element28);
		
		Thread.sleep(1000);
	 
	 driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[9]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	 
	 Thread.sleep(3000);
	 

	 WebElement element29 = driver.findElement(By.xpath("//p[contains(text(),'What kind of complaints can be submitted? Tick all that apply')]"));
		scrollIntoView(element29);
	 
	 driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[10]")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-1']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-2']")).click();
	 Thread.sleep(1000);
  }



	
@Test(priority=3)
public void Add_Buisness_Ethics() throws InterruptedException {
	


driver.switchTo().newWindow(WindowType.TAB);



driver.get(URL1);
	Thread.sleep(1000);
	driver.findElement(By.id("username")).sendKeys(Email);
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	

Thread.sleep(2000);

WebElement element3 = driver.findElement(By.xpath("//p[contains(text(),'Business Ethics')]"));
scrollIntoView(element3);


Thread.sleep(1000);
driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[11]")).click();
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();


Thread.sleep(6000);


WebElement element33 = driver.findElement(By.xpath("//p[contains(text(),'Does your company have a formal policy covering business ethics?')]"));
scrollIntoView(element33);
Thread.sleep(1000);

driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[12]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-1']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-2']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-3']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-4']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-5']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-6']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-7']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-8']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-9']")).click();
Thread.sleep(1000);
}
	

@Test(priority=4)
public void Add_responsible_supply_chain_management() throws InterruptedException{
	
	
	
	driver.switchTo().newWindow(WindowType.TAB);
	
	
	
	
	driver.get(URL1);
	Thread.sleep(1000);
	driver.findElement(By.id("username")).sendKeys(Email);
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	

Thread.sleep(2000);

WebElement element4 = driver.findElement(By.xpath("//p[contains(text(),'Responsible supply chain management')]"));
scrollIntoView(element4);

Thread.sleep(1000);
driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[13]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
Thread.sleep(4000);

driver.findElement(By.xpath("//span[contains(text(),'Responsible supply chain management')]")).click();
Thread.sleep(2000);

WebElement element44 = driver.findElement(By.xpath("//p[contains(text(),'Please tick the areas that are covered by the sustainability requirements towards suppliers')]"));
scrollIntoView(element44);


driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[14]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
Thread.sleep(3000);

driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-1']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-2']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-3']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-4']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-5']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-6']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-7']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-8']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-9']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-10']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-11']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-12']")).click();

driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[14]")).click();
Thread.sleep(2000);
	
driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[15]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
Thread.sleep(1000);

}
	@Test(priority=5)
	
public void add_policies_and_certifications() throws InterruptedException {
	
	
		
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		
		
		
		driver.get(URL1);
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys(Email);
		driver.findElement(By.id("password")).sendKeys("681993@Virat");
		driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
		
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[16]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[17]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	
	
	WebElement element6 = driver.findElement(By.xpath("//p[contains(text(),'Does your site have an environmental management sy')]"));
	scrollIntoView(element6);
    Thread.sleep(1000);
	
	
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[18]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	Thread.sleep(1000);

    
    WebElement element8 = driver.findElement(By.xpath("//p[contains(text(),'Does your company have a formal policy covering wo')]"));
	scrollIntoView(element8);
    Thread.sleep(1000);
	
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[19]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	Thread.sleep(5000);
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[20]")));
	element.click();
	Thread.sleep(2000);
	
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-1']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-2']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-3']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-4']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-5']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-6']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-7']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-8']")).click();
element.click();
Thread.sleep(2000);
	}
	
	

@Test(priority=6)

public void add_policy_part_second() throws InterruptedException {
	
	
	
	driver.switchTo().newWindow(WindowType.TAB);
	
	
	
	driver.get(URL1);
	Thread.sleep(1000);
	driver.findElement(By.id("username")).sendKeys(Email);
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	

Thread.sleep(2000);
	
WebElement element9 = driver.findElement(By.xpath("//p[contains(text(),'Occupational Health and safety policy')]"));
scrollIntoView(element9);
Thread.sleep(1000);

driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[21]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
Thread.sleep(3000);	
WebElement element91 = driver.findElement(By.xpath("//p[contains(text(),'Please tick all that is covered in your occupational health and safety policy')]"));
scrollIntoView(element91);
Thread.sleep(2000);

	
WebDriverWait wait16 = new WebDriverWait(driver, Duration.ofSeconds(6));
WebElement element16 = wait16.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[22]")));
element16.click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-1']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-2']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-3']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-4']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-5']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-6']")).click();
Thread.sleep(1000);
element16.click();
Thread.sleep(2000);

WebElement element10 = driver.findElement(By.xpath("//p[contains(text(),'Does your company have a formal environmental poli')]"));
scrollIntoView(element10);
Thread.sleep(2000);

driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[23]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
Thread.sleep(4000);

WebElement element15 = driver.findElement(By.xpath("//p[contains(text(),'Which of the following areas are covered by this policy? Please tick all that apply.')]"));
scrollIntoView(element15);
Thread.sleep(1000);


WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(6));
WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[24]")));
element2.click();
Thread.sleep(1000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-1']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-2']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-3']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-4']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-5']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-6']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-7']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-8']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-9']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-10']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-11']")).click();
Thread.sleep(2000);	
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-12']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-13']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-14']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-15']")).click();
Thread.sleep(2000);
element2.click();
}

@Test(priority=7)
public void add_chld_frc_hs_fa_ee_fw_lr() throws InterruptedException {
	
	
	
	
	driver.switchTo().newWindow(WindowType.TAB);
	
	
	
	
	driver.get(URL1);
	Thread.sleep(1000);
	driver.findElement(By.id("username")).sendKeys(Email);
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	

Thread.sleep(2000);

driver.findElement(By.xpath("//span[contains(text(),'Responsible supply chain management')]")).click();

driver.findElement(By.xpath("//span[contains(text(),'Child labor')]")).click();		
	
driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[25]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();

Thread.sleep(1000);

driver.findElement(By.xpath("//span[contains(text(),'Forced labor')]")).click();			
	
Thread.sleep(1000);	
driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[26]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();	
	

	driver.findElement(By.xpath("//span[contains(text(),'Health and Safety at work')]")).click();				
	Thread.sleep(1000);
	
	
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[27]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();	
			
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[contains(text(),'Freedom of association')]")).click();	
	
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[28]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();	
	
	Thread.sleep(1000);	
	
driver.findElement(By.xpath("//span[contains(text(),'Equality in employment')]")).click();	
	
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[29]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[contains(text(),'Fair wages')]")).click();	
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[30]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();	
	
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[contains(text(),'Land rights')]")).click();
		
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[31]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();	
	Thread.sleep(1000);
	
	WebElement element21 = driver.findElement(By.xpath("//p[contains(text(),'Do you organise training for all your employees on your policy covering land rights?')]"));
	scrollIntoView(element21);
	Thread.sleep(1000);
	
	
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[32]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();	
	Thread.sleep(2000);
	
	
	
}


@Test(priority=8)
public void add_cs_sw() throws InterruptedException {
	
	
	
	driver.switchTo().newWindow(WindowType.TAB);
	
	
	
	
	driver.get(URL1);
	Thread.sleep(1000);
	driver.findElement(By.id("username")).sendKeys(Email);
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	

Thread.sleep(2000);
	
	driver.findElement(By.xpath("//span[contains(text(),'Conflicts and security')]")).click();
	
	
	WebElement element11 = driver.findElement(By.xpath("//p[contains(text(),'Conflicts and security')]"));
	scrollIntoView(element11);
	
	Thread.sleep(2000);
	
	WebElement element22 = driver.findElement(By.xpath("//p[contains(text(),'Can you confirm that your company does not hire')]"));
	scrollIntoView(element22);
	Thread.sleep(1000);
	
	
    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(4));
	WebElement element3 = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[33]")));
	element3.click();
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();	
		
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[34]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	
	Thread.sleep(1000);
	WebElement element12 = driver.findElement(By.xpath("//p[contains(text(),'Systematic or widespread human rights abuses')]"));
	scrollIntoView(element12);
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[35]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	
	Thread.sleep(1000);
	
	WebElement element13 = driver.findElement(By.xpath("//p[contains(text(),'Do you get legal advice on compliance, contract ne')]"));
	scrollIntoView(element13);
	Thread.sleep(1000);
	
	WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(4));
	WebElement element4 = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[36]")));
	element4.click();
	
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	Thread.sleep(1000);
	
}
	
	

@Test(priority=9)
public void add_environmental_performance() throws InterruptedException {
	
	
	
	driver.switchTo().newWindow(WindowType.TAB);
	
	
	
	
	driver.get(URL1);
	
	Thread.sleep(1000);
	driver.findElement(By.id("username")).sendKeys(Email);
	
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();
	

Thread.sleep(2000);

WebElement element1 = driver.findElement(By.xpath("//p[contains(text(),'Environmental performance')]"));

scrollIntoView(element1);

Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[37]")).click();
	
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	Thread.sleep(2000);

driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[38]")).click();
	
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	
	
	Thread.sleep(2000);
	
driver.findElement(By.xpath("(//input[@id='searchSelectID-main'])[39]")).click();
	
	driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();
	
Thread.sleep(1000);
	
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
WebElement elementw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[40]")));
elementw.click();
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-0']")).click();


WebDriverWait waitf = new WebDriverWait(driver, Duration.ofSeconds(4));
WebElement elementy = waitf.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[41]")));
elementy.click();
driver.findElement(By.xpath("//li[@id='searchSelectID-main-option-1']")).click();
	
		Thread.sleep(2000);
	
}

@Test(priority=10)

public void submit_SAQ() throws InterruptedException {
	
driver.switchTo().newWindow(WindowType.TAB);
driver.get(URL1);
driver.findElement(By.id("username")).sendKeys(Email);
	
	driver.findElement(By.id("password")).sendKeys("681993@Virat");
	driver.findElement(By.xpath("(//button[@name='action'][normalize-space()='Continue'])[2]")).click();	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("multilineTextID-Comment")).sendKeys("piyush");
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[2]")).click();
	Thread.sleep(8000);
	
}


public static void scrollIntoView(WebElement element) {
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", element);
    System.out.println("Scroll into view with smooth behavior");
}




}


	
	
	
	
	
	
	



















package Daato_Automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class kest extends Base_Class{
	
boolean flag;
@Test


public void test() {
	
	
	
for (int i=0; i<10; i++) {


try {
	if(driver.findElement(By.xpath("//img[@id='prompt-logo-centeri']")).isDisplayed()) {
		
		
		flag=driver.findElement(By.xpath("//img[@id='prompt-logo-centeri']")).isDisplayed();
	
	}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
for(int j=0;j<10;j++) {
	
	
if(flag==true) {
	
	
System.out.println("piyush");
System.out.println("value of i ="+i+"value of j ="+j);
break;
	
	
}
else {
	
	System.out.println("value of i ="+i+"value of j ="+j);
	
	System.out.println("piyush");
	break;
}



	
	
}


if(flag==false) {
	
	System.out.println("i am out");
	
	break;	

}


	
}

}
}



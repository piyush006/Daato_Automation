package DoubleMateriality;

import org.testng.annotations.Test;

import DMUTILS.PropertyUtilReader;
import Doublemateriality.Answercollaborationrequest;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;

public class Answercollabrequest extends BaseTest{
	
String Email;	
	

@Test
public void answercollabrequest() throws InterruptedException {
	
	
Email=PropertyUtilReader.stakeholdermail();
	
LoginPage login = new LoginPage(driver);
login.LoginApplication(Email, PropertyFileUtils.getPassword());	

threadSleep(TestConstants.WAIT_TWO);	
	
	
Answercollaborationrequest Answer = new Answercollaborationrequest(driver);
	
	
	
Answer.selectandanswerrequest();
	
}	
	

}

/* Hello, Welcome to Divya Coding */
package daato_automation_page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import daato_automation_pagecomponent.BasePage;
import daato_automation_pagecomponent.PageConstants;

/**
 * @author 47Billion
 *
 */
public class SelfAssessmentPage extends BasePage {

	WebDriver driver;

	public SelfAssessmentPage(WebDriver driver) {
	super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginButton;

	@FindBy(xpath = "//i[@class='material-icons-outlined f36']")
	WebElement arrowButton;

	@FindBy(id = "ifmail")
	WebElement mailFrame;

	@FindBy(id = "ifinbox")
	WebElement mailInboxFrame;
	
	@FindBy(xpath = "//p/b[contains(text(),'Code:')]")
	WebElement otpElement;
	
	@FindBy(xpath = "//input[@name='submit']")
	WebElement submitOTPButton;
	
	@FindBy(xpath = "//a[contains(text(),'View the request')]")
	WebElement viewToRequestButton;

	@FindBy(xpath = "//input[@id='searchSelectID-main']")
	WebElement searchCompanySize;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-1']")
	WebElement selectCompanySize;

	@FindBy(xpath = "//input[@id='numberInputID-main']")
	WebElement revenueCompany;

	@FindBy(xpath = "//input[@id='autocompleteAddressID-main']")
	WebElement locationCompany;

	@FindBy(xpath = "//li[@id='autocompleteAddressID-main-option-3']")
	WebElement autocompleteAddress;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[2]")
	WebElement purchasingRealtionshipList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-2']")
	WebElement purchasingRealtionshipSelect;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[3]")
	WebElement qualityRealtionshipList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-1']")
	WebElement qualityRealtionshipSelect;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[4]")
	WebElement companyImpactList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement companyImpactSelect;

	@FindBy(xpath = "//p[text()='Governance']")
	WebElement governance;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[5]")
	WebElement socialSustainabilityList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement socialSustainabilityOption;

	@FindBy(xpath = "//div[contains(text(),'Can you confirm that your company has a management person responsible for environment sustainability?')]")
	WebElement enviormentSustainabilityText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[6]")
	WebElement enviormentSustainabilityList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement enviormentSustainabilityOption;

	@FindBy(xpath = "//div[contains(text(), 'Can you confirm that your company has a management person responsible for monitoring sustainability risks')]")
	WebElement monitoringSustainabilityText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[7]")
	WebElement monitoringSustainabilityList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement monitoringSustainabilityOption;

	@FindBy(xpath = "//div[contains(text(), 'Can you confirm that your company has a Code of Conduct')]")
	WebElement codeOfCoText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[8]")
	WebElement codeOfCoList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement codeOfCoOption;

	@FindBy(xpath = "//div[contains(text(), 'Can you confirm that your company has a grievance mechanism or documented complaints procedures')]")
	WebElement codeOfCoText1;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[9]")
	WebElement codeOfCoList1;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement codeOfCoOption1;

	@FindBy(xpath = "//div[contains(text(), 'What kind of complaints can be submitted?')]")
	WebElement complaintsText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[10]")
	WebElement complaintsList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement complaintsOption1;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-1']")
	WebElement complaintsOption2;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-2']")
	WebElement complaintsOption3;

	@FindBy(xpath = "//p[contains(text(),'Business Ethics')]")
	WebElement buisnessEthicsText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[11]")
	WebElement buisnessEthicsList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement buisnessEthicsOption;

	@FindBy(xpath = "//div[text()='Does your company have a formal policy covering business ethics?']")
	WebElement buisnessEthicsPolicyText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[12]")
	WebElement buisnessEthicsPolicyList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement buisnessEthicsPolicyOption0;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-1']")
	WebElement buisnessEthicsPolicyOption1;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-2']")
	WebElement buisnessEthicsPolicyOption2;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-3']")
	WebElement buisnessEthicsPolicyOption3;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-4']")
	WebElement buisnessEthicsPolicyOption4;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-5']")
	WebElement buisnessEthicsPolicyOption5;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-6']")
	WebElement buisnessEthicsPolicyOption6;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-7']")
	WebElement buisnessEthicsPolicyOption7;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-8']")
	WebElement buisnessEthicsPolicyOption8;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-9']")
	WebElement buisnessEthicsPolicyOption9;

	@FindBy(xpath = "//p[contains(text(),'Responsible supply chain management')]")
	WebElement supplyChainManageText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[13]")
	WebElement supplyChainManageList;
	
	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement supplyChainManageOption;

	@FindBy(xpath = "//span[contains(text(),'Responsible supply chain management')]")
	WebElement supplyChainManageText1;

	@FindBy(xpath = "//*[text()='Please select the areas that are covered by the sustainability requirements towards suppliers']")
	WebElement tickTheAreaText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[14]")
	WebElement tickTheAreaList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement tickTheAreaOption0;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-1']")
	WebElement tickTheAreaOption1;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-2']")
	WebElement tickTheAreaOption2;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-3']")
	WebElement tickTheAreaOption3;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-4']")
	WebElement tickTheAreaOption4;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-5']")
	WebElement tickTheAreaOption5;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-6']")
	WebElement tickTheAreaOption6;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-7']")
	WebElement tickTheAreaOption7;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-8']")
	WebElement tickTheAreaOption8;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-9']")
	WebElement tickTheAreaOption9;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-10']")
	WebElement tickTheAreaOption10;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-11']")
	WebElement tickTheAreaOption11;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-12']")
	WebElement tickTheAreaOption12;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[14]")
	WebElement envManagementSys;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[15]")
	WebElement humanRightsList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement humanRightsoptions;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[16]")
	WebElement formalPolicyList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement formalPolicyOption;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[17]")
	WebElement envPerformanceList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement envPerformanceOption;

	@FindBy(xpath = "//div[contains(text(),'Does your site have an environmental management system')]")
	WebElement envManagementSysText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[18]")
	WebElement envManagementSysList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement envManagementSysOption;

	@FindBy(xpath = "//div[text()='Does your company have a formal policy covering working condition and human rights?']")
	WebElement policyCoveringText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[19]")
	WebElement policyCoveringList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement policyCoveringOption;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[20]")
	WebElement employeeDoc;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement employeeDocOption0;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-1']")
	WebElement employeeDocOption1;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-2']")
	WebElement employeeDocOption2;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-3']")
	WebElement employeeDocOption3;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-4']")
	WebElement employeeDocOption4;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-5']")
	WebElement employeeDocOption5;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-6']")
	WebElement employeeDocOption6;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-7']")
	WebElement employeeDocOption7;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-8']")
	WebElement employeeDocOption8;

	@FindBy(xpath = "//p[contains(text(),'Occupational Health and safety policy')]")
	WebElement HealthSafetyPolicyText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[21]")
	WebElement HealthSafetyPolicyList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement HealthSafetyPolicyOption;

	@FindBy(xpath = "//div[text()='Please select all that is covered in your occupational health and safety policy']")
	WebElement HealthSafetyPolicyTickText;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement HealthSafetyPolicyTick0;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-1']")
	WebElement HealthSafetyPolicyTick1;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-2']")
	WebElement HealthSafetyPolicyTick2;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-3']")
	WebElement HealthSafetyPolicyTick3;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-4']")
	WebElement HealthSafetyPolicyTick4;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-5']")
	WebElement HealthSafetyPolicyTick5;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-6']")
	WebElement HealthSafetyPolicyTick6;

	@FindBy(xpath = "//div[contains(text(),'Does your company have a formal environmental policy')]")
	WebElement formalEnvPolicyText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[23]")
	WebElement formalEnvPolicyList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement formalEnvPolicyOption;

	@FindBy(xpath = "//div[text()='Which of the following areas are covered by this policy? Please select all that apply.']")
	WebElement formalEnvPolicyTickText;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement formalEnvPolicyTick0;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-1']")
	WebElement formalEnvPolicyTick1;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-2']")
	WebElement formalEnvPolicyTick2;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-3']")
	WebElement formalEnvPolicyTick3;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-4']")
	WebElement formalEnvPolicyTick4;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-5']")
	WebElement formalEnvPolicyTick5;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-6']")
	WebElement formalEnvPolicyTick6;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-7']")
	WebElement formalEnvPolicyTick7;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-8']")
	WebElement formalEnvPolicyTick8;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-9']")
	WebElement formalEnvPolicyTick9;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-10']")
	WebElement formalEnvPolicyTick10;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-11']")
	WebElement formalEnvPolicyTick11;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-12']")
	WebElement formalEnvPolicyTick12;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-13']")
	WebElement formalEnvPolicyTick13;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-14']")
	WebElement formalEnvPolicyTick14;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-15']")
	WebElement formalEnvPolicyTick15;

	@FindBy(xpath = "//span[text()='Responsible supply chain management']")
	WebElement respSupplyChainManagText;

	@FindBy(xpath = "//span[contains(text(),'Child labor')]")
	WebElement childLaborText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[25]")
	WebElement childLaborList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement childLaborOption;

	@FindBy(xpath = "//span[contains(text(),'Forced labor')]")
	WebElement forcedLaborText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[26]")
	WebElement forcedLaborList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement forcedLaborOption;

	@FindBy(xpath = "//span[contains(text(),'Health and Safety at work')]")
	WebElement healthSafetyWorkText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[27]")
	WebElement healthSafetyWorkList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement healthSafetyWorkOption;

	@FindBy(xpath = "//span[contains(text(),'Freedom of association')]")
	WebElement freedAssocText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[28]")
	WebElement freedAssocList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement freedAssocOption;

	@FindBy(xpath = "//span[contains(text(),'Equality in employment')]")
	WebElement equalityempText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[29]")
	WebElement equalityempList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement equalityempOption;

	@FindBy(xpath = "//span[contains(text(),'Fair wages')]")
	WebElement fairWagesText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[30]")
	WebElement fairWagesList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement fairWagesOption;

	@FindBy(xpath = "//div[contains(text(),'Do you organise training for all your employees on your policy covering land rights?')]")
	WebElement emptrainingText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[32]")
	WebElement emptrainingList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement emptrainingOption;

	@FindBy(xpath = "//span[contains(text(),'Conflicts and security')]")
	WebElement conflictSecurity;

	@FindBy(xpath = "//p[contains(text(),'Conflicts and security')]")
	WebElement conflictSecurityText;
	
	@FindBy(xpath = "//span[contains(text(),'Policies and certifications')]")
	WebElement Policiesandcertifications;

	@FindBy(xpath = "//p[contains(text(),'Policies and certifications')]")
	WebElement Policiesandcertificationstext;

	@FindBy(xpath = "//div[contains(text(),'Can you confirm that your company does not hire')]")
	WebElement companyHireText;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement companyHireOption;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[34]")
	WebElement companyHireList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement companyHireOption1;

	@FindBy(xpath = "//p[contains(text(),'Systematic or widespread human rights abuses')]")
	WebElement systWideText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[35]")
	WebElement systWideList;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement systWideOption;

	@FindBy(xpath = "//div[contains(text(),'Do you get legal advice on compliance, contract ne')]")
	WebElement legalAdviceCompText;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement legalAdviceCompOption;

	@FindBy(xpath = "//p[contains(text(),'Environmental performance')]")
	WebElement envPerformanceText;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[37]")
	WebElement envPerformanceList1;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement envPerformanceOption1;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[38]")
	WebElement envPerformanceList2;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement envPerformanceOption2;

	@FindBy(xpath = "(//input[@id='searchSelectID-main'])[39]")
	WebElement envPerformanceList3;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement envPerformanceOption3;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-0']")
	WebElement envPerformanceOption4;

	@FindBy(xpath = "//li[@id='searchSelectID-main-option-1']")
	WebElement envPerformanceOption5;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement submitButton;

	@FindBy(id = "multilineTextID-Comment")
	WebElement comment;

	@FindBy(xpath = "(//button[normalize-space()='Submit'])[2]")
	WebElement submitButton1;

	public void submitSAQ() throws InterruptedException {
		submitButton.click();
		threadSleep(PageConstants.WAIT_FIVE);
		comment.sendKeys(PageConstants.PAGE_COMMENT_NAME);
		threadSleep(PageConstants.WAIT_ONE);
		submitButton1.click();
		threadSleep(PageConstants.WAIT_EIGHT);
		
	}

	public void addEnvironmentalPerformance() throws InterruptedException {
		scrollIntoView(envPerformanceText);
		threadSleep(PageConstants.WAIT_TWO);
		envPerformanceList1.click();
		envPerformanceOption1.click();
		threadSleep(PageConstants.WAIT_TWO);
		envPerformanceList2.click();
		envPerformanceOption2.click();
		threadSleep(PageConstants.WAIT_TWO);
		envPerformanceList3.click();
		envPerformanceOption3.click();
		threadSleep(PageConstants.WAIT_ONE);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		WebElement elementw = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[40]")));
		elementw.click();
		envPerformanceOption4.click();
		WebDriverWait waitf = new WebDriverWait(driver, Duration.ofSeconds(4));
		WebElement elementy = waitf
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[41]")));
		elementy.click();
		envPerformanceOption5.click();
		threadSleep(PageConstants.WAIT_TWO);

	}

	public void addCsSw() throws InterruptedException {
		conflictSecurity.click();
		scrollIntoView(conflictSecurityText);
		threadSleep(PageConstants.WAIT_TWO);
		scrollIntoView(companyHireText);
		threadSleep(PageConstants.WAIT_ONE);
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element3 = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[34]")));
		element3.click();
		threadSleep(PageConstants.WAIT_ONE);
		companyHireOption.click();
		threadSleep(PageConstants.WAIT_ONE);
		companyHireList.click();
		threadSleep(PageConstants.WAIT_ONE);
		companyHireOption1.click();
		threadSleep(PageConstants.WAIT_ONE);
		scrollIntoView(systWideText);
		threadSleep(PageConstants.WAIT_ONE);
		systWideList.click();
		threadSleep(PageConstants.WAIT_ONE);
		systWideOption.click();
		threadSleep(PageConstants.WAIT_ONE);
		scrollIntoView(legalAdviceCompText);
		threadSleep(PageConstants.WAIT_ONE);
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element4 = wait4
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[36]")));
		element4.click();
		legalAdviceCompOption.click();
		threadSleep(PageConstants.WAIT_ONE);

	}

	public void addChldFrcHsFaEeFwLr() throws InterruptedException {
		respSupplyChainManagText.click();
		childLaborText.click();
		childLaborList.click();
		threadSleep(PageConstants.WAIT_ONE);
		childLaborOption.click();
		threadSleep(PageConstants.WAIT_ONE);
		forcedLaborText.click();
		threadSleep(PageConstants.WAIT_ONE);
		forcedLaborList.click();
		threadSleep(PageConstants.WAIT_ONE);
		forcedLaborOption.click();
		threadSleep(PageConstants.WAIT_ONE);
		healthSafetyWorkText.click();
		threadSleep(PageConstants.WAIT_ONE);
		healthSafetyWorkList.click();
		threadSleep(PageConstants.WAIT_ONE);
		healthSafetyWorkOption.click();
		threadSleep(PageConstants.WAIT_ONE);
		freedAssocText.click();
		threadSleep(PageConstants.WAIT_ONE);
		freedAssocList.click();
		threadSleep(PageConstants.WAIT_ONE);
		freedAssocOption.click();
		threadSleep(PageConstants.WAIT_ONE);
		equalityempText.click();
		threadSleep(PageConstants.WAIT_ONE);
		equalityempList.click();
		threadSleep(PageConstants.WAIT_ONE);
		equalityempOption.click();
		threadSleep(PageConstants.WAIT_ONE);
		fairWagesText.click();
		threadSleep(PageConstants.WAIT_ONE);
		fairWagesList.click();
		threadSleep(PageConstants.WAIT_ONE);
		fairWagesOption.click();
		threadSleep(PageConstants.WAIT_ONE);
		scrollIntoView(emptrainingText);
		threadSleep(PageConstants.WAIT_ONE);
		emptrainingList.click();
		threadSleep(PageConstants.WAIT_ONE);
		emptrainingOption.click();
		threadSleep(PageConstants.WAIT_TWO);
	}

	public void addPoliciesPartSecond() throws InterruptedException {
		threadSleep(PageConstants.WAIT_TWO);
		scrollIntoView(HealthSafetyPolicyText);
		threadSleep(PageConstants.WAIT_ONE);
		HealthSafetyPolicyList.click();
		threadSleep(PageConstants.WAIT_ONE);
		HealthSafetyPolicyOption.click();
		threadSleep(PageConstants.WAIT_THREE);
		scrollIntoView(HealthSafetyPolicyTickText);
		threadSleep(PageConstants.WAIT_TWO);
		WebDriverWait wait16 = new WebDriverWait(driver, Duration.ofSeconds(6));
		WebElement element16 = wait16
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[22]")));
		element16.click();
		threadSleep(PageConstants.WAIT_THREE);
		HealthSafetyPolicyTick0.click();
		threadSleep(PageConstants.WAIT_THREE);
		HealthSafetyPolicyTick1.click();
		threadSleep(PageConstants.WAIT_THREE);
		HealthSafetyPolicyTick2.click();
		threadSleep(PageConstants.WAIT_THREE);
		HealthSafetyPolicyTick3.click();
		threadSleep(PageConstants.WAIT_THREE);
		HealthSafetyPolicyTick4.click();
		threadSleep(PageConstants.WAIT_THREE);
		HealthSafetyPolicyTick5.click();
		threadSleep(PageConstants.WAIT_THREE);
		HealthSafetyPolicyTick6.click();
		threadSleep(PageConstants.WAIT_ONE);
		element16.click();
		threadSleep(PageConstants.WAIT_TWO);
		scrollIntoView(formalEnvPolicyText);
		threadSleep(PageConstants.WAIT_TWO);
		formalEnvPolicyList.click();
		threadSleep(PageConstants.WAIT_ONE);
		formalEnvPolicyOption.click();
		threadSleep(PageConstants.WAIT_FOUR);
		scrollIntoView(formalEnvPolicyTickText);
		threadSleep(PageConstants.WAIT_ONE);
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(6));
		WebElement element2 = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[24]")));
		element2.click();
		threadSleep(PageConstants.WAIT_ONE);
		formalEnvPolicyTick0.click();
		threadSleep(PageConstants.WAIT_THREE);
		formalEnvPolicyTick1.click();
		threadSleep(PageConstants.WAIT_THREE);
		formalEnvPolicyTick2.click();
		threadSleep(PageConstants.WAIT_THREE);
		formalEnvPolicyTick3.click();
		threadSleep(PageConstants.WAIT_THREE);
		formalEnvPolicyTick4.click();
		threadSleep(PageConstants.WAIT_THREE);
		formalEnvPolicyTick5.click();
		threadSleep(PageConstants.WAIT_THREE);
		formalEnvPolicyTick6.click();
		threadSleep(PageConstants.WAIT_TWO);
		formalEnvPolicyTick7.click();
		threadSleep(PageConstants.WAIT_TWO);
		formalEnvPolicyTick8.click();
		threadSleep(PageConstants.WAIT_TWO);
		formalEnvPolicyTick9.click();
		threadSleep(PageConstants.WAIT_TWO);
		formalEnvPolicyTick10.click();
		threadSleep(PageConstants.WAIT_TWO);
		formalEnvPolicyTick11.click();
		threadSleep(PageConstants.WAIT_TWO);
		formalEnvPolicyTick12.click();
		threadSleep(PageConstants.WAIT_TWO);
		formalEnvPolicyTick13.click();
		threadSleep(PageConstants.WAIT_TWO);
		formalEnvPolicyTick14.click();
		threadSleep(PageConstants.WAIT_TWO);
		formalEnvPolicyTick15.click();
		threadSleep(PageConstants.WAIT_TWO);
		element2.click();
	}

	public void addPoliciesAndCertifications() throws InterruptedException {
		
		Policiesandcertifications.click();
		scrollIntoView(Policiesandcertificationstext);
		threadSleep(PageConstants.WAIT_TWO);
		formalPolicyList.click();
		threadSleep(PageConstants.WAIT_ONE);
		formalPolicyOption.click();
		threadSleep(PageConstants.WAIT_TWO);
		envPerformanceList.click();
		threadSleep(PageConstants.WAIT_ONE);
		envPerformanceOption.click();
		scrollIntoView(envManagementSysText);
		envManagementSysList.click();
		threadSleep(PageConstants.WAIT_ONE);
		envManagementSysOption.click();
		/*threadSleep(PageConstants.WAIT_ONE);
		scrollIntoView(policyCoveringText);
		threadSleep(PageConstants.WAIT_ONE);
		policyCoveringList.click();
		threadSleep(PageConstants.WAIT_ONE);
		policyCoveringOption.click();
		threadSleep(PageConstants.WAIT_FIVE);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4)); // employeeDoc
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='searchSelectID-main'])[20]")));
		element.click();
		threadSleep(PageConstants.WAIT_TWO);
		employeeDocOption0.click();
		threadSleep(PageConstants.WAIT_THREE);
		employeeDocOption1.click();
		threadSleep(PageConstants.WAIT_THREE);
		employeeDocOption2.click();
		threadSleep(PageConstants.WAIT_THREE);
		employeeDocOption3.click();
		threadSleep(PageConstants.WAIT_THREE);
		employeeDocOption4.click();
		threadSleep(PageConstants.WAIT_THREE);
		employeeDocOption5.click();
		threadSleep(PageConstants.WAIT_THREE);
		employeeDocOption6.click();
		threadSleep(PageConstants.WAIT_THREE);
		employeeDocOption7.click();
		threadSleep(PageConstants.WAIT_THREE);
		employeeDocOption8.click();
		threadSleep(PageConstants.WAIT_TWO);*/
	}

	public void addResponsibleSupplyChainManagement() throws InterruptedException {
		scrollIntoView(supplyChainManageText);
		threadSleep(PageConstants.WAIT_ONE);
		supplyChainManageList.click();
		threadSleep(PageConstants.WAIT_TWO);
		supplyChainManageOption.click();
		threadSleep(PageConstants.WAIT_FOUR);
		supplyChainManageText1.click();
		threadSleep(PageConstants.WAIT_TWO);
		scrollIntoView(tickTheAreaText);
		tickTheAreaList.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption0.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption1.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption2.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption3.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption4.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption5.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption6.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption7.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption8.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption9.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption10.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption11.click();
		threadSleep(PageConstants.WAIT_THREE);
		tickTheAreaOption12.click();
		threadSleep(PageConstants.WAIT_THREE);
		envManagementSys.click();
		threadSleep(PageConstants.WAIT_TWO);
		humanRightsList.click();
		threadSleep(PageConstants.WAIT_THREE);
		humanRightsoptions.click();
		threadSleep(PageConstants.WAIT_ONE);
	}

	public void addBuisnessEthics() throws InterruptedException {
		scrollIntoView(buisnessEthicsText);
		threadSleep(PageConstants.WAIT_ONE);
		buisnessEthicsList.click();
		buisnessEthicsOption.click();
		threadSleep(PageConstants.WAIT_SIX);
		scrollIntoView(buisnessEthicsPolicyText);
		threadSleep(PageConstants.WAIT_ONE);
		buisnessEthicsPolicyList.click();
		threadSleep(PageConstants.WAIT_THREE);
		buisnessEthicsPolicyOption0.click();
		threadSleep(PageConstants.WAIT_THREE);
		buisnessEthicsPolicyOption1.click();
		threadSleep(PageConstants.WAIT_THREE);
		buisnessEthicsPolicyOption2.click();
		threadSleep(PageConstants.WAIT_THREE);
		buisnessEthicsPolicyOption3.click();
		threadSleep(PageConstants.WAIT_THREE);
		buisnessEthicsPolicyOption4.click();
		threadSleep(PageConstants.WAIT_THREE);
		buisnessEthicsPolicyOption5.click();
		threadSleep(PageConstants.WAIT_THREE);
		buisnessEthicsPolicyOption6.click();
		threadSleep(PageConstants.WAIT_THREE);
		buisnessEthicsPolicyOption7.click();
		threadSleep(PageConstants.WAIT_THREE);
		buisnessEthicsPolicyOption8.click();
		threadSleep(PageConstants.WAIT_THREE);
		buisnessEthicsPolicyOption9.click();
		threadSleep(PageConstants.WAIT_ONE);

	}

	public void addGovernance() throws InterruptedException {
		scrollIntoView(governance);
		threadSleep(PageConstants.WAIT_ONE);
		socialSustainabilityList.click();
		socialSustainabilityOption.click();
		threadSleep(PageConstants.WAIT_FOUR);
		scrollIntoView(enviormentSustainabilityText);
		threadSleep(PageConstants.WAIT_ONE);
		enviormentSustainabilityList.click();
		enviormentSustainabilityOption.click();
		threadSleep(PageConstants.WAIT_FOUR);
		scrollIntoView(monitoringSustainabilityText);
		threadSleep(PageConstants.WAIT_ONE);
		monitoringSustainabilityList.click();
		monitoringSustainabilityOption.click();
		threadSleep(PageConstants.WAIT_FOUR);
		scrollIntoView(codeOfCoText);
		threadSleep(PageConstants.WAIT_ONE);
		codeOfCoList.click();
		codeOfCoOption.click();
		threadSleep(PageConstants.WAIT_THREE);
		scrollIntoView(codeOfCoText1);
		threadSleep(PageConstants.WAIT_ONE);
		codeOfCoList1.click();
		codeOfCoOption1.click();
		threadSleep(PageConstants.WAIT_THREE);
		scrollIntoView(complaintsText);
		complaintsList.click();
		threadSleep(PageConstants.WAIT_TWO);
		complaintsOption1.click();
		threadSleep(PageConstants.WAIT_TWO);
		complaintsOption2.click();
		threadSleep(PageConstants.WAIT_TWO);
		complaintsOption3.click();
		threadSleep(PageConstants.WAIT_THREE);

	}

	public void yopmailLogin(String email) throws InterruptedException {
		openNewTabAndNavigate(PageConstants.PAGE_YOPMAIL_URL);
		loginButton.sendKeys(email);
		arrowButton.click();
		threadSleep(PageConstants.WAIT_TWO);
		driver.switchTo().frame(mailFrame);
		threadSleep(PageConstants.WAIT_TWO);
		viewToRequestButton.click();

	}

	public void openNewTabAndNavigate(String url) throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_FOUR);

	}

	public void SwitchToURL(String url) throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		threadSleep(PageConstants.WAIT_ONE);
	}

	public void generalInformation(String revenue, String location) throws InterruptedException {
		searchCompanySize.click();
		selectCompanySize.click();
		revenueCompany.sendKeys(revenue);
		locationCompany.sendKeys(location);
		autocompleteAddress.click();
		threadSleep(PageConstants.WAIT_TWO);
		purchasingRealtionshipList.click();
		purchasingRealtionshipSelect.click();
		threadSleep(PageConstants.WAIT_TWO);
		qualityRealtionshipList.click();
		qualityRealtionshipSelect.click();
		threadSleep(PageConstants.WAIT_TWO);
		companyImpactList.click();
		companyImpactSelect.click();
		threadSleep(PageConstants.WAIT_TWO);

	}
	
	public void yopmailLoginforOTP(String email) throws InterruptedException {
		String otp = getOtpFromEmail(email);
		System.out.println(otp);
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Window handle size: " + windowHandles.size());
        driver.switchTo().window(windowHandles.get(2));
        WebElement otpInput = driver.findElement(By.id("otp"));
        otpInput.sendKeys(otp);
        submitOTPButton.click();        
    }


	public String getOtpFromEmail(String email) throws InterruptedException {
		String emailBody = getEmailBodyFromInbox(email);
		System.out.println(emailBody);

		// Regular expression to extract the OTP (numeric string of 6 digits)
		Pattern otpPattern = Pattern.compile("\\b\\d{6}\\b");
		Matcher matcher = otpPattern.matcher(emailBody);

		if (matcher.find()) {
			return matcher.group(); // Return OTP if found
		}

		return null; // Return null if no OTP found
		
	
	}

	public String getEmailBodyFromInbox(String email) throws InterruptedException {
		openNewTabAndNavigate(PageConstants.PAGE_YOPMAIL_URL);
		System.out.println(email);
		arrowButton.click();
		threadSleep(PageConstants.WAIT_TWO);
		driver.switchTo().frame(mailFrame);
		String emailBody = otpElement.getText(); // Get the email body text
		System.out.println(emailBody);
		return emailBody; // Return the email body content as a string
	}

}

package Daato_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.AddSupplierPage;
import daato_automation_page.LoginPage;

public class Add_Supplier extends Base_Class{
	
	String Company_Name;
	String Contact_Email;
	String Contact_name;
	String Countries_of_operation;
	String Product_or_services;
	String Spend_volume;
	String User_Invited;
	
@Test

public void add_supplier() throws InterruptedException {
	
	
	LoginPage login = new LoginPage(driver);
	login.LoginApplication("piyush.soni@47billion.com", "681993@Virat");
	
	AddSupplierPage addSupplier = new AddSupplierPage(driver);
	addSupplier.navigateToSupplier();
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\47Billion\\Desktop\\xlsx\\Add_Supplier_Afghanistan.xlsx");
	 
	 int count = reader.getRowCount("Add_Supplier");
	 
	 for(int i=0;i<count-1;i++) {
		
		 User_Invited=reader.getCellData("Add_Supplier", "User_Invited", i+2);
		 
		 if(User_Invited.equals("No")) {
			 
		 Company_Name = reader.getCellData("Add_Supplier", "Company_Name", i+2);	 
		 Contact_Email=reader.getCellData("Add_Supplier", "Contact_Email", i+2); 
		 Contact_name =reader.getCellData("Add_Supplier", "Contact_name", i+2);
		 Countries_of_operation  =  reader.getCellData("Add_Supplier", "Countries_of_operation", i+2);
		 Product_or_services = reader.getCellData("Add_Supplier","Product_or_services", i+2);
         Spend_volume= reader.getCellData("Add_Supplier", "Spend_volume", i+2);

         System.out.println(Countries_of_operation);
		 System.out.println(Product_or_services);
		 double C = Double.parseDouble(Countries_of_operation);
		 double P =Double.parseDouble(Product_or_services);
		 int Company1 = (int) C;
		 int Product1 = (int) P;		
	
		 addSupplier.addSupplierForm(Company_Name, Contact_Email, Contact_name,Company1,Product1, Spend_volume);
		 reader.setCellData("Add_Supplier","User_Invited",i+2,"Yes");	
		 break;
	
		 }
		 		 
	 }
	 	reader.setCellData("Recent_Added","Company_Name",2,Company_Name);
	 	reader.setCellData("Recent_Added","Email",2,Contact_Email);

	}
}

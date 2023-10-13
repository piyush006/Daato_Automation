/* Hello, Welcome to Divya Coding */
package daato_automation_test;

import java.io.IOException;

import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.AddSupplierPage;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;

/**
 * @author 47Billion
 *
 */
public class AddSupplierTest extends BaseTest{
	String Company_Name;
	String Contact_Email;
	String Contact_name;
	String Countries_of_operation;
	String Product_or_services;
	String Spend_volume;
	String User_Invited;
	
	String propertyFileName = "globaldata";
	
@Test
public void add_supplier() throws InterruptedException, IOException {
	
	
	PropertyFileUtils prop = new PropertyFileUtils();
	LoginPage login = new LoginPage(driver);
	login.LoginApplication(prop.getuser(),prop.getpassword());
	
	AddSupplierPage addSupplierpage = new AddSupplierPage(driver);
	addSupplierpage.navigateToSupplier();
	
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
	
		 addSupplierpage.addSupplierForm(Company_Name, Contact_Email, Contact_name,Company1,Product1, Spend_volume);
		 reader.setCellData("Add_Supplier","User_Invited",i+2,"Yes");	
		 break;
	
		 }
		 		 
	 }
	 
	 System.out.println(Company_Name);
	 	reader.setCellData("Recent_Added","Company_Name",2,Company_Name);
	 	reader.setCellData("Recent_Added","Email",2,Contact_Email);

	}
}





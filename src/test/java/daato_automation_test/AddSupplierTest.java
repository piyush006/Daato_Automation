/* Hello, Welcome to Divya Coding */
package daato_automation_test;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import Excel.utility.Xls_Reader;
import daato_automation_page.AddSupplierPage;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.BaseTest;
import daato_automation_testcomponent.TestConstants;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author 47Billion
 *
 */
public class AddSupplierTest extends BaseTest {
	String Company_Name;
	String Contact_Email;
	String Contact_name;
	String Countries_of_operation;
	String Product_or_services;
	String Spend_volume;
	String User_Invited;

	@Test(priority=1)
	public void add_supplier() throws InterruptedException, IOException {

		
		PropertyFileUtils p = new PropertyFileUtils();
		LoginPage login = new LoginPage(driver);
		login.LoginApplication(PropertyFileUtils.getUser(), PropertyFileUtils.getPassword());
		//PropertyFileUtils prop = new PropertyFileUtils();
		

		AddSupplierPage addSupplierpage = new AddSupplierPage(driver);
		addSupplierpage.navigateToSupplier();

		 FileInputStream fis = new FileInputStream(TestConstants.TEST_DATA_FILE_PATH);
		    Workbook workbook = new XSSFWorkbook(fis);

		    // Step 2: Pass both path and workbook to Xls_Reader
		    Xls_Reader reader = new Xls_Reader(TestConstants.TEST_DATA_FILE_PATH, workbook);
		int count = reader.getRowCount("Add_Supplier");

		for (int i = 0; i < count - 1; i++) {
	        String User_Invited = reader.getCellData("Add_Supplier", "User_Invited", i + 2);

	        if (User_Invited.equals("No")) {
	            String Company_Name = reader.getCellData("Add_Supplier", "Company_Name", i + 2);
	            String Contact_Email = reader.getCellData("Add_Supplier", "Contact_Email", i + 2);
	            String Contact_name = reader.getCellData("Add_Supplier", "Contact_name", i + 2);
	            String Countries_of_operation = reader.getCellData("Add_Supplier", "Countries_of_operation", i + 2);
	            String Product_or_services = reader.getCellData("Add_Supplier", "Product_or_services", i + 2);
	            String Spend_volume = reader.getCellData("Add_Supplier", "Spend_volume", i + 2);

	            System.out.println(Countries_of_operation);
	            System.out.println(Product_or_services);

	            double C = Double.parseDouble(Countries_of_operation);
	            double P = Double.parseDouble(Product_or_services);
	            int Company1 = (int) C;
	            int Product1 = (int) P;

	            addSupplierpage.addSupplierForm(Company_Name, Contact_Email, Contact_name, Company1, Product1, Spend_volume);
	            reader.setCellData("Add_Supplier", "User_Invited", i + 2, "Yes");

	            // ✅ Save Recent Added Supplier
	            reader.setCellData("Recent_Added", "Company_Name", 2, Company_Name);
	            reader.setCellData("Recent_Added", "Email", 2, Contact_Email);
	            reader.setCellData("Customer_Login", "Company_Name", 2, Company_Name);
	            reader.setCellData("Customer_Login", "Email", 2, Contact_Email);

	            break;
	        }
	    }

		 reader.closeWorkbook();
		    fis.close();
		
	}
}

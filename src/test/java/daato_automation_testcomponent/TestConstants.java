/* Hello, Welcome to Divya Coding */
package daato_automation_testcomponent;

/**
 * @author 47Billion
 *
 */
public class TestConstants {

	public static final String TEST_DAATO_URL = "https://qa.daato.app";
	public static final String TEST_CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String TEST_CHROME_DRIVER_PATH = "C:\\Users\\47Billion\\Desktop\\chromedriver_win32\\chromedriver.exe";
//	public static final String TEST_DATA_FILE_PATH = "C:\\Users\\47Billion\\Desktop\\Daato_Automation\\Add_Supplier_Afghanistan.xlsx";
//	public static final String TEST_DATA_FILE_PATH =System.getProperty("user.dir")+ "/test-data/Add_Supplier_Afghanistan.xlsx";
	public static final String TEST_DATA_FILE_PATH = System.getProperty("user.dir") + "/target/runtime/Add_Supplier_Afghanistan.xlsx";
	public static final String TEST_SUPPLIER_REPO_URL = "https://qa.daato.app/modules/supplyChain/suppliersRepository?";
	public static final int WAIT_TWO = 2000;
	public static final int WAIT_FOUR = 4000;
	public static final int WAIT_THREE = 3000;
	public static final int WAIT_TWENTY = 20000;
	public static final int WAIT_THIRTY = 30000;
}

/* Hello, Welcome to Divya Coding */
package daato_automation_pagecomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

/**
 * @author 47Billion
 *
 */
public class PropertyFileUtils {
	Properties properties;
	String path = "C:\\Users\\47Billion\\eclipse-workspace\\Daato_Automation_Functional\\src\\test\\resources\\globaldata.properties";

	public PropertyFileUtils() throws IOException {

		properties = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getuser() {

		String email = properties.getProperty("globalemail");

		return email;

	}

	public String getpassword() {

		String password = properties.getProperty("globalpass");

		return password;

	}

}

package Daato_Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertiesefile {
	
	
	
	
	 Properties properties;
	 String path = "C:\\Users\\47Billion\\eclipse-workspace\\Daato_Automation_Functional\\src\\main\\java\\Daato_Automation\\Propertiesefile";

	public Propertiesefile() throws IOException {
		
		
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
	
	
	public String getURLSettings() {
		
		String url = properties.getProperty("URLSettings");
		
		return url;
		
		
	}
public String getURLSupplierrepo() {
		
		String url = properties.getProperty("URLSupplierrepo");
		
		return url;
		
		
	}
public String getURLIncident() {
	
	String url = properties.getProperty("URLIncident");
	
	return url;
	
	
}

}
	
	
	
	
	
	
	
	
	
	
	
	
	



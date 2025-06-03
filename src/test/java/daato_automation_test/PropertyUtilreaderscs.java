package daato_automation_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtilreaderscs {
	
	
	
	
	private static final String FILE_PATH = "scsdata.properties";

    public static String getcompanyname() {
        return getValue("companyname");
    }

    public static String getcontactemail() {
        return getValue("contactemail");
    }
    public static String getcontactname() {
        return getValue("contactname");
    }
   
    		
    		
    
    
    
    
    private static String getValue(String key) {
        Properties props = new Properties();
        try (FileInputStream input = new FileInputStream(FILE_PATH)) {
            props.load(input);
            return props.getProperty(key);
        } catch (IOException e) {
            System.err.println("Failed to read from properties file.");
            e.printStackTrace();
            return null;
        }
    }	
	
	
	
	
	

}

package EU_Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtilsreadereu {
	
	
	
	private static final String FILE_PATH = "EU.properties";

    public static String reportid() {
        return getValue("reportid");
    }
    public static String datacollectionid() {
        return getValue("datacollectionidntid");
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

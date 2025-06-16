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
        return getValue("datacollectionid");
    }
    
    public static String Mins32() {
        return getValue("Mins32");
    }
    public static String Mins91() {
        return getValue("Mins91");
    }

    public static String Activityid32() {
        return getValue("Activityid32");
    }
    
    public static String Activityid92() {
        return getValue("Activityid92");
    }
    
    public static String Alingmentid92() {
        return getValue("Alingmentid92");
    }
    
    public static String Alingmentid32() {
        return getValue("Alingmentid32");
    }
    public static String dataproviderid() {
        return getValue("dataproviderid");
    }
    public static String dataprovideremail() {
        return getValue("dataprovideremail");
    }
    public static String Extractdid() {
        return getValue("Extractdid");
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

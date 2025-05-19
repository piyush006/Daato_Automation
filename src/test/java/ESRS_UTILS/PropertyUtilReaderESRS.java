package ESRS_UTILS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtilReaderESRS {
	
	
	
	private static final String FILE_PATH = "ESRSlite.properties";

    public static String reportid() {
        return getValue("reportid");
    }
    public static String parentid() {
        return getValue("parentid");
    }

public static String parentemail() {
    return getValue("parentemail");
}

public static String parententityid() {
    return getValue("parententityid");
}

public static String childid() {
    return getValue("childid");
}

public static String childemail() {
    return getValue("childemail");
}

public static String childentityid() {
    return getValue("childentityid");
}

public static String dataCollectionId() {
    return getValue("dataCollectionId");
}

public static String esrsentitydatacollectionid() {
    return getValue("esrsentitydatacollectionid");
}

public static String esrsentitydatacollectionidparent() {
    return getValue("esrsentitydatacollectionidparent");
}

public static String disclosureRequirementReportId() {
    return getValue("disclosureRequirementReportId");
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

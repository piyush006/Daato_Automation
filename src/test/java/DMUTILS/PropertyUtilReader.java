package DMUTILS;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtilReader {
	
	
	private static final String FILE_PATH = "stakeholder.properties";

    public static String getStakeId() {
        return getValue("stakeid");
    }

    public static String getStakeholderName() {
        return getValue("stakeholderName");
    }
    public static String getReportId() {
        return getValue("reportid");
    }
    public static String stakeholdermail() {
        return getValue("stakeholdermail");
    }
    public static String extractedId() {
        return getValue("extractedId");
    }
    public static String iroId() {
        return getValue("iroId");
    }
    public static String Assessmentreportid() {
        return getValue("Assessmentreportid");
    }
    public static String contributorId() {
        return getValue("contributorId");
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

package DMUTILS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtilWriter {
	
	
	
	private static final String FILE_PATH = "stakeholder.properties";

    public static void writeProperty(String key, String value) {
        Properties props = new Properties();

        // Load existing properties
        try (FileInputStream input = new FileInputStream(FILE_PATH)) {
            props.load(input);
        } catch (IOException e) {
            System.out.println("Properties file not found. A new one will be created.");
        }

        // Set or overwrite key
        props.setProperty(key, value);

        // Save updated properties
        try (FileOutputStream output = new FileOutputStream(FILE_PATH)) {
            props.store(output, "Updated Stakeholder Info");
            System.out.println("Updated " + key + " in properties file.");
        } catch (IOException e) {
            System.err.println("Failed to write to properties file.");
            e.printStackTrace();
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	/* private static final String FILE_PATH = "stakeholder.properties";

	    public static void writeStakeholderData(String stakeid, String stakeholderName) {
	        Properties props = new Properties();
	        props.setProperty("stakeid", stakeid);
	        props.setProperty("stakeholderName", stakeholderName);

	        try (FileOutputStream output = new FileOutputStream(FILE_PATH)) {
	            props.store(output, "Stakeholder Info");
	            System.out.println("Written to properties file.");
	        } catch (IOException e) {
	            System.err.println("Failed to write properties file.");
	            e.printStackTrace();
	        }
	    }*/
	
	
	
	
	
	
	
	
	
	

}

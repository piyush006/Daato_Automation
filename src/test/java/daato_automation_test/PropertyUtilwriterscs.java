package daato_automation_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtilwriterscs {
	
	
	
	
	private static final String FILE_PATH = "scsdata.properties";

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
            props.store(output, "Updated supplier Info");
            System.out.println("Updated " + key + " in properties file.");
        } catch (IOException e) {
            System.err.println("Failed to write to properties file.");
            e.printStackTrace();
        }
    }
	
	
	
	
	

}

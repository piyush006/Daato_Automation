package daato_automation_test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;
import org.testng.annotations.BeforeSuite;


import org.testng.annotations.BeforeSuite;
import java.io.*;
import java.nio.file.*;

public class TestDatasetup {
	
	
	/*@BeforeSuite
	public void copyTestDataFileOnce() throws IOException {
	    String projectDir = System.getProperty("user.dir");

	    Path sourcePath = Paths.get(projectDir, "test-data", "Add_Supplier_Afghanistan.xlsx");
	    Path targetDir = Paths.get(projectDir, "target", "runtime");

	    // Create target dir if it doesn't exist
	    if (Files.notExists(targetDir)) { // use NOT_EXISTS, safer
	        Files.createDirectories(targetDir);
	    }

	    Path targetPath = targetDir.resolve("Add_Supplier_Afghanistan.xlsx");

	    // Only copy ONCE before the full suite
	    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

	    System.out.println("✅ Test data copied ONCE to: " + targetPath.toString());
	}
	
	*/
}

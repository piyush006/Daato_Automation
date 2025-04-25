package daato_automation_testcomponent;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Getlatestfilepath {
	
	
	
    public static File getLatestFileFromDir(String dirPath, String extension) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles((d, name) -> name.toLowerCase().endsWith(extension));

        if (files != null && files.length > 0) {
            return Arrays.stream(files)
                    .max(Comparator.comparingLong(File::lastModified))
                    .orElse(null);
        }
        return null;
    }
	
	
	
	
	
	
	
	
	
	
	
	

}

package DoubleMateriality;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DMUTILS.DMfiledownloader;
import DMUTILS.ImpactData;
import DMUTILS.PropertyUtilReader;
import DMUTILS.XLSXdatareader;
import Excel.utility.Xls_Reader;
import daato_automation_page.LoginPage;
import daato_automation_pagecomponent.PageConstants;
import daato_automation_pagecomponent.PropertyFileUtils;
import daato_automation_testcomponent.Getlatestfilepath;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.AuthTokenadminUtil;
import utils.FileDownloader;
import utils.SupplierDataReader;

public class DownloadDMxlsx {
	
	
	
	String url;
	String admintoken;
	String reportid;
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
	reportid=PropertyUtilReader.getReportId();
		}
	
	
	@Test(priority=1)
	
	public void downloadrepository() throws IOException, InterruptedException, URISyntaxException {
		
		
	
	    System.out.println(reportid);
		
		
	    String url = XLSXdatareader.downloadFile(admintoken,reportid);
	    System.out.println(url);
	    

	  
	    
	    Path downloadPath = Paths.get(System.getProperty("user.dir"), "downloadDMxlsx");
	    Files.createDirectories(downloadPath); // Creates folder if not exists
	    DMfiledownloader.downloadFileFromUrl(url, downloadPath.toString());
	    
	    
	    System.out.println("TEST PASSED: DM excel file downloaded Successfully");
	    
	
}	
	
	
@Test(priority=2)


public void checklatestfiledata() throws IOException {
	
	
	
   	String downloadPath = System.getProperty("user.dir") + "/downloadDMxlsx";
	//String downloadPath = System.getProperty("download.dir", System.getProperty("user.dir") + "/downloads");
    File latestFile = Getlatestfilepath.getLatestFileFromDir(downloadPath, ".xlsx");

    System.out.println(latestFile);
    FileInputStream fis = new FileInputStream(latestFile);
    Workbook workbook = new XSSFWorkbook(fis);
    Xls_Reader reader = new Xls_Reader(latestFile.getAbsolutePath(), workbook);
    int count = reader.getRowCount("Impacts");
    
    
    ArrayList<String> Actual_name = new ArrayList<String>();
    ArrayList<String> Actual_description = new ArrayList<String>();
    ArrayList<String> Actual_sustainabilityMatter = new ArrayList<String>();
    ArrayList<String> Actual_assessment = new ArrayList<String>();
    ArrayList<String> Actual_type = new ArrayList<String>();
    ArrayList<String> Actual_nature = new ArrayList<String>();
    ArrayList<String> Actual_timeframe = new ArrayList<String>();
    
  
    
    List<ImpactData> impactList = new ArrayList<>();

    for (int i = 0; i < count - 1; i++) {
        String name = reader.getCellData("Impacts", "Name", i + 2);
        String description = reader.getCellData("Impacts", "Description", i + 2);
        String sustainabilityMatter = reader.getCellData("Impacts", "Sustainability matter", i + 2);
        String assessment = reader.getCellData("Impacts", "Assessment", i + 2);
        String type = reader.getCellData("Impacts", "Type", i + 2);
        String nature = reader.getCellData("Impacts", "Nature", i + 2);
        String timeframe = reader.getCellData("Impacts", "Timeframe", i + 2);
        
        Actual_name.add(name);
        Actual_description.add(description);
        Actual_sustainabilityMatter.add(sustainabilityMatter);
        Actual_assessment.add(assessment);
        Actual_type.add(type);
        Actual_nature.add(nature);
        Actual_timeframe.add(timeframe);
        

        ImpactData data = new ImpactData(name, description, sustainabilityMatter, assessment, type, nature, timeframe);
        impactList.add(data);
        System.out.println(data); // This prints dynamic data from Excel
        
        
        
        
        
    
 
    }
    
    List<String> expectedNames = getExpectedNames();
    List<String> expectedDescriptions = getExpectedDescriptions();
    List<String> expectedSustainabilityMatters = getExpectedSustainabilityMatters();
    List<String> expectedAssessments = getExpectedAssessments();
    List<String> expectedTypes = getExpectedTypes();
    List<String> expectedNatures = getExpectedNatures();
    List<String> expectedTimeframes = getExpectedTimeframes();
    
    
    Assert.assertEquals(Actual_name, expectedNames);
    Assert.assertEquals(Actual_description, expectedDescriptions);
    Assert.assertEquals(Actual_sustainabilityMatter, expectedSustainabilityMatters);
    Assert.assertEquals(Actual_assessment, expectedAssessments);
    Assert.assertEquals(Actual_type, expectedTypes);
    Assert.assertEquals(Actual_nature, expectedNatures);
    Assert.assertEquals(Actual_timeframe, expectedTimeframes);
    
    
    System.out.println("TEST PASSED: IRO Details showing correct on excel file");
    
    
    
}



    
    

    private List<String> getExpectedNames() {
        List<String> names = new ArrayList<>();
        names.add("Automatedimpact01");
        names.add("Automatedimpact02");
        names.add("Automatedimpact03");
        names.add("Automatedimpact04");
        names.add("Automatedmanual");
        return names;
    }

    private List<String> getExpectedDescriptions() {
        List<String> descriptions = new ArrayList<>();
        descriptions.add("Testauto01");
        descriptions.add("Testauto02");
        descriptions.add("Testauto03");
        descriptions.add("Testauto04");
        descriptions.add("Test");
        return descriptions;
    }

    private List<String> getExpectedSustainabilityMatters() {
        List<String> sustainabilityMatters = new ArrayList<>();
        sustainabilityMatters.add("Climate change adaptation");
        sustainabilityMatters.add("Climate change adaptation");
        sustainabilityMatters.add("Climate change mitigation");
        sustainabilityMatters.add("Climate change mitigation");
        sustainabilityMatters.add("Working conditions - Working time");
        return sustainabilityMatters;
    }

    private List<String> getExpectedAssessments() {
        List<String> assessments = new ArrayList<>();
        assessments.add("Very low");
        assessments.add("Very high");
        assessments.add("Very low");
        assessments.add("Very high");
        assessments.add("Very high");
        return assessments;
    }

    private List<String> getExpectedTypes() {
        List<String> types = new ArrayList<>();
        types.add("Negative");
        types.add("Positive");
        types.add("Negative");
        types.add("Positive");
        types.add("Negative");
        return types;
    }

    private List<String> getExpectedNatures() {
        List<String> natures = new ArrayList<>();
        natures.add("Potential");
        natures.add("Actual");
        natures.add("Potential");
        natures.add("Actual");
        natures.add("Potential");
        return natures;
    }

    private List<String> getExpectedTimeframes() {
        List<String> timeframes = new ArrayList<>();
        timeframes.add("Short-Term");
        timeframes.add("Mid-Term");
        timeframes.add("Short-Term");
        timeframes.add("Mid-Term");
        timeframes.add("Short-Term");
        return timeframes;
    }
    


   

	
}

	



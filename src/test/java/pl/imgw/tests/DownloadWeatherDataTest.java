package pl.imgw.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.imgw.model.ConfigProperties;
import pl.imgw.requests.ApiDataSynop;
import pl.imgw.util.FileUtil;

import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static pl.imgw.util.PropertiesUtil.getProperties;

public class DownloadWeatherDataTest {
    private ConfigProperties properties;
    private FileUtil fileUtil;
    private String fileContent;

    @BeforeTest
    public void setUp() throws IOException {
        System.out.println("Getting user properties...");
        properties = getProperties();
        System.out.println("User properties:");
        System.out.println("Directory: " + properties.getDirectory());
        System.out.println("Station name: " + properties.getStationName());
        System.out.println();
    }

    @Test
    public void checkIfFileIsAlreadyCreated(){
        fileUtil = new FileUtil(properties);
        System.out.println("Checking if " + fileUtil.getFilepath() + " is already created...");
        assertFalse(fileUtil.isFileSaved(), "File " + fileUtil.getFilepath() + " is already created");
        System.out.println("File is not yet created");
        System.out.println();
    }

    @Test(dependsOnMethods = "checkIfFileIsAlreadyCreated")
    public void getApiData(){
        System.out.println("Downloading weather forecast for station: " + properties.getStationName() + "...");
        ApiDataSynop apiDataSynop = new ApiDataSynop();
        fileContent = apiDataSynop.getApiDataSynop(properties.getStationName());
        System.out.println("Successfully downloaded data:");
        System.out.println(fileContent);
        System.out.println();
    }

    @Test(dependsOnMethods = "getApiData")
    public void saveFile(){
        System.out.println("Saving file...");
        fileUtil.saveFile(fileContent);
        assertTrue(fileUtil.isFileSaved(), "Failed to save " + fileUtil.getFilepath());
        System.out.println("File saved successfully");
    }
}

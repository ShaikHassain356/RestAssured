package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class capturescreen {

    private WebDriver driver; // WebDriver instance

    // Constructor to initialize WebDriver
    public capturescreen(WebDriver driver) {
        this.driver = driver;
    }

    // Method to capture a screenshot
    public String CaptureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        // Using FileUtils to copy file
        FileUtils.copyFile(sourceFile, targetFile);

        return targetFilePath;
    }
}

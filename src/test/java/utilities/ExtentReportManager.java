package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import endpoints.BaseTest;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.ITestListener;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    private WebDriver driver;

    String repName;

    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Timestamp
        repName = "Test-Report-" + timeStamp + ".html";
        String reportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + repName;
        sparkReporter = new ExtentSparkReporter(reportPath); // Specify location

        sparkReporter.config().setDocumentTitle("Opencart Automation Report");
        sparkReporter.config().setReportName("Opencart Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "OrangeHRM and InternetHerokuApp");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.log(Status.PASS, result.getName() + " passed successfully");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName() + " failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {
            // Get WebDriver from BaseTest
            driver = BaseTest.getDriver();  // Ensure BaseTest has a proper WebDriver getter method

            // Initialize Screenshot Utility
            capturescreen cs = new capturescreen(driver);
            String imgPath = cs.CaptureScreen(result.getName());

            // Attach Screenshot to Report
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();

        // Open report automatically
        String reportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + repName;
        File extentReport = new File(reportPath);

        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Send Email with Report
        try {
            URL url = new URL("file:///" + reportPath);

            // Fetch email credentials securely from environment variables
            String emailUser = System.getenv("EMAIL_USER");
            String emailPass = System.getenv("EMAIL_PASS");

            if (emailUser == null || emailPass == null) {
                System.out.println("Email credentials not set! Skipping email sending...");
                return;
            }

            // Create Email
            ImageHtmlEmail email = new ImageHtmlEmail();
            email.setDataSourceResolver(new DataSourceUrlResolver(url));
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(emailUser, emailPass));
            email.setSSLOnConnect(true);
            email.setFrom(emailUser);
            email.setSubject("Test Results");
            email.setMsg("Please find the attached report.");
            email.addTo("recipient@example.com");
            email.attach(url, "Extent Report", "Check the attached test report.");
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

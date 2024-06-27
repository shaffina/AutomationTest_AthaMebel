package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExtentReportUtil {
    private ExtentReports extent;
    private Map<String, ExtentTest> testMap;

    public ExtentReportUtil() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setReportName("Test Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        testMap = new HashMap<>();
    }

    public void startTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        testMap.put(testName, test);
    }

    public void logInfo(String testName, String message) {
        ExtentTest test = testMap.get(testName);
        if (test != null) {
            test.info(message);
        }
    }

    public void logPass(String testName, String message) {
        ExtentTest test = testMap.get(testName);
        if (test != null) {
            test.pass(message);
        }
    }

    public void logFail(String testName, String message) {
        ExtentTest test = testMap.get(testName);
        if (test != null) {
            test.fail(message);
        }
    }

    public void endTest(String testName) {
        extent.flush();
        testMap.remove(testName);
    }

    public void takeScreenshot(WebDriver driver, String testName, String screenshotName) {
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("screenshots/" + screenshotName + ".png"));
            ExtentTest test = testMap.get(testName);
            if (test != null) {
                test.addScreenCaptureFromPath("screenshots/" + screenshotName + ".png");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flush() {
        extent.flush();
    }
}

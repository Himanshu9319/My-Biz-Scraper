package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CaptureScreenshot extends Base implements ITestListener {
    // This method will execute before starting of Test suite.
    public void onStart(ITestContext tr) {

    }

    // This method will execute, Once the Test suite is finished.
    public void onFinish(ITestContext tr) {

    }

    // This method will execute only when the test is pass.
    public void onTestSuccess(ITestResult tr) {
//        captureScreenShot(tr, "pass");
    }

    // This method will execute only on the event of fail test.
    public void onTestFailure(ITestResult tr) {
//        captureScreenShot(tr, "fail");


        Reporter.log(getTestRunId().toUpperCase()+" : Failed");
        captureScreenshot(tr.getName());
        String exceptionMessage = tr.getThrowable().getClass().toString();

        testLevelReport.get()
                .debug("<details>" + "<summary>" + "<b>" + "<font color=" + "red>"
                        + "Exception Occured:Click to see </summary>" + "</font>" + "</b >"
                        + exceptionMessage.replaceAll(",", "<br>") + "<br><a href =screenshots/failed_screen.png"
                        + " target=\"_blank\"><img src =\"screenshots/failed_screen.png"
                        + "\" height=\"100\" width =\"150\"/></a>" + "</details>");
        testLevelReport.get().log(Status.INFO, tr.getMethod().getMethodName().toUpperCase() + " Execution Ended");
        testLevelReport.get().log(Status.FAIL, "FAILED");
//        logger.info(tr.getMethod().getMethodName().toUpperCase() + " Execution Ended");

    }

    // This method will execute before the main test start (@Test)
    public void onTestStart(ITestResult tr) {

    }

    // This method will execute only if any of the main test(@Test) get skipped
    public void onTestSkipped(ITestResult tr) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
    }

    // Function to capture screenshot.
//    public void captureScreenShot(ITestResult result) {
//        // AndroidDriver driver=ScreenshotOnPassFail.getDriver();
//        String destDir = "";
//        String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
//        // To capture screenshot.
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
//        // If status = fail then set folder name "screenshots/Failures"
//        if (status.equalsIgnoreCase("fail")) {
//            destDir = "screenshots/Failure" ;
//        }
//        // If status = pass then set folder name "screenshots/Success"
//        else if (status.equalsIgnoreCase("pass")) {
//            destDir = "screenshots/Success";
//        }
//
//        // To create folder to store screenshots
//        new File(destDir).mkdirs();
//        // Set file name with combination of test class name + date time.
//        String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";
//
//        try {
//            // Store file at destination folder location
//            FileHandler.copy(scrFile, new File(destDir + "/" + destFile));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static void captureScreenshot(String testName) {


        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String screenshotName = testName + "_" + d.toString().replaceAll("[ :]", "_") + ".png";
        String absoluteScreenshotPath = Constants.SCREENSHOT_PATH + "failed_screen.png";

        try {
            FileUtils.copyFile(scrFile, new File(absoluteScreenshotPath));
            FileUtils.copyFile(scrFile, new File(Constants.ARCHIVED_SCREENSHOT_PATH + screenshotName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
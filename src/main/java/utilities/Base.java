package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties property;
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> classLevelReport = new ThreadLocal<ExtentTest>();
    public static ThreadLocal<ExtentTest> testLevelReport = new ThreadLocal<ExtentTest>();
    public static String className;
    private static String testName;
    private static String testRunId;
    protected String os = System.getProperty("os.name").toLowerCase();
    private String output;

    CommonFunctionsMobile common = new CommonFunctionsMobile();

    public Base() {
        OSValidator.setPropValues(os);
    }

    public static String getTestRunId() {
        return testRunId;
    }

    public static String getClassName() {
        return className;
    }

    @BeforeSuite
    public void setUpResources() {
        // Load Config Files
        property = TestUtilities.loadConfigProperties();
        extent = ExtentManager.getExtent();

    }

    @BeforeClass
    public void startClass() {
        ExtentTest parent = extent.createTest(getClass().getSimpleName());// + getClass().getAnnotation(Test.class).description());
//        ExtentTest parent = extent.createTest(getClass().getAnnotation(Test.class).description());
        parent.assignCategory("Epic_Level_Report");
        classLevelReport.set(parent);
        classLevelReport.get().log(Status.INFO, "Execution Started for : " + getClass().getSimpleName());//getClass().getAnnotation(Test.class).description());

        //Creates a test Node at class level in the extent report
        className = this.getClass().getSimpleName();

    }

    @Parameters({"platformName"})
    @BeforeTest(alwaysRun = true)
    public void getDevices(@Optional("platformName") String platformName) throws Exception {
        if (platformName.equalsIgnoreCase("android") || platformName.equalsIgnoreCase("ios")) {
            List<String> deviceUids = new ArrayList<String>();
            boolean devicefarm = Boolean.valueOf(property.getProperty("devicefarm"));
            if (!devicefarm) {
                if (platformName.trim().equalsIgnoreCase("ANDROID")) {
//                    output = TestUtilities.runCommandUsingTerminal(devicefarm, "ps -ef| grep -i logcat | grep -v grep | awk '{print $2}' | xargs kill -9;", false, "1", "WAIT");
                    output = TestUtilities.runCommandUsingTerminal(devicefarm, "adb devices", true, "1");
                } else if (platformName.trim().equalsIgnoreCase("IOS")) {
                    TestUtilities.runCommandUsingTerminal(devicefarm, "ps -ef| grep -i idevicesyslog | grep -v grep | awk '{print $2}' | xargs kill -9;", false, "1", "WAIT");
                    output = TestUtilities.runCommandUsingTerminal(devicefarm, "idevice_id -l", true, "1", "NOT NULL");
                }
                String[] adeviceList = output.split("\n");
                if (adeviceList.length > 0) {
                    for (int i = 0; i < adeviceList.length; i++) {
                        List<String> allMatches = new ArrayList<String>();
                        allMatches.add(adeviceList[i]);
                        String rawDeviceId = allMatches.get(allMatches.size() - 1);
                        String deviceId = rawDeviceId;
                        deviceUids.add(deviceId);
                    }
                    System.out.println("Device Ids :: " + deviceUids);
                } else {
                    Assert.fail("No device present");
                }
            }
        }
    }

    @Parameters({"platformName"})
    @BeforeMethod
    public void startMethod(@Optional("platformName") String platformName, Method m, ITestResult result) throws Exception {
        if (platformName.equalsIgnoreCase("android") || platformName.equalsIgnoreCase("ios")) {
            TestUtilities.preparation();
            CommonFunctionsMobile.launchApp();
            CommonFunctionsMobile.allowPermissions(true);
            //  common.removeBanner();
        }
        System.out.println("Started Execution of Test Case : " + m.getAnnotation(Test.class).description());
        testName = m.getName();
        testRunId = m.getName();
        //Creates a test Node at class level in the extent report
//        ExtentTest test = classLevelReport.get().createNode(m.getName().toUpperCase() + " " + m.getAnnotation(Test.class).description());

        ExtentTest test = classLevelReport.get().createNode(m.getAnnotation(Test.class).description());
        test.assignCategory("Test_Level_Report");
        testLevelReport.set(test);
//
//        testLevelReport.get().log(Status.INFO, "Execution Started for : " + result.getMethod().getMethodName().toUpperCase());
    }

    @Parameters({"platformName"})
    @AfterMethod
    public void killMethod(@Optional("platformName") String platformName, Method m, ITestResult result) throws Exception {
        System.out.println("Ended Execution of Test Case : " + m.getAnnotation(Test.class).description());
        testLevelReport.get().log(Status.INFO, "Execution Ended for : " + result.getMethod().getMethodName().toUpperCase());
        extent.flush();
        if (platformName.equalsIgnoreCase("android") || platformName.equalsIgnoreCase("ios")) {
            CommonFunctionsMobile.terminateApp();
//            TestUtilities.stopServer();
        }
        DriverManager.killDriverInstance();
    }

    @AfterClass
    public void killClass() throws Exception {
        classLevelReport.get().log(Status.INFO, "Execution Ended for : " + getClass().getSimpleName());
        System.out.println("Ended Execution of Test Case : " + getClass().getSimpleName());




    }

    @AfterSuite
    public void killResources() {
        TestUtilities.archiveExtentReports();
    }
}
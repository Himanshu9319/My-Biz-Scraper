package mobile.travelplus;

import io.cucumber.testng.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Base;
import utilities.CommonFunctionsMobile;
import utilities.TestUtilities;

import static utilities.CommonFunctionsMobile.launchApp;

@CucumberOptions(
        features = "src/test/java/mobile/travelplus/tests/features",
        glue = {"mobile.travelplus.tests"},
        tags = "@Test",
        plugin = {"html:testResults/cucumber-report.html"})

public class DriverTestRunner extends AbstractTestNGCucumberTests {
    static Base bs = new Base();
    static String platformName;
    private TestNGCucumberRunner testNGCucumberRunner;
    CommonFunctionsMobile common = new CommonFunctionsMobile();

    @BeforeClass(alwaysRun = true)
    @Parameters({"platformName","type","env"})
    public void setUpClass(@Optional() String platformName ,@Optional() String type ,@Optional() String env) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        Base.property = TestUtilities.loadConfigProperties();
        if(!Base.property.getProperty("platformName").equals("")) {
            platformName = Base.property.getProperty("platformName");
            env =Base.property.getProperty("environment");
        }
        else{
            Base.property.setProperty("platformName", platformName);
            Base.property.setProperty("environment", env);
        }
        Base.property = TestUtilities.addConfigProperties(env);
        if (platformName.equalsIgnoreCase("android") || platformName.equalsIgnoreCase("ios")) {
            bs.getDevices(platformName);
            TestUtilities.preparation();
        }
    }

    @BeforeMethod
    public void beforeMethod() throws Exception {
        platformName = Base.property.getProperty("platformName");
        if (platformName.equalsIgnoreCase("android") || platformName.equalsIgnoreCase("ios")) {
            launchApp();
        }
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

   // @AfterMethod
    public void afterMethod(ITestResult result) {
        platformName = Base.property.getProperty("platformName");
        if(!result.isSuccess()){
            if (platformName.equalsIgnoreCase("android")) {
                common.terminateApp();
            }
        }
    }

    @DataProvider(name = "scenarios")
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    //@AfterClass(alwaysRun = true)
    public void tearDownClass() {
        platformName = Base.property.getProperty("platformName");
        testNGCucumberRunner.finish();
        if (platformName.equalsIgnoreCase("android") || platformName.equalsIgnoreCase("ios")) {
            common.terminateApp();
        }
    }
}
package api.travelplus;

import io.cucumber.testng.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Base;
import utilities.CommonFunctionsAPI;
import utilities.Constants;
import utilities.TestUtilities;

import java.util.ArrayList;
import java.util.List;

import static utilities.Base.property;

@CucumberOptions(
        features = "src/test/java/api/travelplus/tests/features",
        tags = "@GDS",
        glue = {"api.travelplus.tests"},
        plugin = {"html:testResults/travelplus-cucumber-report.html", "json:testResults/cucumber-report.json"}
)

public class    TestRunner extends AbstractTestNGCucumberTests {
    int countofTC = 1;
    private TestNGCucumberRunner testNGCucumberRunner;
    List<String> preScrnario = new ArrayList<>();

    @BeforeClass(alwaysRun = true)
    @Parameters({"platformName", "type", "env", "countryCode"})
    public void setUpClass(@Optional() String platformName, @Optional() String type, @Optional() String env, @Optional String countryCode) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        Base.property = TestUtilities.loadConfigProperties();
        if (platformName != null && property.getProperty("platformName").equalsIgnoreCase("api")) {
            Base.property.setProperty("environment", env);
        } else {
            Base.property.setProperty("environment", "dev");
            Base.property.setProperty("countryCode", "IN");
        }
        Constants.setAPI_URI(Base.property.getProperty("env"));
    }
//    @({"DriverStateTesting"})
//    @BeforeMethod
//    public void beforeMethod(@Optional() String count1){
//        if(count1==null){
//            countofTC=2;
//        }
//        else
//            countofTC=Integer.parseInt(count1);
//    }
//
//
//    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
//    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
//        for(int i =0 ; i<countofTC-1;i++){
//            try {
//                runScenarioAgain(pickleWrapper,featureWrapper);
//            }catch (Exception e){
//
//            }
//        }
//        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
//    }
//
//    public void runScenarioAgain(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
//        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
//    }
//    @AfterMethod
//    public void afterMethod(ITestResult result){
//
//    }
//
//    @DataProvider(name = "scenarios")
//    public Object[][] scenarios() {
//        return testNGCucumberRunner.provideScenarios();
//    }
//
    //    @AfterClass(alwaysRun = true)
    //    public void tearDownClass() {
    //        testNGCucumberRunner.finish();
    //    }
}

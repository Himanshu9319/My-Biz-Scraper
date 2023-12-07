package utilities;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners extends Base implements ITestListener {
    static int count_passedTCs;
    static int count_skippedTCs;
    static int count_failedTCs;
    static int count_totalTCs;

    public void onTestStart(ITestResult result) {
        testLevelReport.get().log(Status.INFO, result.getMethod().getMethodName().toUpperCase() + " Execution Started");
    }


    public void onTestSuccess(ITestResult result) {
//        testLevelReport.get().log(Status.INFO, result.getMethod().getMethodName().toUpperCase() + " " + result.getMethod().getDescription() + " Execution Ended");
        testLevelReport.get().log(Status.INFO, result.getMethod().getDescription() + " Execution Ended");
        testLevelReport.get().log(Status.PASS, "PASSED");


//        Reporter.log(getTestRunId().toUpperCase() + " : Passed");
    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
//        Reporter.log(getTestRunId().toUpperCase() + " : Failed");
        String exceptionMessage = result.getThrowable().getClass().toString();
        testLevelReport.get().debug(exceptionMessage);
        testLevelReport.get().error(result.getThrowable().getStackTrace().toString());
//        testLevelReport.get().log(Status.INFO, result.getMethod().getMethodName().toUpperCase() + " " + result.getMethod().getDescription() + " Execution Ended");
        testLevelReport.get().log(Status.INFO, result.getMethod().getDescription() + " Execution Ended");
        testLevelReport.get().log(Status.FAIL, "FAILED");


    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

//        testLevelReport.get().debug(result.getMethod().getMethodName().toUpperCase() + " " + result.getMethod().getDescription() + " isSkipped");
        testLevelReport.get().debug(result.getMethod().getDescription() + " isSkipped");
        testLevelReport.get().log(Status.SKIP, "SKIPPED");

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        count_failedTCs = context.getFailedTests().size();
        count_passedTCs = context.getPassedTests().size();
        count_skippedTCs = context.getSkippedTests().size();
        //count_totalTCs = context.getAllTestMethods();
       // testLevelReport.get().log(Status.valueOf(), context.getName() + " Execution Finish");
       // Email.sendEmail(0, count_passedTCs, count_failedTCs, count_skippedTCs);
    }


}
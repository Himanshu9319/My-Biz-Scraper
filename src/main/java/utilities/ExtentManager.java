package utilities;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

import java.util.Date;

public class ExtentManager {

    private static final String filePath = Constants.EXTENTREPORT_PATH + "extentReport.html";
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;

    public static ExtentReports getExtent() {
        Date d = new Date();
        if (extent != null) {
            return extent;
        } else {
            extent = new ExtentReports();
            extent.attachReporter(getHtmlReporter());
            extent.setSystemInfo("Owner", "Himanshu Shukla(himanshu.shukla1@fabhotels.com)");
            extent.setSystemInfo("Environment", Base.property.getProperty("environment").toUpperCase());
            extent.setSystemInfo("Platform", Base.property.getProperty("platform").toUpperCase());
            extent.setSystemInfo("Run_Date", d.toString());
            extent.setSystemInfo("Organisation", "Travel Plus");
            extent.setAnalysisStrategy(AnalysisStrategy.TEST);
            return extent;
        }
    }


    public static ExtentHtmlReporter getHtmlReporter() {
        htmlReporter = new ExtentHtmlReporter(filePath);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Travel plus automation suite");
        htmlReporter.config().setReportName("Travel plus Automation Automation Test Case Execution Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.setAppendExisting(false);
        return htmlReporter;
    }

}
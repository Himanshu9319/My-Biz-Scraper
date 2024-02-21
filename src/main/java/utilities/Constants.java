package utilities;

import java.util.Properties;

//import static utilities.DBConnection.useMySQL_Database;

public class Constants {
    public static final String FAB_HOTELS_UAT = "https://uat.fabmailers.in";
    public static final String FAB_HOTELS_TENANT = "https://tenant.fabmailers.in";
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String NULL_VALUE = null;
    public static final String WEB_DRIVER_CHROMEDRIVER = System.getProperty("user.dir") + "/src/test/resources/webDrivers/chromedriver";
    public static final String CONFIGURATION_PROPERTIES = System.getProperty("user.dir") + "/src/test/resources/configurations.properties";
    public static final String CONFIGURATION_ADD_PROPERTIES = System.getProperty("user.dir") + "/src/test/resources/configurations/";
    public static final String DB_PROPERTIES = System.getProperty("user.dir") + "/src/test/resources/configurations/db/";
    public static final String EXTENTREPORT_PATH = "./testResults/extentReports/";
    public static final String ARCHIVED_EXTENTREPORT_PATH = "./testResults/extentreportsArchived/";
    public static final String SCREENSHOT_PATH = "./testResults/extentReports/screenshots/";
    public static final String ARCHIVED_SCREENSHOT_PATH = "./testResults/screenshotArchived/";
    public static final String WINDOWS_WEB_DRIVER_CHROMEDRIVER = System.getProperty("user.dir") + "/src/test/resources/windows/chromedriver.exe";
    public static final String FLIGHT_BOOKING_API_EXPECTED_SCHEMA_PATH = "/src/main/java/UtilsAPI/TravelPlus/validator/";

    public static final String B2C_SCHEMA = "/src/main/java/UtilsAPI/B2C/validator/";

    public static final String TRIP_CREATE_API_EXPECTED_SCHEMA_PATH="/src/main/java/UtilsAPI/trip/validator/";
    public static final String DRIVER_API_EXPECTED_SCHEMA_PATH = "/src/main/java/UtilsAPI/driver/Validator/";
    public static final String RIDER_API_EXPECTED_SCHEMA_PATH = "/src/main/java/UtilsAPI/rider/Validator/";
    public static final String HUB_API_EXPECTED_SCHEMA_PATH = USER_DIR + "/src/main/java/UtilsAPI/hub/validator/";
    public static String API_URI;

    public static final String Project_Name = "My Biz Hotel data";

    public static void setAPI_URI(String env) {
        Properties properties = TestUtilities.addConfigProperties(env);
        Constants.API_URI = "https://" + properties.getProperty("env") + "." + Base.property.getProperty("domain");
    }
}

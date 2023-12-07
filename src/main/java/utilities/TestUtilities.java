package utilities;

import com.google.gson.Gson;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestUtilities extends Base {
    ApiUtils apiUtils = new ApiUtils();
    static Properties prop = new Properties();
    public static String env;
    public static String elementPath;
    public static HashMap<String, HashMap<String, HashMap<String, String>>> locators = new HashMap<String, HashMap<String, HashMap<String, String>>>();
    public static DesiredCapabilities capabilities = new DesiredCapabilities();
    static Logger log = LoggerFactory.getLogger(TestUtilities.class);
    private static AppiumDriverLocalService service;

    public static void preparation() throws Exception {
        env = property.getProperty("env");
        if (env == null) {
            env = "AWS";
        }
        if (property.getProperty("platformName").equalsIgnoreCase("IOS")) {
            capabilities.setCapability("platformName", property.getProperty("platformName"));
            capabilities.setCapability("platformVersion", property.getProperty("platformVersion"));
            capabilities.setCapability("bundleId", property.getProperty("bundleId"));
            capabilities.setCapability("deviceName", property.getProperty("deviceName"));
            capabilities.setCapability("automationName", property.getProperty("automationName"));
            capabilities.setCapability("udid", property.getProperty("udid"));
            capabilities.setCapability("app", System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Data/app" + property.getProperty("app"));
            capabilities.setCapability("xcodeOrgId", property.getProperty("xcodeOrgId"));
            capabilities.setCapability("xcodeSigningId", property.getProperty("xcodeSigningId"));
        } else if (property.getProperty("platformName").equalsIgnoreCase("Android")) {
            System.out.println("-------------In android capabilities-----------------");
            capabilities.setCapability("platformName", property.getProperty("platformName"));
            capabilities.setCapability("appPackage", property.getProperty("appPackage"));
            capabilities.setCapability("appActivity", property.getProperty("appActivity"));
            capabilities.setCapability("settings", property.getProperty("WAIT_FOR_IDLE_TIMEOUT"));
            capabilities.setCapability("app", System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Data/app" + File.separator + property.getProperty("androidapp"));
            capabilities.setCapability("automationName", property.getProperty("automationNameAndroid"));
            capabilities.setCapability("unicodeKeyboard", "true");
            capabilities.setCapability("resetKeyboard", "true");
            capabilities.setCapability("newCommandTimeout", 1000);

        }
        capabilities.setCapability("noReset", property.getProperty("noReset"));
        capabilities.setCapability("autoGrantPermissions", property.getProperty("autoGrantPermissions"));
        setLocator(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "mobile" + File.separator + property.getProperty("type") + File.separator + "configs", property.getProperty("platformName").toLowerCase() + "locators.xml");
       //  startServer(capabilities);
        driver = DriverManager.setDriver(env, property.getProperty("platformName"), capabilities);


    }

    public static void startServer(Capabilities cap) {
//        AppiumServiceBuilder builder = new AppiumServiceBuilder();
////        builder.usingPort(Integer.parseInt(property.getProperty("port")));
//        builder.withIPAddress("127.0.0.1");
//        builder.usingPort(Integer.parseInt(property.getProperty("port")));
//        builder.withCapabilities(cap);
//        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
//        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
//        service = AppiumDriverLocalService.buildService(builder);
//        service.start();
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        System.out.println("Appium Service Address: " + service.getUrl().toString());
    }

    public static void stopServer() {
        if (service.isRunning()) {
            System.out.println("Server is getting closed : " + service.getUrl());
            service.stop();
            System.out.println("Server is  closed.");
        }
    }

    public static Properties loadConfigProperties() {
        try {
            FileInputStream fis = new FileInputStream(
                    new File(Constants.CONFIGURATION_PROPERTIES));
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static Properties addConfigProperties(String env) {
        try {
            FileInputStream fis = new FileInputStream(
                    new File(Constants.CONFIGURATION_ADD_PROPERTIES + env + ".properties"));
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static Properties addConfigProperties(String countryCode, String database, String env) {
        try {
            FileInputStream fis = new FileInputStream(
                    new File(Constants.DB_PROPERTIES + countryCode.toLowerCase() + database.toLowerCase() + env.toLowerCase() + ".properties"));
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static int getRandomInteger() {
        Random rand = new Random();
        return rand.nextInt(100000000);
    }

    public static void archiveExtentReports() {
        Date d = new Date();
        String reportName = "ExtenReport_" + d.toString().replaceAll("[ :]", "_") + ".html";
        String absoluteExtentReportPath = Constants.EXTENTREPORT_PATH + "extentReport.html";

        try {
            File scrFile = new File(absoluteExtentReportPath);
            FileUtils.copyFile(scrFile, new File(Constants.ARCHIVED_EXTENTREPORT_PATH + reportName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void sync(Long sTime) {
        try {
            Thread.sleep(sTime);
        } catch (InterruptedException e) {
            log.info("Threw a Exception in BaseUtil::sync, full stack trace follows:", e);
        }
    }

    public static void setLocator(String dir, String xmlFileName) throws Exception {
        if (new File(dir + "/" + xmlFileName).exists()) {
            if (locators.size() == 0)
                locators = new ReadLocatorsXmlFile().getObjectRepository(dir, xmlFileName);
            else
                locators.putAll(new ReadLocatorsXmlFile().getObjectRepository(dir, xmlFileName));
        }
    }

    public static HashMap<String, HashMap<String, HashMap<String, String>>> getLocators() {
        return locators;
    }

    public static String runCommandUsingTerminal(boolean devicefarm, String command, boolean printToConsole, String... params) throws Exception {
        assert params.length <= 3;
        String strCommand = command;
        long timeout = Long.valueOf(params.length > 2 ? params[2] : String.valueOf(1 * 60 * 1000));
        String finalvalue = params.length > 1 ? params[1] : "NOT NULL";
        int counter = Integer.valueOf(params.length > 0 ? params[0] : !property.getProperty("noOfRetriesForADBLogs").trim().equalsIgnoreCase("") ? property.getProperty("noOfRetriesForADBLogs").trim() : "5");
        String output = "";
        command = removeUnwantedCharacters(command);
        if (devicefarm && command.trim().toLowerCase().startsWith("adb")) {
            String[] args = command.trim().split(" ");
            if (command.trim().toLowerCase().startsWith("adb -s")) {
                String _id = args[2].trim();
                String _command;
                _command = command.trim().substring(command.trim().indexOf(_id) + _id.length()).trim();
//                output = runADBCommandInDevicefarm(_id, _command.trim(), counter, finalvalue, timeout);
            } else {
                String adb = args[0].trim();
                String _command;
                _command = command.trim().substring(command.trim().indexOf(adb) + adb.length()).trim();
//                output = runADBCommandInDevicefarm("default", _command.trim(), counter, finalvalue, timeout);
            }
        } else {
            switch (finalvalue.trim().toUpperCase()) {
                case "NOT NULL":
                    do {
                        Object[] obj = runtimeCommand(strCommand, counter, printToConsole, true, timeout);
                        output = (String) obj[0];
                        counter = (int) obj[1];
                        int exitValue = (int) obj[2];
                        if (exitValue != 0)
                            break;
                    } while (output.trim().equalsIgnoreCase("") && counter > 0);
                    break;
                case "WAIT":
                    do {
                        Object[] obj = runtimeCommand(strCommand, counter, printToConsole, true, timeout);
                        output = (String) obj[0];
                        counter = (int) obj[1];
                        int exitValue = (int) obj[2];
                        if (exitValue != 0)
                            break;
                    } while (counter > 0);
                    break;
                default:
                    do {
                        Object[] obj = runtimeCommand(strCommand, counter, printToConsole, true, timeout);
                        output = (String) obj[0];
                        counter = (int) obj[1];
                        int exitValue = (int) obj[2];
                        if (exitValue != 0)
                            break;
                    } while (!output.trim().contains(finalvalue.trim()) && counter > 0);
            }
        }
        return output;
    }

    private static String removeUnwantedCharacters(String text) {
        String[] str = text.trim().split(" ");
        String output = "";
        for (int i = 0; i < str.length; i++) {
            if (!str[i].trim().isEmpty())
                output += str[i].trim() + " ";
        }
        return output.trim();
    }

    public static Object[] runtimeCommand(String strCommand, int counter, boolean printToConsole, boolean waitFor, long... timeout) {
        assert timeout.length <= 1;
        long waitTime = timeout.length > 0 ? timeout[0] : (1 * 60 * 1000);

        String output = "";
        int exitValue = -1;
        try {
            CommandLine command = new CommandLine(OSValidator.shellType);
            if (OSValidator.shellType.trim().equalsIgnoreCase("cmd"))
                command.addArgument("/c", false);
            else {
                command.addArgument("-l", false);
                command.addArgument("-c", false);
            }
            command.addArgument(strCommand, false);

            ByteArrayOutputStream stdout = new ByteArrayOutputStream();
            PumpStreamHandler psh = new PumpStreamHandler(stdout);
            DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
            DefaultExecutor executor = new DefaultExecutor();
            executor.setStreamHandler(psh);
            try {
                executor.execute(command, resultHandler);
                if (waitFor)
                    resultHandler.waitFor(waitTime);
                exitValue = resultHandler.getExitValue();
                if (printToConsole)
                    System.out.println(stdout);
                output = stdout.toString();
            } catch (IOException | InterruptedException e1) {
                log.info("Threw a Exception in BaseUtil::runtimeCommand, full stack trace follows:", e1);
            }
        } catch (Exception ex) {
            //Do Nothing
        } finally {
            counter--;
            sync(1000L);
        }

        return new Object[]{output, counter, exitValue};
    }

    public String getNetworkLogs(String browser, String udid, String port) throws Exception {
        Object[] obj = apiUtils.get(System.getProperty("Address") + "/api/v1/proxy/" + browser.trim().toUpperCase() + "/" + udid.trim() + "/" + port.trim(), new String[]{"content-type"}, new String[]{"application/json"}, true);
        InputStream is = (InputStream) obj[0];
        int responseCode = (int) obj[1];
        if (responseCode == 200 || responseCode == 201) {
            return apiUtils.readAll(is);
        }
        return null;
    }

    public BufferedReader getFilteredNetworkLogs() {
        BufferedReader reader = null;
        try {
            reader = readNetworkLogs();
        } catch (Exception e) {
            //Do Nothing
        }
        return reader;
    }

    public BufferedReader readNetworkLogs() throws Exception {
        Object[] obj = apiUtils.get(property.getProperty("Address") + "/api/v1/location/save/list", new String[]{"content-type"}, new String[]{"application/json"}, false);
        InputStream is = (InputStream) obj[0];
        int responseCode = (int) obj[1];
        if (responseCode == 200 || responseCode == 201) {
            return new BufferedReader(new InputStreamReader(is, "UTF-8"));
        }
        return null;
    }

}

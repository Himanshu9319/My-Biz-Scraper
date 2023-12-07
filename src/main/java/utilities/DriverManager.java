package utilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverManager extends Base {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static Map<String, Method> methods = new HashMap<String, Method>();
    private static AppiumDriverLocalService service;

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver dvr) {
        driver.set(dvr);
    }

    public static WebDriver getDriverInstance(String browser, int timePageLoad, int timeImplicitWait) {

        if (driver.get() == null) {
            if (browser.equalsIgnoreCase("CHROME")) {
                if (property.getProperty("local").equalsIgnoreCase("true")) {
                    System.out.println("Running on Local with Mac ChromeDriver");
                    WebDriverManager.chromedriver().setup();
                    //  System.setProperty("webdriver.chrome.driver", Constants.WEB_DRIVER_CHROMEDRIVER);
                } else {
                    System.out.println("Running on Windows ChromeDriver");
                    WebDriverManager.chromedriver().setup();
//                    System.setProperty("webdriver.chrome.driver", Constants.WINDOWS_WEB_DRIVER_CHROMEDRIVER);
                }
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                if (property.getProperty("headless").equalsIgnoreCase("true")) {
                    options.addArguments("--headless");
                }
                //options.addArguments("--no-sandbox");
                // setDriver(new ChromeDriver(options));
                setDriver(new ChromeDriver());
            } else {
                System.out.println("Please Select a valid browser");
            }
        }

        setDriver(driver.get());
        setPageLoadTimeOut(timePageLoad);
        setImplicitWait(timeImplicitWait);
        return getDriver();
    }

    public static WebDriver getGridDriverInstance(String browser, int timePageLoad, int timeImplicitWait) throws MalformedURLException {
        if (driver.get() == null) {
            if (browser.equalsIgnoreCase("CHROME")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                WebDriver drv;

                System.setProperty("webdriver.chrome.driver", Constants.WEB_DRIVER_CHROMEDRIVER);
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setBrowserName("chrome");
                dc.setPlatform(Platform.MAC);
                drv = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
                setDriver(drv);
            } else {
                System.out.println("Please Select a valid browser");
            }
        }
        setDriver(driver.get());
        setPageLoadTimeOut(timePageLoad);
        setImplicitWait(timeImplicitWait);
        return getDriver();
    }

    public static WebDriver setDriver(String env, String platformName, Capabilities capabilities) throws Exception {
        if (driver.get() == null) {
            WebDriver drv;
            if (env.equalsIgnoreCase("LOCAL")) {
                if (platformName.equalsIgnoreCase("Android")) {
                    System.out.println(property.getProperty("port"));
                    drv = new AndroidDriver(new URL("http://127.0.0.1" + ":" + Integer.parseInt(property.getProperty("port")) + "/"), capabilities);
                    drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    //                 drv.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, Duration.ofSeconds(5));
                    DriverManager.setDriver(drv);
                } else if (platformName.equalsIgnoreCase("iOS")) {
                    drv = new IOSDriver(new URL("http://127.0.0.1" + ":" + Integer.parseInt(property.getProperty("port")) + "/wd/hub"), capabilities);
                    drv.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    DriverManager.setDriver(drv);
                }
            } else if (env.equalsIgnoreCase("AWS")) {
                if (platformName.equalsIgnoreCase("Android")) {
                    drv = new AndroidDriver(new URL(service.getUrl().toString()), capabilities);
                    drv.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    DriverManager.setDriver(drv);
                } else if (platformName.equalsIgnoreCase("iOS")) {
                    drv = new IOSDriver(new URL(service.getUrl().toString()), capabilities);
                    drv.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    DriverManager.setDriver(drv);
                }
            }
        }
        setDriver(driver.get());
        return getDriver();
    }

    public static void killDriverInstance() {
        if (driver.get() != null) {
//            driver.get().close();
            driver.get().quit();
            driver.set(null);
        }
    }

    public static void setImplicitWait(int time) {
        driver.get().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void setPageLoadTimeOut(int time) {
        driver.get().manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public static Method getByMethod(String locator) {
        Method retMethod = null;
        try {
            if (methods.containsKey(locator)) {
                retMethod = methods.get(locator);
            } else if (methods.containsKey(locator.toLowerCase())) {
                retMethod = methods.get(locator);
            } else {
                throw new Exception("Given locator: " + locator + " is not available in Selenium or Appium methods");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return retMethod;
    }

    private static void storeAllAvailableLocatorMethods() {
        try {
            Method[] mobByMeths = (MobileBy.class).getMethods();
            List<Method> methList = new ArrayList<Method>();
            for (Method meth : mobByMeths)
                methList.add(meth);
            for (Method byMeth : methList) {
                String methName = byMeth.toString();
                methName = methName.split("[(]")[0];
                int len = methName.split("[.]").length;
                methName = methName.split("[.]")[len - 1];
                methods.put(methName, byMeth);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public static WebDriver getMobileViewDrivverInstance(String browser, int timePageLoad, int timeImplicitWait) {
        if (driver.get() == null) {
            if (browser.equalsIgnoreCase("CHROME")) {
                if (property.getProperty("local").equalsIgnoreCase("true")) {
                    System.out.println("Running on Local with Mac ChromeDriver");
                    WebDriverManager.chromedriver().setup();
                    //  System.setProperty("webdriver.chrome.driver", Constants.WEB_DRIVER_CHROMEDRIVER);
                }
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*"); // Allow remote origins
                if (property.getProperty("ismobileview").equalsIgnoreCase("yes")) {
                    options.addArguments("--window-size=390,844"); // Set the window size to simulate a mobile device
                    options.addArguments("--disable-extensions"); // Disable extensions
                    // Specify the device name or user agent for emulation
                    options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 8.0.0; SM-G955U Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Mobile Safari/537.36");

                } else {
                    System.out.println("Running on Windows ChromeDriver");
                    WebDriverManager.chromedriver().setup();
//                    System.setProperty("webdriver.chrome.driver", Constants.WINDOWS_WEB_DRIVER_CHROMEDRIVER);
                }

                if (property.getProperty("headless").equalsIgnoreCase("true")) {
                    options.addArguments("--headless");
                }
                //options.addArguments("--no-sandbox");
                setDriver(new ChromeDriver(options));
                //setDriver(new ChromeDriver());
            } else {
                System.out.println("Please Select a valid browser");
            }
        }
        setDriver(driver.get());
        setPageLoadTimeOut(timePageLoad);
        setImplicitWait(timeImplicitWait);
        return getDriver();
    }
}


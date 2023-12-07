package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static org.apache.commons.io.FileUtils.readFileToByteArray;
import static org.apache.commons.io.FileUtils.waitFor;
import static utilities.Base.driver;
import static utilities.Base.property;
import static utilities.DriverManager.getDriver;

public class CommonFunctionsMobile extends FindLocators {
    private AppiumDriver appium;
    public static IOSDriver iosDriver;
    public static AndroidDriver androidDriver;
    public static String text;
    static Logger log = LoggerFactory.getLogger(CommonFunctionsMobile.class);
    private static long DEFAULT_FIND_ELEMENT_TIMEOUT;
    private static HashMap<String, HashMap<String, HashMap<String, String>>> locators = new HashMap<String, HashMap<String, HashMap<String, String>>>();
    private static Scenario scenario;

    public static void clickbyId(String path) throws Exception {
        String value = "";
        String locatorBy = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        HashMap<String, String> map = (HashMap) ((HashMap) TestUtilities.getLocators().get(page)).get(elementPath);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        locatorBy = entry.getKey();
        value = entry.getValue();
        sleep(3);
        driver.findElement(By.id(value)).click();
    }

    public static void clickbyXpath(String path) throws Exception {
        String value = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        HashMap<String, String> map = (HashMap) ((HashMap) TestUtilities.getLocators().get(page)).get(elementPath);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        value = entry.getValue();
        sleep(3);
        driver.findElement(By.xpath(value)).click();
    }

    public static void clickbyCoordinates(int x, int y) {
        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        action.tap(PointOption.point(x, y)).release().perform();
    }

    public static void sendKeysByid(String path, String Str) {
        String value = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        HashMap<String, String> map = (HashMap) ((HashMap) TestUtilities.getLocators().get(page)).get(elementPath);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        value = entry.getValue();
        sleep(3);
        driver.findElement(By.id(value)).clear();
        driver.findElement(By.id(value)).sendKeys(Str);
    }

    public static void sendKeysByXpath(String path, String string) {
        String value = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        HashMap<String, String> map = (HashMap) ((HashMap) TestUtilities.getLocators().get(page)).get(elementPath);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        value = entry.getValue();
        sleep(3);
        driver.findElement(By.xpath(value)).clear();
        driver.findElement(By.xpath(value)).sendKeys(string);

    }

    public static void SeceltByIdWithIndex(String path, int indexNo) {
        String value = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        HashMap<String, String> map = (HashMap) ((HashMap) TestUtilities.getLocators().get(page)).get(elementPath);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        value = entry.getValue();
        List<WebElement> suggetions = driver.findElements(By.id(value));
        suggetions.get(indexNo).click();
    }

    public static void getTextByid(String path) {
        String value = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        HashMap<String, String> map = (HashMap) ((HashMap) TestUtilities.getLocators().get(page)).get(elementPath);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        value = entry.getValue();
        text = driver.findElement(By.id(value)).getText();
    }

    public static void clickbyName(String path) throws Exception {
        String value = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        HashMap<String, String> map = (HashMap) ((HashMap) TestUtilities.getLocators().get(page)).get(elementPath);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        value = entry.getValue();
        sleep(3);
        driver.findElement(By.name(value)).click();
    }

    public static void sendKeysID(String path, String val) throws Exception {
        String value = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        HashMap<String, String> map = (HashMap) ((HashMap) TestUtilities.getLocators().get(page)).get(elementPath);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        value = entry.getValue();
        sleep(3);
        driver.findElement(By.id(value)).sendKeys(val);
    }

    public static void sendKeysXpath(String path, String val) throws Exception {
        String value = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        HashMap<String, String> map = (HashMap) ((HashMap) TestUtilities.getLocators().get(page)).get(elementPath);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        value = entry.getValue();
        sleep(3);
        driver.findElement(By.xpath(value)).sendKeys(val);
    }

    public static void sleep(int sTime) {
        try {
            Thread.sleep(sTime * 1000);
        } catch (InterruptedException e) {
            log.info("Threw a Exception in BaseUtil::sync, full stack trace follows:", e);
        }
    }

    public static void sleep(int sTime, WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(sTime))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static void launchApp() {
        try {
            if (property.getProperty("platformName").equalsIgnoreCase("Android")) {
                androidDriver = (AndroidDriver) driver;
                //androidDriver.launchApp();
                androidDriver.activateApp("com.travelplus.guests.debug");

            } else if (property.getProperty("platformName").equalsIgnoreCase("IOS")) {
                String bundleID = Base.property.getProperty("bundleId").trim();
                HashMap<String, Object> iOSSettingsAppArgs = new HashMap<>();
                iOSSettingsAppArgs.put("bundleId", bundleID);
                iosDriver = (IOSDriver) driver;
                iosDriver.executeScript("mobile: launchApp", iOSSettingsAppArgs);
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Unable to launch app : " + e);
        }
    }

    public static void terminateApp() {
        if (property.getProperty("platformName").equalsIgnoreCase("Android")) {
            androidDriver = (AndroidDriver) driver;
            androidDriver.closeApp();
        } else if (property.getProperty("platformName").equalsIgnoreCase("IOS")) {
            String bundleID = Base.property.getProperty("bundleId").trim();
            HashMap<String, Object> iOSSettingsAppArgs = new HashMap<>();
            iOSSettingsAppArgs.put("bundleId", bundleID);
            iosDriver = (IOSDriver) driver;
            iosDriver.executeScript("mobile: terminateApp", iOSSettingsAppArgs);
        }
    }



    public void resetAPP() {
        androidDriver.resetApp();
    }

    public static void allowPermissions(boolean allowOrDeny) throws Exception {
        if (property.getProperty("autoGrantPermissions").trim().equalsIgnoreCase("true") && allowOrDeny) {
            String elementPath = "Login/Permission";
            if (property.getProperty("platformName").equalsIgnoreCase("android")) {
                if (isElementDisplayed(By.xpath("//android.widget.ScrollView/android.view.View/android.widget.TextView[@text=\"Always send unknown apps\"]"))) {
                    click(elementPath, "Always send unknown apps");
                }
            }
            if (property.getProperty("platformName").equalsIgnoreCase("ios")) {
                if (isElementDisplayed(By.xpath("//XCUIElementTypeButton[contains(@name,\"Allow\")]"))) {
                    click(elementPath, "Allow");
                    click(elementPath, "Allow While Using App");
                    click(elementPath, "Allow");
                }
            }
        }
    }

    public static void allowPermissionsdriver(boolean allowOrDeny) throws Exception {
        if (property.getProperty("autoGrantPermissions").trim().equalsIgnoreCase("true") && allowOrDeny) {
            String elementPath = "Login/Permission";
            if (property.getProperty("platformName").equalsIgnoreCase("android")) {
                if (isElementDisplayed(By.xpath("//android.widget.Button[contains(@text,\"Allow\")]"))) {
                    click(elementPath, "Allow");
                }
            }
            if (property.getProperty("platformName").equalsIgnoreCase("ios")) {
                if (isElementDisplayed(By.xpath("//XCUIElementTypeButton[contains(@name,\"Allow\")]"))) {
                    click(elementPath, "Allow While Using App");
                    click(elementPath, "OK");
                    click(elementPath, "Allow");
                }
            }
        }
    }

    public static void allowPermissionsdriver(boolean allowOrDeny, String params) throws Exception {
        if (property.getProperty("autoGrantPermissions").trim().equalsIgnoreCase("true") && allowOrDeny) {
            String elementPath = "Login/Permission";
            if (property.getProperty("platformName").equalsIgnoreCase("android")) {
                if (isElementDisplayed(By.xpath("//android.widget.Button[contains(@text,\"" + params + "\")]"))) {
                    click(elementPath, params);
                }
            }
            if (property.getProperty("platformName").equalsIgnoreCase("ios")) {
            }
        }
    }

    public void setEnv() {
        try {
            if (property.getProperty("platformName").equalsIgnoreCase("IOS")) {
                if (isElementDisplayed(By.xpath("//XCUIElementTypeButton[@name=\"card-primary-action-button\"]"))) {
                    driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"card-primary-action-button\"]")).click();
                }
                if (isElementDisplayed(By.xpath("//XCUIElementTypeButton[@name=\"crossgrey\"]"))) {
                    driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"crossgrey\"]")).click();
                }
            }
            if (property.getProperty("platformName").equalsIgnoreCase("Android")) {
                Base.property = TestUtilities.loadConfigProperties();
                String envprodradiobutton = "(//android.widget.TextView[@text='Enter token environment']/..//android.view.ViewGroup[2])[1]";
                String envDevelopmentButton = "(//android.widget.TextView[@text=\"Development\"])[1]";
                String rozerpayprodradiobutton = "(//android.widget.TextView[@text=\"Production\"])[2]";
                String devenvradiobutton = "(//android.widget.TextView[@text=\"Development\"])[1])";
                String rozerpaydevelopmentradiobutton = "(//android.widget.TextView[@text=\"Development\"])[1])";
                String envurlinputField = "(//android.widget.EditText)[2]";
                String saveButton = "//android.widget.TextView[@text='Save']/..";
                String okbutton = "//android.widget.Button";
                String circleButton = "(//android.view.ViewGroup)[27]";
                String Developeroptions = "(//android.widget.TextView[@text='Developer Options']/../..//android.view.ViewGroup)[1]";
                driver.findElement(By.xpath(circleButton)).click();
                if (property.getProperty("applicationenvurl").equalsIgnoreCase(driver.findElement(By.xpath(envurlinputField)).getText())) {
                    driver.findElement(By.xpath(Developeroptions)).click();
                    // CommonFunctionsMobile.click(Developeroptions);
                } else if (isElementDisplayed(By.xpath(envurlinputField))) {
                    driver.findElement(By.xpath(envurlinputField)).clear();
                    driver.findElement(By.xpath(envurlinputField)).sendKeys("https://api.travelplusapp.com");
                    driver.findElement(By.xpath(envprodradiobutton)).click();
                    driver.findElement(By.xpath(rozerpayprodradiobutton)).click();
                    driver.findElement(By.xpath(saveButton)).click();
                    CommonFunctionsMobile.getElementWhenVisible(By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]"), 2000);
                    driver.findElement(By.xpath(okbutton)).click();

                }
            }

        } catch (Exception e) {
            System.out.println("Element not visible");
        }
    }

    public static void disableInternet() throws Exception {
        TestUtilities.runCommandUsingTerminal(Boolean.parseBoolean(property.getProperty("devicefarm")), "adb -s " + property.getProperty("udid") + " shell svc wifi disable", false, "1");
        TestUtilities.runCommandUsingTerminal(Boolean.parseBoolean(property.getProperty("devicefarm")), "adb -s " + property.getProperty("udid") + " shell svc data disable", false, "1");
        Reporter.log("disable internet");
    }

    public static boolean isElementDisplayed(By By) {
        Predicate<WebElement> predicate = p -> p.isDisplayed();
        try {
            if (predicate.test(driver.findElement(By))) {
                return true;
            }
        } catch (NoSuchElementException nsee) {
            return false;
        }
        return false;
    }

    public static boolean isElementDisplayedNew(By locator) {
        boolean isDisplayed;
        WebElement we = getElementWhenVisible(locator);
        if (we == null) {
            return false;
        }
        isDisplayed = we.isDisplayed();
        return isDisplayed;
    }

    public static boolean isElementDisplayed(String elementPath, String... params) throws Exception {
        boolean isDisplayed;
        WebElement we = getMobElement(elementPath, params);
        if (we == null) {
            return false;
        }
        isDisplayed = we.isDisplayed();
        return isDisplayed;
    }

    public static boolean isElementDisplayed(String path, int time, String... params) {
        Boolean flag = false;
        String value = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        HashMap<String, String> map = (HashMap) ((HashMap) TestUtilities.getLocators().get(page)).get(elementPath);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        value = entry.getValue();
        value = MessageFormat.format(value, (Object[]) params);
        value = value.trim();
        sleep(3);
        if (driver.findElement(By.xpath(value)) != null) {
            flag = true;
        }
        return flag;
    }

    public void selectSystempopup() {
        driver.switchTo().alert().accept();
    }

    public static String getAttribute(String elementPath, String attributeName, String... params) throws Exception {
        if (property.getProperty("platformName").equalsIgnoreCase("ANDROID") && attributeName.equalsIgnoreCase("value")) {
            attributeName = "text";
        }
        String value = "";
        WebElement we = getMobElement(elementPath, params);
        if (!we.getAttribute(attributeName).isEmpty()) {
            value = we.getAttribute(attributeName);
            log.info("For the Element the " + attributeName + " on" + elementPath);
        } else {
            log.info("For the Element the " + elementPath + " value is empty");
        }
        return value;
    }

    public static WebElement getMobElement(String path, String... params) throws Exception {
        WebElement we = null;
        String locatorBy = "";
        String value = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        Exception exception = null;
        HashMap<String, String> map = TestUtilities.getLocators().get(page).get(elementPath);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            locatorBy = entry.getKey();
            value = entry.getValue();
            if (!locatorBy.isEmpty() && !value.isEmpty()) {
                value = MessageFormat.format(value, (Object[]) params);
                value = value.trim();
                String driverType = property.getProperty("platformName");
                if (driverType.trim().toUpperCase().contains("ANDROID") && locatorBy.trim().equalsIgnoreCase("id")) {
                    value = property.getProperty("appPackage").trim() + ":id/" + value;
                }
                By by = (By) getByMethod(locatorBy).invoke(null, value);
                try {
                    we = getElementWhenVisible(by);
                } catch (Exception ex) {
                    exception = ex;
                    Reporter.log("MobileElement: " + path);
                }
                if (we != null) {
                    break;
                }
            }
        }
        if (we == null && exception != null) {
            throw exception;
        }
        System.out.println("----------------" + we);
        return we;
    }

    public static WebElement getMobElement(String path, int time, String... params) throws Exception {
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        String locatorBy = "";
        String value = "";
        HashMap<String, String> map = TestUtilities.getLocators().get(page).get(elementPath);
        WebElement we = null;
        Exception exception = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            locatorBy = entry.getKey();
            value = entry.getValue();
            if (!locatorBy.isEmpty() && !value.isEmpty()) {
                value = MessageFormat.format(value, (Object[]) params);
                value = value.trim();
                String driverType = property.getProperty("platformName");
                if (driverType.trim().toUpperCase().contains("ANDROID") && locatorBy.trim().equalsIgnoreCase("id")) {
                    value = property.getProperty("appPackage").trim() + ":id/" + value;
                }
                By by = (By) getByMethod(locatorBy).invoke(null, value);
                try {
                    we = getElementWhenVisible(by, time);
                } catch (Exception ex) {
                    exception = ex;
                    Reporter.log("MobileElement: " + path);
                }
                if (we != null) {
                    break;
                }
            }
        }
        if (we == null && exception != null) {
            throw exception;
        }
        return we;
    }

    public static void sendKeys(String elementPath, CharSequence... textToType) throws Exception {
        WebElement we = getMobElement(elementPath);
        we.clear();
        we.sendKeys(textToType);
    }

    public static WebElement getElementWhenVisible(By locater, long... waitSeconds) {
        assert waitSeconds.length <= 1;
        long seconds = waitSeconds.length > 0 ? waitSeconds[0] : DEFAULT_FIND_ELEMENT_TIMEOUT;
        WebElement element = null;
        long minTime = !property.getProperty("minimumTimeElementFound").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("minimumTimeElementFound").trim()) : 20;
        if (seconds <= minTime)
            minTime = (int) (seconds / 2);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        long implicitWait = Long.valueOf(property.getProperty("implicitWait")) / 1000;
        try {
            driver.manage().timeouts().implicitlyWait(minTime, TimeUnit.SECONDS);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
        } catch (Exception ex) {
            throw ex;
        } finally {
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        }
        return element;
    }

    public static void sync(Long sTime) {
        try {
            Thread.sleep(sTime);
        } catch (InterruptedException e) {
            log.info("Threw a Exception in BaseUtil::sync, full stack trace follows:", e);
        }
    }

    public static void click(String elementPath, String... params) throws Exception {
        int counter = !property.getProperty("noOfRetriesForSameOperation").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("noOfRetriesForSameOperation").trim()) : 1;
        while (counter > 0) {
            try {
                WebElement we = getMobElement(elementPath, params);
                if (we != null) {
                    javascriptClick(we, elementPath);
                    Reporter.log("Verify user is able to click on " + elementPath.toLowerCase());
                    break;
                }
            } catch (Exception ex) {
                if (counter == 1) {
                    Reporter.log("Verify user is able to click on " + elementPath.toLowerCase());
                    throw ex;
                }
                sync(1000L);
            }
            counter--;
        }
    }

    public static void click(String elementPath, int time, String... params) throws Exception {
        int counter = !property.getProperty("noOfRetriesForSameOperation").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("noOfRetriesForSameOperation").trim()) : 1;
        while (counter > 0) {
            try {
                WebElement we = getMobElement(elementPath, time, params);
                if (we != null) {
                    javascriptClick(we, elementPath);
                    Reporter.log("Verify user is able to click on " + elementPath.toLowerCase());
                    break;
                }
            } catch (Exception ex) {
                if (counter == 1) {
                    Reporter.log("Verify user is able to click on " + elementPath.toLowerCase());
                    throw ex;
                }
                sync(1000L);
            }
            counter--;
        }
    }

    public static boolean javascriptClick(WebElement webElement, String strObjName) {
        int counter = !property.getProperty("noOfRetriesForSameOperation").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("noOfRetriesForSameOperation").trim()) : 1;
        String driverType = property.getProperty("platformName");
        while (counter > 0) {
            try {
                if (driverType.trim().toUpperCase().contains("ANDROID") || driverType.trim().toUpperCase().contains("IOS")) {
                    webElement.click();
                } else {
                    try {
                        ((JavascriptExecutor) driver).executeScript("return arguments[0].click()", webElement);
                    } catch (WebDriverException we) {
                        webElement.click();
                    }
                }
                break;
            } catch (StaleElementReferenceException ex) {
                break;
            } catch (Exception e) {
                if (counter == 1) {
                    log.info("Threw a Exception in BaseUtil::javascriptClick, full stack trace follows:", e);
                    Reporter.log("Click: " + strObjName);
                    throw e;
                }
                sync(1000L);
            }
            counter--;
        }
        return true;
    }

    public static String getAllString(String... params) {
        String text = "";
        for (int i = 0; i < params.length; i++) {
            text = text + "," + params[i];
        }
        return text;
    }

    public static WebElement getElementWhenClickable(By locator, long... waitSeconds) {
        assert waitSeconds.length <= 1;
        long seconds = waitSeconds.length > 0 ? waitSeconds[0] : DEFAULT_FIND_ELEMENT_TIMEOUT;
        WebElement element = null;
        long minTime = !property.getProperty("minimumTimeElementFound").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("minimumTimeElementFound").trim()) : 20;
        if (seconds <= minTime)
            minTime = (int) (seconds / 2);
        long implicitWait = Long.valueOf(property.getProperty("implicitWait")) / 1000;
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        try {
            driver.manage().timeouts().implicitlyWait(minTime, TimeUnit.SECONDS);
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception ex) {
            throw ex;
        } finally {
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        }
        return element;
    }

    public static WebElement getElementWhenTextIsPresent(By locater, String text, long... waitSeconds) {
        assert waitSeconds.length <= 1;
        long seconds = waitSeconds.length > 0 ? waitSeconds[0] : DEFAULT_FIND_ELEMENT_TIMEOUT;
        WebElement element = null;
        long minTime = !property.getProperty("minimumTimeElementFound").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("minimumTimeElementFound").trim()) : 20;

        if (seconds <= minTime)
            minTime = (int) (seconds / 2);
        long implicitWait = Long.valueOf(property.getProperty("implicitWait")) / 1000;
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        try {
            driver.manage().timeouts().implicitlyWait(minTime, TimeUnit.SECONDS);
            boolean val = wait.until(ExpectedConditions.textToBePresentInElementLocated(locater, text));
            if (val) {
                element = driver.findElement(locater);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        }
        return element;
    }

    public static void selectByVisibleText(By locator, String objName, String selText) {
        WebElement we = getElementWhenVisible(locator);
        if (we == null)
            return;

        Select select = new Select(we);
        select.selectByVisibleText(selText);
        if (select.getFirstSelectedOption().getText().equals(selText))
            Reporter.log("Validate " + selText + " is selected from the list - " + objName.toLowerCase());
        else
            Reporter.log("Validate " + selText + " is selected from the list - " + objName.toLowerCase());
    }

    private WebElement getPermissionButton(String text) {
        return driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'permission_') and contains(@text,'" + text + "')] "));
    }

    public void bringBackForegroundAndroid(int sec) {
        androidDriver = (AndroidDriver) driver;
        androidDriver.runAppInBackground(Duration.ofSeconds(sec));
    }

    public void runMonkeyTest(int eventNumbers) throws Exception {
        String command = "adb -s " + property.getProperty("udid") + " shell monkey -p " + property.getProperty("appPackage") + " -v " + eventNumbers;
        TestUtilities.runCommandUsingTerminal(Boolean.parseBoolean(property.getProperty("devicefarm")), command, true, "1");
    }

    public void makeACall(String phoneNumber) throws Exception {
        String command = "adb -s " + property.getProperty("udid") + " shell am start -a android.intent.action.CALL -d tel:" + phoneNumber;
        TestUtilities.runCommandUsingTerminal(Boolean.parseBoolean(property.getProperty("devicefarm")), command, false, "1");
        Reporter.log("makeACall");
    }

    public void enableInternet() throws Exception {
        TestUtilities.runCommandUsingTerminal(Boolean.parseBoolean(property.getProperty("devicefarm")), "adb -s " + property.getProperty("udid") + " shell svc wifi enable", false, "1");
        TestUtilities.runCommandUsingTerminal(Boolean.parseBoolean(property.getProperty("devicefarm")), "adb -s " + property.getProperty("udid") + " shell svc data enable", false, "1");
        Reporter.log("enable internet");
    }

    @Deprecated
    public static void ResetApplication() {
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.resetApp();
    }

    public boolean verifyPresenceOfElement(WebElement we) {
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        int counter = !property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim()) : 1;
        long seconds = Long.valueOf(property.getProperty("implicitWait")) / 1000;
        while (counter > 0) {
            try {
                getElementWhenVisible(we, seconds);
                break;
            } catch (Exception ex) {
                if (counter == 1) {
                    Assert.assertTrue(false, method + ": Verify element is present");
                    return false;
                }
                sync(500L);
            }
            counter--;
        }
//    Assert.assertTrue(true, method + ": Verify element is present");
        return true;
    }

    public boolean verifyPresenceOfElement(String elementPath, int time, String... params) {
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        int counter = !property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim()) : 1;
        long seconds = Long.valueOf(property.getProperty("implicitWait")) / 1000;
        while (counter > 0) {
            try {
                WebElement we = getMobElement(elementPath, params);
                getElementWhenVisible(we, seconds);
                break;
            } catch (Exception ex) {
                if (counter == 1) {
                    Assert.assertTrue(false, method + ": Verify element is present");
                    return false;
                }
                sync(500L);
            }
            counter--;
        }
//    Assert.assertTrue(true, method + ": Verify element is present");
        return true;
    }

    public boolean verifyPresenceOfElementOpt(String elementPath, int time, String... params) {
        int counter = !property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim()) : 1;
        while (counter > 0) {
            try {
                getMobElement(elementPath, time, params);
                break;
            } catch (Exception ex) {
                if (counter == 1) {
                    return false;
                }
                sync(500L);
            }
            counter--;
        }
        return true;
    }

    public boolean verifyNonPresenceOfElement(String elementPath, int time, String... params) {
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        int counter = !property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim()) : 1;
        while (counter > 0) {
            try {
                getMobElementWithoutHandlePopups(elementPath, time, params);
                if (counter == 1) {
                    break;
                }
                sync(1000L);
            } catch (Exception ex) {
                Assert.assertTrue(true, method + " : " + elementPath + " - Verify element is not present");
                return true;
            }
            counter--;
        }
        Assert.assertTrue(false, method + " : " + elementPath + " - Verify element is not present");
        return false;
    }

    public WebElement getMobElementWithoutHandlePopups(String path, int time, String... params) throws Exception {
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        String locatorBy = "";
        String value = "";
        HashMap<String, String> map = TestUtilities.getLocators().get(page).get(elementPath);
        WebElement we = null;
        Exception exception = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            locatorBy = entry.getKey();
            value = entry.getValue();
            if (!locatorBy.isEmpty() && !value.isEmpty()) {
                value = MessageFormat.format(value, (Object[]) params);
                value = value.trim();
                String driverType = property.getProperty("platformName");
                if (driverType.trim().toUpperCase().contains("ANDROID") && locatorBy.trim().equalsIgnoreCase("id")) {
                    value = property.getProperty("appPackage").trim() + ":id/" + value;
                }
                By by = (By) getByMethod(locatorBy).invoke(null, value);
                try {
                    we = (WebElement) getElementWhenVisibleWithoutHandlePopups(by, time);
                } catch (Exception ex) {
                    exception = ex;
                    Reporter.log("MobileElement: " + path);
                }
                if (we != null) {
                    break;
                }
            }
        }
        if (we == null && exception != null) {
            throw exception;
        }
        return we;
    }

    public WebElement getElementWhenVisibleWithoutHandlePopups(By locater, long... waitSeconds) {
        assert waitSeconds.length <= 1;
        long seconds = waitSeconds.length > 0 ? waitSeconds[0] : DEFAULT_FIND_ELEMENT_TIMEOUT;
        WebElement element = null;
        long minTime = !property.getProperty("minimumTimeElementFound").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("minimumTimeElementFound").trim()) : 20;
        if (seconds <= minTime)
            minTime = (int) (seconds / 2);
        long implicitWait = Long.valueOf(property.getProperty("implicitWait")) / 1000;
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        try {
            driver.manage().timeouts().implicitlyWait(minTime, TimeUnit.SECONDS);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
        } catch (Exception ex) {
            throw ex;
        } finally {
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        }
        return element;
    }

    public String getAttribute(By locator, String attribute, long... waitSeconds) {
        WebElement we = getElementWhenVisible(locator, waitSeconds);
        if (we == null)
            return null;
        return we.getAttribute(attribute);
    }

    public String getAttribute(WebElement we, String attribute) {
        return we.getAttribute(attribute);
    }

    public WebElement getElementWhenVisible(WebElement we, long... waitSeconds) {
        assert waitSeconds.length <= 1;
        long seconds = waitSeconds.length > 0 ? waitSeconds[0] : DEFAULT_FIND_ELEMENT_TIMEOUT;
        long minTime = !property.getProperty("minimumTimeElementFound").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("minimumTimeElementFound").trim()) : 20;
        if (seconds <= minTime)
            minTime = (int) (seconds / 2);
        long implicitWait = Long.valueOf(property.getProperty("implicitWait")) / 1000;
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        try {
            driver.manage().timeouts().implicitlyWait(minTime, TimeUnit.SECONDS);
            we = wait.until(ExpectedConditions.visibilityOf(we));
        } catch (Exception ex) {
            throw ex;
        } finally {
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        }
        return we;
    }

    public boolean checkIfElementPresent(WebElement we, long... waitSeconds) {
        int counter = !property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim()) : 1;
        assert waitSeconds.length <= 1;
        long seconds = waitSeconds.length > 0 ? waitSeconds[0] : Long.valueOf(property.getProperty("implicitWait")) / 1000;
        while (counter > 0) {
            try {
                getElementWhenVisible(we, seconds);
                break;
            } catch (Exception ex) {
                if (counter == 1) {
                    return false;
                }
                sync(1000L);
            }
            counter--;
        }
        return true;
    }

    public boolean checkIfElementPresent(By locator, long... waitSeconds) {
        int counter = !property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim()) : 1;
        assert waitSeconds.length <= 1;
        long seconds = waitSeconds.length > 0 ? waitSeconds[0] : Long.valueOf(property.getProperty("implicitWait")) / 1000;
        while (counter > 0) {
            try {
                getElementWhenVisible(locator, seconds);
                break;
            } catch (Exception ex) {
                if (counter == 1) {
                    return false;
                }
                sync(1000L);
            }
            counter--;
        }
        return true;
    }

    public boolean clickWithOutWait(String elementPath, String... params) throws Exception {
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName() + " on";
        boolean flag = false;
        WebElement we = getMobElement(elementPath, params);
        try {
            for (int i = 0; i <= 2; i++) {
                if (we != null && verifyPresenceOfElement(we)) {
                    try {
                        we.click();
                        flag = true;
                        Reporter.log("Verify user is able to click on " + elementPath.toLowerCase());
                        break;
                    } catch (StaleElementReferenceException se) {
                        we = getMobElement(elementPath, params);
                        Actions ac = new Actions(driver);
                        ac.moveToElement(we).click().build().perform();
                        Reporter.log("Verify user is able to click on " + elementPath.toLowerCase());
                        log.error(method + elementPath + " " + getAllString(params) + "\n" + se);
                        break;
                    } catch (Exception e) {
                        log.error(method + "Exception: " + e + " for " + elementPath + " "
                                + getAllString(params));
                        throw new Exception(
                                "Exception occurred while clicking on: " + elementPath + " " + e);
                    }
                } else {
                    we = getMobElement(elementPath, 5, params);
                    if (i == 1) {
                        Reporter.log(method
                        );
                        throw new Exception("Element: " + elementPath + " isn't present");
                    }
                }
            }
        } catch (Exception e) {
            log.error("Unable to get the MobileElement of: " + elementPath + "\n" + e);
            Reporter.log(method);
            throw new Exception(e);
        }
        return flag;
    }

    public boolean swipeNTimesDown(int noOfTimes) {
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName() + " on";
        boolean flag = false;

        try {
            for (int i = 1; i <= noOfTimes; i++) {
                Dimension size = driver.manage().window().getSize();
                int startPointx = size.width / 2;
                int startPointy = size.height / 2;
                int endPointx = size.width / 2;
                int endPointy = getvPercentValue(size.height, 80);
                swipe(driver, startPointx, startPointy, endPointx, endPointy, Duration.ofMillis(2000));
            }
            flag = true;
        } catch (Exception e) {
            log.error("Exception occurred while scrolling on: " + e);
            Reporter.log(method);
        }
        return flag;
    }

    public void swipebyCoordinates(int startx, int starty, int endx, int endy, int count) {
        try {
            for (int i = 1; i <= count; i++) {
                swipe(driver, startx, starty, endx, endy, Duration.ofMillis(2000));
            }
        } catch (Exception e) {
            log.error("Exception occurred while scrolling on: " + e);
        }
    }

    public boolean swipeNTimesUP(int noOfTimes) {
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName() + " on";
        boolean flag = false;

        try {
            for (int i = 1; i <= noOfTimes; i++) {
                Dimension size = driver.manage().window().getSize();
                int startPointx = size.width / 2;
                int startPointy = getvPercentValue(size.height, 80);
                int endPointx = size.width / 2;
                int endPointy = size.height / 2;
                swipe(driver, startPointx, startPointy, endPointx, endPointy, Duration.ofMillis(2000));
            }
            flag = true;
        } catch (Exception e) {
            log.error("Exception occurred while scrolling on: " + e);
            Reporter.log(method);
        }
        return flag;
    }

    private int getvPercentValue(int value, int percent) {
        int finalvalue = (value * percent) / 100;
        return finalvalue;
    }

    public void swipe(WebDriver driver, int startx, int starty, int endx, int endy, Duration duration) {
        new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(duration)).moveTo(PointOption.point(endx, endy)).release().perform();
    }

    public List<WebElement> getMobElements(String path, String... parms) throws Exception {
        List<WebElement> we = new ArrayList<WebElement>();
        String locatorBy = "";
        String value = "";
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        Exception exception = null;
        HashMap<String, String> map = TestUtilities.getLocators().get(page).get(elementPath);
        long implicitWait = Long.valueOf(property.getProperty("implicitWait")) / 1000;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            locatorBy = entry.getKey();
            value = entry.getValue();
            if (!locatorBy.isEmpty() && !value.isEmpty()) {
                value = MessageFormat.format(value, (Object[]) parms);
                value = value.trim();
                String driverType = property.getProperty("platformName");
                if (driverType.trim().toUpperCase().contains("ANDROID") && locatorBy.trim().equalsIgnoreCase("id")) {
                    value = property.getProperty("appPackage").trim() + ":id/" + value;
                }
                By by = (By) getByMethod(locatorBy).invoke(null, value);
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                        .pollingEvery(Duration.ofMillis(500))
                        .ignoring(org.openqa.selenium.NoSuchElementException.class);
                try {
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    we = (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
                    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
                } catch (Exception ex) {
                    exception = ex;
                    Reporter.log("MobileElement: " + path);
                } finally {
                    driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
                }
                if (!we.isEmpty()) {
                    break;
                }
            }
        }
        if (we.isEmpty() && exception != null) {
            throw exception;
        }
        return we;
    }

    public void click(WebElement we, String objName) {
        javascriptClick(we, objName);
        Reporter.log("Verify user is able to click on " + objName.toLowerCase());
    }

    public void swipe(WebElement we, String SwipeDirection) {
        Dimension size = we.getSize();
        WebElement me = ((WebElement) we);
        AppiumDriver appium = (AppiumDriver) driver;
        String driverType = property.getProperty("platformName");
        if (driverType.trim().toUpperCase().contains("IOS")) {
            IOSDriver ios = (IOSDriver) appium;
            if (SwipeDirection.trim().equalsIgnoreCase("Up")) {
                swipe(ios, me.getRect().getX(), me.getLocation().getY() + size.height - 1, me.getRect().getX(), me.getLocation().getY() + 1, Duration.ofMillis(2000));
            } else if (SwipeDirection.equalsIgnoreCase("Down")) {
                swipe(ios, me.getRect().getX(), me.getLocation().getY() + 1, me.getRect().getX(), me.getLocation().getY() + size.height - 1, Duration.ofMillis(2000));
            } else if (SwipeDirection.equalsIgnoreCase("Right")) {
                swipe(ios, me.getLocation().getX() + 1, me.getRect().getY(), me.getLocation().getX() + size.width - 1, me.getRect().getY(), Duration.ofMillis(2000));
            } else if (SwipeDirection.equalsIgnoreCase("Left")) {
                swipe(ios, me.getLocation().getX() + size.width - 1, me.getRect().getY(), me.getLocation().getX() + 1, me.getRect().getY(), Duration.ofMillis(2000));
            } else {
                log.info("Not a valid direction passed");
            }
        } else {
            AndroidDriver android = (AndroidDriver) appium;
            if (SwipeDirection.trim().equalsIgnoreCase("Up")) {
                swipe(android, me.getRect().getX(), me.getLocation().getY() + size.height - 1, me.getRect().getX(), me.getLocation().getY() + 1, Duration.ofMillis(5000));
            } else if (SwipeDirection.equalsIgnoreCase("Down")) {
                swipe(android, me.getRect().getX(), me.getLocation().getY() + 1, me.getRect().getX(), me.getLocation().getY() + size.height - 1, Duration.ofMillis(5000));
            } else if (SwipeDirection.equalsIgnoreCase("Right")) {
                swipe(android, me.getLocation().getX() + 1, me.getRect().getY(), me.getLocation().getX() + size.width - 1, me.getRect().getY(), Duration.ofMillis(2000));
            } else if (SwipeDirection.equalsIgnoreCase("Left")) {
                swipe(android, me.getLocation().getX() + size.width - 1, me.getRect().getY(), me.getLocation().getX() + 1, me.getRect().getY(), Duration.ofMillis(2000));
            } else {
                log.info("Not a valid direction passed");
            }
        }
    }

    public boolean swipeRightToLeft(String elementPath, String... params) throws Exception {
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName() + " on";
        boolean flag = false;
        WebElement we = getMobElement(elementPath, 3, params);
        if (we != null) {
            try {
                Dimension size = driver.manage().window().getSize();
                int anchor = ((WebElement) we).getRect().getY();
                int startPoint = ((WebElement) we).getRect().getX();
                int endPoint = (int) (size.width - ((WebElement) we).getRect().getX());
                swipe(driver, startPoint, anchor, endPoint, anchor, Duration.ofMillis(2000));
                flag = true;
                Reporter.log(method);
            } catch (Exception e) {
                Reporter.log(method);
                log.error("Exception occurred while clicking on: " + elementPath + " " + e);
                throw new Exception(
                        "Exception occurred while clicking on: " + elementPath + " " + e);
            }
        } else {
            Reporter.log(method);
            throw new Exception("Element: " + elementPath + " isn't present");
        }

        return flag;
    }

    public boolean swipeLefttoRight(String elementPath, String... params) throws Exception {
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName() + " on";
        boolean flag = false;
        WebElement we = getMobElement(elementPath, 3, params);
        if (we != null) {
            try {
                Dimension size = driver.manage().window().getSize();
                int anchor = ((WebElement) we).getRect().getY();
                int startPoint = (int) (size.width - ((WebElement) we).getRect().getX() - 50);
                int endPoint = ((WebElement) we).getRect().getX();
                swipe(driver, startPoint, anchor, endPoint, anchor, Duration.ofMillis(2000));
                flag = true;
                Reporter.log(method);
            } catch (Exception e) {
                Reporter.log(method);
                log.error("Exception occurred while clicking on: " + elementPath + " " + e);
                throw new Exception(
                        "Exception occurred while clicking on: " + elementPath + " " + e);
            }
        } else {
            Reporter.log(method);
            throw new Exception("Element: " + elementPath + " isn't present");
        }

        return flag;
    }

    public boolean swipeRightToLeftnTimes(String elementPath, int count, String... params) throws Exception {
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName() + " on";
        boolean flag = false;
        WebElement we = getMobElement(elementPath, 3, params);
        if (we != null) {
            try {
                for (int i = 0; i < count; i++) {
                    Dimension size = driver.manage().window().getSize();
                    int anchor = ((WebElement) we).getRect().getY();
                    int startPoint = ((WebElement) we).getRect().getX();
                    int endPoint = (int) (size.width - ((WebElement) we).getRect().getX());
                    swipe(appium, startPoint, anchor, endPoint, anchor, Duration.ofMillis(2000));
                    flag = true;
                    Reporter.log(method);
                }
            } catch (Exception e) {
                Reporter.log(method);
                log.error("Exception occurred while clicking on: " + elementPath + " " + e);
                throw new Exception(
                        "Exception occurred while clicking on: " + elementPath + " " + e);
            }
        } else {
            Reporter.log(method);
            throw new Exception("Element: " + elementPath + " isn't present");
        }

        return flag;
    }

    private boolean getElementIsEnabled(String path, String... params) throws Exception {
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        String locatorBy = "";
        String value = "";
        HashMap<String, String> map = TestUtilities.getLocators().get(page).get(elementPath);
        Boolean isEnabled = null;
        Exception exception = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            locatorBy = entry.getKey();
            value = entry.getValue();
            if (!locatorBy.isEmpty() && !value.isEmpty()) {
                value = MessageFormat.format(value, (Object[]) params);
                value = value.trim();
                String driverType = property.getProperty("platformName");
                if (driverType.trim().toUpperCase().contains("ANDROID") && locatorBy.trim().equalsIgnoreCase("id")) {
                    value = property.getProperty("appPackage").trim() + ":id/" + value;
                }
                By by = (By) getByMethod(locatorBy).invoke(null, value);
                try {
                    isEnabled = driver.findElement(by).isEnabled();
                } catch (Exception ex) {
                    exception = ex;
                    Reporter.log("MobileElement: " + path);
                }
                if (isEnabled != null) {
                    break;
                }
            }
        }
        if (isEnabled == null && exception != null) {
            throw exception;
        }
        return isEnabled;
    }

    public boolean verifyElementIsEnabled(String elementPath, String... params) {
        int counter = !property.getProperty("noOfRetriesForElementToBeEnabled").trim().equalsIgnoreCase("") ? Integer.valueOf(property.getProperty("noOfRetriesForSameOperationOnElementPresent").trim()) : 1;
        Boolean isEnabled = null;
        while (counter > 0) {
            try {
                isEnabled = getElementIsEnabled(elementPath, params);
                break;
            } catch (Exception ex) {
                if (counter == 1) {
                    return false;
                }
                sync(1000L);
            }
            if (isEnabled != null) {
                break;
            }
            counter--;
        }
        return isEnabled;
    }

    public void captureScreenShot(ITestResult result) {
        String destDir = "";
        try {
            String passfailMethod = result.getParameters()[0].toString();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_hh");
            destDir = "screenshots/Failure" + dateFormat.format(new Date());
            new File(destDir).mkdirs();
            String destFile = passfailMethod + " - " + ".png";
            FileHandler.copy(scrFile, new File(destDir + "/" + destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File takeScreenShot(String screenShotName) {
        String destDir = "";
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_hh");
            destDir = "screenshots/Failure" + dateFormat.format(new Date());
            new File(destDir).mkdirs();
            String fullPath = destDir + "/" + getScreenShotName();
//            FileHandler.copy(scrFile, new File(destDir + "/" + getScreenShotName()+".png"));
            FileHandler.copy(scrFile, new File(fullPath + ".png"));

            BufferedImage fullImage = ImageIO.read(scrFile);

            // Calculate the new dimensions based on the aspect ratio
            int newWidth = fullImage.getWidth() / 3;
            int newHeight = fullImage.getHeight() / 3;

            // Create a new BufferedImage with the adjusted dimensions
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            resizedImage.getGraphics().drawImage(fullImage, 0, 0, newWidth, newHeight, null);

            File resizedScreenshot = new File(fullPath + "resized.png");
            ImageIO.write(resizedImage, "png", resizedScreenshot);

            return resizedScreenshot;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static File takeScreenShot() {
        return takeScreenShot(getScreenShotName());
    }

    private static void attachScreenShot(File screenShot, String screenShotName) {
        try {
            byte[] byteArray = readFileToByteArray(screenShot);
            scenario.attach(byteArray, "image/png", screenShotName);
        } catch (IOException e) {
        }
    }

    public static void takeAndAttachScreenShot(String screenShotName) {
        File file = takeScreenShot(screenShotName);
        attachScreenShot(file, screenShotName);
    }

    public static void takeAndAttachScreenShot() {
        String screenShotName = getScreenShotName();
        File file = takeScreenShot(screenShotName);
        attachScreenShot(file, screenShotName);
    }

    private static String getScreenShotName() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String scrName = "Screenshot" + dateFormat.format(new Date()) + " - ";
        return scrName;
    }

    public static void setScenario(Scenario scenario) {
        CommonFunctionsMobile.scenario = scenario;
    }

    public String getAttributeOfElement(String path, String attributeName, String... params) throws Exception {
        String page = path.split("/")[0];
        String elementPath = path.split("/")[1];
        String locatorBy = "";
        String value = "";
        HashMap<String, String> map = TestUtilities.getLocators().get(page).get(elementPath);
        String attributeValue = null;
        Exception exception = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            locatorBy = entry.getKey();
            value = entry.getValue();
            if (!locatorBy.isEmpty() && !value.isEmpty()) {
                value = MessageFormat.format(value, (Object[]) params);
                value = value.trim();
                String driverType = property.getProperty("platformName");
                if (driverType.trim().toUpperCase().contains("ANDROID") && locatorBy.trim().equalsIgnoreCase("id")) {
                    value = property.getProperty("appPackage").trim() + ":id/" + value;
                }
                By by = (By) getByMethod(locatorBy).invoke(null, value);
                try {
                    attributeValue = driver.findElement(by).getAttribute(attributeName);
                } catch (Exception ex) {
                    exception = ex;
                    Reporter.log("MobileElement: " + path);
                }
                if (attributeValue != null) {
                    break;
                }
            }
        }
        if (attributeValue == null && exception != null) {
            throw exception;
        }
        return attributeValue;
    }

    public void findElementandClick(String element, String elementText) throws Exception {
        String elementPath = element;
        boolean flag = false;
        List<WebElement> elementList = getMobElements(elementPath);
        if (elementList.size() > 0) {
            for (int i = 0; i < elementList.size(); i++) {
                WebElement we = elementList.get(i);
                if (getAttribute(we, "text").contains(elementText)) {
                    click(we, "element");
                    flag = true;
                    break;
                }
            }
        } else {
            if (getAttribute(elementList.get(0), "text").equals(elementText)) {
                click(elementList.get(0), "element");
                flag = true;
            }
        }
        if (!flag) {
            Assert.fail("element not found");
        }
    }

    public void openNotifications() throws Exception {
        androidDriver.openNotifications();
        Reporter.log("Verify notification is opened");
    }

    public void closeNotifications() throws Exception {
        TestUtilities.runCommandUsingTerminal(false, "adb -s " + property.getProperty("udid").trim() + " shell input swipe 10 1000 10 10", false, "1");
        if (checkIfElementPresent(By.id("com.android.systemui:id/dismiss_text"), 1)) {
            TestUtilities.runCommandUsingTerminal(false, "adb -s " + property.getProperty("udid").trim() + " shell input swipe 10 1000 10 10", false, "1");
        }
    }

    public boolean swipeTillElementFound(String elementPath, int time, int count, String... params) {
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName() + " on";
        boolean flag = false;

        try {
            for (int i = 1; i <= count; i++) {
                Dimension size = driver.manage().window().getSize();
                int startPointx = size.width / 2;
                int startPointy = getvPercentValue(size.height, 80);
                int endPointx = size.width / 2;
                int endPointy = size.height / 2;
                swipe(driver, startPointx, startPointy, endPointx, endPointy, Duration.ofMillis(2000));
                if (verifyPresenceOfElementOpt(elementPath, 1, params)) {
                    flag = true;
                    break;
                }
            }
        } catch (Exception e) {
            log.error("Exception occurred while scrolling on: " + e);
            Reporter.log(method);
        }
        return flag;
    }

    public static void selectDate(String month, String day) {
        String text = androidDriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Next month']")).getText();
        while (true) {

        }

    }
}

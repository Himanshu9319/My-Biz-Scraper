package utilities;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;


public class CommonFunctionsWeb extends Base {
    public static void openURL() throws InterruptedException {
        try {
            driver = DriverManager.getDriverInstance(property.getProperty("browser"), 20, 10);
            driver.manage().window().maximize();
            Base.driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Base.property = TestUtilities.addConfigProperties(Base.property.getProperty("env"));
            String url = Base.property.getProperty("url");
            loadPageWithRetry(url);
            testLevelReport.get().log(Status.PASS, "Able to launch URL");
            testLevelReport.get().log(Status.INFO, url);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Unable to launch URL for : " + "TravelPlus");
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Unable to launch URL for : " + "TravelPlus");

        }
    }

    public static void waitForElementToDisappear(By locator) throws InterruptedException {
        int count = 0;
        while (count < 5) {
            try {
                while (fluentWait(locator).isDisplayed()) {
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                count++;
            }
            Thread.sleep(2000);
            count++;
        }
    }

    public static void enterCharacter(By locator, String generatedString, String elementName) {
        try {
            fluentWait(locator).sendKeys(generatedString);
            testLevelReport.get().log(Status.PASS, "Entered characters in field : " + elementName);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Unable to enter characters in field : " + elementName);
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Unable to enter characters in : " + elementName);
        }
    }

    public static void click(By locator, String elementName) {
        try {
            fluentWait(locator).click();
            testLevelReport.get().log(Status.PASS, "Clicked on element : " + elementName);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Unable to click on button : " + elementName);
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Unable to click on button : " + elementName);
        }
    }

    public static void hoverElement(By locator, String elementName) {
        try {
            fluentWait(locator);
            //   action.moveToElement(fluentWait(locator)).build().perform();
            testLevelReport.get().log(Status.PASS, "Clicked on element : " + elementName);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Unable to click on button : " + elementName);
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Unable to click on button : " + elementName);
        }
    }

    public static void clickUsingJS(By element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(element));
    }


    public static String getText(By locator, String elementName) {
        String text = fluentWait(locator).getText();
        testLevelReport.get().log(Status.PASS, "Clicked on element : " + elementName);
        return text;
    }

    public static void hardwait(long sec) throws InterruptedException {
        Thread.sleep(sec);
    }


    public static void isElementDisplayed(By locator, String elementName) {
        try {
            fluentWait(locator).isDisplayed();
            testLevelReport.get().log(Status.PASS, "Element is getting displayed : " + elementName);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Element is not getting displayed : " + elementName);
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Element Not getting displayed : " + elementName);
        }
    }

    private static WebElement fluentWait(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        return wait.until(driver -> driver.findElement(locator));
    }

    public static void clickOnElements(By locator, String elementName, int index) {
        Actions action = new Actions(driver);
        try {
            fluentWaitWithWebElements(locator);
            action.moveToElement(getElements(locator).get(index)).click().perform();
            // getElements(locator).get(index).click();
            testLevelReport.get().log(Status.PASS, "Clicked on element : " + elementName);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Unable to click on button : " + elementName);
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Unable to click on button : " + elementName);
        }
    }

    public static List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    private static List<WebElement> fluentWaitWithWebElements(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        return wait.until(driver -> driver.findElements(locator));
    }

    public static void scrollTillElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded()", driver.findElement(locator));
    }

    public static void waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        } catch (Exception e) {
            Assert.fail("Element is not visible: " + locator);
        }
    }

    public static void waitforVisibilityOFallElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(locator)));
        } catch (Exception e) {
            Assert.fail("Element is not visible: " + locator);
        }
    }


    public static void waitForElementToBeClikable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        } catch (Exception e) {
            System.out.println("Element is not visible: " + locator);
        }
    }

    public static void pageContainUrl(String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.urlContains(url));
        } catch (Exception e) {
            System.out.println("Not able to Load url");
        }
    }


    public static boolean verifyAttributValue(By element, String text, String attribute, String elementName) {
        try {
            String heading = driver.findElement(element).getAttribute(attribute);
            return heading.contains(text);
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
            System.out.println("Unable to locate element : " + elementName);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred while locating element : " + elementName);
            return false;
        }
    }

    public static void verifyText(By element, String generatedString, String elementName, String... param) {
        boolean flag = false;
        try {
            String text = driver.findElement(element).getText();
            flag = text.toLowerCase().contains(param[0].toLowerCase());
            testLevelReport.get().log(Status.PASS, "Verified text for " + elementName);
            Assert.assertTrue(flag, "Verified text for " + elementName);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Unable to verify text for " + elementName);
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Unable to Verify text for " + elementName);
        }
    }

    public static void loadPageWithRetry(String url) {
        int retryCount = 0;
        boolean pageLoaded = false;
        while (!pageLoaded && retryCount < 8) {
            try {
                driver.get(url);
                pageLoaded = true;
            } catch (Exception e) {
                retryCount++;
                try {
                    Thread.sleep(15000); // wait for 15 seconds
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if (!pageLoaded) {
            System.out.println("Page could not be loaded after 8 attempts. Exiting the test.");
            if (driver != null) {
                driver.close();
                driver.quit();
            }
            System.exit(0);
        }
    }

    public static void verifyElementAttributeValue(By locator, String attribute, String expectedValue, String elementName) {
        try {
            if (fluentWait(locator).getAttribute(attribute).equalsIgnoreCase(expectedValue))
                testLevelReport.get().log(Status.PASS, "Verified Attribute '" + attribute + "' Value is : " + expectedValue + " for " + elementName);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Unable to verify Attribute '" + attribute + "' Value is : " + expectedValue + " for " + elementName);
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Unable to verify Attribute '" + attribute + "' Value is : " + expectedValue + " for " + elementName);
        }
    }

    public static void pressEnter(By inputSearchDomain, String elementName) {
        try {
            Thread.sleep(1000);
            driver.findElement(inputSearchDomain).sendKeys(Keys.RETURN);
            Thread.sleep(2000);
            testLevelReport.get().log(Status.PASS, "Enter Key Pressed on " + elementName);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Unable to press Enter Key on " + elementName);
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Unable to press Enter Key on " + elementName);
        }
    }

    public static void clearTextFromInputField(By locator, String elementName) {
        try {
            Thread.sleep(1000);
            driver.findElement(locator).clear();
            Thread.sleep(2000);
            testLevelReport.get().log(Status.PASS, "Cleared input in  : " + elementName);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Unable to clear input in " + elementName);
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Unable to clear input in " + elementName);
        }
    }

    public static void verifyElementNotDisplayed(By locator, String elementName) {
        try {
            fluentWait(locator).isDisplayed();
            testLevelReport.get().log(Status.FAIL, "Element is getting displayed : " + elementName);
            Assert.fail("Element is getting displayed : " + elementName);
        } catch (Exception e) {
            testLevelReport.get().log(Status.PASS, "Element is not getting displayed : " + elementName);
        }
    }

    public static void selectDropDownByValue(By locator, String value, String elementName) {
        try {
            fluentWait(locator).isDisplayed();
            WebElement dropdownElement = driver.findElement(locator);
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue(value);
            testLevelReport.get().log(Status.PASS, "Selected " + elementName + " with value " + value);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Unable to select " + elementName + " with value " + value);
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Unable to select " + elementName + " with value " + value);
        }
    }

    public static void openB2BURL() throws InterruptedException {
        try {
            driver = DriverManager.getDriverInstance(property.getProperty("browser"), 20, 10);
            driver.manage().window().maximize();
            Base.driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Base.property = TestUtilities.addConfigProperties(Base.property.getProperty("env"));
            String url = Base.property.getProperty("b2curl");
            loadPageWithRetry(url);
            testLevelReport.get().log(Status.PASS, "Able to launch URL");
            testLevelReport.get().log(Status.INFO, url);
        } catch (Exception e) {
            testLevelReport.get().log(Status.FAIL, "Unable to launch URL for : " + "Travelplus");
            testLevelReport.get().log(Status.DEBUG, e);
            Assert.fail("Unable to launch URL for : " + "Travelplus");

        }
    }

    public static void switchTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        // Switch to the new tab
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }
    }

    public static void scrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        hardwait(2);
    }
}
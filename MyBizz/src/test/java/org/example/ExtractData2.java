package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class ExtractData2 {

    //Radisson Blu Hotel New Delhi Dwarka
    public static String text = null;

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //System.setProperty("webdriver.chrome.driver","/Users/rahulshetty/Documents/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.makemytrip.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("----");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        Thread.sleep(2000);
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[id='webklipper-publisher-widget-container-notification-close-div']"))));
        //driver.findElement(By.cssSelector("[id=\"webklipper-publisher-widget-container-notification-close-div\"]")).click();
        Thread.sleep(2000);
        // button_login.click();
        driver.findElement(By.xpath("//li[text()='MyBiz Account']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("trips@planyourtrip.co.in");
        driver.findElement(By.xpath("//span[text()='CONTINUE']")).click();
        Thread.sleep(6000);
        // wait.until(ExpectedConditions.visibilityOf())
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123@Swati");
        driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Skip this step']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='OK GOT IT']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[text()='Hotels'])[1]")).click();
        Thread.sleep(3000);
        ArrayList<String> list = new ArrayList<>();
        list.add("ITC Maurya - A Luxury Collection Hotel, Delhi");
        list.add("Radisson Blu Hotel New Delhi Dwarka");
        list.add("Taj Palace, New Delhi");
        for (int j = 0; j < list.size(); j++) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='City, Property name or Location']")));
            Thread.sleep(1000);
            System.out.println("---------Enter property------------------");
            driver.findElement(By.xpath("//input[@placeholder=\"Enter city/ Hotel/ Area/ Building\"]")).sendKeys(list.get(j));
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(@class,'locusLabel appendBottom')]"))));

            for (int i = 0; i < driver.findElements(By.xpath("//p[contains(@class,'locusLabel appendBottom')]")).size(); i++) {
                text = driver.findElements(By.xpath("//p[contains(@class,'locusLabel appendBottom')]")).get(i)
                        .getText();
                System.out.println(text);
                if (text.contains(list.get(j))) {
                    System.out.println("In if condition");
                    //   executor.executeScript("arguments[0].click();",driver.findElements(By.xpath("//p[contains(@class,'locusLabel appendBottom')]")).get(i));
                    //  driver.findElement(By.xpath("//p[contains(@class,'locusLabel appendBottom')]")).click();
                    Actions actions = new Actions(driver);
                    actions.moveToElement(driver.findElements(By.xpath("//p[contains(@class,'locusLabel appendBottom')]/../..")).get(i)).click().perform();
                    Thread.sleep(3000);
                    break;
                } else {
                    System.out.println("Text is not matched");
                }
            }
            System.out.println("Check in date------");
            driver.findElement(By.xpath("//div[@aria-label=\"Wed Nov 08 2023\"]")).click();
            System.out.println("Check out date------");
            driver.findElement(By.xpath("//div[@aria-label=\"Thu Nov 09 2023\"]")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@data-testid=\"adult_count\"]/.."))));
            driver.findElement(By.xpath("//span[@data-testid=\"adult_count\"]/..")).click();
            driver.findElement(By.xpath("//li[text()='1']")).click();
            driver.findElement(By.xpath("//button[text()='Apply']")).click();
            driver.findElement(By.xpath("//button[@id=\"hsw_search_button\"]")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
            for (int i = 0; i < driver.findElements(By.xpath("//p[@itemprop=\"name\"]//span")).size(); i++) {
                String text = driver.findElements(By.xpath("//p[@itemprop=\"name\"]//span")).get(i).getText();
                System.out.println(text);
                if (driver.findElements(By.xpath("//p[@itemprop=\"name\"]//span")).get(i).getText().equalsIgnoreCase(text)) {
                    driver.findElements(By.xpath("//p[@itemprop=\"name\"]//span")).get(i).click();
                    break;
                } else {
                    System.out.println("No hotel found");
                }
            }
            String parent = driver.getWindowHandle();
            Set<String> s = driver.getWindowHandles();
            Iterator<String> I1 = s.iterator();
            while (I1.hasNext()) {
                String child_window = I1.next();
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);
                    System.out.println("On child window");
                    //try {
                        driver.findElement(By.xpath("//h5[text()='Room with Breakfast']/../../..//a//p[text()='SELECT ROOM']")).click();
//                   // } catch (Exception e) {
//                        driver.close();
//                        driver.switchTo().window(parent);
//                        driver.navigate().back();
//                        continue;
//                   // }

                    System.out.println("Remove coupan");
                    driver.findElement(By.xpath("//span[@class=\"dlCodes__delete\"]")).click();
                    System.out.println("------" + driver.findElement(By.xpath("//p[@class=\"latoBlack blackText\"]")).getText() + "--------");
                    System.out.println("------" + driver.findElement(By.xpath("//p[@class=\"latoBlack redText\"]")).getText() + "-----");
                    driver.close();
                    driver.switchTo().window(parent);
                    driver.navigate().back();
                }
            }
        }
    }
}

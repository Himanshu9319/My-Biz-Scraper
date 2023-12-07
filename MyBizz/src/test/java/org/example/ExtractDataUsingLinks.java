package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static java.time.Duration.ofSeconds;
import org.example.ExcelUtility;
import java.io.IOException;

public class ExtractDataUsingLinks {


  //  @Test
    public static void login() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //System.setProperty("webdriver.chrome.driver","/Users/rahulshetty/Documents/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.makemytrip.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("----");
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(4));
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
    }

    @Test(enabled = true,description = "Extract data",dataProvider="excel-data", dataProviderClass =ExcelUtility.class)
    public void extractData(String str1 , String str2 ,String str3 , String str4) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //System.setProperty("webdriver.chrome.driver","/Users/rahulshetty/Documents/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);




    }



}

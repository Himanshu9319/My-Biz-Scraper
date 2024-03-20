package web.mybizz.tests;


import com.redis.S;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utilities.*;

import javax.mail.MessagingException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import static utilities.Base.driver;
import static utilities.EmailAttachmentsSender.sendEmailWithAttachments;
import static utilities.EmailConfig.*;


public class ExtractData2 {

    static Set<Cookie> cookies;


    String userDataDirectory = System.getProperty("user.dir") + "/src/test/resources/cookies";  // Update with your desired path

    @Test(dataProvider = "MyBizzUrl", dataProviderClass = ExcelUtility.class)
    public void hitUrlAndData(String str1, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) throws InterruptedException {


        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\FabHotels\\Downloads\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        options.setBinary("C://Users//FabHotels//Downloads//chrome-win//chrome.exe");
        //   options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.50 Safari/537.36");
        options.addArguments("--enable-javascript");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://mybiz.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        captureScreenshot(driver, "Wholepagess");
        for (Cookie cookie : cookies) {
            try {
                driver.manage().addCookie(cookie);
            } catch (InvalidCookieDomainException e) {
                System.out.println("--" + cookie);
                System.out.println("Cannot add cookie to a domain different from the current domain");
            }
        }


        System.out.println("Make my trip is opened");

        // driver.manage().window().maximize();
        driver.get(str11);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //  driver.get("https://www.makemytrip.com/hotels/hotel-details/?checkin=02042024&checkout=02052024&locusId=CTBLR&locusType=city&city=CTBLR&country=IN&searchText=Grand%20Mercure%20Bengaluru%20at%20Gopalan%20Mall%2C%20An%20Accor%20Hotels%20Brand%2C%20Bangalore%2C%20Karnataka&roomStayQualifier=1e0e&_uCurrency=INR&reference=hotel&hotelId=202001031238347123&rf=directSearch&lat=12.99261&lng=77.66066&mpo=true&type=hotel&rsc=1e1e0e");
        System.out.println(str11);
        captureScreenshot(driver, "AfterWholepagess");
        //driver.get("https://www.makemytrip.com/hotels/hotel-review?_uCurrency=INR&checkin=11242023&checkout=11252023&city=CTHYDERA&country=IN&hotelId=200901081257279151&lat=17.41796&lng=78.45077&locusId=CTHYDERA&locusType=city&mpo=true&mtKey=-3876286554656957408&payMode=PAS&reference=hotel&rf=directSearch&roomCriteria=22099~%7C~990580251220%3A1134%3AINGO~%7C~1e0e&roomStayQualifier=1e0e&rsc=1e1e0e&searchText=Taj%20Deccan%2C%20Hyderabad%2C%20Hyderabad%2C%20Telangana&searchType=E&suppDetail=&type=hotel\n");


        try {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class=\"prmProperty \"]"))));
            wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class=\"rmSelect__card--wrapRow\"]"))));
            captureScreenshot(driver, "HotelnameHeading");
            if (!driver.findElements(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only'])[1]")).isEmpty()) {
                if (!driver.findElements(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only']/../../../..//div[@class=\"rmSelect__card--rowRight\"]//a//p[text()='Select Package'])[1]")).isEmpty()) {
                    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only']/../../../..//div[@class=\"rmSelect__card--rowRight\"]//a//p[text()='Select Package'])[1]"))));
                    driver.findElement(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only']/../../../..//div[@class=\"rmSelect__card--rowRight\"]//a//p[text()='Select Package'])[1]")).click();
                    // Thread.sleep(5000);
                    captureScreenshot(driver, "Screenshot1");
                    //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-testid=\"circular-loader\"]"))));
                    // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@data-testid=\"circular-loader\"]"))));
                    try {
                        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='rmSoldout__wrap']"))));
                        if (!driver.findElements(By.xpath("//div[@class='rmSoldout__wrap']")).isEmpty()) {
                            System.out.println("Check is property is sold out");
                            String hotelName = driver.findElement(By.xpath("//div[@class=\"prmProperty \"]//h1")).getText().replace(",", "");
                            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                            writeDataOnCSVFile2(str1, hotelName, "", "", "", "Yes", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", timeStamp);
                        }
                    } catch (Exception e) {
                        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=\"htlInfo__wrapper\"]"))));
                        getCoupanData(driver, str1);
                    }

                } else if (!driver.findElements(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only']/../../..//div[@class='rmSelect__card--rowRight']//a//p[text()='SELECT ROOM'])[1]")).isEmpty()) {
                    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only']/../../..//div[@class='rmSelect__card--rowRight']//a//p[text()='SELECT ROOM'])[1]"))));
                    driver.findElement(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only']/../../..//div[@class=\"rmSelect__card--rowRight\"]//a//p[text()='SELECT ROOM'])[1]")).click();
                    //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-testid=\"circular-loader\"]"))));
                    // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@data-testid=\"circular-loader\"]"))));

                    captureScreenshot(driver, "Screenshot2");
                    try {
                        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='rmSoldout__wrap']"))));
                        if (!driver.findElements(By.xpath("//div[@class='rmSoldout__wrap']")).isEmpty()) {
                            System.out.println("Check is property is sold out");
                            String hotelName = driver.findElement(By.xpath("//div[@class=\"prmProperty \"]//h1")).getText().replace(",", "");
                            //String roomtype = driver.findElement(By.xpath("(//h2[@class=\"rmType__roomName\"]/../../following-sibling::div[@class=\"rmSelect__card--right\"]//h5[text()='Room With Free Cancellation | Breakfast only'])[1]")).getText();
                            //  String member = driver.findElement(By.xpath("(//div[@class=\"roomDtlCard__head\"]//p)[2]")).getText();
                            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                            writeDataOnCSVFile2(str1, hotelName, "", "", "", "Yes", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", timeStamp);
                        }
                    } catch (Exception e) {
                        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=\"htlInfo__wrapper\"]"))));
                        getCoupanData(driver, str1);

                    }
                }


            }
            //------------------------------------------------------------------------------------------------------------------------------

            else if (!driver.findElements(By.xpath("(//h5[text()='Room with Breakfast'])[1]")).isEmpty()) {
                //(//h5[text()='Room with Breakfast']/../../..//div[@class="rmSelect__card--rowRight"]//a)[1]
                //(//h5[text()='Room with Breakfast'])[1]/../../../../..//a//p)[1]
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//h5[text()='Room with Breakfast']/../../..//div[@class='rmSelect__card--rowRight']//a)[1]"))));
                // WebElement element = driver.findElement(By.xpath("(//h5[text()='Room with Breakfast']/../../..//div[@class='rmSelect__card--rowRight']//a[@class=\"primaryBtn rmPayable__dtl--cta \"])[1]"));
                // Use Actions class to perform a series of actions, including scrolling
                driver.findElement(By.xpath("(//h5[text()='Room with Breakfast']/../../..//div[@class='rmSelect__card--rowRight']//a[@class=\"primaryBtn rmPayable__dtl--cta \"])[1]")).click();
                //  Thread.sleep(5000);

                // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-testid=\"circular-loader\"]"))));
                // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@data-testid=\"circular-loader\"]"))));
                //driver.findElement(By.xpath("(//h5[text()='Room with Breakfast']/../../..//div[@class='rmSelect__card--rowRight']//a[@class=\"primaryBtn rmPayable__dtl--cta \"])[1]")).click();
                try {
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Sold Out on MakeMyTrip']"))));
                    if (!driver.findElements(By.xpath("//p[text()='Sold Out on MakeMyTrip']")).isEmpty()) {
                        String hotelName = driver.findElement(By.xpath("//div//h1")).getText().replace(",", "");
                        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        writeDataOnCSVFile2(str1, hotelName, "", "", "", "yes", "", "", "", null, null, "", null, null, "", null, null, null, null, null, null, null, null, timeStamp);
                        //driver.quit();
                    }
                } catch (Exception e) {
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=\"htlInfo__wrapper\"]"))));
                    getCoupanData(driver, str1);
                }
            }
        } catch (Exception e) {
            if (driver.findElements(By.xpath("//div[@class=\"rmSelectRooms\"]")).isEmpty() && !driver.findElements(By.xpath("//div[@class=\"poiCont \"]")).isEmpty()) {
                String hotelName = driver.findElement(By.xpath("//div//h1")).getText().replace(",", "");
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                writeDataOnCSVFile2(str1, hotelName, "NO ROOM SPACE IS PRESENT", "", "", "", "PAGE IS EMPTY", "", "", null, null, "", null, null, "", null, null, null, null, null, null, null, null, timeStamp);

            } else if (!driver.findElements(By.xpath("//div[@class=\"dlLoader\"]")).isEmpty()) {
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                writeDataOnCSVFile2(str1, str11, "Url is corrupt", "", "", "", "", "", "", null, null, "", null, null, "", null, null, null, null, null, null, null, null, timeStamp);
                // driver.quit();
            } else {//need to modifi some conditions
                //  captureScreenshot(driver,"Screenshot2");
                String hotelName = driver.findElement(By.xpath("//div//h1")).getText().replace(",", "");
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                writeDataOnCSVFile2(str1, hotelName, "Room With break fast is not available", "", "", "Yes", "", "", "", null, null, "", null, null, "", null, null, null, null, null, null, null, null, timeStamp);
            }
        } finally {
            Thread.sleep(500);
            driver.quit();
        }

//        } catch (Exception e) {
//
//        }
    }

    public static void writeDataOnCSVFile2(String propid, String hotelName, String roomspace, String priceWithCoupon, String tax, String isSoldOut, String roomType, String roomFacility, String couponname1, String couponname2, String coupaonanme3, String coupanname4, String coupanname5, String cooupon1price, String cooupon2price, String cooupon3price, String cooupon4price, String cooupon5price, String coupon1des, String coupon2des, String coupon3des, String coupon4des, String coupon5des, String timstapm) {
        String filePath = System.getProperty("user.dir") + "//src//test//resources//mybiz.csv";
        System.out.println("-----------------------------" + filePath);

        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(filePath), true))) {
            // If the file does not exist, write the header
            if (new File(filePath).length() == 0) {
                pw.append("propid,HotelName,roomspace,PriceWithCoupon,HotelTaxes,SoldOut,roomtype,roomfacility,couponname1,couponname2,couponname3,couponname4,couponname5,cooupon1price,cooupon2price,cooupon3price,cooupon4price,cooupon5price,couponname1des,couponname2des,couponname3des,couponname4des,couponname5des,timstamp\r\n");
            }
            // Write data to the file
            pw.append(propid).append(",");
            pw.append(hotelName).append(",");
            pw.append(roomspace).append(",");
            pw.append(priceWithCoupon).append(",");
            pw.append(tax).append(",");
            pw.append(isSoldOut).append(",");
            pw.append(roomType).append(",");
            pw.append(roomFacility).append(",");
            pw.append(couponname1).append(",");
            pw.append(couponname2).append(",");
            pw.append(coupaonanme3).append(",");
            pw.append(coupanname4).append(",");
            pw.append(coupanname5).append(",");
            pw.append(cooupon1price).append(",");
            pw.append(cooupon2price).append(",");
            pw.append(cooupon3price).append(",");
            pw.append(cooupon4price).append(",");
            pw.append(cooupon5price).append(",");
            pw.append(coupon1des).append(",");
            pw.append(coupon2des).append(",");
            pw.append(coupon3des).append(",");
            pw.append(coupon4des).append(",");
            pw.append(coupon5des).append(",");
            pw.append(timstapm).append("\r\n");

            System.out.println("Data added successfully");
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., log it)
        }
    }

    @AfterClass
    public void createMenthodBody() throws MessagingException {
        // Create object to add multimedia type content
        sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "",
                System.getProperty("user.dir") + "//src//test//resources//mybiz.csv");
    }

    // @AfterSuite
    public void after() {
        System.out.println("Deleting all cookies");
        driver.manage().deleteAllCookies();
    }

    @BeforeClass
    public void setupClassName(ITestContext context) throws MessagingException {
        context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(10);
        context.getCurrentXmlTest().getSuite().setPreserveOrder(false);
    }

    @BeforeSuite
    public void setupClass(ITestContext context) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\FabHotels\\Downloads\\chromedriver-win64\\chromedriver.exe");
        // WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        /* With out Head less mode*/
//           chromeOptions.addArguments("--user-data-dir=" + userDataDirectory);
//           chromeOptions.addArguments("--remote-allow-origins=*");

        /*Head less mode*/
        //  chromeOptions.addArguments("--user-data-dir=" + userDataDirectory);
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setBinary("C:\\Users\\FabHotels\\Downloads\\chrome-win\\chrome.exe");
        // chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        WebDriver driver = new ChromeDriver(chromeOptions);

        //  driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //login to website
        driver.get("https://mybiz.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[text()='SIGN IN / SIGN UP']/..")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@class=\"modalMain\"]"))));
            captureScreenshot(driver, "LScreenshot1");
        } catch (Exception e) {
            try {
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[text()='Get Started']")).click();
                driver.findElement(By.xpath("//a[text()='SIGN IN / SIGN UP']/..")).click();
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class=\"contentHeading\"]"))));
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@class=\"modalMain\"]"))));

            } catch (Exception e1) {
                try {
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//a[text()='OK GOT IT']")).click();
                    driver.findElement(By.xpath("//a[text()='SIGN IN / SIGN UP']/..")).click();
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class=\"contentHeading\"]"))));
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@class=\"modalMain\"]"))));
                } catch (Exception e2) {

                }
            }
        }
        Thread.sleep(3000);
        captureScreenshot(driver, "LoginSuccessfully");
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@class=\"modalMain\"]"))));
        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@placeholder=\"Enter your work email id\"]")).sendKeys("mynewmail1234@yopmail.com");
            driver.findElement(By.xpath("//span[text()='CONTINUE']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("demo@1234");
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("User is logged in");
        }
        captureScreenshot(driver, "LoginSuccessfully2");
        cookies = driver.manage().getCookies();
//        for (Cookie cookie : cookies) {
//            driver.manage().addCookie(cookie);
//        }
        deleteDir(new File(userDataDirectory));

    }


    public void getCoupanData(WebDriver driver, String propid) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            if (!driver.findElements(By.xpath("//li[contains(@class,'dlCodes__listItem')]")).isEmpty()) {
                ArrayList<String> couponnames = new ArrayList<>();
                ArrayList<String> couponprice = new ArrayList<>();
                ArrayList<String> coupondes = new ArrayList<>();
                String couponPrice = null;
                String coupandescription = null;
                int totalCoupanCount = driver.findElements(By.xpath("//li[contains(@class,'dlCodes__listItem')]")).size();
                System.out.println("Total Coupan's-----" + totalCoupanCount);
                int totalCoupanCountWithPrice = driver.findElements(By.xpath("//span[@class=\"dealPrice latoBlack noShrink\"]")).size();
                System.out.println("Total Coupan's with price-----" + totalCoupanCountWithPrice);
                if (totalCoupanCount > totalCoupanCountWithPrice) {
                    for (int i = 0; i < driver.findElements(By.xpath("//li[contains(@class,'dlCodes__listItem')]")).size(); i++) {
                        if (i == 0) {
                            couponPrice = "This is first coupan so no coupan price is present for this coupan";
                            String couponName = driver.findElements(By.cssSelector("[class='dealCode__truncate overrideRtl']")).get(i).getText();
                            coupandescription = driver.findElements(By.xpath("//div[@class=\"makeRelative\"]//p[@class=\"font12 lineHight16\"]")).get(i).getText().replace(",", "");
                            couponnames.add(couponName);
                            coupondes.add(coupandescription);
                            couponprice.add(couponPrice);
                        } else {
                            String couponName = driver.findElements(By.cssSelector("[class='dealCode__truncate overrideRtl']")).get(i).getText();
                            couponnames.add(couponName);

                            if (!driver.findElements(By.xpath("//span[@class=\"dealPrice latoBlack noShrink\"]")).isEmpty()) {
                                couponPrice = driver.findElements(By.xpath("//span[@class=\"dealPrice latoBlack noShrink\"]")).get(i - 1).getText().replace(",", "");
                                couponprice.add(couponPrice);
                            } else {
                                couponPrice = null;
                                couponprice.add(couponPrice);
                            }

                            if (!driver.findElements(By.xpath("//span[@class=\"dealPrice latoBlack noShrink\"]")).isEmpty()) {
                                coupandescription = driver.findElements(By.xpath("//div[@class=\"makeRelative\"]//p[@class=\"font12 lineHight16\"]")).get(i).getText().replace(",", "");
                                coupondes.add(coupandescription);
                            }////span[@class="dealPrice latoBlack noShrink"]
                            else {
                                coupandescription = driver.findElement(By.xpath("(//ul[@class=\"dlCodes__list\"]//p)[2]")).getText().replace(",", "");
                                coupondes.add(coupandescription);
                            }

                        }

                    }
                } else {
                    for (int i = 0; i < driver.findElements(By.xpath("//li[contains(@class,'dlCodes__listItem')]")).size(); i++) {
                        String couponName = driver.findElements(By.cssSelector("[class='dealCode__truncate overrideRtl']")).get(i).getText();
                        couponnames.add(couponName);
                        if (!driver.findElements(By.xpath("//span[@class=\"dealPrice latoBlack noShrink\"]")).isEmpty()) {
                            couponPrice = driver.findElements(By.xpath("//span[@class=\"dealPrice latoBlack noShrink\"]")).get(i).getText().replace(",", "");
                        } else {
                            couponPrice = null;
                        }
                        couponprice.add(couponPrice);
                        if (!driver.findElements(By.xpath("//span[@class=\"dealPrice latoBlack noShrink\"]")).isEmpty()) {
                            //  if (i != 3) {
                            coupandescription = driver.findElements(By.xpath("//div[@class=\"makeRelative\"]//p[@class=\"font12 lineHight16\"]")).get(i).getText().replace(",", "");
                            //  }

                        }////span[@class="dealPrice latoBlack noShrink"]
                        else {
                            coupandescription = driver.findElement(By.xpath("(//ul[@class=\"dlCodes__list\"]//p)[2]")).getText().replace(",", "");
                        }
                        coupondes.add(coupandescription);
                    }
                }

                String hotelName = driver.findElement(By.xpath("//div//h3")).getText().replace(",", "");
                String roomspace = "";
                for (int i = 0; i < driver.findElements(By.xpath("//p[contains(@class,'latoBold blackText')]//span")).size(); i++) {
                    roomspace = roomspace + " " + driver.findElements(By.xpath("//p[contains(@class,'latoBold blackText')]//span")).get(i).getText();
                    System.out.println("---" + roomspace);
                }
                System.out.println(coupondes + " " + couponPrice);
                /*Coupoan details page*/
                String totalAmountToBePaid = driver.findElement(By.xpath("//p[@class='latoBlack redText']")).getText().replaceAll(",", "");
                String tax = driver.findElement(By.xpath("//div[@class=\"latoBold blackText makeFlex hrtlCenter\"]/../..//p[@class=\"latoBold\"]")).getText().replace(",", "");
                String roomType = driver.findElement(By.xpath("//p[@class=\"latoBlack font14 blackText capText makeFlex\"]")).getText().replace(",", "");
                String roomFacility = driver.findElement(By.xpath("//div[@class=\"makeFlex\"]/following-sibling::p")).getText().replace(",", "");

                if (coupondes.size() == 1) {
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

                    writeDataOnCSVFile2(propid, hotelName, roomspace, totalAmountToBePaid, tax, "", roomType, roomFacility, couponnames.get(0), "", "", "", "", couponprice.get(0), "", null, null, null, coupondes.get(0), null, null, null, null, timeStamp);
                } else if (coupondes.size() == 2) {
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                    System.out.println("--coupondes---" + coupondes);
                    System.out.println("---couponprice---" + couponprice);
                    System.out.println("couponnames----------" + couponnames);
                    writeDataOnCSVFile2(propid, hotelName, roomspace, totalAmountToBePaid, tax, "", roomType, roomFacility, couponnames.get(0), couponnames.get(1), "", "", "", couponprice.get(0), couponprice.get(1), null, null, null, coupondes.get(0), coupondes.get(1), "", "", "", timeStamp);
                } else if (coupondes.size() == 3) {
                    System.out.println("Get coupan description---------------------------" + coupondes.get(2));
                    System.out.println("--coupondes---" + coupondes);
                    System.out.println("---couponprice---" + couponprice);
                    System.out.println("couponnames----------" + couponnames);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                    writeDataOnCSVFile2(propid, hotelName, roomspace, totalAmountToBePaid, tax, "", roomType, roomFacility, couponnames.get(0), couponnames.get(1), couponnames.get(2), "", "", couponprice.get(0), couponprice.get(1), couponprice.get(2), "", coupondes.get(0), coupondes.get(1), coupondes.get(2), "", "", "", timeStamp);
                } else if (coupondes.size() == 4) {
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                    writeDataOnCSVFile2(propid, hotelName, roomspace, totalAmountToBePaid, tax, "", roomType, roomFacility, couponnames.get(0), couponnames.get(1), couponnames.get(2), couponnames.get(3), "", couponprice.get(0), couponprice.get(1), couponprice.get(2), couponprice.get(3), "", coupondes.get(0), coupondes.get(1), coupondes.get(2), coupondes.get(3), "", timeStamp);

                } else if (coupondes.size() > 4) {
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                    writeDataOnCSVFile2(propid, hotelName, roomspace, totalAmountToBePaid, tax, "", roomType, roomFacility, couponnames.get(0), couponnames.get(1), couponnames.get(2), couponnames.get(3), couponnames.get(4), couponprice.get(0), couponprice.get(1), couponprice.get(2), couponprice.get(3), couponprice.get(4), coupondes.get(0), coupondes.get(1), coupondes.get(2), coupondes.get(3), coupondes.get(4), timeStamp);

                }
            } else if (!driver.findElements(By.xpath("//p[text()='Not available for selected dates on MakeMyTrip']")).isEmpty()) {
                String hotelName = driver.findElement(By.xpath("//div[@class=\"prmProperty \"]//h1")).getText().replace(",", "");
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                writeDataOnCSVFile2(propid, hotelName, "No room available", "", "", "Yes", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", timeStamp);
            } else {
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div//h3"))));
                String hotelName = driver.findElement(By.xpath("//div//h3")).getText().replace(",", "");
                System.out.println("---Hotel Name---" + driver.findElement(By.xpath("//div//h3")).getText() + "-----");
                System.out.println("---If no coupan is available on page---");
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(@class,'latoBold blackText')]//span"))));
                String roomspace = "";
                for (int i = 0; i < driver.findElements(By.xpath("//p[contains(@class,'latoBold blackText')]//span")).size(); i++) {
                    roomspace = roomspace + " " + driver.findElements(By.xpath("//p[contains(@class,'latoBold blackText')]//span")).get(i).getText();
                    System.out.println("---" + roomspace);
                }
                System.out.println("Total amount to be paid heading-> " + driver.findElement(By.xpath("//p[@class='latoBlack blackText']")).getText() + "----");
                System.out.println("Total amount-> " + driver.findElement(By.xpath("//p[@class='latoBlack redText']")).getText());
                System.out.println("-Hotel tax--" + driver.findElement(By.xpath("//div[@class=\"latoBold blackText makeFlex hrtlCenter\"]")).getText());
                String totalAmountToBePaid = driver.findElement(By.xpath("//p[@class=\"latoBlack redText\"]")).getText().replaceAll(",", "");
                System.out.println("--" + driver.findElement(By.xpath("//div[text()='Hotel Taxes']/../..//p[@class=\"latoBold\"]")).getText());
                String tax = driver.findElement(By.xpath("//div[text()='Hotel Taxes']/../..//p[@class=\"latoBold\"]")).getText().replace(",", "");
                String roomType = driver.findElement(By.xpath("(//div[@class=\"makeFlex column\"]//p)[1]")).getText().replace(",", "");
                String roomFacility = driver.findElement(By.xpath("//div[@class=\"makeFlex\"]/following-sibling::p")).getText().replace(",", "");
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                writeDataOnCSVFile2(propid, hotelName, roomspace, totalAmountToBePaid, tax, "", roomType, roomFacility, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", timeStamp);
            }
        } catch (Exception e) {
            driver.quit();
        }
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        // Convert the driver to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot as a file
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination path for the screenshot
        String destination = System.getProperty("user.dir") + "/src/test/resources/" + screenshotName + ".png";

        try {
            // Copy the file to the specified location
            FileUtils.copyFile(source, new File(destination));
            System.out.println("Screenshot taken and saved at: " + destination);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }


    //@BeforeMethod
    public static void deleteDir(File dirFile) {
        if (dirFile.isDirectory()) {
            File[] dirs = dirFile.listFiles();
            for (File dir : dirs) {
                deleteDir(dir);
            }
        }
        dirFile.delete();
        System.out.println("File deleted successfully");
    }

    public static int countRowsInCSV(String csvFilePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        int rowCount = 0;
        while (reader.readLine() != null) {
            rowCount++;
        }
        reader.close();
        return rowCount;
    }

    @AfterMethod
    public void sendMailAfter300url() throws MessagingException {
        System.out.println("Row count is not reached till 300");
        String csvFilePath = System.getProperty("user.dir") + "//src//test//resources//mybiz.csv";
        // Number of rows to trigger email sending
        int triggerRowCount = 10;

        // Start monitoring the CSV file for row count

        try {
            int rowCount = countRowsInCSV(csvFilePath);
            if (rowCount == 300) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
                System.gc();
            } else if (rowCount == 600) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
                System.gc();
            } else if (rowCount == 900) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
                System.gc();
            }
            else if (rowCount == 1200) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
                System.gc();
            }
            else if (rowCount == 1500) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
                System.gc();
            }
            else if (rowCount == 1800) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
                System.gc();
            }
            else if (rowCount == 2100) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
                System.gc();
            }
            else if (rowCount == 2400) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
                System.gc();
            }
            else if (rowCount == 2700) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
                System.gc();
            }
            else if (rowCount == 3000) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
                System.gc();
            }
            else if (rowCount == 3300) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
                System.gc();
            }
            // Check every 5 minutes (adjust as needed)
            //Thread.sleep(5 * 60 * 1000); // Sleep for 5 minutes
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}



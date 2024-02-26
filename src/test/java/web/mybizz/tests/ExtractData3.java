package web.mybizz.tests;


import io.cucumber.java.bs.A;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utilities.ExcelUtility;

import javax.mail.MessagingException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import static utilities.Base.driver;
import static utilities.EmailAttachmentsSender.sendEmailWithAttachments;
import static utilities.EmailConfig.*;


public class ExtractData3 {

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

        //  str11="https://www.makemytrip.com/hotels/hotel-details/?_uCurrency=INR&checkin=02212024&checkout=02222024&city=CTAGR&country=IN&hotelId=201301121840404200&lat=27.15924&lng=78.04377&locusId=CTAGR&locusType=city&mpo=true&reference=hotel&rf=directSearch&roomStayQualifier=1e0e&rsc=1e1e0e&searchText=ITC%20Mughal%20-%20A%20Luxury%20Collection%20Hotel%2C%20Agra%2C%20Uttar%20Pradesh&type=hotel";

        // driver.manage().window().maximize();
        driver.get(str11);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //  driver.get("https://www.makemytrip.com/hotels/hotel-details/?checkin=02042024&checkout=02052024&locusId=CTBLR&locusType=city&city=CTBLR&country=IN&searchText=Grand%20Mercure%20Bengaluru%20at%20Gopalan%20Mall%2C%20An%20Accor%20Hotels%20Brand%2C%20Bangalore%2C%20Karnataka&roomStayQualifier=1e0e&_uCurrency=INR&reference=hotel&hotelId=202001031238347123&rf=directSearch&lat=12.99261&lng=77.66066&mpo=true&type=hotel&rsc=1e1e0e");
        System.out.println(str11);
        captureScreenshot(driver, "AfterWholepagess");
        //driver.get("https://www.makemytrip.com/hotels/hotel-review?_uCurrency=INR&checkin=11242023&checkout=11252023&city=CTHYDERA&country=IN&hotelId=200901081257279151&lat=17.41796&lng=78.45077&locusId=CTHYDERA&locusType=city&mpo=true&mtKey=-3876286554656957408&payMode=PAS&reference=hotel&rf=directSearch&roomCriteria=22099~%7C~990580251220%3A1134%3AINGO~%7C~1e0e&roomStayQualifier=1e0e&rsc=1e1e0e&searchText=Taj%20Deccan%2C%20Hyderabad%2C%20Hyderabad%2C%20Telangana&searchType=E&suppDetail=&type=hotel\n");
        String hotelName = driver.findElement(By.xpath("//div[@class=\"prmProperty \"]//h1")).getText().replace(",", "");
        System.out.println("Hotel name------>" + hotelName);
        ArrayList<String> roomtype = new ArrayList<>();
        for (int i = 0; i < driver.findElements(By.xpath("//h2[@class=\"rmType__roomName\"]")).size(); i++) {
            String room_type = driver.findElements(By.xpath("//h2[@class=\"rmType__roomName\"]")).get(i).getText();
            System.out.println("Room type-----" + i + "   " + room_type);
            roomtype.add(room_type);
//            for (int j = 0; j < driver.findElements(By.xpath("//h2[text()='" + room_type + "']/..//span[@class='rmTypeList__item--text']")).size(); j++) {
//                String roomtypelistitem = driver.findElements(By.xpath("//h2[text()='" + room_type + "']/..//span[@class='rmTypeList__item--text']")).get(j).getText();
//                System.out.println("Room type list item--------------->" + roomtypelistitem);
//
//            }
        }
        writeDataOnCSVFile3(str1, hotelName, roomtype, "", "","");

        driver.quit();


        // String roomType = driver.findElement(By.xpath("//h2[@class=\"rmType__roomName\"]")).getText();


    }

    public static void writeDataOnCSVFile2(String propid, String hotelName, String Roomtype, String roomfacility1, String roomfacility2, String roomfacility3) {
        String filePath = System.getProperty("user.dir") + "//src//test//resources//roomtype.csv";
        System.out.println("-----------------------------" + filePath);

        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(filePath), true))) {
            // If the file does not exist, write the header
            if (new File(filePath).length() == 0) {
                pw.append("propid,HotelName,Roomtype,roomfacility1,roomfacility2,roomfacility3\r\n");
            }
            // Write data to the file
            pw.append(propid).append(",");
            pw.append(hotelName).append(",");
            pw.append(Roomtype).append(",");
            pw.append(roomfacility1).append(",");

            System.out.println("Data added successfully");
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., log it)
        }
    }

    public static void writeDataOnCSVFile3(String propid, String hotelName, ArrayList<String> roomTypes, String roomfacility1, String roomfacility2, String roomfacility3) {
        String filePath = System.getProperty("user.dir") + "//src//test//resources//roomtype.csv";
        System.out.println("-----------------------------" + filePath);
        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(filePath), true))) {
            // If the file does not exist, write the header
            if (new File(filePath).length() == 0) {
                pw.append("propid,HotelName");
                for (String roomType : roomTypes) {
                    pw.append(",roomType");
                }
                pw.append(",roomfacility1,roomfacility2,roomfacility3\r\n");
            }
            // Write data to the file
            pw.append(propid).append(",");
            pw.append(hotelName).append(",");
            for (String roomType : roomTypes) {
                pw.append(roomType).append(",");
            }
            pw.append(roomfacility1).append(",");
            pw.append(roomfacility2).append(",");
            pw.append(roomfacility3).append("\r\n");
            System.out.println("Data added successfully");
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., log it)
        }
    }


    @AfterClass
    public void createMenthodBody() throws MessagingException {
        // Create object to add multimedia type content
        sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "",
                System.getProperty("user.dir") + "//src//test//resources//roomtype.csv");
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
        String csvFilePath = System.getProperty("user.dir") + "//src//test//resources//roomtype.csv";
        // Number of rows to trigger email sending
        int triggerRowCount = 10;

        // Start monitoring the CSV file for row count

        try {
            int rowCount = countRowsInCSV(csvFilePath);
            if (rowCount == 300) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
            } else if (rowCount == 600) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
            } else if (rowCount == 900) {
                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
                System.out.println("Maild is triggered");
                Thread.sleep(10000);
            }
//            else if (rowCount == 1167) {
//                sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, "", csvFilePath);
//                System.out.println("Maild is triggered");
//                Thread.sleep(10000);
//            }
            // Check every 5 minutes (adjust as needed)
            //Thread.sleep(5 * 60 * 1000); // Sleep for 5 minutes
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}



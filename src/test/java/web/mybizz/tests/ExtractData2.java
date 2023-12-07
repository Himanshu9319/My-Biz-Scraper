package web.mybizz.tests;

import UtilsAPI.TravelPlus.responseDto.Search.SearchResults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.ExcelUtility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.ArrayList;

public class ExtractData2 {

    @Test(dataProvider = "MyBizzUrl", dataProviderClass = ExcelUtility.class)
    public void hitUrlAndData(String str1, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) throws InterruptedException {
        System.out.println(str11);//5,9,10
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(500);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get(str11);
        //driver.get("https://www.makemytrip.com/hotels/hotel-review?_uCurrency=INR&checkin=11242023&checkout=11252023&city=CTHYDERA&country=IN&hotelId=200901081257279151&lat=17.41796&lng=78.45077&locusId=CTHYDERA&locusType=city&mpo=true&mtKey=-3876286554656957408&payMode=PAS&reference=hotel&rf=directSearch&roomCriteria=22099~%7C~990580251220%3A1134%3AINGO~%7C~1e0e&roomStayQualifier=1e0e&rsc=1e1e0e&searchText=Taj%20Deccan%2C%20Hyderabad%2C%20Hyderabad%2C%20Telangana&searchType=E&suppDetail=&type=hotel\n");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        if (driver.findElements(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only'])[1]")).size() > 0) {
            if (driver.findElements(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only']/../../../..//div[@class=\"rmSelect__card--rowRight\"]//a//p[text()='Select Package'])[1]")).size() > 0) {
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only']/../../../..//div[@class=\"rmSelect__card--rowRight\"]//a//p[text()='Select Package'])[1]"))));
                driver.findElement(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only']/../../../..//div[@class=\"rmSelect__card--rowRight\"]//a//p[text()='Select Package'])[1]")).click();
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only']/../../..//div[@class='rmSelect__card--rowRight']//a//p[text()='SELECT ROOM'])[1]"))));
                driver.findElement(By.xpath("(//h5[text()='Room With Free Cancellation | Breakfast only']/../../..//div[@class=\"rmSelect__card--rowRight\"]//a//p[text()='SELECT ROOM'])[1]")).click();
            }

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=\"htlInfo__wrapper\"]"))));
        } else if (driver.findElements(By.xpath("(//h5[text()='Room with Breakfast'])[1]")).size() > 0) {
            //(//h5[text()='Room with Breakfast']/../../..//div[@class="rmSelect__card--rowRight"]//a)[1]
            //(//h5[text()='Room with Breakfast'])[1]/../../../../..//a//p)[1]
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//h5[text()='Room with Breakfast']/../../..//div[@class='rmSelect__card--rowRight']//a)[1]"))));
            driver.findElement(By.xpath("(//h5[text()='Room with Breakfast']/../../..//div[@class='rmSelect__card--rowRight']//a[@class=\"primaryBtn rmPayable__dtl--cta \"])[1]")).click();
        }
        if (driver.findElements(By.xpath("//div[@class='rmSoldout__wrap']")).size() > 0) {
            String hotelName = driver.findElement(By.xpath("//div[@class=\"prmProperty \"]//h1")).getText().replace(",", "");
            //String roomtype = driver.findElement(By.xpath("(//h2[@class=\"rmType__roomName\"]/../../following-sibling::div[@class=\"rmSelect__card--right\"]//h5[text()='Room With Free Cancellation | Breakfast only'])[1]")).getText();
            //  String member = driver.findElement(By.xpath("(//div[@class=\"roomDtlCard__head\"]//p)[2]")).getText();
            writeDataOnCSVFile2(hotelName, "", "", "", "Yes", "", "", "", "", "", "", "", "", "", "", "");
        } else if (driver.findElements(By.xpath("//li[contains(@class,'dlCodes__listItem')]")).size() > 0) {
            ArrayList<String> couponnames = new ArrayList<>();
            ArrayList<String> couponprice = new ArrayList<>();
            ArrayList<String> coupondes = new ArrayList<>();
            String couponPrice = null;
            String coupandescription = null;
            for (int i = 0; i < driver.findElements(By.xpath("//li[contains(@class,'dlCodes__listItem')]")).size(); i++) {
                String couponName = driver.findElements(By.cssSelector("[class='dealCode__truncate overrideRtl']")).get(i).getText();
                couponnames.add(couponName);
                if (driver.findElements(By.xpath("//span[@class=\"dealPrice latoBlack noShrink\"]")).size() > 0) {
                    couponPrice = driver.findElements(By.xpath("//span[@class=\"dealPrice latoBlack noShrink\"]")).get(i).getText().replace(",", "");
                } else {
                    couponPrice = null;
                }
                couponprice.add(couponPrice);
                if (driver.findElements(By.xpath("//span[@class=\"dealPrice latoBlack noShrink\"]")).size() > 0) {
                    //  if (i != 3) {
                    coupandescription = driver.findElements(By.xpath("//div[@class=\"makeRelative\"]//p[@class=\"font12 lineHight16\"]")).get(i).getText().replace(",", "");
                    //  }

                }////span[@class="dealPrice latoBlack noShrink"]
                else {
                    coupandescription = driver.findElement(By.xpath("(//ul[@class=\"dlCodes__list\"]//p)[2]")).getText().replace(",", "");
                }
                coupondes.add(coupandescription);
            }

            String hotelName = driver.findElement(By.xpath("//div//h3")).getText().replace(",", "");
            String roomspace = "";
            for (int i = 0; i < driver.findElements(By.xpath("//p[contains(@class,'latoBold blackText')]//span")).size(); i++) {
                roomspace = roomspace + " " + driver.findElements(By.xpath("//p[contains(@class,'latoBold blackText')]//span")).get(i).getText();
                System.out.println("---" + roomspace);
            }
            System.out.println(coupondes + " " + couponPrice);
            String totalAmountToBePaid = driver.findElement(By.xpath("(//p[@class='font16 latoBold'])[2]")).getText().replaceAll(",", "");
            String tax = driver.findElement(By.xpath("//div[@class=\"latoBold blackText makeFlex hrtlCenter\"]/../..//p[@class=\"latoBold\"]")).getText().replace(",", "");
            String roomType = driver.findElement(By.xpath("//div[@class=\"makeFlex spaceBetween\"]//h4")).getText();
            String roomFacility = driver.findElement(By.xpath("//div[@class=\"rmDesc \"]//div[@class=\"makeFlex column end\"]//span")).getText();

            if (coupondes.size() == 1) {
                writeDataOnCSVFile2(hotelName, roomspace, totalAmountToBePaid, tax, "", roomType, roomFacility, couponnames.get(0), null, null, couponprice.get(0), null, null, coupondes.get(0), null, null);
            } else if (coupondes.size() == 2) {
                writeDataOnCSVFile2(hotelName, roomspace, totalAmountToBePaid, tax, "", roomType, roomFacility, couponnames.get(0), couponnames.get(1), null, couponprice.get(0), couponprice.get(1), null, coupondes.get(0), coupondes.get(1), null);
            } else if (coupondes.size() > 2) {
                System.out.println(coupondes.get(2));
                writeDataOnCSVFile2(hotelName, roomspace, totalAmountToBePaid, tax, "", roomType, roomFacility, couponnames.get(0), couponnames.get(1), couponnames.get(2), couponprice.get(0), couponprice.get(1), couponprice.get(2), coupondes.get(0), coupondes.get(1), coupondes.get(2));
            }
        } else if (driver.findElements(By.xpath("//span[@title='WELCOMEBACK1']")).size() > 0) {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='dtNewDetailsPage']"))));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div//h3"))));
            System.out.println("---Hotel Name---" + driver.findElement(By.xpath("//div//h3")).getText() + "-----");
            String hotelName = driver.findElement(By.xpath("//div//h3")).getText().replace(",", " ");
            System.out.println("----Before coupon price-----");
            System.out.println("--" + driver.findElement(By.xpath("//p[@class=\"latoBlack blackText\"]")).getText() + "----");
            System.out.println("--" + driver.findElement(By.xpath("//p[@class=\"latoBlack redText\"]")).getText());
            System.out.println("----Coupan details-----");
            String couponText = driver.findElement(By.xpath("//span[@title='WELCOMEBACK1']")).getText();
            System.out.println(couponText);
            String couponPrice = driver.findElement(By.cssSelector("[class='dealPrice latoBlack noShrink']")).getText();
            System.out.println(couponPrice);
            System.out.println("After removal coupon");
            driver.findElement(By.xpath("//span[@class=\"dlCodes__delete\"]")).click();
            System.out.println("--" + driver.findElement(By.xpath("//p[@class=\"latoBlack blackText\"]")).getText() + "----");
            System.out.println("--" + driver.findElement(By.xpath("//p[@class=\"latoBlack redText\"]")).getText());
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(@class,'latoBold blackText')]//span"))));
            String roomspace = "";
            for (int i = 0; i < driver.findElements(By.xpath("//p[contains(@class,'latoBold blackText')]//span")).size(); i++) {
                roomspace = roomspace + " " + driver.findElements(By.xpath("//p[contains(@class,'latoBold blackText')]//span")).get(i).getText();
                System.out.println("---" + roomspace);
            }
            String totalAmountToBePaid = driver.findElement(By.xpath("(//p[@class='font16 latoBold'])[2]")).getText().replaceAll(",", "");
            String tax = driver.findElement(By.xpath("//div[@class=\"latoBold blackText makeFlex hrtlCenter\"]/../..//p[@class=\"latoBold\"]")).getText().replace(",", "");
            String roomType = driver.findElement(By.xpath("//div[@class=\"makeFlex spaceBetween\"]//h4")).getText();
            String roomFacility = driver.findElement(By.xpath("(//div[@class=\"roomDtlCard__content\"]//ul//p)[1]")).getText();
            //  writeDataOnCSVFile2(hotelName, roomspace, totalAmountToBePaid, tax, "", roomType,roomFacility);
        } else if (driver.findElements(By.xpath("//li[@class=\"dlCodes__listItem whiteBg  itemSelectedNew \"]")).size() > 0) {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div//h3"))));
            System.out.println("---Hotel Name---" + driver.findElement(By.xpath("//div//h3")).getText() + "-----");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(@class,'latoBold blackText')]//span"))));
            String roomspace = "";
            for (int i = 0; i < driver.findElements(By.xpath("//p[contains(@class,'latoBold blackText')]//span")).size(); i++) {
                roomspace = roomspace + " " + driver.findElements(By.xpath("//p[contains(@class,'latoBold blackText')]//span")).get(i).getText();
                System.out.println("---" + roomspace);
            }
            String hotelName = driver.findElement(By.xpath("//div//h3")).getText().replace(",", "");
            System.out.println("Normal coupon");
            System.out.println(driver.findElement(By.xpath("//span[@class=\"dealCode__truncate overrideRtl\"]")).getText());
            driver.findElement(By.xpath("//span[@class=\"dlCodes__delete\"]")).click();
            System.out.println("--" + driver.findElement(By.xpath("//div[@class=\"pricBreakup__total\"]//div//div[@class='pricBreakup__lft']//p")).getText() + "----");
            System.out.println("--" + driver.findElement(By.xpath("//div[@class=\"pricBreakup__total\"]//div//div[@class='pricBreakup__rht']//p")).getText() + "----");
            String totalAmountToBePaid = driver.findElement(By.xpath("(//p[@class='font16 latoBold'])[2]")).getText().replaceAll(",", "");
            String tax = driver.findElement(By.xpath("//div[@class=\"latoBold blackText makeFlex hrtlCenter\"]/../..//p[@class=\"latoBold\"]")).getText().replace(",", "");
            String roomType = driver.findElement(By.xpath("//div[@class=\"makeFlex spaceBetween\"]//h4")).getText();
            String roomFacility = driver.findElement(By.xpath("(//li[@class=\"incListItem\"]//div//span)[1]")).getText().replace(",", "");
            writeDataOnCSVFile2(hotelName, roomspace, totalAmountToBePaid, tax, "", roomType, roomFacility, "", "", "", "", "", "", "", "", "");

        } else if (driver.findElements(By.xpath("//p[text()='Not available for selected dates on MakeMyTrip']")).size() > 0) {
            String hotelName = driver.findElement(By.xpath("//div[@class=\"prmProperty \"]//h1")).getText().replace(",", "");

            writeDataOnCSVFile2(hotelName, "No room available", "", "", "Yes", "", "", "", "", "", "", "", "", "", "", "");
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
            System.out.println("--" + driver.findElement(By.xpath("(//p[@class=\"font16 latoBold\"])[1]")).getText() + "----");
            System.out.println("--" + driver.findElement(By.xpath("(//p[@class=\"font16 latoBold\"])[2]")).getText());
            System.out.println("---" + driver.findElement(By.xpath("//div[@class=\"latoBold blackText makeFlex hrtlCenter\"]")).getText());
            String totalAmountToBePaid = driver.findElement(By.xpath("(//p[@class='font16 latoBold'])[2]")).getText().replaceAll(",", "");
            System.out.println("--" + driver.findElement(By.xpath("//div[@class=\"latoBold blackText makeFlex hrtlCenter\"]/../..//p[@class=\"latoBold\"]")).getText());
            String tax = driver.findElement(By.xpath("//div[@class=\"latoBold blackText makeFlex hrtlCenter\"]/../..//p[@class=\"latoBold\"]")).getText().replace(",", "");
            String roomType = driver.findElement(By.xpath("//div[@class=\"makeFlex spaceBetween\"]//h4")).getText();
            String roomFacility = driver.findElement(By.xpath("(//div[@class=\"makeFlex spaceBetween\"]//li)[1]")).getText();
            writeDataOnCSVFile2(hotelName, roomspace, totalAmountToBePaid, tax, "", roomType, roomFacility, "", "", "", "", "", "", "", "", "");
        }


        Thread.sleep(1000);
        driver.quit();
    }

    public static void writeDataOnCSVFile2(String hotelName, String roomspace, String priceWithCoupon, String tax, String isSoldOut, String roomType, String roomFacility, String couponname1, String couponname2, String coupaonanme3, String cooupon1price, String cooupon2price, String cooupon3price, String coupon1des, String coupon2des, String coupon3des) {
        String filePath = "//Users//fabhotels//Downloads//FabHotels//src//test//resources//books_table3.csv";

        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(filePath), true))) {
            // If the file does not exist, write the header
            if (new File(filePath).length() == 0) {
                pw.append("HotelName,roomspace,PriceWithCoupon,HotelTaxes,SoldOut,roomtype,roomfacility,couponname1,couponname2,couponname3,cooupon1price,cooupon2price,cooupon3price,couponname1des,couponname2des,couponname3des\r\n");
            }
            // Write data to the file
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
            pw.append(cooupon1price).append(",");
            pw.append(cooupon2price).append(",");
            pw.append(cooupon3price).append(",");
            pw.append(coupon1des).append(",");
            pw.append(coupon2des).append(",");
            pw.append(coupon3des).append("\r\n");

            System.out.println("Data added successfully");
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., log it)
        }
    }
}

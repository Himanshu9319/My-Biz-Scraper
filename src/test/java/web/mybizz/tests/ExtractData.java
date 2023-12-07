package web.mybizz.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.Base;
import utilities.ExcelUtility;
import zmq.util.Draft;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.stream.StreamSupport;

public class ExtractData {

    @Test(dataProvider = "MyBizzUrl", dataProviderClass = ExcelUtility.class)
    public void hitUrlAndData(String str1, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) throws InterruptedException {
        System.out.println(str11);//5,9,10
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(str11);
        //li[@class="dlCodes__listItem whiteBg  itemSelectedNew "]//  coipon link
        //span[@class="dealCode__truncate overrideRtl"]..coupon texxt
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        if (driver.findElements(By.xpath("//span[@title=\"WELCOMEBACK1\"]")).size() > 0) {
            System.out.println("---Hotel Name---" + driver.findElement(By.xpath("//div[@class=\"htlInfo__dtlLeft\"]//h3")).getText() + "-----");
            System.out.println("----Before coupon price-----");
            System.out.println("--" + driver.findElement(By.xpath("//p[@class=\"latoBlack blackText\"]")).getText() + "----");
            System.out.println("--" + driver.findElement(By.xpath("//p[@class=\"latoBlack redText\"]")).getText());
            System.out.println("----Coupan details-----");
            String couponText = driver.findElement(By.xpath("//span[@title=\"WELCOMEBACK1\"]")).getText();
            System.out.println(couponText);
            String couponPrice = driver.findElement(By.xpath("[class=\"dealPrice latoBlack noShrink\"]")).getText();
            System.out.println(couponPrice);
            System.out.println("After removal coupon");
            driver.findElement(By.xpath("//span[@class=\"dlCodes__delete\"]")).click();
            System.out.println("--" + driver.findElement(By.xpath("//p[@class=\"latoBlack blackText\"]")).getText() + "----");
            System.out.println("--" + driver.findElement(By.xpath("//p[@class=\"latoBlack redText\"]")).getText());
        } else if (driver.findElements(By.xpath("//li[@class=\"dlCodes__listItem whiteBg  itemSelectedNew \"]")).size() > 0) {
            System.out.println("---Hotel Name---" + driver.findElement(By.xpath("//div[@class=\"rvHtlInfoLft\"]//h3")).getText() + "-----");
            System.out.println("Normal coupon");
            System.out.println(driver.findElement(By.xpath("//span[@class=\"dealCode__truncate overrideRtl\"]")).getText());
            driver.findElement(By.xpath("//span[@class=\"dlCodes__delete\"]")).click();
            System.out.println("--" + driver.findElement(By.xpath("//div[@class=\"pricBreakup__total\"]//div//div[@class='pricBreakup__lft']//p")).getText() + "----");
            System.out.println("--" + driver.findElement(By.xpath("//div[@class=\"pricBreakup__total\"]//div//div[@class='pricBreakup__rht']//p")).getText() + "----");

        } else {
            String hotelName = driver.findElement(By.xpath("//h3[@class=\"font22 latoBlack blackText\"]")).getText();

            System.out.println("---Hotel Name---" + driver.findElement(By.xpath("//h3[@class=\"font22 latoBlack blackText\"]")).getText() + "-----");
            System.out.println("---If no coupan is available on page---");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class=\"latoBold blackText\"]//span"))));
            String roomtype = "";
            for (int i = 0; i < driver.findElements(By.xpath("//p[@class=\"latoBold blackText\"]//span")).size(); i++) {
                roomtype = roomtype+" "+driver.findElements(By.xpath("//p[@class=\"latoBold blackText\"]//span")).get(i).getText();
                System.out.println("---" + roomtype);
            }
            System.out.println("--" + driver.findElement(By.xpath("(//p[@class=\"font16 latoBold\"])[1]")).getText() + "----");
            System.out.println("--" + driver.findElement(By.xpath("(//p[@class=\"font16 latoBold\"])[2]")).getText());
            System.out.println("---" + driver.findElement(By.xpath("//div[@class=\"latoBold blackText makeFlex hrtlCenter\"]")).getText());
            String totalAmountToBePaid =driver.findElement(By.xpath("(//p[@class='font16 latoBold'])[2]")).getText().replaceAll(",","");
            System.out.println("--" + driver.findElement(By.xpath("//div[@class=\"latoBold blackText makeFlex hrtlCenter\"]/../..//p[@class=\"latoBold\"]")).getText());
            String tax= driver.findElement(By.xpath("//div[@class=\"latoBold blackText makeFlex hrtlCenter\"]/../..//p[@class=\"latoBold\"]")).getText().replace(",","");
            writeDataOnCSVFile(hotelName,roomtype,totalAmountToBePaid,tax);
        }
        Thread.sleep(10000);
    }

    public static void writeDataOnCSVFile(String hotelName, String roomtype , String prieceWithCoupan , String tax) {
        try {
            PrintWriter pw = new PrintWriter(new File("//Users//fabhotels//Downloads//FabHotels//src//test//resources//books_table.csv"));
            StringBuilder sb = new StringBuilder();
            sb.append("HotelName");
            sb.append(",");
            sb.append("RoomType");
            sb.append(",");
            sb.append("PriceWithCoupan");
            sb.append(",");
            sb.append("HotelTaxes");
            sb.append("\r\n");
            sb.append(hotelName);
            sb.append(",");
            sb.append(roomtype);
            sb.append(",");
            sb.append(prieceWithCoupan);
            sb.append(",");
            sb.append(tax);
            pw.write(sb.toString());
            pw.close();
            System.out.println("finished");
        } catch (Exception e) {

        }
    }


}

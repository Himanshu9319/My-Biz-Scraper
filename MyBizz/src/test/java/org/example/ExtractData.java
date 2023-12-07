package org.example;

import com.google.common.collect.Table;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import static java.time.Duration.*;

public class ExtractData {

    public static void main(String[] args) throws IOException, InterruptedException {
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
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Hotels']")).click();
        Thread.sleep(3000);


        //using action class
//        Actions action = new Actions(driver);
//        action.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']"))
//        ).click().perform();
//        //using wait--

//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']"))));

        driver.findElement(By.xpath("//button[text()='Search']")).click();

        //calling the method
        Thread.sleep(5000);
        // int size = driver.findElements(By.xpath("//div[@class=\"makeFlex flexOne padding20 relative lftCol\"]")).size();
        for (int i = 0; i < driver.findElements(By.xpath("//div[@class=\"makeFlex flexOne padding20 relative lftCol\"]")).size(); i++) {
            System.out.println("--START START--");
            //  if (i == 1) {
            driver.findElements(By.xpath("//div[@class=\"makeFlex flexOne padding20 relative lftCol\"]")).get(i).click();
            Thread.sleep(10000);
            String parent = driver.getWindowHandle();
            Set<String> s = driver.getWindowHandles();
            Iterator<String> I1 = s.iterator();
            while (I1.hasNext()) {
                String child_window = I1.next();
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);
                    System.out.println(driver.switchTo().window(child_window).getTitle());
                    try {
                        System.out.println("Hotel Name-----" + driver.findElement(By.xpath("//span[@data-testid=\"phName\"]")).getText());
                    } catch (Exception e) {
                        try {
                            System.out.println("Hotel Name-----" + driver.findElement(By.xpath("//div[@class=\"prmProperty \"]")).getText());
                        } catch (Exception k) {
                            System.out.println("Hote name--" + driver.findElement(By.xpath("//h1[@class=\"font26 blackText latoBlack appendBottom10\"]")).getText());
                        }
                    }

                    try {
                        System.out.println("Hotel rating---" + driver.findElement(By.xpath("//span[@class=\"prmHtlRating__ratingBx--value\"]")).getText());
                    } catch (Exception e) {
                        System.out.println("Hotel rating--" + driver.findElement(By.xpath("//div[@class=\"prmRatingCard__rating makeRelative blueBg\"]")).getText());
                    }
                    try {
                        System.out.println("Hotel addrsss and location--" + driver.findElement(By.xpath("//span[@class=\"font18 latoBlack blackText\"]")).getText());
                    } catch (Exception e) {
                        System.out.println(driver.findElement(By.xpath("//p[@class=\"latoBold makeFlex\"]")).getText());
                    }
                    System.out.println(" Value for Money- " + driver.findElement(By.xpath("(//span[text()='Property Highlights'])[1]")).getText());
                    System.out.println("Reviews--" + driver.findElement(By.xpath("(//a[@class=\"blueText latoBold font12 lineHight14\"])[1]")).getText());
                    try {
                        System.out.println(" Breakfast- " + driver.findElement(By.xpath("(//span[text()='Property Highlights'])[2]")).getText());
                    } catch (Exception e) {
                        System.out.println(" Breakfast- " + driver.findElement(By.xpath("(//span[@class=\"font16 lineHight22 latoBlack\"])[2]")).getText());
                        System.out.println("Review--" + driver.findElement(By.xpath("(//a[@class=\"blueText latoBold font12 lineHight14\"])[2]")).getText());
                    }

                    System.out.println("Reviews--" + driver.findElement(By.xpath("(//a[@class=\"blueText latoBold font12 lineHight14\"])[2]")).getText());
                    System.out.println(" Room Quality-- " + driver.findElement(By.xpath("(//span[text()='Property Highlights'])[1]")).getText());
                    System.out.println("Reviews--" + driver.findElement(By.xpath("(//a[@class=\"blueText latoBold font12 lineHight14\"])[1]")).getText());
                    Thread.sleep(2000);
                    System.out.println("------Benifits--------");
                    for (int j = 0; j < driver.findElements(By.xpath("//span[@class=\"prtyHglt__content--featureText\"]")).size(); j++) {
                        System.out.println(driver.findElements(By.xpath("//span[@class=\"prtyHglt__content--featureText\"]")).get(j).getText());
                    }
                    Thread.sleep(2000);
                    // System.out.println("----"+driver.findElement(By.xpath("//p[@id=\"detpg_headerright_room_type\"]")).getText()+"-------");
                    //  System.out.println(driver.findElement(By.xpath("//span[@class=\"bkng__capacity\"]")).getText());
                    try {
                        System.out.println(driver.findElement(By.xpath("//span[@class=\"latoBold redText\"]")).getText());
                    } catch (Exception e) {
                        System.out.println(driver.findElement(By.xpath("//span[@class=\"latoBold greenText\"]")));
                    }
                    //   System.out.println(driver.findElement(By.xpath("(//p[@class=\"roomOfferings__item--text\"])[2]")).getText());
                    System.out.println("----" + driver.findElement(By.xpath("//p[@class=\"font10 grayText appendBottom3\"]")).getText() + "----");
                    System.out.println("------" + driver.findElement(By.xpath("//p[@id=\"detpg_headerright_room_price\"]")).getText());
                    System.out.println(driver.findElement(By.xpath("(//span[@class=\"latoBlack blackText\"])[1]")).getText());
                    try {
                        System.out.println(driver.findElement(By.xpath("//p[@class=\"font11 redText lineHight14 latoBold\"]")).getText());
                    } catch (Exception e) {
                        System.out.println(driver.findElement(By.xpath("(//span[@class=\"latoBlack blackText\"])[1]")).getText());
                        System.out.println(driver.findElement(By.xpath("//p[@class=\"font11 appendBottom7\"]")).getText());
                    }
                    driver.close();
                    driver.switchTo().window(parent);
                }
                // driver.findElement(By.xpath("//button[@data-cy='submit']")).click();
            }
            System.out.println("--THE END--");

            // }
        }
    }


   /* public static void write_data_in_excel() {
        String filePath = "/Users/fabhotels/Downloads/FabHotels/MyBizz/src/test/MyBizHotelData.xlsx";
        Workbook workbook = new XSSFWorkbook(); // for .xlsx format
        Sheet sheet = workbook.createSheet("MySheet");


        String[] data = {"Name", "Age", "City"};

        // Create the header row
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < data.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(data[i]);
        }

        // Create data rows
        String[][] rowData = {
                {"John Doe", "30", "New York"},
                {"Jane Smith", "25", "Los Angeles"},
                {"Bob Johnson", "35", "Chicago"}
        };

        for (int i = 0; i < rowData.length; i++) {
            Row row = sheet.createRow(i + 1); // Start from the second row (index 1)
            for (int j = 0; j < rowData[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(rowData[i][j]);
            }
        }

        try {
            // Write the Excel data to the specified file path
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();
            System.out.println("Data has been written to the Excel file at " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}









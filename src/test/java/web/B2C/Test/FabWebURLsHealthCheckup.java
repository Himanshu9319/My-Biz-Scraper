package web.B2C.Test;

import com.aventstack.extentreports.Status;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Base;
import utilities.CommonFunctionsWeb;
import utilities.Email;
import utilities.ExcelUtility;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static utilities.CommonFunctionsWeb.*;

//@Listeners(utilities.CustomListeners.class)
public class FabWebURLsHealthCheckup extends Base {

    static SoftAssert softAssert = new SoftAssert();
    static ArrayList<Object> TwoXX = new ArrayList<>();
    static ArrayList<String> OtherXX = new ArrayList<>();
    static ArrayList<Object> linksOfStaleElement = new ArrayList<>();

    @Test(enabled = true, priority = 1, description = "Fabhotels url's", dataProvider = "FBWebURL", dataProviderClass = ExcelUtility.class)
    public static void hitFabURL(String url) throws InterruptedException, IOException {
//        openURLWithMobileView(url);
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        System.out.println("Count of Links using FabHome Page" + links.size());
//        ArrayList<Object> enf = new ArrayList<>();
//        String internalUrl = "";
//        for (WebElement link : links) {
//            try {
//                internalUrl = link.getAttribute("href");
//            } catch (StaleElementReferenceException e) {
//                linksOfStaleElement.add(link);
//            } catch (Exception e) {
//                enf.add(internalUrl);
//            }
//            if (internalUrl != null && !internalUrl.isEmpty()) {
//                int isWorking = isURLWorking(internalUrl);
////                if (isWorking == 200) {
////                    TwoXX.add("URL: " + internalUrl + " is working? " + isWorking);
////
////                    Email.sendEmail(0, 0, 0, 0);
////                } else {
////                    OtherXX.add("URL: " + internalUrl + " is working? " + isWorking);
////                }
//                softAssert.assertEquals(200, isWorking, internalUrl);
//
//            }
//        }
//        softAssert.assertAll();
//        System.out.println(TwoXX);
//        System.out.println(OtherXX);
//        System.out.println(linksOfStaleElement);
        //java tes  testLevelReport.get().log(Status.INFO, url + "");
        int stausCode = isURLWorking(url);
        if (stausCode != 200) {
            TwoXX.add(stausCode + "  " + url);
        }
//        softAssert.assertEquals(200, stausCode, url);
//        softAssert.assertAll();


    }

//    @AfterClass
//    public static Object createMenthodBody() throws MessagingException {
//        // Create object to add multimedia type content
//        System.out.println("---" + TwoXX.size());
//        BodyPart messageBodyPart1 = new MimeBodyPart();
//        StringBuilder messageContent = new StringBuilder();
//        for (int i = 0; i < TwoXX.size(); i++) {
//            messageContent.append(TwoXX.get(i));
//            messageBodyPart1.setText(String.valueOf(TwoXX));
//        }
//        Email.emailSend("", messageBodyPart1);
//        return messageBodyPart1;
//    }

    @AfterClass
    public static Object createMenthodBody() throws MessagingException {
        // Create object to add multimedia type content
        System.out.println("---" + TwoXX.size());
        BodyPart messageBodyPart1 = new MimeBodyPart();

        StringBuilder messageContent = new StringBuilder();

        for (int i = 0; i < TwoXX.size(); i++) {
            messageContent.append(TwoXX.get(i));
            if (i < TwoXX.size() - 1) {
                // Add a newline character if it's not the last element
                messageContent.append("\n");
            }
        }

        messageBodyPart1.setText(messageContent.toString());
        Email.emailSend("", messageBodyPart1);
        return messageBodyPart1;
    }

    private static int isURLWorking(String url) throws IOException {
        try {
            if (property.getProperty("ismobileview").equalsIgnoreCase("Yes")) {
                System.setProperty("http.agent", "Mozilla/5.0 (Linux; Android 8.0.0; SM-G955U Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Mobile Safari/537.36");
            }
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            return responseCode;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}

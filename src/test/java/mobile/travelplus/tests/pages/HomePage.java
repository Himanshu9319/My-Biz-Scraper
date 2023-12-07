package mobile.travelplus.tests.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.CommonFunctionsMobile;

import static utilities.CommonFunctionsMobile.getMobElement;
import static utilities.CommonFunctionsMobile.iosDriver;

public class HomePage {

    CommonFunctionsMobile commonFunctionsMobile = new CommonFunctionsMobile();
    public static AndroidDriver androidDriver;
  //  public static By randomclik = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
   // WebElement element = androidDriver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));

    public void scrollScreen() throws Exception {
        String elementPath = "Login/paymentpendingscroll";
        commonFunctionsMobile.swipe(androidDriver.findElement(By.xpath("//android.widget.SeekBar[@content-desc=\"Bottom Sheet handle\"]/android.view.ViewGroup/android.view.ViewGroup")), "down");
    }

//    public void randomClick() throws Exception {
//        String elementPath = "HomePage/randomclick";
//        WebElement webElement = CommonFunctionsMobile.getElementWhenVisible(randomclik, 10);
//        webElement.click();
//    }

    public void clickOncreateTrip() throws Exception {
        String elementPath = "HomePage/createbutton";
        CommonFunctionsMobile.clickbyXpath(elementPath);
    }

    public void addFlight() throws Exception {
        String elementPath="HomePage/addflight";
        CommonFunctionsMobile.clickbyXpath(elementPath);
    }

    public void selectDate() throws Exception {
        String elementPath="HomePage/depaturedate";
        String caleander ="HomePage/date";
        CommonFunctionsMobile.clickbyXpath(elementPath);
        String text="25 November 2023";
        CommonFunctionsMobile.clickbyXpath(caleander);
    }
}

package mobile.travelplus.tests.pages;


import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import utilities.CommonFunctionsMobile;

import static mobile.travelplus.tests.pages.HomePage.androidDriver;
import static utilities.CommonFunctionsMobile.iosDriver;

public class LoginPage {

    public static void login(String username) throws Exception {
        String elementPath = "Login/EmailInputField";
        CommonFunctionsMobile.sendKeys(elementPath, username);
    }

    public static void clickOnSendButton() throws Exception {
        String elementPath = "Login/SendOtpAction";
        CommonFunctionsMobile.clickbyXpath(elementPath);
    }

    public static void validateCreateTripButton(){
        String elementPath ="Login/createtriptext";
  // CommonFunctionsMobile.ge
    }

    public static void  enterOtp(String otp) throws Exception {
        String elementPath = "Login/otp1";
        CommonFunctionsMobile.sendKeys(elementPath, otp);

    }

    public static void entersecondotpdigit(String otp) throws Exception {
        String elementPath = "Login/otp2";
        CommonFunctionsMobile.sendKeys(elementPath, otp);
    }

    public static void enterthreeotpdigit(String otp) throws Exception {
        String elementPath = "Login/otp3";
        CommonFunctionsMobile.sendKeys(elementPath, otp);
    }

    public static void enterfourthotpdigit(String otp) throws Exception {
        String elementPath = "Login/otp4";
        CommonFunctionsMobile.sendKeys(elementPath, otp);
    }

    public static void enterfifthotpdigit(String otp) throws Exception {
        String elementPath = "Login/otp5";
        CommonFunctionsMobile.sendKeys(elementPath, otp);
    }

    public static void entersixthotpdigit(String otp) throws Exception {
        String elementPath = "Login/otp6";
        CommonFunctionsMobile.sendKeys(elementPath, otp);
    }

    public static void clickonproceedbutton() throws Exception {
        String elementPath = "Login/prceedbutton";
        CommonFunctionsMobile.clickbyXpath(elementPath);

    }
}

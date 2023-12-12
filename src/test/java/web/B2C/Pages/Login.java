package web.B2C.Pages;

import org.openqa.selenium.By;
import utilities.CommonFunctionsWeb;

public class Login {

    private static By LoginAndSignUpButton = By.xpath("//span[@class=\"login-btn flex vertical-center\"]");
    private static By loginAndSignUpPop = By.xpath("//div[@class=\"login-modal\"]");
    private static By mobilenoinputField = By.xpath("//input[@id=\"phone-number\"]");
    private static By continueButton = By.xpath("//div[@class=\"login-modal\"]//button");
    private static By otpinputfield = By.xpath("//input[@id=\"otpInput\"]");
    private static By otpsection = By.xpath("//div[@class=\"otp-section otp_form\"]//button");
    private static By selectRoom = By.xpath("//span[@class='btn select_room_cta select-room-cta']");
    private static By clickOnHotel = By.xpath("//h3[@class='hotel-name']//a");

    private static By getstartedButton = By.xpath("//div[@class=\"otp-section otp_form\"]//button");


    public static void loginwithphoneno(String phoneno) {
        CommonFunctionsWeb.click(LoginAndSignUpButton, "Click on login and sign up button");
        CommonFunctionsWeb.waitForVisibility(loginAndSignUpPop);
        CommonFunctionsWeb.enterCharacter(mobilenoinputField, phoneno, "Enter phone no");
        CommonFunctionsWeb.click(continueButton, "");
        CommonFunctionsWeb.enterCharacter(otpinputfield, "123456", "");
        CommonFunctionsWeb.click(getstartedButton,"");
    }

}

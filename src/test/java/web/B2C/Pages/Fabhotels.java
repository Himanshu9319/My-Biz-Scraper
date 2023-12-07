package web.B2C.Pages;

import org.openqa.selenium.By;
import utilities.CommonFunctionsWeb;

public class Fabhotels {

    private static By LoginAndSignUpButton = By.xpath("//span[@class=\"login-btn flex vertical-center\"]");
    private static By loginAndSignUpPop = By.xpath("//div[@class=\"login-modal\"]");
    private static By mobilenoinputField = By.xpath("//input[@id=\"phone-number\"]");
    private static By continueButton = By.xpath("//div[@class=\"form-wrap\"]//button");
    private static By otpinputfield = By.xpath("//input[@id=\"otpInput\"]");
    private static By otpsection = By.xpath("//div[@class=\"otp-section otp_form\"]//button");
    private static By selectRoom = By.xpath("//span[@class='btn select_room_cta select-room-cta']");
    private static By clickOnHotel = By.xpath("//h3[@class='hotel-name']//a");


    public static void clickOnLoginAndSignUpButton() {
        CommonFunctionsWeb.click(LoginAndSignUpButton, "Click on login and sign up button");
        CommonFunctionsWeb.waitForVisibility(loginAndSignUpPop);
    }

    public static void enterMobileno() {
        CommonFunctionsWeb.enterCharacter(mobilenoinputField, "8375030612", "");
    }

    public static void clickOnContinueButton() {
        CommonFunctionsWeb.click(continueButton, "");
    }

    public static void entersOtp() {
        CommonFunctionsWeb.enterCharacter(otpinputfield, "123456", "");
    }

    public static void clickGetStartedButton() {
        CommonFunctionsWeb.click(otpsection, "Click on otp section button");
    }

    public static void selectRoom() throws InterruptedException {
        CommonFunctionsWeb.click(clickOnHotel, "Click on first hotel");

    }


}

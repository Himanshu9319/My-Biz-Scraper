package web.admin.pages;

import org.openqa.selenium.By;
import utilities.CommonFunctionsWeb;

public class Logout {

    private static By companyName = By.xpath("//span[@class=\"company-name\"]");

    private static By logoutbutton = By.xpath("//div[@class=\"user-menu\"]//span");

    private static By loginpage = By.xpath("//div[@class=\"middle-section-login\"]");

    private static By send_otp_button = By.cssSelector("[class='submit-btn']");


    public static void logoutapplication() {
        CommonFunctionsWeb.isElementDisplayed(companyName, "Company name");
        CommonFunctionsWeb.click(companyName, "Logout button");
        CommonFunctionsWeb.click(logoutbutton, "Login page");
        CommonFunctionsWeb.isElementDisplayed(send_otp_button, "Login page");
    }

}

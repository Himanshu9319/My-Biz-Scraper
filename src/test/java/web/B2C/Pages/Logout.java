package web.B2C.Pages;

import org.openqa.selenium.By;
import utilities.CommonFunctionsWeb;

public class Logout {


    private static By userinfoiconelement = By.xpath("//span[@class=\"flex column user-info\"]");

    private static By logoutButton = By.xpath("//button[text()='Logout']");

    private static By loginsignuptext = By.xpath("//span[@class=\"login-btn flex vertical-center\"]");

    public static void logoutB2chotelpage() throws InterruptedException {
        CommonFunctionsWeb.click(userinfoiconelement, "Click on user info element");
        CommonFunctionsWeb.click(logoutButton, "Click on logout button");

    }


}

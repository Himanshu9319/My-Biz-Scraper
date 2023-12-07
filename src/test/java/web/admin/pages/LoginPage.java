package web.admin.pages;

import org.openqa.selenium.By;
import utilities.CommonFunctionsWeb;

public class LoginPage {

    public static By login_input = By.xpath("//input[@id=\"email\"]");
    public static By send_otp_button = By.xpath("//button[@class=\"submit-btn\"]");
    public static By input_1 = By.xpath("//input[@name=\"input_1\"]");
    public  static By input_2 = By.xpath("//input[@name=\"input_2\"]");
    public static By input_3 = By.xpath("//input[@name=\"input_3\"]");
    public static By input_4 = By.xpath("//input[@name=\"input_4\"]");
    public static By input_5 = By.xpath("//input[@name=\"input_5\"]");
    public static By input_6= By.xpath("//input[@name=\"input_6\"]");
    public static By submit_button=By.xpath("//button[@class=\"submit-btn \"]");
    public static By main_setion  = By.xpath("//div[@class=\"wrapper-table\"]");
    public static By userpopp = By.xpath("//div[@class=\"user-menu-wrapper\"]");
    public static By booknow_element =By.xpath("//div[@title=\"Book now\"]");


    public static void loginapplication(String username, String password) throws InterruptedException {
        CommonFunctionsWeb.enterCharacter(login_input, username, password);
        CommonFunctionsWeb.click(send_otp_button,"Send otp button");
        CommonFunctionsWeb.waitForVisibility(submit_button);
        CommonFunctionsWeb.enterCharacter(input_1,"1","");
        CommonFunctionsWeb.enterCharacter(input_2,"2","");
        CommonFunctionsWeb.enterCharacter(input_3,"3","");
        CommonFunctionsWeb.enterCharacter(input_4,"4","");
        CommonFunctionsWeb.enterCharacter(input_5,"5","");
        CommonFunctionsWeb.enterCharacter(input_6,"6","");
        CommonFunctionsWeb.waitForElementToBeClikable(submit_button);
        CommonFunctionsWeb.click(submit_button,"SubmitButton");
        CommonFunctionsWeb.pageContainUrl("/admin/orion/travel/requests/pending");
        CommonFunctionsWeb.waitForVisibility(booknow_element);
        CommonFunctionsWeb.isElementDisplayed(main_setion,"Main_Page");
    }

}

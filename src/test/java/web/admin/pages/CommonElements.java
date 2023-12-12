package web.admin.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.CommonFunctionsWeb;

public class CommonElements {

    public static By employeenamefield = By.xpath("//input[@data-testid=\"multisuggest-input\"]");
    public static By continue_button = By.xpath("//button[text()='Continue']");
    public static By paymentmodeelement = By.xpath("//div[@class=\"payment-mode-title\"]/following-sibling::div//span");
    public static By confirmBookingElement = By.xpath("//button[text()='Confirm booking']");

    public static By voucheDownloadPage = By.xpath("//div[@class=\"content-wrapper\"]");

    public static By confirmationtitle = By.xpath("//span[@class=\"title\"]");

    public static By travellerName = By.xpath("//span[@class=\"name\"]");

    public static By flight_Name = By.xpath("//span[@class=\"flight-name\"]");

    public static By pnr = By.xpath("//div[@class=\"PNR\"]");

    public static By bookingElement = By.xpath("//div[@title=\"Bookings\"]");

    public static By traveller_details_poup = By.xpath("//div[@class=\"modal-main guest-modal\"]");

    public static By tripstatus = By.xpath("//span[@class='status ']");
    public static By gstElement = By.xpath("//span[text()='GST selection is mandatory for booking']");

    public static By gstDropDown = By.xpath("//div[@class=\"dropdown-heading\"]");

    public static By gstCompnay = By.xpath("(//div[@class='entityName'])[2]");

    public static By guestTypeDropDownElement = By.xpath("(//div[@class=\"dropdown-heading-value\"])[2]");

    public static By lastNameElement = By.xpath("//input[@id=\"lastName\"]");

    public static By mobile_no = By.xpath("//input[@name=\"mobile\"]");

    public static By emailelement = By.xpath("//input[@id=\"email\"]");
    public static By error_message = By.xpath("//span[@class=\"error-message\"]");
    public static By pop_up_continue_button = By.xpath("//div[@class=\"btn-row\"]//button");

    public static By addasaguestelement = By.xpath("//span[text()='Add as guest']");



    public static String getPaymentmodetect() throws InterruptedException {
        Thread.sleep(5000);
        return CommonFunctionsWeb.getText(paymentmodeelement, "Payment mode type");
    }

    public static String getTravellerName() {
        return CommonFunctionsWeb.getText(travellerName, "GET Traveller name");
    }

    public static String getFlightName() {
        return CommonFunctionsWeb.getText(flight_Name, "Flight name");
    }









    public static void isPnrIsDisplayed() {
        try {
            CommonFunctionsWeb.isElementDisplayed(pnr, "PNR NO");
        } catch (Exception e) {
            Assert.fail("PNR NO IS NOT GENERATED");
        }
    }



    public static void selectGSt() {
        if (CommonFunctionsWeb.getElements(gstElement).size() > 0) {
            CommonFunctionsWeb.click(gstDropDown, "Click on gst dropdown");
            CommonFunctionsWeb.click(gstCompnay, "Select gst company");
        }
    }

    public static void fillTravellerForm(String employeelastname, String phoneno, String email) {
        CommonFunctionsWeb.waitForVisibility(guestTypeDropDownElement);
        CommonFunctionsWeb.enterCharacter(lastNameElement, employeelastname, "Enter email");
        CommonFunctionsWeb.enterCharacter(mobile_no, phoneno, "Enter mobile no");
        CommonFunctionsWeb.enterCharacter(emailelement, email, "Enter email");
        if (CommonFunctionsWeb.getElements(error_message).size() > 0) {
            CommonFunctionsWeb.enterCharacter(lastNameElement, employeelastname, "Enter email");
            CommonFunctionsWeb.enterCharacter(mobile_no, phoneno, "Enter mobile no");
            CommonFunctionsWeb.enterCharacter(emailelement, email, "Enter email");
        }
        CommonFunctionsWeb.click(pop_up_continue_button, "Click On Continue button");
    }

    public static void clickOnAddAsAGuest(){
        CommonFunctionsWeb.waitForVisibility(addasaguestelement);
        CommonFunctionsWeb.click(addasaguestelement,"Click on add as a guest");
    }





}

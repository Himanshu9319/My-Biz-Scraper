package web.B2C.Pages;

import org.openqa.selenium.By;
import utilities.CommonFunctionsWeb;

public class Bookingconfrimationpage {
    private static By paymentconfirmationElement = By.xpath("//div[@class=\"payment-box\"]");
    private static By hotelname = By.xpath("//div[@class=\"room-detail-box\"]//h3");
    private static By checkindate = By.xpath("//div[@class=\"checkin-content\"]//strong");
    private static By checkoutdate = By.xpath("//div[@class=\"checkout-content\"]//strong");
    private static By guestCount = By.xpath("//div[@class=\"guest-content\"]//strong");
    private static By confirmationMessage = By.xpath("//span/following-sibling::h3");
    private static By totoalPayableAmount = By.xpath("//span[@class=\"total-price\"]");

    public static void validateConfirmationPage(){
        CommonFunctionsWeb.waitForVisibility(paymentconfirmationElement);
        CommonFunctionsWeb.isElementDisplayed(paymentconfirmationElement,"Confirmation page");
    }

    public static String actualHotelname(){
        return CommonFunctionsWeb.getText(hotelname,"Hotel Name");
    }

    public static String actualcheckindate(){
        return CommonFunctionsWeb.getText(checkindate,"Hotel Name");
    }

    public static String actualcheckOutdate(){
        return CommonFunctionsWeb.getText(checkoutdate,"Hotel Name");
    }

    public static String actualGuestCount(){
        return CommonFunctionsWeb.getText(guestCount,"Hotel Name");
    }

    public static String confirmationMessage(){
        CommonFunctionsWeb.scrollTillElement(confirmationMessage);
        return CommonFunctionsWeb.getText(confirmationMessage,"");
    }

    public static void totapPayAbleAmount(){
        CommonFunctionsWeb.isElementDisplayed(totoalPayableAmount,"Total payable amount");
    }

}

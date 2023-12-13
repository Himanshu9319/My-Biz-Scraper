package web.B2C.Pages;

import org.openqa.selenium.By;
import utilities.CommonFunctionsWeb;

import static utilities.CommonFunctionsWeb.scrollDown;

public class HotelBookingPage {

    private static By searchHotel = By.cssSelector("[name='Enter a City, Locality or Landmark']");
    private static By hotelName = By.xpath("//span[@class='heading']");
    private static By searchwrapper = By.xpath("//div[@class=\"search-wrapper\"]");
    private static By guest_name = By.xpath("//span[@class=\"guest-name\"]");
    private static By guestList = By.cssSelector("[class=\"list-wrapper dropdown-effect\"]");
    private static By searchButton = By.xpath("//div[@class=\"search-bottom\"]");
    private static By fablogo = By.xpath("//a[@class=\"main-logo\"]");
    private static By filterElement = By.xpath("//div[@class=\"range-slider-wrapper\"]");
    private static By pricecontainerfilterTitle = By.xpath("//div[@class=\"price-container price_container\"]");
    private static By brandtypefilter = By.xpath("//div[@id=\"brand_type_filter\"]");
    private static By brandFilterTitle = By.xpath("//div[@class=\"fab-brands\"]/strong");
    private static By hotelListElement = By.xpath("//h3[@class='hotel-name']");
    private static By searchButtonTextElement = By.xpath("//button[@class=\"btn search_form_button\"]");
    private static By quickBookButtonElement = By.xpath("(//div[@class='hotel-content-wrap']//span[@class='btn quick-book quick_book'])[1]");
    private static By quickhotelNameElement = By.xpath("(//span[@class=\"btn quick-book quick_book\"]/../../..//h3[@class=\"hotel-name\"])[1]");
    private static By hotelNameOnPaymentBox = By.xpath("//div[@class=\"room-detail-box\"]//h3");
    private static By checkInDateElement = By.xpath("//div[@class=\"checkin-content\"]//strong");
    private static By checkOutDateElement = By.xpath("//div[@class=\"checkout-content\"]//strong");

    private static By payathotel = By.xpath("//span[text()='Pay@Hotel']/..");

    private static By otpContainer = By.xpath("//div[@class=\"otp-container review_otp_container active-opt-modal\"]");

    private static By otp1 = By.xpath("(//input[@name=\"Payment[OTP]\"])[1]");
    private static By otp2 = By.xpath("(//input[@name=\"Payment[OTP]\"])[2]");
    private static By otp3 = By.xpath("(//input[@name=\"Payment[OTP]\"])[3]");
    private static By otp4 = By.xpath("(//input[@name=\"Payment[OTP]\"])[4]");
    private static By otp5 = By.xpath("(//input[@name=\"Payment[OTP]\"])[5]");
    private static By otp6 = By.xpath("(//input[@name=\"Payment[OTP]\"])[6]");
    private static By confirmBooking = By.xpath("//button[@class=\"confirm-booking otp_confirm_booking\"]");
    private static By quickHotelBookingElement = By.xpath("//a[contains(text(),'FabHotel The Daffodils')]/../../..//span[@class=\"btn quick quick_book\"]");
    private static By selectFabHotelTheDaffodilsElement = By.xpath("//a[contains(text(),'FabHotel The Daffodils')]/../../..//span[@class=\"btn select_room_cta select-room-cta\"]");
    private static By booknowbutton = By.xpath("//span[@class=\"book_now\"]");


    public static void select_guest(String guest) {
        CommonFunctionsWeb.waitForVisibility(guestList);
        CommonFunctionsWeb.click(By.xpath("//span[text()='" + guest + "']"), "Select Guest");
    }

    public static void selectCity(String city) throws InterruptedException {
        CommonFunctionsWeb.waitForVisibility(guest_name);
        CommonFunctionsWeb.enterCharacter(searchHotel, city, "Enter hotel name");
        CommonFunctionsWeb.hardwait(1);
        CommonFunctionsWeb.waitForVisibility(searchwrapper);
        for (int i = 0; i < CommonFunctionsWeb.getElements(hotelName).size(); i++) {
            if (CommonFunctionsWeb.getElements(hotelName).get(i).getText().equalsIgnoreCase(city)) {
                CommonFunctionsWeb.getElements(hotelName).get(i).click();
            }
        }
    }

    public static void clickOnSearchButton() {
        CommonFunctionsWeb.isElementDisplayed(searchButton, "Check visibility of search button");
        CommonFunctionsWeb.click(searchButton, "Search button");
    }

    public static void validateFabhotelsLogo() {
        CommonFunctionsWeb.isElementDisplayed(fablogo, "Visibility of fab logo");
    }

    public static void validateFilter() {
        CommonFunctionsWeb.isElementDisplayed(filterElement, "Filter element is displayed");
    }

    public static String filterTitle() {
        return CommonFunctionsWeb.getText(pricecontainerfilterTitle, "");
    }

    public static String brandfiltertype() {
        CommonFunctionsWeb.isElementDisplayed(brandtypefilter, "Brandtype filter");
        return CommonFunctionsWeb.getText(brandFilterTitle, "Actual brand filter title");
    }

    public static boolean totalhotelList() {
        int size = CommonFunctionsWeb.getElements(hotelListElement).size();
        return size > 0;
    }

    public static String validatesearchButton() {
        return CommonFunctionsWeb.getText(searchButtonTextElement, "Search Button text");
    }

    public static void clickOnQuickBookButton() {
        CommonFunctionsWeb.waitForElementToBeClikable(quickBookButtonElement);
        CommonFunctionsWeb.clickUsingJS(quickBookButtonElement);
    }

    public static String getHotelName() {
        return CommonFunctionsWeb.getText(quickhotelNameElement, "QuickBookHotelName");
    }

    public static String getHotelNameOnPaymentBox() {
        return CommonFunctionsWeb.getText(hotelNameOnPaymentBox, "Hotel name on payment box");
    }

    public static String getCheckIndate() {
        return CommonFunctionsWeb.getText(checkInDateElement, "Get check in date");
    }

    public static String getCheckOutDate() {
        return CommonFunctionsWeb.getText(checkOutDateElement, "Get actual checkout date");
    }

    public static void clickOnPayAtHotel() {
        CommonFunctionsWeb.click(payathotel, "Click on pay at hotel");
        CommonFunctionsWeb.waitForVisibility(otpContainer);
    }

    public static void enterotp() {
        CommonFunctionsWeb.enterCharacter(otp1, "1", "Enter otp");
        CommonFunctionsWeb.enterCharacter(otp2, "2", "Enter otp");
        CommonFunctionsWeb.enterCharacter(otp3, "3", "Enter otp");
        CommonFunctionsWeb.enterCharacter(otp4, "4", "Enter otp");
        CommonFunctionsWeb.enterCharacter(otp5, "5", "Enter otp");
        CommonFunctionsWeb.enterCharacter(otp6, "6", "Enter otp");
    }

    public static void clickOnQuickButtonOfHotelFabHotelTheDaffodils() {
        CommonFunctionsWeb.click(quickHotelBookingElement, "Click On quick hotel booking");
    }

    public static void clickonselctroomwithgivenhotel(String hotelname) throws InterruptedException {
        //CommonFunctionsWeb.waitForVisibility(hotelListElement);
        //CommonFunctionsWeb.scrollTillElement(By.xpath("//a[contains(text(),'" + hotelname + "')]"));
        scrollDown();
        CommonFunctionsWeb.clickUsingJS(By.xpath("//a[contains(text(),'" + hotelname + "')]/../../..//span[@class=\"btn select_room_cta select-room-cta\"]"));

    }

    public static void clickOnBookNowButton() {
        CommonFunctionsWeb.isElementDisplayed(booknowbutton, "Book now button");
        CommonFunctionsWeb.click(booknowbutton, "Click on book now button");
    }

    public static void clickOnConfirmButton() {
        CommonFunctionsWeb.click(confirmBooking, "");
    }


}

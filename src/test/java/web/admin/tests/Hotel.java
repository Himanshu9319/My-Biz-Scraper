package web.admin.tests;

import UtilsAPI.HotelBooking.responseDto.Create.DailyRatePlanPrice;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Base;
import utilities.DriverManager;
import utilities.ExcelUtility;
import utilities.TestUtilities;

import java.io.IOException;
import java.util.Properties;

import static utilities.CommonFunctionsWeb.loadPageWithRetry;
import static utilities.CommonFunctionsWeb.openURL;
import static web.admin.pages.Hotel.*;
import static web.admin.pages.LoginPage.loginapplication;
import static web.admin.pages.Logout.logoutapplication;

@Listeners(utilities.CustomListeners.class)
public class Hotel extends Base {
    Properties properties = TestUtilities.loadConfigProperties();
    public static String bookingId;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void login() throws InterruptedException {
        openURL();
        loginapplication(properties.getProperty("username"), "");
    }

    @AfterMethod
    public void logout() {
        loadPageWithRetry(Base.property.getProperty("openurl"));
        logoutapplication();
    }

    @Test(enabled = true, priority = 2, description = "Open Travel plus Web Application", dataProvider = "excel-data", dataProviderClass = ExcelUtility.class)
    public void book_hotel_with_BTC_payment_type(String cityname, String employeename, String emplolastname, String phonno, String emailid, String checkindate, String checkoutDate, String bookingstatus) throws InterruptedException, IOException {
        clickOnBookNowButton();
        enterHotelDetails(cityname, employeename, checkindate, checkoutDate);
        String expectedHotelName = selectHotel();
        String actualBookingStatus = paymentUsingBTC(emplolastname, phonno, emailid, bookingstatus);
        String actualPaymentMode = getPaymentmodetext();
        String actualHotelName = actualHotelName();
        isBookingIdIsDisplayed();
        String fullExpectedCheckInDateAndCheckoutDate = getExpectedCheckInDateAndCheckoutDate(checkindate, checkoutDate);
        String actualCheckInAndCheckOutDate = actualCheckInAndCheckoutDate();
        softAssert.assertEquals(actualCheckInAndCheckOutDate, fullExpectedCheckInDateAndCheckoutDate);
        softAssert.assertEquals(actualHotelName, expectedHotelName);
        softAssert.assertEquals(actualCheckInAndCheckOutDate, fullExpectedCheckInDateAndCheckoutDate);
        softAssert.assertNotNull(getBookingId());
        softAssert.assertEquals(actualBookingStatus, bookingstatus);
        softAssert.assertEquals(actualPaymentMode, "Bill to company");
        softAssert.assertAll();
    }

    @Test(enabled = true, priority = 2, description = "Open Travel plus Web Application", dataProvider = "excel-data", dataProviderClass = ExcelUtility.class)
    public void book_hotel_with_wallet_payment_type(String cityname, String employeename, String emplolastname, String phonno, String emailid, String checkindate, String checkoutDate, String bookingstatus) throws InterruptedException {
        clickOnBookNowButton();
        enterHotelDetails(cityname, employeename, checkindate, checkoutDate);
        String expectedHotelName = selectHotel();
        String actualBookingStatus = payUsingWallet(emplolastname, phonno, emailid, bookingstatus);
        isBookingIdIsDisplayed();
        String actualPaymentMode = getPaymentmodetext();
        String actualHotelName = actualHotelName();
        String fullExpectedCheckInDateAndCheckoutDate = getExpectedCheckInDateAndCheckoutDate(checkindate, checkoutDate);
        String actualCheckInAndCheckOutDate = actualCheckInAndCheckoutDate();
        softAssert.assertEquals(actualCheckInAndCheckOutDate, fullExpectedCheckInDateAndCheckoutDate);
        softAssert.assertEquals(actualHotelName, expectedHotelName);
        softAssert.assertNotNull(getBookingId());
        softAssert.assertEquals(actualHotelName, expectedHotelName);
        softAssert.assertEquals(actualBookingStatus, bookingstatus);
        softAssert.assertEquals(actualPaymentMode, "Prepaid");
        softAssert.assertAll();
    }

    @Test(enabled = true, priority = 3, description = "Open Travel plus Web Application", dataProvider = "excel-data", dataProviderClass = ExcelUtility.class)
    public void book_hotel_with_payathotel_payment_type(String cityname, String employeename, String emplolastname, String phonno, String emailid, String checkindate, String checkoutDate, String bookingstatus) throws InterruptedException {
        clickOnBookNowButton();
        enterHotelDetails(cityname, employeename, checkindate, checkoutDate);
        String expectedHotelName = selectHotel();
        String actualBookingStatus = payAtHotel(emplolastname, phonno, emailid, bookingstatus);
        String actualPaymentMode = getPaymentmodetext();
        String actualHotelName = actualHotelName();
        isBookingIdIsDisplayed();
        String fullExpectedCheckInDateAndCheckoutDate = getExpectedCheckInDateAndCheckoutDate(checkindate, checkoutDate);
        String actualCheckInAndCheckOutDate = actualCheckInAndCheckoutDate();
        softAssert.assertEquals(actualCheckInAndCheckOutDate, fullExpectedCheckInDateAndCheckoutDate);
        softAssert.assertEquals(actualHotelName, expectedHotelName);
        softAssert.assertNotNull(getBookingId());
        softAssert.assertEquals(actualBookingStatus, bookingstatus);
        softAssert.assertEquals(actualHotelName, expectedHotelName);
        softAssert.assertEquals(actualPaymentMode, "Pay@hotel");
        softAssert.assertAll();
    }


    @Test(enabled = true, priority = 4, description = "Open Travel plus Web Application", dataProvider = "International search", dataProviderClass = ExcelUtility.class)
    public void book_international_hotel_with_given_paymentType(String cityname, String employeename, String emplolastname, String phonno, String emailid, String checkindate, String checkoutDate, String bookingstatus) throws InterruptedException {
        clickOnBookNowButton();
        enterHotelDetails(cityname, employeename, checkindate, checkoutDate);
        String expectedHotelName = selectHotel();
        String actualBookingStatus = payment(emplolastname, phonno, emailid, bookingstatus);
        isBookingIdIsDisplayed();
        String actualHotelName = actualHotelName();
        String fullExpectedCheckInDateAndCheckoutDate = getExpectedCheckInDateAndCheckoutDate(checkindate, checkoutDate);
        String actualCheckInAndCheckOutDate = actualCheckInAndCheckoutDate();
        softAssert.assertEquals(actualCheckInAndCheckOutDate, fullExpectedCheckInDateAndCheckoutDate);
        softAssert.assertEquals(actualBookingStatus, bookingstatus);
        softAssert.assertEquals(actualHotelName, expectedHotelName);
        softAssert.assertNotNull(getBookingId());
        softAssert.assertAll();
    }

    @Test(enabled = true, priority = 5, description = "Open Travel plus Web Application", dataProvider = "Internationa Hotel book with hotelname", dataProviderClass = ExcelUtility.class)
    public void book_international_hotel_with_payathotel_payment_type(String cityname, String hotelName, String employeename, String emplolastname, String phonno, String emailid, String checkindate, String checkoutDate, String bookingstatus) throws InterruptedException {
        clickOnBookNowButton();
        enterHotelDetails(cityname, employeename, checkindate, checkoutDate);
        selectSpecificHotel(hotelName);
        String actualBookingStatus = payAtHotel(emplolastname, phonno, emailid, bookingstatus);
        isBookingIdIsDisplayed();
        String actualHotelName = actualHotelName();
        String actualPaymentMode = getPaymentmodetext();
        String fullExpectedCheckInDateAndCheckoutDate = getExpectedCheckInDateAndCheckoutDate(checkindate, checkoutDate);
        String actualCheckInAndCheckOutDate = actualCheckInAndCheckoutDate();
        softAssert.assertEquals(actualHotelName, hotelName);
        softAssert.assertEquals(actualCheckInAndCheckOutDate, fullExpectedCheckInDateAndCheckoutDate);
        softAssert.assertEquals(actualBookingStatus, bookingstatus);
        softAssert.assertNotNull(getBookingId());
        softAssert.assertEquals(actualPaymentMode, "Pay@hotel");
        softAssert.assertAll();
    }

    @Test(enabled = true, priority = 6, description = "Open Travel plus Web Application", dataProvider = "Internationa Hotel book with hotelname", dataProviderClass = ExcelUtility.class)
    public void book_international_hotel_with_wallet_payment_type(String cityname, String hotelName, String employeename, String emplolastname, String phonno, String emailid, String checkindate, String checkoutDate, String bookingstatus) throws InterruptedException {
        clickOnBookNowButton();
        enterHotelDetails(cityname, employeename, checkindate, checkoutDate);
        selectSpecificHotel(hotelName);
        selectRoom();
        String actualBookingStatus = payUsingWallet(emplolastname, phonno, emailid, bookingstatus);
        isBookingIdIsDisplayed();
        String actualHotelName = actualHotelName();
        String actualPaymentMode = getPaymentmodetext();
        String fullExpectedCheckInDateAndCheckoutDate = getExpectedCheckInDateAndCheckoutDate(checkindate, checkoutDate);
        String actualCheckInAndCheckOutDate = actualCheckInAndCheckoutDate();
        softAssert.assertEquals(actualHotelName, hotelName);
        softAssert.assertEquals(actualCheckInAndCheckOutDate, fullExpectedCheckInDateAndCheckoutDate);
        softAssert.assertEquals(actualBookingStatus, bookingstatus);
        softAssert.assertNotNull(getBookingId());
        softAssert.assertEquals(actualPaymentMode, "Prepaid");
        softAssert.assertAll();
    }

    @Test(enabled = true, priority = 6, description = "Open Travel plus Web Application", dataProvider = "Internationa Hotel book with hotelname", dataProviderClass = ExcelUtility.class)
    public void book_international_hotel_with_btc_payment_type(String cityname, String hotelName, String employeename, String emplolastname, String phonno, String emailid, String checkindate, String checkoutDate, String bookingstatus) throws InterruptedException {
        clickOnBookNowButton();
        enterHotelDetails(cityname, employeename, checkindate, checkoutDate);
        selectSpecificHotel(hotelName);
        selectRoom();
        String actualBookingStatus = paymentUsingBTC(emplolastname, phonno, emailid, bookingstatus);
        isBookingIdIsDisplayed();
        String actualHotelName = actualHotelName();
        String actualPaymentMode = getPaymentmodetext();
        String fullExpectedCheckInDateAndCheckoutDate = getExpectedCheckInDateAndCheckoutDate(checkindate, checkoutDate);
        String actualCheckInAndCheckOutDate = actualCheckInAndCheckoutDate();
        softAssert.assertEquals(actualHotelName, hotelName);
        softAssert.assertEquals(actualCheckInAndCheckOutDate, fullExpectedCheckInDateAndCheckoutDate);
        softAssert.assertEquals(actualBookingStatus, bookingstatus);
        softAssert.assertNotNull(getBookingId());
        softAssert.assertEquals(actualPaymentMode, "Bill to company");
        softAssert.assertAll();
    }

}

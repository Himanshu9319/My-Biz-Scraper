package web.B2C.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Base;
import utilities.CommonFunctionsWeb;
import utilities.ExcelUtility;
import utilities.TestUtilities;

import static utilities.CommonFunctionsWeb.*;
import static web.B2C.Pages.Bookingconfrimationpage.*;
import static web.B2C.Pages.HotelBookingPage.*;
import static web.B2C.Pages.Login.loginwithphoneno;
import static web.B2C.Pages.Logout.logoutB2chotelpage;
import static web.admin.pages.Calander.*;


public class B2C_HotelBookingFlow extends Base {

    public static SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void methodName() {
        Base.property = TestUtilities.addConfigProperties(Base.property.getProperty("env"));
    }

    @BeforeMethod
    public void login() throws InterruptedException {
        openB2BURL();
        loginwithphoneno(Base.property.getProperty("mobileno"));
    }

    @AfterMethod
    public void logOut() throws InterruptedException {
        loadPageWithRetry(Base.property.getProperty("b2curl"));
        logoutB2chotelpage();
    }


    @Test(enabled = true, priority = 1, description = "Open B2C", dataProvider = "B2C", dataProviderClass = ExcelUtility.class)
    public static void searchAndBookHotelWithQuickHotelBookOption(String city, String CheckInDate, String checkoutdate, String guest) throws InterruptedException {
        selectCity(city);
        selectCheckInDate(CheckInDate.split(" ")[0] + " " + CheckInDate.split(" ")[1], CheckInDate.split(" ")[2]);
        checkoutdate(checkoutdate.split(" ")[0] + " " + checkoutdate.split(" ")[1], checkoutdate.split(" ")[2]);
        select_guest(guest);
        clickOnSearchButton();
        validateFabhotelsLogo();
        validateFilter();
        String actualBrandFilter = brandfiltertype();
        String actualSearchButtonText = validatesearchButton();
        boolean hotelList = totalhotelList();
        String actualHotelName = getHotelName();
        clickOnQuickBookButton();
        CommonFunctionsWeb.switchTab();
        String expectedHotelName = getHotelNameOnPaymentBox();
        String actualCheckInDate = getCheckIndate();
        String actualCheckOutDate = getCheckOutDate();
        clickOnPayAtHotel();
        enterotp();
        softAssert.assertTrue(actualBrandFilter.contains("Our Brands"));
        softAssert.assertEquals(hotelList, true, "Validate hotel are present on the dom");
        softAssert.assertEquals(actualSearchButtonText, "Search", "Validate hotel are present on the dom");
        softAssert.assertEquals(actualHotelName, expectedHotelName);
        softAssert.assertTrue(actualCheckInDate.contains(CheckInDate.split(" ")[2] + " " + CheckInDate.split(" ")[0]));
        softAssert.assertTrue(actualCheckOutDate.contains(checkoutdate.split(" ")[2] + " " + checkoutdate.split(" ")[0]));
        softAssert.assertAll();
    }

    @Test(enabled = true, priority = 1, description = "Open B2C", dataProvider = "B2C", dataProviderClass = ExcelUtility.class)
    public static void bookFabHotelsDFabHotelTheDaffodilsBySelectRoomOptions(String city, String CheckInDate, String checkoutdate, String guest, String hotelName) throws InterruptedException {
        selectCity(city);
        selectCheckInDate(CheckInDate.split(" ")[0] + " " + CheckInDate.split(" ")[1], CheckInDate.split(" ")[2]);
        checkoutdate(checkoutdate.split(" ")[0] + " " + checkoutdate.split(" ")[1], checkoutdate.split(" ")[2]);
        select_guest(guest);
        clickOnSearchButton();
        validateFabhotelsLogo();
        validateFilter();
        String actualBrandFilter = brandfiltertype();
        String actualSearchButtonText = validatesearchButton();
        boolean hotelList = totalhotelList();
        clickonselctroomwithgivenhotel(hotelName);
        CommonFunctionsWeb.switchTab();
        clickOnBookNowButton();
        String actualHotelName = getHotelNameOnPaymentBox();
        String actualCheckInDate = getCheckIndate();
        String actualCheckOutDate = getCheckOutDate();
        clickOnPayAtHotel();
        enterotp();
        clickOnConfirmButton();
        validateConfirmationPage();
        totapPayAbleAmount();
        String actualHotelNameOfConfirmationPage = actualHotelname();
        String actualCheckInDateOfConfirmationPage = actualcheckindate().replace(",", "").split(" ")[0] + " " + actualcheckindate().replace(",", "").split(" ")[1];
        String actualCheckOutDateOfConfirmationPage = actualcheckOutdate().replace(",", "").split(" ")[0] + " " + actualcheckOutdate().replace(",", "").split(" ")[1];
        String actualGuestCount = actualGuestCount();
        String actualConfirmationMessage = confirmationMessage();
        softAssert.assertTrue(actualBrandFilter.contains("Our Brands"));
        softAssert.assertEquals(hotelList, true, "Validate hotel are present on the dom");
        softAssert.assertEquals(actualSearchButtonText, "Search", "Validate hotel are present on the dom");
        softAssert.assertEquals(actualHotelName, hotelName);
        softAssert.assertEquals(actualGuestCount, guest);
        softAssert.assertEquals(actualConfirmationMessage, "Booking Confirmed!");
        softAssert.assertTrue(actualCheckInDate.contains(CheckInDate.split(" ")[2] + " " + CheckInDate.split(" ")[0]));
        softAssert.assertTrue(actualCheckOutDate.contains(checkoutdate.split(" ")[2] + " " + checkoutdate.split(" ")[0]));
        softAssert.assertEquals(actualHotelNameOfConfirmationPage, hotelName);
        softAssert.assertEquals(actualCheckInDateOfConfirmationPage, CheckInDate.split(" ")[2] + " " + CheckInDate.split(" ")[0], "Check in date");
        softAssert.assertEquals(actualCheckOutDateOfConfirmationPage, checkoutdate.split(" ")[2] + " " + checkoutdate.split(" ")[0], "Check in date");
        softAssert.assertAll();
    }

}

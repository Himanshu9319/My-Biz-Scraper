package web.admin.tests;

import UtilsAPI.HotelBooking.responseDto.Create.DailyRatePlanPrice;
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
import web.admin.pages.Calander;
import web.admin.pages.CommonElements;

import java.util.Properties;

import static utilities.CommonFunctionsWeb.*;
import static web.admin.pages.CommonElements.*;
import static web.admin.pages.Flight.*;
import static web.admin.pages.Hotel.clickOnBookNowButton;
import static web.admin.pages.LoginPage.loginapplication;
import static web.admin.pages.Logout.logoutapplication;
@Listeners(utilities.CustomListeners.class)
public class Flight extends Base {

    Properties properties = TestUtilities.loadConfigProperties();
    SoftAssert softAssert = new SoftAssert();

    CommonElements common = new CommonElements();
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


    @Test(enabled = true, priority = 0, description = "Open Travel plus Web Application", dataProvider = "Flight", dataProviderClass = ExcelUtility.class)
    public static void BookOneWayFlightWithEmployeeWithBTC(String depature, String arrival, String employeename, String MobileNo, String emailid, String travellerCount, String depDate) throws InterruptedException {
        clickOnBookNowButton();
        selectFlight();
        enterFromDestination(depature);
        enterToDestination(arrival);
        selectDepDate(depDate);
        clickonselectTraveleller();
        selectTravellerCount(travellerCount);
        chooseEconomytravelClass();
        clickondoneButton();
        enterEmployeeName(employeename);
        clickOnSarchFlights();
        String flightName = selectAndBookFlightWithRegularPrice();
        System.out.println(flightName);
        paymentUsingBTC(employeename,MobileNo,emailid,"");
//        isPnrIsDisplayed();
//        String paymentMode = getPaymentmodetect();
//        String travellerName = getTravellerName();
//        String actualFlightName = getFlightName();
//        Assert.assertEquals(paymentMode, "Bill to company");
//        Assert.assertEquals(travellerName.toLowerCase(), employeename.toLowerCase());
//        Assert.assertEquals(flightName, actualFlightName);
    }

    @Test(enabled = true, priority = 1, description = "Open Travel plus Web Application", dataProvider = "Flight", dataProviderClass = ExcelUtility.class, dependsOnMethods = "BookOneWayFlightWithEmployeeWithBTC")
    public static void BookOneWayFlightWithEmployeeWithWalletPaymentOption(String depature, String arrival, String employeename, String MobileNo, String emailid, String travellerCount, String depDate) throws InterruptedException {
        clickOnBookNow();
        selectFlight();
        // enterFromandTodestination(depature, arrival, depDate);
        clickonselectTraveleller();
        selectTravellerCount(travellerCount);
        chooseEconomytravelClass();
        clickondoneButton();
        enterEmployeeName(employeename);
        clickOnSarchFlights();
        String flightName = selectAndBookFlightWithRegularPrice();
        paymentusinfwallet();
        isPnrIsDisplayed();
        String paymentMode = getPaymentmodetect();
        String travellerName = getTravellerName();
        String actualFlightName = getFlightName();
        Assert.assertEquals(travellerName.toLowerCase(), employeename.toLowerCase());
        Assert.assertEquals(paymentMode, "Prepaid");
        Assert.assertEquals(flightName, actualFlightName);
    }
}

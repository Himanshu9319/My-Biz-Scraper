package web.admin.tests;

import UtilsAPI.HotelBooking.responseDto.Create.DailyRatePlanPrice;
import org.testng.Assert;
import org.testng.annotations.*;
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


    @BeforeClass
    public void methodName() {
        Base.property = TestUtilities.addConfigProperties(Base.property.getProperty("env"));
    }

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void login() throws InterruptedException {
        openURL();
        loginapplication(Base.property.getProperty("username"), "");
    }

    @AfterMethod
    public void logout() {
        loadPageWithRetry(Base.property.getProperty("url"));
        logoutapplication();
    }


    @Test(enabled = true, priority = 1, description = "Open Travel plus Web Application", dataProvider = "Flight", dataProviderClass = ExcelUtility.class)
    public static void BookOneWayFlightWithEmployeeWithBTC(String depature, String arrival, String employeename, String MobileNo, String emailid, String travellerCount, String depDate, String flightName, String pricetype, String addons, String city, String username, String usernumber, String userdate, String usermobno) throws InterruptedException {
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
        String actualFlightName = selectPrice(flightName, pricetype);
        paymentUsingBTC(employeename, MobileNo, city, username, usernumber, userdate, usermobno, "");
        //  isPnrIsDisplayed();
//        String paymentMode = getPaymentmodetect();
//        String travellerName = getTravellerName();
//        String actualFlightName = getFlightName();
//        Assert.assertEquals(paymentMode, "Bill to company");
//        Assert.assertEquals(travellerName.toLowerCase(), employeename.toLowerCase());
//        Assert.assertEquals(flightName, actualFlightName);
    }

    @Test(enabled = true, priority = 2, description = "Open Travel plus Web Application", dataProvider = "Flight", dataProviderClass = ExcelUtility.class, dependsOnMethods = "BookOneWayFlightWithEmployeeWithBTC")
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
        //String flightName = selectAndBookFlightWithRegularPrice();
        paymentusinfwallet();
        isPnrIsDisplayed();
        String paymentMode = getPaymentmodetect();
        String travellerName = getTravellerName();
        String actualFlightName = getFlightName();
        Assert.assertEquals(travellerName.toLowerCase(), employeename.toLowerCase());
        Assert.assertEquals(paymentMode, "Prepaid");
        //  Assert.assertEquals(flightName, actualFlightName);
    }
}

package web.admin.tests;

import utilities.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.CommonFunctionsWeb;
import utilities.TestUtilities;

import java.util.Properties;

import static utilities.CommonFunctionsWeb.loadPageWithRetry;
import static utilities.CommonFunctionsWeb.openURL;
import static web.admin.pages.Buses.*;
import static web.admin.pages.LoginPage.loginapplication;

public class Bus extends Base {

    Properties properties = TestUtilities.loadConfigProperties();
    public static String bookingId;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void login() throws InterruptedException {
        openURL();
        loginapplication(properties.getProperty("username"), "");
    }

    @AfterMethod
    public void logout() throws InterruptedException {
        loadPageWithRetry(Base.property.getProperty("openurl"));
        CommonFunctionsWeb.hardwait(7);
    }

    @Test(enabled = true, priority = 2, description = "Open Travel plus Web Application")
    public void BookBusSeatWalletBTC() throws InterruptedException {

        clickOnBookNowBus();
        searchBuses();
        CommonFunctionsWeb.hardwait(5);
        fillTravellerForm("Abhishek", "9717952092", "abhics33@gmail.com");
        bookSeat();
        selectPaymemtMode("BTC");

    }
    @Test(enabled = true, priority = 1, description = "Open Travel plus Web Application")
    public void BookBusSeatWallet() throws InterruptedException {

        clickOnBookNowBus();
        searchBuses();
        CommonFunctionsWeb.hardwait(5);
        fillTravellerForm("Abhishek", "9717952092", "abhics33@gmail.com");
        bookSeat();
        selectPaymemtMode("Wallet");

    }
    @Test(enabled = true, priority = 1, description = "Open Travel plus Web Application")
    public void SearchBooking() throws InterruptedException {

        searchBooking();
    }


}

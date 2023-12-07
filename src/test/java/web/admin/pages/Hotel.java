package web.admin.pages;

import com.sun.corba.se.impl.encoding.CDRInputObject;
import io.gatling.charts.highcharts.series.StackedColumnSeries;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.CommonFunctionsWeb;
import utilities.RandomDataCreator;

public class Hotel {
    public static By book_now_button = By.xpath("//span[text()='Book now']");
    public static By destination = By.xpath("//input[@id=\"fas-input\"]");
    public static By getCheck_in_date_button = By.xpath("(//div[@id=\"calendar-input\"])[1]");
    public static By check_in_time = By.xpath("//span[text()='Check-in date']/..");
    public static By getCheck_out_date_button = By.xpath("(//div[@id=\"calendar-input\"])[2]");
    public static By check_out_time = By.xpath("//div[@data-datevalue=\"Tue Nov 28 2023 00:00:00 GMT+0530 (India Standard Time)\"]");
    public static By searh_hotel_button = By.xpath("//button[text()='Search hotels']");
    public static By first_city_in_search_box = By.xpath("(//div[@class=\"suggestion-item\"])[1]");
    public static By random_destination = By.xpath("//span[text()='Destination']");
    public static By select_room = By.xpath("(//button[text()='Select room'])[1]");
    public static By select_random_room = By.xpath("//button[text()='Select room']");
    public static By BILL_TO_COMPANY = By.xpath("//div[text()='Bill to company']");
    public static By continue_button = By.xpath("//button[text()='Continue']");

    public static By travellerpopupcontinuebutton = By.xpath("(//button[text()='Continue'])[2]");
    public static By employeenamefield = By.xpath("//input[@data-testid=\"multisuggest-input\"]");
    public static By existingemployeelistelement = By.xpath("//div[@class=\"dynamic-item\"]/..//ul");
    public static By add_as_guest_button = By.xpath("//span[@class=\"dynamic-add-btn\"]");
    public static By traveller_details_poup = By.xpath("//div[@class=\"modal-main guest-modal\"]");
    public static By pop_up_continue_button = By.xpath("//div[@class=\"btn-row\"]//button");
    public static By mobile_no = By.xpath("//input[@name=\"mobile\"]");
    public static By emailelement = By.xpath("//input[@id=\"email\"]");
    public static By lastNameElement = By.xpath("//input[@id=\"lastName\"]");
    public static By tripstatus = By.xpath("//span[@class='status ']");
    public static By booking_id = By.xpath("//span[@class=\"bookingId\"]");
    public static By Walletelement = By.xpath("//div[text()='Wallet']");
    public static By hotel_list = By.xpath("//section[@class=\"hotels-listing\"]");
    public static By payathotel = By.xpath("(//span[@class=\"paymentOption\"])[1]");
    public static By travellersdetailspopupelement = By.xpath("//div[@class=\"modal-main guest-modal\"]");
    public static By traveltabElement = By.xpath("//li[text()='Travel']");
    public static By radio_selected = By.xpath("//span[@class=\"radioSelector selected\"]");
    public static By paymentmodeelement = By.xpath("//span[text()='Payment mode']/following-sibling::strong");
    public static By hotelSearchError = By.xpath("//button[text()='Try again']");
    public static By crossIcon = By.cssSelector("[class*='crossIcon']");
    public static By searchCityList = By.xpath("//div[@id=\"search-dropdown-wrapper\"]");
    public static By hotelDeatilsPageElement = By.xpath("//div[@class=\"modal-main \"]");
    public static By error_message = By.xpath("//span[@class=\"error-message\"]");
    public static By destinationField = By.xpath("//span[text()='Destination']");
    public static By leftSideFilterElement = By.xpath("//div[@class=\"sticky-wrapper\"]");
    public static By guestTypeDropDownElement = By.xpath("(//div[@class=\"dropdown-heading-value\"])[2]");
    public static By bookingTable = By.xpath("//div[@class=\"wrapper-table\"]");
    public static By bookingid = By.xpath("//span[@class=\"bookingId\"]//strong");
    public static By bookings = By.xpath("//div[@title=\"Bookings\"]");
    public static By upcomingBookingElement = By.xpath("//li[@id='UPCOMING']");

    public static By gstElement = By.xpath("//span[text()='GST selection is mandatory for booking']");

    public static By gstDropDown = By.xpath("//div[@class=\"dropdown-heading\"]");

    public static By gstCompnay = By.xpath("(//div[@class='entityName'])[2]");

    public static By EgstName = By.xpath("//div[@class=\"dropdown-heading-value\"]//span//span");

    public static By AgstCompnayName = By.xpath("//label[@class=\"select-item false\"]//small");

    public static By paymentOptionList = By.xpath("//span[@class=\"paymentOption\"]");

    public static By paymentOptionName = By.xpath("//span[@class='paymentOption']//div");

    public static By selectedOptinname = By.xpath("//span[@class='radioSelector selected']/following-sibling::div");

    public static By checkinandcheckoutdate = By.xpath("//div[@class=\"date \"]//span[@class=\"value\"]");

    public static By hotelName = By.xpath("//h2[@class=\"hotel-name\"]");

    public static By hotelNameElementOnConfirmationPage = By.xpath("//h3[@class=\"hotelName\"]");

    private static By searchinputField = By.xpath("//input[@data-testid=\"searchBar\"]");

    private static By bookindonBookingPage = By.xpath("//div[@class=\"bookingId\"]");

    private static By selectedRoom = By.xpath("(//div[@class=\"rate-plan-details-wrapper normal-flow\"]//button)[2]");

    private static By clearAllButton = By.xpath("//div[@class=\"clear-all active\"]");



    public static void clickOnBookNowButton() {
        CommonFunctionsWeb.click(book_now_button, "Click on Book Now Button");
        CommonFunctionsWeb.isElementDisplayed(destinationField, "Destination field of BookNowPage");
    }



    public static void enterHotelDetails(String destinations, String emloyeename, String checkindate, String checkoutdate) throws InterruptedException {
        CommonFunctionsWeb.enterCharacter(destination, destinations, "");
        CommonFunctionsWeb.waitForVisibility(searchCityList);
        CommonFunctionsWeb.hardwait(500);
        CommonFunctionsWeb.click(first_city_in_search_box, "");
        CommonFunctionsWeb.click(getCheck_in_date_button, "Check in date button");
        Calander.selectCheckInAndCheckOutDateFromCalandar(checkindate.split(" ")[0] + " " + checkindate.split(" ")[1], checkindate.split(" ")[2]);
        CommonFunctionsWeb.click(getCheck_out_date_button, "Check out date button");
        CommonFunctionsWeb.click(getCheck_out_date_button, "Check out date button");
        Calander.selectCheckInAndCheckOutDateFromCalandar(checkoutdate.split(" ")[0] + " " + checkoutdate.split(" ")[1], checkoutdate.split(" ")[2]);
        CommonFunctionsWeb.enterCharacter(employeenamefield, emloyeename, "Enter guest name");
        CommonFunctionsWeb.isElementDisplayed(existingemployeelistelement, "List of suggestions");
        CommonFunctionsWeb.click(add_as_guest_button, "Click on add as a guest button");
        CommonFunctionsWeb.click(searh_hotel_button, "click on search hotel button");
        CommonFunctionsWeb.waitForElementToBeClikable(select_random_room);
        CommonFunctionsWeb.waitForElementToBeClikable(clearAllButton);
        CommonFunctionsWeb.isElementDisplayed(leftSideFilterElement, "Right side sticky wrapper");
    }

    public static String paymentUsingBTC(String employeelastname, String phoneno, String email, String bookingstatus) throws InterruptedException {
        CommonFunctionsWeb.waitForVisibility(BILL_TO_COMPANY);
        CommonFunctionsWeb.click(BILL_TO_COMPANY, "BILL TO COMPANY");
        CommonFunctionsWeb.waitForVisibility(radio_selected);
        CommonFunctionsWeb.click(continue_button, "Click on continue Button");
        selectGSt();
        CommonFunctionsWeb.waitForVisibility(traveller_details_poup);
        fillTravellerForm(employeelastname, phoneno, email);
        CommonFunctionsWeb.pageContainUrl("/admin/orion/travel/booking-confirmation/");
        CommonFunctionsWeb.waitForVisibility(tripstatus);
        return CommonFunctionsWeb.getText(tripstatus, "Booking confrimed status");
    }

    public static void selectGSt() {
        if (CommonFunctionsWeb.getElements(gstElement).size() > 0) {
            CommonFunctionsWeb.click(gstDropDown, "Click on gst dropdown");
            CommonFunctionsWeb.click(gstCompnay, "Select gst company");
            CommonFunctionsWeb.click(continue_button, "Click on continue Button");
        }
    }

    public static String payUsingWallet(String employeelastname, String phoneno, String email, String bookingstatus) {
        CommonFunctionsWeb.waitForVisibility(Walletelement);
        CommonFunctionsWeb.waitForElementToBeClikable(Walletelement);
        CommonFunctionsWeb.click(Walletelement, "Wallet");
        CommonFunctionsWeb.waitForVisibility(radio_selected);
        CommonFunctionsWeb.click(continue_button, "Click on continue Button");
        CommonFunctionsWeb.waitForVisibility(traveller_details_poup);
        fillTravellerForm(employeelastname, phoneno, email);
        CommonFunctionsWeb.pageContainUrl("https://tenant.fabmailers.in/admin/orion/travel/booking-confirmation/");
        CommonFunctionsWeb.waitForVisibility(tripstatus);
        return CommonFunctionsWeb.getText(tripstatus, "Booking confrimed status");
    }

    public static void clickOnTravellerTabElement() {
        CommonFunctionsWeb.click(traveltabElement, "traveltab");
        CommonFunctionsWeb.waitForVisibility(bookingTable);
    }

    public static String getPaymentmodetext() {
        return CommonFunctionsWeb.getText(paymentmodeelement, "Booking confrimed status");
    }

    public static String payAtHotel(String employeelastname, String phoneno, String email, String bookingstatus) {
        CommonFunctionsWeb.waitForVisibility(payathotel);
        CommonFunctionsWeb.click(payathotel, "BILL TO COMPANY");
        CommonFunctionsWeb.waitForVisibility(radio_selected);
        CommonFunctionsWeb.click(continue_button, "Click on continue Button");
        CommonFunctionsWeb.waitForVisibility(traveller_details_poup);
        fillTravellerForm(employeelastname, phoneno, email);
        CommonFunctionsWeb.pageContainUrl("https://tenant.fabmailers.in/admin/orion/travel/booking-confirmation/");
        CommonFunctionsWeb.waitForVisibility(tripstatus);
        return CommonFunctionsWeb.getText(tripstatus, "Booking confrimed status");
    }


    public static String selectHotel() {
        String actualhotelName = null;
        if (CommonFunctionsWeb.getElements(hotelSearchError).size() > 0) {
            Assert.fail("An error occurred during hotel search");
        } else {
            int size = CommonFunctionsWeb.getElements(select_random_room).size();
            int randomHotelIndex = RandomDataCreator.generateRandomInt(0, size - 1);
            CommonFunctionsWeb.getElements(select_random_room).get(randomHotelIndex).click();
            CommonFunctionsWeb.waitForVisibility(hotelDeatilsPageElement);
            actualhotelName = CommonFunctionsWeb.getElements(hotelName).get(randomHotelIndex).getText();
        }
        return actualhotelName;

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

    public static String getBookingId() {
        return CommonFunctionsWeb.getText(bookingid, "Get booking id");
    }

    public static void selectRandomPaymentOption() throws InterruptedException {
        CommonFunctionsWeb.waitForVisibility(paymentOptionList);
        int size = CommonFunctionsWeb.getElements(paymentOptionList).size();
        int i = RandomDataCreator.generateRandomInt(1, size);
        if (i == 1) {
            CommonFunctionsWeb.waitForElementToBeClikable(paymentOptionName);
            CommonFunctionsWeb.click(paymentOptionName, "Payment option name");
        } else {
            CommonFunctionsWeb.waitForElementToBeClikable(paymentOptionName);
            CommonFunctionsWeb.clickOnElements(paymentOptionName, "Payment option name", i);
        }
        CommonFunctionsWeb.waitForVisibility(radio_selected);
        Thread.sleep(2000);

    }

    public static String payment(String employeelastname, String phoneno, String email, String bookingstatus) throws InterruptedException {
        selectRandomPaymentOption();
        String selectedOptionanme = CommonFunctionsWeb.getText(selectedOptinname, "Selected option name text");
        System.out.println("Selected option name--" + selectedOptionanme);
        CommonFunctionsWeb.click(continue_button, "Click on continue Button");
        if (selectedOptionanme.contains("Bill to company")) {
            selectGSt();
            CommonFunctionsWeb.click(continue_button, "Click on continue Button");
        }
        CommonFunctionsWeb.waitForVisibility(traveller_details_poup);
        fillTravellerForm(employeelastname, phoneno, email);
        CommonFunctionsWeb.pageContainUrl("/admin/orion/travel/booking-confirmation/");
        CommonFunctionsWeb.waitForVisibility(tripstatus);
        return CommonFunctionsWeb.getText(tripstatus, "Booking confrimed status");
    }

    public static void isBookingIdIsDisplayed() {
        CommonFunctionsWeb.isElementDisplayed(booking_id, "Check booking is visible");
    }

    public static String actualCheckInAndCheckoutDate() {
        CommonFunctionsWeb.isElementDisplayed(checkinandcheckoutdate, "Checkin and checkout date");
        return CommonFunctionsWeb.getText(checkinandcheckoutdate, "Checkin and checkout date");
    }

    public static String actualHotelName() {
        return CommonFunctionsWeb.getText(hotelNameElementOnConfirmationPage, "");
    }

    public static String validateBookingid() {
        return CommonFunctionsWeb.getText(bookindonBookingPage, "Booking id");
    }


    public static String getExpectedCheckInDateAndCheckoutDate(String checkindate, String checkoutDate) {
        String[] FullCalendar = checkindate.split(" ");
        String[] spellchecker = checkoutDate.split(" ");
        String expectedCheckInDate = FullCalendar[2] + " " + FullCalendar[0];
        String expectedCheckoutDate = spellchecker[2] + " " + spellchecker[0];
        return expectedCheckInDate + " - " + expectedCheckoutDate;
    }


    public static void selectSpecificHotel(String hotelName) {
        By hotelname = By.xpath("//h2[text()='" + hotelName + "']/../../..//button");
        CommonFunctionsWeb.click(hotelname, "Hotel Name");
        CommonFunctionsWeb.waitForVisibility(hotelDeatilsPageElement);
    }

    public static void selectRoom() {
        CommonFunctionsWeb.click(selectedRoom, "Select room");
    }


}





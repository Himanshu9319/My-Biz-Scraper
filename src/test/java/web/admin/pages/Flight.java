package web.admin.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.CommonFunctionsWeb;
import utilities.RandomDataCreator;

import static web.admin.pages.CommonElements.*;

public class Flight {
    private static By BookNow = By.xpath("//span[text()='Book now']");
    private static By fligths = By.xpath("//span[@class=\"name flight \"]");
    private static By fromInputField = By.xpath("//span[text()='From']/following-sibling::input");
    private static By toinputField = By.xpath("//span[text()='To']/following-sibling::input");
    private static By depaturedate = By.xpath("(//div[@class=\"react-datepicker__input-container\"])[1]");
    private static By fromandtocitylist = By.cssSelector("[class='city-detail-container']");
    private static By fromairportslist = By.cssSelector("[class='city-list-container from popular-airports']");
    private static By toairportlist = By.xpath("//div[@class='city-name']");
    private static By travellerandClass = By.cssSelector("[class=\"selected-text\"]");
    private static By economytravelclass = By.xpath("//input[@id=\"ECONOMY\"]");
    private static By doneButton = By.xpath("//button[text()='Done']");
    private static By employeenamefield = By.xpath("//input[@data-testid='multisuggest-input']");
    private static By searchFlightButton = By.xpath("//div[@class=\"submitCta\"]");
    private static By monthContainer = By.cssSelector("[class=\"react-datepicker__month-container\"]");
    private static By employeeList = By.xpath("//div[@class=\"dynamic-item\"]");
    private static By viewfareElement = By.xpath("//div[@class='view-fare']");

    private static By airlinename = By.xpath("//div[@class=\"airline\"]");
    private static By bookButtonElement = By.xpath("//div[@class='book_cta ']");
    private static By gstinbutton = By.xpath("//div[@class=\"dropdown-heading-value\"]");
    private static By searchGSTList = By.cssSelector("[class=\"options\"]");
    private static By Wallet = By.xpath("//span[text()='Wallet']");
    private static By msgreloadpopup = By.xpath("//span[@class=\"msg reload-popup\"]");
    private static By travelButton = By.xpath("//li[text()='Travel']");
    private static By errormessagecontainer = By.xpath("//div[@class=\"msg-icon-container\"]");
    private static By searchAgain = By.xpath("//button[@class=\"cta\"]");
    private static By flightListingSection = By.xpath("//section[@class=\"flight-listing-section\"]");

    private static By messagePriceUpdate = By.xpath("//span[@class=\"msg price-updated\"]");

    private static By yesElement = By.xpath("//button[text()='Yes']");

    private static By depdateElement = By.xpath("//span[text()='Departure date']/following-sibling::span");

    private static By flightlist = By.xpath("div[class*='normal-padding flight-listing-container']");

    private static By bookflightNowText = By.xpath("//span[text()='Book a flight now']");

    private static By filterSection = By.xpath("//div[@class=\"sticky-wrapper\"]");

    private static By model_text = By.xpath("//div[@class=\"modal-main \"]");

    private static By calander = By.xpath("//div[@class=\"react-datepicker calendar-date-wrapper popper-placement oneway-checkin\"]");

    private static By oneway = By.xpath("//span[text()='One-way']");
    private static By roundTrip = By.xpath("//span[text()='Round-trip']");
    private static By multiCity = By.xpath("//span[text()='Multi-city']");
    private static By travellerInputElement = By.xpath("//span[text()='Traveler(s) & Class']/..");

    private static By flightsTabButtonElement = By.xpath("//span[@class='name flight ']");

    private static By paymentmodesection = By.xpath("//div[@class=\"flexRow paymentMode\"]");

    private static By BILL_TO_COMPANY = By.xpath("//span[text()='Bill to company']");

    private static By radio_selected = By.xpath("//span[@class=\"radioSelector selected  \"]");

    private static By contibueButton = By.xpath("//button[text()='Confirm booking']");

    private static By loader = By.xpath("//span[text()='Fetching fare details']");

    private static By plus_signbutton = By.xpath("//span[@class='plus-sign']");

    private static By email = By.xpath("//input[@id='email']");

    private static By mobileNo = By.xpath("//span[text()='Mobile number']");

    private static By flightFaretypeelement = By.xpath("//div[@class=\"sub-section td-static-column\"]");
    private static By priceBreakUpPage = By.xpath("//div[@class=\"price-breakup-wrapper\"]");

    private static By actualFlightName = By.xpath("//span[@class=\"airline\"]");

    private static By customFieldSearch = By.xpath("//input[@data-testid=\"multisuggest-input\"]");

    private static By suggestedEmployeeName = By.xpath("//span[@class=\"suggestion-name\"]");

    private static By paymentTextElement = By.xpath("//span[@class=\"radioSelector selected  \"]/following-sibling::span");

    private static By cityListdropdown = By.xpath("//span[text()='City list']/..");
    private static By dropDownList = By.cssSelector("[data-testid=\"dropDownList\"]");

    private static By cityName = By.xpath("//span[@class=\"item-text\"]");

    private static By userNameElement = By.xpath("//input[@id='User name']");

    private static By usernumberElement = By.xpath("//input[@name='User number']");

    private static By userDateElement = By.xpath("//span[text()='User date']/following-sibling::input");

    private static By userMobileNoElement = By.xpath("//input[@id=\"User mob\"]");

    public static void selectFlight() {
        CommonFunctionsWeb.waitForVisibility(flightsTabButtonElement);
        CommonFunctionsWeb.isElementDisplayed(flightsTabButtonElement, "Flights tab element");
        CommonFunctionsWeb.click(flightsTabButtonElement, "Click on flight tab element");
    }

    public static void clickOnBookNow() {
        CommonFunctionsWeb.click(travelButton, "Click on travel button");
        CommonFunctionsWeb.click(BookNow, "Click on book now flow");
        CommonFunctionsWeb.click(fligths, "Click on book now flow");
    }

    public static void checkAllElementPresentOnFlightsPage() {
        CommonFunctionsWeb.isElementDisplayed(searchFlightButton, "Search button");
        CommonFunctionsWeb.isElementDisplayed(oneway, "One way");
        CommonFunctionsWeb.isElementDisplayed(roundTrip, "Round trip");
        CommonFunctionsWeb.isElementDisplayed(multiCity, "Multi city");
        CommonFunctionsWeb.isElementDisplayed(depdateElement, "Depature date element");
        CommonFunctionsWeb.isElementDisplayed(travellerInputElement, "Traveller Class");
    }


    public static void enterFromDestination(String from) {
        CommonFunctionsWeb.isElementDisplayed(fromInputField, "From input field");
        CommonFunctionsWeb.enterCharacter(fromInputField, from, "Enter onboarding airport");
        CommonFunctionsWeb.waitForVisibility(fromairportslist);
        for (int i = 0; i < CommonFunctionsWeb.getElements(fromandtocitylist).size(); i++) {
            String text = CommonFunctionsWeb.getElements(fromandtocitylist).get(i).getText();
            if (text.contains(from)) {
                CommonFunctionsWeb.getElements(fromandtocitylist).get(i).click();
            }
        }
    }

    public static void enterToDestination(String to) {
        CommonFunctionsWeb.waitForVisibility(toairportlist);
        CommonFunctionsWeb.enterCharacter(toinputField, to, "Enter deboarding airport");
        for (int i = 0; i < CommonFunctionsWeb.getElements(toairportlist).size(); i++) {
            String text = CommonFunctionsWeb.getElements(toairportlist).get(i).getText();
            if (text.contains(to)) {
                CommonFunctionsWeb.getElements(toairportlist).get(i).click();
            }
        }
    }

    public static void selectDepDate(String depdate) throws InterruptedException {
        clickOnDepatureDateElement();
        Calander.selectDepAndArriavaldate(depdate.split(" ")[0] + " " + depdate.split(" ")[1], depdate.split(" ")[2]);
    }


    public static void clickonselectTraveleller() {
        CommonFunctionsWeb.click(travellerandClass, "Click con select traveller button");
    }

    public static void selectTravellerCount(String taveller) {
        By selectTraveller = By.xpath("//button[text()='" + taveller + "']");
        CommonFunctionsWeb.click(selectTraveller, "Select traveller count");
    }

    public static void chooseEconomytravelClass() {
        CommonFunctionsWeb.click(economytravelclass, "click on economy travcel class");
    }

    public static void clickondoneButton() {
        CommonFunctionsWeb.click(doneButton, "Click check in date");
    }

    public static void enterEmployeeName(String employeename) {
        CommonFunctionsWeb.enterCharacter(employeenamefield, employeename, "Enter existing employee name");
        for (int i = 0; i < CommonFunctionsWeb.getElements(employeeList).size(); i++) {
            if (CommonFunctionsWeb.getElements(employeeList).get(i).getText().contains(employeename)) {
                CommonFunctionsWeb.getElements(employeeList).get(i).click();
                break;
            }
        }
    }

    public static void clickOnSarchFlights() {
        CommonFunctionsWeb.click(searchFlightButton, "Search flight button");
        CommonFunctionsWeb.waitForElementToBeClikable(viewfareElement);
        CommonFunctionsWeb.isElementDisplayed(bookflightNowText, "");
        CommonFunctionsWeb.isElementDisplayed(filterSection, "Filter section");
    }

    public static String selectPrice(String flight, String pricetype) throws InterruptedException {
        By viewFareFlightName = By.xpath("(//div[text()='" + flight + "']/../../..//div[@class='view-fare'])[1]");
        By priceTypeButton = By.xpath("//div[text()='" + pricetype + "']/..//div[@class='book_cta ']");
        CommonFunctionsWeb.click(viewFareFlightName, "Click on '" + flight + "'" + "view fare");
        CommonFunctionsWeb.waitForVisibility(flightFaretypeelement);
        CommonFunctionsWeb.click(priceTypeButton, "Click on '" + pricetype + "'" + "flight");
        CommonFunctionsWeb.waitForVisibility(priceBreakUpPage);
        CommonFunctionsWeb.waitForVisibility(model_text);
        return CommonFunctionsWeb.getText(actualFlightName, "Actual flight name on price break up page");
    }

    public static void paymentusinfwallet() throws InterruptedException {
        CommonFunctionsWeb.scrollTillElement(Wallet);
        CommonFunctionsWeb.waitForVisibility(Wallet);
        CommonFunctionsWeb.click(Wallet, "WALLET");
        CommonFunctionsWeb.waitForVisibility(radio_selected);
        CommonFunctionsWeb.click(confirmBookingElement, "Click on confirm booking Button");
        // searchAgainWhenAirlineSystemFail();
    }

//    public static void searchAgainWhenAirlineSystemFail() throws InterruptedException {
//        if (CommonFunctionsWeb.getElements(errormessagecontainer).size() > 0) {
//            while (CommonFunctionsWeb.getElements(errormessagecontainer).size() > 0) {
//                if (CommonFunctionsWeb.getElements(messagePriceUpdate).size() > 0) {
//                    CommonFunctionsWeb.click(yesElement, "Click on yes");
//                    CommonFunctionsWeb.pageContainUrl("https://tenant.fabmailers.in/admin/orion/travel/flight-confirmation/");
//                } else {
//                    CommonFunctionsWeb.click(searchAgain, "Click on search again");
//                    CommonFunctionsWeb.waitForVisibility(flightListingSection);
//                    selectAndBookFlightWithRegularPrice();
//                    CommonFunctionsWeb.click(confirmBookingElement, "Click on confirm booking Button");
//                    CommonFunctionsWeb.waitForVisibility(confirmationtitle);
//                }
//            }
//        } else {
//            CommonFunctionsWeb.waitForVisibility(confirmationtitle);
//        }
//
//    }

    public static void clickOnDepatureDateElement() {
        CommonFunctionsWeb.click(depdateElement, " Departure date element");
        CommonFunctionsWeb.waitForVisibility(calander);
    }

    public static void clickOnArrivalDateElement() {
        CommonFunctionsWeb.click(depdateElement, " Departure date element");
        CommonFunctionsWeb.waitForVisibility(calander);
    }

    public static String paymentUsingBTC(String employeename, String phoneno, String city, String userName, String usernumber, String userdate, String userMob, String bookingstatus) throws InterruptedException {
        CommonFunctionsWeb.waitForVisibility(BILL_TO_COMPANY);
        CommonFunctionsWeb.click(BILL_TO_COMPANY, "BILL TO COMPANY");
        CommonFunctionsWeb.waitForVisibility(radio_selected);
        CommonFunctionsWeb.click(contibueButton, "Click on continue Button");
        selectGSt();
        enterDataForExistingEmployee(employeename, city, userName, usernumber, userdate, userMob);
        CommonFunctionsWeb.click(contibueButton, "Click on continue Button");
        return CommonFunctionsWeb.getText(paymentTextElement, "Get payment type text");
    }


    public static void fillTravellerDetails() {
        CommonFunctionsWeb.click(plus_signbutton, "Click on plus sign button");
    }

    public static boolean actualName(String expectedEmail) {
        return CommonFunctionsWeb.verifyAttributValue(email, expectedEmail, "value", "");
    }

    public static void enterEmployeeDate(String phoneNo) {
        CommonFunctionsWeb.enterCharacter(mobileNo, phoneNo, "Mobile no");
    }

    public static void enterDataForExistingEmployee(String employeename, String City, String username, String usernumber, String userdate, String usermob) {
        CommonFunctionsWeb.enterCharacter(customFieldSearch, employeename, "");
        if (CommonFunctionsWeb.getText(suggestedEmployeeName, "EmployeeName").equalsIgnoreCase(employeename)) {
            CommonFunctionsWeb.click(suggestedEmployeeName, "Click on suggested employee name");
        }
        CommonFunctionsWeb.waitForElementToBeClikable(cityListdropdown);
        CommonFunctionsWeb.click(cityListdropdown, "City list dropdwon");
        for (int i = 0; i < CommonFunctionsWeb.getElements(cityName).size(); i++) {
            if (CommonFunctionsWeb.getElements(cityName).get(i).getText().equalsIgnoreCase(City)) {
                CommonFunctionsWeb.click(cityName, "Select given city");
            } else {
                Assert.fail("City is not present on given list");
            }
        }
        Calander.selectUserDate(userdate.split(" ")[0], userdate.split(" ")[1], userdate.split(" ")[2]);
        CommonFunctionsWeb.enterCharacter(userNameElement, username, "Enter user name");
        CommonFunctionsWeb.enterCharacter(usernumberElement, usernumber, "Enter user number");
        CommonFunctionsWeb.enterCharacter(userDateElement, "15/12/2023", "Enter date");
        CommonFunctionsWeb.enterCharacter(userMobileNoElement, usermob, "");
    }


}

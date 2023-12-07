package web.admin.pages;
import org.openqa.selenium.By;
import utilities.CommonFunctionsWeb;
public class Buses {
    private static By BookNow = By.xpath("//span[text()='Book now']");
    private static By BookBus = By.xpath("//span[@class=\"name buses \"]");
    private static By DepartureCity = By.xpath("(//input[@type='text'])[1]");
    private static By DepartureCitySuggestion = By.xpath("(//div[contains(@class,'locality-wrapper')])[1]");
    private static By ArrivalCity = By.xpath("//div[contains(@class,'to-container dropdown-city')]//input[contains(@type,'text')]");
    private static By ArrivalCitySuggestion = By.xpath("//div[contains(@class,'city-detail-container')][1]");
    private static By SearchExistingEmpGuest = By.xpath("//div[contains(@class,'multisuggest-input    css-1hck4gz')]");
    private static By AddAsGuest = By.xpath("//span[@class=\"dynamic-add-btn\"]");
    private static By SearchBuses = By.xpath("//button[text()='Search buses']");
    private static By InputFieldFromCIty = By.xpath("//span[text()='From']/following-sibling::input");

    private static By InputToDestination = By.xpath("//span[text()='To']/following-sibling::input");

    private static By ViewDetail = By.xpath("//button[text()='View details']");

    private static By clickAtBookCTA = By.xpath("//div[@class='book-cta']");

    private static By addNewGuest = By.xpath("//span[@class='add-new-guest']");


    //Add Guest
    private static By fristName = By.xpath("//input[@id=\"firstName\"]");

    private static By lastName = By.xpath("//input[@id=\"lastName\"]");

    private static By mobileNumber = By.xpath("//input[@id=\"contactNo\"]");

    private static By emailAddress = By.xpath("//input[@id =\"email\"]");

    private static By selectSeat = By.xpath("//div[@class='seats-element   ']");
    private static By clickAtDoneButtonOfSeat = By.xpath("//button[text()='Done']");

    private static By addSeat = By.xpath("//div[@class='add-cta '] ");

    private static By Wallet = By.xpath("//span[text()='Wallet']");

    private static By confirmBooking = By.xpath("//button[text()='Confirm booking']");

    private static By priceIncreasePopup = By.xpath("//div[@class='msg-icon-container']");


    private static By increasedPriceContinue = By.xpath("//button[text()='Continue'] ");

    private static By bookingID = By.xpath("//div[@class='booking-id'] ");

    private static By BTC = By.xpath("//span[text()='Bill to company']");

    private static By busCharges = By.xpath("(//span[@class='price '])[1]");

    private static By taxesFees = By.xpath("(//span[@class='price '])[2]");

    private static By convenienceFees = By.xpath("(//span[@class='price '])[2]");
    private static By totalAmout = By.xpath("(//span[@class='price total'])[1]");

    private static By bookingsTab = By.xpath("//span[text()='Bookings']");

    private static By bookingBusesSection = By.xpath("//span[text()='BUSES']");
    private static By bookingSearchByIDTripID = By.xpath("//input[@data-testid='searchBar']");

    private static By bookingStatusPast = By.xpath("//span[text()='Past']");

    private static By bookingStatusFuture = By.xpath("//span[text() ='Upcoming']");
    private static By BookingStatusOngoing = By.xpath("//span[text()='Ongoing']");

    public static void clickOnBookNowBus() {

        CommonFunctionsWeb.click(BookNow, "Click at BookNow option");
        CommonFunctionsWeb.click(BookBus, "Click at Bus(es)");

    }

    public static void fillTravellerForm(String employeelastname, String phoneno, String email) {
        CommonFunctionsWeb.waitForVisibility(fristName);
        CommonFunctionsWeb.enterCharacter(fristName, employeelastname, "Enter Name");
        CommonFunctionsWeb.enterCharacter(mobileNumber, phoneno, "Enter mobile no");
        CommonFunctionsWeb.enterCharacter(emailAddress, email, "Enter email");
        CommonFunctionsWeb.enterCharacter(lastName, "Singh", "lastName of Traveller");
        CommonFunctionsWeb.click(addSeat, "Add Seat Option");
    }


    public static void searchBuses() throws InterruptedException {

        CommonFunctionsWeb.enterCharacter(InputFieldFromCIty, "Bangalore", "Enter the City of Departure");
        CommonFunctionsWeb.hardwait(3);
        CommonFunctionsWeb.click(DepartureCitySuggestion, "Select the 1st suggestion from the dropdown");
        CommonFunctionsWeb.hardwait(3);
        CommonFunctionsWeb.enterCharacter(InputToDestination, "Hyderabad", "Destination");
        CommonFunctionsWeb.hardwait(3);
        CommonFunctionsWeb.click(ArrivalCitySuggestion, "Arrival City Suggestion");
        CommonFunctionsWeb.hardwait(3);
        CommonFunctionsWeb.waitForElementToBeClikable(SearchBuses);
        CommonFunctionsWeb.click(SearchBuses, "Clicked on Search Button");
        CommonFunctionsWeb.hardwait(5);
        CommonFunctionsWeb.waitForElementToBeClikable(ViewDetail);
        CommonFunctionsWeb.click(ViewDetail, "Click at view details");
        CommonFunctionsWeb.click(clickAtBookCTA, "Clicked at Book Now bus button");
        CommonFunctionsWeb.click(addNewGuest, "Clicked at to add new guest for BusTravelling");


    }


    public static void bookSeat() {
        CommonFunctionsWeb.waitForVisibility(selectSeat);
        CommonFunctionsWeb.click(selectSeat, "select sheet");
        System.out.println(CommonFunctionsWeb.getText(selectSeat, "get Price"));
        CommonFunctionsWeb.click(clickAtDoneButtonOfSeat, "Click at Done button of seat Popup");

    }


    public static void selectPaymemtMode(String paymentMode) throws InterruptedException {

        CommonFunctionsWeb.waitForVisibility(Wallet);

        if (paymentMode.contains("Wallet"))
            CommonFunctionsWeb.click(Wallet, "selectType of paymemt");
        else
            CommonFunctionsWeb.click(BTC, "Payment Mode BTC");
        CommonFunctionsWeb.click(confirmBooking, "payment/Booking confirmatation");
        CommonFunctionsWeb.hardwait(5);
        if (CommonFunctionsWeb.getElements(priceIncreasePopup).size() > 0) {
            CommonFunctionsWeb.click(increasedPriceContinue, "Continue Button");

        }

        System.out.println(CommonFunctionsWeb.getText(bookingID, "Booking ID fetch"));
        System.out.println(CommonFunctionsWeb.getText(busCharges, "Buses Charges"));
        System.out.println(CommonFunctionsWeb.getText(taxesFees, "Taxes Changes"));
        System.out.println(CommonFunctionsWeb.getText(convenienceFees, "convenience Fees "));
        System.out.println(CommonFunctionsWeb.getText(totalAmout, "Total Amount "));

    }


    public static void searchBooking() {
        CommonFunctionsWeb.click(bookingsTab, "Clicking at Booking Tab");
        CommonFunctionsWeb.click(bookingBusesSection, "Click at Booking Section");
        CommonFunctionsWeb.enterCharacter(bookingSearchByIDTripID, "B8WJMKN", "Search By Booking ID");

    }

}
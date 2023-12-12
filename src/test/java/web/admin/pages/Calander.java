package web.admin.pages;

import org.openqa.selenium.By;
import utilities.CommonFunctionsWeb;

public class Calander {

    public static By checkindate = By.xpath("(//div[@id=\"calendar-input\"])[1]");

    public static By checkOutdate = By.xpath("(//div[@id=\"calendar-input\"])[2]");
    public static By yearAndMontElement = By.xpath("//div[@class=\"month-layout-wrapper\"]//span");
    public static By leftSideIcon = By.xpath("(//i)[1]");
    public static By rightSideIcon = By.xpath("(//i)[2]");
    public static By dateElement = By.xpath("//div[@id='day' and contains(@data-datevalue,'00:00:00')]");
    public static By flight_yearAndMontElement = By.xpath("//span[@class='monthValue']");

    public static By flight_dateElement = By.xpath("//div[@role = 'button']");

    public static By nextButton = By.xpath("//button[@aria-label=\"Next Month\"]");

    public static By flightElement = By.xpath("//div[contains(@aria-label,\"Jan\")]");

    private static By userDateElement = By.xpath("//span[text()='User date']/following-sibling::input");

    private static By monthTextDropdown = By.xpath("//div[contains(@class,'month-selctor')]//span[@class=\"dropdown-btn-text\"]");

    private static By yearsNameElement = By.xpath("//span[@class=\"item-text\"]");
    private static By yearTextDropDown = By.xpath("//div[contains(@class,'year-selctor')]//span[@class=\"dropdown-btn-text\"]");

    /*b B2C calendar*/
    private static By b2c_checkindate = By.xpath("//div[@class=\"date-input false\"]");

    private static By b2c_yealandMonth = By.xpath("(//th[@align=\"center\"])[1]");

    private static By currentDateElement = By.xpath("//td[contains(@class,'current-date')]");

    private static By b2cnextbuttonelement = By.cssSelector("[class=\"next-icon\"]");

    private static By selectCheckInDaye = By.xpath("(//div[@class=\"datepicker-wrapper\"]//table)[1]//td[contains(@class,'styledHOC')]");

    private static By b2c_checkoutyealandMonth = By.xpath("(//th[@align=\"center\"])[2]");

    private static By b2c_checkoutDaye = By.xpath("(//div[@class=\"datepicker-wrapper\"]//table)[2]//td[contains(@class,'styledHOC')]");



    public static void selectCheckInAndCheckOutDateFromCalandar(String yearandmonth, String day) throws InterruptedException {//Dec 2023
        if (CommonFunctionsWeb.getText(yearAndMontElement, "Current Year And Month").equalsIgnoreCase(yearandmonth) && CommonFunctionsWeb.getText(dateElement, "Date").equalsIgnoreCase(day) && CommonFunctionsWeb.verifyAttributValue(dateElement, "false", "data-disabledday", "Date Attribute")) {
            CommonFunctionsWeb.click(dateElement, "Date");
        } else {
            while (!(CommonFunctionsWeb.getText(yearAndMontElement, "").equalsIgnoreCase(yearandmonth))) {
                CommonFunctionsWeb.click(rightSideIcon, "Right side icon of calander");
                System.out.println(CommonFunctionsWeb.getText(yearAndMontElement, "") + " " + yearandmonth);
                CommonFunctionsWeb.waitForVisibility(yearAndMontElement);
            }
            CommonFunctionsWeb.getElements(dateElement).get(Integer.parseInt(day) - 1).click();

        }
    }


    public static void selectDepAndArriavaldate(String yearandmonth, String day) {
        if (CommonFunctionsWeb.getText(flight_yearAndMontElement, "Current Year And Month").equalsIgnoreCase(yearandmonth) && CommonFunctionsWeb.getText(flight_dateElement, "Date").equalsIgnoreCase(day) && CommonFunctionsWeb.verifyAttributValue(flight_dateElement, "false", "aria-disabled", "Date Attribute")) {
            CommonFunctionsWeb.click(flight_dateElement, "Date");
        } else {
            while (!CommonFunctionsWeb.getText(flight_yearAndMontElement, "").equalsIgnoreCase(yearandmonth)) {
                CommonFunctionsWeb.click(nextButton, "Right side icon of calender");
                CommonFunctionsWeb.waitForVisibility(flight_yearAndMontElement);
            }
            CommonFunctionsWeb.getElements(By.xpath("//div[contains(@aria-label,'" + yearandmonth.split(" ")[0] + "')]")).get(Integer.parseInt(day) - 1).click();
        }
    }

    public static void selectUserDate(String month, String year, String day) {
        CommonFunctionsWeb.click(userDateElement, "");
        CommonFunctionsWeb.click(monthTextDropdown, "");
        for (int i = 0; i < CommonFunctionsWeb.getElements(yearsNameElement).size(); i++) {
            if (CommonFunctionsWeb.getElements(yearsNameElement).get(i).getText().equalsIgnoreCase(month)) {
                CommonFunctionsWeb.getElements(yearsNameElement).get(i).click();
            }
        }
        CommonFunctionsWeb.click(yearTextDropDown, "Year drop down text element");
        for (int i = 0; i < CommonFunctionsWeb.getElements(yearsNameElement).size(); i++) {
            if (CommonFunctionsWeb.getElements(yearsNameElement).get(i).getText().equalsIgnoreCase(year)) {
                CommonFunctionsWeb.getElements(yearsNameElement).get(i).click();
            }
        }
        CommonFunctionsWeb.getElements(By.xpath("//div[contains(@aria-label,'" + year + "')]")).get(Integer.parseInt(day) - 1).click();

    }


    public static void selectCheckInDate(String yearandmonth, String day) {
        if (CommonFunctionsWeb.getText(b2c_yealandMonth, "Current Year And Month").equalsIgnoreCase(yearandmonth) && CommonFunctionsWeb.getText(currentDateElement, "Date").equalsIgnoreCase(day)) {
            CommonFunctionsWeb.click(currentDateElement, "Date");
        } else {
            while (!(CommonFunctionsWeb.getText(b2c_yealandMonth, "").equalsIgnoreCase(yearandmonth))) {
                CommonFunctionsWeb.click(b2cnextbuttonelement, "Right side icon of calander");
                CommonFunctionsWeb.waitForVisibility(b2c_yealandMonth);
            }
            CommonFunctionsWeb.getElements(selectCheckInDaye).get(Integer.parseInt(day) - 1).click();
        }


    }

    public static void checkoutdate(String yearandmonth, String day) {
        if (CommonFunctionsWeb.getText(b2c_yealandMonth, "Current Year And Month").equalsIgnoreCase(yearandmonth)) {
            CommonFunctionsWeb.getElements(selectCheckInDaye).get(Integer.parseInt(day) - 1).click();
        } else {
            CommonFunctionsWeb.getElements(b2c_checkoutDaye).get(Integer.parseInt(day) - 1).click();
        }
    }




}

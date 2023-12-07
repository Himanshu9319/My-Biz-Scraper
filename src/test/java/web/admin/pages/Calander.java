package web.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
            while (!CommonFunctionsWeb.getText(flight_yearAndMontElement, "").equalsIgnoreCase(yearandmonth)){
                CommonFunctionsWeb.click(nextButton, "Right side icon of calender");
                CommonFunctionsWeb.waitForVisibility(flight_yearAndMontElement);
            }
            CommonFunctionsWeb.getElements(By.xpath("//div[contains(@aria-label,'"+yearandmonth.split(" ")[0]+"')]")).get(Integer.parseInt(day)-1).click();
        }

    }
}

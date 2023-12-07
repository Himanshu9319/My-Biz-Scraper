package mobile.travelplus.tests.steps;

import com.redis.S;
import mobile.travelplus.tests.pages.HomePage;
import mobile.travelplus.tests.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Base;
import utilities.CommonFunctionsMobile;
import utilities.TestUtilities;

import java.util.Properties;
import java.util.Scanner;

import static mobile.travelplus.tests.pages.LoginPage.clickonproceedbutton;

public class StepApproval {

    Properties properties = TestUtilities.addConfigProperties(Base.property.getProperty("environment"));

    HomePage hp = new HomePage();

    @Given("Login application with employee {string}")
    public void loginApplicationWithEmployee(String username) throws Exception {
        LoginPage.login(properties.getProperty(username));
    }

    @Then("Click send otp button")
    public void clickSendOtpButton() throws Exception {
        LoginPage.clickOnSendButton();
    }

    @When("Enter otp on first box {string}")
    public void enterOtpOnFirstBox(String otp) throws Exception {
        LoginPage.enterOtp(otp);
    }

//    @When("Enter otp on second box {string}")
//    public void enterOtpOnSecondBox(String otpDigitTtwo) throws Exception {
//        LoginPage.entersecondotpdigit(otpDigitTtwo);
//
//    }

//    @When("Enter otp on third box {string}")
//    public void enterOtpOnThirdBox(String otp3DigitThree) throws Exception {
//        LoginPage.enterthreeotpdigit(otp3DigitThree);
//    }

//    @When("Enter otp on fourth box {string}")
//    public void enterOtpOnFourthBox(String otpDigitFour) throws Exception {
//        LoginPage.enterfourthotpdigit(otpDigitFour);
//    }

//    @When("Enter otp on fifth box {string}")
//    public void enterOtpOnfifthBox(String otpDigitFive) throws Exception {
//        LoginPage.enterfourthotpdigit(otpDigitFive);
//    }
//
//    @When("Enter otp on sixth box {string}")
//    public void enterOtpOnSixthBox(String otpDigitSix) throws Exception {
//        LoginPage.enterfourthotpdigit(otpDigitSix);
//    }


//    @Given("Scroll the payment page")
//    public void scrollThePaymentPage() throws Exception {
//        //hp.scrollScreen();
//        //  hp.randomClick();;
//    }

//    @When("Click on create tripbutton")
//    public void clickOnCreateTripbutton() throws Exception {
//        hp.clickOncreateTrip();
//    }

//    @When("Click on add flight button")
//    public void clickOnAddFlightButton() throws Exception {
//        hp.addFlight();
//    }

//    @When("Select date")
//    public void selectDate() throws Exception {
//        hp.selectDate();
//    }

    @When("Click on proceed button")
    public void clickOnProceedButton() throws Exception {
        clickonproceedbutton();
    }


}

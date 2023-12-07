package api.travelplus.tests.steps;

import UtilsAPI.TravelPlus.requestDto.Confirm.Details;
import UtilsAPI.TravelPlus.responseDto.Confirm.Confirm;
import UtilsAPI.TravelPlus.responseDto.Initial.InitalResponse;
import UtilsAPI.TravelPlus.responseDto.Login_Response;
import UtilsAPI.TravelPlus.responseDto.Payment.Payload;
import UtilsAPI.helper.AccessToken;
import UtilsAPI.helper.StandardResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.reporters.EmailableReporter;
import utilities.Constants;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static UtilsAPI.TravelPlus.HitApi.*;


public class Flight_Booking_Flow {
    private static ExtractableResponse<Response> response;
    public static String email;

    @Given("Admin Login with his {string}")
    public void adminLoginWithHis(String emailID) {
        email = emailID;
        response = post_v1_app_login(emailID);
    }

    @When("Get auth token {string} {string}")
    public void getAuthToken(String email, String otp) {
        response = post_v1_get_auth_token(email, otp);
        AccessToken.accessToken = response.cookie("token");
    }

    @Then("validate HTTP status code for login api {int} {string}")
    public void validateHTTPStatusCodeForLoginApiHttpStatusCode(int httpstatuscode, String message) {
        Assert.assertEquals(response.statusCode(), httpstatuscode);
        StandardResponse<Login_Response> standardResponseschema = response.statusCode() == 200 ? StandardResponse.parseJsonResponse(response.response().asPrettyString(), Login_Response.class) : null;
        Assert.assertNotNull(standardResponseschema, "Expected and actual response of login api is different");
        Assert.assertEquals(response.response().jsonPath().get("message"), message);
    }

    @Given("User enter the details and search for the flight {string}  {string} {string} {string}  {string}")
    public void userEnterTheDetailsAndSearchForTheFlight(String origin, String destination, String depature, String travller, String travelClass) {
        response = post_v1_search_flights(AccessToken.accessToken, origin, destination, depature, travller, travelClass);
    }

    @Then("Validate HTTP status code and response for search Api {int} {string}")
    public void validateHTTPStatusCodeAndResponseForSearchApi(int httpsstatuscode, String message) {
        Assert.assertEquals(response.statusCode(), httpsstatuscode);
        String schemaPath = Constants.USER_DIR + Constants.FLIGHT_BOOKING_API_EXPECTED_SCHEMA_PATH + "search.json";
        //response.body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
        // response.response().then().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
        Assert.assertEquals(response.response().jsonPath().get("message").toString().trim(), message);
    }


    @When("User is able to book the flight {string}  {string} {string} {string}  {string}")
    public void userIsAbleToBookTheFlight(String origin, String destination, String depature, String noOfTraveller, String trvelClass) throws IOException {
        response = post_v1_book_flight(AccessToken.accessToken, noOfTraveller, origin, destination, depature, trvelClass);
    }

    @Then("Validate HTTP status code and response for book flights  Api {int} {string}")
    public void validateHTTPStatusCodeAndResponseForBookFlightsApiHttpstatuscode(int httpsstatuscode, String message) {
        Assert.assertEquals(response.statusCode(), httpsstatuscode);
        Assert.assertEquals(response.response().jsonPath().get("message").toString().trim(), message);
    }


    @When("the following booking information with {string}")
    public void theFollowingBookingInformationWith(String walletoption, DataTable dataTable) throws JsonProcessingException {
        response = post_v1_payment(AccessToken.accessToken, dataTable, walletoption);
    }

    @Then("validate HTTP status code and payment response {int} {string}")
    public void validateHTTPStatusCodeAndPaymentResponseHttpstatuscode(int httpstatuscode, String message) {
        Assert.assertEquals(response.statusCode(), httpstatuscode);
        StandardResponse<Payload> standardResponse = response.statusCode() == 200 ? StandardResponse.parseJsonResponse(response.response().asPrettyString(), Payload.class) : null;
        Assert.assertNotNull(standardResponse, "Response is not matched");
        Assert.assertEquals(response.response().jsonPath().get("message").toString().trim(), message);
    }

    @When("User hit the confirm post request")
    public void userHitTheConfirmPostRequest() {
        response = post_v3_confirm(AccessToken.accessToken);
    }

    @Then("Validate HTTP status code and conform response {int} {string}")
    public void validateHTTPStatusCodeAndConformResponseHttpstatuscode(int httpstatuscode, String message) {
        Assert.assertEquals(response.statusCode(), httpstatuscode);
        Assert.assertEquals(response.response().jsonPath().get("message").toString().trim(), message);
    }

    @Then("Validate flight booking details")
    public void validateFlightBookingDetails() {
        response = post_v3_details(AccessToken.accessToken);
    }


    @Then("validate HTTP status code and response message {int} {string}")
    public void xvalidateHTTPStatusCodeAndResponseMessageHttpstatuscode(int statuscode, String message) {
        Assert.assertEquals(response.statusCode(), statuscode);
        Assert.assertEquals(response.response().jsonPath().get("message").toString().trim(), message);
//        StandardResponse<Details> standardResponse = response.statusCode() == 200 ? StandardResponse.parseJsonResponse(response.response().asPrettyString(), Details.class) : null;
//        Assert.assertNotNull(standardResponse, "Expected and actual response of login api is different");
    }

    @When("Hit confirm payment request {string}")
    public void hitConfirmPaymentRequest(String paymentoption) {
        post_v3_create(AccessToken.accessToken, response.jsonPath().get("data.potMasterBookingId"), paymentoption);
    }

    @Then("Validate flight booking HTTP status code and message")
    public void validateFlightBookingHTTPStatusCodeAndMessage(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            if (columns.get("field").equalsIgnoreCase("statuscode")) {
                Assert.assertEquals(response.statusCode(), Integer.parseInt(columns.get("value")));

            } else if (columns.get("field").equalsIgnoreCase("message")) {
                Assert.assertEquals(response.response().jsonPath().get("message"), columns.get("value"));
            }
        }
        Assert.assertEquals((response.response().jsonPath().get("data.bookingDetails[0].bookingDetail.bookingStatus")), "CONFIRMED");
    }


    @When("User is able to book the flight for source {string}  {string} {string} {string}  {string} {string} {string} {string}")
    public void userIsAbleToBookTheFlightForSource(String origin, String destination, String depature, String noOfTraveller, String trvelClass, String provider, String airlinecode, String pricetype) throws JsonProcessingException {
        post_v1_book_flight_forgivenprovider(AccessToken.accessToken, noOfTraveller, origin, destination, depature, trvelClass, provider, airlinecode, pricetype);
    }

    @When("the follow booking information with add-ons {string} {string}")
    public void theFollowBookingInformationWithAddOns(String walletoption, String addons, DataTable dataTable) throws JsonProcessingException {
        response = post_v1_payment_with_add_ons(AccessToken.accessToken, dataTable, walletoption, addons);
    }
}

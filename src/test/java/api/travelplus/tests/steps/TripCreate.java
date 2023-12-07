package api.travelplus.tests.steps;

import UtilsAPI.TravelPlus.responseDto.Login_Response;
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
import utilities.Base;
import utilities.Constants;
import utilities.TestUtilities;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static UtilsAPI.TravelPlus.HitApi.post_v1_get_auth_token;
import static UtilsAPI.TravelPlus.HitApi.post_v3_create;
import static UtilsAPI.trip.HitApi.*;

public class TripCreate {


    private static ExtractableResponse<Response> response;
    private static ExtractableResponse<Response> approvalresponse;

    private static String accesstoken = "";

    private static String masterBookingid = "";


    Properties properties = TestUtilities.addConfigProperties(Base.property.getProperty("env"));

    @Given("Employee Login with his {string}")
    public void employeeLoginWithHis(String email) {
        post_v1_employee_login(properties.getProperty(email));
    }

    @When("Get employee auth token {string} {string}")
    public void getEmployeeAuthToken(String email, String otp) {
        response = post_v1_employee_get_auth_token(properties.getProperty(email), otp);
        AccessToken.accessToken = response.cookie("token");
        accesstoken = AccessToken.accessToken;


    }

    @Then("validate Employee HTTP status code for login api {int} {string}")
    public void validateEmployeeHTTPStatusCodeForLoginApiHttpStatusCode(int httpstatuscode, String message) {
        Assert.assertEquals(response.statusCode(), httpstatuscode);
        Assert.assertEquals(response.response().jsonPath().get("message"), message);
        String schemaPath = Constants.USER_DIR + Constants.TRIP_CREATE_API_EXPECTED_SCHEMA_PATH + "Login.json";
        response.response().then().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
    }

    @Given("User enter the Employee details and search for the flight {string}  {string} {string} {int} {string} {string} {string}")
    public void userEnterTheEmployeeDetailsAndSearchForTheFlight(String from, String to, String deapturedate, int travller, String travellerclass, String arrivalCity, String sourcecity) {
        response = post_v2_empoyee_search_flights(AccessToken.accessToken, from, to, deapturedate, travller, travellerclass, arrivalCity, sourcecity);
    }

    @Then("Validate search api status code and message and schema")
    public void validateSearchApiStatusCodeAndMessageAndSchema(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            if (columns.get("field").equalsIgnoreCase("statuscode")) {
                Assert.assertEquals(response.statusCode(), Integer.parseInt(columns.get("value")));
            } else if (columns.get("field").equalsIgnoreCase("message")) {
                Assert.assertEquals(response.response().jsonPath().get("message"), columns.get("value"));
            }
        }
//        String schemaPath = Constants.USER_DIR + Constants.TRIP_CREATE_API_EXPECTED_SCHEMA_PATH + "search.json";
//        response.response().then().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
    }

    @When("User create a trip {string}  {string} {string} {string} {string} {string} {string} {int}")
    public void userCreateATrip(String sourcecity, String arrivalcity, String travvellerclass, String purposeoftravel, String type, String bookingmode, String depaturedate, int nooftravller) throws JsonProcessingException {
        response = post_v2_employee_book_flight(AccessToken.accessToken, nooftravller, sourcecity, arrivalcity, depaturedate, travvellerclass, type, bookingmode);
    }

    @When("MANAGER one login and approval")
    public void managerOneLoginAndApproval(DataTable table) {
        String email = "";
        String otp = "";
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            if (columns.get("field").equalsIgnoreCase("email")) {
                email = properties.getProperty(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("otp")) {
                otp = columns.get("value");
            }
        }
        post_v1_employee_login(email);
        approvalresponse = post_v1_employee_get_auth_token(email, otp);
        AccessToken.accessToken = approvalresponse.cookie("token");
        manager_one_approval(AccessToken.accessToken, response.jsonPath().get("data.masterTripId"), "Looks good");
    }

    @When("MANAGER two login and approval")
    public void managerTwoLoginAndApproval(DataTable table) {
        String email = "";
        String otp = "";
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            if (columns.get("field").equalsIgnoreCase("email")) {
                email = properties.getProperty(columns.get("value"));

            } else if (columns.get("field").equalsIgnoreCase("otp")) {
                otp = columns.get("value");
            }

        }
        post_v1_employee_login(email);
        approvalresponse = post_v1_employee_get_auth_token(email, otp);
        AccessToken.accessToken = approvalresponse.cookie("token");
        manager_one_approval(AccessToken.accessToken, response.jsonPath().get("data.masterTripId"), "Looks good");

    }

    @When("MANAGER three login and approval")
    public void managerThreeLoginAndApproval(DataTable table) {
        String email = "";
        String otp = "";
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            if (columns.get("field").equalsIgnoreCase("email")) {
                email = properties.getProperty(columns.get("value"));

            } else if (columns.get("field").equalsIgnoreCase("otp")) {
                otp = columns.get("value");
            }

        }
        post_v1_employee_login(email);
        approvalresponse = post_v1_employee_get_auth_token(email, otp);
        AccessToken.accessToken = approvalresponse.cookie("token");
        masterBookingid = response.jsonPath().get("data.masterTripId");
        response = manager_one_approval(AccessToken.accessToken, response.jsonPath().get("data.masterTripId"), "Looks good");

    }

    @Then("Validate HTTPS status code and message for trip approval")
    public void validateHTTPSStatusCodeAndMessageForTripApproval(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            if (columns.get("field").equalsIgnoreCase("statuscode")) {
                Assert.assertEquals(response.statusCode(), Integer.parseInt(columns.get("value")));

            } else if (columns.get("field").equalsIgnoreCase("message")) {
                Assert.assertEquals(response.response().jsonPath().get("data.tripStatus"), columns.get("value"));
            }
        }
        String schemaPath = Constants.USER_DIR + Constants.TRIP_CREATE_API_EXPECTED_SCHEMA_PATH + "triplaststepapproval.json";
        response.response().then().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
    }

    @Then("Validate pnr status")
    public void validatePnrStatus() {
        response = get_ticket_details(accesstoken, masterBookingid);
        Assert.assertNotNull(response.response().jsonPath().get("data.subTripsDetails[0].flightBookingDetails"));
    }


}

package api.travelplus.tests.steps;

import UtilsAPI.HotelBooking.responseDto.initiated.Data;
import UtilsAPI.HotelBooking.responseDto.initiated.Initiate;
import UtilsAPI.TravelPlus.responseDto.Login_Response;
import UtilsAPI.helper.AccessToken;
import UtilsAPI.helper.StandardResponse;
import com.google.gson.JsonArray;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import io.cucumber.java.zh_tw.假設;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import scala.Int;
import utilities.DateUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static UtilsAPI.HotelBooking.HitApi.*;
import static api.travelplus.tests.steps.Flight_Booking_Flow.email;

public class HotelBookingFlow {
    ExtractableResponse<Response> response;
    protected static String searchid;
    protected static String checkindate;
    protected static String checkout;

    public static int proerty_id;
    public static String rate;

    public static String provider;

    public static String ratePlanId;
    public static String roomtypeid;

    @Given("User enter the details for search api {string} {string} {string} {string} {string}")
    public void userEnterTheDetailsForSearchApi(String city, String locality, String lattitude, String longitude, String occupancy) {
        checkindate = DateUtils.generateRandomCheckInDate();
        checkout = DateUtils.generateRandomCheckOutDate(checkindate);
        response = get_v2_initiate_search(AccessToken.accessToken, checkindate, checkout, city, locality, lattitude, longitude, "", occupancy);
    }

    @Then("Validate Response and status code {string} {int}")
    public void validateResponseAndStatusCodeStatuscode(String message, int httpstatuscode) {
        searchid = response.jsonPath().get("data.searchId");
        Assert.assertEquals(response.statusCode(), httpstatuscode);
        StandardResponse<Initiate> standardResponseschema = response.statusCode() == 200 ? StandardResponse.parseJsonResponse(response.response().asPrettyString(), Initiate.class) : null;
        Assert.assertNotNull(standardResponseschema, "Expected and actual response of login api is different");
        Assert.assertEquals(response.response().jsonPath().get("message"), message);
    }


    @When("User hit the search get request {string} {string} {string} {string} {string}")
    public void userHitTheSearchGetRequest(String city, String locality, String lattitude, String longitude, String occupancy) throws InterruptedException {
        response = get_v2_search(AccessToken.accessToken, city, locality, checkindate, checkout, lattitude, longitude, "", "true", occupancy, "false", searchid, "false");
        while (response.jsonPath().get("data.allPropertiesFetched").equals(false)) {
            response = get_v2_search(AccessToken.accessToken, city, locality, checkindate, checkout, lattitude, longitude, "", "true", occupancy, "false", searchid, "false");
        }
    }


    @When("User create hotels booking {string}")
    public void userCreateHotelsBooking(String occupancy) {
        proerty_id = response.jsonPath().get("data.properties[0].id");
        rate = response.jsonPath().get("data.properties[0].rate.type");
        provider = response.jsonPath().get("data.properties[0].rate.provider");
        ArrayList<Integer> occupancyList = new ArrayList<>();
        if (occupancy.length() == 1) {
            occupancyList.add(Integer.parseInt(occupancy));
            response = post_v2_bookingcreate(AccessToken.accessToken, proerty_id, rate, checkindate, checkout, provider, searchid, occupancyList);
        } else {
            String[] occupancylist = occupancy.split(",");
            for (int i = 0; i < occupancylist.length; i++) {
                occupancyList.add(Integer.parseInt(occupancylist[i]));
            }
            response = post_v2_bookingcreate(AccessToken.accessToken, proerty_id, rate, checkindate, checkout, provider, searchid, occupancyList);
        }
    }

    @When("User enter following booking information with payment option {string} {string} {string} {string}")
    public void userEnterFollowingBookingInformationWithPaymentOption(String paymentoption, String guestType, String occupancy, String currentGSTStatus, DataTable dataTable) {
        ratePlanId = response.jsonPath().get("data.roomTypeMeta[0].ratePlans[0].id");
        roomtypeid = response.jsonPath().get("data.roomTypeMeta[0].roomTypeId");
        ArrayList<Integer> occupancyList = new ArrayList<>();

        if (occupancy.length() == 1) {
            occupancyList.add(Integer.parseInt(occupancy));
            response = post_v2_hotelbooking(AccessToken.accessToken, dataTable, "", proerty_id, rate, Boolean.parseBoolean(currentGSTStatus), occupancyList, checkindate, checkout, searchid, paymentoption, ratePlanId, roomtypeid, guestType);
        } else {
            String[] occupancylist = occupancy.split(",");
            for (int i = 0; i < occupancylist.length; i++) {
                occupancyList.add(Integer.parseInt(occupancylist[i]));
            }
            response = post_v2_hotelbooking(AccessToken.accessToken, dataTable, "", proerty_id, rate, Boolean.parseBoolean(currentGSTStatus), occupancyList, checkindate, checkout, searchid, paymentoption, ratePlanId, roomtypeid, guestType);
        }
    }

    @Then("Validate HTTP status code and message")
    public void validateHTTPStatusCodeAndMessage(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            if (columns.get("field").equalsIgnoreCase("statuscode")) {
                Assert.assertEquals(response.statusCode(), Integer.parseInt(columns.get("value")));

            } else if (columns.get("field").equalsIgnoreCase("message")) {
                Assert.assertEquals(response.response().jsonPath().get("message"), columns.get("value"));
            }
        }
    }

    @When("Search api validation {string} {string} {string} {string} {string}")
    public void searchApiValidation(String city, String locality, String lattitude, String longitude, String occupancy) throws InterruptedException {
        int totalresponsetime = 0;
        int oneapitime = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> apiresponsetime = new ArrayList<>();
        System.out.println(email);
        response = get_v2_search(AccessToken.accessToken, city, locality, checkindate, checkout, lattitude, longitude, "", "true", occupancy, "false", searchid, "false");
        oneapitime = (int) (response.response().getTime());
        JSONObject jsonObject = new JSONObject(response.response().prettyPrint());
        JSONArray jsonarray = jsonObject.getJSONObject("data").getJSONArray("properties");
        Thread.sleep(1000);
        int sum = 0;
        while (response.jsonPath().get("data.allPropertiesFetched").equals(false) || response.jsonPath().get("data.nextPage").equals(true)) {
            if (response.jsonPath().get("data.nextPage").equals(true) && response.jsonPath().get("data.allPropertiesFetched").equals(false)) {
                response = get_v2_search(AccessToken.accessToken, city, locality, checkindate, checkout, lattitude, longitude, "", "true", occupancy, "false", searchid, "false");
                oneapitime=oneapitime+(int)(response.response().getTime());
                continue;
            } else if (response.jsonPath().get("data.nextPage").equals(true) && response.jsonPath().get("data.allPropertiesFetched").equals(true)) {
                response = get_v2_search(AccessToken.accessToken, city, locality, checkindate, checkout, lattitude, longitude, "", "true", occupancy, "false", searchid, "false");

            } else if (response.jsonPath().get("data.nextPage").equals(false) && response.jsonPath().get("data.allPropertiesFetched").equals(false)) {
                response = get_v2_search(AccessToken.accessToken, city, locality, checkindate, checkout, lattitude, longitude, "", "true", occupancy, "false", searchid, "false");

            }
            totalresponsetime = (int) (totalresponsetime + response.response().getTime());
            apiresponsetime.add(oneapitime);

            //  response = get_v2_search(AccessToken.accessToken, city, locality, checkindate, checkout, lattitude, longitude, "", "true", occupancy, "false", searchid, "false");
            jsonObject = new JSONObject(response.response().prettyPrint());
            jsonarray = jsonObject.getJSONObject("data").getJSONArray("properties");
            sum = sum + jsonarray.length();
            try {
                // Generate a timestamp for the filename
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String timestamp = dateFormat.format(new Date());
                // Create a unique filename using the timestamp
                String fileName = "/Users/fabhotels/Downloads/FabHotels/src/test/resources/CopyJson_" + "vikas" + city + timestamp + ".json";

                // Write the JSON to the new file
                try (FileWriter file = new FileWriter(fileName)) {
                    file.write(response.response().getBody().prettyPrint());
                    System.out.println("Successfully Copied JSON Object to File: " + fileName);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            for (int i = 0; i < jsonarray.length(); i++) {
                list.add(response.jsonPath().get("data.properties[" + i + "].id"));
            }

        }
        System.out.println("-------------------------------" + sum);
        Collections.sort(list);
        for (Integer integer : list) {
            if (email.equalsIgnoreCase("vikas.yadav@fabmailers.in")) {
                writeDataOnCSVFile2(city, integer, 0, totalresponsetime, oneapitime);
            } else if (email.equalsIgnoreCase("anuj.joshi+2@fabhotels.com")) {
                writeDataOnCSVFile2(city, 0, integer, totalresponsetime, oneapitime);

            }

        }
    }

    public static void writeDataOnCSVFile2(String cityname, int hotelId1, int hotelId2, int totalresponsetime, int perapiresponsetime) {
        String filePath = "//Users//fabhotels//Downloads//FabHotels//src//test//resources//id's.csv";

        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(filePath), true))) {
            // If the file does not exist, write the header
            if (new File(filePath).length() == 0) {
                pw.append("Cityname,HotelId,hotelid2,TotalResponseTime\r\n");
            }
            // Write data to the file
            pw.append(cityname);
            pw.print(",");
            pw.print(hotelId1);
            pw.print(",");
            pw.print(hotelId2);
            pw.print(",");
            pw.print(totalresponsetime);
            pw.print(",");
            pw.print(perapiresponsetime);
            pw.println();
            System.out.println("Data added successfully");
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., log it)
        }
    }


    @When("User enter details for internation search {string} {string} {string} {string} {string} {string} {string}")
    public void userEnterDetailsForInternationSearch(String city, String locality, String lattitude, String longitude, String occupancy, String CI, String CO) {
        checkindate = CI;
        checkout = CO;
        response = get_v2_initiate_search(AccessToken.accessToken, checkindate, checkout, city, locality, lattitude, longitude, "", occupancy);
    }
}

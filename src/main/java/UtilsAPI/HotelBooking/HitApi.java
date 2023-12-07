package UtilsAPI.HotelBooking;

import UtilsAPI.HotelBooking.requestDto.Create;
import UtilsAPI.HotelBooking.requestDto.PaymentCreate;
import UtilsAPI.HotelBooking.requestDto.Traveller;
import UtilsAPI.helper.HeaderConstant;
import UtilsAPI.helper.ReqConfig;
import UtilsAPI.helper.RestAssuredHelper;
import io.cucumber.datatable.DataTable;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import utilities.Constants;
import utilities.RandomDataCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HitApi {

    public ExtractableResponse<Response> response;
    public static PaymentCreate paymentCreate;

    public static ExtractableResponse<Response> get_v2_initiate_search(String accesstoken, String checkindate, String checkoutdate, String city, String locality, String latitude, String longitude, String travellerUserIds, String occupancy) {
        String url = Constants.API_URI + Endpoints.INITIATE_SEARCH;
        return RestAssuredHelper.callGetApi(HeaderConstant.getAccessTokenHeader(accesstoken), HeaderConstant.setAndGetParm("checkIn", checkindate, "checkOut", checkoutdate, "city", city, "locality", locality, "latitude", latitude, "longitude", longitude, "travellerUserIds", travellerUserIds, "occupancy", occupancy), url, null, 2);


    }

    public static ExtractableResponse<Response> get_v2_search(String accesstoken, String city, String locality, String checkindate, String checkoutdate, String latitude, String longitude, String travellerUserIds, String outOfPolicy, String occupancy, String recommendedOnly, String searchId, String payAtHotelOnly) {
        String url = Constants.API_URI + Endpoints.HOTEL_SEARCH;
        return RestAssuredHelper.callGetApi(HeaderConstant.getAccessTokenHeader(accesstoken), HeaderConstant.setAndGetParm("city", city, "locality", locality, "checkIn", checkindate, "checkOut", checkoutdate, "latitude", latitude, "longitude", longitude, "travellerUserIds", travellerUserIds, "outOfPolicy", outOfPolicy, "occupancy", occupancy, "recommendedOnly", recommendedOnly, "searchId", searchId), url, null, 4);
    }

    public static ExtractableResponse<Response> post_v2_bookingcreate(String accesstoken, int propertyId, String rate, String checkIn, String checkOut, String provider, String searchId, ArrayList<Integer> occupancy) {
        String url = Constants.API_URI + Endpoints.BOOKINGS_METADATA_CREATE;
        Create create = Create.builder().
                propertyId(propertyId).
                rate(rate).checkIn(checkIn).
                checkOut(checkOut).occupancy(occupancy).
                provider(provider).searchId(searchId).build();
        return RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accesstoken), null, url, create, ReqConfig.getDefaultRequest());
    }

    public static ExtractableResponse<Response> post_v2_hotelbooking(String accesstoken, DataTable table, String hoteltripid, int propertyId, String rate, boolean currentStateGSTAvailable, ArrayList<Integer> occupancy, String chckin, String checkout, String searchid, String paymentoption, String rateTypeId, String roomtypeid, String guestType) {
        String url = Constants.API_URI + Endpoints.BOOKING_CREATE;
        String firstname = RandomDataCreator.generateFirstName();
        String lastname = RandomDataCreator.generateLastname();
        String contactNo = "9319580173";
        String email = RandomDataCreator.generateEmail();
        String gstPincode = null;
        String gstin = null;
        String gstaddress = null;
        String gstCompanyName = null;
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        Traveller traveller = new Traveller();
        traveller.setFirstName(firstname);
        traveller.setLastName(lastname);
        traveller.setMobile(contactNo);
        traveller.setEmail(email);
        traveller.setUserId(null);
        traveller.setGuestType(guestType);
        traveller.setCorporateUserType(null);
        traveller.setCorporateUserTypeResponse(null);
        traveller.setGuestTypeResponse(null);
        traveller.setCorporateUserType(null);
        traveller.setId(null);
        for (Map<String, String> columns : rows) {
            if (columns.get("field").equalsIgnoreCase("traveller[0].title")) {
                traveller.setTitle(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("isSaveDetails")) {
                traveller.setIsSaveDetails(Boolean.valueOf(columns.get("value")));
            } else if (columns.get("field").equalsIgnoreCase("middleName")) {
                traveller.setMiddleName(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTNumber")) {
                gstin = columns.get("value");
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyAddress")) {
                gstaddress = columns.get("value");
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyName")) {
                gstCompanyName = columns.get("value");
            } else if (columns.get("field").equalsIgnoreCase("gstPinCode")) {
                gstPincode = columns.get("value");
            }
        }
        ArrayList<Traveller> travellers = new ArrayList<>();
        travellers.add(traveller);
        if ((paymentoption.equalsIgnoreCase("WALLET") || paymentoption.equalsIgnoreCase("BTC")||paymentoption.equalsIgnoreCase("PAY_AT_HOTEL")) && !currentStateGSTAvailable) {
            paymentCreate = PaymentCreate.builder().hotelTripId(hoteltripid)
                    .propertyId(propertyId).rate(rate).currentStateGSTAvailable(currentStateGSTAvailable).occupancy(occupancy).ratePlanId(rateTypeId).roomTypeId(roomtypeid).paymentMode(paymentoption).checkIn(chckin)
                    .checkOut(checkout).searchId(searchid).travellers(travellers).
                    paymentOption(paymentoption).specialRequests("")
                    .build();
        } else if (paymentoption.equalsIgnoreCase("BTC") && currentStateGSTAvailable) {
            paymentCreate = PaymentCreate.builder().hotelTripId(hoteltripid)
                    .propertyId(propertyId).rate(rate).currentStateGSTAvailable(currentStateGSTAvailable).occupancy(occupancy).ratePlanId(rateTypeId).roomTypeId(roomtypeid).paymentMode(paymentoption).checkIn(chckin)
                    .checkOut(checkout).searchId(searchid).travellers(travellers).
                    paymentOption(paymentoption).specialRequests("").gstin(gstin).gstAddress(gstaddress).gstPinCode(gstPincode).gstCompanyName(gstCompanyName)
                    .build();
        }
        return RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accesstoken), null, url, paymentCreate, ReqConfig.getDefaultRequest());
    }
}

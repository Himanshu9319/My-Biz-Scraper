package UtilsAPI.TravelPlus;

import UtilsAPI.TravelPlus.requestDto.Confirm.Confirm;
import UtilsAPI.TravelPlus.requestDto.*;
import UtilsAPI.TravelPlus.requestDto.Confirm.Details;
import UtilsAPI.TravelPlus.requestDto.Payment.*;
import UtilsAPI.TravelPlus.responseDto.Initial.*;
import UtilsAPI.TravelPlus.responseDto.Search.*;
import UtilsAPI.helper.HeaderConstant;
import UtilsAPI.helper.ReqConfig;
import UtilsAPI.helper.RestAssuredHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.restassured.response.ExtractableResponse;
import org.testng.Assert;
import scala.collection.immutable.Stream;
import utilities.Constants;
import io.restassured.response.Response;
import utilities.RandomDataCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HitApi {
    public static ExtractableResponse<Response> response;
    public static ExtractableResponse<Response> response2;
    public static ExtractableResponse<Response> response3;
    public static String masterBookingId;


    public static ExtractableResponse<Response> post_v1_app_login(String email) {

        AuthOtpDto auth = new AuthOtpDto();
        auth.setEmailid(email);
        String url = Constants.API_URI + Endpoints.TRAVEL_PLUS_LOGIN;
        return RestAssuredHelper.callPostApi(HeaderConstant.getDefaultHeader(), null, url, auth, ReqConfig.getDefaultRequest());
    }

    public static ExtractableResponse<Response> post_v1_get_auth_token(String email, String otp) {
        String url = Constants.API_URI + Endpoints.TRAVEL_PLUS_AUTH_OTP;
        AuthVerifyDto authotp = new AuthVerifyDto();
        authotp.setEmailid(email);
        authotp.setOtp(otp);
        return RestAssuredHelper.callPostApi(HeaderConstant.getDefaultHeader(), null, url, authotp, ReqConfig.getDefaultRequest());

    }

    public static ExtractableResponse<Response> post_v1_search_flights(String accesstoken, String origin, String destination, String depature, String noOfTraveller, String travelClass) {
        List<String> travlleruserid = new ArrayList<>();
        SearchFlightRequest search = new SearchFlightRequest();
        search.setOrigin(origin);
        search.setTravelClass(travelClass);
        search.setDestination(destination);
        search.setDeparture(depature);
        search.setNoOfTravellers(noOfTraveller);
        search.setProvider("");
        search.setTravellerUserIds(travlleruserid);
        String url = Constants.API_URI + Endpoints.TRAVEL_SEARCH_API;
        response = RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accesstoken), null, url, search, ReqConfig.getDefaultRequest());
        return response;
    }

    public static ExtractableResponse<Response> post_v1_book_flight(String accessToken, String noOfTraveller, String origin, String destinations, String depature, String travelClass) throws JsonProcessingException {
        String JSON = response.response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Roots roots = objectMapper.readValue(JSON, Roots.class);
        FlightItinerary flightItinerary = roots.getData().getSearchResults().get(0).getResultDetail().getFlightDetail().getFlightItineraries().get(0);
        List<FlightItinerary> list2 = new ArrayList<>();
        list2.add(flightItinerary);
        int ticketingSourceValue = roots.getData().getSearchResults().get(0).getResultDetail().fareClasses.get(0).getTicketingSourceValue();
        System.out.println("Ticketing source value----" + ticketingSourceValue);
        String id = roots.getData().getSearchResults().get(0).getId();
        FareClass selectedFare = roots.getData().getSearchResults().get(0).getResultDetail().getFareClasses().get(0);
        ArrayList<Object> empty = new ArrayList<>();
        CheckoutRequest checkoutRequest = new CheckoutRequest();
        checkoutRequest.setOrigin(origin);
        checkoutRequest.setTravelClass(travelClass);
        checkoutRequest.setDestination(destinations);
        checkoutRequest.setDeparture(depature);
        checkoutRequest.setNoOfTravellers(noOfTraveller);
        checkoutRequest.setFlightItineraries(list2);
        checkoutRequest.setId(id);
        checkoutRequest.setTicketingSourceValue(ticketingSourceValue);
        checkoutRequest.setSelectedFare(selectedFare);
        List<CheckoutRequest> checkoutList = new ArrayList<>();
        checkoutList.add(checkoutRequest);
        Root root = new Root(checkoutList, roots.getData().getSource(), empty);
        String url = Constants.API_URI + Endpoints.BOOK_FLIGHTS_API;
        response2 = RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accessToken), null, url, root, ReqConfig.getDefaultRequest());
        return response2;
    }

    public static ExtractableResponse<Response> post_v1_payment(String accessToken, DataTable table, String paymentoption) throws JsonProcessingException {
        String firstname = RandomDataCreator.generateFirstName();
        String lastname = RandomDataCreator.generateLastname();
        String contactNo = RandomDataCreator.generateRandomPhoneNumber();
        String email = RandomDataCreator.generateEmail();
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        Passenger passenger1 = new Passenger();
        passenger1.setFirstName(firstname);
        passenger1.setLastName(lastname);
        passenger1.setEmail(email);
        passenger1.setContactNo(contactNo);
        CompanyGstDetail companyGstDetail = new CompanyGstDetail();
        SelectedGender selectedGender = new SelectedGender();
        SelectedTitle selectedTitle = new SelectedTitle();
        Payload payload = new Payload();
        for (Map<String, String> columns : rows) {
            if (columns.get("field").equalsIgnoreCase("passengers[0].address")) {
                passenger1.setAddress(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].isLeadPax")) {
                passenger1.setIsLeadPax(Boolean.parseBoolean(columns.get("value")));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].isdCode")) {
                passenger1.setIsdCode(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].countryName")) {
                passenger1.setCountryName(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].address")) {
                passenger1.setAddress(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].city")) {
                passenger1.setCity(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].key")) {
                passenger1.setKey(Integer.parseInt(columns.get("value")));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].mealDetails")) {
                passenger1.setMealDetails(null);
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].seatDetails")) {
                passenger1.setSeatDetails(columns.get(null));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].baggageDetails")) {
                passenger1.setBaggageDetails(columns.get(null));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].gender")) {
                passenger1.setGender(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].title")) {
                passenger1.setTitle(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].nationality")) {
                passenger1.setNationality(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].dateOfBirth")) {
                passenger1.setDateOfBirth(null);
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].userId")) {
                passenger1.setUserId(null);
            } else if (columns.get("field").equalsIgnoreCase("pasengers[0].selectedGender.text")) {
                selectedGender.setText(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("pasengers[0].selectedGender.value")) {
                selectedGender.setValue(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyName")) {
                companyGstDetail.setGSTCompanyName(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyContactNumber")) {
                companyGstDetail.setGSTCompanyContactNumber(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTNumber")) {
                companyGstDetail.setGSTNumber(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyEmail")) {
                companyGstDetail.setGSTCompanyEmail(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyAddress")) {
                companyGstDetail.setGSTCompanyAddress(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyAddress")) {
                companyGstDetail.setGSTCompanyAddress(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("pasengers[0].selectedTitle.text")) {
                selectedTitle.setText(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("pasengers[0].selectedTitle.value")) {
                selectedTitle.setValue(columns.get("value"));
            } else {
                System.out.println("key not found");
            }
        }
        payload.setPaymentOption(paymentoption);
        passenger1.setSelectedGender(selectedGender);
        passenger1.setSelectedTitle(selectedTitle);
        ArrayList<Passenger> list = new ArrayList<>();
        list.add(passenger1);
        payload.setPassengers(list);
        payload.setProvider(response.response().jsonPath().get("data.source"));
        payload.setCompanyGstDetail(companyGstDetail);
        payload.setPotMasterBookingId(response2.response().jsonPath().get("data.potMasterBookingId"));
        String url = Constants.API_URI + Endpoints.PAYMENT_API;
        response3 = RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accessToken), null, url, payload, ReqConfig.getDefaultRequest());
        return response3;
    }


    public static ExtractableResponse<Response> post_v3_confirm(String accessToken) {
        String bookingId = response3.response().jsonPath().get("data.potMasterBookingId");
        Confirm confirm = new Confirm(bookingId);
        String url = Constants.API_URI + Endpoints.CONFIRM_API;
        ExtractableResponse<Response> response = RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accessToken), null, url, confirm, ReqConfig.getDefaultRequest());
        masterBookingId = response.response().jsonPath().get("data.masterBookingId");
        return response;
    }

    public static ExtractableResponse<Response> post_v3_details(String accessToken) {
        Details details = new Details();
        details.setMasterBookingId(masterBookingId);
        String url = Constants.API_URI + Endpoints.DETAILS_API;
        return RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accessToken), null, url, details, ReqConfig.getDefaultRequest());
    }

    public static ExtractableResponse<Response> post_v3_create(String accessToken, String tempFlightBookingId, String paymentOption) {
        String url = Constants.API_URI + Endpoints.CREATE_API;
        return RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accessToken), HeaderConstant.setAndGetParm("tempFlightBookingId", tempFlightBookingId, "paymentOption", paymentOption), url, null, ReqConfig.getDefaultRequest());
    }


    public static ExtractableResponse<Response> post_v1_book_flight_forgivenprovider(String accessToken, String noOfTraveller, String origin, String destinations, String depature, String travelClass, String provider, String airlinecode, String pricetype) throws JsonProcessingException {
        String JSON = response.response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Roots roots = objectMapper.readValue(JSON, Roots.class);
        ArrayList<SearchResults> searchResults = roots.getData().getSearchResults();

        List<FlightItinerary> list2 = new ArrayList<>();
        System.out.println("Search results size" + searchResults.size());
        String id = "";
        int ticketingSourceValue = 0;
        FareClass selectedFare = null;
        int flag = 0;
        for (int flightIndex = 0; flightIndex < searchResults.size(); flightIndex++) {
            ArrayList<Airline> airlines = roots.getData().getSearchResults().get(flightIndex).resultDisplay.getAirlines();
            ArrayList<FareClass> corporateFare = roots.getData().getSearchResults().get(flightIndex).getResultDetail().getFareClasses();
            for (int airlineindex = 0; airlineindex < airlines.size(); airlineindex++) {
                for (int corporatefareindex = 0; corporatefareindex < corporateFare.size(); corporatefareindex++) {
                    if (String.valueOf(roots.getData().getSearchResults().get(flightIndex).getTicketingSourceValue()).equalsIgnoreCase(provider) && roots.getData().getSearchResults().get(flightIndex).resultDisplay.getAirlines().get(airlineindex).getAirlineCode().equalsIgnoreCase(airlinecode) && roots.getData().getSearchResults().get(flightIndex).getResultDetail().getFareClasses().get(corporatefareindex).getTravelPlusFareType().equalsIgnoreCase(pricetype)) {
                        FlightItinerary flightItinerary = roots.getData().getSearchResults().get(flightIndex).getResultDetail().getFlightDetail().getFlightItineraries().get(0);
                        list2.add(flightItinerary);
                        ticketingSourceValue = roots.getData().getSearchResults().get(flightIndex).getResultDetail().fareClasses.get(0).getTicketingSourceValue();
                        id = roots.getData().getSearchResults().get(flightIndex).getId();
                        selectedFare = roots.getData().getSearchResults().get(flightIndex).getResultDetail().getFareClasses().get(0);
                        flag = 1;
                        break;
                    }
                }
            }
        }
        if (flag == 0) {
            Assert.fail("Provider " + provider + " is not mapped with this account");
        }
        ArrayList<Object> empty = new ArrayList<>();
        CheckoutRequest checkoutRequest = new CheckoutRequest();
        checkoutRequest.setOrigin(origin);
        checkoutRequest.setTravelClass(travelClass);
        checkoutRequest.setDestination(destinations);
        checkoutRequest.setDeparture(depature);
        checkoutRequest.setNoOfTravellers(noOfTraveller);
        checkoutRequest.setFlightItineraries(list2);
        checkoutRequest.setId(id);
        checkoutRequest.setTicketingSourceValue(ticketingSourceValue);
        checkoutRequest.setSelectedFare(selectedFare);
        List<CheckoutRequest> checkoutList = new ArrayList<>();
        checkoutList.add(checkoutRequest);
        Root root = new Root(checkoutList, roots.getData().getSource(), empty);
        String url = Constants.API_URI + Endpoints.BOOK_FLIGHTS_API;
        response2 = RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accessToken), null, url, root, ReqConfig.getDefaultRequest());
        return response2;
    }

    public static ExtractableResponse<Response> post_v1_payment_with_add_ons(String accessToken, DataTable table, String paymentoption, String addons) throws JsonProcessingException {
        List<MealInfo> selectMeal = null;
        ArrayList<SeatInfoLcc> seatInfoLccs = null;
        SeatDetail seatDetails = new SeatDetail();


        if (addons.equalsIgnoreCase("Yes")) {
            String JSON = response.response().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            InitalResponse roots = objectMapper.readValue(JSON, InitalResponse.class);
          // for(int i=0;i<roots.getData().getCheckoutResponses().get(0).getMealDetails().size();i++){
//               while(roots.getData().getCheckoutResponses().get(0).getMealDetails().isEmpty()) {
//
//               }

             //  }
          // }
            selectMeal = roots.getData().getCheckoutResponses().get(0).getMealDetails().get(0).getMealInfos();
            seatInfoLccs = roots.getData().getCheckoutResponses().get(0).getSeatDetails().get(0).getSeatPlan().getRowData().get(0);
            seatDetails.setOrigin(roots.getData().getCheckoutResponses().get(0).getSeatDetails().get(0).getOrigin());
            seatDetails.setDestination(roots.getData().getCheckoutResponses().get(0).getSeatDetails().get(0).getDestination());
        }

        String firstname = RandomDataCreator.generateFirstName();
        String lastname = RandomDataCreator.generateLastname();
        String contactNo = RandomDataCreator.generateRandomPhoneNumber();
        String email = RandomDataCreator.generateEmail();
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        Passenger passenger1 = new Passenger();
        passenger1.setFirstName(firstname);
        passenger1.setLastName(lastname);
        passenger1.setEmail(email);
        passenger1.setContactNo(contactNo);
        CompanyGstDetail companyGstDetail = new CompanyGstDetail();
        SelectedGender selectedGender = new SelectedGender();
        SelectedTitle selectedTitle = new SelectedTitle();
        Payload payload = new Payload();
        for (Map<String, String> columns : rows) {
            if (columns.get("field").equalsIgnoreCase("passengers[0].address")) {
                passenger1.setAddress(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].isLeadPax")) {
                passenger1.setIsLeadPax(Boolean.parseBoolean(columns.get("value")));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].isdCode")) {
                passenger1.setIsdCode(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].countryName")) {
                passenger1.setCountryName(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].address")) {
                passenger1.setAddress(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].city")) {
                passenger1.setCity(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].key")) {
                passenger1.setKey(Integer.parseInt(columns.get("value")));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].mealDetails")) {
                passenger1.setMealDetails(null);
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].seatDetails")) {
                passenger1.setSeatDetails(columns.get(null));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].baggageDetails")) {
                passenger1.setBaggageDetails(columns.get(null));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].gender")) {
                passenger1.setGender(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].title")) {
                passenger1.setTitle(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].nationality")) {
                passenger1.setNationality(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].dateOfBirth")) {
                passenger1.setDateOfBirth(null);
            } else if (columns.get("field").equalsIgnoreCase("passengers[0].userId")) {
                passenger1.setUserId(null);
            } else if (columns.get("field").equalsIgnoreCase("pasengers[0].selectedGender.text")) {
                selectedGender.setText(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("pasengers[0].selectedGender.value")) {
                selectedGender.setValue(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyName")) {
                companyGstDetail.setGSTCompanyName(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyContactNumber")) {
                companyGstDetail.setGSTCompanyContactNumber(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTNumber")) {
                companyGstDetail.setGSTNumber(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyEmail")) {
                companyGstDetail.setGSTCompanyEmail(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyAddress")) {
                companyGstDetail.setGSTCompanyAddress(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("companyGstDetail.gSTCompanyAddress")) {
                companyGstDetail.setGSTCompanyAddress(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("pasengers[0].selectedTitle.text")) {
                selectedTitle.setText(columns.get("value"));
            } else if (columns.get("field").equalsIgnoreCase("pasengers[0].selectedTitle.value")) {
                selectedTitle.setValue(columns.get("value"));
            } else {
                System.out.println("key not found");
            }
        }
        payload.setPaymentOption(paymentoption);
        passenger1.setSelectedGender(selectedGender);
        passenger1.setSelectedTitle(selectedTitle);
        passenger1.setMealDetails(selectMeal);
        passenger1.setSeatDetails(seatInfoLccs);
        ArrayList<Passenger> list = new ArrayList<>();
        list.add(passenger1);
        payload.setPassengers(list);
        payload.setProvider(response.response().jsonPath().get("data.source"));
        payload.setCompanyGstDetail(companyGstDetail);
        payload.setPotMasterBookingId(response2.response().jsonPath().get("data.potMasterBookingId"));
        String url = Constants.API_URI + Endpoints.PAYMENT_API;
        response3 = RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accessToken), null, url, payload, ReqConfig.getDefaultRequest());
        return response3;
    }


}


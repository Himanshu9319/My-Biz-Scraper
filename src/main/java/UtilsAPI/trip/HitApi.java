package UtilsAPI.trip;

import UtilsAPI.TravelPlus.requestDto.*;
import UtilsAPI.helper.HeaderConstant;
import UtilsAPI.helper.ReqConfig;
import UtilsAPI.helper.RestAssuredHelper;
import UtilsAPI.trip.requestdto.CheckoutRequest;
import UtilsAPI.trip.requestdto.Manager_one;
import UtilsAPI.trip.requestdto.trip.FlightTripRequest;
import UtilsAPI.trip.requestdto.trip.Trip;
import UtilsAPI.trip.responsedto.search.FareClass;
import UtilsAPI.trip.responsedto.search.Search;
import UtilsAPI.trip.responsedto.search.FlightItinerary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import utilities.Base;
import utilities.Constants;
import utilities.TestUtilities;

import java.util.ArrayList;

public class HitApi {

    public static ExtractableResponse<Response> response;
    public static ExtractableResponse<Response> response2;

    public static String masterBookingId;

    public static ExtractableResponse<Response> post_v1_employee_login(String email) {

        AuthOtpDto auth = new AuthOtpDto();
        auth.setEmailid(email);
        String url = Constants.API_URI + UtilsAPI.trip.Endpoints.EMPLOYEE_LOGIN;
        return RestAssuredHelper.callPostApi(HeaderConstant.getDefaultHeader(), null, url, auth, ReqConfig.getDefaultRequest());
    }

    public static ExtractableResponse<Response> post_v1_employee_get_auth_token(String email, String otp) {
        String url = Constants.API_URI + Endpoints.EMPLOYEE_OTP;
        AuthVerifyDto authotp = new AuthVerifyDto();
        authotp.setEmailid(email);
        authotp.setOtp(otp);
        return RestAssuredHelper.callPostApi(HeaderConstant.getDefaultHeader(), null, url, authotp, ReqConfig.getDefaultRequest());
    }


    public static ExtractableResponse<Response> post_v2_empoyee_search_flights(String accesstoken, String origin, String destination, String depature, int noOfTraveller, String travelClass, String arrivalCity, String sourcecity) {
        UtilsAPI.trip.requestdto.Search search = new UtilsAPI.trip.requestdto.Search();
        search.setArrivalCity(arrivalCity);
        search.setDestination(destination);
        search.setOrigin(origin);
        search.setDeparture(depature);
        search.setTravelClass(travelClass);
        search.setNoOfTravellers(noOfTraveller);
        search.setSourceCity(sourcecity);
        String url = Constants.API_URI + Endpoints.EMPLOYEE_SEARCH_API;
        response = RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accesstoken), null, url, search, ReqConfig.getDefaultRequest());
        return response;
    }

    public static ExtractableResponse<Response> post_v2_employee_book_flight(String accessToken,int noOfTraveller ,String origin, String destinations, String depature, String travelClass , String type ,String bookingmode) throws JsonProcessingException {
        FlightTripRequest flightTripRequest = new FlightTripRequest();
        flightTripRequest.setType(type);
        String JSON = response.response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Search roots = objectMapper.readValue(JSON, Search.class);
        FlightItinerary flightItinerary = roots.getData().getSearchResultsInPolicy().get(0).getResultDetail().getFlightDetail().getFlightItineraries().get(0);
        ArrayList<FlightItinerary> list2 = new ArrayList<>();
        list2.add(flightItinerary);
        int ticketingSourceValue = roots.getData().getSearchResultsInPolicy().get(0).getResultDetail().fareClasses.get(0).getTicketingSourceValue();
        String id = roots.getData().getSearchResultsInPolicy().get(0).getId();
        FareClass selectedFare = roots.getData().getSearchResultsInPolicy().get(0).getResultDetail().getFareClasses().get(0);
        ArrayList<FlightTripRequest> empty = new ArrayList<>();
        empty.add(flightTripRequest);
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
        /*flightTripRequest*/
        flightTripRequest.setCheckoutRequests(checkoutRequest);
        flightTripRequest.setSource(roots.getData().getSearchResultsInPolicy().get(0).getResultDisplay().getSource().getAirport().getCityName());
        flightTripRequest.setSourceAirportCode(roots.getData().getSearchResultsInPolicy().get(0).getResultDisplay().getSource().getAirport().getAirportCode());
        flightTripRequest.setDestination(roots.getData().getSearchResultsInPolicy().get(0).getResultDisplay().getDestination().getAirport().getCityName());
        flightTripRequest.setDestinationAirportCode(roots.getData().getSearchResultsInPolicy().get(0).getResultDisplay().getDestination().getAirport().getAirportCode());
        flightTripRequest.setDepartureDate(depature);
        flightTripRequest.setBookingMode(bookingmode);
        flightTripRequest.setSourceCountry(roots.getData().getSearchResultsInPolicy().get(0).getResultDisplay().getSource().getAirport().getCountryName());
        flightTripRequest.setDestinationCountry(roots.getData().getSearchResultsInPolicy().get(0).getResultDisplay().getDestination().getAirport().getCountryName());
        flightTripRequest.setAirline(roots.getData().getSearchResultsInPolicy().get(0).getResultDisplay().getAirlines().get(0).getAirlineName());
        flightTripRequest.setAirlineCode(roots.getData().getSearchResultsInPolicy().get(0).getResultDisplay().getAirlines().get(0).getAirlineCode());
        flightTripRequest.setFlightNumber(roots.getData().getSearchResultsInPolicy().get(0).getResultDisplay().getAirlines().get(0).getFlightNumber());
        flightTripRequest.setTotalDuration(roots.getData().getSearchResultsInPolicy().get(0).getResultDisplay().getTotalDuration());
        flightTripRequest.setStop(roots.getData().getSearchResultsInPolicy().get(0).getResultDisplay().getStopInfo());
        flightTripRequest.setPrice(roots.getData().getSearchResultsInPolicy().get(0).getResultDetail().getFareClasses().get(0).getPublishedFare());
        flightTripRequest.setDepartureTime(roots.getData().getSearchResultsInPolicy().get(0).getResultDetail().getFlightDetail().getFlightItineraries().get(0).getSource().getDepTime());
        flightTripRequest.setArrivalTime(roots.getData().getSearchResultsInPolicy().get(0).getResultDetail().getFlightDetail().getFlightItineraries().get(0).getDestination().getArrTime());
        flightTripRequest.setFareType(roots.getData().getSearchResultsInPolicy().get(0).getResultDetail().getFareClasses().get(0).getType());
        flightTripRequest.setOutOfPolicy(false);
        flightTripRequest.setOutOfPolicyReasons(null);
        flightTripRequest.setLcc(roots.getData().getSearchResultsInPolicy().get(0).getResultDetail().getFlightDetail().isLcc());
        flightTripRequest.setBaggageIncluded(false);
        Trip trip = new Trip();
        trip.setPurposeOfTravel("CONFRENCE");
        trip.setFlightTripRequest(empty);
        String url = Constants.API_URI + Endpoints.EMPLOYEE_TRIP_CREATE;
         return RestAssuredHelper.callPostApi(HeaderConstant.getAccessTokenHeader(accessToken), null, url, trip, ReqConfig.getDefaultRequest());
    }

    public static ExtractableResponse<Response> manager_one_approval(String accesstoken ,String mastertripid , String comment){
        String url= Constants.API_URI+Endpoints.MANAGER_APPROVAL;
        Manager_one managerOne= new Manager_one(comment,mastertripid);
        return RestAssuredHelper.callPatchApi(HeaderConstant.getAccessTokenHeader(accesstoken),null,url,managerOne,ReqConfig.getDefaultRequest());
    }

    public static ExtractableResponse<Response> get_ticket_details(String accesstoken ,String mastertripid){
        String url= Constants.API_URI+Endpoints.GET_DETAILS;
     //   Manager_one managerOne= new Manager_one(comment,mastertripid);
        return RestAssuredHelper.callGetApi(HeaderConstant.getAccessTokenHeader(accesstoken),HeaderConstant.setAndGetParm("masterTripId",mastertripid),url,ReqConfig.getDefaultRequest());
    }





}

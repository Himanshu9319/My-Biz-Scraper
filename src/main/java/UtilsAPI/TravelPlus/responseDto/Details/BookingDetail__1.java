package UtilsAPI.TravelPlus.responseDto.Details;
import javax.annotation.Generated;

import UtilsAPI.TravelPlus.responseDto.Initial.FareRule;
import UtilsAPI.TravelPlus.responseDto.Search.ResultDisplay;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bookingId",
        "flightTripId",
        "pnr",
        "origin",
        "destination",
        "departure",
        "noOfTravellers",
        "noOfMealSelected",
        "noOfSeatSelected",
        "noOfBaggageSelected",
        "resultDisplay",
        "fareRule",
        "bookingStatus",
        "bookingType",
        "flightClassKey",
        "flightClass",
        "travelPlusFareType",
        "originalBookingId"
})
@Generated("jsonschema2pojo")
public class BookingDetail__1 {
    @JsonProperty("bookingId")
    public String bookingId;
    @JsonProperty("flightTripId")
    public String flightTripId;
    @JsonProperty("pnr")
    public String pnr;
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
    @JsonProperty("departure")
    public String departure;
    @JsonProperty("noOfTravellers")
    public Integer noOfTravellers;
    @JsonProperty("noOfMealSelected")
    public Integer noOfMealSelected;
    @JsonProperty("noOfSeatSelected")
    public Integer noOfSeatSelected;
    @JsonProperty("noOfBaggageSelected")
    public Integer noOfBaggageSelected;
    @JsonProperty("resultDisplay")
    public ResultDisplay resultDisplay;
    @JsonProperty("fareRule")
    public FareRule fareRule;
    @JsonProperty("bookingStatus")
    public String bookingStatus;
    @JsonProperty("bookingType")
    public String bookingType;
    @JsonProperty("flightClassKey")
    public String flightClassKey;
    @JsonProperty("flightClass")
    public String flightClass;
    @JsonProperty("travelPlusFareType")
    public String travelPlusFareType;
    @JsonProperty("originalBookingId")
    public String originalBookingId;
}

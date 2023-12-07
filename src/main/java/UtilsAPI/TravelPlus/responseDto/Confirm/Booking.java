package UtilsAPI.TravelPlus.responseDto.Confirm;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bookingId",
        "flightTripId",
        "origin",
        "destination",
        "departure",
        "grandTotal",
        "bookingStatus"
})

public class Booking {
    @JsonProperty("bookingId")
    public String bookingId;
    @JsonProperty("flightTripId")
    public String flightTripId;
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
    @JsonProperty("departure")
    public String departure;
    @JsonProperty("grandTotal")
    public Integer grandTotal;
    @JsonProperty("bookingStatus")
    public String bookingStatus;
}

package UtilsAPI.trip.requestdto.trip;

import UtilsAPI.trip.requestdto.CheckoutRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.annotation.Generated;
import java.util.Locale;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "source",
        "sourceAirportCode",
        "destination",
        "destinationAirportCode",
        "departureDate",
        "startTime",
        "endTime",
        "bookingMode",
        "travelClass",
        "sourceCountry",
        "destinationCountry",
        "source",
        "destination",
        "airline",
        "airlineCode",
        "airlineIcon",
        "airlineTailIcon",
        "flightNumber",
        "totalDuration",
        "stop",
        "price",
        "departureTime",
        "arrivalTime",
        "fareType",
        "isOutOfPolicy",
        "outOfPolicyReasons",
        "isLcc",
        "mealCount",
        "seatCount",
        "baggageIncluded",
        "checkoutRequests",
        "priceBreakup",
        "cheaperFare",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightTripRequest {

    public String type;
    public String source;
    public String sourceAirportCode;
    public String destination;
    public String destinationAirportCode;
    public String departureDate;
    public Object startTime;
    public Object endTime;
    public String bookingMode;
    public String travelClass;
    public String sourceCountry;
    public String destinationCountry;
    public String airline;
    public String airlineCode;
    public String airlineIcon;
    public String airlineTailIcon;
    public String flightNumber;
    public String totalDuration;
    public String stop;
    public double price;
    public String departureTime;
    public String arrivalTime;
    public String fareType;
    public boolean isOutOfPolicy;
    public Object outOfPolicyReasons;
    public boolean isLcc;
    public int mealCount;
    public int seatCount;
    public boolean baggageIncluded;
    public CheckoutRequest checkoutRequests;
    public PriceBreakup priceBreakup;
    public Object cheaperFare;
}

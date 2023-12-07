package UtilsAPI.trip.requestdto;

import UtilsAPI.trip.responsedto.search.FareClass;
import UtilsAPI.trip.responsedto.search.FlightItinerary;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "noOfTravellers",
        "origin",
        "destination",
        "arrivalCity",
        "sourceCity",
        "departure",
        "travelClass",
        "flightItineraries",
        "selectedFare",
        "ticketingSourceValue",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest{
    public String id;
    public int noOfTravellers;
    public String origin;
    public String destination;
    public String arrivalCity;
    public String sourceCity;
    public String departure;
    public String travelClass;
    public ArrayList<FlightItinerary> flightItineraries;
    @JsonProperty("selectedFare")
    public FareClass selectedFare;
    public int ticketingSourceValue;
}

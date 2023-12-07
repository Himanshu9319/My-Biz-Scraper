package UtilsAPI.TravelPlus.requestDto;


import java.util.List;
import javax.annotation.Generated;

import UtilsAPI.TravelPlus.responseDto.Search.FareClass;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "origin",
        "destination",
        "travelClass",
        "departure",
        "noOfTravellers",
        "flightItineraries",
        "ticketingSourceValue",
        "id",
        "selectedFare",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest {
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
    @JsonProperty("travelClass")
    public String travelClass;
    @JsonProperty("departure")
    public String departure;
    @JsonProperty("noOfTravellers")
    public String noOfTravellers;
    @JsonProperty("flightItineraries")
    public List<FlightItinerary> flightItineraries;
    @JsonProperty("ticketingSourceValue")
    public Integer ticketingSourceValue;
    @JsonProperty("id")
    public String id;
    @JsonProperty("selectedFare")
    public FareClass selectedFare;

}

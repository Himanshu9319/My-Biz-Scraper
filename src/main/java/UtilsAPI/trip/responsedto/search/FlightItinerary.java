package UtilsAPI.trip.responsedto.search;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "itineraryIndex",
        "duration",
        "layover",
        "baggage",
        "airline",
        "source",
        "destination"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightItinerary {

    public int itineraryIndex;
    public String duration;
    public String layover;
    public Baggage baggage;
    public Airline airline;
    public Source source;
    public Destination destination;
}

package UtilsAPI.trip.requestdto.trip;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonProperty("airport")
    public int itineraryIndex;
    @JsonProperty("airport")
    public String duration;
    @JsonProperty("airport")
    public Object layover;
    @JsonProperty("airport")
    public Baggage baggage;
    @JsonProperty("airport")
    public Airline airline;
    @JsonProperty("airport")
    public Source source;
    @JsonProperty("airport")
    public Destination destination;
}

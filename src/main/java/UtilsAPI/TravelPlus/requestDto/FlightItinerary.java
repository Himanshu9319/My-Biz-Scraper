package UtilsAPI.TravelPlus.requestDto;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
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
    @JsonProperty("itineraryIndex")
    public Integer itineraryIndex;
    @JsonProperty("duration")
    public String duration;
    @JsonProperty("layover")
    public Object layover;
    @JsonProperty("baggage")
    public Baggage baggage;

    @Override
    public String toString() {
        return "FlightItinerary{" +
                "itineraryIndex=" + itineraryIndex +
                ", duration='" + duration + '\'' +
                ", layover=" + layover +
                ", baggage=" + baggage +
                ", airline=" + airline +
                ", source=" + source +
                ", destination=" + destination +
                '}';
    }

    @JsonProperty("airline")
    public Airline airline;
    @JsonProperty("source")
    public Source source;
    @JsonProperty("destination")
    public Destination destination;
}

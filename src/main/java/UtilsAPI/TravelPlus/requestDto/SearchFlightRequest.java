package UtilsAPI.TravelPlus.requestDto;


import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "noOfTravellers",
        "origin",
        "destination",
        "departure",
        "provider",
        "travellerUserIds",
        "travelClass"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchFlightRequest {

    @JsonProperty("noOfTravellers")
    public String noOfTravellers;
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
    @JsonProperty("departure")
    public String departure;
    @JsonProperty("provider")
    public String provider;
    @JsonProperty("travelClass")
    public String travelClass;
    @JsonProperty("travellerUserIds")
    public List<String> travellerUserIds;

}

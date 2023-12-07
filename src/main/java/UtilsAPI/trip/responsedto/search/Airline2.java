package UtilsAPI.trip.responsedto.search;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "airlineCode",
        "airlineIcon",
        "airlineTailIcon",
        "airlineName",
        "flightNumber"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airline2 {
    @JsonProperty("airlineCode")
    public String airlineCode;
    @JsonProperty("airlineIcon")
    public String airlineIcon;
    @JsonProperty("airlineTailIcon")
    public String airlineTailIcon;
    @JsonProperty("airlineName")
    public String airlineName;
    @JsonProperty("flightNumber")
    public String flightNumber;

}

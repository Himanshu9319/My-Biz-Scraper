package UtilsAPI.TravelPlus.responseDto.Initial;


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
        "airlineCode",
        "flightNumber",
        "baggageCode",
        "baggageWeight",
        "price",
        "origin",
        "destination",
        "ticketingSource"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaggageInfo {
    @JsonProperty("airlineCode")
    public String airlineCode;
    @JsonProperty("flightNumber")
    public String flightNumber;
    @JsonProperty("baggageCode")
    public String baggageCode;
    @JsonProperty("baggageWeight")
    public int baggageWeight;
    @JsonProperty("price")
    public double price;
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
    @JsonProperty("ticketingSource")
    public String ticketingSource;
}

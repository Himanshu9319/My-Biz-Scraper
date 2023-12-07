package UtilsAPI.TravelPlus.responseDto.Details;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "origin",
        "destination",
        "baggageWeight",
        "baggageCharge"
})
@Generated("jsonschema2pojo")
public class BaggageSelected {
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
    @JsonProperty("baggageWeight")
    public Integer baggageWeight;
    @JsonProperty("baggageCharge")
    public Integer baggageCharge;
}

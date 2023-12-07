package UtilsAPI.TravelPlus.responseDto.Details;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "origin",
        "destination",
        "seatsSelected",
        "mealsSelected",
        "baggageSelected"
})
public class AddonDetailsFlightWise {
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
    @JsonProperty("seatsSelected")
    public List<SeatsSelected__1> seatsSelected;
    @JsonProperty("mealsSelected")
    public List<MealsSelected> mealsSelected;
    @JsonProperty("baggageSelected")
    public List<BaggageSelected> baggageSelected;
}

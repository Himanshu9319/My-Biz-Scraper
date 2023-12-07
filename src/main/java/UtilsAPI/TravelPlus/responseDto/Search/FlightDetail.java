package UtilsAPI.TravelPlus.responseDto.Search;

import UtilsAPI.TravelPlus.requestDto.FlightItinerary;
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
        "totalDuration",
        "isGstMandatory",
        "flightItineraries",
        "fare",
        "cancellationCharges",
        "rescheduleCharges",
        "gstMandatory",
        "lcc",
        "isLcc",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDetail {
    @JsonProperty("totalDuration")
    public String totalDuration;
//    @JsonProperty("isGstMandatory")
    public boolean isGstMandatory;
    @JsonProperty("flightItineraries")
    public ArrayList<FlightItinerary> flightItineraries;
    @JsonProperty("fare")
    public Fare fare;
    @JsonProperty("cancellationCharges")
    public ArrayList<CancellationCharge> cancellationCharges;
    @JsonProperty("rescheduleCharges")
    public ArrayList<RescheduleCharge> rescheduleCharges;
   // @JsonProperty("gstMandatory")
    public boolean gstMandatory;
    @JsonProperty("lcc")
    public boolean lcc;
    @JsonProperty("isLcc")
    public boolean isLcc;
}


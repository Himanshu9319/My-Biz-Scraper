package UtilsAPI.TravelPlus.responseDto.Search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.ArrayList;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "stop",
        "airline",
        "departureTimeSlot",
        "arrivalTimeSlot",
        "priceMinMax"
})
@Generated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filters {
    @JsonProperty("stop")
    public ArrayList<Stop> stop;

    @JsonProperty("airline")
    public ArrayList<Airline_2> airline_2;

    @JsonProperty("departureTimeSlot")
    public ArrayList<DepartureTimeSlot> departureTimeSlot;

    @JsonProperty("arrivalTimeSlot")
    public ArrayList<ArrivalTimeSlot> arrivalTimeSlot;

    @JsonProperty("priceMinMax")
    public String priceMinMax;

}

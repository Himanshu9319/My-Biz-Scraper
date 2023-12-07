package UtilsAPI.TravelPlus.responseDto.Search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "airlines",
        "departureTimeSlot",
        "arrivalTimeSlot",
        "priceLowHigh",
        "stop"
})
@Generated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filter {
    @JsonProperty("stop")
    public String stop;
    @JsonProperty("airlines")
    public ArrayList<String> airlines;
    @JsonProperty("departureTimeSlot")
    public String departureTimeSlot;
    @JsonProperty("arrivalTimeSlot")
    public String arrivalTimeSlot;
    @JsonProperty("priceLowHigh")
    public String priceLowHigh;
}

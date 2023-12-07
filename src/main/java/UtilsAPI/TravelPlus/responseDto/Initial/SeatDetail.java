package UtilsAPI.TravelPlus.responseDto.Initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "seatPreferences",
        "seatPlan",
        "origin",
        "destination",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatDetail {
    @JsonProperty("seatPreferences")
    public Object seatPreferences;
    @JsonProperty("seatPlan")
    public SeatPlan seatPlan;
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
}

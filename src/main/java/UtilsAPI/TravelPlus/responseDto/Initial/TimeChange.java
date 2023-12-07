package UtilsAPI.TravelPlus.responseDto.Initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "previousDeparture",
        "previousArrival",
        "currentDeparture",
        "currentArrival",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TimeChange {
    @JsonProperty("previousDeparture")
    public Object previousDeparture;
    @JsonProperty("previousArrival")
    public Object previousArrival;
    @JsonProperty("currentDeparture")
    public Object currentDeparture;
    @JsonProperty("currentArrival")
    public Object currentArrival;
}

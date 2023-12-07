package UtilsAPI.trip.responsedto.search;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
@JsonPropertyOrder({
        "checkIn",
        "cabin",
        })
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CancellationCharge {
    @JsonProperty("timeFrame")
    public String timeFrame;
    @JsonProperty("charges")
    public String charges;
}

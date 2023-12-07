package UtilsAPI.TravelPlus.responseDto.Initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "previous",
        "current",
        "difference",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceVsColorCodeMap {

    @JsonProperty("Above ₹1501")
    private String above1501;

    @JsonProperty("Free")
    private String free;

    @JsonProperty("Unavailable")
    private String unavailable;

    @JsonProperty("₹1 - ₹500")
    private String range1to500;

    @JsonProperty("₹1001 - ₹1500")
    private String range1001to1500;

    @JsonProperty("₹501 - ₹1000")
    private String range501to1000;
}

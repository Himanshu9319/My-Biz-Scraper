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
        "airlineIcon",
        "airlineCode",
        "src",
        "dst",
        "checkIn",
        "cabin"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaggageRule {
    @JsonProperty("airlineIcon")
    public String airlineIcon;
    @JsonProperty("airlineCode")
    public Object airlineCode;
    @JsonProperty("src")
    public String src;
    @JsonProperty("dst")
    public String dst;
    @JsonProperty("checkIn")
    public String checkIn;
    @JsonProperty("cabin")
    public String cabin;
}

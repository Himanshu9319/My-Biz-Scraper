package UtilsAPI.TravelPlus.responseDto.Initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.util.ArrayList;

@JsonPropertyOrder({
        "baggageInfos",
        "origin",
        "destination"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaggageDetail {
    @JsonProperty("baggageInfos")
    public ArrayList<BaggageInfo> baggageInfos;
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
}

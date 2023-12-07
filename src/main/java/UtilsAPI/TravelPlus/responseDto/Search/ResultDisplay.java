package UtilsAPI.TravelPlus.responseDto.Search;

import UtilsAPI.TravelPlus.requestDto.Airline;
import UtilsAPI.TravelPlus.requestDto.Destination;
import UtilsAPI.TravelPlus.requestDto.Source;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "totalDuration",
        "stopInfo",
        "airlines",
        "source",
        "destination",
        "totalLayoverTimeInHours"
})
@Generated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDisplay {
    @JsonProperty("totalDuration")
    public String totalDuration;
    @JsonProperty("stopInfo")
    public String stopInfo;
    @JsonProperty("airlines")
    public ArrayList<Airline> airlines;
    @JsonProperty("source")
    public Source source;
    @JsonProperty("destination")
    public Destination destination;
    @JsonProperty("totalLayoverTimeInHours")
    public double totalLayoverTimeInHours;
}

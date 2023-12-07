package UtilsAPI.TravelPlus.responseDto.Search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.ArrayList;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "flightDetail",
        "fareClasses",
})
@Generated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDetail {
    @JsonProperty("flightDetail")
    public FlightDetail flightDetail;

    @Override
    public String toString() {
        return "ResultDetail{" +
                "flightDetail=" + flightDetail +
                ", fareClasses=" + fareClasses +
                '}';
    }

    @JsonProperty("fareClasses")
    public ArrayList<FareClass> fareClasses;
}

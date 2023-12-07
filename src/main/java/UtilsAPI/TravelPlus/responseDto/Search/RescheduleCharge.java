package UtilsAPI.TravelPlus.responseDto.Search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;


@JsonPropertyOrder({
        "timeFrame",
        "charges"
})
@Generated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RescheduleCharge {
    @JsonProperty("timeFrame")
    public String timeFrame;
    @JsonProperty("charges")
    public String charges;
}

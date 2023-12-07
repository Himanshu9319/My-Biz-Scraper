package UtilsAPI.TravelPlus.responseDto.Initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "budgetText",
        "advanceDaysText",
        "travelClassText",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutOfPolicy {
    @JsonProperty("budgetText")
    public String budgetText;
    @JsonProperty("advanceDaysText")
    public String advanceDaysText;
    @JsonProperty("travelClassText")
    public Object travelClassText;
}

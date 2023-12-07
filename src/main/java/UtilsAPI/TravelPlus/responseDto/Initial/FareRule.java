package UtilsAPI.TravelPlus.responseDto.Initial;

import UtilsAPI.TravelPlus.responseDto.Search.CancellationCharge;
import UtilsAPI.TravelPlus.responseDto.Search.RescheduleCharge;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.util.ArrayList;
@JsonPropertyOrder({
        "fareRuleDetail",
        "cancellationCharges",
        "rescheduleCharges",
        "baggageRules",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FareRule {
    @JsonProperty("fareRuleDetail")
    public ArrayList<String> fareRuleDetail;
    @JsonProperty("cancellationCharges")
    public ArrayList<CancellationCharge> cancellationCharges;
    @JsonProperty("rescheduleCharges")
    public ArrayList<RescheduleCharge> rescheduleCharges;
    @JsonProperty("baggageRules")
    public ArrayList<BaggageRule> baggageRules;
}


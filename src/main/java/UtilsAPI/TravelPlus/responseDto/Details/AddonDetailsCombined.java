package UtilsAPI.TravelPlus.responseDto.Details;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
@JsonPropertyOrder({
        "selectedSeatsText",
        "selectedMealsText",
        "selectedBaggageText"
})
public class AddonDetailsCombined {
    @JsonProperty("selectedSeatsText")
    public String selectedSeatsText;
    @JsonProperty("selectedMealsText")
    public String selectedMealsText;
    @JsonProperty("selectedBaggageText")
    public String selectedBaggageText;
}

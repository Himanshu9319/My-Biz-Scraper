package UtilsAPI.TravelPlus.responseDto.Details;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "origin",
        "destination",
        "mealCode",
        "mealCharge",
        "mealDescription"
})
@Generated("jsonschema2pojo")
public class MealsSelected {
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
    @JsonProperty("mealCode")
    public String mealCode;
    @JsonProperty("mealCharge")
    public Integer mealCharge;
    @JsonProperty("mealDescription")
    public String mealDescription;

}

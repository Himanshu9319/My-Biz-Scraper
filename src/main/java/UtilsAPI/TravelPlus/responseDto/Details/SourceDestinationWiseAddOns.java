package UtilsAPI.TravelPlus.responseDto.Details;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "additionalProp1",
        "additionalProp2",
        "additionalProp3"
})
@Generated("jsonschema2pojo")

public class SourceDestinationWiseAddOns {
    @JsonProperty("additionalProp1")
    public String additionalProp1;
    @JsonProperty("additionalProp2")
    public String additionalProp2;
    @JsonProperty("additionalProp3")
    public String additionalProp3;

}

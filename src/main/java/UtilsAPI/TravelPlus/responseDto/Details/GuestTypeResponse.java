package UtilsAPI.TravelPlus.responseDto.Details;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "key",
        "value"
})
@Generated("jsonschema2pojo")
public class GuestTypeResponse {
    @JsonProperty("key")
    public String key;
    @JsonProperty("value")
    public String value;
}

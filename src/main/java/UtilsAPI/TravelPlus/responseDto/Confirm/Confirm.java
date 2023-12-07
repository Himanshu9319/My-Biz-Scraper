package UtilsAPI.TravelPlus.responseDto.Confirm;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "mesage",
        "data"
})
@Generated("jsonschema2pojo")
public class Confirm {
    @JsonProperty("message")
    public String message;
    @JsonProperty("data")
    public Data data;
}

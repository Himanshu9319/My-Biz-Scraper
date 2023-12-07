package UtilsAPI.TravelPlus.responseDto.Search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "message",
        "data"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@ToString
public class Roots {
    @JsonProperty("message")
    public String message;

    @JsonProperty("data")
    public Data data;
}

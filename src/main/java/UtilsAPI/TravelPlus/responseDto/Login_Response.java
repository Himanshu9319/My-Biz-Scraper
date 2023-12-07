package UtilsAPI.TravelPlus.responseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Generated;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "data",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@ToString
public class Login_Response {
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private String data;
}

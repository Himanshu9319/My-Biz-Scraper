package UtilsAPI.HotelBooking.responseDto.initiated;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "data"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
public class Initiate {
    @JsonProperty("message")
    public String message;
    @JsonProperty("data")
    public Data data;
}

package UtilsAPI.HotelBooking.responseDto.Create;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "text",
        "colorCode"
})
@Generated("jsonschema2pojo")
public class CancellationInfo__1 {
    @JsonProperty("text")
    public String text;
    @JsonProperty("colorCode")
    public String colorCode;
}

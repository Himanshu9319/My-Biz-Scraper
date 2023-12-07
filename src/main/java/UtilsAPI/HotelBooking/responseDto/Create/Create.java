package UtilsAPI.HotelBooking.responseDto.Create;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "data"
})
@Generated("jsonschema2pojo")
public class Create {
    @JsonProperty("message")
    public String message;
    @JsonProperty("data")
    public Data data;
}

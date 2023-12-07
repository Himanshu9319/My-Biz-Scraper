package UtilsAPI.HotelBooking.responseDto.Create;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "description",
        "refundable"
})
@Generated("jsonschema2pojo")
public class CancellationInfo {
    @JsonProperty("description")
    public List<String> description;
    @JsonProperty("refundable")
    public Boolean refundable;
}

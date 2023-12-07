package UtilsAPI.HotelBooking.responseDto.Create;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "roomTypeId",
        "ratePlans"
})
@Generated("jsonschema2pojo")
public class RoomTypeMeta {
    @JsonProperty("name")
    public String name;
    @JsonProperty("roomTypeId")
    public String roomTypeId;
    @JsonProperty("ratePlans")
    public List<RatePlan> ratePlans;

}

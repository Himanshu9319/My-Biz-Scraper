package UtilsAPI.TravelPlus.responseDto.Details;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "origin",
        "destination",
        "seatNumber",
        "seatType",
        "seatCharge"
})
@Generated("jsonschema2pojo")
public class SeatsSelected__1 {

    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
    @JsonProperty("seatNumber")
    public String seatNumber;
    @JsonProperty("seatType")
    public String seatType;
    @JsonProperty("seatCharge")
    public Integer seatCharge;
}

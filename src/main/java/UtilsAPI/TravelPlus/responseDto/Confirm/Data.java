package UtilsAPI.TravelPlus.responseDto.Confirm;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "csvResponseV1",
        "masterBookingId",
        "bookings"
})
@Generated("jsonschema2pojo")
public class Data {
    @JsonProperty("csvResponseV1")
    public CsvResponseV1 csvResponseV1;
    @JsonProperty("masterBookingId")
    public String masterBookingId;
    @JsonProperty("bookings")
    public List<Booking> bookings;
}

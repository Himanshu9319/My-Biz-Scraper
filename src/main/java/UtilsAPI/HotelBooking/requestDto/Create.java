package UtilsAPI.HotelBooking.requestDto;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "hotelTripId",
        "propertyId",
        "rate",
        "checkIn",
        "checkOut",
        "occupancy",
        "provider",
        "searchId"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Create {
    @JsonProperty("hotelTripId")
    public String hotelTripId;
    @JsonProperty("propertyId")
    public Integer propertyId;
    @JsonProperty("rate")
    public String rate;
    @JsonProperty("checkIn")
    public String checkIn;
    @JsonProperty("checkOut")
    public String checkOut;
    @JsonProperty("occupancy")
    public List<Integer> occupancy;
    @JsonProperty("provider")
    public String provider;
    @JsonProperty("searchId")
    public String searchId;
}

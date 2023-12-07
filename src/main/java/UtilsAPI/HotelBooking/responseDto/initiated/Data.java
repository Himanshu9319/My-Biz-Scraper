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
        "searchId",
        "checkIn",
        "checkOut",
        "minPrice",
        "maxPrice",
        "travellerUserIds"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
public class Data {
    @JsonProperty("searchId")
    public String searchId;
    @JsonProperty("checkIn")
    public String checkIn;
    @JsonProperty("checkOut")
    public String checkOut;
    @JsonProperty("minPrice")
    public Integer minPrice;
    @JsonProperty("maxPrice")
    public Integer maxPrice;
    @JsonProperty("travellerUserIds")
    public Object travellerUserIds;
}

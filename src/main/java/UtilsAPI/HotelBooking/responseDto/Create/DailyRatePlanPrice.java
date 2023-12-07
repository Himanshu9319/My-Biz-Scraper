package UtilsAPI.HotelBooking.responseDto.Create;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "price"
})
@Generated("jsonschema2pojo")
public class DailyRatePlanPrice {
    @JsonProperty("date")
    public String date;
    @JsonProperty("price")
    public Double price;
}

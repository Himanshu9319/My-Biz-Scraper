package UtilsAPI.HotelBooking.responseDto.Create;

import java.util.List;
import javax.annotation.Generated;

import UtilsAPI.TravelPlus.responseDto.Payment.PaymentOption;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "paymentOptions",
        "price",
        "roomTypeMeta",
        "occupancy",
        "travellers",
        "searchId",
        "cancellationInfo",
        "payAtHotelTooltipText"
})
@Generated("jsonschema2pojo")
public class Data {
    @JsonProperty("paymentOptions")
    public List<PaymentOption> paymentOptions;
    @JsonProperty("price")
    public Price price;
    @JsonProperty("roomTypeMeta")
    public List<RoomTypeMeta> roomTypeMeta;
    @JsonProperty("occupancy")
    public List<Integer> occupancy;
    @JsonProperty("travellers")
    public List<Object> travellers;
    @JsonProperty("searchId")
    public String searchId;
    @JsonProperty("cancellationInfo")
    public CancellationInfo__1 cancellationInfo;
    @JsonProperty("payAtHotelTooltipText")
    public String payAtHotelTooltipText;
}

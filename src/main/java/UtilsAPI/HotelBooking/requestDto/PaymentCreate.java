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
        "currentStateGSTAvailable",
        "occupancy",
        "specialRequests",
        "ratePlanId",
        "roomTypeId",
        "paymentMode",
        "checkIn",
        "checkOut",
        "searchId",
        "travellers",
        "paymentOption",
        "gstin",
        "gstCompanyName"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentCreate {
    @JsonProperty("hotelTripId")
    public String hotelTripId;
    @JsonProperty("propertyId")
    public Integer propertyId;
    @JsonProperty("rate")
    public String rate;
    @JsonProperty("currentStateGSTAvailable")
    public Boolean currentStateGSTAvailable;
    @JsonProperty("occupancy")
    public List<Integer> occupancy;
    @JsonProperty("specialRequests")
    public String specialRequests;
    @JsonProperty("ratePlanId")
    public String ratePlanId;
    @JsonProperty("roomTypeId")
    public String roomTypeId;
    @JsonProperty("paymentMode")
    public String paymentMode;
    @JsonProperty("checkIn")
    public String checkIn;
    @JsonProperty("checkOut")
    public String checkOut;
    @JsonProperty("searchId")
    public String searchId;
    @JsonProperty("travellers")
    public List<Traveller> travellers;
    @JsonProperty("paymentOption")
    public String paymentOption;
    @JsonProperty("gstin")
    public String gstin;
    @JsonProperty("gstCompanyName")
    public String gstCompanyName;
    @JsonProperty("gstAddress")
    public String gstAddress;
    @JsonProperty("gstPinCode")
    public String gstPinCode;

}

package UtilsAPI.TravelPlus.responseDto.Details;
import java.util.List;
import javax.annotation.Generated;

import UtilsAPI.TravelPlus.responseDto.Initial.OutOfPolicy;
import UtilsAPI.TravelPlus.responseDto.Initial.PriceBreakup;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "masterFlightBookingId",
        "bookingDetail",
        "travellers",
        "priceBreakup",
        "lccModifyPriceBreakup",
        "outOfPolicy",
        "paymentMode",
        "paymentOption",
        "contactInfo",
        "isLCC",
        "createdBy",
        "ticketingSource",
        "bookingSource",
        "masterTripId",
        "cancellationAutomated",
        "modificationAutomated",
        "gSTCompanyName",
        "isCancellationAutomated",
        "isModificationAutomated"
})
@Generated("jsonschema2pojo")
public class BookingDetail {

    @JsonProperty("masterFlightBookingId")
    public String masterFlightBookingId;
    @JsonProperty("bookingDetail")
    public BookingDetail__1 bookingDetail;
    @JsonProperty("travellers")
    public List<Traveller> travellers;
    @JsonProperty("priceBreakup")
    public PriceBreakup priceBreakup;
    @JsonProperty("lccModifyPriceBreakup")
    public LccModifyPriceBreakup lccModifyPriceBreakup;
    @JsonProperty("outOfPolicy")
    public OutOfPolicy outOfPolicy;
    @JsonProperty("paymentMode")
    public String paymentMode;
    @JsonProperty("paymentOption")
    public String paymentOption;
    @JsonProperty("contactInfo")
    public ContactInfo contactInfo;
    @JsonProperty("isLCC")
    public Boolean isLCC;
    @JsonProperty("createdBy")
    public String createdBy;
    @JsonProperty("ticketingSource")
    public String ticketingSource;
    @JsonProperty("bookingSource")
    public String bookingSource;
    @JsonProperty("masterTripId")
    public String masterTripId;
    @JsonProperty("cancellationAutomated")
    public Boolean cancellationAutomated;
    @JsonProperty("modificationAutomated")
    public Boolean modificationAutomated;
    @JsonProperty("gSTCompanyName")
    public String gSTCompanyName;
    @JsonProperty("isCancellationAutomated")
    public Boolean isCancellationAutomated;
    @JsonProperty("isModificationAutomated")
    public Boolean isModificationAutomated;
}

package UtilsAPI.TravelPlus.responseDto.Details;

import java.util.List;
import javax.annotation.Generated;

import UtilsAPI.TravelPlus.responseDto.Confirm.CsvResponseV1;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "csvResponseV1",
        "masterBookingId",
        "bookingDetails",
        "paymentMode",
        "paymentOption",
        "tripType",
        "contactInfo",
        "addonDetailsCombined",
        "addonDetailsFlightWise",
        "gSTCompanyName"
})
@Generated("jsonschema2pojo")

public class Data {

    @JsonProperty("csvResponseV1")
    public CsvResponseV1 csvResponseV1;
    @JsonProperty("masterBookingId")
    public String masterBookingId;
    @JsonProperty("bookingDetails")
    public List<BookingDetail> bookingDetails;
    @JsonProperty("paymentMode")
    public String paymentMode;
    @JsonProperty("paymentOption")
    public String paymentOption;
    @JsonProperty("tripType")
    public String tripType;
    @JsonProperty("contactInfo")
    public ContactInfo__1 contactInfo;
    @JsonProperty("addonDetailsCombined")
    public AddonDetailsCombined addonDetailsCombined;
    @JsonProperty("addonDetailsFlightWise")
    public List<AddonDetailsFlightWise> addonDetailsFlightWise;
    @JsonProperty("gSTCompanyName")
    public String gSTCompanyName;
}

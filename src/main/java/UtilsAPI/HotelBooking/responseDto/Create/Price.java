package UtilsAPI.HotelBooking.responseDto.Create;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "subTotal",
        "pricePerNight",
        "gst",
        "grandTotal",
        "savingText",
        "nights",
        "convenienceFee",
        "surcharge",
        "pahGrandTotal"
})
@Generated("jsonschema2pojo")
public class Price {

    @JsonProperty("subTotal")
    public Double subTotal;
    @JsonProperty("pricePerNight")
    public Double pricePerNight;
    @JsonProperty("gst")
    public Double gst;
    @JsonProperty("grandTotal")
    public Double grandTotal;
    @JsonProperty("savingText")
    public String savingText;
    @JsonProperty("nights")
    public Integer nights;
    @JsonProperty("convenienceFee")
    public Double convenienceFee;
    @JsonProperty("surcharge")
    public Double surcharge;
    @JsonProperty("pahGrandTotal")
    public Double pahGrandTotal;
}

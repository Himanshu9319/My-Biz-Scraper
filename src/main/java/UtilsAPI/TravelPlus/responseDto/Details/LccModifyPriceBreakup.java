package UtilsAPI.TravelPlus.responseDto.Details;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "base",
        "taxesAndFees",
        "reissueCharges",
        "oldFare",
        "newFare",
        "publishedFare",
        "gst",
        "gstCharged",
        "discount",
        "convenienceFee",
        "cancellationCharges",
        "cancellationConvFee",
        "cancellationConvFeeGst",
        "total"
})
@Generated("jsonschema2pojo")
public class LccModifyPriceBreakup {
    @JsonProperty("base")
    public Integer base;
    @JsonProperty("taxesAndFees")
    public Integer taxesAndFees;
    @JsonProperty("reissueCharges")
    public Integer reissueCharges;
    @JsonProperty("oldFare")
    public Integer oldFare;
    @JsonProperty("newFare")
    public Integer newFare;
    @JsonProperty("publishedFare")
    public Integer publishedFare;
    @JsonProperty("gst")
    public Integer gst;
    @JsonProperty("gstCharged")
    public String gstCharged;
    @JsonProperty("discount")
    public Integer discount;
    @JsonProperty("convenienceFee")
    public Integer convenienceFee;
    @JsonProperty("cancellationCharges")
    public Integer cancellationCharges;
    @JsonProperty("cancellationConvFee")
    public Integer cancellationConvFee;
    @JsonProperty("cancellationConvFeeGst")
    public Integer cancellationConvFeeGst;
    @JsonProperty("total")
    public Integer total;
}

package UtilsAPI.TravelPlus.responseDto.Details;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "base",
        "taxesAndFees",
        "publishedFare",
        "gst",
        "gstCharged",
        "discount",
        "convenienceFee",
        "mealCharge",
        "seatCharge",
        "baggageCharges",
        "total",
        "modificationCharge",
        "cancellationCharge",
        "cancellationConvFee",
        "cancellationConvFeeGst",
        "mealSelected",
        "baggageSelected",
        "seatSelected",
        "isMealSelected",
        "isBaggageSelected",
        "isSeatSelected"
})
@Generated("jsonschema2pojo")
public class PriceBreakup {
    @JsonProperty("base")
    public Integer base;
    @JsonProperty("taxesAndFees")
    public Integer taxesAndFees;
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
    @JsonProperty("mealCharge")
    public Integer mealCharge;
    @JsonProperty("seatCharge")
    public Integer seatCharge;
    @JsonProperty("baggageCharges")
    public Integer baggageCharges;
    @JsonProperty("total")
    public Integer total;
    @JsonProperty("modificationCharge")
    public Integer modificationCharge;
    @JsonProperty("cancellationCharge")
    public Integer cancellationCharge;
    @JsonProperty("cancellationConvFee")
    public Integer cancellationConvFee;
    @JsonProperty("cancellationConvFeeGst")
    public Integer cancellationConvFeeGst;
    @JsonProperty("mealSelected")
    public Boolean mealSelected;
    @JsonProperty("baggageSelected")
    public Boolean baggageSelected;
    @JsonProperty("seatSelected")
    public Boolean seatSelected;
    @JsonProperty("isMealSelected")
    public Boolean isMealSelected;
    @JsonProperty("isBaggageSelected")
    public Boolean isBaggageSelected;
    @JsonProperty("isSeatSelected")
    public Boolean isSeatSelected;
}

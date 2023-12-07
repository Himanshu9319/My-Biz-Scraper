package UtilsAPI.TravelPlus.responseDto.Initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

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
        "cancellationConvFeeGst",
        "mealSelected",
        "baggageSelected",
        "seatSelected",
        "isMealSelected",
        "isBaggageSelected",
        "isSeatSelected",

})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceBreakup {
    @JsonProperty("base")
    public double base;
    @JsonProperty("taxesAndFees")
    public double taxesAndFees;
    @JsonProperty("publishedFare")
    public double publishedFare;
    @JsonProperty("gst")
    public double gst;
    @JsonProperty("gstCharged")
    public String gstCharged;
    @JsonProperty("discount")
    public double discount;
    @JsonProperty("convenienceFee")
    public double convenienceFee;
    @JsonProperty("mealCharge")
    public double mealCharge;
    @JsonProperty("seatCharge")
    public double seatCharge;
    @JsonProperty("baggageCharges")
    public double baggageCharges;
    @JsonProperty("total")
    public double total;
    @JsonProperty("modificationCharge")
    public Object modificationCharge;
    @JsonProperty("cancellationCharge")
    public Object cancellationCharge;
    @JsonProperty("cancellationConvFee")
    public Object cancellationConvFee;
    @JsonProperty("cancellationConvFeeGst")
    public Object cancellationConvFeeGst;
    @JsonProperty("mealSelected")
    public boolean mealSelected;
    @JsonProperty("baggageSelected")
    public boolean baggageSelected;
    @JsonProperty("seatSelected")
    public boolean seatSelected;
    @JsonProperty("isMealSelected")
    public boolean isMealSelected;
    @JsonProperty("isBaggageSelected")
    public boolean isBaggageSelected;
    @JsonProperty("isSeatSelected")
    public boolean isSeatSelected;

}

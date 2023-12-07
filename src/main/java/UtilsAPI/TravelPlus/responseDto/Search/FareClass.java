package UtilsAPI.TravelPlus.responseDto.Search;

import UtilsAPI.TravelPlus.requestDto.Baggage;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "resultIndex",
        "fareSource",
        "fareIndicator",
        "noOfSeatsAvailable",
        "color",
        "type",
        "travelPlusFareType",
        "publishedFare",
        "baggage",
        "cancellationCharges",
        "resultIndex",
        "fareSource",
        "fareIndicator",
        "noOfSeatsAvailable",
        "color",
        "type",
        "travelPlusFareType",
        "publishedFare",
        "isRefundable",
        "isCorporateCodeFare",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FareClass{
    @JsonProperty("resultIndex")
    public String resultIndex;
    @JsonProperty("fareSource")
    public int fareSource;
    @JsonProperty("fareIndicator")
    public int fareIndicator;
    @JsonProperty("noOfSeatsAvailable")
    public int noOfSeatsAvailable;
    @JsonProperty("color")
    public String color;
    @JsonProperty("type")
    public String type;
    @JsonProperty("travelPlusFareType")
    public String travelPlusFareType;
    @JsonProperty("publishedFare")
    public double publishedFare;
    @JsonProperty("baggage")
    public Baggage baggage;
    @JsonProperty("cancellationCharges")
    public String cancellationCharges;
    @JsonProperty("rescheduleCharges")
    public String rescheduleCharges;
    @JsonProperty("cancellationTimeFrame")
    public String cancellationTimeFrame;
    @JsonProperty("rescheduleTimeFrame")
    public String rescheduleTimeFrame;
    @JsonProperty("outOfPolicy")
    public Object outOfPolicy;
    @JsonProperty("outOfPolicyReasons")
    public Object outOfPolicyReasons;
    @JsonProperty("inPolicy")
    public boolean inPolicy;
    @JsonProperty("ticketingSourceValue")
    public int ticketingSourceValue;
    @JsonProperty("refundable")
    public boolean refundable;
    @JsonProperty("corporateCodeFare")
    public boolean corporateCodeFare;
    @JsonProperty("isRefundable")
    public boolean isRefundable;
    @JsonProperty("isCorporateCodeFare")
    public boolean isCorporateCodeFare;
}

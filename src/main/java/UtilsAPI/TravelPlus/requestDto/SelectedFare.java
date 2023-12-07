package UtilsAPI.TravelPlus.requestDto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
        "rescheduleCharges",
        "cancellationTimeFrame",
        "rescheduleTimeFrame",
        "outOfPolicy",
        "outOfPolicyReasons",
        "inPolicy",
        "ticketingSourceValue",
        "refundable",
        "corporateCodeFare",
        "isRefundable",
        "isCorporateCodeFare"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SelectedFare {
    @JsonProperty("resultIndex")
    public String resultIndex;
    @JsonProperty("fareSource")
    public Integer fareSource;
    @JsonProperty("fareIndicator")
    public Integer fareIndicator;
    @JsonProperty("noOfSeatsAvailable")
    public Integer noOfSeatsAvailable;
    @JsonProperty("color")
    public String color;
    @JsonProperty("type")
    public String type;
    @JsonProperty("travelPlusFareType")
    public String travelPlusFareType;
    @JsonProperty("publishedFare")
    public Integer publishedFare;
    @JsonProperty("baggage")
    public Baggage__1 baggage;
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
    public Boolean inPolicy;
    @JsonProperty("ticketingSourceValue")
    public Integer ticketingSourceValue;
    @JsonProperty("refundable")
    public Boolean refundable;
    @JsonProperty("corporateCodeFare")
    public Boolean corporateCodeFare;
    @JsonProperty("isRefundable")
    public Boolean isRefundable;
    @JsonProperty("isCorporateCodeFare")
    public Boolean isCorporateCodeFare;
}

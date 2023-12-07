package UtilsAPI.trip.responsedto.search;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.util.ArrayList;

@JsonPropertyOrder({
        "resultIndex",
        "fareSource",
        "noOfSeatsAvailable",
        "color",
        "type",
        "travelPlusFareType",
        "publishedFare",
        "baggage",
        "cancellationCharges",
        "rescheduleCharges",
        "ticketingSourceValue",
        "inPolicy",
        "outOfPolicy",
        "outOfPolicyReasons",
        "publishedFare",
        "pricingKey",
        "isRefundable",
        "isCorporateCodeFare",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FareClass {
    public String resultIndex;
    public int fareSource;
    public int noOfSeatsAvailable;
    public String color;
    public String type;
    public String travelPlusFareType;
    public double publishedFare;
    public Baggage baggage;
    public String cancellationCharges;
    public String rescheduleCharges;
    public int ticketingSourceValue;
    public boolean inPolicy;
    public OutOfPolicy outOfPolicy;
    public ArrayList<String> outOfPolicyReasons;
    public Object pricingKey;
    public boolean isRefundable;
    public boolean isCorporateCodeFare;
}

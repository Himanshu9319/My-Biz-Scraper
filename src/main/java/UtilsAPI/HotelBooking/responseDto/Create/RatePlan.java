package UtilsAPI.HotelBooking.responseDto.Create;
import java.util.List;
import javax.annotation.Generated;

import UtilsAPI.TravelPlus.responseDto.Initial.OutOfPolicy;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "price",
        "name",
        "id",
        "gstIncluded",
        "nights",
        "selected",
        "pahApplicable",
        "roomCount",
        "travellersCount",
        "cancellationInfo",
        "dailyRatePlanPrices",
        "outOfPolicy",
        "outOfPolicyReasons"
})
public class RatePlan {
    @JsonProperty("price")
    public Double price;
    @JsonProperty("name")
    public String name;
    @JsonProperty("id")
    public String id;
    @JsonProperty("gstIncluded")
    public Boolean gstIncluded;
    @JsonProperty("nights")
    public Integer nights;
    @JsonProperty("selected")
    public Boolean selected;
    @JsonProperty("pahApplicable")
    public Boolean pahApplicable;
    @JsonProperty("roomCount")
    public Integer roomCount;
    @JsonProperty("travellersCount")
    public Integer travellersCount;
    @JsonProperty("cancellationInfo")
    public CancellationInfo cancellationInfo;
    @JsonProperty("dailyRatePlanPrices")
    public List<DailyRatePlanPrice> dailyRatePlanPrices;
    @JsonProperty("outOfPolicy")
    public OutOfPolicy outOfPolicy;
    @JsonProperty("outOfPolicyReasons")
    public Object outOfPolicyReasons;
}

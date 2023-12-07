package UtilsAPI.HotelBooking.responseDto.search;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "preferredLocation",
        "brands",
        "corporateRating",
        "starRatings",
        "cancellationPolicy",
        "confirmationType",
        "recommendedOnly",
        "payAtHotelOnly",
        "outOfPolicyHotels",
        "localities",
        "hotelChains",
        "mealPlan",
        "minPrice",
        "maxPrice",
        "minPriceLimit",
        "maxPriceLimit",
        "maxPriceDisplay",
        "inititalMinPrice",
        "inititalMaxPrice",
        "pricing"
})
@Generated("jsonschema2pojo")
public class Filters {
    @JsonProperty("preferredLocation")
    public Boolean preferredLocation;
    @JsonProperty("brands")
    public Object brands;
    @JsonProperty("corporateRating")
    public Object corporateRating;
    @JsonProperty("starRatings")
    public List<StarRating> starRatings;
    @JsonProperty("cancellationPolicy")
    public Object cancellationPolicy;
    @JsonProperty("confirmationType")
    public List<ConfirmationType> confirmationType;
    @JsonProperty("recommendedOnly")
    public Boolean recommendedOnly;
    @JsonProperty("payAtHotelOnly")
    public Boolean payAtHotelOnly;
    @JsonProperty("outOfPolicyHotels")
    public Object outOfPolicyHotels;
    @JsonProperty("localities")
    public Object localities;
    @JsonProperty("hotelChains")
    public Object hotelChains;
    @JsonProperty("mealPlan")
    public List<MealPlan> mealPlan;
    @JsonProperty("minPrice")
    public Integer minPrice;
    @JsonProperty("maxPrice")
    public Integer maxPrice;
    @JsonProperty("minPriceLimit")
    public Integer minPriceLimit;
    @JsonProperty("maxPriceLimit")
    public Integer maxPriceLimit;
    @JsonProperty("maxPriceDisplay")
    public Integer maxPriceDisplay;
    @JsonProperty("inititalMinPrice")
    public Integer inititalMinPrice;
    @JsonProperty("inititalMaxPrice")
    public Integer inititalMaxPrice;
    @JsonProperty("pricing")
    public Pricing pricing;
}

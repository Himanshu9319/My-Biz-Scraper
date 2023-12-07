package UtilsAPI.trip.responsedto.search;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "minPriceLimit",
        "maxPriceLimit",
        "minPrice",
        "maxPrice",
        "maxPriceDisplay",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceMinMaxFilter {
    public double minPriceLimit;
    public double maxPriceLimit;
    public double minPrice;
    public double maxPrice;
    public double maxPriceDisplay;
}

package UtilsAPI.TravelPlus.responseDto.Search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "base",
        "taxesAndFees",
        "publishedFare",
        "outOfPolicy"
})
@Generated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fare {
    @JsonProperty("base")
    public double base;
    @JsonProperty("taxesAndFees")
    public double taxesAndFees;
    @JsonProperty("publishedFare")
    public double publishedFare;
    @JsonProperty("outOfPolicy")
    public Object outOfPolicy;
}

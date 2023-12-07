package UtilsAPI.HotelBooking.responseDto.search;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "initialMin",
        "initialMax",
        "min",
        "max",
        "buckets"
})
@Generated("jsonschema2pojo")
public class Pricing {
    @JsonProperty("initialMin")
    public Integer initialMin;
    @JsonProperty("initialMax")
    public Integer initialMax;
    @JsonProperty("min")
    public Integer min;
    @JsonProperty("max")
    public Object max;
    @JsonProperty("buckets")
    public List<Bucket> buckets;
}

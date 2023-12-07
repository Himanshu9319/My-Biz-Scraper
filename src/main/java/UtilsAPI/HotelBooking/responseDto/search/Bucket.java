package UtilsAPI.HotelBooking.responseDto.search;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "min",
        "max",
        "selected"
})
@Generated("jsonschema2pojo")
public class Bucket {
    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("min")
    public Integer min;
    @JsonProperty("max")
    public Object max;
    @JsonProperty("selected")
    public Boolean selected;
}

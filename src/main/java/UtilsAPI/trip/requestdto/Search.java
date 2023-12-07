package UtilsAPI.trip.requestdto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.redis.S;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "noOfTravellers",
        "origin",
        "destination",
        "arrivalCity",
        "sourceCity",

})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Search {
    public int noOfTravellers;
    public String origin;
    public String destination;
    public String arrivalCity;
    public String sourceCity;
    public String departure;
    public String travelClass;
}

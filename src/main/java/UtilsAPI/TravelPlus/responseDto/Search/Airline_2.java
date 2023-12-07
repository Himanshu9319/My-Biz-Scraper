package UtilsAPI.TravelPlus.responseDto.Search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "airlineCode",
        "airlineIcon",
        "airlineTailIcon",
        "airlineName",
        "flightNumber",
        "id",
        "name",
        "icon",
        "tailIcon",
        "selected"

})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airline_2 {
    public String airlineCode;
    public String airlineIcon;
    public String airlineTailIcon;
    public String airlineName;
    public String flightNumber;
    public String id;
    public String name;
    public String icon;
    public String tailIcon;
    public boolean selected;
}

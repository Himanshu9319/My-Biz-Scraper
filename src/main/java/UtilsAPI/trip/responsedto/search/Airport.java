package UtilsAPI.trip.responsedto.search;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "terminal",
        "airportName",
        "cityName",
        "cityCode",
        "airportCode",
        "countryName",
        "countryCode"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airport {
    @JsonProperty("terminal")
    public String terminal;
    @JsonProperty("airportName")
    public String airportName;
    @JsonProperty("cityName")
    public String cityName;
    @JsonProperty("cityCode")
    public String cityCode;
    @JsonProperty("airportCode")
    public String airportCode;
    @JsonProperty("countryName")
    public String countryName;
    @JsonProperty("countryCode")
    public String countryCode;
}

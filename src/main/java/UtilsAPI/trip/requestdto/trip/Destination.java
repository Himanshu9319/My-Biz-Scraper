package UtilsAPI.trip.requestdto.trip;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "airport",
        "arrTime",
        "date",
        "time",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Destination {
    @JsonProperty("airport")
    public Airport airport;
    @JsonProperty("arrTime")
    public String arrTime;
    @JsonProperty("date")
    public String date;
    @JsonProperty("time")
    public String time;
}

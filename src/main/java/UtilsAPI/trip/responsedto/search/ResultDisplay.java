package UtilsAPI.trip.responsedto.search;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.util.ArrayList;

@JsonPropertyOrder({
        "totalDuration",
        "stopInfo",
        "airlines",
        "source",
        "destination",
        "totalLayoverTimeInHours"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDisplay {
    public String totalDuration;
    public String stopInfo;
    public ArrayList<Airline> airlines;
    public Source source;
    public Destination destination;
    public double totalLayoverTimeInHours;

}

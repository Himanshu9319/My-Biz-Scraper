package UtilsAPI.trip.responsedto.search;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "id",
        "resultDisplay",
        "resultDetail",
        "sort",
        "stop",
        "travelClass",
        "ticketingSourceValue"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchResultsInPolicy {

    public String id;
    public ResultDisplay resultDisplay;
    public ResultDetail resultDetail;
    public Sort sort;
    public String stop;
    public String travelClass;
    public int ticketingSourceValue;
}

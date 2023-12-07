package UtilsAPI.trip.responsedto.search;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "id",
        "name",
        "timeRange",
        "selected",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArrivalTimeSlot {
    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("timeRange")
    public TimeRange timeRange;
    @JsonProperty("selected")
    public boolean selected;
}

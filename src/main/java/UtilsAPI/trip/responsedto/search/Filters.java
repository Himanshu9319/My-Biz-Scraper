package UtilsAPI.trip.responsedto.search;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.util.ArrayList;

@JsonPropertyOrder({
        "stop",
        "entitlement",
        "filterAirline",
        "departureTimeSlot",
        "arrivalTimeSlot",
        "priceMinMax",
        "priceMinMaxFilter"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filters {

    public ArrayList<Stop> stop;
    public ArrayList<Entitlement> entitlement;
    public ArrayList<FilterAirline> filterAirline;
    public ArrayList<DepartureTimeSlot> departureTimeSlot;
    public ArrayList<ArrivalTimeSlot> arrivalTimeSlot;
    public String priceMinMax;
    public PriceMinMaxFilter priceMinMaxFilter;
}

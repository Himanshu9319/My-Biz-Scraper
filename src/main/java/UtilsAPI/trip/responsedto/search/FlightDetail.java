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
        "isGstMandatory",
        "flightItineraries",
        "fare",
        "cancellationCharges",
        "rescheduleCharges",
        "gstMandatory",
        "lcc",
        "isLcc",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FlightDetail {

    public String totalDuration;
    public boolean isGstMandatory;
    public ArrayList<FlightItinerary> flightItineraries;
    public Fare fare;
    public ArrayList<CancellationCharge> cancellationCharges;
    public ArrayList<RescheduleCharge> rescheduleCharges;
    public boolean gstMandatory;
    public boolean lcc;

    public boolean isLcc() {
        return isLcc;
    }

    public void setLcc(boolean lcc) {
        isLcc = lcc;
    }

    public boolean isLcc;


}

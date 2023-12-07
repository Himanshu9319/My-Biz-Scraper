package UtilsAPI.trip.requestdto.trip;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "tripTitle",
        "purposeOfTravel",
        "flightTripRequest",
        "travelers",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Trip {
    public String tripTitle;
    public String purposeOfTravel;
    public ArrayList<FlightTripRequest> flightTripRequest;
    public ArrayList<Traveler> travelers;
}

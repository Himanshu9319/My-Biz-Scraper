package UtilsAPI.trip.requestdto.trip;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "flightCharges",
        "mealCharges",
        "seatCharges",
        "baggageCharges",
        "convenienceFee",
        "convFeeWithGst",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceBreakup {
    public int flightCharges;
    public int mealCharges;
    public int seatCharges;
    public int baggageCharges;
    public Object convenienceFee;
    public int convFeeWithGst;
}

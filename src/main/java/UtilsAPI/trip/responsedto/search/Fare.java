package UtilsAPI.trip.responsedto.search;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "base",
        "taxesAndFees",
        "publishedFare",
        "outOfPolicy"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Fare {
    public double base;
    public double taxesAndFees;
    public double publishedFare;
    public Object outOfPolicy;
}

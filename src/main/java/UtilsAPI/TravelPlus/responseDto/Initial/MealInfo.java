package UtilsAPI.TravelPlus.responseDto.Initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "airlineCode",
        "flightNumber",
        "mealType",
        "mealPlan",
        "mealCode",
        "mealDescription",
        "quantity",
        "price",
        "mealCode",
        "mealDescription",
        "quantity",
        "price",
        "origin",
        "destination",
        "ticketingSource",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MealInfo {
    @JsonProperty("airlineCode")
    public String airlineCode;
    @JsonProperty("flightNumber")
    public String flightNumber;
    @JsonProperty("mealType")
    public String mealType;
    @JsonProperty("mealPlan")
    public String mealPlan;
    @JsonProperty("mealCode")
    public String mealCode;
    @JsonProperty("mealDescription")
    public String mealDescription;
    @JsonProperty("quantity")
    public int quantity;
    @JsonProperty("price")
    public double price;
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
    @JsonProperty("ticketingSource")
    public String ticketingSource;
}

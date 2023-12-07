package UtilsAPI.TravelPlus.responseDto.Initial;

import UtilsAPI.TravelPlus.responseDto.Search.ResultDisplay;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.util.ArrayList;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        //"potBookingId",
        "priceChange",
        "timeChange",
        "resultDisplay",
        "fareRule",
        "mealDetails",
        "seatDetails",
        "baggageDetails",
        "priceBreakup",
        "outOfPolicy",
        "ticketingSource",
        "lcc",
        "seatAvailable",
        "timeChanged",
        "freeMealAvailable",
        "freeSeatAvailable",
        "isLcc",
        "isSeatAvailable",
        "ticketingSource",
        "lcc",
        "isSeatAvailable",
        "isTimeChanged",
        "isFreeMealAvailable",
        "isFreeSeatAvailable",
        "verbiage",
        "travelClassKey",
        "travelClass"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CheckoutResponse {
    @JsonProperty("potBookingId")
    public String potBookingId;
    @JsonProperty("priceChange")
    public PriceChange priceChange;
    @JsonProperty("timeChange")
    public TimeChange timeChange;
    @JsonProperty("resultDisplay")
    public ResultDisplay resultDisplay;
    @JsonProperty("fareRule")
    public FareRule fareRule;
    @JsonProperty("mealDetails")
    public ArrayList<MealDetail> mealDetails;
    @JsonProperty("seatDetails")
    public ArrayList<SeatDetail> seatDetails;
    @JsonProperty("baggageDetails")
    public ArrayList<BaggageDetail> baggageDetails;
    @JsonProperty("priceBreakup")
    public PriceBreakup priceBreakup;
    @JsonProperty("outOfPolicy")
    public OutOfPolicy outOfPolicy;
    @JsonProperty("ticketingSource")
    public Object ticketingSource;
    @JsonProperty("lcc")
    public boolean lcc;
    @JsonProperty("seatAvailable")
    public boolean seatAvailable;
    @JsonProperty("timeChanged")
    public boolean timeChanged;
    @JsonProperty("freeMealAvailable")
    public boolean freeMealAvailable;
    @JsonProperty("freeSeatAvailable")
    public boolean freeSeatAvailable;
    @JsonProperty("isLcc")
    public boolean isLcc;
    @JsonProperty("isSeatAvailable")
    public boolean isSeatAvailable;
    @JsonProperty("isTimeChanged")
    public boolean isTimeChanged;
    @JsonProperty("isFreeMealAvailable")
    public boolean isFreeMealAvailable;
    @JsonProperty("isFreeSeatAvailable")
    public boolean isFreeSeatAvailable;
    @JsonProperty("verbiage")
    public Verbiage verbiage;
    @JsonProperty("travelClassKey")
    public String travelClassKey;
    @JsonProperty("travelClass")
    public String travelClass;
}

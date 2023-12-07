package UtilsAPI.TravelPlus.responseDto.Initial;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatInfoLcc {
    @JsonProperty("airlineCode")
    private String airlineCode;
    @JsonProperty("flightNumber")
    private String flightNumber;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("craftType")
    private String craftType;
    @JsonProperty("availablityType")
    private int availablityType;
    @JsonProperty("description")
    private int description;
    @JsonProperty("code")
    private String code;
    @JsonProperty("rowNo")
    private String rowNo;
    @JsonProperty("seatNo")
    private String seatNo;
    @JsonProperty("seatType")
    private int seatType;
    @JsonProperty("seatWayType")
    private int seatWayType;
    @JsonProperty("compartment")
    private int compartment;
    @JsonProperty("deck")
    private int deck;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("colorCode")
    private String colorCode;
    @JsonProperty("isSeatAvailable")
    private boolean isSeatAvailable;
    @JsonProperty("seatTypeValue")
    private Integer seatTypeValue;
    //For policy level status
    @JsonProperty("isSeatOutOfPolicy")
    private boolean isSeatOutOfPolicy;
    @JsonProperty("ticketingSource")
    private Integer ticketingSource;
    @JsonProperty("std")
    public String std;

}

package UtilsAPI.TravelPlus.responseDto.Initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.util.ArrayList;

@JsonPropertyOrder({
        "listColumns",
        "splitAfterColumn",
        "priceVsColorCodeMap",
        "rowData",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatPlan {
    @JsonProperty("listColumns")
    public ArrayList<String> listColumns;
    @JsonProperty("splitAfterColumn")
    public ArrayList<String> splitAfterColumn;
    @JsonProperty("priceVsColorCodeMap")
    public PriceVsColorCodeMap priceVsColorCodeMap;
    @JsonProperty("rowData")
    public ArrayList<ArrayList<SeatInfoLcc>> rowData;
}

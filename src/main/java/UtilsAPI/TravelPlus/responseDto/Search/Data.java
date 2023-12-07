package UtilsAPI.TravelPlus.responseDto.Search;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.annotation.Generated;
import java.util.ArrayList;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties("message")
@JsonPropertyOrder({
        "csvResponseV1",
        "searchResults",
        "filters",
        "source",
        "baggageRuleInfoText",
        "internationalSearch",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Data {
    @JsonProperty("csvResponseV1")
    public Object csvResponseV1;
    @JsonProperty("searchResults")
    public ArrayList<SearchResults> searchResults;
    @JsonProperty("filters")
    public Filters filters;
    @JsonProperty("source")
    public String source;

    // @JsonProperty("showRecommendedFlights")
    public boolean showRecommendedFlights;

    public boolean isShowRecommendedFlights() {
        return showRecommendedFlights;
    }

    public void setShowRecommendedFlights(boolean showRecommendedFlights) {
        this.showRecommendedFlights = showRecommendedFlights;
    }

    @JsonProperty("baggageRuleInfoText")
    public ArrayList<String> baggageRuleInfoText;

    @JsonProperty("internationalSearch")
    public boolean internationalSearch;

    @JsonProperty("newjsonproeprty")
    public String newjsonproeprty;

}

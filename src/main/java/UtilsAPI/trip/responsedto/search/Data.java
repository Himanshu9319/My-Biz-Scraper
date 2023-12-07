package UtilsAPI.trip.responsedto.search;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.util.ArrayList;

@JsonPropertyOrder({
        "searchResultsInPolicy",
        "searchResultsOutOfPolicy",
        "filters",
        "convFeeWithGst",
        "source",
        "outOfPolicy",
        "showRecommendedFlights",
        "baggageRuleInfoText",
        "outOfPolicyReasons",
        "internationalSearch",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    @JsonProperty("searchResultsInPolicy")
    public ArrayList<SearchResultsInPolicy> searchResultsInPolicy;
    @JsonProperty("searchResultsOutOfPolicy")
    public ArrayList<Object> searchResultsOutOfPolicy;
    @JsonProperty("filters")
    public Filters filters;
    @JsonProperty("convFeeWithGst")
    public double convFeeWithGst;
    @JsonProperty("source")
    public String source;
    @JsonProperty("outOfPolicy")
    public OutOfPolicy outOfPolicy;
    @JsonProperty("showRecommendedFlights")
    public boolean showRecommendedFlights;
    @JsonProperty("baggageRuleInfoText")
    public ArrayList<String> baggageRuleInfoText;
    @JsonProperty("outOfPolicyReasons")
    public ArrayList<String> outOfPolicyReasons;
    @JsonProperty("internationalSearch")
    public boolean internationalSearch;
}

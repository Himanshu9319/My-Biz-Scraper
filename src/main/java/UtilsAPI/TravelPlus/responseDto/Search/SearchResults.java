package UtilsAPI.TravelPlus.responseDto.Search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.annotation.Generated;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "resultDisplay",
        "resultDetail",
        "sort",
        "filter",
        "isBookable",
        "bookRestrictionReason",
        "travelClass",
        "travelClassText",
        "ticketingSourceValue"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchResults {
    @JsonProperty("id")
    public String id;
    @JsonProperty("resultDisplay")
    public ResultDisplay resultDisplay;
    @JsonProperty("resultDetail")
    public ResultDetail resultDetail;
    @JsonProperty("sort")
    public Sort sort;
    @JsonProperty("filter")
    public Filter filter;
    @JsonProperty("isBookable")
    public boolean isBookable;
    @JsonProperty("bookRestrictionReason")
    public Object bookRestrictionReason;
    @JsonProperty("travelClass")
    public String travelClass;
    @JsonProperty("travelClassText")
    public String travelClassText;

    @Override
    public String toString() {
        return "SearchResults{" +
                "id='" + id + '\'' +
                ", resultDisplay=" + resultDisplay +
                ", resultDetail=" + resultDetail +
                ", sort=" + sort +
                ", filter=" + filter +
                ", isBookable=" + isBookable +
                ", bookRestrictionReason=" + bookRestrictionReason +
                ", travelClass='" + travelClass + '\'' +
                ", travelClassText='" + travelClassText + '\'' +
                ", ticketingSourceValue=" + ticketingSourceValue +
                '}';
    }

    @JsonProperty("ticketingSourceValue")
    public int ticketingSourceValue;
}


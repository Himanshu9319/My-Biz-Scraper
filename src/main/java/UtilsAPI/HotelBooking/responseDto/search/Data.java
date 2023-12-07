package UtilsAPI.HotelBooking.responseDto.search;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "csvResponseV1",
        "checkIn",
        "checkOut",
        "searchId",
        "totalProperties",
        "properties",
        "filters",
        "positionSubmitQuery",
        "landmarkSearch",
        "locality",
        "city",
        "pageTitle",
        "nextPage",
        "firstPage",
        "allPropertiesFetched",
        "sortOrder",
        "locationLat",
        "locationLon"
})
@Generated("jsonschema2pojo")
public class Data {
    @JsonProperty("csvResponseV1")
    public Object csvResponseV1;
    @JsonProperty("checkIn")
    public String checkIn;
    @JsonProperty("checkOut")
    public String checkOut;
    @JsonProperty("searchId")
    public String searchId;
    @JsonProperty("totalProperties")
    public Integer totalProperties;
    @JsonProperty("properties")
    public List<Object> properties;
    @JsonProperty("filters")
    public Filters filters;
    @JsonProperty("positionSubmitQuery")
    public Integer positionSubmitQuery;
    @JsonProperty("landmarkSearch")
    public Boolean landmarkSearch;
    @JsonProperty("locality")
    public String locality;
    @JsonProperty("city")
    public String city;
    @JsonProperty("pageTitle")
    public String pageTitle;
    @JsonProperty("nextPage")
    public Boolean nextPage;
    @JsonProperty("firstPage")
    public Boolean firstPage;
    @JsonProperty("allPropertiesFetched")
    public Boolean allPropertiesFetched;
    @JsonProperty("sortOrder")
    public Object sortOrder;
    @JsonProperty("locationLat")
    public String locationLat;
    @JsonProperty("locationLon")
    public String locationLon;
}

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
        "nonLccMeals",
        "mealInfos",
        "origin",
        "destination",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MealDetail {
    @JsonProperty("nonLccMeals")
    public Object nonLccMeals;
    @JsonProperty("mealInfos")
    public ArrayList<MealInfo> mealInfos;
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("destination")
    public String destination;
}

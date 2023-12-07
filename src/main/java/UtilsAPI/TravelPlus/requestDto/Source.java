package UtilsAPI.TravelPlus.requestDto;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.cucumber.java.eo.Se;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "airport",
        "depTime"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Source {

    @JsonProperty("airport")
    public Airport airport;
    @JsonProperty("depTime")
    public String depTime;
}

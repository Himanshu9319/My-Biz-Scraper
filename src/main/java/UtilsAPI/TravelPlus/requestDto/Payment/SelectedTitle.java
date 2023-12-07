package UtilsAPI.TravelPlus.requestDto.Payment;


import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "text",
        "value"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SelectedTitle {
    @JsonProperty("text")
    public String text;
    @JsonProperty("value")
    public String value;
}

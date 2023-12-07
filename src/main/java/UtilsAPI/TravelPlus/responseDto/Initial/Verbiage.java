package UtilsAPI.TravelPlus.responseDto.Initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "modificationPolicy",
        "cancellationPolicy",
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Verbiage {
    @JsonProperty("modificationPolicy")
    public Object modificationPolicy;
    @JsonProperty("cancellationPolicy")
    public String cancellationPolicy;
}

package UtilsAPI.TravelPlus.responseDto.Confirm;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "errors"
})
@Generated("jsonschema2pojo")
public class CsvResponseV1 {
    @JsonProperty("errors")
    public List<String> errors;

}

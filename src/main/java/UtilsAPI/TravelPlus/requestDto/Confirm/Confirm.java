package UtilsAPI.TravelPlus.requestDto.Confirm;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "potMasterBookingId"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
public class Confirm {
    @JsonProperty("potMasterBookingId")
    public String potMasterBookingId;
}

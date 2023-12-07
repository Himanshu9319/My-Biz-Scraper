package UtilsAPI.TravelPlus.responseDto.Details;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "phone",
        "email"
})
@Generated("jsonschema2pojo")
public class ContactInfo {
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("email")
    public String email;
}

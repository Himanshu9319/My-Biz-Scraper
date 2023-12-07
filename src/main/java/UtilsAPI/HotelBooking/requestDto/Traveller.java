package UtilsAPI.HotelBooking.requestDto;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({
        "email",
        "firstName",
        "lastName",
        "title",
        "mobile",
        "isSaveDetails",
        "middleName",
        "guestType",
        "corporateUserType",
        "corporateUserTypeResponse",
        "guestTypeResponse",
        "userId",
        "id"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
public class Traveller {
    @JsonProperty("email")
    public String email;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("title")
    public String title;
    @JsonProperty("mobile")
    public String mobile;
    @JsonProperty("isSaveDetails")
    public Boolean isSaveDetails;
    @JsonProperty("middleName")
    public String middleName;
    @JsonProperty("guestType")
    public String guestType;
    @JsonProperty("corporateUserType")
    public Object corporateUserType;
    @JsonProperty("corporateUserTypeResponse")
    public Object corporateUserTypeResponse;
    @JsonProperty("guestTypeResponse")
    public Object guestTypeResponse;
    @JsonProperty("userId")
    public Object userId;
    @JsonProperty("id")
    public Object id;
}

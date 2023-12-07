package UtilsAPI.TravelPlus.requestDto.Payment;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
@JsonPropertyOrder({
        "selectedGender",
        "selectedTitle",
        "isLeadPax",
        "isdCode",
        "countryName",
        "address",
        "city",
        "key",
        "mealDetails",
        "seatDetails",
        "baggageDetails",
        "firstName",
        "lastName",
        "gender",
        "title",
        "contactNo",
        "email",
        "passportNumber",
        "passportExpiryDate",
        "nationality",
        "dateOfBirth",
        "userId"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger {
    @JsonProperty("selectedGender")
    public SelectedGender selectedGender;
    @JsonProperty("selectedTitle")
    public SelectedTitle selectedTitle;
    @JsonProperty("isLeadPax")
    public Boolean isLeadPax;
    @JsonProperty("isdCode")
    public String isdCode;
    @JsonProperty("countryName")
    public String countryName;
    @JsonProperty("address")
    public String address;
    @JsonProperty("city")
    public String city;
    @JsonProperty("key")
    public Integer key;
    @JsonProperty("mealDetails")
    public Object mealDetails;
    @JsonProperty("seatDetails")
    public Object seatDetails;
    @JsonProperty("baggageDetails")
    public Object baggageDetails;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("title")
    public String title;
    @JsonProperty("contactNo")
    public String contactNo;
    @JsonProperty("email")
    public String email;
    @JsonProperty("passportNumber")
    public Object passportNumber;
    @JsonProperty("passportExpiryDate")
    public Object passportExpiryDate;
    @JsonProperty("nationality")
    public String nationality;
    @JsonProperty("dateOfBirth")
    public Object dateOfBirth;
    @JsonProperty("userId")
    public Object userId;
}

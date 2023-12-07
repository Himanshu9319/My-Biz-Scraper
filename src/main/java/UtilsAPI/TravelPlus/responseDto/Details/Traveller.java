package UtilsAPI.TravelPlus.responseDto.Details;
import java.util.List;
import javax.annotation.Generated;

import UtilsAPI.TravelPlus.responseDto.Initial.BaggageInfo;
import UtilsAPI.TravelPlus.responseDto.Initial.MealInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.cucumber.java.mk_latn.No;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "firstName",
        "lastName",
        "gender",
        "email",
        "isdCode",
        "countryCode",
        "countryName",
        "phone",
        "address",
        "city",
        "nationality",
        "ticketNumber",
        "passportNumber",
        "passportExpiryDate",
        "userId",
        "isVip",
        "guestType",
        "corporateUserType",
        "corporateUserTypeResponse",
        "guestTypeResponse",
        "isPrimary",
        "seatsSelected",
        "baggageInfos",
        "mealInfos",
        "sourceDestinationWiseAddOns",
        "vip",
        "isLeadPax"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Traveller {

    @JsonProperty("title")
    public String title;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("email")
    public String email;
    @JsonProperty("isdCode")
    public String isdCode;
    @JsonProperty("countryCode")
    public String countryCode;
    @JsonProperty("countryName")
    public String countryName;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("mobile")
    public String mobile;
    @JsonProperty("address")
    public String address;
    @JsonProperty("city")
    public String city;
    @JsonProperty("nationality")
    public String nationality;
    @JsonProperty("ticketNumber")
    public String ticketNumber;
    @JsonProperty("passportNumber")
    public String passportNumber;
    @JsonProperty("passportExpiryDate")
    public String passportExpiryDate;
    @JsonProperty("userId")
    public String userId;
    @JsonProperty("isVip")
    public Boolean isVip;
    @JsonProperty("guestType")
    public String guestType;
    @JsonProperty("corporateUserType")
    public String corporateUserType;
    @JsonProperty("corporateUserTypeResponse")
    public CorporateUserTypeResponse corporateUserTypeResponse;
    @JsonProperty("guestTypeResponse")
    public GuestTypeResponse guestTypeResponse;
    @JsonProperty("isPrimary")
    public Boolean isPrimary;
    @JsonProperty("seatsSelected")
    public List<SeatsSelected> seatsSelected;
    @JsonProperty("baggageInfos")
    public List<BaggageInfo> baggageInfos;
    @JsonProperty("mealInfos")
    public List<MealInfo> mealInfos;
    @JsonProperty("sourceDestinationWiseAddOns")
    public SourceDestinationWiseAddOns sourceDestinationWiseAddOns;
    @JsonProperty("vip")
    public Boolean vip;
    @JsonProperty("isLeadPax")
    public Boolean isLeadPax;

}

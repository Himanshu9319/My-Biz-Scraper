package UtilsAPI.TravelPlus.requestDto.Payment;


import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "potMasterBookingId",
        "passengers",
        "paymentOption",
        "companyGstDetail",
        "provider"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payload {
    @JsonProperty("potMasterBookingId")
    public String potMasterBookingId;
    @JsonProperty("passengers")
    public List<Passenger> passengers;
    @JsonProperty("paymentOption")
    public String paymentOption;
    @JsonProperty("companyGstDetail")
    public CompanyGstDetail companyGstDetail;
    @JsonProperty("provider")
    public String provider;

}

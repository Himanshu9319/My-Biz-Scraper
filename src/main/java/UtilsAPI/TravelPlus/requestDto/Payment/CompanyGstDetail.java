package UtilsAPI.TravelPlus.requestDto.Payment;


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
        "gSTCompanyAddress",
        "gSTNumber",
        "gSTCompanyContactNumber",
        "gSTCompanyName",
        "gSTCompanyEmail"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyGstDetail {
    @JsonProperty("gSTCompanyAddress")
    public String gSTCompanyAddress;
    @JsonProperty("gSTNumber")
    public String gSTNumber;
    @JsonProperty("gSTCompanyContactNumber")
    public String gSTCompanyContactNumber;
    @JsonProperty("gSTCompanyName")
    public String gSTCompanyName;
    @JsonProperty("gSTCompanyEmail")
    public String gSTCompanyEmail;


}

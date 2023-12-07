package UtilsAPI.TravelPlus.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;


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
        "emailid",
        "otp"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthVerifyDto {

    @JsonProperty("emailid")
    public String emailid;
    @JsonProperty("otp")
    public String otp;


}
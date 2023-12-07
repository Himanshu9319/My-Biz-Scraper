package UtilsAPI.TravelPlus.responseDto.Payment;

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
        "csvResponseV1",
        "potMasterBookingId",
        "checkoutResponses",
        "paymentOptions",
        "wallet",
        "btcWallet",
        "passengerDetails",
        "nationalities",
        "isPassportMandatory"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    @JsonProperty("csvResponseV1")
    public Object csvResponseV1;
    @JsonProperty("potMasterBookingId")
    public String potMasterBookingId;
    @JsonProperty("checkoutResponses")
    public List<Object> checkoutResponses;
    @JsonProperty("paymentOptions")
    public List<PaymentOption> paymentOptions;
    @JsonProperty("wallet")
    public Object wallet;
    @JsonProperty("btcWallet")
    public Object btcWallet;
    @JsonProperty("passengerDetails")
    public Object passengerDetails;
    @JsonProperty("nationalities")
    public List<String> nationalities;
    @JsonProperty("isPassportMandatory")
    public Boolean isPassportMandatory;
}

package UtilsAPI.TravelPlus.responseDto.Initial;

import UtilsAPI.TravelPlus.responseDto.Payment.PaymentOption;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import javax.annotation.Generated;
import java.util.ArrayList;
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
@ToString
public class Data {
    @JsonProperty("csvResponseV1")
    public Object csvResponseV1;
    @JsonProperty("potMasterBookingId")
    public String potMasterBookingId;
    @JsonProperty("checkoutResponses")
    public ArrayList<CheckoutResponse> checkoutResponses;
    @JsonProperty("paymentOptions")
    public ArrayList<PaymentOption> paymentOptions;
    @JsonProperty("wallet")
    public Object wallet;
    @JsonProperty("btcWallet")
    public Object btcWallet;
    @JsonProperty("passengerDetails")
    public Object passengerDetails;
    @JsonProperty("nationalities")
    public ArrayList<String> nationalities;
    @JsonProperty("isPassportMandatory")
    public boolean isPassportMandatory;

    @JsonProperty("isPasasdasdsportMandatory")
    public boolean isPasasdasdsportMandatory;
}

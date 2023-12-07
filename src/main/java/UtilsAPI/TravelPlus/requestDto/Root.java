package UtilsAPI.TravelPlus.requestDto;



import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.cucumber.java.eo.Se;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "checkoutRequests",
        "provider",
        "passengerUserIds"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Root {
    @JsonProperty("checkoutRequests")
    public List<CheckoutRequest> checkoutRequests;
    @JsonProperty("provider")
    public String provider;
    @JsonProperty("passengerUserIds")
    public ArrayList<Object> passengerUserIds;

}

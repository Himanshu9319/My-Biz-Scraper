package UtilsAPI.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "code",
        "error"
})
@Getter
@Setter
public class FailureResponse<T> {

    @JsonProperty("code")
    public Integer code;
    @JsonProperty("error")
    public String error;

    public static <T> FailureResponse<T> convertFromJsonUsingJackson(String jsonData, Class<T> responseType) {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = new Object();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        FailureResponse<T> response = null;
        try {
            response = mapper.readValue(jsonData, new TypeReference<FailureResponse<T>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        T responseBody = mapper.convertValue(response.getCode(), responseType);
        response.setCode((Integer) responseBody);
        return response;
    }

}
package UtilsAPI.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardResponse<T> {


    private String message;
    private T response;
    private Object data;

    public static <T> StandardResponse<T> parseJsonResponse(String jsonData, Class<T> responseType) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        StandardResponse<T> response = null;
        try {
            response = mapper.readValue(jsonData, new TypeReference<StandardResponse<T>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        T responseBody = mapper.convertValue(response.getResponse(), responseType);
        response.setResponse(responseBody);
        return response;
    }
}

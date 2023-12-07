package UtilsAPI.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StandardResponseArray<T> {

    private String status;
    private int statusCode;
    private Object errorCode;
    private String message;
    private List<T> response;
    private Object errorResponse;
    private Object errorMessage;
    private Object responseData;

    public static <T> StandardResponseArray<T> parseJsonArrayResponse(String response, TypeReference<StandardResponseArray<T>> typeReference) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        StandardResponseArray<T> standardResponse;
        try {
            standardResponse = objectMapper.readValue(response, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return standardResponse;
    }

}
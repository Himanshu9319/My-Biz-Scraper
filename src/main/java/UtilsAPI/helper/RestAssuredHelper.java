package UtilsAPI.helper;

//import UtilsAPI.helper.RequestConfigs;
//import UtilsAPI.helper.CommonContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class RestAssuredHelper {
    private static final Logger logger = LoggerFactory.getLogger(RestAssuredHelper.class);

    public RestAssuredHelper() {
    }

    private static ExtractableResponse<Response> getResponse(HTTPRequestType requestType, Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody, RequestConfigs requestConfigs) {
        ValidatableResponse validatableResponse = null;
        if (null == requestConfigs) {
            requestConfigs = new RequestConfigs();
        }

        if (params == null) {
            params = new HashMap();
        }

        CommonContext commonContext = CommonContextFactory.getCommonContext();
        CustomLogFilter filter = commonContext.getFilter();

        try {
            RequestSpecification requestSpecification = getRequestSpecification(filter, requestConfigs);
            Map<String, Object> formParams = new HashMap();
            fillRequestConfigs(requestConfigs, requestSpecification, formParams);
            RequestSpecification initialRequest = requestBody == null ? requestSpecification.headers(headerMap).queryParams(params).when() : requestSpecification.headers(headerMap).queryParams(params).body(getRequestBody(requestBody)).when();
            switch (requestType) {
                case GET:
                    validatableResponse = initialRequest.get(requestURL, new Object[0]).then();
                    break;
                case PUT:
                    validatableResponse = initialRequest.put(requestURL, new Object[0]).then();
                    break;
                case PATCH:
                    validatableResponse = initialRequest.patch(requestURL, new Object[0]).then();
                    break;
                case POST:
                    validatableResponse = initialRequest.post(requestURL, new Object[0]).then();
                    break;
                case DELETE:
                    validatableResponse = initialRequest.delete(requestURL, new Object[0]).then();
            }

            ExtractableResponse<Response> response = requestConfigs.isLogsNeeded() ? validatableResponse.log().all().extract() : validatableResponse.extract();
            fillLogs(filter, commonContext);
            return response;
        } catch (Exception var13) {
            fillLogs(filter, commonContext);
            throw new AssertionError(var13.getLocalizedMessage() + " url : " + requestURL);
        }
    }

    private static void fillLogs(CustomLogFilter filter, CommonContext commonContext) {
        if (filter != null) {
            commonContext.getScenario().log("\nAPI Request:\n\n" + filter.getRequestBuilder() + "\nAPI BonusImage_ResponseDto:" + filter.getResponseBuilder());
        }

    }

    public static RestAssuredConfig getDefaultConfig() {
        return RestAssured.config().httpClient(HttpClientConfig.httpClientConfig().setParam("http.connection.timeout", 10000).setParam("http.socket.timeout", 10000));
    }

    public static void fillRequestConfigs(RequestConfigs requestConfigs, RequestSpecification requestSpecification, Map<String, Object> formParams) {
        if (requestConfigs.getUrlEncoding() != null && requestConfigs.getUrlEncoding()) {
            requestSpecification.urlEncodingEnabled(requestConfigs.getUrlEncoding());
        }

        if (requestConfigs.getAutoRedirection() != null) {
            requestSpecification = requestSpecification.redirects().follow(requestConfigs.getAutoRedirection());
        }

        if (requestConfigs.getUserName() != null) {
            requestSpecification = requestSpecification.auth().preemptive().basic(requestConfigs.getUserName(), requestConfigs.getPassWord());
        }

        if (requestConfigs.getTimeout() != null) {
            RestAssuredConfig config = RestAssured.config().httpClient(HttpClientConfig.httpClientConfig().setParam("http.connection.timeout", requestConfigs.getTimeout()).setParam("http.socket.timeout", requestConfigs.getTimeout()));
            requestSpecification.config(config);
        }

        if (requestConfigs.getFormParams() != null) {
            formParams = requestConfigs.getFormParams();
        }

    }

    public static RequestSpecification getRequestSpecification(Filter filter, RequestConfigs requestConfigs) {
        RestAssuredConfig config = getDefaultConfig();
        if (filter != null) {
            return requestConfigs.isLogsNeeded() ? RestAssured.given().config(config).filter(filter).log().all() : RestAssured.given().filter(filter).config(config);
        } else {
            return requestConfigs.isLogsNeeded() ? RestAssured.given().config(config).log().all() : RestAssured.given().config(config);
        }
    }

    public static ExtractableResponse<Response> callPostApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody, RequestConfigs requestConfigs, int retry) {
        ExtractableResponse<Response> response = null;

        while (retry >= 0) {
            try {
                response = getResponse(HTTPRequestType.POST, headerMap, params, requestURL, requestBody, requestConfigs);
                break;
            } catch (AssertionError var8) {
                logger.error(var8.getMessage());
                if (retry == 0) {
                    throw var8;
                }

                --retry;
            }
        }

        return response;
    }

    public static ExtractableResponse<Response> callPutApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody, RequestConfigs requestConfigs, int retry) {
        ExtractableResponse<Response> response = null;

        while (retry >= 0) {
            try {
                response = getResponse(HTTPRequestType.PUT, headerMap, params, requestURL, requestBody, requestConfigs);
                break;
            } catch (AssertionError var8) {
                logger.error(var8.getMessage());
                if (retry == 0) {
                    throw var8;
                }

                --retry;
            }
        }

        return response;
    }

    public static ExtractableResponse<Response> callPatchApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody, RequestConfigs requestConfigs, int retry) {
        ExtractableResponse<Response> response = null;

        while (retry >= 0) {
            try {
                response = getResponse(HTTPRequestType.PATCH, headerMap, params, requestURL, requestBody, requestConfigs);
                break;
            } catch (AssertionError var8) {
                logger.error(var8.getMessage());
                if (retry == 0) {
                    throw var8;
                }

                --retry;
            }
        }

        return response;
    }

    public static ExtractableResponse<Response> callGetApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, RequestConfigs requestConfigs, int retry) {
        ExtractableResponse<Response> response = null;

        while (retry >= 0) {
            try {
                response = getResponse(HTTPRequestType.GET, headerMap, params, requestURL, null, requestConfigs);
                break;
            } catch (AssertionError var7) {
                logger.error(var7.getMessage());
                if (retry == 0) {
                    throw var7;
                }

                --retry;
            }
        }

        return response;
    }

    public static ExtractableResponse<Response> callDeleteApi(Map<String, String> headerMap, String requestURL, RequestConfigs requestConfigs, int retry) {
        ExtractableResponse<Response> response = null;

        while (retry >= 0) {
            try {
                response = getResponse(HTTPRequestType.DELETE, headerMap, null, requestURL, null, requestConfigs);
                break;
            } catch (AssertionError var6) {
                logger.error(var6.getMessage());
                if (retry == 0) {
                    throw var6;
                }

                --retry;
            }
        }

        return response;
    }

    public static String getRequestBody(Object requestBody) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.convertValue(requestBody, JsonNode.class);
        return objectMapper.writeValueAsString(jsonNode);
    }

    public static ExtractableResponse<Response> callPostApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody, RequestConfigs requestConfigs) {
        return getResponse(HTTPRequestType.POST, headerMap, params, requestURL, requestBody, requestConfigs);
    }

    public static ExtractableResponse<Response> callPutApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody, RequestConfigs requestConfigs) {
        return getResponse(HTTPRequestType.PUT, headerMap, params, requestURL, requestBody, requestConfigs);
    }

    public static ExtractableResponse<Response> callPatchApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody, RequestConfigs requestConfigs) {
        return getResponse(HTTPRequestType.PATCH, headerMap, params, requestURL, requestBody, requestConfigs);
    }

    public static ExtractableResponse<Response> callGetApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, RequestConfigs requestConfigs) {
        return getResponse(HTTPRequestType.GET, headerMap, params, requestURL, null, requestConfigs);
    }

    public static ExtractableResponse<Response> callDeleteApi(Map<String, String> headerMap, String requestURL, RequestConfigs requestConfigs) {
        return getResponse(HTTPRequestType.DELETE, headerMap, null, requestURL, null, requestConfigs);
    }

    public static ExtractableResponse<Response> callDeleteApi(Map<String, String> headerMap, String requestURL, Object requestBody, RequestConfigs requestConfigs) {
        return getResponse(HTTPRequestType.DELETE, headerMap, null, requestURL, requestBody, requestConfigs);
    }

    public static ExtractableResponse<Response> callPostApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody) {
        return getResponse(HTTPRequestType.POST, headerMap, params, requestURL, requestBody, null);
    }

    public static ExtractableResponse<Response> callPutApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody) {
        return getResponse(HTTPRequestType.PUT, headerMap, params, requestURL, requestBody, null);
    }

    public static ExtractableResponse<Response> callPatchApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody) {
        return getResponse(HTTPRequestType.PATCH, headerMap, params, requestURL, requestBody, null);
    }

    public static ExtractableResponse<Response> callGetApi(Map<String, String> headerMap, Map<String, String> params, String requestURL) {
        return getResponse(HTTPRequestType.GET, headerMap, params, requestURL, null, null);
    }

    public static ExtractableResponse<Response> callDeleteApi(Map<String, String> headerMap, String requestURL) {
        return getResponse(HTTPRequestType.DELETE, headerMap, null, requestURL, null, null);
    }

    public static ExtractableResponse<Response> callDeleteApi(Map<String, String> headerMap, String requestURL, Object requestBody) {
        return getResponse(HTTPRequestType.DELETE, headerMap, null, requestURL, requestBody, null);
    }

    public static ExtractableResponse<Response> callGetApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody) {
        return getResponse(HTTPRequestType.GET, headerMap, params, requestURL, requestBody, null);
    }

    public static ExtractableResponse<Response> callGetApi(Map<String, String> headerMap, Map<String, String> params, String requestURL, Object requestBody, RequestConfigs requestConfigs) {
        return getResponse(HTTPRequestType.GET, headerMap, params, requestURL, requestBody, requestConfigs);
    }





    protected enum HTTPRequestType {
        GET,
        POST,
        DELETE,
        PUT,
        PATCH;

        HTTPRequestType() {
        }
    }
}


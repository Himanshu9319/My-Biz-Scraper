package UtilsAPI.helper;

import utilities.Base;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HeaderConstant {
    public static Map<String, String> getDefaultHeader() {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept", "*/*");
        header.put("content-type","application/json;charset=UTF-8");
        //header.put("content-type","application/json");
        return header;
    }






    public static Map<String, String> getAccessTokenHeader(String token) {
        Map<String, String> header = new HashMap<String, String>();
        header.put("content-type", "application/json");
        header.put("token", token);
        return header;
    }

    public static Map<String, String> getHeadersWithToken(String token) {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        header.put("Authorization", token);
        header.put("country", Base.property.getProperty("countryCode"));
        return header;
    }

    public static Map<String, String> getHeadersWithTokenandHubList(String token ,String hubList) {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        header.put("Authorization", token);
        header.put("hublist",hubList);
        header.put("country", Base.property.getProperty("countryCode"));
        return header;
    }

    public static Map<String,String> getQueryParams(String key,String value){
        Map<String, String> queryParam = new HashMap<>();
        queryParam.put(key,value);
        return queryParam;
    }
    public static Map<String,String> pathParams(String key,String value) {
        Map<String, String> pathParam = new HashMap<>();
        pathParam.put(key, value);
        return pathParam;
    }
    public static Map<String, String> getPostHeaders_DRIVER_AppVersion_Platform(String access_token, String appVersion, String platform) {
        Map<String, String> header = new HashMap<>();
        header.put("Accept", "*/*");
        header.put("Content-Type", "application/json");
        header.put("Authorization", "Bearer " + access_token);
        header.put("appVersion", appVersion);
        header.put("platform", platform);
        header.put("country", Base.property.getProperty("countryCode"));
        return header;
    }

    public static Map<String, String> getPostHeaders_DIPATCH_Platform(String access_token, String serviceregionid, String zoneids) {
        Map<String, String> header = new HashMap<>();
        header.put("Accept", "*/*");
        header.put("Content-Type", "application/json");
        header.put("Authorization", "Bearer " + access_token);
        header.put("serviceregionid", serviceregionid);
        header.put("zoneids", zoneids);
        header.put("country", Base.property.getProperty("countryCode"));
        return header;
    }

    public static Map<String, String> setAndGetHeaders(String... headerValuePairs) {
        Map<String, String> headerMap = new HashMap<>();

        if (headerValuePairs.length % 2 != 0) {
            throw new IllegalArgumentException("Each header must have a corresponding value.");
        }

        for (int i = 0; i < headerValuePairs.length; i += 2) {
            String header = headerValuePairs[i];
            String value = headerValuePairs[i + 1];
            headerMap.put(header, value);
        }
        headerMap.put("country", Base.property.getProperty("countryCode"));
        return headerMap;
    }

    public static Map<String, String> setAndGetParm(String... paramValuePairs) {
        Map<String, String> paramMap = new HashMap<>();
        if (paramValuePairs.length % 2 != 0) {
            throw new IllegalArgumentException("Each header must have a corresponding value.");
        }

        for (int i = 0; i < paramValuePairs.length; i += 2) {
            String header = paramValuePairs[i];
            String value = paramValuePairs[i + 1];
            paramMap.put(header, value);
        }
        return paramMap;

    }
    public static Map<String, String> setAndGetParms(String... paramValuePairs) {
        Map<String, String> paramMap = new HashMap<>();
        if (paramValuePairs.length % 2 != 0) {
            throw new IllegalArgumentException("Each header must have a corresponding value.");
        }

        for (int i = 0; i < paramValuePairs.length; i += 2) {
            String header = paramValuePairs[i];
            String value = paramValuePairs[i + 1];
            try {
                paramMap.put(URLEncoder.encode(header, StandardCharsets.UTF_8.toString()), URLEncoder.encode(value, StandardCharsets.UTF_8.toString()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
          //  paramMap.put(header, value);
        }
        return paramMap;

    }

    public static String buildUrlWithQueryParameters(String path, Map<String, String> queryParams) {
        StringBuilder url = new StringBuilder(path + "?");
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            try {
                String key = URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8.toString());
                String value = URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8.toString());
                url.append(key).append("=").append(value).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        // Remove the trailing '&' character
        url.deleteCharAt(url.length() - 1);
        return url.toString();
    }
    public static Map<String, String> getContentTypeHeader()
    {
        Map<String, String>  header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("country", Base.property.getProperty("countryCode"));
        return header;
    }


}

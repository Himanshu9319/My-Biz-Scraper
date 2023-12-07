package UtilsAPI.helper;

public class ReqConfig {
    public static RequestConfigs getDefaultRequest() {
        RequestConfigs requestConfigs = new RequestConfigs();
        requestConfigs.setTimeout(50000);
        return requestConfigs;
    }

}

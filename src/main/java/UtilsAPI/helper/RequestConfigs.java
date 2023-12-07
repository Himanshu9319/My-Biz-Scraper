package UtilsAPI.helper;

import java.util.HashMap;
import java.util.Map;

public class RequestConfigs {
    private String userName;
    private String passWord;
    private Integer timeout;
    private Boolean autoRedirection;
    private Boolean urlEncoding;
    private Map<String, Object> formParams = new HashMap();
    private boolean logsNeeded = true;

    public RequestConfigs() {
    }

    public boolean isLogsNeeded() {
        return this.logsNeeded;
    }

    public void setLogsNeeded(boolean logsNeeded) {
        this.logsNeeded = logsNeeded;
    }

    public Map<String, Object> getFormParams() {
        return this.formParams;
    }

    public void setFormParams(Map<String, Object> formParams) {
        this.formParams = formParams;
    }

    public Boolean getAutoRedirection() {
        return this.autoRedirection;
    }

    public void setAutoRedirection(Boolean autoRedirection) {
        this.autoRedirection = autoRedirection;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getTimeout() {
        return this.timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Boolean getUrlEncoding() {
        return this.urlEncoding;
    }

    public void setUrlEncoding(Boolean urlEncoding) {
        this.urlEncoding = urlEncoding;
    }
}

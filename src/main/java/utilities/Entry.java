package utilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entry {

    @SerializedName("startedDateTime")
    @Expose
    private String startedDateTime;
    @SerializedName("time")
    @Expose
    private int time;    @SerializedName("serverIPAddress")
    @Expose
    private String serverIPAddress;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Entry() {
    }

    /**
     *
     * @param time
     * @param serverIPAddress
     * @param startedDateTime
     */
    public Entry(String startedDateTime, int time,  String serverIPAddress) {
        super();
        this.startedDateTime = startedDateTime;
        this.time = time;

        this.serverIPAddress = serverIPAddress;
    }

    public String getStartedDateTime() {
        return startedDateTime;
    }

    public void setStartedDateTime(String startedDateTime) {
        this.startedDateTime = startedDateTime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public String getServerIPAddress() {
        return serverIPAddress;
    }

    public void setServerIPAddress(String serverIPAddress) {
        this.serverIPAddress = serverIPAddress;
    }


}

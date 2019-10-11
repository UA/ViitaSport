package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceCommand {

    @SerializedName("deviceId")
    @Expose
    public String deviceId = "0";
    @SerializedName("deviceType")
    @Expose
    public String deviceType = "Android";
    @SerializedName("osVersion")
    @Expose
    public String osVersion = "7.0";
    @SerializedName("appVersion")
    @Expose
    public String appVersion = "1.0.0";
    @SerializedName("model")
    @Expose
    public String model = "Mi 3";
    @SerializedName("language")
    @Expose
    public String language = "tr-tr";
}

package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Settings {

    @SerializedName("accountSettings")
    @Expose
    public AccountSettings accountSettings;
    @SerializedName("alarmSettings")
    @Expose
    public AlarmSettings alarmSettings;
    @SerializedName("userSettings")
    @Expose
    public UserSettings userSettings;
    @SerializedName("watchSettings")
    @Expose
    public WatchSettings watchSettings;

}
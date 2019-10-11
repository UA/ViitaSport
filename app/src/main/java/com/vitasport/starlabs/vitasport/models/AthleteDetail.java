package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AthleteDetail {
    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("device")
    @Expose
    public Device device;
    @SerializedName("settings")
    @Expose
    public Settings settings;





}



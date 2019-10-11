package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlarmSettings {

    @SerializedName("alarmEnabled")
    @Expose
    public Boolean alarmEnabled;
    @SerializedName("smartAlarmEnabled")
    @Expose
    public Boolean smartAlarmEnabled;
    @SerializedName("mondayEnabled")
    @Expose
    public Boolean mondayEnabled;
    @SerializedName("mondayTime")
    @Expose
    public String mondayTime;
    @SerializedName("tuesdayEnabled")
    @Expose
    public Boolean tuesdayEnabled;
    @SerializedName("tuesdayTime")
    @Expose
    public String tuesdayTime;
    @SerializedName("wednesdayEnabled")
    @Expose
    public Boolean wednesdayEnabled;
    @SerializedName("wednesdayTime")
    @Expose
    public String wednesdayTime;
    @SerializedName("thursdayEnabled")
    @Expose
    public Boolean thursdayEnabled;
    @SerializedName("thursdayTime")
    @Expose
    public String thursdayTime;
    @SerializedName("fridayEnabled")
    @Expose
    public Boolean fridayEnabled;
    @SerializedName("fridayTime")
    @Expose
    public String fridayTime;
    @SerializedName("saturdayEnabled")
    @Expose
    public Boolean saturdayEnabled;
    @SerializedName("saturdayTime")
    @Expose
    public String saturdayTime;
    @SerializedName("sundayEnabled")
    @Expose
    public Boolean sundayEnabled;
    @SerializedName("sundayTime")
    @Expose
    public String sundayTime;

}

package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WatchSettings {

    @SerializedName("notificationsEnabled")
    @Expose
    public Boolean notificationsEnabled;
    @SerializedName("notificationsActivityEnabled")
    @Expose
    public Boolean notificationsActivityEnabled;
    @SerializedName("notificationTimeEnabled")
    @Expose
    public Boolean notificationTimeEnabled;
    @SerializedName("notificationTimeStart")
    @Expose
    public String notificationTimeStart;
    @SerializedName("notificationTimeEnd")
    @Expose
    public String notificationTimeEnd;
    @SerializedName("notificationTypes")
    @Expose
    public NotificationTypes notificationTypes;
    @SerializedName("timeFormat")
    @Expose
    public String timeFormat;
    @SerializedName("autoScreenEnabled")
    @Expose
    public Boolean autoScreenEnabled;
    @SerializedName("flowHrvEnabled")
    @Expose
    public Boolean flowHrvEnabled;
    @SerializedName("favoriteActivities")
    @Expose
    public List<String> favoriteActivities = null;
    @SerializedName("favoriteHomeScreen")
    @Expose
    public String favoriteHomeScreen;
    @SerializedName("favoriteScreenDesign")
    @Expose
    public String favoriteScreenDesign;
    @SerializedName("activitySetBreak")
    @Expose
    public Integer activitySetBreak;
    @SerializedName("activitySetExercise")
    @Expose
    public Integer activitySetExercise;

}

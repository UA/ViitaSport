package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationTypes {

    @SerializedName("incomingCall")
    @Expose
    public Boolean incomingCall;
    @SerializedName("textMessage")
    @Expose
    public Boolean textMessage;
    @SerializedName("whatsapp")
    @Expose
    public Boolean whatsapp;
    @SerializedName("email")
    @Expose
    public Boolean email;
    @SerializedName("skype")
    @Expose
    public Boolean skype;
    @SerializedName("calendar")
    @Expose
    public Boolean calendar;
    @SerializedName("facebook")
    @Expose
    public Boolean facebook;
    @SerializedName("facebookMessenger")
    @Expose
    public Boolean facebookMessenger;
    @SerializedName("snapchat")
    @Expose
    public Boolean snapchat;
    @SerializedName("wechat")
    @Expose
    public Boolean wechat;
    @SerializedName("qq")
    @Expose
    public Boolean qq;

}

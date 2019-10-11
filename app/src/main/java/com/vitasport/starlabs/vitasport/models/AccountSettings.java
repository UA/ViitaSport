package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountSettings {

    @SerializedName("displayedUnits")
    @Expose
    public String displayedUnits;
    @SerializedName("newsletterEnabled")
    @Expose
    public Boolean newsletterEnabled;

}

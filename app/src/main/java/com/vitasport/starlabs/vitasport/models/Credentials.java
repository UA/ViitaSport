package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Credentials {
    @SerializedName("identifier")
    @Expose
    public String identifier;
    @SerializedName("password")
    @Expose
    public String password = "12345678";

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

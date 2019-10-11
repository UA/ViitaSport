package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("verified")
    @Expose
    public Boolean verified;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("avatarUrl")
    @Expose
    public Object avatarUrl;

}

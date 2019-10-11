package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AthletesModel {

    @SerializedName("credentials")
    @Expose
    public Credentials credentials = new Credentials();
    @SerializedName("deviceCommand")
    @Expose
    public DeviceCommand deviceCommand = new DeviceCommand();

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setDeviceCommand(DeviceCommand deviceCommand) {
        this.deviceCommand = deviceCommand;
    }


    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWatchid() {
        return watchid;
    }

    public void setWatchid(String watchid) {
        this.watchid = watchid;
    }

    public String identifier;
    public String password;
    private String watchid;

}

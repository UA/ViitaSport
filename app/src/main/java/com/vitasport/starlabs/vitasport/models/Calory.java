package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Calory {

    @SerializedName("watchId")
    @Expose
    public Integer watchId;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("values")
    @Expose
    public List<Integer> values = null;

    public String getDate() {
        return date;
    }

    public List<Integer> getValues() {
        return values;
    }
}
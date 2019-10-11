package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ViitaApi {

    @SerializedName("calories")
    @Expose
    public List<Calory> calories = null;
    @SerializedName("regeneration")
    @Expose
    public List<Regeneration> regeneration = null;
    @SerializedName("steps")
    @Expose
    public List<Step> steps = null;
    @SerializedName("stress")
    @Expose
    public List<Stress> stress = null;
}
package com.vitasport.starlabs.vitasport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserSettings {

    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("dateOfBirth")
    @Expose
    public String dateOfBirth;
    @SerializedName("weight")
    @Expose
    public Integer weight;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("userMission")
    @Expose
    public String userMission;
    @SerializedName("sleepGoalStart")
    @Expose
    public String sleepGoalStart;
    @SerializedName("sleepGoalEnd")
    @Expose
    public String sleepGoalEnd;
    @SerializedName("stepsGoal")
    @Expose
    public Integer stepsGoal;
    @SerializedName("caloriesGoal")
    @Expose
    public Integer caloriesGoal;

}

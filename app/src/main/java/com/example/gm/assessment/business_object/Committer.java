package com.example.gm.assessment.business_object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Committer {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("date")
    @Expose
    public String date;

}
package com.example.gm.assessment.business_object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommitsResponse {

    @SerializedName("sha")
    @Expose
    public String sha;

    @SerializedName("commit")
    @Expose
    public Commit commit;
}
package com.example.gm.assessment.business_object;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Commit {
    
    @SerializedName("committer")
    @Expose
    public Committer committer;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("comment_count")
    @Expose
    public Integer commentCount;
}
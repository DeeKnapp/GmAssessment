package com.example.gm.assessment.business_object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommitsResponse {

    @SerializedName("sha")
    @Expose
    public String sha;
    @SerializedName("node_id")
    @Expose
    public String nodeId;
    @SerializedName("commit")
    @Expose
    public Commit commit;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("html_url")
    @Expose
    public String htmlUrl;
    @SerializedName("comments_url")
    @Expose
    public String commentsUrl;
}
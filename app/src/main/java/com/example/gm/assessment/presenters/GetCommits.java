package com.example.gm.assessment.presenters;

import com.example.gm.assessment.business_object.CommitsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCommits {

    @GET("/repos/square/retrofit/commits")
    Call<CommitsResponse[]> getRetrofitCommits();
}

package com.example.gm.assessment.presenters;


import android.util.Log;

import com.example.gm.assessment.business_object.CommitsResponse;
import com.example.gm.assessment.networking.RetrofitBuilder;
import com.example.gm.assessment.reactive_views.GitCommitsReactiveView;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitCommitsPresenter implements Callback<CommitsResponse[]> {

    private static final String TAG = "GitCommitsPresenter";

    GitCommitsReactiveView reactiveView;

    @Inject
    GitCommitsPresenter() {
    }

    public void setView(GitCommitsReactiveView view) {
        this.reactiveView = view;
    }

    public void getRecentCommits() {
        RetrofitBuilder.getRetrofitClient().create(GetCommits.class).getRetrofitCommits().enqueue(this);
    }

    @Override
    public void onResponse(Call<CommitsResponse[]> call, Response<CommitsResponse[]> response) {
        Log.d(TAG, response.raw().toString());
        reactiveView.onSuccess(response.body());
    }

    @Override
    public void onFailure(Call<CommitsResponse[]> call, Throwable t) {
        Log.d(TAG, t.getMessage());
        reactiveView.onFailure();
    }
}

package com.example.gm.assessment.reactive_views;

import com.example.gm.assessment.business_object.CommitsResponse;

public interface GitCommitsReactiveView {

    void onSuccess(CommitsResponse[] commits);

    void onFailure();

}

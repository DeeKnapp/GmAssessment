package com.example.gm.assessment.reactive_views;

import com.example.gm.assessment.business_object.Commit;

public interface GitCommitsReactiveView {

    void getCommitsSuccess(Commit[] commits);

    void getCommitsFailure();

}

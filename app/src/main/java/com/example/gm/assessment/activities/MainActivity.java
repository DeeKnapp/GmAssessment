package com.example.gm.assessment.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.gm.assessment.MyApplication;
import com.example.gm.assessment.R;
import com.example.gm.assessment.adapters.CommitListAdapter;
import com.example.gm.assessment.business_object.CommitsResponse;
import com.example.gm.assessment.presenters.GitCommitsPresenter;
import com.example.gm.assessment.reactive_views.GitCommitsReactiveView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements GitCommitsReactiveView {

    @Inject
    GitCommitsPresenter presenter;
    @Inject
    CommitListAdapter adapter;

    RecyclerView commitsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.activity_main);

        adapter.setContext(this);

        commitsList = findViewById(R.id.commitsList);
        commitsList.setAdapter(adapter);
        commitsList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        presenter.setView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getRecentCommits();
    }

    @Override
    public void onSuccess(CommitsResponse[] commits) {
        adapter.setCommits(commits);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure() {
        Toast.makeText(this, "Oops! Something went wrong!", Toast.LENGTH_SHORT).show();
    }
}

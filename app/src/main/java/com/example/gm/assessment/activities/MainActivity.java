package com.example.gm.assessment.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

        commitsList = findViewById(R.id.commitsList);
        commitsList.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        commitsList.setLayoutManager(layoutManager);

        presenter.setView(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getRecentCommits();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSuccess(CommitsResponse[] commits) {
        adapter.setCommits(commits);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void pnFailure() {
        Toast.makeText(this, "Oops! Something went wrong!", Toast.LENGTH_SHORT).show();
    }
}

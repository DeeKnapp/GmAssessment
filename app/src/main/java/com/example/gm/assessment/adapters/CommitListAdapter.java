package com.example.gm.assessment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gm.assessment.R;
import com.example.gm.assessment.business_object.CommitsResponse;

import javax.inject.Inject;

public class CommitListAdapter extends RecyclerView.Adapter<CommitListAdapter.CommitViewHolder> {

    private CommitsResponse[] commits;

    @Inject
    public CommitListAdapter() {
    }

    public CommitsResponse[] getCommits() {
        return commits;
    }

    public void setCommits(CommitsResponse[] commits) {
        this.commits = commits;
    }

    @NonNull
    @Override
    public CommitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CommitViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.commit_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommitViewHolder commitViewHolder, int i) {
        CommitsResponse commitsResponse = commits[i];
        commitViewHolder.name.setText("Author's name: " + commitsResponse.commit.committer.name);
        commitViewHolder.commitHash.setText("Commit: " + commitsResponse.sha);
        commitViewHolder.commitMessage.setText("Commit Message: " + commitsResponse.commit.message);

    }

    @Override
    public int getItemCount() {
        if (commits != null) {
            return commits.length;
        }
        return 0;
    }


    static class CommitViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView commitHash;
        TextView commitMessage;

        CommitViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.authorName);
            commitHash = view.findViewById(R.id.commitHash);
            commitMessage = view.findViewById(R.id.commitMessage);

        }
    }

}


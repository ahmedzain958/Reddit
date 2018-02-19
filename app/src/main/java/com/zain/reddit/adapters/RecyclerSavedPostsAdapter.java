package com.zain.reddit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zain.reddit.R;
import com.zain.reddit.models.saved_posts.Child;

import java.util.List;

/**
 * Created by Zain on 29/01/2018.
 */

public class RecyclerSavedPostsAdapter extends RecyclerView.Adapter<RecyclerSavedPostsAdapter.MyViewHolder> {

    private List<Child> dataSet;
    Context mContext;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, subreddit_name_prefixed, domain, num_comments;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.subreddit_name_prefixed = itemView.findViewById(R.id.subreddit_name_prefixed);
            this.domain = itemView.findViewById(R.id.domain);
            this.num_comments = itemView.findViewById(R.id.num_of_comments);
        }
    }

    public RecyclerSavedPostsAdapter(Context mContext, List<Child> data) {
        this.dataSet = data;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.saved_posts_cardview, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {


        TextView title = holder.title;
        TextView subreddit_name_prefixed = holder.subreddit_name_prefixed;
        TextView domain = holder.domain;
        TextView num_comments = holder.num_comments;

        if (dataSet != null && dataSet.size() > 0) {
            com.zain.reddit.models.saved_posts.Child child_ = dataSet.get(listPosition);
            com.zain.reddit.models.saved_posts.Data_ data_ = child_.getData();
            if (data_ != null) {
                title.setText(data_.getTitle());
                subreddit_name_prefixed.setText(data_.getSubredditNamePrefixed());
                domain.setText(data_.getDomain());
            }
        }

    }

    public void clear() {
        if (dataSet != null)
            dataSet.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<com.zain.reddit.models.saved_posts.Child> list) {
        dataSet.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (dataSet != null)
            if (dataSet.size() > 0)
                return dataSet.size();
        return 0;
    }
}

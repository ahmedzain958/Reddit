package com.zain.reddit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zain.reddit.R;

import java.util.List;

/**
 * Created by Zain on 29/01/2018.
 */

public class RecyclerUserCommentsAdapter extends RecyclerView.Adapter<RecyclerUserCommentsAdapter.MyViewHolder> {

    private List<com.zain.reddit.models.user_comments.Child> dataSet;
    Context mContext;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView link_title, subreddit_name_prefixed, body;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.link_title = itemView.findViewById(R.id.link_title);
            this.subreddit_name_prefixed = itemView.findViewById(R.id.subreddit_name_prefixed);
            this.body = itemView.findViewById(R.id.body);
        }
    }

    public RecyclerUserCommentsAdapter(Context mContext, List<com.zain.reddit.models.user_comments.Child> data) {
        this.dataSet = data;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_comment_cardview, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView link_title = holder.link_title;
        TextView subreddit_name_prefixed = holder.subreddit_name_prefixed;
        TextView body = holder.body;

        if (dataSet != null && dataSet.size() > 0) {
            com.zain.reddit.models.user_comments.Child child_ = dataSet.get(listPosition);
            com.zain.reddit.models.user_comments.Data_ data_ = child_.getData();
            if (data_ != null) {
                link_title.setText(data_.getLinkTitle());
                subreddit_name_prefixed.setText(data_.getSubredditNamePrefixed());
                body.setText(data_.getBody());
            }
        }

    }

    public void clear() {
        if (dataSet != null)
            dataSet.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<com.zain.reddit.models.user_comments.Child> list) {
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

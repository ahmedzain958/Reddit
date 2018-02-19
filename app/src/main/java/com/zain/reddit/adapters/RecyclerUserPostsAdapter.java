package com.zain.reddit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zain.reddit.R;
import com.zain.reddit.models.user_posts.Child;
import com.zain.reddit.models.user_posts.Data_;

import java.util.List;

/**
 * Created by Zain on 29/01/2018.
 */

public class RecyclerUserPostsAdapter extends RecyclerView.Adapter<RecyclerUserPostsAdapter.MyViewHolder> {
    private List<Child> dataSet;
    Context mContext;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView subreddit, title;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            this.subreddit = itemView.findViewById(R.id.user_username);
            this.title = itemView.findViewById(R.id.user_title);
        }

        @Override
        public void onClick(View v) {
        }
    }

    public RecyclerUserPostsAdapter(Context mContext, List<Child> data) {
        this.dataSet = data;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_post_cardview, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView subreddit = holder.subreddit;
        TextView title = holder.title;

        if (dataSet != null && dataSet.size() > 0) {
            Child child_ = dataSet.get(listPosition);
            Data_ data_ = child_.getData();
            if (data_ != null) {
                subreddit.setText(data_.getSubredditNamePrefixed());
                title.setText(data_.getTitle());

            }
        }

    }

    public void clear() {
        if (dataSet != null)
            dataSet.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Child> list) {
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

package com.zain.reddit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zain.reddit.R;
import com.zain.reddit.models.post_details.Child;
import com.zain.reddit.models.post_details.Data_;

import java.util.List;

/**
 * Created by Zain on 29/01/2018.
 */

public class RecyclerPostCommentsAdapter extends RecyclerView.Adapter<RecyclerPostCommentsAdapter.MyViewHolder> {
    private List<Child> dataSet;
    Context mContext;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView author, body;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.author = itemView.findViewById(R.id.author);
            this.body = itemView.findViewById(R.id.body);
        }
    }

    public RecyclerPostCommentsAdapter(Context mContext, List<Child> data) {
        this.dataSet = data;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_comments_detail, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView body = holder.body;
        TextView author = holder.author;

        if (dataSet != null && dataSet.size() > 0) {
            Child child_ = dataSet.get(listPosition);
            Data_ data_ = child_.getData();
            if (data_ != null) {
                body.setText(data_.getSubredditNamePrefixed());
                author.setText(data_.getAuthor());

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

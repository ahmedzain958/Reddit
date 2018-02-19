package com.zain.reddit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zain.reddit.R;
import com.zain.reddit.models.posts.Child;
import com.zain.reddit.models.posts.Data_;

import java.util.List;

import static com.zain.reddit.util.HelpMethods.format;

/**
 * Created by Zain on 29/01/2018.
 */

public class RecyclerPostsAdapter extends RecyclerView.Adapter<RecyclerPostsAdapter.MyViewHolder> {

    static List<Child> dataSet;
    static Context mContext;
    Listener listener;


    public RecyclerPostsAdapter(Context mContext, List<Child> data, Listener listener) {
        this.dataSet = data;
        this.mContext = mContext;
        this.listener = listener;
    }

    public interface Listener {
        void onItemClicked(Child child);

        void onLongClick(Child child);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView subredditPrefixed, domain, title, ups, num_comments, author, upVote;
        ImageView img_Post;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.subredditPrefixed = itemView.findViewById(R.id.subredditPrefixed);
            this.domain = itemView.findViewById(R.id.domain);
            this.title = itemView.findViewById(R.id.title);
            this.ups = itemView.findViewById(R.id.ups);
            this.num_comments = itemView.findViewById(R.id.num_comments);
            this.author = itemView.findViewById(R.id.author);
            this.img_Post = itemView.findViewById(R.id.img_Post);
            this.upVote = itemView.findViewById(R.id.upVote);
        }

        public void bind(final Child child, final Listener listener) {
            if (child != null) {
                Data_ data_ = child.getData();
                if (data_ != null) {
                    subredditPrefixed.setText(data_.getSubredditNamePrefixed());
                    author.setText("u/" + data_.getAuthor());
                    domain.setText(data_.getDomain());
                    title.setText(data_.getTitle());
                    ups.setText(format(data_.getUps()));
                    num_comments.setText(String.valueOf(data_.getNumComments()));
                    Picasso.with(mContext).load(data_.getThumbnail()).into(img_Post);

                }
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (child != null && listener != null)
                        listener.onItemClicked(child);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (child != null&& listener != null)
                        listener.onLongClick(child);
                    return false;
                }
            });
        }

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_cardview, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

       /* TextView subredditPrefixed = holder.subredditPrefixed;
        TextView author = holder.author;
        TextView domain = holder.domain;
        TextView title = holder.title;
        TextView ups = holder.ups;
        TextView num_comments = holder.num_comments;
        ImageView img_Post = holder.img_Post;*/


        holder.bind(dataSet.get(listPosition), listener);
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

package com.zain.reddit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.zain.reddit.R;
import com.zain.reddit.models.post_details.Child;
import com.zain.reddit.models.post_details.Data_;

import java.util.List;

/**
 * Created by Zain on 10/02/2018.
 */

public class PostCommentsDetailsAdapter extends ArrayAdapter {

    private final LayoutInflater inflater;
    List<Child> children;

    public PostCommentsDetailsAdapter(Context context, List<Child> children) {
        super(context, 0, children);
        this.children = children;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.post_comments_detail, parent, false);
            holder = new ViewHolder();
            holder.author = convertView.findViewById(R.id.author);
            holder.body = convertView.findViewById(R.id.body);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (children != null) {
            if (children.get(position) != null) {
                Data_ data = children.get(position).getData();
                if (data != null) {
                    holder.body.setText(data.getBody());
                    holder.author.setText(data.getAuthor());
                }
                // set the name to the text;
            }
        } else {
            holder.body.setText("-");
            holder.author.setText("-");
        }
        return convertView;

    }

    static class ViewHolder {

        TextView author;
        TextView body;
    }
}


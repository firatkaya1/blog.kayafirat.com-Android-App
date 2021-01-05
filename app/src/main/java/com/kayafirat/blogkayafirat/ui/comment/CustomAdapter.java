package com.kayafirat.blogkayafirat.ui.comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    LayoutInflater inflter;
    ArrayList<Comment> comments;

    public CustomAdapter(Context applicationContext, ArrayList<Comment> comments) {
        this.comments = comments;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int i) {
        return comments.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Long.valueOf(comments.get(i).getCommentId());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.item_comment, null);
        TextView commentDetail = view.findViewById(R.id.commentDetail);
        TextView commentDate = view.findViewById(R.id.commentDate);
        TextView commentUsername = view.findViewById(R.id.commentUsername);

        commentDetail.setText(comments.get(i).getCommentBody());
        commentDate.setText(comments.get(i).getCommentDate());
        commentUsername.setText(comments.get(i).getUserName());

        return view;
    }


}

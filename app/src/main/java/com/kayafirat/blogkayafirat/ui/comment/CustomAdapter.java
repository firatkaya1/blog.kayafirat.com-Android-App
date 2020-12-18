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
    HashMap<String,String>comments;

    public CustomAdapter(Context applicationContext, HashMap<String,String> comments) {
        this.comments = comments;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.item_comment, null);
        TextView commentDetail = view.findViewById(R.id.commentDetail);
        TextView commentDate = view.findViewById(R.id.commentDate);
        TextView commentUsername = view.findViewById(R.id.commentUsername);
        System.out.println(comments);
    /*    commentDetail.setText(comments.get(0).getCommentBody());
        commentDate.setText(comments.get(0).getCommentDate());
        commentUsername.setText(comments.get(0).getUserName());*/
        return view;
    }


}

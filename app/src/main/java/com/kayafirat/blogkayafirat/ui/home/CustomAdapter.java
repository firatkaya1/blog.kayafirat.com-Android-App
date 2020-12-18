package com.kayafirat.blogkayafirat.ui.home;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.Post;
import com.kayafirat.blogkayafirat.service.IPostService;
import com.kayafirat.blogkayafirat.service.impl.PostService;

import java.util.List;


public class CustomAdapter extends BaseAdapter {

    LayoutInflater inflater;
    List<Post> postList;


    public CustomAdapter(Context applicationContext, List<Post> _postList) {
        inflater = (LayoutInflater.from(applicationContext));
        this.postList = _postList;
    }
    @Override
    public int getCount() {
        return postList.size();
    }


    @Override
    public Post getItem(int i) {
        return postList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Long.parseLong(postList.get(i).getPostId());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_postlistviewitem, null);
        TextView postTitle = view.findViewById(R.id.postTitle);
        TextView postHeader = view.findViewById(R.id.postHeader);
        TextView postView = view.findViewById(R.id.postView);

        postTitle.setText(postList.get(i).getPostTitle());
        postHeader.setText(postList.get(i).getPostHeader());
        postView.setText(postList.get(i).getPostRegisterDate());
        return view;

    }


}

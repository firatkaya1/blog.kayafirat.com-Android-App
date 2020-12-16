package com.kayafirat.blogkayafirat.ui.post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kayafirat.blogkayafirat.R;

public class CustomAdapter extends BaseAdapter {
    LayoutInflater inflter;
    String testList[];

    public CustomAdapter(Context applicationContext, String[] testList) {
        this.testList = testList;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return testList.length;
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
        commentDetail.setText(testList[i]);
        return view;
    }


}

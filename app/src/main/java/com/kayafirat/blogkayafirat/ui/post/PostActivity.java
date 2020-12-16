package com.kayafirat.blogkayafirat.ui.post;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kayafirat.blogkayafirat.R;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ListView commentListView = findViewById(R.id.commentListView);
        String testList[] = {
                "India", "China", "australia", "Portugle", "America", "NewZealand",
                "India", "China", "australia", "Portugle", "America", "NewZealand",
                "India", "China", "australia", "Portugle", "America", "NewZealand",
                "India", "China", "australia", "Portugle", "America", "NewZealand",
                "India", "China", "australia", "Portugle", "America", "NewZealand",
                "India", "China", "australia", "Portugle", "America", "NewZealand"};
        com.kayafirat.blogkayafirat.ui.post.CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), testList);
        commentListView.setAdapter(customAdapter);
    }
}

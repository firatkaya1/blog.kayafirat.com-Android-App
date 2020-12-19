package com.kayafirat.blogkayafirat.ui.comment;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.Comment;

import java.util.ArrayList;

public class CommentActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        ListView commentListView = findViewById(R.id.commentListView);


        ArrayList<Comment> comments =(ArrayList<Comment>) getIntent().getSerializableExtra("comments");


        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), comments);
        commentListView.setAdapter(customAdapter);
    }

}

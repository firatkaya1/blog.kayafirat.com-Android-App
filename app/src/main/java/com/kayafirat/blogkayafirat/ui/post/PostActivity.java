package com.kayafirat.blogkayafirat.ui.post;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.Comment;
import com.kayafirat.blogkayafirat.model.Post;
import com.kayafirat.blogkayafirat.ui.comment.CommentActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageButton btnComment = findViewById(R.id.goComment);
        TextView postTitle = findViewById(R.id.postTitle);
        TextView postDetail = findViewById(R.id.postDetail);

        Post post = (Post) getIntent().getExtras().getSerializable("post");
        JSONArray jsonArray = new JSONArray(post.getComments());
        try {
            System.out.println(jsonArray.getJSONObject(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        postTitle.setText(post.getPostTitle());
        postDetail.setText(post.getPostDetail());

        btnComment.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CommentActivity.class);
            ArrayList<Comment> comments = post.getComments();
            intent.putExtra("comments", comments);
            startActivity(intent);
        });

    }

}

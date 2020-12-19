package com.kayafirat.blogkayafirat.ui.post;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import org.json.JSONObject;

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
        ArrayList<Comment> comments = convertToArray(post.getComments());


        postTitle.setText(post.getPostTitle());

        postDetail.setText(post.getPostDetail());

        btnComment.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CommentActivity.class);
            intent.putExtra("comments",comments);
            startActivity(intent);
        });

    }

    private ArrayList<Comment> convertToArray(ArrayList<Comment> comment){
        JSONArray jsonArray = new JSONArray(comment);
        ArrayList<Comment> comments = new ArrayList<>();

        for (int i=0;i<jsonArray.length();i++){
            try {
                comments.add(new Comment(new JSONObject(jsonArray.getString(i)).get("commentId").toString(),
                        new JSONObject(jsonArray.getString(i)).get("userName").toString(),
                        new JSONObject(jsonArray.getString(i)).get("commentBody").toString(),
                        new JSONObject(jsonArray.getString(i)).get("commentDate").toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return comments;
    }

}

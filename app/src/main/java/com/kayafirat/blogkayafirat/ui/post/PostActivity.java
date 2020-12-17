package com.kayafirat.blogkayafirat.ui.post;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.Post;
import com.kayafirat.blogkayafirat.service.IPostService;
import com.kayafirat.blogkayafirat.service.impl.PostService;
import com.kayafirat.blogkayafirat.ui.comment.CommentActivity;

import org.w3c.dom.Text;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageButton btnComment = findViewById(R.id.goComment);
        TextView postTitle = findViewById(R.id.postTitle);
        TextView postDetail = findViewById(R.id.postDetail);

        IPostService postService = new PostService();

        Post post = postService.getPost(getIntent().getExtras().get("postId").toString());

        postTitle.setText(post.getPostTitle());
        postDetail.setText(post.getPostDetail());

        btnComment.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CommentActivity.class);
            startActivity(intent);
        });

    }

}

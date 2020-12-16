package com.kayafirat.blogkayafirat.ui.post;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.ui.comment.CommentActivity;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageButton btnComment = findViewById(R.id.goComment);

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CommentActivity.class);
                startActivity(intent);
            }
        });

    }

}

package com.kayafirat.blogkayafirat.ui.comment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.Comment;
import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.service.IPostService;
import com.kayafirat.blogkayafirat.service.IUserService;
import com.kayafirat.blogkayafirat.service.impl.PostService;
import com.kayafirat.blogkayafirat.service.impl.UserService;

import java.util.ArrayList;

public class CommentActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Button btnAddComment = findViewById(R.id.btnAddComment);
        ListView commentListView = findViewById(R.id.commentListView);

        IPostService postService = new PostService();
        IUserService userService = new UserService();

        Long userId = getApplicationContext().getSharedPreferences(getString(R.string.prefence_file_key), Context.MODE_PRIVATE).getLong("id",0);
        User user = userService.getUser(userId);


        String postId = getIntent().getStringExtra("postID");
        ArrayList<Comment> comments =(ArrayList<Comment>) getIntent().getSerializableExtra("comments");

        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), comments);
        commentListView.setAdapter(customAdapter);


        LayoutInflater inflater = LayoutInflater.from(CommentActivity.this);
        final View v = inflater.inflate(R.layout.comment_dialog, null);
        final TextView etName = (EditText) v.findViewById(R.id.commentDescription);

        AlertDialog dialog = new AlertDialog.Builder(CommentActivity.this)
                .setView(v)
                .setPositiveButton("Gönder", (dialog1, whichButton) -> {
                    String commentBody =  etName.getText().toString();
                    Comment comment = postService.commentAdd(commentBody,user.getUserName(),postId);
                    comments.add(comment);
                    customAdapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "Yorumunuz başarıyla eklendi.", Toast.LENGTH_LONG).show();
                })
                .setNegativeButton("İptal Et", null).create();

        btnAddComment.setOnClickListener(ve -> {
            dialog.show();
        });

    }



}

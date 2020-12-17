package com.kayafirat.blogkayafirat.ui.comment;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ListView commentListView = findViewById(R.id.commentListView);
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment("1","Fırat Kaya","test","Konunuzu çok beğendim. Harikaymış","2019/12/12 23:12:12","2019/12/12 23:12:12"));
        comments.add(new Comment("2","Fırat Kaya","test","Konunuzu çok beğendim. Harikaymış","2019/12/12 23:12:12","2019/12/12 23:12:12"));
        comments.add(new Comment("3","Fırat Kaya","test","Konunuzu çok beğendim. Harikaymış","2019/12/12 23:12:12","2019/12/12 23:12:12"));
        comments.add(new Comment("4","Fırat Kaya","test","Konunuzu çok beğendim. Harikaymış","2019/12/12 23:12:12","2019/12/12 23:12:12"));
        comments.add(new Comment("5","Fırat Kaya","test","Konunuzu çok beğendim. Harikaymış","2019/12/12 23:12:12","2019/12/12 23:12:12"));
        comments.add(new Comment("6","Fırat Kaya","test","Konunuzu çok beğendim. Harikaymış","2019/12/12 23:12:12","2019/12/12 23:12:12"));
        comments.add(new Comment("7","Fırat Kaya","test","Konunuzu çok beğendim. Harikaymış","2019/12/12 23:12:12","2019/12/12 23:12:12"));
        comments.add(new Comment("8","Fırat Kaya","test","Konunuzu çok beğendim. Harikaymış","2019/12/12 23:12:12","2019/12/12 23:12:12"));
        comments.add(new Comment("9","Fırat Kaya","test","Konunuzu çok beğendim. Harikaymış","2019/12/12 23:12:12","2019/12/12 23:12:12"));



        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), comments);
        commentListView.setAdapter(customAdapter);
    }

}

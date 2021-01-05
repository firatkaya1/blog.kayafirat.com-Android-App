package com.kayafirat.blogkayafirat.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.Post;
import com.kayafirat.blogkayafirat.service.IPostService;
import com.kayafirat.blogkayafirat.service.impl.PostService;
import com.kayafirat.blogkayafirat.ui.home.CustomAdapter;
import com.kayafirat.blogkayafirat.ui.post.PostActivity;

import java.util.ArrayList;

public class SearchFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        EditText searchText = root.findViewById(R.id.text_search);
        final Button btnSearch = root.findViewById(R.id.btnSearch);
        TextView findedResult = root.findViewById(R.id.findedResult);
        ListView postListView = root.findViewById(R.id.postListView);

        IPostService postService = new PostService();

        btnSearch.setOnClickListener(v -> {
            ArrayList<Post> postList  = postService.searchPost(searchText.getText().toString().trim());
            CustomAdapter customAdapter = new CustomAdapter(getContext(),postList);
            postListView.setAdapter(customAdapter);
            if (postList.size() > 0){
                findedResult.setText("Toplam "+postList.size()+" adet sonuç bulundu.");
            } else {
                findedResult.setText("Sonuç bulunamadı.");
            }

        });

        postListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getActivity(), PostActivity.class);
            intent.putExtra("post",postService.getPost(String.valueOf(id)));
            startActivity(intent);
        });


        return root;
    }


}
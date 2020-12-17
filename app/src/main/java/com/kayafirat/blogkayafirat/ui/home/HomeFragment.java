package com.kayafirat.blogkayafirat.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.Post;
import com.kayafirat.blogkayafirat.service.IPostService;
import com.kayafirat.blogkayafirat.service.impl.PostService;
import com.kayafirat.blogkayafirat.ui.post.PostActivity;



public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        IPostService postService = new PostService();

        CustomAdapter customAdapter = new CustomAdapter(getContext(),postService.getAllPost());
        ListView postListView = root.findViewById(R.id.postListView);
        postListView.setAdapter(customAdapter);

        postListView.setOnItemClickListener((parent, view, position, id) -> {

            Intent intent = new Intent(getActivity(), PostActivity.class);
            intent.putExtra("postId",id);
            startActivity(intent);
        });


        return root;
    }

}
package com.kayafirat.blogkayafirat.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.ui.post.PostActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ListView postListView = root.findViewById(R.id.postListView);
        String testList[] = {
                "India", "China", "australia", "Portugle", "America", "NewZealand",
                "India", "China", "australia", "Portugle", "America", "NewZealand",
                "India", "China", "australia", "Portugle", "America", "NewZealand",
                "India", "China", "australia", "Portugle", "America", "NewZealand",
                "India", "China", "australia", "Portugle", "America", "NewZealand",
                "India", "China", "australia", "Portugle", "America", "NewZealand"};
        CustomAdapter customAdapter = new CustomAdapter(this.getContext(), testList);
        postListView.setAdapter(customAdapter);


        postListView.setOnItemClickListener((parent, view, position, id) -> {
            System.out.println("tiklanan item :"+testList[position]);
            Intent intent = new Intent(getActivity(), PostActivity.class);
            startActivity(intent);
        });

        return root;
    }


}
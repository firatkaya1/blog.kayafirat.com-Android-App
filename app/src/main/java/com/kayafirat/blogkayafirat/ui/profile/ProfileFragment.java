package com.kayafirat.blogkayafirat.ui.profile;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.service.IUserService;
import com.kayafirat.blogkayafirat.service.impl.UserService;

public class ProfileFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView userId = root.findViewById(R.id.userId);
        TextView emailAddress = root.findViewById(R.id.emailAddress);
        TextView userName = root.findViewById(R.id.username);
        TextView registerDate = root.findViewById(R.id.registerDate);

        IUserService userService = new UserService();

        Long id = getContext().getSharedPreferences(getString(R.string.prefence_file_key), Context.MODE_PRIVATE).getLong("id",0);
        User user = userService.getUser(id);
        userId.setText(user.getId());
        emailAddress.setText(user.getEmailAddress());
        userName.setText(user.getUserName());
        registerDate.setText(user.getUserRegisterDate());


        return root;
    }
}
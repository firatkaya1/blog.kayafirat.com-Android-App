package com.kayafirat.blogkayafirat.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.service.IUserService;
import com.kayafirat.blogkayafirat.service.impl.UserService;
import com.kayafirat.blogkayafirat.ui.search.SearchViewModel;

public class SettingsFragment extends Fragment  {

    private SearchViewModel searchViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        TextView userId = root.findViewById(R.id.userId);
        EditText emailAddress = root.findViewById(R.id.emailAddress);
        EditText userName = root.findViewById(R.id.username);
        EditText userPassword = root.findViewById(R.id.userPassword);

        IUserService userService = new UserService();
        User user = userService.getUser(1);

        userId.setText(user.getId());
        emailAddress.setText(user.getEmailAddress());
        userName.setText(user.getUserName());
        userPassword.setText(user.getUserPassword());

        return root;
    }
}

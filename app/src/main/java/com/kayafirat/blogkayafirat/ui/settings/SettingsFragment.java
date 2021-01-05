package com.kayafirat.blogkayafirat.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.kayafirat.blogkayafirat.R;
import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.service.IUserService;
import com.kayafirat.blogkayafirat.service.impl.UserService;
import com.kayafirat.blogkayafirat.ui.login.LoginActivity;

public class SettingsFragment extends Fragment  {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        TextView userId = root.findViewById(R.id.userId);
        EditText emailAddress = root.findViewById(R.id.emailAddress);
        EditText userName = root.findViewById(R.id.username);
        EditText userPassword = root.findViewById(R.id.userPassword);
        Button btnUpdate = root.findViewById(R.id.btnUpdate);
        Button btnExit = root.findViewById(R.id.btnExit);


        IUserService userService = new UserService();
        Long id = getContext().getSharedPreferences(getString(R.string.prefence_file_key), Context.MODE_PRIVATE).getLong("id",0);
        User user = userService.getUser(id);
        userId.setText(user.getId());
        emailAddress.setText(user.getEmailAddress());
        userName.setText(user.getUserName());
        userPassword.setText(user.getUserPassword());


        btnUpdate.setOnClickListener(v-> {
            user.setEmailAddress(userId.getText().toString());
            user.setEmailAddress(emailAddress.getText().toString());
            user.setUserName(userName.getText().toString());
            user.setUserPassword(userPassword.getText().toString());

            userService.updateUser(user);
        });

        btnExit.setOnClickListener(v-> {
            Toast.makeText(getContext(),"Çıkış yapıldı.",Toast.LENGTH_LONG);
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });


        return root;
    }
}

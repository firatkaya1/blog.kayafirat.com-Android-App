package com.kayafirat.blogkayafirat.service.impl;

import android.os.StrictMode;

import com.kayafirat.blogkayafirat.model.Comment;
import com.kayafirat.blogkayafirat.model.Post;
import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.service.IUserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserService implements IUserService {

    private final static String USER_URI = "https://api.kayafirat.com/mobile/user/";

    @Override
    public User getUser(long id) {
        User user;
        int SDK_INT = android.os.Build.VERSION.SDK_INT;

        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            RestTemplate restTemplate = new RestTemplate();
            Map map = restTemplate.getForObject(USER_URI.concat(String.valueOf(id)), Map.class);
            user = new User();
            user.setUserId(map.get("id").toString());
            user.setUserEmail(map.get("emailAddress").toString());
            user.setUserName(map.get("userName").toString());
            user.setUserPassword(map.get("userPassword").toString());
            user.setUserRegisterDate(map.get("userRegisterDate").toString());
            return user;
        }


        return null;
    }

    @Override
    public User saveUser(User user) {

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject("url", "message", String.class);
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void updatePassword(HashMap<String, String> request) {

    }

    @Override
    public void updateUserUsername(String email, String username) {

    }

}

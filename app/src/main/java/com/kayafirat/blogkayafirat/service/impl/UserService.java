package com.kayafirat.blogkayafirat.service.impl;

import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.service.IUserService;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class UserService  implements IUserService {


    @Override
    public User getUserByEmail(String email) {
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

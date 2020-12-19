package com.kayafirat.blogkayafirat.service;

import com.kayafirat.blogkayafirat.model.User;

import java.util.HashMap;

public interface IUserService {

    User getUser(long email);

    User saveUser(User user);

    User updateUser(User user);

    void updatePassword(HashMap<String, String> request);


    void updateUserUsername(String email, String username);


}

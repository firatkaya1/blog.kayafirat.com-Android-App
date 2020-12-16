package com.kayafirat.blogkayafirat.service;

import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.model.UserPermissions;

import java.util.HashMap;

public interface IUserService {

    User getUserByEmail(String email);

    User saveUser(User user);

    User updateUser(User user);

    boolean updateUserPermissions(UserPermissions userPermissions);

    void updatePassword(HashMap<String, String> request);

    void updateUserGithubAddress(String email, String githubaddress);

    void updateUserLinkedinAddress(String email, String linkedinaddress);

    void updateUserUsername(String email, String username);

    void updateUserBirthDate(String email, String date);

}

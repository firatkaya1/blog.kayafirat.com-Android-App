package com.kayafirat.blogkayafirat.service.impl;

import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.model.UserPermissions;
import com.kayafirat.blogkayafirat.service.IUserService;

import java.util.HashMap;

public class UserService  implements IUserService {

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean updateUserPermissions(UserPermissions userPermissions) {
        return false;
    }

    @Override
    public void updatePassword(HashMap<String, String> request) {

    }

    @Override
    public void updateUserGithubAddress(String email, String githubaddress) {

    }

    @Override
    public void updateUserLinkedinAddress(String email, String linkedinaddress) {

    }

    @Override
    public void updateUserUsername(String email, String username) {

    }

    @Override
    public void updateUserBirthDate(String email, String date) {

    }
}

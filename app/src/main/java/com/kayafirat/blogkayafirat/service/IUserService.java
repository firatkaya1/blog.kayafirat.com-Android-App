package com.kayafirat.blogkayafirat.service;

import com.kayafirat.blogkayafirat.model.AuthenticateRequest;
import com.kayafirat.blogkayafirat.model.User;

import java.util.HashMap;

public interface IUserService {

    User getUser(long id);

    Boolean saveUser(User user);

    Long login(AuthenticateRequest authenticateRequest);

    User updateUser(User user);


}

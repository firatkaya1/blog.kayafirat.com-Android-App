package com.kayafirat.blogkayafirat.service.impl;

import android.os.StrictMode;

import com.kayafirat.blogkayafirat.model.AuthenticateRequest;
import com.kayafirat.blogkayafirat.model.User;
import com.kayafirat.blogkayafirat.service.IUserService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class UserService implements IUserService {

    private final static String USER_URI = "https://api.kayafirat.com/mobile/user/";
    private final static String LOGIN_URI = "https://api.kayafirat.com/mobile/user/login";

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
            user.setId(map.get("id").toString());
            user.setEmailAddress(map.get("emailAddress").toString());
            user.setUserName(map.get("userName").toString());
            user.setUserPassword(map.get("userPassword").toString());
            user.setUserRegisterDate(map.get("userRegisterDate").toString());
            return user;
        }


        return null;
    }

    @Override
    public Boolean saveUser(User user) {

        int SDK_INT = android.os.Build.VERSION.SDK_INT;

        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            RestTemplate restTemplate = new RestTemplate();
            Boolean isSuccess = restTemplate.postForObject(USER_URI,user, Boolean.class);
            return isSuccess;
        }
        return false;
    }

    @Override
    public Long login(AuthenticateRequest authenticateRequest) {

        int SDK_INT = android.os.Build.VERSION.SDK_INT;

        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<?> httpEntity = new HttpEntity<Object>(authenticateRequest);
            String id = restTemplate.exchange(LOGIN_URI,HttpMethod.POST,httpEntity,String.class).getBody();
            if (!id.equals("0")){
                User user = getUser(Long.valueOf(id));
                return Long.valueOf(user.getId());
            }
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        int SDK_INT = android.os.Build.VERSION.SDK_INT;

        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<User> entity = new HttpEntity<User>(user);
            ResponseEntity<User> map = restTemplate.exchange(USER_URI,HttpMethod.PUT,entity,User.class);
            System.out.println("map : "+map.getBody());

/*            user.setId(map.get("id").toString());
            user.setEmailAddress(map.get("emailAddress").toString());
            user.setUserName(map.get("userName").toString());
            user.setUserPassword(map.get("userPassword").toString());
            user.setUserRegisterDate(map.get("userRegisterDate").toString());*/
            return user;
        }
        return null;
    }
}

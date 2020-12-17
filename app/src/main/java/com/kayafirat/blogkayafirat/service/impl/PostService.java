package com.kayafirat.blogkayafirat.service.impl;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.kayafirat.blogkayafirat.model.Post;
import com.kayafirat.blogkayafirat.service.IPostService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PostService  implements IPostService  {

    private final static String POST_URI = "https://api.kayafirat.com/mobile/post/";



    @Override
    public List<Post> getAllPost() {
        List<Post> post = new ArrayList<>();
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            RestTemplate restTemplate = new RestTemplate();
             Map[] map = restTemplate.getForObject(POST_URI, Map[].class);
            for (int i =0 ;i < map.length;i++){
                post.add(
                        new Post(
                                map[i].get("postId").toString(),
                                map[i].get("postTitle").toString(),
                                map[i].get("postHeader").toString(),
                                map[i].get("postDetail").toString(),
                                "2013/12/12 23:12:11",
                                "56"));
            }
        }

        return post;
    }

    @Override
    public Post getPost(String id) {
        Post post = new Post();
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            RestTemplate restTemplate = new RestTemplate();
            Map map = restTemplate.getForObject(POST_URI+id, Map.class);

            post.setPostId(map.get("postId").toString());
            post.setPostTitle(map.get("postTitle").toString());
            post.setPostHeader(map.get("postHeader").toString());
            post.setPostDetail(map.get("postDetail").toString());
            post.setPostTime("2013/12/12 23:12:11");
            post.setPostMaxView("56");

        }
        return post;
    }


}
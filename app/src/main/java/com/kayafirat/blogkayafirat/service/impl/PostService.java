package com.kayafirat.blogkayafirat.service.impl;

import android.os.StrictMode;
import com.kayafirat.blogkayafirat.model.Comment;
import com.kayafirat.blogkayafirat.model.Post;
import com.kayafirat.blogkayafirat.service.IPostService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostService  implements IPostService  {

    private final static String POST_URI = "https://api.kayafirat.com/mobile/post/";
    private final static String SEARCH_POST_URI = "https://api.kayafirat.com/mobile/post/search/";


    @Override
    public List<Post> getAllPost() {

        List<Post> post = new ArrayList<>();

        int SDK_INT = android.os.Build.VERSION.SDK_INT;

        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
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
                                map[i].get("postRegisterDate").toString(),
                                map[i].get("postMaxView").toString(),
                                (ArrayList<Comment>) map[i].get("comment")));
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
            post.setPostRegisterDate(map.get("postRegisterDate").toString());
            post.setPostMaxView(map.get("postMaxView").toString());
            post.setComments((ArrayList<Comment>) map.get("comment"));

        }
        return post;
    }

    @Override
    public ArrayList<Post> searchPost(String keyword) {
        ArrayList<Post> post = new ArrayList<>();

        int SDK_INT = android.os.Build.VERSION.SDK_INT;

        if (SDK_INT > 8 && !keyword.isEmpty())
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            RestTemplate restTemplate = new RestTemplate();
            Map[] map = restTemplate.getForObject(SEARCH_POST_URI.concat(keyword), Map[].class);

            for (int i =0 ;i < map.length;i++){

                post.add(
                        new Post(
                                map[i].get("postId").toString(),
                                map[i].get("postTitle").toString(),
                                map[i].get("postHeader").toString(),
                                map[i].get("postDetail").toString(),
                                map[i].get("postRegisterDate").toString(),
                                map[i].get("postMaxView").toString(),
                                (ArrayList<Comment>) map[i].get("comment")));
            }
        }

        return post;
    }


}
package com.kayafirat.blogkayafirat.service;

import com.kayafirat.blogkayafirat.model.Comment;
import com.kayafirat.blogkayafirat.model.Post;

import java.util.ArrayList;
import java.util.List;

public interface IPostService {

        List<Post> getAllPost();

        Post getPost(String id);

        ArrayList<Post> searchPost(String keyword);

        Comment commentAdd(String comment,String username,String id);
}

package com.kayafirat.blogkayafirat.service;

import com.kayafirat.blogkayafirat.model.Post;

import java.util.List;

public interface IPostService {

        List<Post> getAllPost(int pageNumber,int pageSize,String sortBy,String orderBy);

        Post getPost(String id);


}

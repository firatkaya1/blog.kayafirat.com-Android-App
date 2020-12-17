package com.kayafirat.blogkayafirat.model;

import com.android.volley.toolbox.StringRequest;

import java.util.HashSet;
import java.util.Set;

public class Post {

    private String postId;

    private String postTitle;

    private String postHeader;

    private String postDetail;

    private String postTime;

    private String postMaxView;

    public Post() {
    }

    public Post(String postId, String postTitle, String postHeader, String postDetail, String postTime, String postMaxView) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postHeader = postHeader;
        this.postDetail = postDetail;
        this.postTime = postTime;
        this.postMaxView = postMaxView;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostHeader() {
        return postHeader;
    }

    public void setPostHeader(String postHeader) {
        this.postHeader = postHeader;
    }

    public String getPostDetail() {
        return postDetail;
    }

    public void setPostDetail(String postDetail) {
        this.postDetail = postDetail;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostMaxView() {
        return postMaxView;
    }

    public void setPostMaxView(String postMaxView) {
        this.postMaxView = postMaxView;
    }


}

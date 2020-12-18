package com.kayafirat.blogkayafirat.model;


import java.io.Serializable;
import java.util.ArrayList;


public class Post implements Serializable {

    private String postId;

    private String postTitle;

    private String postHeader;

    private String postDetail;

    private String postRegisterDate;

    private String postMaxView;

    private ArrayList<Comment> comment;

    public Post() { }

    public Post(String postId, String postTitle, String postHeader, String postDetail, String postRegisterDate, String postMaxView,ArrayList<Comment> comment) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postHeader = postHeader;
        this.postDetail = postDetail;
        this.postRegisterDate = postRegisterDate;
        this.postMaxView = postMaxView;
        this.comment = comment;
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

    public String getPostRegisterDate() {
        return postRegisterDate;
    }

    public void setPostRegisterDate(String postTime) {
        this.postRegisterDate = postTime;
    }

    public String getPostMaxView() {
        return postMaxView;
    }

    public void setPostMaxView(String postMaxView) {
        this.postMaxView = postMaxView;
    }

    public ArrayList<Comment> getComments() {
        return comment;
    }

    public void setComments(ArrayList<Comment> comment) {
        this.comment = comment;
    }
}

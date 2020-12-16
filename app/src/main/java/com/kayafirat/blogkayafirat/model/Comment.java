package com.kayafirat.blogkayafirat.model;

public class Comment {

    private String commentId;

    private String username;

    private String userProfilePhoto;

    private String commentMessage;

    private String commentTime;

    private String commentUpdateTime;

    public Comment(String commentId, String username, String userProfilePhoto, String commentMessage, String commentTime, String commentUpdateTime) {
        this.commentId = commentId;
        this.username = username;
        this.userProfilePhoto = userProfilePhoto;
        this.commentMessage = commentMessage;
        this.commentTime = commentTime;
        this.commentUpdateTime = commentUpdateTime;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentUpdateTime() {
        return commentUpdateTime;
    }

    public void setCommentUpdateTime(String commentUpdateTime) {
        this.commentUpdateTime = commentUpdateTime;
    }
}

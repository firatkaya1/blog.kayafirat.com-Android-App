package com.kayafirat.blogkayafirat.model;

import java.io.Serializable;

public class Comment implements Serializable {

    private String commentId;

    private String userName;

    private String commentBody;

    private String commentDate;

    public Comment(String commentId, String userName, String commentBody, String commentDate) {
        this.commentId = commentId;
        this.userName = userName;
        this.commentBody = commentBody;
        this.commentDate = commentDate;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", userName='" + userName + '\'' +
                ", commentBody='" + commentBody + '\'' +
                ", commentDate='" + commentDate + '\'' +
                '}';
    }
}

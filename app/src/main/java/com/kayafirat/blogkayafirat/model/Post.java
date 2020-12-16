package com.kayafirat.blogkayafirat.model;

import java.util.HashSet;
import java.util.Set;

public class Post {

    private String postId;

    private String postTag;

    private String postTitle;

    private String postHeader;

    private String postBody;

    private String postTime;

    private long postMaxView;

    private Set<Comment> comment = new HashSet<>();

}

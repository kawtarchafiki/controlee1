package com.example.dao;

import com.example.model.Post;

import java.util.Arrays;
import java.util.List;

public class PostDAO {

    public List<Post> listerTousLesPosts() {
        return Arrays.asList(Post.values());
    }
}

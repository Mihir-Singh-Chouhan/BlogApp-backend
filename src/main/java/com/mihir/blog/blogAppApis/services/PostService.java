package com.mihir.blog.blogAppApis.services;

import com.mihir.blog.blogAppApis.dto.request.PostRequest;
import com.mihir.blog.blogAppApis.dto.response.PostResponse;

import java.util.List;

public interface PostService {

    PostRequest createPost(PostRequest postRequest, Integer userId, Integer categoryId);
    PostRequest updatePost(PostRequest postRequest, Integer postId);
    void deletePost(Integer postId);
    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy);
    PostRequest getPostById(Integer postId);

    List<PostRequest> getAllPostByCategory(Integer categoryId);
    List<PostRequest> getAllPostByUser(Integer userId);

    //for searching:
    List<PostRequest> searchPosts(String keyword);
}

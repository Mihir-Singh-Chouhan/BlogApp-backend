package com.mihir.blog.blogAppApis.services;

import com.mihir.blog.blogAppApis.dto.request.PostDto;
import com.mihir.blog.blogAppApis.entities.Post;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
    PostDto updatePost(PostDto postDto, Integer postId);
    void deletePost(Integer postId);
    List<PostDto> getAllPost();
    PostDto getPostById(Integer postId);

    List<PostDto> getAllPostByCategory(Integer categoryId);
    List<PostDto> getAllPostByUser(Integer userId);

    //for searching:
    List<Post> searchPosts(String keyword);
}

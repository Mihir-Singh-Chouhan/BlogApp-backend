package com.mihir.blog.blogAppApis.services.impl;

import com.mihir.blog.blogAppApis.dto.request.PostDto;
import com.mihir.blog.blogAppApis.entities.Category;
import com.mihir.blog.blogAppApis.entities.Post;
import com.mihir.blog.blogAppApis.entities.User;
import com.mihir.blog.blogAppApis.exceptions.ResourceNotFoundException;
import com.mihir.blog.blogAppApis.repositories.CategoryRepository;
import com.mihir.blog.blogAppApis.repositories.PostRepository;
import com.mihir.blog.blogAppApis.repositories.UserRepository;
import com.mihir.blog.blogAppApis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PostDto createPost(PostDto postDto,Integer userId, Integer categoryId) {

        User user = this.userRepository.findById(userId)
                        .orElseThrow(()-> new ResourceNotFoundException("User","User Id",userId));
        Category category = this.categoryRepository.findById(categoryId)
                                .orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id",categoryId));

        Post creatPost = this.modelMapper.map(postDto,Post.class);
        creatPost.setImageName("default.png");
        creatPost.setAddedDate(new Date());
        creatPost.setUser(user);
        creatPost.setCategory(category);
        return this.modelMapper.map(this.postRepository.save(creatPost),PostDto.class);  // or Post newPost = this.postRepository.save(creatPost); use newPost
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
        post.setPostTitle(postDto.getTitle());
        post.setPostContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        Post updatedPost = this.postRepository.save(post);

        return this.modelMapper.map(updatedPost,PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
        this.postRepository.delete(post);
    }

    @Override
    public List<PostDto> getAllPost() {
       List<Post> allPosts = this.postRepository.findAll();
       List<PostDto> postDtos = allPosts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {
       Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id", postId));
       PostDto convertIntoDto = this.modelMapper.map(post,PostDto.class);
        return convertIntoDto;
    }

    @Override
    public List<PostDto> getAllPostByCategory(Integer categoryId) {

       Category category = this.categoryRepository.findById(categoryId)
               .orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));

        List<Post> posts = this.postRepository.findByCategory(category);

        //Use streamApi to convert post -> postDto using lambda
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getAllPostByUser(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","UserId",userId));

        List<Post> posts = this.postRepository.findByUser(user);

        //Use streamApi to convert post -> postDto using lambda
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return List.of();
    }
}

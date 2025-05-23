package com.mihir.blog.blogAppApis.controllers;

import com.mihir.blog.blogAppApis.constants.AppConstants;
import com.mihir.blog.blogAppApis.dto.request.PostRequest;
import com.mihir.blog.blogAppApis.dto.response.ApiResponse;
import com.mihir.blog.blogAppApis.dto.response.PostResponse;
import com.mihir.blog.blogAppApis.services.FileService;
import com.mihir.blog.blogAppApis.services.PostService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    private final PostService postService;
    private final FileService fileService;
    public PostController(PostService postService, FileService fileService) {
        this.postService = postService;
        this.fileService = fileService;
    }

    @Value("${project.image}")
    private String path;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostRequest> createPost(@RequestBody PostRequest postRequest, @PathVariable Integer userId, @PathVariable Integer categoryId){
    PostRequest createPost = this.postService.createPost(postRequest,userId,categoryId);
    return new ResponseEntity<PostRequest>(createPost, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostRequest>> getAllPostByUser(@PathVariable Integer userId){
        List<PostRequest> posts =  this.postService.getAllPostByUser(userId);
        return new ResponseEntity<List<PostRequest>>(posts,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostRequest>> getAllPostByCategory(@PathVariable Integer categoryId){
        List<PostRequest> posts = this.postService.getAllPostByCategory(categoryId);
        return new ResponseEntity<List<PostRequest>>(posts,HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
            @RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy){
        PostResponse allPost = this.postService.getAllPost(pageNumber - 1,pageSize,sortBy);
        return new ResponseEntity<PostResponse>(allPost,HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostRequest> getPostById(@PathVariable Integer postId){
        PostRequest postRequest = this.postService.getPostById(postId);
        return new ResponseEntity<PostRequest>(postRequest,HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePostById(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted Successfully",true),HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostRequest> updatePost(@RequestBody PostRequest postRequest, @PathVariable Integer postId){
       PostRequest updateDto =  this.postService.updatePost(postRequest,postId);
        return new ResponseEntity<PostRequest>(updateDto,HttpStatus.OK);
    }

    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostRequest>> searchPostByTitle(@PathVariable String keywords){
        List<PostRequest> result = this.postService.searchPosts(keywords);
        return new ResponseEntity<List<PostRequest>>(result,HttpStatus.OK);
    }

    @PostMapping("/post/image/upload/{postId}")
    public ResponseEntity<PostRequest> uploadPostImage(@RequestParam("image")MultipartFile image,@PathVariable Integer postId) throws IOException {

        PostRequest postDto = this.postService.getPostById(postId);
        String fileName = this.fileService.uploadImage(path,image);

        postDto.setImageName(fileName);
        PostRequest updatePost = this.postService.updatePost(postDto,postId);

        return new ResponseEntity<PostRequest>(updatePost,HttpStatus.OK);
    }

    @GetMapping(value = "/post/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException{

        InputStream resource = this.fileService.getResource(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }

}

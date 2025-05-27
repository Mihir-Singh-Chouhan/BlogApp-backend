package com.company.demo.controllers;

import com.company.demo.dto.request.CommentRequest;
import com.company.demo.dto.response.ApiResponse;
import com.company.demo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentRequest> createComment(@RequestBody CommentRequest comment, @PathVariable Integer postId){
       CommentRequest createComment = this.commentService.createComment(comment,postId);
       return new ResponseEntity<CommentRequest>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment Deleted Successfully",true),HttpStatus.OK);
    }
}

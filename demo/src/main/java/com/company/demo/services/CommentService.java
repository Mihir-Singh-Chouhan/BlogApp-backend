package com.company.demo.services;

import com.company.demo.dto.request.CommentRequest;

public interface CommentService {

    CommentRequest createComment(CommentRequest commentRequest, Integer postId);

    void deleteComment(Integer commentId);
}

package com.mihir.blog.blogAppApis.services;

import com.mihir.blog.blogAppApis.dto.request.CommentRequest;

public interface CommentService {

    CommentRequest createComment(CommentRequest commentRequest,Integer postId);

    void deleteComment(Integer commentId);
}

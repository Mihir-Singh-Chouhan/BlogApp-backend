package com.mihir.blog.blogAppApis.services.impl;

import com.mihir.blog.blogAppApis.dto.request.CommentRequest;
import com.mihir.blog.blogAppApis.entities.CommentEntity;
import com.mihir.blog.blogAppApis.entities.PostEntity;
import com.mihir.blog.blogAppApis.exceptions.ResourceNotFoundException;
import com.mihir.blog.blogAppApis.repositories.CommentRepository;
import com.mihir.blog.blogAppApis.repositories.PostRepository;
import com.mihir.blog.blogAppApis.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    @Autowired
    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentRequest createComment(CommentRequest commentRequest, Integer postId) {

        PostEntity post = this.postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
        CommentEntity comment = this.modelMapper.map(commentRequest, CommentEntity.class);

        comment.setPost(post);

        CommentEntity savedComment = this.commentRepository.save(comment);
        return this.modelMapper.map(savedComment,CommentRequest.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
     CommentEntity comment = this.commentRepository.findById(commentId)
             .orElseThrow(()-> new ResourceNotFoundException("Comment","comment id",commentId));

     this.commentRepository.delete(comment);

    }
}

package com.company.demo.services.impl;

import com.company.demo.dto.request.CommentRequest;
import com.company.demo.entities.CommentEntity;
import com.company.demo.entities.PostEntity;
import com.company.demo.exceptions.ResourceNotFoundException;
import com.company.demo.repositories.CommentRepository;
import com.company.demo.repositories.PostRepository;
import com.company.demo.repositories.UserRepository;
import com.company.demo.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    @Autowired
    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository,UserRepository userRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentRequest createComment(CommentRequest commentRequest, Integer postId) {

        PostEntity post = this.postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
        CommentEntity comment = this.modelMapper.map(commentRequest, CommentEntity.class);

        comment.setPost(post);

       // add logic for user details

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

package com.mihir.blog.blogAppApis.dto.request;

import com.mihir.blog.blogAppApis.entities.CommentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostRequest {

    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryRequest category;
    private UserRequest user;

    private Set<CommentRequest> commentEntitySet = new HashSet<>();
}

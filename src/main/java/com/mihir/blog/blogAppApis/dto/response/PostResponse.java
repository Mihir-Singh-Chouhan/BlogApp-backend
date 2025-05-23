package com.mihir.blog.blogAppApis.dto.response;

import com.mihir.blog.blogAppApis.dto.request.CategoryRequest;
import com.mihir.blog.blogAppApis.dto.request.PostRequest;
import com.mihir.blog.blogAppApis.dto.request.UserRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class PostResponse {
    private List<PostRequest> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean lastPage;

}


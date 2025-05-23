package com.mihir.blog.blogAppApis.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryRequest {

    private Integer categoryId;

    @NotBlank
    @Size(min = 5,message = "Title must have atleast 5 charaters")
    private String categoryTitle;

    @NotBlank
    @Size(min = 5,max = 100,message = "Description contains 5-100 charaters")
    private String categoryDescription;
}

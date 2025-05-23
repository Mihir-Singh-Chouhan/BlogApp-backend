package com.mihir.blog.blogAppApis.services;

import com.mihir.blog.blogAppApis.dto.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    CategoryRequest createCategory(CategoryRequest categoryRequest);
    CategoryRequest updateCategory(CategoryRequest categoryRequest, Integer categoryId);
    CategoryRequest getCategoryById(Integer categoryId);
    List<CategoryRequest> getAllCategory();
    void deleteCategory(Integer categoryId);
}

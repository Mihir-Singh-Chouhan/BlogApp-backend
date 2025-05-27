package com.company.demo.services;


import com.company.demo.dto.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    CategoryRequest createCategory(CategoryRequest categoryRequest);
    CategoryRequest updateCategory(CategoryRequest categoryRequest, Integer categoryId);
    CategoryRequest getCategoryById(Integer categoryId);
    List<CategoryRequest> getAllCategory();
    void deleteCategory(Integer categoryId);
}

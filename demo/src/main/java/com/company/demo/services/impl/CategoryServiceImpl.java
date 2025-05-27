package com.company.demo.services.impl;

import com.company.demo.dto.request.CategoryRequest;
import com.company.demo.entities.CategoryEntity;
import com.company.demo.exceptions.ResourceNotFoundException;
import com.company.demo.repositories.CategoryRepository;
import com.company.demo.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryRequest createCategory(CategoryRequest categoryRequest) {
        CategoryEntity categoryEntity = this.modelMapper.map(categoryRequest, CategoryEntity.class);
        CategoryEntity addedCategoryEntity = this.categoryRepository.save(categoryEntity);
        return this.modelMapper.map(addedCategoryEntity, CategoryRequest.class);
    }

    @Override
    public CategoryRequest updateCategory(CategoryRequest categoryRequest, Integer categoryId) {
        CategoryEntity categoryEntity = this.categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
        categoryEntity.setCategoryTitle(categoryRequest.getCategoryTitle());
        categoryEntity.setCategoryDescription(categoryRequest.getCategoryDescription());
        CategoryEntity updatedCategoryEntity = this.categoryRepository.save(categoryEntity);
        return this.modelMapper.map(updatedCategoryEntity, CategoryRequest.class);
    }

    @Override
    public CategoryRequest getCategoryById(Integer categoryId) {
        CategoryEntity categoryEntity = this.categoryRepository.findById(categoryId).orElseThrow(()->
                new ResourceNotFoundException("Category","category id",categoryId));
        return this.modelMapper.map(categoryEntity, CategoryRequest.class);
    }

    @Override
    public List<CategoryRequest> getAllCategory() {
        List<CategoryEntity> categories = this.categoryRepository.findAll();
//        List<CategoryDto> categoryDtos = categories.stream().map(category -> this.modelMapper.map(category, CategoryDto.class))
//                .collect(Collectors.toList());
        return categories.stream().map(category -> this.modelMapper.map(category, CategoryRequest.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Integer categoryId) {
         CategoryEntity categoryEntity =this.categoryRepository.findById(categoryId).orElseThrow(()->
                 new ResourceNotFoundException("Category","category id",categoryId));
                 this.categoryRepository.delete(categoryEntity);
    }
}

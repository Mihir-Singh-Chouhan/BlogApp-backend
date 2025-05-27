package com.company.demo.controllers;

import com.company.demo.dto.request.CategoryRequest;
import com.company.demo.dto.response.ApiResponse;
import com.company.demo.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<CategoryRequest> createCategory(@Valid @RequestBody CategoryRequest categoryRequest){
       CategoryRequest createCategory = this.categoryService.createCategory(categoryRequest);
       return new ResponseEntity<CategoryRequest>(createCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryRequest> updateCategory(@Valid @RequestBody CategoryRequest categoryRequest, @PathVariable Integer categoryId){
        CategoryRequest updateCategory = this.categoryService.updateCategory(categoryRequest,categoryId);
        return new ResponseEntity<CategoryRequest>(updateCategory,HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted Successfully",true),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryRequest>> getAllCategory(){
       return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryRequest> getUserById(@PathVariable Integer categoryId){
        CategoryRequest getUserById = this.categoryService.getCategoryById(categoryId);
        return new ResponseEntity<CategoryRequest>(getUserById,HttpStatus.OK);
    }

}

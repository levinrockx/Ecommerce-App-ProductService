package com.ecommerce.productsservice.controllers;

import com.ecommerce.productsservice.dtos.ResponseDto;
import com.ecommerce.productsservice.exceptions.CategoryNotFoundException;
import com.ecommerce.productsservice.models.Category;
import com.ecommerce.productsservice.models.ResponseMessage;
import com.ecommerce.productsservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @PostMapping
    public ResponseDto<Object> addCategory(@RequestBody Category category){
        return ResponseDto.builder()
                .success(true)
                .message(ResponseMessage.success)
                .data(categoryService.addCategory(category))
                .build();
    }
    @GetMapping("/{id}")
    public ResponseDto<Object> getCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        return  ResponseDto.builder()
                .success(true)
                .message(ResponseMessage.success)
                .data(categoryService.getCategoryById(id))
                .build();
    }
    @GetMapping
    public ResponseDto<Object> getAllCategories(){
        return  ResponseDto.builder()
                .success(true)
                .message(ResponseMessage.success)
                .data(categoryService.getAllCategories())
                .build();
    }
}

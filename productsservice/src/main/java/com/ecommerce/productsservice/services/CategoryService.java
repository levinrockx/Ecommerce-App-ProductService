package com.ecommerce.productsservice.services;

import com.ecommerce.productsservice.exceptions.CategoryNotFoundException;
import com.ecommerce.productsservice.models.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long id) throws CategoryNotFoundException;
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategoryById(Long id, Category category);
    Category deleteCategoryById(Long id);
}

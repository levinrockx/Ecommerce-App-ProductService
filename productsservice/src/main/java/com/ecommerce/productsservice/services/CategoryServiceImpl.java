package com.ecommerce.productsservice.services;

import com.ecommerce.productsservice.exceptions.CategoryNotFoundException;
import com.ecommerce.productsservice.models.Category;
import com.ecommerce.productsservice.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepo categoryRepo;
    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }
    @Override
    public Category getCategoryById(Long id) throws CategoryNotFoundException {
        return this.categoryRepo.findById(id).orElseThrow(()-> new CategoryNotFoundException(
                "Catergory with id:" + id +", is not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Category addCategory(Category category) {
        return null;
    }

    @Override
    public Category updateCategoryById(Long id, Category category) {
        return null;
    }

    @Override
    public Category deleteCategoryById(Long id) {
        return null;
    }
}

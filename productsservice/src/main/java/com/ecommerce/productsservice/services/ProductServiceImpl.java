package com.ecommerce.productsservice.services;

import com.ecommerce.productsservice.exceptions.CategoryNotFoundException;
import com.ecommerce.productsservice.exceptions.ProductNotFoundException;
import com.ecommerce.productsservice.models.Category;
import com.ecommerce.productsservice.models.Product;
import com.ecommerce.productsservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private CategoryService categoryService;
    private ProductRepo productRepo;
    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, CategoryService categoryService){
        this.categoryService = categoryService;
        this.productRepo = productRepo;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException{
        Optional<Product> product = productRepo.findById(id);
        return product.orElseThrow(()-> new ProductNotFoundException("Product with id: " + id + ", is not found."));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product deleteProductById(Long id) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProductById(Long id, Product product) {
        return null;
    }

    @Override
    public Category getCategoryById(Long id) throws CategoryNotFoundException {
        return this.categoryService.getCategoryById(id);
    }
}

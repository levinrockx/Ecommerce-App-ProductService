package com.ecommerce.productsservice.services;

import com.ecommerce.productsservice.dtos.ProductResponseDto;
import com.ecommerce.productsservice.exceptions.CategoryNotFoundException;
import com.ecommerce.productsservice.exceptions.ProductNotFoundException;
import com.ecommerce.productsservice.models.Category;
import com.ecommerce.productsservice.models.Product;

import java.util.List;

public interface ProductService {
    ProductResponseDto getProductById(Long id) throws ProductNotFoundException;
    List<ProductResponseDto> getAllProducts();
    Product deleteProductById(Long id);
    Product addProduct(Product product);
    Product updateProductById(Long id, Product product);
    Category getCategoryById(Long id) throws CategoryNotFoundException;
}

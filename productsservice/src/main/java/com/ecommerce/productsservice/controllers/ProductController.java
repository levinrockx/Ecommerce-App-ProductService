package com.ecommerce.productsservice.controllers;

import com.ecommerce.productsservice.dtos.ResponseDto;
import com.ecommerce.productsservice.exceptions.ProductNotFoundException;
import com.ecommerce.productsservice.models.Product;
import com.ecommerce.productsservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public ResponseDto<Object> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product p = productService.getProductById(id);
        ResponseDto<Object> response = ResponseDto.builder().data(p).message("success").success(true).build();
        return response;
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

}

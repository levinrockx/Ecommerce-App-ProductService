package com.ecommerce.productsservice.controllers;

import com.ecommerce.productsservice.dtos.AddProductRequestDto;
import com.ecommerce.productsservice.dtos.ResponseDto;
import com.ecommerce.productsservice.exceptions.CategoryNotFoundException;
import com.ecommerce.productsservice.exceptions.ProductNotFoundException;
import com.ecommerce.productsservice.models.Category;
import com.ecommerce.productsservice.models.Product;
import com.ecommerce.productsservice.models.ResponseMessage;
import com.ecommerce.productsservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        return ResponseDto.builder()
                .data(productService.getProductById(id))
                .message(ResponseMessage.success)
                .success(true)
                .build();
    }
    @GetMapping
    public ResponseDto<Object> getAllProducts(){
        return ResponseDto.builder()
                .data(productService.getAllProducts())
                .message(ResponseMessage.success)
                .success(true)
                .build();
    }
    @PostMapping
    public ResponseDto<Object> addProduct(@RequestBody AddProductRequestDto addProductDto)
            throws CategoryNotFoundException{
        Product product = getProductFromAddProductDto(addProductDto);
        return ResponseDto.builder()
                .data(productService.addProduct(product))
                .message(ResponseMessage.success)
                .success(true)
                .build();
    }
    public Product getProductFromAddProductDto(AddProductRequestDto dto) throws CategoryNotFoundException {
        Product product = new Product();
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setRating(dto.getRating());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        Category category = this.productService.getCategoryById(dto.getCategoryId());
        product.setCategory(category);
        return product;
    }
}

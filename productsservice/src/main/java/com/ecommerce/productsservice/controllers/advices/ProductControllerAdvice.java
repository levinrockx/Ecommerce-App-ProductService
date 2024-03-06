package com.ecommerce.productsservice.controllers.advices;

import com.ecommerce.productsservice.dtos.ExceptionDto;
import com.ecommerce.productsservice.exceptions.CategoryNotFoundException;
import com.ecommerce.productsservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException e){
        ExceptionDto dto = ExceptionDto.builder().success(false).message(e.getMessage()).data(null).build();
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
        return response;
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleCategoryNotFoundException(CategoryNotFoundException e){
        ExceptionDto dto = ExceptionDto.builder().success(false).message(e.getMessage()).data(null).build();
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        return response;
    }

}

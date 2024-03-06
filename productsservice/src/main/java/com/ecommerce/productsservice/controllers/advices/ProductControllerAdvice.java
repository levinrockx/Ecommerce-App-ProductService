package com.ecommerce.productsservice.controllers.advices;

import com.ecommerce.productsservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e){
        ResponseEntity<String> response = new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        return response;
    }
}

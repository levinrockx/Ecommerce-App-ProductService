package com.ecommerce.productsservice.exceptions;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(String message){
        super(message);
    }
}

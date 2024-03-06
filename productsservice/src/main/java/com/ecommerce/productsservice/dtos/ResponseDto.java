package com.ecommerce.productsservice.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDto <T>{
    private T data;
    private String message;
    private boolean success;
}

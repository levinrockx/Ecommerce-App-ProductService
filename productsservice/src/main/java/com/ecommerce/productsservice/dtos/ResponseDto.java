package com.ecommerce.productsservice.dtos;

import com.ecommerce.productsservice.models.ResponseMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDto <T>{
    private T data;
    private ResponseMessage message;
    private boolean success;
}

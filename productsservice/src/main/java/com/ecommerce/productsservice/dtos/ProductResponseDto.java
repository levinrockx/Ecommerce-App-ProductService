package com.ecommerce.productsservice.dtos;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private Long price;
    private Long categoryId;
    private int quantity;
    private int rating;
}

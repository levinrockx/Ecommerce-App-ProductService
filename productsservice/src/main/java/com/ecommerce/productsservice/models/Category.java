package com.ecommerce.productsservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
//    @OneToMany(fetch = FetchType.EAGER,mappedBy = "category")
//    private List<Product> products;
}

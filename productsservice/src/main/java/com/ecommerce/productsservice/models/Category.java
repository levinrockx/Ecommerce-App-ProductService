package com.ecommerce.productsservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    public String name;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "category")
    List<Product> products;
}

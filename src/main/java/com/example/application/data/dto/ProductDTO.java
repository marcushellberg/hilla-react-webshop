package com.example.application.data.dto;

import com.example.application.data.entity.Product;

import javax.annotation.Nonnull;
import javax.validation.constraints.Size;

public class ProductDTO extends AbstractDTO {
    @Nonnull
    @Size(min = 1, max = 140)
    private String name;

    private String description;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.setId(product.getId());
        this.name = product.getName();
        this.description = product.getDescription();
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public void setName(@Nonnull String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product toProduct() {
        var product = new Product();
        product.setDescription(description);
        product.setName(name);
        return product;
    }
}
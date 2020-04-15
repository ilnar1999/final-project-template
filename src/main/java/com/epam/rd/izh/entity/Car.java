package com.epam.rd.izh.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Car {

    private Long id;
    private String brand;
    private String model;
    private BigDecimal price;
    private Category category;
    private byte[] image;

    public Car id(Long id) {
        this.setId(id);
        return this;
    }

    public Car brand(String brand) {
        this.setBrand(brand);
        return this;
    }

    public Car model(String model) {
        this.setModel(model);
        return this;
    }

    public Car price(BigDecimal price) {
        this.setPrice(price);
        return this;
    }

    public Car category(Category category) {
        this.setCategory(category);
        return this;
    }

    public Car image(byte[] image) {
        this.setImage(image);
        return this;
    }
}
